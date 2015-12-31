package com.office.rebates.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.office.rebates.dal.cache.CacheClient;
import com.office.rebates.model.Soho3qOrder;
import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.Messages;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.model.common.ResultCode;
import com.office.rebates.model.request.CreateOrderRequest;
import com.office.rebates.service.RebatesOrderService;
import com.office.rebates.service.UserService;
import com.office.rebates.service.impl.UserServiceImpl;


@Controller
@RequestMapping(RouteKey.REBATES_ORDER)
public class RebatesOrderController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private RebatesOrderService rebatesOrderService;
    
    static Logger logger = LoggerFactory.getLogger(RebatesOrderController.class);
	//创建一个新的订单
	@RequestMapping(value = RouteKey.CREATE_ORDER, method = RequestMethod.POST)
	public ResultCode<Soho3qOrder> createRebatesOrder(@RequestBody CreateOrderRequest request,HttpServletRequest httpServletRequest) {
		ResultCode<Soho3qOrder> result=new ResultCode<Soho3qOrder>();		
		//check params
		if(request==null){
			result.setErrCode(Messages.USER_NOT_LOGON_CODE);
			result.setErrMsg(Messages.USER_NOT_LOGON_MSG);
			return result;
		}
		
		if(request.getCheckInDate()==null||
			request.getCheckOutDate()==null||
			request.getCustomerAlipay()==null||
			request.getCustomerCompany()==null||
			request.getCustomerMobile()==null||
			request.getCustomerName()==null||
			request.getDepositAmount()==null||
			request.getLeaseAmount()==null||
			request.getOrderItems()==null||
			request.getOrderItems().isEmpty()||
			request.getPeriodMonth()==null||
			request.getPeriodWeek()==null||
			request.getProjectId()==null||
			request.getProjectName()==null)
			{
				result.setErrCode(Messages.MISSING_REQUIRED_PARAM_CODE);
				result.setErrMsg(Messages.MISSING_REQUIRED_PARAM_MSG);
				return result;
			}
		
		//check if the user is logon
		Cookie[] cookies=httpServletRequest.getCookies();
		logger.info("creating order with parms:"+JSON.toJSONString(request)+",cookies:"+JSON.toJSONString(cookies));
		UserInfo userInfo=userService.getUserInfo(cookies);
		logger.info("user info is:"+JSON.toJSONString(userInfo));
		if(userInfo==null||userInfo.getUserId()==null){
			result.setErrCode(Messages.USER_NOT_LOGON_CODE);
			result.setErrMsg(Messages.USER_NOT_LOGON_MSG);
			return result;
		}
		
		//create the order
		try {
			Soho3qOrder soho3qOrder=rebatesOrderService.createRebatesOrder(request,userInfo);
		} catch (RebatesException e) {
			result.setErrCode(e.getErrCode());
			result.setErrMsg(e.getErrMsg());
		}
		return result;

	}
}
