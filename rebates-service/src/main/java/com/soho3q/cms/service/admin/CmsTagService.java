package com.soho3q.cms.service.admin;

import java.util.ArrayList;

import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.model.admin.CmsTagModel;

public interface CmsTagService {
	
	ArrayList<CmsTagModel> getCmsTagList(String channelName);
	
	CmsTagModel addTag(CmsTagModel model);
}
