/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : temp

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-05-27 08:29:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_workflow
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow`;
CREATE TABLE `t_workflow` (
  `workflow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����id������ʶ��ʱ��Ψһ��ʶ	',
  `workflow_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '��������',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '������',
  PRIMARY KEY (`workflow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow���̶����';

-- ----------------------------
-- Records of t_workflow
-- ----------------------------
INSERT INTO `t_workflow` VALUES ('1', '������������', '2021-05-24 09:05:44', '1');

-- ----------------------------
-- Table structure for t_workflow_business
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_business`;
CREATE TABLE `t_workflow_business` (
  `workflow_business_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '������������ҵ����й�����ÿһ������ֻ����һ����¼',
  `workflow_id` int(11) DEFAULT NULL COMMENT '����id',
  `curr_node` int(11) DEFAULT NULL COMMENT '�������������̽ڵ�',
  `last_node` int(11) DEFAULT NULL COMMENT '��һ����ڵ�',
  `workflow_status` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '���̵�ǰ�����״̬����������գ��ѽ��գ��ѽ���������ʵ��ҵ������',
  `business_id` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '������ҵ����й���ʱ���洢��ҵ����Ψһ��ʶ',
  `business_type` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '������ҵ���ʶ������ʵ�ʵ�ҵ������',
  `deal_user` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '�����Ƿ������1-δ������2-���� ',
  `workflow_is_over` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '������',
  `create_user` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '���̴�����',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`workflow_business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_business����ҵ��������˱�������ʶ���̵�ǰ��ת��״̬�ͽڵ�';

-- ----------------------------
-- Records of t_workflow_business
-- ----------------------------
INSERT INTO `t_workflow_business` VALUES ('1', '1', '1', null, '1', '1', 'T024', '2', '1', '6', '2021-05-25 10:13:57');

-- ----------------------------
-- Table structure for t_workflow_business_history
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_business_history`;
CREATE TABLE `t_workflow_business_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ҵ����ת����ʷ��¼Ψһ��ʶ	',
  `workflow_business_id` int(11) DEFAULT NULL COMMENT '����ҵ�������id',
  `curr_node_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '���̵�ǰ����ڵ�',
  `next_node_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '������ת��һ�ڵ�',
  `node_action` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '������ת��ʶ,ͨ��-next,����-back,ת��-send��������ʶ����ת��ͨ�����ǲ���',
  `deal_user_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '��ǰ�ڵ㴦����id',
  `deal_user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '��ǰ�ڵ㴦��������',
  `deal_time` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '����ʱ��',
  `suggestion_feedback` text COLLATE utf8_bin COMMENT '���̴��������',
  `deal_step` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '���̴����裬���磺�ύ���룬�����ȵȣ��ɸ���ʵ��ҵ��������',
  `create_time` char(10) COLLATE utf8_bin DEFAULT NULL COMMENT '����ʱ��',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '������',
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_business_historyҵ����ת��¼��';

-- ----------------------------
-- Records of t_workflow_business_history
-- ----------------------------

-- ----------------------------
-- Table structure for t_workflow_node
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node`;
CREATE TABLE `t_workflow_node` (
  `node_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '���̽ڵ�id��������ʶ���̽ڵ�',
  `workflow_id` int(11) DEFAULT NULL COMMENT '����id��������ʶ���̺ͽڵ�Ĺ�ϵ',
  `node_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '�ڵ�����',
  `node_status` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '���̽ڵ�״̬��1-��ʼ�ڵ㣬2-�����м�ڵ㣬3-�����ڵ�	',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '������',
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_node���̽ڵ��';

-- ----------------------------
-- Records of t_workflow_node
-- ----------------------------
INSERT INTO `t_workflow_node` VALUES ('1', '1', '������', '1', '2021-05-24 09:08:13', '1');
INSERT INTO `t_workflow_node` VALUES ('2', '1', '��Ŀ����', '2', '2021-05-24 09:09:04', '1');
INSERT INTO `t_workflow_node` VALUES ('3', '1', '��������', '2', '2021-05-24 09:10:34', '1');
INSERT INTO `t_workflow_node` VALUES ('4', '1', '�ܾ���', '2', '2021-05-24 09:10:51', '1');
INSERT INTO `t_workflow_node` VALUES ('5', '1', '����', '2', '2021-05-24 09:14:09', '1');
INSERT INTO `t_workflow_node` VALUES ('6', '1', '����', '3', '2021-05-24 09:14:25', '1');

-- ----------------------------
-- Table structure for t_workflow_node_action
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node_action`;
CREATE TABLE `t_workflow_node_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `workflow_id` int(11) DEFAULT NULL COMMENT '����id',
  `node_id` int(11) DEFAULT NULL COMMENT '�ڵ�id',
  `action` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '������ͨ��-next������-back��send-ת��',
  `action_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_node_action���̽ڵ���ת������';

-- ----------------------------
-- Records of t_workflow_node_action
-- ----------------------------
INSERT INTO `t_workflow_node_action` VALUES ('1', '1', '1', 'submit', '�ύ����');
INSERT INTO `t_workflow_node_action` VALUES ('2', '1', '2', 'next', 'ͨ��');
INSERT INTO `t_workflow_node_action` VALUES ('3', '1', '3', 'reject', '����');

-- ----------------------------
-- Table structure for t_workflow_node_link
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node_link`;
CREATE TABLE `t_workflow_node_link` (
  `workflow_id` int(11) NOT NULL COMMENT '����id',
  `curr_node_id` int(11) NOT NULL COMMENT '��ǰ���̽ڵ�',
  `next_node_id` int(11) NOT NULL COMMENT '��һ���̽ڵ�',
  `action_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '������ת����',
  `action` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '������ת��ʶ,ͨ��-next,����-back��������ʶ����ת��ͨ�����ǲ���',
  `workflow_status` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '�˲����Ƿ��������1-��������2-����    ',
  PRIMARY KEY (`workflow_id`,`curr_node_id`,`next_node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_node_link���̽ڵ������';

-- ----------------------------
-- Records of t_workflow_node_link
-- ----------------------------
INSERT INTO `t_workflow_node_link` VALUES ('1', '1', '2', '�ύ����', 'submit', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '2', '1', '����', 'reject', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '2', '3', 'ͨ��', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '2', '4', 'ͨ��', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '2', '5', 'ͨ��', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '3', '1', '����', 'reject', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '3', '4', 'ͨ��', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '4', '1', '����', 'reject', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '4', '5', 'ͨ��', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '5', '1', '����', 'reject', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '5', '6', 'ͨ��', 'next', '2');

-- ----------------------------
-- Table structure for t_workflow_node_x_role
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node_x_role`;
CREATE TABLE `t_workflow_node_x_role` (
  `node_id` int(11) NOT NULL COMMENT '���̽ڵ�id',
  `role_id` int(11) NOT NULL COMMENT '���̽�ɫid'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_node_x_role���̺ͽ�ɫ���������̺ͽ�ɫ������һ�Զ��ϵ	 ';

-- ----------------------------
-- Records of t_workflow_node_x_role
-- ----------------------------
INSERT INTO `t_workflow_node_x_role` VALUES ('1', '6');
INSERT INTO `t_workflow_node_x_role` VALUES ('2', '2');
INSERT INTO `t_workflow_node_x_role` VALUES ('3', '3');
INSERT INTO `t_workflow_node_x_role` VALUES ('4', '4');
INSERT INTO `t_workflow_node_x_role` VALUES ('5', '5');
