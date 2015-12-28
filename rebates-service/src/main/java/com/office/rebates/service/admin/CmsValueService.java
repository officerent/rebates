package com.soho3q.cms.service.admin;


import java.util.List;

import com.soho3q.cms.dal.dataobj.CmsValueHistory;
import com.soho3q.cms.model.admin.CmsKeyModel;
import com.soho3q.cms.model.admin.CmsValueModel;

/**
 * 
 * @author pangweidong
 *
 */
public interface CmsValueService {
	/**
	 * 获取c-key
	 * @param channel_name
	 * @param cms_key
	 * @return
	 */
	CmsKeyModel getCmsKey(String channel_name,String cms_key);
	/**
	 * 获取c-value
	 * @param channel_name
	 * @param cms_key
	 * @return
	 */
	List<CmsValueModel> getCmsValueList(String channel_name,String cms_key);
	/**
	 * 根据ID查询cms-value
	 * @param valueId
	 * @return
	 */
	CmsValueModel getCmsValue(Long valueId);
	/**
	 * 新增c-value
	 * @param cmsValueModel
	 * @return
	 */
	int addCmsValue(CmsValueModel cmsValueModel);
	/**
	 * 修改c-value
	 * @param cmsValueModel
	 * @return
	 */
	int updateCmsValue(CmsValueModel cmsValueModel);
	/**
	 * 删除c-value
	 * @param valueId
	 * @return
	 */
	int deleteCmsValue(Long valueId);
	/**
	 * 获取历史记录
	 * @param valueId
	 * @return
	 */
	List<CmsValueHistory>  getCmsValueHistory(Long valueId);
}
