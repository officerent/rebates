package com.soho3q.cms.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.service.admin.CMSService;
import com.soho3q.cms.dal.dao.CmsChannelMapper;
import com.soho3q.cms.dal.dao.CmsKeyMapper;
import com.soho3q.cms.dal.dao.CmsTagMapper;
import com.soho3q.cms.dal.dao.CmsValueMapper;
import com.soho3q.cms.dal.dataobj.*;
import com.soho3q.web.utils.LogicUtil;


@Service
public class CMSServiceImpl implements CMSService{

	static Logger logger = Logger.getLogger(CMSServiceImpl.class);	
	
	@Autowired
	private CmsChannelMapper cmsChannelMapper;
	
	@Autowired
	private CmsKeyMapper cmsKeyMapper;
	
	@Autowired
	private CmsTagMapper cmsTagMapper;
	
	@Autowired
	private CmsValueMapper cmsValueMapper;
	
	@Override
	public ArrayList<CmsChannelModel> getChannelList() {
		CmsChannelExample exa = new CmsChannelExample();
		List<CmsChannel> channelList = cmsChannelMapper.selectByExample(exa);
		if(LogicUtil.isNotNullAndEmpty(channelList)){
			return setChanneltoModelList(channelList);
		}else{
			return null;
		}
		
	}
	
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
	
}
