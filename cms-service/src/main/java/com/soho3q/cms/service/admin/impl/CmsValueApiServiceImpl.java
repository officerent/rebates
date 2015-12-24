package com.soho3q.cms.service.admin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soho3q.cms.dal.dao.CmsChannelMapper;
import com.soho3q.cms.dal.dao.CmsKeyMapper;
import com.soho3q.cms.dal.dao.CmsValueMapper;
import com.soho3q.cms.dal.dataobj.CmsChannel;
import com.soho3q.cms.dal.dataobj.CmsChannelExample;
import com.soho3q.cms.dal.dataobj.CmsKey;
import com.soho3q.cms.dal.dataobj.CmsKeyExample;
import com.soho3q.cms.dal.dataobj.CmsValue;
import com.soho3q.cms.dal.dataobj.CmsValueExample;
import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.model.admin.CmsValueModel;
import com.soho3q.cms.model.common.Constant;
import com.soho3q.cms.service.admin.CmsValueApiService;
import com.soho3q.web.utils.LogicUtil;

@Service
public class CmsValueApiServiceImpl implements CmsValueApiService {

	private Logger logger=Logger.getLogger(CmsValueApiServiceImpl.class);
	
	@Autowired
	private CmsChannelMapper cmsChannelMapper;
	
	@Autowired
	private CmsKeyMapper cmsKeyMapper;
	
	@Autowired
	private CmsValueMapper cmsValueMapper;
	/**
	 * 获取cms-channel
	 */
	@Override
	public List<CmsChannelModel> getCmsChannel() {
		logger.info("查询所有频道");
		List<CmsChannel> channelList=this.cmsChannelMapper.selectByExample(new CmsChannelExample());
		if(LogicUtil.isNotNullAndEmpty(channelList)){
			return setChanneltoModelList(channelList);
		}
		return null;
	}

	/**
	 * 获取cms-key
	 */
	@Override
	public List<CmsKey> getCmsKey(String channel_name) {
		logger.info("查询频道channel_name： "+channel_name+" 中所有的key");
		CmsKeyExample example=new CmsKeyExample();
		CmsKeyExample.Criteria criteria=example.createCriteria();
		criteria.andChannelNameEqualTo(channel_name);
		//获取key状态为正常的值
		criteria.andEnabledEqualTo(Constant.KEY_DISABLED_AVAILABLE);
		List<CmsKey> cmsKeyList=this.cmsKeyMapper.selectByExample(example);
		return cmsKeyList;
	}

	
	@Override
	public List<CmsValueModel> getCmsValueList(String channel_name, String cms_key) {
		logger.info("查询频道channel_name： "+channel_name+" ,关键值key："+cms_key+" 中所有value");
		List<CmsValueModel> cmsValueModelList=new ArrayList<CmsValueModel>();
		CmsValueExample ee=new CmsValueExample();
		CmsValueExample.Criteria criteria=ee.createCriteria();
		criteria.andChannelNameEqualTo(channel_name);
		criteria.andCmsKeyEqualTo(cms_key);
		//获取value为正常的值
		criteria.andEnabledEqualTo(Constant.C_VALUE_NORMAL);
		List<CmsValue> cmsValueList=this.cmsValueMapper.selectByExample(ee);
		if(cmsValueList!=null && cmsValueList.size()>0){
			for (CmsValue cmsValue : cmsValueList) {
				cmsValueModelList.add(setToCmsValueModel(cmsValue));
			}
		}else{
			logger.info("根据 channel_name:"+channel_name+", cms_key"+cms_key+"，在cms-value中  未找到相应的数据");
		}
		return cmsValueModelList;
	}

	@Override
	public List<CmsValueModel> getCmsValueList(String channel_name,String cms_keys,
			String language,String isApp,String useragent,String business_id){
		logger.info("查询频道channel_name： "+channel_name+" ,关键值key："+cms_keys+" ,业务id business_ids："+business_id+
				" ,语言language:"+language+" ,isApp:"+isApp+", useragent+"+useragent+" 中的value");
		List<CmsValueModel> cmsValueModelList=new ArrayList<CmsValueModel>();
		String cmsKeys[]=cms_keys.split(",");
		for (int i = 0; i < cmsKeys.length; i++) {
			CmsValueModel cmsValueModel=getCmsValue(channel_name,cmsKeys[i],language,isApp,useragent,business_id);
			cmsValueModelList.add(cmsValueModel);
		}
		return cmsValueModelList;
	}
	
