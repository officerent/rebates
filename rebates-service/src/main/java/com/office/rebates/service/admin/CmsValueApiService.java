package com.soho3q.cms.service.admin;


import java.util.List;

import com.soho3q.cms.dal.dataobj.CmsKey;
import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.model.admin.CmsValueModel;

/**
 * 
 * @author pangweidong
 *
 */
public interface CmsValueApiService {

	/**
	 * 获取c-channel
	 * @return
	 */
	List<CmsChannelModel> getCmsChannel();
	/**
	 * 获取c-key
	 * @param channel_name
	 * @param cms_key
	 * @return
	 */
	List<CmsKey> getCmsKey(String channel_name);
	/**
	 * 获取c-value
	 * @param channel_name
	 * @param cms_key
	 * @return
	 */
	List<CmsValueModel> getCmsValueList(String channel_name,String cms_key);
	/**
	 * 获取c-value
	 * @param channel_name
	 * @param cms_key
	 * @param language
	 * @param client
	 * @param os
	 * @param business_id
	 * @return
	 */
	CmsValueModel getCmsValue(String channel_name,String cms_key,
			String language,String isApp,String useragent,String business_id);
	
	List<CmsValueModel> getCmsValueList(String channel_name,String cms_keys,
			String language,String isApp,String useragent,String business_id);
}
