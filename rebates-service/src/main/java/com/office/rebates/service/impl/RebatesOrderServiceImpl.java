package com.office.rebates.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.office.rebates.dal.cache.CacheClient;
import com.office.rebates.dal.dao.NewSalesPeopleMapper;
import com.office.rebates.dal.dao.RebatesOrderItemMapper;
import com.office.rebates.dal.dao.RebatesOrderMapper;
import com.office.rebates.dal.dao.SalesPeopleMapper;
import com.office.rebates.dal.dataobj.RebatesOrder;
import com.office.rebates.dal.dataobj.RebatesOrderItem;
import com.office.rebates.dal.dataobj.SalesPeople;
import com.office.rebates.dal.dataobj.SalesPeopleExample;
import com.office.rebates.dal.rest.Soho3qCheckOrderApi;
import com.office.rebates.dal.rest.Soho3qCreateOrderApi;
import com.office.rebates.model.OrderItem;
import com.office.rebates.model.Soho3qOrder;
import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.Messages;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.model.request.CreateOrderRequest;
import com.office.rebates.service.RebatesOrderService;
import com.office.rebates.util.DateUtil;


@Service
@Transactional(value = "rebatesTransactionManager", rollbackFor = Exception.class)
public class RebatesOrderServiceImpl implements RebatesOrderService{

	static Logger logger = LoggerFactory.getLogger(RebatesOrderServiceImpl.class);
	
    @Autowired
    private RebatesOrderMapper rebatesOrderMapper;
    
    @Autowired
    private RebatesOrderItemMapper rebatesOrderItemMapper;
    
    @Autowired
    private SalesPeopleMapper salesPeopleMapper;
    
	@Autowired
	private Soho3qCreateOrderApi soho3qCreateOrderApi;
	
	@Autowired
	private NewSalesPeopleMapper newSalesPeopleMapper;
	
	@Override
	public Long createRebatesOrder(CreateOrderRequest request, UserInfo userInfo) throws RebatesException {
		//select a sales people to place to soho3q order
		Date now=new Date();
		SalesPeople people=getSalesPeople();
		logger.info("got sales people to place order:"+JSON.toJSONString(people));
		
		//lock the sales people,确保一个销售不能同时下两个订单
		newSalesPeopleMapper.getAndLockSalesPeople(people.getSalesId());
		
		//place order to soho3q
		Long soho3qOrderId=soho3qCreateOrderApi.createSoho3qOrder(request,people);
		logger.info("created soho3q order with id:"+soho3qOrderId);
		if(soho3qOrderId==null){
			logger.error("fail to create soho3q order");
			throw new RebatesException(Messages.FAIL_TO_CREATE_SOHO3Q_ORDER_CODE,Messages.FAIL_TO_CREATE_SOHO3Q_ORDER_MSG);
		}
		
		//insert rebates order
		RebatesOrder rebatesOrder=new RebatesOrder();
		rebatesOrder.setCheckinDate(DateUtil.parseDate(request.getCheckInDate(), DateUtil.FORMAT_DEFAULT));
		rebatesOrder.setCheckoutDate(DateUtil.parseDate(request.getCheckOutDate(), DateUtil.FORMAT_DEFAULT));
		rebatesOrder.setCreateTime(now);
		rebatesOrder.setCustomerAlipay(request.getCustomerAlipay());
		rebatesOrder.setCustomerCompany(request.getCustomerCompany());
		rebatesOrder.setCustomerMobile(request.getCustomerMobile());
		rebatesOrder.setCustomerName(request.getCustomerName());
		Double depositAmountCent=request.getDepositAmount()*100;
		rebatesOrder.setDepositAmount(depositAmountCent.intValue());
		rebatesOrder.setLastUpdateTime(now);
		Double leaseAmountCent=request.getLeaseAmount()*100;
		rebatesOrder.setLeaseAmount(leaseAmountCent.intValue());
		rebatesOrder.setPeriodMonth(request.getPeriodMonth());
		rebatesOrder.setPeriodWeek(request.getPeriodWeek());
		rebatesOrder.setPorjectId(request.getProjectId());
		rebatesOrder.setPorjectName(request.getProjectName());
		rebatesOrder.setSalesId(people.getSalesId());
		rebatesOrder.setSoho3qOrderId(soho3qOrderId);
		rebatesOrder.setUserId(userInfo.getUserId());
		rebatesOrderMapper.insert(rebatesOrder);
		logger.info("created soho3q order :"+JSON.toJSONString(rebatesOrder));
		
		//insert rebates order items
		if(request.getOrderItems()!=null&&!request.getOrderItems().isEmpty()){
			for(OrderItem orderItem:request.getOrderItems()){
				RebatesOrderItem rebatesOrderItem=new RebatesOrderItem();
				rebatesOrderItem.setBookNum(orderItem.getBookNum());
				rebatesOrderItem.setCreateTime(now);
				Double depositCent=orderItem.getDepositPrice()*100;
				rebatesOrderItem.setDepositPrice(depositCent.intValue());
				Double finalPriceCent=orderItem.getDepositPrice()*100;
				rebatesOrderItem.setFinalPrice(finalPriceCent.intValue());
				rebatesOrderItem.setLastUpdateTime(now);
				rebatesOrderItem.setOrderId(rebatesOrder.getOrderId());
				Double originalPriceCent=orderItem.getOriginalPrice()*100;
				rebatesOrderItem.setOriginalPrice(originalPriceCent.intValue());
				rebatesOrderItem.setPorjectId(orderItem.getProjectId());
				rebatesOrderItem.setProductSubType(orderItem.getProductSubType());
				rebatesOrderItem.setProductType(orderItem.getProductType());
				Double totalPriceCent=(finalPriceCent+depositCent)*orderItem.getBookNum();
				rebatesOrderItem.setTotalPrice(totalPriceCent.intValue());
				rebatesOrderItemMapper.insert(rebatesOrderItem);
				logger.info("created soho3q order item :"+JSON.toJSONString(rebatesOrderItem));
			}
		}
		return rebatesOrder.getOrderId();

	}

	private SalesPeople getSalesPeople() throws RebatesException {
		SalesPeopleExample salesPeopleExample=new SalesPeopleExample();
		salesPeopleExample.createCriteria();
		List<SalesPeople> salesPeoples=salesPeopleMapper.selectByExample(salesPeopleExample);
		
		if(salesPeoples==null||salesPeoples.size()==0){
			logger.error("no sales people configured");
			throw new RebatesException(Messages.NO_SALES_PEOPLE_FOUND_CODE,Messages.NO_SALES_PEOPLE_FOUND_MSG);
		}
		int size=salesPeoples.size();
		Date now =new Date();
		Long random=now.getTime();
		Long mod=random%size;
		
		int index=mod.intValue();
		return salesPeoples.get(index);
	}



}
