package com.soho3q.cms.service.admin;

import java.util.ArrayList;

import com.soho3q.cms.model.admin.CmsChannelModel;

public interface CmsChannelService {
	
	ArrayList<CmsChannelModel> getChannelList() throws Exception;
	
	int addCmsChannel() throws Exception;
	
	CmsChannelModel selectCmsChannelById(Long channelId) throws Exception;
	
	CmsChannelModel selectCmsChannelByName(String channelName) throws Exception;
}
