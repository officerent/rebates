package com.office.rebates.controller.web;

import com.office.rebates.controller.RouteKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 下单控制器
 * Created by liyongfeng on 2016/3/20.
 */
@Controller
@RequestMapping(RouteKey.SALES)
public class WebSalesController {

    @RequestMapping(RouteKey.COUPON_ORDER)
    public void couponOrder(){

    }

    @RequestMapping(RouteKey.STATION_ORDER)
    public void stationOrder(){

    }
}
