package com.office.rebates.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.rebates.dal.rest.Soho3qGetProjectListApi;
import com.office.rebates.model.Soho3qProjectModel;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.service.Soho3qAccessService;

@Service
public class Soho3qAccessServiceImpl implements Soho3qAccessService{

	static Logger logger = LoggerFactory.getLogger(Soho3qAccessServiceImpl.class);
    
	@Autowired
	private Soho3qGetProjectListApi soho3qGetProjectListApi;

	@Override
	public List<Soho3qProjectModel> getProjectList() throws RebatesException {	
		return soho3qGetProjectListApi.getProjectList();
	}

	
	
}
