package com.soho3q.cms.service.admin.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.model.admin.CmsKeyModel;
import com.soho3q.cms.model.admin.CmsTagModel;
import com.soho3q.cms.model.common.Constant;
import com.soho3q.cms.model.common.PageData;
import com.soho3q.cms.service.admin.CMSService;
import com.soho3q.cms.service.admin.CmsKeyService;
import com.soho3q.cms.dal.dao.CmsChannelMapper;
import com.soho3q.cms.dal.dao.CmsKeyMapper;
import com.soho3q.cms.dal.dao.CmsTagMapper;
import com.soho3q.cms.dal.dao.CmsValueMapper;
import com.soho3q.cms.dal.dao.NewCmsKeyMapper;
import com.soho3q.cms.dal.dataobj.*;
import com.soho3q.web.utils.LogicUtil;


@Service
public class CmsKeyServiceImpl implements CmsKeyService{

	static Logger logger = Logger.getLogger(CmsKeyServiceImpl.class);	
	
	@Autowired
	private CmsChannelMapper cmsChannelMapper;
	
	@Autowired
	private CmsKeyMapper cmsKeyMapper;
	
	@Autowired
	private CmsTagMapper cmsTagMapper;
	
	@Autowired
	private CmsValueMapper cmsValueMapper;
	
	@Autowired
	private NewCmsKeyMapper newCmsKeyMapper;
	
	@Override
	public PageData<CmsKeyModel> getCmsKeyList(CmsKeyModel model,Integer pageSize,Integer pageNum) {
		logger.info("Will go to select KeyList ");
		/*CmsKeyExample example = new CmsKeyExample();
		if(LogicUtil.isNotNullAndEmpty(channelName)){
			example.createCriteria().andChannelNameEqualTo(channelName);
		}
		//总数
		int countKey = cmsKeyMapper.countByExample(example);
		List<CmsKey> keyList = cmsKeyMapper.selectByExample(example);*/
		int startNum = (pageNum-1)*pageSize;
		int endNum = pageSize;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("startNum", startNum);
		param.put("endNum", endNum);
		param.put("channelName", model.getChannelName());
		param.put("keyType", model.getKeyType());
		param.put("cmsKey", model.getCmsKey());
		param.put("enabled", model.getEnabled());
		param.put("name", model.getName());
		param.put("tagId", model.getTagId());
		int countKey = newCmsKeyMapper.selectPageKeyListOfCount(param);
		List<CmsKey> keyList = newCmsKeyMapper.selectPageKeyList(param);
		PageData<CmsKeyModel> pageKey = new PageData<CmsKeyModel>();
		if(LogicUtil.isNotNullAndEmpty(keyList)){
			pageKey.setPageNum(pageNum);
			pageKey.setPageSize(pageSize);
			pageKey.setTotal(countKey);
			pageKey.setPageTotal(countKey, pageSize);
			pageKey.setListData(setKeytoModelList(keyList));
			return pageKey;
		}else{
			return null;
		}
	}
	
	@Override
	public int addKey(CmsKeyModel model) {
		logger.info("Will go to add CmsKey for param: "+JSONObject.toJSON(model));
		CmsKey key  = setModeltoKey(model);
		key.setCreateTime(new Date());
		key.setEnabled(Constant.KEY_DISABLED_AVAILABLE);
		int num = cmsKeyMapper.insert(key);
		
		return num;
	}

	
	public ArrayList<CmsKeyModel> setKeytoModelList(List<CmsKey> keyList){
		ArrayList<CmsKeyModel>  modelList = new ArrayList<CmsKeyModel>();
		for(CmsKey item:keyList){
			modelList.add(setKeytoModel(item));
		}
		return modelList;
	}
	
	public CmsKeyModel setKeytoModel(CmsKey key){
		CmsKeyModel model = new CmsKeyModel();
		model.setChannelName(key.getChannelName());
		model.setCreateTime(key.getCreateTime()); 
		model.setCreator(key.getCreator()); 
		model.setLastUpdateTime(key.getLastUpdateTime()); 
		model.setName(key.getName()); 
		model.setTagId(key.getTagId()); 
		if(LogicUtil.isNotNull(key.getTagId())){
			CmsTag tag = cmsTagMapper.selectByPrimaryKey(key.getTagId());
			if(LogicUtil.isNotNull(tag)){
				model.setTagName(tag.getName());
				model.setTagColor(tag.getColor());
			}
		}
		model.setUpdater(key.getUpdater()); 
		model.setCmsKey(key.getCmsKey());
		model.setDescription(key.getDescription());
		model.setEnabled(key.getEnabled());
		model.setKeyId(key.getKeyId());
		model.setKeyType(key.getKeyType());
		return model;
	}
	
