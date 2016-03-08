package com.office.rebates.controller.admin;

import com.office.rebates.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 订单控制器
 * Created by liyongfeng on 2016/3/6.
 */
public class AdminOrderController {

    /**
     * 订单服务
     */
    @Autowired
    private AdminOrderService adminOrderService;

}
