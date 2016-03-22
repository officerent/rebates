package com.office.rebates.controller.web;

import com.office.rebates.controller.RouteKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * web端控制器
 * Created by liyongfeng on 2016/3/13.
 */
@Controller
@RequestMapping(RouteKey.WEB)
public class WebIndexController {

    /**
     * web端首页
     */
    @RequestMapping(RouteKey.WEB_INDEX)
    public void index(){

    }
    
    /**
     * 固定工位下单
     */
    @RequestMapping(RouteKey.FIX_PRODUCT)
    public void fix_product(){

    }
}
