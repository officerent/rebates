package com.soho3q.cms.api.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.soho3q.cms.admin.RouteKey;
import com.soho3q.cms.admin.controller.CMSDetailController;
import com.soho3q.cms.model.admin.CmsValueModel;
import com.soho3q.cms.model.common.Messages;
import com.soho3q.cms.model.common.ResultCode;
import com.soho3q.cms.service.admin.CmsValueApiService;
import com.soho3q.web.model.AjaxTypeResult;

/**
 * 
 * 修改clinetType 为isApp
 * client充userAgent中判断
 * @author pangWeiDong
 * @version 1.1 (2015-11-04)
 *
 */
@Controller
@RequestMapping(RouteKey.API_CMS)
public class KeyValueController {

	private Logger logger=Logger.getLogger(CMSDetailController.class);
	
	@Autowired
	private CmsValueApiService cmsValueApiService;
	
	@RequestMapping(RouteKey.API_CMS_VALUE)
	@ResponseBody
	public AjaxTypeResult<CmsValueModel> getValueByKey(String channelName,String cmsKey,String language,
			String isApp,String userAgent,String businessId){
		logger.info("===================================开始=========================================================="+System.currentTimeMillis());
		long startTime=System.currentTimeMillis();
		AjaxTypeResult<CmsValueModel> ajaxTypeResult=new AjaxTypeResult<CmsValueModel>();
		ajaxTypeResult.setStatus(Messages.AJAX_RESULT_SUCCESS_STATUS);
		ajaxTypeResult.setMessage(Messages.AJAX_RESULT_SUCCESS_MSG);
		ajaxTypeResult.setCode(Messages.AJAX_RESULT_SUCCESS_CODE);
		ajaxTypeResult.setResult(null);
		if(channelName==null || "".equals(channelName)){
			logger.error("param channel_name is null");
			ajaxTypeResult.setStatus(Messages.AJAX_RESULT_FAILED_STATUS);
			ajaxTypeResult.setMessage(Messages.AJAX_RESULT_FAILED_MSG);
			ajaxTypeResult.setCode(Messages.AJAX_RESULT_FAILED_CODE);
			return ajaxTypeResult;
		}
		if(cmsKey==null || "".equals(cmsKey)){
			logger.error("param cms_key is null");
			ajaxTypeResult.setStatus(Messages.AJAX_RESULT_FAILED_STATUS);
			ajaxTypeResult.setMessage(Messages.AJAX_RESULT_FAILED_MSG);
			ajaxTypeResult.setCode(Messages.AJAX_RESULT_FAILED_CODE);
			return ajaxTypeResult;
		}
		try{
			CmsValueModel cmsValueModelt=cmsValueApiService.getCmsValue(channelName, cmsKey, language,isApp,userAgent, businessId);
			ajaxTypeResult.setResult(cmsValueModelt);
		}catch(Exception e){
			ajaxTypeResult.setStatus(Messages.AJAX_RESULT_FAILED_STATUS);
			ajaxTypeResult.setMessage(Messages.AJAX_RESULT_FAILED_MSG);
			ajaxTypeResult.setCode(Messages.AJAX_RESULT_FAILED_CODE);
			logger.error("KeyValueController.getValueByKey Exception",e);
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		logger.info("耗时："+(endTime-startTime));
		logger.info("===================================结束=========================================================="+endTime);
		return ajaxTypeResult;
	}
	
	
	@RequestMapping(RouteKey.API_CMS_VALUES)
	@ResponseBody
	public AjaxTypeResult<List<CmsValueModel>> getValueByKeyList(String channelName,String cmsKeys,String language,
			String isApp,String userAgent,String businessId){
		logger.info("===================================开始==========================================================");
		AjaxTypeResult<List<CmsValueModel>> ajaxTypeResult=new AjaxTypeResult<List<CmsValueModel>>();
		
		ajaxTypeResult.setStatus(Messages.AJAX_RESULT_SUCCESS_STATUS);
		ajaxTypeResult.setMessage(Messages.AJAX_RESULT_SUCCESS_MSG);
		ajaxTypeResult.setCode(Messages.AJAX_RESULT_SUCCESS_CODE);
		ajaxTypeResult.setResult(null);
		if(channelName==null || "".equals(channelName)){
			logger.error("param channel_name is null");
			ajaxTypeResult.setStatus(Messages.AJAX_RESULT_FAILED_STATUS);
			ajaxTypeResult.setMessage(Messages.AJAX_RESULT_FAILED_MSG);
			ajaxTypeResult.setCode(Messages.AJAX_RESULT_FAILED_CODE);
			return ajaxTypeResult;
		}
		if(cmsKeys==null || "".equals(cmsKeys)){
			logger.error("param cms_key is null");
			ajaxTypeResult.setStatus(Messages.AJAX_RESULT_FAILED_STATUS);
			ajaxTypeResult.setMessage(Messages.AJAX_RESULT_FAILED_MSG);
			ajaxTypeResult.setCode(Messages.AJAX_RESULT_FAILED_CODE);
			return ajaxTypeResult;
		}
		try{
			List<CmsValueModel> cmsValueModeltList=cmsValueApiService.getCmsValueList(channelName, cmsKeys, language,isApp,userAgent, businessId);
			ajaxTypeResult.setResult(cmsValueModeltList);
		}catch(Exception e){
			ajaxTypeResult.setStatus(Messages.AJAX_RESULT_FAILED_STATUS);
			ajaxTypeResult.setMessage(Messages.AJAX_RESULT_FAILED_MSG);
			ajaxTypeResult.setCode(Messages.AJAX_RESULT_FAILED_CODE);
			logger.error("KeyValueController.getValueByKey Exception",e);
			e.printStackTrace();
		}
		logger.info("===================================结束==========================================================");
		return ajaxTypeResult;
	}
}