	@Override
	public CmsValueModel getCmsValue(String channel_name,String cms_key,
			String language,String isApp,String useragent,String business_id){
		
		logger.info("查询频道channel_name： "+channel_name+" ,关键值key："+cms_key+" ,业务id business_id："+business_id+
				" ,语言language:"+language+" ,isApp:"+isApp+", useragent:"+useragent+",中的value");
		CmsKeyExample cmsKeyExample=new CmsKeyExample();
		CmsKeyExample.Criteria keyCriteria=cmsKeyExample.createCriteria();
		keyCriteria.andChannelNameEqualTo(channel_name);
		keyCriteria.andCmsKeyEqualTo(cms_key);
		keyCriteria.andEnabledEqualTo(Constant.KEY_DISABLED_AVAILABLE);
		List<CmsKey> cmsKeyList=this.cmsKeyMapper.selectByExample(cmsKeyExample);
		if(cmsKeyList!=null && cmsKeyList.size()>0){
			if(cmsKeyList.size()>1){
				logger.error("sql data  cms-key error! channel:"+channel_name+", cms_key"+cms_key+" repetition");
			}else{
				CmsKey cmsKey=cmsKeyList.get(0);
				if(cmsKey.getEnabled()!=Constant.KEY_DISABLED_AVAILABLE){
					logger.info("channel_name:"+channel_name+",cms_key"+cms_key+"，是--失效的状态");
					return new CmsValueModel();
				}
			}
		}else{
			logger.info("channel_name:"+channel_name+",cms_key"+cms_key+"，没有查询到，或者说是--失效的状态");
			return new CmsValueModel();
		}
		
		CmsValueExample ee=new CmsValueExample();
		CmsValueExample.Criteria criteria=ee.createCriteria();
		//获取value为正常的值
		criteria.andEnabledEqualTo(Constant.C_VALUE_NORMAL);
		criteria.andChannelNameEqualTo(channel_name);
		criteria.andCmsKeyEqualTo(cms_key);

//		if(business_id!=null && !"".equalsIgnoreCase(business_id)){
//			if(!Constant.WILDCARD.equalsIgnoreCase(business_id)){
//				logger.info("business_id 不为空并且不是*，所以查询数据库的时候加入business_id是"+business_id+"或者通配符*的结果!");
//				criteria.andBusinessIdEqualTo(Constant.WILDCARD);
//				CmsValueExample.Criteria criteria1=ee.createCriteria();
//				criteria1.andEnabledEqualTo(Constant.C_VALUE_NORMAL);
//				criteria1.andChannelNameEqualTo(channel_name);
//				criteria1.andCmsKeyEqualTo(cms_key);
//				criteria1.andBusinessIdEqualTo(business_id);
//				ee.or(criteria1);
//			}else{
//				logger.info("business_id 不为空并且是*，所以查询数据库的时候加入business_id是 通配符"+business_id+"的结果!");
//				criteria.andBusinessIdEqualTo(Constant.WILDCARD);
//			}
//			
//		}
//		if(Constant.ISAPP.equalsIgnoreCase(isApp)){
//			logger.info("client是app所以查询数据库的时候加入client是app或者通配符*的结果!");
//			criteria.andClientEqualTo(Constant.WILDCARD);
//			CmsValueExample.Criteria criteria1=ee.createCriteria();
//			criteria1.andClientEqualTo(Constant.CLIENT_APP);
//			ee.or(criteria1);
//		}
		ee.setOrderByClause("business_id desc,os desc,client desc,language desc");
		List<CmsValue> cmsValueList=this.cmsValueMapper.selectByExample(ee);
		if(cmsValueList==null || cmsValueList.size()<=0){
			logger.info("channel_name:"+channel_name+",cms_key"+cms_key+" 没有查询到c-value值");
			return new CmsValueModel();
		}
		return matching(cmsValueList,isApp,useragent,language,business_id);
	}
	
	
	
	
	//匹配算法
	private CmsValueModel matching(List<CmsValue> cmsValueList,String isApp,String useragent,String language,String business_id){
		logger.info("查询的初始值,对cmsValue的通配符数量经行升序排数");
		List<RankingCmsValue> rankingCmsValueList=rankCmsValue(cmsValueList);
		String os=analysisUseragentGetOs(useragent);
		String client="*";
		if(Constant.ISAPP.equalsIgnoreCase(isApp)){
			logger.info("isApp is  Y ,client is APP");
			client=Constant.CLIENT_APP;
		}else{
			 client=analysisUseragentGetClient(useragent);
		}
		logger.info("解析当前终端是："+os+"  ,*表示没有解析出来对应的操作系统,或者说是传入的useragent为*");
		return matchIngCmsValue(rankingCmsValueList,language,client,os,business_id);
	}
	
