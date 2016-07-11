package com.office.rebates.controller.web;

import com.office.rebates.controller.RouteKey;
import com.office.rebates.model.Soho3qProjectModel;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.service.Soho3qAccessService;
import com.office.rebates.service.web.WebSalesService;
import com.office.rebates.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 下单控制器
 * Created by liyongfeng on 2016/3/20.
 */
@Controller
@RequestMapping(RouteKey.SALES)
public class WebSalesController {

    /**
     * 下单服务
     */
    @Autowired
    private WebSalesService webSalesService;

    /**
     * 下券订单
     */
    @RequestMapping(RouteKey.COUPON_ORDER)
    public void couponOrder(Model model){
        model.addAttribute("couponList",webSalesService.getCouponList());
    }

    /**
     * 下传统订单页
     * @param model 载体
     */
    @RequestMapping(RouteKey.STATION_ORDER)
    public void stationOrder(Model model){
        String date = DateUtil.getFormatDate(new Date(),"yyyy-MM-dd");
        List<Soho3qProjectModel> projectList=webSalesService.getProjectList();
        model.addAttribute("project",projectList);
        model.addAttribute("startTime", date);
        model.addAttribute("productList", webSalesService.getProductList(projectList.get(0).getProjectId(),date,DateUtil.addDayOfYear(date,30)));
    }
    
    /**
     * 我的订单列表
     * @param model 载体
     */
    @RequestMapping(RouteKey.ORDER_LIST)
    public void myOrder(Model model){
        String date = DateUtil.getFormatDate(new Date(),"yyyy-MM-dd");
        List<Soho3qProjectModel> projectList=webSalesService.getProjectList();
        model.addAttribute("project",projectList);
        model.addAttribute("startTime", date);
        model.addAttribute("productList", webSalesService.getProductList(projectList.get(0).getProjectId(),date,DateUtil.addDayOfYear(date,30)));
    }
}
