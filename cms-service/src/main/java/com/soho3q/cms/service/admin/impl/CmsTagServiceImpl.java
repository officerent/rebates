package com.soho3q.cms.service.admin.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.model.admin.CmsTagModel;
import com.soho3q.cms.service.admin.CMSService;
import com.soho3q.cms.service.admin.CmsTagService;
import com.soho3q.cms.dal.dao.CmsChannelMapper;
import com.soho3q.cms.dal.dao.CmsKeyMapper;
import com.soho3q.cms.dal.dao.CmsTagMapper;
import com.soho3q.cms.dal.dao.CmsValueMapper;
import com.soho3q.cms.dal.dataobj.*;
import com.soho3q.web.utils.LogicUtil;


@Service
public class CmsTagServiceImpl implements CmsTagService{

	static Logger logger = Logger.getLogger(CmsTagServiceImpl.class);	
	
	@Autowired
	private CmsChannelMapper cmsChannelMapper;
	
	@Autowired
	private CmsKeyMapper cmsKeyMapper;
	
	@Autowired
	private CmsTagMapper cmsTagMapper;
	
	@Autowired
	private CmsValueMapper cmsValueMapper;
	
	@Override
	public ArrayList<CmsTagModel> getCmsTagList(String channelName) {
		CmsTagExample example = new CmsTagExample();
		if(LogicUtil.isNotNullAndEmpty(channelName)){
			example.createCriteria().andChannelNameEqualTo(channelName);
		}
		List<CmsTag> tagList = cmsTagMapper.selectByExample(example);
		if(LogicUtil.isNotNullAndEmpty(tagList)){
			return setChanneltoModelList(tagList);
		}else{
			return null;
		}
	}
	
	public ArrayList<CmsTagModel> setChanneltoModelList(List<CmsTag> tagList){
		ArrayList<CmsTagModel>  modelList = new ArrayList<CmsTagModel>();
		for(CmsTag item:tagList){
			modelList.add(setTagtoModel(item));
		}
		return modelList;
	}
	
	public CmsTagModel setTagtoModel(CmsTag tag){
		CmsTagModel model = new CmsTagModel();
		model.setChannelName(tag.getChannelName());
		model.setCreateTime(tag.getCreateTime()); 
		model.setCreator(tag.getCreator()); 
		model.setLastUpdateTime(tag.getLastUpdateTime()); 
		model.setName(tag.getName()); 
		model.setTagId(tag.getTagId()); 
		model.setUpdater(tag.getUpdater()); 
		model.setColor(tag.getColor());
		return model;
	}

	@Override
	public CmsTagModel addTag(CmsTagModel model) {
		CmsTag tag = new CmsTag();
		tag.setChannelName(model.getChannelName());
		tag.setCreateTime(new Date());
		tag.setName(model.getName());
		tag.setCreator(model.getCreator());
		tag.setColor(model.getColor());
		/*tag.setTagId(tagId);
		tag.setUpdater(updater);
		tag.setLastUpdateTime(lastUpdateTime);*/
		int num = cmsTagMapper.insert(tag);
		if(num>0){
			return setTagtoModel(tag);
		}else{
			return null;
		}
	}
}