	//根据通配符*数量 将cmsValue  升序排序,通配符数量越多，list中越靠后
	private List<RankingCmsValue> rankCmsValue(List<CmsValue> cmsValueList){
		List<RankingCmsValue> rankingCmsValueLsit=new ArrayList<RankingCmsValue>();
		for(CmsValue msValue:cmsValueList){
			RankingCmsValue rankingCmsValue=setCmsValueToRankingCmsValue(msValue);
			int wildcardNum=0;
			if(Constant.WILDCARD.equalsIgnoreCase(msValue.getLanguage())){
				wildcardNum +=1;
			}
			if(Constant.WILDCARD.equalsIgnoreCase(msValue.getClient())){
				wildcardNum +=1;
			}
			if(Constant.WILDCARD.equalsIgnoreCase(msValue.getOs())){
				wildcardNum +=1;
			}
			if(Constant.WILDCARD.equalsIgnoreCase(msValue.getBusinessId())){
				wildcardNum +=1;
			}
			rankingCmsValue.setRank(wildcardNum);
			rankingCmsValueLsit.add(rankingCmsValue);
		}
		//list排序
		Collections.sort(rankingCmsValueLsit,new Comparator<RankingCmsValue>(){  
            public int compare(RankingCmsValue arg0, RankingCmsValue arg1) { 
                return arg0.getRank().compareTo(arg1.getRank());  
            }  
        });
		for (RankingCmsValue rankingCmsValue:rankingCmsValueLsit) {
			logger.info("businessId:"+rankingCmsValue.getBusinessId()+" --  Os:"+rankingCmsValue.getOs()+"  --  Client:"+rankingCmsValue.getClient()+"  --  Language:"+rankingCmsValue.getLanguage()+",通配符*的数量:"+rankingCmsValue.getRank());
		}
		return rankingCmsValueLsit;
	}
	
	//****获取匹配到的值--依次按字段（语言、终端、设备）最优匹配出一条记录 *******
	private CmsValueModel matchIngCmsValue(List<RankingCmsValue> rankingCmsValueList,String language,String client,String os,String business_id){
		logger.info("查找排序后的值----- 取 语言："+language+", 渠道client:"+client+", 操作系统os:"+os +", 业务ID:"+business_id+" 的最优匹配");
		CmsValueModel cmsValueModel=new CmsValueModel();
		if(rankingCmsValueList!=null && rankingCmsValueList.size()>0){
			if(language==null || "".equalsIgnoreCase(language) ){
				language=Constant.WILDCARD;
			}
			if(client==null || "".equalsIgnoreCase(client) ){
				client=Constant.WILDCARD;
			}
			if(os==null || "".equalsIgnoreCase(os)  ){
				os=Constant.WILDCARD;
			}
			for (RankingCmsValue rankingCmsValue : rankingCmsValueList) {
				/**
				 * 因为是升序方式排序，所以按照语言、终端、设备  依次对比。
				 * 语言参数与数据库相同，或者数据中是通配符
				 * 并且
				 * 客户端参数与数据库相同，或者数据库中是通配符
				 * 并且
				 * 操作系统参数与数据库相同，或者数据库中是通配符
				 * 
				 * 按照os  client language 对比
				 */
				if(business_id.equalsIgnoreCase(rankingCmsValue.getBusinessId()) || "*".equalsIgnoreCase(rankingCmsValue.getBusinessId()) ){
					if(os.equalsIgnoreCase(rankingCmsValue.getOs()) || "*".equalsIgnoreCase(rankingCmsValue.getOs()) ){
						if(client.equalsIgnoreCase(rankingCmsValue.getClient()) || "*".equalsIgnoreCase(rankingCmsValue.getClient())){
							if(language.equalsIgnoreCase(rankingCmsValue.getLanguage()) || "*".equalsIgnoreCase(rankingCmsValue.getLanguage())){
//								logger.info("匹配的结果："+JSONObject.toJSONString(rankingCmsValue));
								logger.info("匹配的结果:business_id:"+rankingCmsValue.getBusinessId()+
										" -- os:"+rankingCmsValue.getOs()+
										" -- client:"+rankingCmsValue.getClient()+
										" -- language:"+rankingCmsValue.getLanguage());
								return setRankingCmsValueToCmsValueModel(rankingCmsValue);
							}else{
								logger.info("匹配的结果:language不匹配,param-language:"+language+",data-language:"+rankingCmsValue.getLanguage());
							}
						}else{
							logger.info("匹配的结果:client不匹配,param-client:"+client+",data-client:"+rankingCmsValue.getClient());
						}
					}else{
						logger.info("匹配的结果:os不匹配,param-os:"+os+",data-os:"+rankingCmsValue.getOs());
					}
				}else{
					logger.info("匹配的结果:business_id不匹配,param-business_id:"+business_id+",data-business_id:"+rankingCmsValue.getBusinessId());
				}
				
			}
		}
		return cmsValueModel;
	}
	
