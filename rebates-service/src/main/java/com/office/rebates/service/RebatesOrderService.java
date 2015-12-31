package com.office.rebates.service;

import java.util.List;

import com.office.rebates.model.Soho3qOrder;
import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.model.request.CreateOrderRequest;

public interface RebatesOrderService {

	Soho3qOrder createRebatesOrder(CreateOrderRequest request, UserInfo userInfo) throws RebatesException;
	
}
