package com.office.rebates.controller.admin;

import com.alibaba.fastjson.JSON;
import com.office.rebates.controller.RouteKey;
import com.office.rebates.dal.dao.RebatesArticleMapper;
import com.office.rebates.dal.dataobj.RebatesArticle;
import com.office.rebates.model.common.Page;
import com.office.rebates.service.admin.AdminArticleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制器
 * Created by xxm on 2016/7/25.
 */
@Controller
@RequestMapping(RouteKey.ARTICLE)
public class AdminArticleController {

    /**
     * 文章服务
     */
    @Autowired
    private AdminArticleService adminArticleService;
    
    @Autowired
    private RebatesArticleMapper rebatesArticleMapper;
    
    private  Logger logger = LoggerFactory.getLogger(AdminArticleController.class);
    

    /**
     * 获取用户列表
     */
    @RequestMapping(RouteKey.ARTICLE_LIST)
    public void user_list(Page page,String type,Boolean isDeleted,Model model){
        model.addAttribute("data",adminArticleService.getArticleList(page, type, isDeleted));
        model.addAttribute("page",page);
        model.addAttribute("type",type);
        model.addAttribute("isDeleted",isDeleted);
    }
    
    /**
     * 添加文章
     */
    @RequestMapping(RouteKey.ADD_ARTICLE)
    public void add_article(){
    	
    }
    
    /**
     * 编辑文章
     */
    @RequestMapping(RouteKey.MODIFY_ARTICLE)
    public void modify_article(Long articleId,Model model){
    	model.addAttribute("data",rebatesArticleMapper.selectByPrimaryKey(articleId));
    }


    /**
     * 新增文章信息至数据库
     * @return
     */
    @RequestMapping(RouteKey.INSERT_ARTICLE)
    public String insert_article(RebatesArticle article) {
    	logger.info("inserting article with:"+JSON.toJSONString(article));
    	adminArticleService.createArticle(article);
        //adminUserService.insert(rebatesUser);
        return "redirect:article_list.html";
    }


}
