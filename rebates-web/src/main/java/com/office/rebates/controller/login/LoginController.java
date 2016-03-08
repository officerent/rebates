package com.office.rebates.controller.login;

import com.office.rebates.controller.RouteKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制器
 * Created by liyongfeng on 2016/1/24.
 */
@Controller
@RequestMapping(RouteKey.REBATES_USER)
public class LoginController {

    /**
     * 跳转至登录接口
     */
    @RequestMapping(RouteKey.DO_LOGIN)
    public void login(){

    }
}
