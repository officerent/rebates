package com.soho3q.cms.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.service.admin.CmsChannelService;
import com.soho3q.cms.dal.dao.CmsChannelMapper;
import com.soho3q.cms.dal.dao.CmsKeyMapper;
import com.soho3q.cms.dal.dao.CmsTagMapper;
import com.soho3q.cms.dal.dao.CmsValueMapper;
import com.soho3q.cms.dal.dataobj.*;
import com.soho3q.web.utils.LogicUtil;


@Service
public class CmsChannelServiceImpl implements CmsChannelService{

	static Logger logger = Logger.getLogger(CmsChannelServiceImpl.class);	
	
	@Autowired
	private CmsChannelMapper cmsChannelMapper;
	
	@Autowired
	private CmsKeyMapper cmsKeyMapper;
	
	@Autowired
	private CmsTagMapper cmsTagMapper;
	
	@Autowired
	private CmsValueMapper cmsValueMapper;
	
	@Override
	public ArrayList<CmsChannelModel> getChannelList() throws Exception {
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
		model.setCssFile(channel.getCssFile());
		return model;
	}

	@Override
	public int addCmsChannel() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CmsChannelModel selectCmsChannelById(Long channelId) throws Exception {
		
		CmsChannel channel = cmsChannelMapper.selectByPrimaryKey(channelId);
		if(LogicUtil.isNotNull(channel)){
			return setChanneltoModel(channel);
		}else{
			return null;
		}
	}

	@Override
	public CmsChannelModel selectCmsChannelByName(String channelName)
			throws Exception {
		CmsChannelExample example = new CmsChannelExample();
		example.createCriteria().andNameEqualTo(channelName);
		List<CmsChannel> channel = cmsChannelMapper.selectByExample(example);
		if(LogicUtil.isNotNullAndEmpty(channel)){
			return setChanneltoModel(channel.get(0));
		}else{
			return null;
		}
	}
	
	
	
}
