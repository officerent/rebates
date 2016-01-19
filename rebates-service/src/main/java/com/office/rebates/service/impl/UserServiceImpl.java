package com.office.rebates.service.impl;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.Constants;
import com.office.rebates.model.common.Messages;
import com.office.rebates.service.TokenService;
import com.office.rebates.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private TokenService tokenService;
    
    static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
	@Override
	public UserInfo getUserInfo(String token) {
		UserInfo userInfo=null;
		return userInfo;
	}

	@Override
	public UserInfo getUserInfo(Cookie[] cookies) {
		UserInfo userInfo=null;
		if(cookies==null ||cookies.length<=0){
			return null;
		}else{
			for (int i = 0; i < cookies.length; i++) {
				if (Constants.COOKIE_USER_TOKEN.equalsIgnoreCase(cookies[i].getName())) {
					String token=cookies[i].getValue();
					userInfo=tokenService.getUserInfoByToken(token);
				}
			}
		}		
		return userInfo;
	}
}