	public CmsKey setModeltoKey(CmsKeyModel key){
		CmsKey model = new CmsKey();
		if(LogicUtil.isNotNull(key.getKeyId())){
			model.setKeyId(key.getKeyId());
		}
		if(LogicUtil.isNotNullAndEmpty(key.getChannelName())){
			model.setChannelName(key.getChannelName());
		}
		if(LogicUtil.isNotNull(key.getCreateTime())){
			model.setCreateTime(key.getCreateTime());
		}
		if(LogicUtil.isNotNullAndEmpty(key.getCreator())){
			model.setCreator(key.getCreator());
		}
		if(LogicUtil.isNotNull(key.getLastUpdateTime())){
			model.setLastUpdateTime(key.getLastUpdateTime());
		}
		if(LogicUtil.isNotNullAndEmpty(key.getName())){
			model.setName(key.getName());
		}
		if(LogicUtil.isNotNull(key.getTagId())){
			model.setTagId(key.getTagId());
		}
		if(LogicUtil.isNotNullAndEmpty(key.getUpdater())){
			model.setUpdater(key.getUpdater());
		}
		if(LogicUtil.isNotNullAndEmpty(key.getCmsKey())){
			model.setCmsKey(key.getCmsKey());
		}
		if(LogicUtil.isNotNullAndEmpty(key.getDescription())){
			model.setDescription(key.getDescription());
		}
		if(LogicUtil.isNotNull(key.getEnabled())){
			model.setEnabled(key.getEnabled());
		}
		if(LogicUtil.isNotNullAndEmpty(key.getKeyType())){
			model.setKeyType(key.getKeyType());
		}
		return model;
	}

	
	@Override
	public int updateKey(CmsKeyModel key) {
		logger.info("Will go to update key for param:"+JSONArray.toJSONString(key));
		if(LogicUtil.isNotNullAndEmpty(key.getUpdater())){
			key.setUpdater(key.getUpdater());
		}else{
			key.setUpdater(Constant.DEFAULT_UPDATER);
		}
		
		key.setLastUpdateTime(new Date());
		int num = cmsKeyMapper.updateByPrimaryKeySelective(setModeltoKey(key));
		return num;
	}

	@Override
	public int deleteKey(Long keyId) {
		int num=cmsKeyMapper.deleteByPrimaryKey(keyId);
		return num;
	}

	@Override
	public CmsKeyModel getCmsKeyModelById(Long keyId) {
		logger.info("Will go to select CmsKey by keyId:"+keyId);
		CmsKey key = cmsKeyMapper.selectByPrimaryKey(keyId);
		if(LogicUtil.isNotNull(key)){
			return setKeytoModel(key);
		}else{
			return new CmsKeyModel();
		}
	}

	@Override
	public int updateKeyStatus(CmsKeyModel key) {
		logger.info("Will go to updateKey enabled for id:"+key.getKeyId()+",and enabled:"+key.getEnabled());
		CmsKey record = new CmsKey();
		record.setKeyId(key.getKeyId());
		record.setEnabled(key.getEnabledSub());
		int num = cmsKeyMapper.updateByPrimaryKeySelective(record);
		return num;
	}

	@Override
	public int selectCMSKeyByKey(String channelName, String cmsKey) {
		logger.info("Will go to selectCMSKeyByKey  for channelName:"+channelName+",and cmsKey:"+cmsKey);
		CmsKeyExample example = new CmsKeyExample();
		example.createCriteria().andChannelNameEqualTo(channelName).andCmsKeyEqualTo(cmsKey);
		List<CmsKey> keyList = cmsKeyMapper.selectByExample(example);
		if(LogicUtil.isNotNullAndEmpty(keyList)){
			return keyList.size();
		}else{
			return 0;
		}
	}
}
