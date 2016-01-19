package com.office.rebates.model.common;

public class Constants {
	public static String LANG_CN = "zh_CN";
	public static String LANG_EN = "en_US";

	public static String SYSTEM = "SYSTEM";
	
	//rebates bonus status
	public static Byte BONUS_STATUS_ORDER_PLACED = 0;//需求单待确认
	public static Byte BONUS_STATUS_ORDER_CONFIRM = 1; //需求单已确认
	public static Byte BONUS_STATUS_ORDER_PAID = 2; //客户已支付订单
	public static Byte BONUS_STATUS_BONUS_PAID = 3;  //销售已收到佣金
	public static Byte BONUS_STATUS_REBATES_PAID = 4; //客户已经收到返利
	public static Byte BONUS_STATUS_ORDER_CANCELED = 5; //需求单已取消

	//是否是管理员
	public static Byte IS_ADMIN_Y = 1;
	public static Byte IS_ADMIN_N = 0;

	//用户状态
	public static Byte STATUS_NORMAL = 0;
	public static Byte STATUS_FROZEN = 1;
	public static Byte STATUS_DELETE = 2;

	//cookie
	public static String COOKIE_USER_TOKEN = "user_token";
	
	//user admin
	public static Byte USER_NOT_ADMIN = 0;//不是管理员
	public static Byte USER_ADMIN = 1; //是管理员
	
	//user status
	public static Byte USER_STATUS_NORMAL = 0;//正常
	public static Byte USER_STATUS_FROZEN = 1; //冻结
	public static Byte USER_STATUS_DELETED = 2; //删除

}
