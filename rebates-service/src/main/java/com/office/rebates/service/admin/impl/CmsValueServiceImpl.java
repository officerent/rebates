package com.soho3q.cms.service.admin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soho3q.cms.model.admin.CmsKeyModel;
import com.soho3q.cms.model.admin.CmsValueArrayModel;
import com.soho3q.cms.model.admin.CmsValueModel;
import com.soho3q.cms.model.common.Constant;
import com.soho3q.cms.service.admin.CmsValueApiService;
import com.soho3q.cms.service.admin.CmsValueService;
import com.soho3q.cms.service.admin.impl.CmsValueApiServiceImpl.RankingCmsValue;
import com.soho3q.cms.dal.dao.CmsChannelMapper;
import com.soho3q.cms.dal.dao.CmsKeyMapper;
import com.soho3q.cms.dal.dao.CmsTagMapper;
import com.soho3q.cms.dal.dao.CmsValueHistoryMapper;
import com.soho3q.cms.dal.dao.CmsValueMapper;
import com.soho3q.cms.dal.dao.NewCmsValueHistoryMapper;
import com.soho3q.cms.dal.dataobj.*;


@Service
@Transactional
public class CmsValueServiceImpl implements CmsValueService{

	static Logger logger = Logger.getLogger(CmsValueServiceImpl.class);	
	
	@Autowired
	private CmsChannelMapper cmsChannelMapper;
	
	@Autowired
	private CmsKeyMapper cmsKeyMapper;
	
	@Autowired
	private CmsValueMapper cmsValueMapper;
	
	@Autowired
	private CmsValueHistoryMapper cmsValueHistoryMapper;
	
	@Autowired
	private NewCmsValueHistoryMapper newCmsValueHistoryMapper;
	
	/**
	 * 根据channel_name,cms_key 获取c-key
	 */
	public CmsKeyModel getCmsKey(String channel_name,String cms_key){
		CmsKeyModel cmsKeyModel=new CmsKeyModel();
		
		CmsKeyExample ee=new CmsKeyExample();
		CmsKeyExample.Criteria keyCriteria=ee.createCriteria();
		keyCriteria.andChannelNameEqualTo(channel_name);
		keyCriteria.andCmsKeyEqualTo(cms_key);
//		keyCriteria.andEnabledEqualTo(Constant.KEY_DISABLED_AVAILABLE);
		List<CmsKey> cmsKeyList=this.cmsKeyMapper.selectByExample(ee);
		if(cmsKeyList!=null && cmsKeyList.size()>0){
			if(cmsKeyList.size()>1){
				logger.error("sql data  cms-key error! channel:"+channel_name+", cms_key"+cms_key+" repetition");
			}
			cmsKeyModel=setKeytoModel(cmsKeyList.get(0));
		}else{
			logger.info("根据 channel_name:"+channel_name+", cms_key"+cms_key+"，在cms-key中  未找到相应的数据");
			return cmsKeyModel;
		}
		return cmsKeyModel;
	}
	
	/**
	 * 根据channel_name,cms_key 获取c-value
	 */
	@Override
	public List<CmsValueModel> getCmsValueList(String channel_name,String cms_key) {
		List<CmsValueModel> cmsValueModelList=new ArrayList<CmsValueModel>();
		
//		CmsKeyExample ee=new CmsKeyExample();
//		CmsKeyExample.Criteria keyCriteria=ee.createCriteria();
//		keyCriteria.andChannelNameEqualTo(channel_name);
//		keyCriteria.andCmsKeyEqualTo(cms_key);
//		keyCriteria.andEnabledEqualTo(Constant.KEY_DISABLED_AVAILABLE);
//		List<CmsKey> cmsKeyList=this.cmsKeyMapper.selectByExample(ee);
//		if(cmsKeyList!=null && cmsKeyList.size()>0){
//			if(cmsKeyList.size()>1){
//				logger.error("sql data  cms-key error! channel:"+channel_name+", cms_key"+cms_key+" repetition");
//			}else{
//				CmsKey cmsKey=cmsKeyList.get(0);
//				if(cmsKey.getEnabled()!=Constant.KEY_DISABLED_AVAILABLE){
//					logger.info("channel_name:"+channel_name+",cms_key"+cms_key+"，是--失效的状态");
//					return cmsValueModelList;
//				}
//			}
//		}else{
//			logger.info("channel_name:"+channel_name+",cms_key"+cms_key+"，没有查询到，或者说是--失效的状态");
//			return cmsValueModelList;
//		}
		/**
		 * 根据channel_name,cms_key 获取c-value
		 */
		CmsValueExample example=new CmsValueExample();
		CmsValueExample.Criteria criteria=example.createCriteria();
		criteria.andChannelNameEqualTo(channel_name);
		criteria.andCmsKeyEqualTo(cms_key);
		criteria.andEnabledEqualTo(Constant.C_VALUE_NORMAL);
		example.setOrderByClause("business_id desc,os desc,client desc,language desc");
		List<CmsValue> cmsValueList=this.cmsValueMapper.selectByExample(example);
		if(cmsValueList!=null && cmsValueList.size()>0){
			List<RankingCmsValue> rankingCmsValueList=rankCmsValue(cmsValueList);
			for (RankingCmsValue rankingCmsValue : rankingCmsValueList) {
				cmsValueModelList.add(setRankingCmsValueToCmsValueModel(rankingCmsValue));
			}
		}else{
			logger.info("根据 channel_name:"+channel_name+", cms_key"+cms_key+"，在cms-value中  未找到相应的数据");
		}
		return cmsValueModelList;
	}
	
