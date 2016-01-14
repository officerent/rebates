
drop database rebates;
create database if not exists rebates default charset utf8 collate utf8_general_ci;

use rebates;

CREATE TABLE `rebates_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(50) COMMENT '用户名',
  `password` varchar(2048) COMMENT '用户密码，md5加密以后的值',
  `status` tinyint comment '状态:0=正常，1=冻结，2=删除',
  `is_admin` tinyint comment '是否管理员:0=不是，1=是',
  `last_frozen_time` datetime comment '最后一次冻结时间',
  `create_time` datetime comment '创建时间',
  `last_update_time` datetime comment '最后一次更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `name` (`name`)
) AUTO_INCREMENT = 20000 ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='用户表';

CREATE TABLE `question_answer` (
  `qa_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'QA ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `root_qa_id` bigint COMMENT 'root QA ID，最上一层',
  `parent_qa_id` bigint COMMENT '上一层 QA ID',
  `content` varchar(1024) COMMENT '内容',
  `create_time` datetime comment '创建时间',
  `last_update_time` datetime comment '最后一次更新时间',
  PRIMARY KEY (`qa_id`),
  KEY `root_qa_id` (`root_qa_id`),
  KEY `user_id` (`user_id`)
) AUTO_INCREMENT = 20000 ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='用户问答表';

#token可以不用存数据库，直接放缓存#
#CREATE TABLE `user_token` (
#  `token_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户tokenID',
#  `user_id` bigint NOT NULL COMMENT '用户ID',
#  `token` varchar(2048) COMMENT 'token value，md5(user_id + 当前时间)',
#  `create_time` datetime comment '创建时间',
#  PRIMARY KEY (`channel_id`),
#  UNIQUE KEY `token` (`token`)
#) AUTO_INCREMENT = 20000 ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='用户token表';

CREATE TABLE `sales_people` (
  `sales_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'sales ID',
  `sales_num` int(11) NOT NULL COMMENT '销售的编号，1,2,3,4等，下单按此编号随机挑选一个销售',
  `user_name` varchar(50) NOT NULL COMMENT '该销售在soho3q中的登录名',
  `user_password` varchar(50) NOT NULL COMMENT '该销售在soho3q中的登录密码明文',  
  `create_time` datetime comment '创建时间',
  `last_update_time` datetime comment '最后一次更新时间',
  PRIMARY KEY (`sales_id`),
  UNIQUE KEY `token` (`sales_num`)
) AUTO_INCREMENT = 20000 ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='soho3q销售表';

CREATE TABLE `rebates_order` (
  `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `sales_id` bigint COMMENT '销售ID,使用该销售向soho3q下单',
  `soho3q_order_id` bigint COMMENT 'soho3q需求单',
  #`status` tinyint comment '状态:0=用户下单，1=已向soho3q下单',
  `customer_mobile` varchar(50) COMMENT '客户手机',
  `customer_name` varchar(50) COMMENT '客户姓名',
  `customer_company` varchar(50) COMMENT '客户公司',
  `customer_alipay` varchar(50) COMMENT '客户支付宝帐号',
  `porject_id` varchar(50) COMMENT '项目id',
  `porject_name` varchar(50) COMMENT '项目名称',
  `checkin_date` date comment '入住日期',
  `checkout_date` date comment '退租日期',
  `period_month` int(11) COMMENT '租期,月',
  `period_week` int(11) COMMENT '租期,周',
  `lease_amount` int(11) COMMENT '租金金额，单位分',
  `deposit_amount` int(11) COMMENT '押金金额，单位分',
  `create_time` datetime comment '创建时间',
  `last_update_time` datetime comment '最后一次更新时间',
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  UNIQUE KEY `soho3q_order_id` (`soho3q_order_id`),
  KEY `sales_id` (`sales_id`)
) AUTO_INCREMENT = 20000 ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

CREATE TABLE `rebates_order_item` (
  `order_item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单明细ID',
  `order_id` bigint NOT NULL COMMENT 'order ID',
  `porject_id` varchar(50) COMMENT '项目id',
  `original_price` int(11) COMMENT '产品租金原单价，单位分',
  `final_price` int(11) COMMENT '产品折后租金单价，单位分',
  `deposit_price` int(11) COMMENT '押金金额，单位分',
  `product_type` varchar(50) COMMENT '产品大类',
  `product_sub_type` varchar(50) COMMENT '产品小类',
  `book_num` int(11) COMMENT '产品数量',
  `total_price` int(11) COMMENT '该品总价，单位分',
  `create_time` datetime comment '创建时间',
  `last_update_time` datetime comment '最后一次更新时间',
  PRIMARY KEY (`order_item_id`),
  KEY `order_id` (`order_id`)
) AUTO_INCREMENT = 20000 ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

CREATE TABLE `rebates_bonus` (
  `bonus_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'key ID',
  `order_id` bigint COMMENT '订单ID',
  `sales_id` bigint COMMENT '销售ID',
  `soho3q_order_id` bigint COMMENT 'soho3q需求单id',
  `soho3q_order_num` varchar(50) COMMENT 'soho3q订单编号,实际支付的订单编号',
  `soho3q_confirmed_order_num` varchar(50) COMMENT 'soho3q确认后的订单编号,如果不是分期，与付款实际支付的订单编号一致',
  `lease_amount` int(11) COMMENT '支付租金金额，单位分',
  `bonus_before_tax` int(11) COMMENT 'soho3q佣金税前金额，单位分',
  `bonus_tax` int(11) COMMENT 'soho3q佣金税金额，单位分',
  `bonus_after_tax` int(11) COMMENT 'soho3q佣金税后金额，单位分', 
  `rebates_amount` int(11) COMMENT '给客户的返利金额，单位分',
  `status` tinyint COMMENT '0=需求单待确认，1=需求单已确认，2=客户已支付订单，3=销售已收到佣金，4=客户已经收到返利,5=订单已取消',
  `create_time` datetime comment '创建时间',
  `last_update_time` datetime comment '最后一次更新时间',
  `updater` varchar(50) COMMENT '修改人',
  PRIMARY KEY (`bonus_id`),
  UNIQUE KEY `soho3q_order` (`soho3q_order_id`,`soho3q_order_num`),
  KEY `order_id` (`order_id`)
) AUTO_INCREMENT = 20000 ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='佣金表';


