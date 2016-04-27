package com.office.rebates.service;

import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.model.request.CreateOrderRequest;
import com.office.rebates.model.request.CreateCouponOrderRequest;

public interface RebatesOrderService {

	Long createRebatesOrder(CreateOrderRequest request, UserInfo userInfo) throws RebatesException;
	
	Long createRebatesCouponOrder(CreateCouponOrderRequest request, UserInfo userInfo) throws RebatesException;
	
}
