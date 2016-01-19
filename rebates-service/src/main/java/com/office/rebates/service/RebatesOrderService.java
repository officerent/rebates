package com.office.rebates.service;

import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.model.request.CreateOrderRequest;

public interface RebatesOrderService {

	Long createRebatesOrder(CreateOrderRequest request, UserInfo userInfo) throws RebatesException;
	
}
