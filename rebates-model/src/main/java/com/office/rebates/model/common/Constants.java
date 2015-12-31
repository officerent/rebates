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

		
}
