package com.office.rebates.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.office.rebates.model.Soho3qOrder;
import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.model.request.CreateOrderRequest;
import com.office.rebates.service.RebatesOrderService;


@Service
public class RebatesOrderServiceImpl implements RebatesOrderService{

	static Logger logger = LoggerFactory.getLogger(RebatesOrderServiceImpl.class);
	
	@Override
	public Soho3qOrder createRebatesOrder(CreateOrderRequest request, UserInfo userInfo) throws RebatesException {
		// TODO Auto-generated method stub
		return null;
	}



}
