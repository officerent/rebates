package com.office.rebates.service.web;

import com.office.rebates.model.Soho3qProductModel;
import com.office.rebates.model.Soho3qProjectModel;

import java.util.List;

/**
 * 下单服务
 * Created by liyongfeng on 2016/3/26.
 */
public interface WebSalesService {

    /**
     * 获取项目
     * @return
     */
    public List<Soho3qProjectModel> getProjectList();

    /**
     * 获取产品列表
     * @return
     */
    public List<Soho3qProductModel> getProductList(String projectId,String checkInDate,String checkOutDate);
}
