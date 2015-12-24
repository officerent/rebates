package com.soho3q.cms.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.alibaba.fastjson.JSONObject;
import com.soho3q.cms.admin.RouteKey;
import com.soho3q.cms.model.admin.CmsChannelModel;
import com.soho3q.cms.model.admin.CmsKeyModel;
import com.soho3q.cms.model.admin.CmsTagModel;
import com.soho3q.cms.model.admin.CmsValueModel;
import com.soho3q.cms.model.common.Constant;
import com.soho3q.cms.model.common.Messages;
import com.soho3q.cms.model.common.PageData;
import com.soho3q.cms.model.common.ResultCode;
import com.soho3q.cms.service.admin.CMSService;
import com.soho3q.cms.service.admin.CmsChannelService;
import com.soho3q.cms.service.admin.CmsKeyService;
import com.soho3q.cms.service.admin.CmsTagService;
import com.soho3q.cms.service.admin.CmsValueService;
import com.soho3q.web.utils.LogicUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



/**
 * CMS
 * Created by zuoluliang on 15/10/13.
 */
@Controller
@RequestMapping(RouteKey.PREFIX_CMS)
public class CMSController {

    static Logger logger = Logger.getLogger(CMSController.class);
    
    @Autowired
    private CMSService cmsService;
    
    @Autowired
    private CmsChannelService cmsChannelService;
    
    @Autowired
    private CmsTagService cmsTagService;
    
    @Autowired
    private CmsKeyService cmsKeyService;
    
    @Autowired
    private CmsValueService cmsValueService;
    /**
     * 去往首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
    	logger.info("Will go to index !");
    	ModelAndView mv = new ModelAndView();
    	ArrayList<CmsChannelModel> channelList = cmsService.getChannelList();
    	mv.addObject("channelList", channelList);
    	mv.setViewName("index");
    	return mv;
    }
    
    /**
     * 去往 keylist 页面
     * @return
     * @throws Exception 
     */
    @RequestMapping("keylistview")
    public ModelAndView keyView(String channelName) throws Exception{
    	logger.info("Will go to keylist by channelName:"+channelName);
    	ModelAndView mv = new ModelAndView();
    	CmsChannelModel channel = cmsChannelService.selectCmsChannelByName(channelName);
    	mv.addObject("channel", channel);
    	mv.addObject("channelName", channelName);
    	CmsKeyModel key = new CmsKeyModel();
    	key.setChannelName(channelName);
    	List<CmsTagModel> tagList = cmsTagService.getCmsTagList(channelName);
    	mv.addObject("tagList", tagList);
    	PageData<CmsKeyModel> keyList = cmsKeyService.getCmsKeyList(key,10,1);
    	mv.addObject("pageData", keyList);
    	//System.out.println(keyList.getPageTotal());
    	mv.setViewName("/cms/key_list_view");
    	return mv;
    }
    
    /**
     * 去往新增 或者修改 Key
     * @return
     * @throws Exception 
     */
    @RequestMapping("tonewkey")
    public ModelAndView tocreateKey(String channelName,Long keyId) throws Exception{
    	logger.info("Will go to pre add key by channelName:"+channelName+",keyId:"+keyId);
    	ModelAndView mv = new ModelAndView();
    	ArrayList<CmsTagModel> tagList = cmsTagService.getCmsTagList(channelName);
    	CmsChannelModel channel = cmsChannelService.selectCmsChannelByName(channelName);
    	mv.addObject("channel", channel);
    	mv.addObject("channelName", channelName);
    	mv.addObject("tagList", tagList);
    	if(LogicUtil.isNotNull(keyId)){
    		CmsKeyModel keymv = cmsKeyService.getCmsKeyModelById(keyId);
    		mv.addObject("key", keymv);
    	}else{
    		mv.addObject("key", new CmsKeyModel());
    	}
    	mv.setViewName("/cms/key_create");
    	return mv;
    }
    
    /**
     * 去往修改 Key 页面
     * @return
     * @throws Exception 
     */
    @RequestMapping("toupdatekey")
    public ModelAndView toUpdateKey(String channelName,Long keyId) throws Exception{
    	logger.info("Will go to pre update key by channelName:"+channelName+",keyId:"+keyId);
    	ModelAndView mv = new ModelAndView();
    	ArrayList<CmsTagModel> tagList = cmsTagService.getCmsTagList(channelName);
    	CmsChannelModel channel = cmsChannelService.selectCmsChannelByName(channelName);
    	mv.addObject("channel", channel);
    	mv.addObject("channelName", channelName);
    	mv.addObject("tagList", tagList);
    	if(LogicUtil.isNotNull(keyId)){
    		CmsKeyModel keymv = cmsKeyService.getCmsKeyModelById(keyId);
    		mv.addObject("key", keymv);
    	}else{
    		mv.addObject("key", new CmsKeyModel());
    	}
    	mv.setViewName("/cms/key_update");
    	return mv;
    }
    