	/**
	 * 新增c-value
	 */
	public int addCmsValue(CmsValueModel cmsValueModel){
		//根据四项参数，验证是否存在。
		CmsValueExample ee=new CmsValueExample();
		CmsValueExample.Criteria criteria=ee.createCriteria();
		criteria.andChannelNameEqualTo(cmsValueModel.getChannelName());
		criteria.andCmsKeyEqualTo(cmsValueModel.getCmsKey());
		criteria.andBusinessIdEqualTo(cmsValueModel.getBusinessId());
		criteria.andLanguageEqualTo(cmsValueModel.getLanguage());
		criteria.andClientEqualTo(cmsValueModel.getClient());
		criteria.andOsEqualTo(cmsValueModel.getOs());
		criteria.andEnabledEqualTo(Constant.C_VALUE_NORMAL);
		List<CmsValue> cmsValueLsit=this.cmsValueMapper.selectByExample(ee);
		if(cmsValueLsit!=null && cmsValueLsit.size()>0){
			logger.error("this value is exist,"+
					"ChannelName:"+cmsValueModel.getChannelName()+",CmsKey:"+cmsValueModel.getCmsKey()+
					",BusinessId:"+cmsValueModel.getBusinessId()+",Language"+cmsValueModel.getLanguage()+
					",Client"+cmsValueModel.getClient()+",Os:"+cmsValueModel.getOs());
			return 0;
		}
		
		CmsValue cmsValue=setToCmsValue(cmsValueModel);
		//TODO 创建人，修改人----获取登录信息
		if(cmsValue.getBusinessId()==null || "".equals(cmsValue.getBusinessId())){
			cmsValue.setBusinessId("*");
		}
		cmsValue.setCreateTime(new Date());
		cmsValue.setLastUpdateTime(new Date());
		cmsValue.setCmsValue("");
		cmsValue.setEnabled(Constant.C_VALUE_NORMAL);
		int num=this.cmsValueMapper.insertSelective(cmsValue);
		if(num>0){
			CmsValueHistory cmsValueHistory=cmsValueSetToCmsValueHistory(cmsValue);
			int code=this.cmsValueHistoryMapper.insertSelective(cmsValueHistory);
			if(code>0){
				return code;
			}
		}
		return 0;
	}
	
	/**
	 * 修改c-value
	 */
	public int updateCmsValue(CmsValueModel cmsValueModel){
		CmsValue cmsValue=setToCmsValue(cmsValueModel);
		cmsValue.setLastUpdateTime(new Date());
		//TODO  修改人,获取登录状态信息
		int num=this.cmsValueMapper.updateByPrimaryKeySelective(cmsValue);
		if(num>0){
			cmsValue=this.cmsValueMapper.selectByPrimaryKey(cmsValueModel.getValueId());
			CmsValueHistory cmsValueHistory=cmsValueSetToCmsValueHistory(cmsValue);
			int code=this.cmsValueHistoryMapper.insertSelective(cmsValueHistory);
			if(code>0){
				return code;
			}
		}
		return 0;
	}
	
	/**
	 * 删除c-value
	 * 修改 Enabled状态
	 */
	public int deleteCmsValue(Long valueId){
		CmsValue cmsValue=this.cmsValueMapper.selectByPrimaryKey(valueId);
		cmsValue.setEnabled(Constant.C_VALUE_DISABLE);
		int num=updateCmsValue(setToCmsValueModel(cmsValue));
		return num;
	}
	
	/**
	 * 获取历史数据
	 */
	public List<CmsValueHistory> getCmsValueHistory(Long valueId){
//		CmsValueHistoryExample example=new CmsValueHistoryExample();
//		example.setOrderByClause("last_update_time desc");
//		CmsValueHistoryExample.Criteria criteria=example.createCriteria();
//		criteria.andValueIdEqualTo(valueId);
//		List<CmsValueHistory> cmsValueHistoryList=this.cmsValueHistoryMapper.selectByExample(example);
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("valueId", valueId);
		paramMap.put("start", 0);
		paramMap.put("length", 20);
		List<CmsValueHistory> cmsValueHistoryList=newCmsValueHistoryMapper.selectCmsValueHistory(paramMap);
		return cmsValueHistoryList;
	}
	/**
	 * 根据ID查询cms-value
	 */
	public CmsValueModel getCmsValue(Long valueId){
		CmsValue cmsValue=this.cmsValueMapper.selectByPrimaryKey(valueId);
		return setToCmsValueModel(cmsValue);
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
		cmsValueModel.setDescription(cmsValue.getDescription());
		return cmsValueModel;
	}
	
