
drop database soho3q_cms;
create database if not exists soho3q_cms default charset utf8 collate utf8_general_ci;

use soho3q_cms;

CREATE TABLE `cms_channel` (
  `channel_id` bigint NOT NULL AUTO_INCREMENT COMMENT '频道ID',
  `name` varchar(50) COMMENT '频道名称',
  `description` varchar(2048) COMMENT '频道描述',
  `status` tinyint comment '状态:0=正常，1=删除',
  `css_file` varchar(2048) COMMENT 'css文件地址',
  `creator` varchar(50) COMMENT '创建人',
  `create_time` datetime comment '创建时间',
  `updater` varchar(50) COMMENT '修改人',
  `last_update_time` datetime comment '最后一次更新时间',
  PRIMARY KEY (`channel_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='频道表';

CREATE TABLE `cms_tag` (
  `tag_id` bigint NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `channel_name` varchar(50) COMMENT '频道名称',
  `name` varchar(50) COMMENT '标签名称',
  `color` varchar(50) COMMENT '颜色',
  `creator` varchar(50) COMMENT '创建人',
  `create_time` datetime comment '创建时间',
  `updater` varchar(50) COMMENT '修改人',
  `last_update_time` datetime comment '最后一次更新时间',
  PRIMARY KEY (`tag_id`),
  KEY `channel_name` (`channel_name`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

CREATE TABLE `cms_key` (
  `key_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'key ID',
  `channel_name` varchar(50) COMMENT '频道名称',
  `tag_id` bigint COMMENT 'tag ID',
  `cms_key` varchar(250) NOT NULL COMMENT 'key',
  `name` varchar(50) NOT NULL COMMENT 'key的名字',
  `description` varchar(2048) NOT NULL COMMENT 'key的描述',
  `key_type` varchar(50) COMMENT 'key的类型:IMAGE,JSON,HTML,INT,STRING,BOOLEAN',
  `enabled` tinyint comment 'key状态:0=key未生效，1=key已生效',
  `creator` varchar(50) COMMENT '创建人',
  `create_time` datetime comment '创建时间',
  `updater` varchar(50) COMMENT '修改人',
  `last_update_time` datetime comment '最后一次更新时间',
  PRIMARY KEY (`key_id`),
  KEY `channel_tag` (`channel_name`,`tag_id`),
  UNIQUE KEY `cms_key` (`channel_name`,`cms_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='key表';

CREATE TABLE `cms_value` (
  `value_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'value ID',
  `channel_name` varchar(50) COMMENT '频道名称',
  `cms_key` varchar(250) NOT NULL COMMENT 'key',
  `language` varchar(50) NOT NULL COMMENT '语言:zh_CN或者en_US, *表示通配符',
  `client` varchar(50) NOT NULL COMMENT '客户端Web，H5、APP、WeChat, *表示通配符',
  `os` varchar(50) NOT NULL COMMENT '操作系统:IOS、Andriod, *表示通配符', 
  `business_id` varchar(100) COMMENT '业务ID',
  `cms_value` varchar(10000) NOT NULL COMMENT 'value',
  `enabled` tinyint comment 'value状态:0=value未生效，1=value已生效',
  `creator` varchar(50) COMMENT '创建人',
  `create_time` datetime comment '创建时间',
  `updater` varchar(50) COMMENT '修改人',
  `last_update_time` datetime comment '最后一次更新时间',
  `description` varchar(300) comment '策略描述',
  PRIMARY KEY (`value_id`),
  KEY `cms_key` (`channel_name`,`cms_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='value表';

CREATE TABLE `cms_value_history` (
  `value_history_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'value history ID',
  `value_id` bigint NOT NULL COMMENT 'value ID',
  `channel_name` varchar(50) COMMENT '频道名称',
  `cms_key` varchar(250) NOT NULL COMMENT 'key',
  `language` varchar(50) NOT NULL COMMENT '语言:zh_CN或者en_US, *表示通配符',
  `client` varchar(50) NOT NULL COMMENT '客户端Web，H5、APP、WeChat, *表示通配符',
  `os` varchar(50) NOT NULL COMMENT '操作系统:IOS、Andriod, *表示通配符', 
  `business_id` varchar(100) COMMENT '业务ID',
  `cms_value` varchar(10000) NOT NULL COMMENT 'value',
  `enabled` tinyint comment 'value状态:0=value未生效，1=value已生效',
  `creator` varchar(50) COMMENT '创建人',
  `create_time` datetime comment '创建时间',
  `updater` varchar(50) COMMENT '修改人',
  `last_update_time` datetime comment '最后一次更新时间',
  `description` varchar(300) comment '策略描述',
  PRIMARY KEY (`value_history_id`),
  KEY `cms_key` (`channel_name`,`cms_key`),
  KEY `value_id` (`value_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='value历史表';


## cms_value 、 cms_value_history分别添加 description 字段
Alter table cms_value_history change cms_value cms_value varchar(10000) NOT NULL COMMENT 'value';

