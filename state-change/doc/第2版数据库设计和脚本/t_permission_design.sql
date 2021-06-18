/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : temp

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-06-01 15:10:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色-权限关系表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1');
INSERT INTO `t_role_permission` VALUES ('1', '2');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户-角色关系表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2');
INSERT INTO `t_user_role` VALUES ('3', '3');
INSERT INTO `t_user_role` VALUES ('4', '4');
INSERT INTO `t_user_role` VALUES ('5', '5');
INSERT INTO `t_user_role` VALUES ('6', '6');
INSERT INTO `t_user_role` VALUES ('7', '6');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '权限名称',
  `type` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '权限类型（1为按钮，2为菜单）',
  `action` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '权限行为（url）',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '测试-保存', '1', '/test/save');
INSERT INTO `t_permission` VALUES ('2', '测试删除', '1', '/test/delete');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', null);
INSERT INTO `t_role` VALUES ('2', '项目经理', null);
INSERT INTO `t_role` VALUES ('3', '人事主管', null);
INSERT INTO `t_role` VALUES ('4', '总经理', null);
INSERT INTO `t_role` VALUES ('5', '财务', null);
INSERT INTO `t_role` VALUES ('6', '职员', null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `mobile` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '手机号',
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `AK_Key_2` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '乔峰', '123456', '15801630979', '15801630979@163.com', '1990-11-18');
INSERT INTO `t_user` VALUES ('2', '宋清溪', '123456', '15801630978', '15801630978@163.com', '1990-11-18');
INSERT INTO `t_user` VALUES ('3', '奚三祁', '123456', '15801630977', '15801630977@163.com', '1990-11-18');
INSERT INTO `t_user` VALUES ('4', '陈孤雁', '123456', '15801630976', '15801630976@163.com', '1990-11-18');
INSERT INTO `t_user` VALUES ('5', '吴长风', '123456', '15801630975', '15801630975@163.com', '1990-11-18');
INSERT INTO `t_user` VALUES ('6', '白世镜', '123456', '15801630974', '15801630974@163.com', '1990-11-18');
INSERT INTO `t_user` VALUES ('7', '吕章', '123456', '15801630973', '15801630973@163.com', '1990-11-18');
