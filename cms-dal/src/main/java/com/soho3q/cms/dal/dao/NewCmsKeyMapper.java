package com.soho3q.cms.dal.dao;

import com.soho3q.cms.dal.dataobj.CmsKey;
import com.soho3q.cms.dal.dataobj.CmsKeyExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NewCmsKeyMapper {
    /**
     * 分页查询总数
     */
	int selectPageKeyListOfCount(Map<String,Object> param);
	/**
     * 分页查询
     */
    List<CmsKey> selectPageKeyList(Map<String,Object> param);

}