package com.soho3q.cms.dal.dao;

import java.util.List;
import java.util.Map;

import com.soho3q.cms.dal.dataobj.CmsValueHistory;

public interface NewCmsValueHistoryMapper {

	List<CmsValueHistory> selectCmsValueHistory(Map<String,Object> paramMap);
}
