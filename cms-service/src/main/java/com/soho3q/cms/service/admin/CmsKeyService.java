package com.soho3q.cms.service.admin;

import java.util.ArrayList;

import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.model.admin.CmsKeyModel;
import com.soho3q.cms.model.common.PageData;

public interface CmsKeyService {
	/**
	 * 分页查询Key
	 */
	PageData<CmsKeyModel> getCmsKeyList(CmsKeyModel model,Integer pageSize,Integer pageNum);
	/**
	 * 通过Id查询Key
	 */
	CmsKeyModel getCmsKeyModelById(Long keyId);
	/**
	 * 增加Key
	 */
	int addKey(CmsKeyModel key);
	/**
	 * 修改Key
	 */
	int updateKey(CmsKeyModel key);
	/**
	 * 修改Key状态
	 */
	int updateKeyStatus(CmsKeyModel key);
	/**
	 * 删除Key
	 */
	int deleteKey(Long keyId);
	
	/**
	 * 通过Key 查询Key
	 */
	int selectCMSKeyByKey(String channelName,String cmsKey);
}
