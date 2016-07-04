package com.office.rebates.interceptor;

import com.office.rebates.model.UserInfo;
import com.office.rebates.model.common.Constants;
import com.office.rebates.service.TokenService;
import com.office.rebates.util.CookieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截
 * Created by liyongfeng on 2016/2/20.
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 唯一验证服务
     */
    @Autowired
    private TokenService tokenService;

    /**
     * 拦截器
     */
    public static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = CookieHelper.getCookie(Constants.COOKIE_USER_TOKEN,request);
        UserInfo userInfo = tokenService.getUserInfoByToken(token);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
