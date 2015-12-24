package com.soho3q.cms.model.common;

public class Constant {

	public static String LANG_CN = "zh_CN";
	public static String LANG_EN = "en_US";
	
	public static String DEFAULT_CREATER = "admin";
	public static String DEFAULT_UPDATER = "admin";
	
	public static byte KEY_DISABLED_AVAILABLE = 1; //正常
	public static byte KEY_DISABLED_DELETE = 0;//删除

	public static byte C_VALUE_NORMAL=1;
	public static byte C_VALUE_DISABLE=0;

	//通配符
	public final static String WILDCARD="*";
	
	
	//os
	public final static String OS_IOS="IOS";
	public final static String OS_ANDRIOD="Andriod";
	public final static String OS_WINDOWS="Windows";
	public final static String OS_MAC="Mac";
	
	
	public final static String ISAPP="Y";
	
	//client
	public final static String CLIENT_APP="APP";
	public final static String CLIENT_WEB="Web";//pc端
	public final static String CLIENT_H5="H5";//移动设备
	public final static String CLIENT_WECHAT="WeChat";//微信设备
	
}
