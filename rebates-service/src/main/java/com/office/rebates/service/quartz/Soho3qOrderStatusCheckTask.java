package com.office.rebates.service.quartz;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import com.office.rebates.dal.dao.SalesPeopleMapper;
import com.office.rebates.dal.dataobj.SalesPeople;
import com.office.rebates.dal.dataobj.SalesPeopleExample;

@Transactional(value = "rebatesTransactionManager", rollbackFor = Exception.class)
public class Soho3qOrderStatusCheckTask {
	
	@Autowired
	private SalesPeopleMapper salesPeopleMapper;
		
	
	
	static Logger logger = LoggerFactory.getLogger(Soho3qOrderStatusCheckTask.class);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM"); 
	
	public void doWork() {		
		logger.info("start to check soho3q order status...");	
		
		//获得所有的销售信息
		SalesPeopleExample example=new SalesPeopleExample();
		List<SalesPeople> sales=salesPeopleMapper.selectByExample(example);
		
		for(SalesPeople people:sales){
			logger.info("checking soho3q order status for sales:"+people.getUserName());
			List<Order> orders=getOrderBySales(people);
		}
		
		Date lastMonth = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lastMonth);		
		calendar.add(Calendar.MONTH, -1);
		lastMonth = calendar.getTime();	
		
		String lastMonthStr=sdf.format(lastMonth);
		logger.info("last month is:" +lastMonthStr+", start to calculate company bonus...");
		try{	
			generateCompanyBonus(lastMonthStr);
			
			//补9月数据，下次上线需要删掉
			//logger.info("make up date for 2015-09");
			//generateCompanyBonus("2015-09");
		}catch(Exception e){
			logger.error("fail to generate company bonus for month:"+lastMonthStr,e);
		}
	}
	
	public void generateCompanyBonus(String month) throws Exception {
		SalesGlobalLock globalLock=newSalesGlobalLockMapper.lockResource(Constants.LOCK_COMPANY_BONUS);
		if(globalLock!=null){
			logger.info("got the global lock for generating company bonus.");
		}else{//没有拿到lock,说明其他实例已经hold lock并且正在执行该方法，则不执行该方法
			logger.info("other instance is holding the lock and generating the company bonus, quit the method.");
			return;
		}
		Date start=sdf.parse(month);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);	
		calendar.add(Calendar.MONTH, 1);
		Date end=calendar.getTime();
		
		//get all the company sales
		SalesPeopleExample peopleExample=new SalesPeopleExample();
		peopleExample.createCriteria().andSalesTypeEqualTo(Constants.SALES_TYPE_COMPANY);
		List<SalesPeople> companies= salesPeopleMapper.selectByExample(peopleExample);
		logger.info("all the company sales are:"+JSON.toJSONString(companies));
		
		//为每个机构计算该月的佣金
		if(companies!=null&&!companies.isEmpty()){
			for(SalesPeople company:companies){
				logger.info("processing company bonus for :"+JSON.toJSONString(company));
				//查看该机构的的该月佣金请求是否已经产生
				SalesBonusRequestExample bonusRequestExample=new SalesBonusRequestExample();
				bonusRequestExample.createCriteria().andSalesIdEqualTo(company.getSalesId()).andBillMonthEqualTo(month).andIsCompanyEqualTo(Constants.IS_COMPANY_BONUS);
				List<SalesBonusRequest> bonusRequestList=salesBonusRequestMapper.selectByExample(bonusRequestExample);
				if(bonusRequestList!=null&&!bonusRequestList.isEmpty()){//已经产生了,不再重复产生
					logger.info("found existing bonus for company sales:"+company.getSalesId()+" for month:"+month+":"+JSON.toJSONString(bonusRequestList));
				}else{//该机构没有产生该月佣金
					//查找该机构所有该月的佣金
					SalesBonusExample bonusExample=new SalesBonusExample();
					List<Byte> statusCondition=Arrays.asList(Constants.BONUS_STATUS_AVAILABLE,Constants.BONUS_STATUS_REQUESTING);
					bonusExample.createCriteria().andSalesIdEqualTo(company.getSalesId()).andCreateTimeBetween(start, end).andStatusIn(statusCondition);
					List<SalesBonus> bonusList=salesBonusMapper.selectByExample(bonusExample);
					logger.info("all the bonus for company sales:"+company.getSalesId()+" for month:"+month+" are:"+JSON.toJSONString(bonusList));
					if(bonusList!=null&&!bonusList.isEmpty()){//该月有佣金
						Long requestId=salesBonusService.createBonusRedeem(company, bonusList,month);
						logger.info("bonus request for compay:"+company.getSalesId()+" for month:"+month+" has beed created with id:"+requestId);
					}else{//该月无佣金
						logger.info("no bonus found for company sales:"+company.getSalesId()+" for month:"+month);
					}
					
				}
			}
		}
		
	}
	
	
}
