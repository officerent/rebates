package com.office.rebates.service.web.impl;

import com.office.rebates.model.Soho3qProductModel;
import com.office.rebates.model.Soho3qProjectModel;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.service.Soho3qAccessService;
import com.office.rebates.service.web.WebSalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 下单服务
 * Created by liyongfeng on 2016/3/26.
 */
@Service
public class WebSalesServiceImpl implements WebSalesService{


    /**
     * 3q对外接口
     */
    @Autowired
    private Soho3qAccessService soho3qAccessService;

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(WebSalesServiceImpl.class);

    /**
     * 获取项目列表
     * @return
     */
    @Override
    public List<Soho3qProjectModel> getProjectList() {
        List<Soho3qProjectModel> projectList = new ArrayList<Soho3qProjectModel>();
        try {
            projectList = soho3qAccessService.getProjectList();
        } catch (RebatesException e) {
            logger.error("WebSalesController.stationOrder",e);
        }
        return projectList;
    }

    /**
     * 获取产品列表
     * @param projectId 项目id
     * @param checkInDate 入驻时间
     * @param checkOutDate 离场时间
     * @return
     */
    @Override
    public List<Soho3qProductModel> getProductList(String projectId, String checkInDate, String checkOutDate) {
        List<Soho3qProductModel> soho3qProductModels = new ArrayList<Soho3qProductModel>();
        try {
            soho3qProductModels=soho3qAccessService.getProductList(projectId,checkInDate,checkOutDate);
        } catch (RebatesException e) {
            logger.error("WebSalesController.getProductList", e);
        }
        return soho3qProductModels;
    }
}
