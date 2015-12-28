package com.soho3q.cms.admin.controller;


import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.soho3q.cms.admin.RouteKey;
import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.model.admin.CmsKeyModel;
import com.soho3q.cms.model.admin.CmsValueModel;
import com.soho3q.cms.service.admin.CmsChannelService;
import com.soho3q.cms.service.admin.CmsValueService;

@Controller
@RequestMapping(RouteKey.PREFIX_CMS_DETAIL)
public class CMSDetailController {

	private Logger logger=Logger.getLogger(CMSDetailController.class);
	
	@Autowired
	private CmsValueService cmsValueService;
	
	@Autowired
	private CmsChannelService cmsChannelService;
	
	/**
	 * 
	 * 频道与key是唯一标示符
	 * 获取value值信息
	 * @param channel_name
	 * @param cms_key
	 */
	@RequestMapping(RouteKey.PREFIX_CMS_DETAIL_INDEX)
	public ModelAndView getCMSValue(String channel_name,String cms_key){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("cms/value_edit");
		try{
			if(channel_name==null || "".equals(channel_name)){
				logger.info("param channel_name is null");
				mv.addObject("cmsKey", new CmsKeyModel());
				mv.addObject("cmsValue", new ArrayList<CmsValueModel>());
				return mv;
			}
			CmsChannelModel channel = cmsChannelService.selectCmsChannelByName(channel_name);
	    	mv.addObject("channel", channel);
			mv.addObject("channel_name", channel_name);
			if(cms_key==null || "".equals(cms_key)){
				logger.info("param cms_key is null");
				mv.addObject("cmsKey", new CmsKeyModel());
				mv.addObject("cmsValue", new ArrayList<CmsValueModel>());
				return mv;
			}
			mv.addObject("cms_key", cms_key);
			mv.addObject("cmsKey", cmsValueService.getCmsKey( channel_name, cms_key));
			mv.addObject("cmsValue", cmsValueService.getCmsValueList( channel_name, cms_key));
		}catch(Exception e){
			logger.error("error", e);
		}
		
		return mv;
	}
	
	/**
	 * 添加c-value值
	 * @param channel_name
	 * @param cms_key
	 */
	@RequestMapping(RouteKey.PREFIX_CMS_DETAIL_ADD)
	public String addCMSValue(CmsValueModel cmsValueModel){
		if(cmsValueModel==null){
			logger.info("param is null");
			return "redirect:"+RouteKey.PREFIX_CMS_DETAIL+RouteKey.PREFIX_CMS_DETAIL_INDEX+"?channel_name=''&cms_key=''";
		}
		if(cmsValueModel.getChannelName()==null ||  "".equals(cmsValueModel.getChannelName())){
			logger.info("param ChannelName is null");
			return "redirect:"+RouteKey.PREFIX_CMS_DETAIL+RouteKey.PREFIX_CMS_DETAIL_INDEX+"?channel_name=''&cms_key=''";
		}
		if(cmsValueModel.getCmsKey()==null ||  "".equals(cmsValueModel.getCmsKey())){
			logger.info("param CmsKey is null");
			return "redirect:"+RouteKey.PREFIX_CMS_DETAIL+RouteKey.PREFIX_CMS_DETAIL_INDEX+"?channel_name=''&cms_key=''";
		}
		int num=cmsValueService.addCmsValue(cmsValueModel);
		if(num==0){
			logger.error("save final!");
		}
		return "redirect:"+RouteKey.PREFIX_CMS_DETAIL+RouteKey.PREFIX_CMS_DETAIL_INDEX+"?channel_name="+cmsValueModel.getChannelName()+"&cms_key="+cmsValueModel.getCmsKey();
	}
	/**
	 * 修改c-value值
	 * @param valueId
	 * @param channel_name
	 * @param cms_key
	 */
	@RequestMapping(value=RouteKey.PREFIX_CMS_DETAIL_UPDATE,method=RequestMethod.POST)
	@ResponseBody
	public String updateCMSValue(CmsValueModel cmsValueModel){
		if(cmsValueModel==null){
			logger.info("param is null");
			return "0";
		}
		if(cmsValueModel.getValueId()==null){
			logger.info("param ValueId is null");
			return "0";
		}
		if(cmsValueModel.getChannelName()==null ||  "".equals(cmsValueModel.getChannelName())){
			logger.info("param ChannelName is null");
			return "0";
		}
		if(cmsValueModel.getCmsKey()==null ||  "".equals(cmsValueModel.getCmsKey())){
			logger.info("param CmsKey is null");
			return "0";
		}
		try{
			int num=cmsValueService.updateCmsValue(cmsValueModel);
			if(num==0){
				logger.info("update final!");
				return "0";
			}
		}catch(Exception e){
			logger.error("error:",e);
			return "0";
		}
		
		
		return "1";
	}
	
