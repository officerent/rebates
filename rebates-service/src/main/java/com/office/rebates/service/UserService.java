package com.office.rebates.service;

import java.util.List;

import javax.servlet.http.Cookie;

import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.RebatesException;

public interface UserService {
	
	//根据usertoken获取用户信息
	UserInfo  getUserInfo(String token);

	UserInfo getUserInfo(Cookie[] cookies);

	Long registerUser(String userName, String password) throws RebatesException,Exception;
	
	String login(String userName, String password) throws RebatesException,Exception;
}
