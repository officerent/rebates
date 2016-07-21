package com.office.rebates.controller.web;

import com.office.rebates.controller.RouteKey;
import com.office.rebates.service.web.WebQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 问题控制器
 * Created by liyongfeng on 16/7/14.
 */
@Controller
@RequestMapping(RouteKey.WEB_QUESTION)
public class WebQuestionController {

    /**
     * 问题服务
     */
    @Autowired
    private WebQuestionService webQuestionService;

    /**
     * 提示页
     */
    @RequestMapping(RouteKey.TIP)
    public void tip(String manager,String url,Model model){
        model.addAttribute("url",url);
        model.addAttribute("manager",manager);
    }
    

    /**
     * 帮助中心页
     */
    @RequestMapping(RouteKey.QUESTION_LIST)
    public void help(){

    }
}
