package com.office.rebates.controller.web;

import com.office.rebates.controller.RouteKey;
import com.office.rebates.dal.dao.RebatesArticleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章控制器
 * Created by xxm on 16/8/1.
 */
@Controller
@RequestMapping(RouteKey.WEB_ARTICLE)
public class WebArticleController {

    /**
     * 文章dao
     */
    @Autowired
    private RebatesArticleMapper rebatesArticleMapper;

    /**
     * 文章详情页
     */
    @RequestMapping(RouteKey.ARTICLE_DETAIL)
    public void getArticleDetail(Long articleId,Model model){
        model.addAttribute("data",rebatesArticleMapper.selectByPrimaryKey(articleId));
        //model.addAttribute("manager",manager);
    }
    

}
