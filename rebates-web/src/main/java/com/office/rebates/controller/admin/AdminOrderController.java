package com.office.rebates.controller.admin;

import com.office.rebates.controller.RouteKey;
import com.office.rebates.model.admin.RebatesOrderModel;
import com.office.rebates.model.common.Page;
import com.office.rebates.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单控制器
 * Created by liyongfeng on 2016/3/6.
 */
@Controller
@RequestMapping(RouteKey.ORDER)
public class AdminOrderController {

    /**
     * 订单服务
     */
    @Autowired
    private AdminOrderService adminOrderService;

    /**
     * 获取订单列表
     * @param page 分页
     * @param rebatesOrderModel 订单实体
     * @param model 载体
     */
    @RequestMapping(RouteKey.ORDER_LIST)
    public void orderList(Page page,RebatesOrderModel rebatesOrderModel,Model model){
        model.addAttribute("orderList",adminOrderService.selectRebatesOrderList(page,rebatesOrderModel));
        model.addAttribute("page",page);
        model.addAttribute("order",rebatesOrderModel);
    }

    /**
     * 查询订单详情
     * @param orderId 订单id
     * @param model 载体
     */
    @RequestMapping(RouteKey.SEE_ONE_ORDER)
    public void seeOneOrder(long orderId,Model model){
        model.addAttribute("order",adminOrderService.selectRebatesOrderOne(orderId));
        model.addAttribute("orderItemList",adminOrderService.selectOrderItemList(orderId));
    }
}
