package com.office.rebates.util;

import com.alibaba.fastjson.JSON;
import com.office.rebates.dal.cache.CacheClient;
import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 判断是否
 * Created by liyongfeng on 2016/4/27.
 */
public final class LoginUtils {

    @Autowired
    @Qualifier("simpleRedisClient")
    private static CacheClient cacheClient;
    /**
     * 日志
     */
    public static Logger logger = LoggerFactory.getLogger(LoginUtils.class);

    /**
     * 获取登录状态
     * @param request
     * @return
     */
    public static boolean getLoginStatus(HttpServletRequest request){
        boolean flag = false;
        try{
            Cookie[] cookies=request.getCookies();
            logger.info("login with parms:"+ JSON.toJSONString(request)+",cookies:"+JSON.toJSONString(cookies));
            UserInfo userInfo= getUserInfo(cookies);
            logger.info("user info is:"+JSON.toJSONString(userInfo));
            if(userInfo !=null || userInfo.getUserId() != null){
                flag = true;
            }
        }catch(Exception e){
            logger.error("LoginUtils.getLoginStatus",e);
        }
        return flag;
    }

    /**
     * 获取用户唯一标识从cookie中
     * @param cookies cookies
     * @return
     */
    public static UserInfo getUserInfo(Cookie[] cookies){
        UserInfo userInfo=null;
        if(cookies==null ||cookies.length<=0){
            return null;
        }else{
            for (int i = 0; i < cookies.length; i++) {
                if (Constants.COOKIE_USER_TOKEN.equalsIgnoreCase(cookies[i].getName())) {
                    String token=cookies[i].getValue();
                    userInfo=getUserInfoByToken(token);
                }
            }
        }
        return userInfo;
    }

    /**
     * 从缓存中获取用户信息
     * @param token 唯一标识
     * @return
     */
    public static UserInfo getUserInfoByToken(String token){
        UserInfo userInfo=cacheClient.get(token, UserInfo.class);
        return userInfo;
    }
}
