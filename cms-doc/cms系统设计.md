# CMS系统设计
----
	author：luozhi
	
	
	
	
### 一、CMS概述

* CMS系统功能概述：
	1. SOHO3Q静态内容维护后台，提供内容编辑以及发布等功能，支持各种子系统（如众包、拍卖等），支持各种终端（如PC Web,H5,APP等）；内容的值类型包含主要常用的（如HTML、IMG、Json、Int、String等）；由业务或编辑人员管理
	2. key-value配置键值管理，支持将经常会变化的值维护到此CMS系统；由技术人员维护管理, 使用Tag=“技术参数”和其他CMSKey区分

### 二、模型设计


1. 频道（Channel）：按频道划分CMS的key的管理，值如： 主站、拍卖、众包、My3Q
 
	Channel | Name | 状态 | 创建时间 | 创建者
------- | ----- | --- | ------- | ------------
 Home | 首页主站 | 删除 | luozhi  | 2015-9-1 12:3 
 
2. Tag：标签用于方便后台管理及搜索, 一般为页面名称


	TagID | Channel | TagName  | 创建时间 | 创建者 | 修改时间 | 修改者
--------- | ------- | ----- | ------- | ----| --- | ----
1 | Home | 首页 |luozhi | 2015-9-1 12:3 
2 | Home | 列表页 |luozhi | 2015-9-1 12:3 

3. CMSKey： Key表
	* valueType: json, int, string, bool, html
	* 状态：停用、启用、假删除 
	
	CMSContentID | Key | 名称 | 描述 |  valueType | 状态 | Channel | TagID | 创建时间 | 创建者  
------------ | --------| ----- | ---|--------- | ----- | ------- | ---- | ------|---
1 | HOME_HEADBIMG | | | json | | HOME | 1,2 |  
2 | HOME_HEAD | | |  | |  HOME | 
   


4. CMSValue：主题为Key-value，即按key对应相应的CMS内容
	* Key: 调用方按Key查值
	* 语言：CN，EN
	* 渠道：Web，H5、APP、WeChat
	* OS：IOS、Andriod、（华为note..）
	* 业务ID：扩展字段，按业务ID查询对应CMS
	* valueType：json、HTML、int、string、bool...(用于后台显示对应的输入框)
	* Key状态： 假删除
	
	CMSContentID | Channel | Key |  语言 | 渠道 | 设备OS | 业务ID | value  | 状态 | 创建时间 | 创建者 | 修改时间 | 修改者
------------ | ---------- | ---- | ----- | --- | --- | ----- | ----- | ----- | --- | --------- | --------- | -----
1 | HOME | HOME_HEADBIMG  | 0 | 0 | 0 | |&lt;div>.. | | |  |  
2 | HOME | HOME_HEADBIMG  | CN | 0 | 0 | | &lt;div>.. | | |   
3 | HOME | HOME_HEADBIMG  | EN | WEB,PAD | 0 | | &lt;div>.. | |   |  
4 | HOME | HOME_HEADBIMG  | CN | MOBILE | IOS, WECHAT | | &lt;div>.. | |  |   

4. CMS历史记录（CMSHistory）

	CMSHistoryID | CMSContentID | value | 修改时间 | 修改者
------------ | ------------- | -------- | ------- | -----
1 | 4 | ... | 2015-9-1 | user | 

5. 权限表（Members）

所有人都有只读权限可以看任何内容； 操作的按钮只有相应权限的人才可见

* Role：编辑、删除、
	

ID | Channel | UserID | Role | 修改时间
--- | ------ | ------ | ----- | -----
1 | Home | |  编辑、删除 | 


### 三、调用接口设计

1. String GetCMS（Channel，Key， Language， clientType，Useragent, businessID）
	
	 参数：
	 * Channel, Key必须传
	 * Language：CN/EN,可以不传则值为0
	 * clientType：Web/APP/WeChat/H5，可以不传则为0
	 * Useragent：直接传入useragnet，由接口内部识别设备；也可以不传则为0
	 * BusinessID: 业务ID，可以不传
	 
2. Dict<Key,Value> GetCMSList(Channel，List<String> Key， Language， ApplicationType，Useragent)

###### 搜索逻辑：

1. 第一步，按Channel、Key、businessID查询出CMS表中的列表，多条记录
2. 第二步，在获得的列表中，依次按字段（语言、终端、设备）最优匹配出一条记录，没有匹配按默认值0匹配
3. 第三部，查询并计算出返回一个key对应的一个value
 
### 三、后台设计