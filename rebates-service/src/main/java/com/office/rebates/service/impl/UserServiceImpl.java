package com.office.rebates.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.office.rebates.dal.dao.RebatesUserMapper;
import com.office.rebates.dal.dataobj.RebatesUser;
import com.office.rebates.dal.dataobj.RebatesUserExample;
import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.Constants;
import com.office.rebates.model.common.Messages;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.service.TokenService;
import com.office.rebates.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private RebatesUserMapper rebatesUserMapper;
    
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

	@Override
	public Long registerUser(String userName, String password) throws RebatesException, Exception {		
		//check if the user exist
		RebatesUserExample userExample=new RebatesUserExample();
		userExample.createCriteria().andNameEqualTo(userName);
		List<RebatesUser> users=rebatesUserMapper.selectByExample(userExample);
		if(users!=null&&!userName.isEmpty()){//name already exist
			logger.info("user name "+userName+" already exists");
			throw new RebatesException(Messages.USER_ALREADY_EXIST_CODE,Messages.USER_ALREADY_EXIST_MSG);
		}
		
		//insert user table
		Date now=new Date();
		RebatesUser rebatesUser=new RebatesUser();
		rebatesUser.setCreateTime(now);
		rebatesUser.setIsAdmin(Constants.USER_NOT_ADMIN);
		rebatesUser.setName(userName);
		rebatesUser.setPassword(password);
		rebatesUser.setStatus(Constants.USER_STATUS_NORMAL);
		rebatesUser.setLastUpdateTime(now);
		rebatesUserMapper.insert(rebatesUser);
		logger.info("new user was inserted:"+JSON.toJSONString(rebatesUser));
		return rebatesUser.getUserId();
	}
	
	
}