    /**
     * 分页查询 Key 数据
     * HTML
     * @throws Exception 
     */
    @ResponseBody
    @RequestMapping("pagekeylist")
    public ModelAndView pageKeyListsub(CmsKeyModel key,Integer pageSize,Integer pageNum) throws Exception{
    	logger.info("Will go to select page key by key:"+JSONObject.toJSONString(key)+",pageNum:"+pageNum+",pageSize:"+pageSize);
    	ModelAndView mv = new ModelAndView();
    	if(pageSize==null){
    		pageSize=10;
    	}
    	if(pageNum==null){
    		pageNum=1;
    	}
    	PageData<CmsKeyModel> keyList = cmsKeyService.getCmsKeyList(key,pageSize,pageNum);
    	mv.addObject("channelName", key.getChannelName());
    	mv.addObject("pageData", keyList);
    	
    	mv.setViewName("/cms/key_list_sub_view");
    	return mv;
    }
    
    /**
     * 分页查询 Key
     * HTML
     * @throws Exception 
     */
    @ResponseBody
    @RequestMapping("searchkeylist")
    public ModelAndView searchKeyList(CmsKeyModel key,Integer pageSize,Integer pageNum) throws Exception{
    	logger.info("Will go to search page key by key:"+JSONObject.toJSONString(key)+",pageNum:"+pageNum+",pageSize:"+pageSize);
    	ModelAndView mv = new ModelAndView();
    	if(pageSize==null){
    		pageSize=10;
    	}
    	if(pageNum==null){
    		pageNum=1;
    	}
    	PageData<CmsKeyModel> keyList = cmsKeyService.getCmsKeyList(key,pageSize,pageNum);
    	mv.addObject("channelName", key.getChannelName());
    	mv.addObject("pageData", keyList);
    	mv.setViewName("/cms/key_list_sub_view");
    	return mv;
    }
    /**
     * 通过Key 查询 Key
     * @param channelName
     * @param cmsKey
     * @return
     */
    @RequestMapping(value="selectbykey",method=RequestMethod.POST)
    @ResponseBody
    public String selectCMSKeyByKey(String channelName,String cmsKey){
    	ResultCode result = new ResultCode();
    	try {
			int num = cmsKeyService.selectCMSKeyByKey(channelName, cmsKey);
			if(num>0){
				result.setData(num);
				result.setMessage(Messages.FAILED_MSG);
				result.setStatus(Messages.FAILED_STATUS);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return JSONObject.toJSONString(result);
    }
    
    /**
     * 增加 Key
     * @return
     * @throws Exception 
     */
    @RequestMapping(value="addnewkey",method=RequestMethod.POST)
    public ModelAndView createKey(CmsKeyModel key,String channelName) throws Exception{
    	logger.info("Will to addKey for key param: "+JSONObject.toJSON(key)+" ,channelName:"+channelName);
    	ModelAndView mv = new ModelAndView();
    	int num = cmsKeyService.addKey(key);
    	CmsChannelModel channel = cmsChannelService.selectCmsChannelByName(channelName);
    	mv.addObject("channel", channel);
    	mv.addObject("channelName", channelName);
    	if(num>0){
    		CmsKeyModel keyv = new CmsKeyModel();
    		keyv.setChannelName(channelName);
    		List<CmsTagModel> tagList = cmsTagService.getCmsTagList(channelName);
        	mv.addObject("tagList", tagList);
    		PageData<CmsKeyModel> keyList = cmsKeyService.getCmsKeyList(keyv,10,1);
    		mv.addObject("pageData", keyList);
        	mv.setViewName("/cms/key_list_view");
    	}else{
        	ArrayList<CmsTagModel> tagList = cmsTagService.getCmsTagList(channelName);
        	mv.addObject("tagList", tagList);
        	mv.addObject("key", key);
        	mv.setViewName("/cms/key_create");
    	}
    	
    	return mv;
    }
    
    /**
     * 修改 Key
     * @param args
     * @throws Exception 
     */
    @RequestMapping(value="updatekey",method=RequestMethod.POST)
    public ModelAndView updateKey(CmsKeyModel key,String channelName) throws Exception{
    	logger.info("Will to updateKey for param: "+JSONObject.toJSON(key)+" ,channelName:"+channelName);
    	ModelAndView mv = new ModelAndView();
    	int num = cmsKeyService.updateKey(key);
    	CmsChannelModel channel = cmsChannelService.selectCmsChannelByName(channelName);
    	mv.addObject("channel", channel);
    	mv.addObject("channelName", channelName);
    	if(num>0){
    		CmsKeyModel keyv = new CmsKeyModel();
    		keyv.setChannelName(channelName);
    		List<CmsTagModel> tagList = cmsTagService.getCmsTagList(channelName);
        	mv.addObject("tagList", tagList);
    		PageData<CmsKeyModel> keyList = cmsKeyService.getCmsKeyList(keyv,10,1);
    		mv.addObject("pageData", keyList);
        	mv.setViewName("/cms/key_list_view");
    	}else{
        	ArrayList<CmsTagModel> tagList = cmsTagService.getCmsTagList(channelName);
        	mv.addObject("tagList", tagList);
    		CmsKeyModel keymv = cmsKeyService.getCmsKeyModelById(key.getKeyId());
    		mv.addObject("key", keymv);
        	mv.setViewName("/cms/key_update");
    	}
    	return mv;
    }
    
    /**
     * 修改 KEY 状态
     * @param args
     */
    @RequestMapping(value="modifykeystatus",method=RequestMethod.POST)
    public ModelAndView updateKeyStatus(CmsKeyModel key,String channelName,Integer pageSize,Integer pageNum){
    	logger.info("Will to modifyKey for param: "+JSONObject.toJSON(key)+" ,channelName:"+channelName+",pageNum:"+pageNum+",pageSize:"+pageSize);
    	ModelAndView mv = new ModelAndView();
    	//更新状态
    	cmsKeyService.updateKeyStatus(key);
    	
    	if(pageSize==null){
    		pageSize=10;
    	}
    	if(pageNum==null){
    		pageNum=1;
    	}
    	PageData<CmsKeyModel> keyList = cmsKeyService.getCmsKeyList(key,pageSize,pageNum);
    	mv.addObject("channelName", key.getChannelName());
    	mv.addObject("pageData", keyList);
    	mv.setViewName("/cms/key_list_sub_view");
    	return mv;
    }
    
    /**
     * 增加 tag
     * @param args
     * @throws Exception 
     */
    @RequestMapping(value="addtag",method=RequestMethod.POST)
    public ModelAndView addTag(CmsTagModel model,CmsKeyModel key) throws Exception{
    	logger.info("Will go to add Tag for tag:"+JSONObject.toJSONString(model)+",keyId:"+key.getKeyId());
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("channelName", model.getChannelName());
    	CmsChannelModel channel = cmsChannelService.selectCmsChannelByName(model.getChannelName());
    	mv.addObject("channel", channel);
    	try {
    		//新增
    		CmsTagModel tag = cmsTagService.addTag(model);
    		
		} catch (Exception e) {}
    	ArrayList<CmsTagModel> tagList = cmsTagService.getCmsTagList(model.getChannelName());
    	mv.addObject("tagList", tagList);
    	//mv.addObject("key", key);
    	if(LogicUtil.isNotNull(key.getKeyId())){
    		CmsKeyModel keymv = cmsKeyService.getCmsKeyModelById(key.getKeyId());
    		mv.addObject("key", keymv);
    		mv.setViewName("/cms/key_update");
    	}else{
    		mv.addObject("key", key);
    		mv.setViewName("/cms/key_create");
    	}
    	return mv;
    }
    
    @RequestMapping(value="delkey")
    public String delKey(Long KeyId,String channelName){
    	logger.info("KeyId:"+KeyId+"  channelName:"+channelName);
    	CmsKeyModel cmsKeyModel=cmsKeyService.getCmsKeyModelById(KeyId);
    	int num=cmsKeyService.deleteKey(KeyId);
    	if(num>0){
    		List<CmsValueModel> cmsValueModelList=cmsValueService.getCmsValueList(channelName,cmsKeyModel.getCmsKey());
    		if(cmsValueModelList!=null && cmsValueModelList.size()>0){
    			for (CmsValueModel cmsValueModel : cmsValueModelList) {
    				cmsValueModel.setEnabled(Constant.C_VALUE_DISABLE);
    				cmsValueService.updateCmsValue(cmsValueModel);
    			}
    		}
    	}else{
    		logger.error("删除失败");
    		System.out.println("删除失败");
    	}
    	return "redirect:"+RouteKey.PREFIX_CMS+"/keylistview?channelName="+channelName;
    }
    
    public static void main(String[] args) {
        //SendSMSClient sendSMSClient=new SendSMSClient();
        //SendSMSClient.sendMsgCode("123456","15110288269");
        /*int code = new Random().nextInt(899999);
        System.out.println(code);
    	String userId = "23";
    	String str = String.format("a=%s", userId);
    	System.out.print("输入:");
    	Scanner scan = new Scanner(System.in);
    	int total = scan.nextInt();
    	int size = 2;*/
    	String str1 = "\"PathFormat\":\"/ueditor\"";
    	//System.out.println("输入数据："+((total/size)+1)); 
    	
    	//System.out.println(str);
    }

}
