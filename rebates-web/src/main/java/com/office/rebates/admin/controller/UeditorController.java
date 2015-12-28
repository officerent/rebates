package com.soho3q.cms.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;
import com.soho3q.cms.model.common.PropertiesUtils;
import com.soho3q.web.utils.LogicUtil;

@Controller
@RequestMapping(value = "/ueditor")
public class UeditorController {
	
	static Logger logger = Logger.getLogger(UeditorController.class);
	
	public static void main(String[] args) {
		String aaa="hfasdjfgajsdbfj bvbdjfbkjkdfghjdsfhgkhkPathFormat':'/ueditor/jsp/a.jsp";
		String aa="PathFormat':'/ueditor";
		System.out.println(aaa.replaceAll(aa, "PathFormat':'/cms/ueditor"));
	}
	
	 @RequestMapping("/jsp/controller.s")
     public void config(HttpServletRequest request,  HttpServletResponse response, String action) {
                     
//          	System.out.println("========================action:"+action);
             try {
           	   response.setContentType("application/json");  
               String rootPath = request.getSession().getServletContext().getRealPath("/");
//               rootPath="E://";
//               System.out.println("----rootPath:"+rootPath);
                 String exec = new ActionEnter(request, rootPath+"\\WEB-INF").exec();
//                 String exec = new ActionEnter(request, rootPath).exec();
               
                 logger.info("edit save path for :"+exec);
                 PrintWriter writer = response.getWriter();
                 writer.write(exec);
                 writer.flush();
                 writer.close();
             } catch (IOException e) {
                     e.printStackTrace();
             }
             
     }
}
