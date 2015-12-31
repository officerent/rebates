package com.office.rebates.service;

import java.util.List;

import javax.servlet.http.Cookie;

import com.office.rebates.model.UserInfo;

public interface UserService {
	
	//根据usertoken获取用户信息
	UserInfo  getUserInfo(String token);

	UserInfo getUserInfo(Cookie[] cookies);
}