	//解析applicationType-----获取os 
	private String analysisUseragentGetOs(String useragent){
		logger.info("前台传入useragent:"+useragent);
		String returnValue="*";
		if(useragent==null || "".equalsIgnoreCase(useragent)){
			logger.info("useragent 为 null 或者为 '' 时，返回 *");
			return Constant.WILDCARD;
		}
		if( useragent.indexOf("Mac")>-1 && useragent.indexOf("iPhone")>-1){//ios终端 --手机
			logger.info("useragent 包含 Mac 并且  iPhone  时，返回  IOS");
			returnValue=Constant.OS_IOS;
		}else if((useragent.indexOf("Android") > -1 || useragent.indexOf("Linux") > -1) && useragent.indexOf("Mobile")>-1){//android终端或者uc浏览器，去除pad
			logger.info("useragent 包含 Android 或者  Linux 或者 Mobile  时，返回  Android");
			returnValue=Constant.OS_ANDRIOD;
		}else if(useragent.indexOf("Mac") > -1){//Mac---苹果电脑
			logger.info("useragent 仅包含 Mac 时，返回  Mac");
			returnValue=Constant.OS_MAC;
		}else if(useragent.indexOf("Windows")>-1){//Windows
			logger.info("useragent 仅包含 Windows 时，返回  Windows");
			returnValue=Constant.OS_WINDOWS;
		}
		return returnValue;
	}
	//解析applicationType-----获取client 
	private String analysisUseragentGetClient(String useragent){
		logger.info("前台传入useragent:"+useragent);
		String returnValue="*";
		if(useragent==null || "".equalsIgnoreCase(useragent)){
			logger.info("useragent 为 null 或者为 '' 时，返回 *");
			return Constant.WILDCARD;
		}
		if(useragent.indexOf("MicroMessenger") > -1 ){//webChart--微信
			logger.info("useragent 包含  MicroMessenger  时，返回  WeChat-微信");
			returnValue=Constant.CLIENT_WECHAT;
		}else if(  useragent.indexOf("iPhone")>-1  || useragent.indexOf("Android") > -1 || useragent.indexOf("Linux") > -1 || useragent.indexOf("Mobile")>-1 ){//手机-H5
			logger.info("useragent 包含 iPhone 或者  Android 或者  Linux 或者 Mobile 时，返回  H5 -移动端");
			returnValue=Constant.CLIENT_H5;
		}else{//pc端---web
			logger.info("useragent 不 包含 MicroMessenger,iPhone,Android,Linux,Mobile 时，返回  Web-PC端");
			returnValue=Constant.CLIENT_WEB;
		}
		return returnValue;
	}
	
	
	/**
	 * 排名CmsValue
	 * @author pangweidong
	 *
	 */
	class RankingCmsValue extends CmsValue{
		private  Integer rank;

		public Integer getRank() {
			return rank;
		}

		public void setRank(Integer rank) {
			this.rank = rank;
		}
	}
	
	//********************************cms-channel转换成CmsChannelModel开始************************************************//
	public ArrayList<CmsChannelModel> setChanneltoModelList(List<CmsChannel> channelList){
		ArrayList<CmsChannelModel>  modelList = new ArrayList<CmsChannelModel>();
		for(CmsChannel item:channelList){
			modelList.add(setChanneltoModel(item));
		}
		return modelList;
	}
	