	/**
	 * CmsValueModel to cmsvalue
	 * @param CmsValueModel
	 * @return cmsvalue
	 */
	private CmsValue setToCmsValue(CmsValueModel cmsValueModel){
		CmsValue cmsValue=new CmsValue();
		cmsValue.setBusinessId(cmsValueModel.getBusinessId());
		cmsValue.setChannelName(cmsValueModel.getChannelName());
		cmsValue.setClient(cmsValueModel.getClient());
		cmsValue.setCmsKey(cmsValueModel.getCmsKey());
		cmsValue.setCmsValue(cmsValueModel.getCmsValue());
		cmsValue.setCreateTime(cmsValueModel.getCreateTime());
		cmsValue.setCreator(cmsValueModel.getCreator());
		cmsValue.setEnabled(cmsValueModel.getEnabled());
		cmsValue.setLanguage(cmsValueModel.getLanguage());
		cmsValue.setLastUpdateTime(cmsValueModel.getLastUpdateTime());
		cmsValue.setOs(cmsValueModel.getOs());
		cmsValue.setUpdater(cmsValueModel.getUpdater());
		cmsValue.setValueId(cmsValueModel.getValueId());
		cmsValue.setDescription(cmsValueModel.getDescription());
		return cmsValue;
	}
	
	/**
	 * key to keyModel
	 * @param key
	 * @return
	 */
	private  CmsKeyModel setKeytoModel(CmsKey key){
		CmsKeyModel model = new CmsKeyModel();
		model.setChannelName(key.getChannelName());
		model.setCreateTime(key.getCreateTime()); 
		model.setCreator(key.getCreator()); 
		model.setLastUpdateTime(key.getLastUpdateTime()); 
		model.setName(key.getName()); 
		model.setTagId(key.getTagId()); 
		model.setUpdater(key.getUpdater()); 
		model.setCmsKey(key.getCmsKey());
		model.setDescription(key.getDescription());
		model.setEnabled(key.getEnabled());
		model.setKeyId(key.getKeyId());
		model.setKeyType(key.getKeyType());
		return model;
	}
	
	/**
	 * CmsValueModel to CmsValueHistory
	 * @param cmsValueModel
	 * @return CmsValueHistory
	 */
	private CmsValueHistory setToCmsValueHistory(CmsValueModel cmsValueModel){
		CmsValueHistory cmsValueHistory=new CmsValueHistory();
		cmsValueHistory.setBusinessId(cmsValueModel.getBusinessId());
		cmsValueHistory.setChannelName(cmsValueModel.getChannelName());
		cmsValueHistory.setClient(cmsValueModel.getClient());
		cmsValueHistory.setCmsKey(cmsValueModel.getCmsKey());
		cmsValueHistory.setCmsValue(cmsValueModel.getCmsValue());
		cmsValueHistory.setCreateTime(cmsValueModel.getCreateTime());
		cmsValueHistory.setCreator(cmsValueModel.getCreator());
		cmsValueHistory.setEnabled(cmsValueModel.getEnabled());
		cmsValueHistory.setLanguage(cmsValueModel.getLanguage());
		cmsValueHistory.setLastUpdateTime(cmsValueModel.getLastUpdateTime());
		cmsValueHistory.setOs(cmsValueModel.getOs());
		cmsValueHistory.setUpdater(cmsValueModel.getUpdater());
		cmsValueHistory.setValueId(cmsValueModel.getValueId());
		cmsValueHistory.setDescription(cmsValueModel.getDescription());
		return cmsValueHistory;
	}
	/**
	 * cmsValue to CmsValueHistory
	 * @param cmsValueModel
	 * @return CmsValueHistory
	 */
	private CmsValueHistory cmsValueSetToCmsValueHistory(CmsValue cmsValue){
		CmsValueHistory cmsValueHistory=new CmsValueHistory();
		cmsValueHistory.setBusinessId(cmsValue.getBusinessId());
		cmsValueHistory.setChannelName(cmsValue.getChannelName());
		cmsValueHistory.setClient(cmsValue.getClient());
		cmsValueHistory.setCmsKey(cmsValue.getCmsKey());
		cmsValueHistory.setCmsValue(cmsValue.getCmsValue());
		cmsValueHistory.setCreateTime(cmsValue.getCreateTime());
		cmsValueHistory.setCreator(cmsValue.getCreator());
		cmsValueHistory.setEnabled(cmsValue.getEnabled());
		cmsValueHistory.setLanguage(cmsValue.getLanguage());
		cmsValueHistory.setLastUpdateTime(cmsValue.getLastUpdateTime());
		cmsValueHistory.setOs(cmsValue.getOs());
		cmsValueHistory.setUpdater(cmsValue.getUpdater());
		cmsValueHistory.setValueId(cmsValue.getValueId());
		cmsValueHistory.setDescription(cmsValue.getDescription());
		return cmsValueHistory;
	}
	
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
		rankingCmsValue.setDescription(cmsValue.getDescription());
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
		cmsValue.setDescription(rankingCmsValue.getDescription());
		return cmsValue;
	}
}