	/**
	 * 删除c-value值
	 * @param valueId
	 * @param channel_name
	 * @param cms_key
	 */
	@RequestMapping(RouteKey.PREFIX_CMS_DETAIL_DELETE)
	public String delCMSValue(Long valueId,String channelName,String cmsKey){
		if(valueId==null){
			logger.info("param valueId is null");
			return "redirect:"+RouteKey.PREFIX_CMS_DETAIL+RouteKey.PREFIX_CMS_DETAIL_INDEX+"?channel_name=''&cms_key=''";
		}
		if(channelName==null || "".equals(channelName)){
			logger.info("param channelName is null");
			return "redirect:"+RouteKey.PREFIX_CMS_DETAIL+RouteKey.PREFIX_CMS_DETAIL_INDEX+"?channel_name=''&cms_key=''";
		}
		if(cmsKey==null || "".equals(cmsKey)){
			logger.info("param cmsKey is null");
			return "redirect:"+RouteKey.PREFIX_CMS_DETAIL+RouteKey.PREFIX_CMS_DETAIL_INDEX+"?channel_name=''&cms_key=''";
		}
		System.out.println("------------------------------------getChannelName:"+channelName);
		cmsValueService.deleteCmsValue(valueId);
		return "redirect:"+RouteKey.PREFIX_CMS_DETAIL+RouteKey.PREFIX_CMS_DETAIL_INDEX+"?channel_name="+channelName+"&cms_key="+cmsKey;
	}
	
	/**
	 * 获取历史信息
	 * @return
	 */
	@RequestMapping(RouteKey.PREFIX_CMS_HISTORY_INDEX)
	@ResponseBody
	public String getCmsValueHistory(Long valueId,Model model){
		if(valueId==null){
			logger.info("param valueId is null");
			return "";
		}
		return JSONArray.toJSONString(cmsValueService.getCmsValueHistory(valueId));
	}
	
	/**
	 * 根据id获取 cma-value
	 * @param valueId
	 * @param model
	 * @return
	 */
	@RequestMapping(RouteKey.PREFIX_CMS_DETAIL_SEL)
	@ResponseBody
	public String getCmsValue(Long valueId){
		if(valueId==null){
			logger.info("param valueId is null");
			return "";
		}
		return JSONArray.toJSONString(cmsValueService.getCmsValue(valueId));
	}
	
	
	/**
	 * 根据id获取 cma-value  iframe使用
	 * @param valueId
	 * @param model
	 * @return
	 */
	@RequestMapping(RouteKey.PREFIX_CMS_DETAIL_IFRAME)
	@ResponseBody
	public ModelAndView getCmsValueForIframe(Long valueId){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("cms/ueditor");
		mv.addObject("valueId",valueId);
		if(valueId==null){
			logger.info("param valueId is null");
			return mv;
		}
		CmsValueModel cmsValueModel=cmsValueService.getCmsValue(valueId);
		if(cmsValueModel!=null && cmsValueModel.getChannelName()!=null && !"".equals(cmsValueModel.getChannelName())){
			mv.addObject("cmsValue",cmsValueModel.getCmsValue());
			
			CmsChannelModel channel = null;
			try {
				channel = cmsChannelService.selectCmsChannelByName(cmsValueModel.getChannelName());
			} catch (Exception e) {
				logger.error("error", e);
				e.printStackTrace();
			}
	    	mv.addObject("channel", channel);
			mv.addObject("channel_name", cmsValueModel.getChannelName());
			
			if(cmsValueModel.getCmsKey()!=null && !"".equals(cmsValueModel.getCmsKey()) ){
				CmsKeyModel cmsKeyModel=cmsValueService.getCmsKey( cmsValueModel.getChannelName(), cmsValueModel.getCmsKey());
				mv.addObject("keyType", cmsKeyModel.getKeyType());
			}
		}
		return mv;
	}
	
	
	
}