	public CmsChannelModel setChanneltoModel(CmsChannel channel){
		CmsChannelModel model = new CmsChannelModel();
		model.setChannelId(channel.getChannelId());
		model.setCreator(channel.getCreator());
		model.setName(channel.getName());
		model.setDescription(channel.getDescription());
		model.setStatus(channel.getStatus());
		model.setUpdater(channel.getUpdater());
		model.setCreateTime(channel.getCreateTime());
		model.setLastUpdateTime(channel.getLastUpdateTime());
		return model;
	}
	//********************************cms-channel转换成CmsChannelModel结束************************************************//
	
	//********************************cms-value转换成CmsValueModel开始*********************************************//
	/**
	 * cmsvalue to CmsValueModel
	 * @param cmsValue
	 * @return CmsValueModel
	 */
	private CmsValueModel setToCmsValueModel(CmsValue cmsValue){
		CmsValueModel cmsValueModel=new CmsValueModel();
		cmsValueModel.setBusinessId(cmsValue.getBusinessId());
		cmsValueModel.setChannelName(cmsValue.getChannelName());
		cmsValueModel.setClient(cmsValue.getClient());
		cmsValueModel.setCmsKey(cmsValue.getCmsKey());
		cmsValueModel.setCmsValue(cmsValue.getCmsValue());
		cmsValueModel.setCreateTime(cmsValue.getCreateTime());
		cmsValueModel.setCreator(cmsValue.getCreator());
		cmsValueModel.setEnabled(cmsValue.getEnabled());
		cmsValueModel.setLanguage(cmsValue.getLanguage());
		cmsValueModel.setLastUpdateTime(cmsValue.getLastUpdateTime());
		cmsValueModel.setOs(cmsValue.getOs());
		cmsValueModel.setUpdater(cmsValue.getUpdater());
		cmsValueModel.setValueId(cmsValue.getValueId());
		return cmsValueModel;
	}
	//********************************cms-value转换成CmsValueModel结束*********************************************//
	
	
	//将cmsValue 转换成 RankingCmsValue
	private RankingCmsValue setCmsValueToRankingCmsValue(CmsValue cmsValue){
		RankingCmsValue rankingCmsValue=new RankingCmsValue();
		rankingCmsValue.setBusinessId(cmsValue.getBusinessId());
		rankingCmsValue.setChannelName(cmsValue.getChannelName());
		rankingCmsValue.setClient(cmsValue.getClient());
		rankingCmsValue.setCmsKey(cmsValue.getCmsKey());
		rankingCmsValue.setCmsValue(cmsValue.getCmsValue());
		rankingCmsValue.setCreateTime(cmsValue.getCreateTime());
		rankingCmsValue.setCreator(cmsValue.getCreator());
		rankingCmsValue.setEnabled(cmsValue.getEnabled());
		rankingCmsValue.setLanguage(cmsValue.getLanguage());
		rankingCmsValue.setLastUpdateTime(cmsValue.getLastUpdateTime());
		rankingCmsValue.setOs(cmsValue.getOs());
		rankingCmsValue.setUpdater(cmsValue.getUpdater());
		rankingCmsValue.setValueId(cmsValue.getValueId());
		return rankingCmsValue;
	}
	
	//将RankingCmsValue 转换成 CmsValueModel
	private CmsValueModel setRankingCmsValueToCmsValueModel(RankingCmsValue rankingCmsValue){
		CmsValueModel cmsValue=new CmsValueModel();
		cmsValue.setBusinessId(rankingCmsValue.getBusinessId());
		cmsValue.setChannelName(rankingCmsValue.getChannelName());
		cmsValue.setClient(rankingCmsValue.getClient());
		cmsValue.setCmsKey(rankingCmsValue.getCmsKey());
		cmsValue.setCmsValue(rankingCmsValue.getCmsValue());
		cmsValue.setCreateTime(rankingCmsValue.getCreateTime());
		cmsValue.setCreator(rankingCmsValue.getCreator());
		cmsValue.setEnabled(rankingCmsValue.getEnabled());
		cmsValue.setLanguage(rankingCmsValue.getLanguage());
		cmsValue.setLastUpdateTime(rankingCmsValue.getLastUpdateTime());
		cmsValue.setOs(rankingCmsValue.getOs());
		cmsValue.setUpdater(rankingCmsValue.getUpdater());
		cmsValue.setValueId(rankingCmsValue.getValueId());
		return cmsValue;
	}
}
