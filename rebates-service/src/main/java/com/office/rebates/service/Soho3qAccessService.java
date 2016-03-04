package com.office.rebates.service;

import java.util.List;

import com.office.rebates.model.Soho3qProjectModel;
import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.model.request.CreateOrderRequest;

public interface Soho3qAccessService {

	List<Soho3qProjectModel> getProjectList() throws RebatesException;
	
}
