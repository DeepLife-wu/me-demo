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
  `workflow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流程id，流程识别时的唯一标识	',
  `workflow_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '流程名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`workflow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow流程定义表';

-- ----------------------------
-- Records of t_workflow
-- ----------------------------
INSERT INTO `t_workflow` VALUES ('1', '财务审批流程', '2021-05-24 09:05:44', '1');

-- ----------------------------
-- Table structure for t_workflow_business
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_business`;
CREATE TABLE `t_workflow_business` (
  `workflow_business_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流程启动后，与业务进行关联，每一条流程只产生一条记录',
  `workflow_id` int(11) DEFAULT NULL COMMENT '流程id',
  `curr_node` int(11) DEFAULT NULL COMMENT '流程所处的流程节点',
  `last_node` int(11) DEFAULT NULL COMMENT '上一处理节点',
  `workflow_status` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '流程当前处理的状态，例如待接收，已接收，已结束，根据实际业务来定',
  `business_id` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '流程与业务进行关联时，存储的业务表的唯一标识',
  `business_type` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关联的业务标识，根据实际的业务来定',
  `deal_user` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '流程是否结束，1-未结束，2-结束 ',
  `workflow_is_over` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '处理人',
  `create_user` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '流程创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`workflow_business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_business流程业务关联表，此表用来标识流程当前流转到状态和节点';

-- ----------------------------
-- Records of t_workflow_business
-- ----------------------------
INSERT INTO `t_workflow_business` VALUES ('1', '1', '1', null, '1', '1', 'T024', '2', '1', '6', '2021-05-25 10:13:57');

-- ----------------------------
-- Table structure for t_workflow_business_history
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_business_history`;
CREATE TABLE `t_workflow_business_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务流转表历史记录唯一标识	',
  `workflow_business_id` int(11) DEFAULT NULL COMMENT '流程业务关联表id',
  `curr_node_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '流程当前处理节点',
  `next_node_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '流程流转下一节点',
  `node_action` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '流程流转标识,通过-next,驳回-back,转发-send，用来标识此流转是通过还是驳回',
  `deal_user_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '当前节点处理人id',
  `deal_user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '当前节点处理人名称',
  `deal_time` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '处理时间',
  `suggestion_feedback` text COLLATE utf8_bin COMMENT '流程处理反馈意见',
  `deal_step` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '流程处理步骤，例如：提交申请，审批等等，可根据实际业务来定制',
  `create_time` char(10) COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_business_history业务流转记录表';

-- ----------------------------
-- Records of t_workflow_business_history
-- ----------------------------

-- ----------------------------
-- Table structure for t_workflow_node
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node`;
CREATE TABLE `t_workflow_node` (
  `node_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流程节点id，用来标识流程节点',
  `workflow_id` int(11) DEFAULT NULL COMMENT '流程id，用来标识流程和节点的关系',
  `node_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '节点名称',
  `node_status` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '流程节点状态，1-起始节点，2-流程中间节点，3-结束节点	',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_node流程节点表';

-- ----------------------------
-- Records of t_workflow_node
-- ----------------------------
INSERT INTO `t_workflow_node` VALUES ('1', '1', '申请人', '1', '2021-05-24 09:08:13', '1');
INSERT INTO `t_workflow_node` VALUES ('2', '1', '项目经理', '2', '2021-05-24 09:09:04', '1');
INSERT INTO `t_workflow_node` VALUES ('3', '1', '人事主管', '2', '2021-05-24 09:10:34', '1');
INSERT INTO `t_workflow_node` VALUES ('4', '1', '总经理', '2', '2021-05-24 09:10:51', '1');
INSERT INTO `t_workflow_node` VALUES ('5', '1', '财务', '2', '2021-05-24 09:14:09', '1');
INSERT INTO `t_workflow_node` VALUES ('6', '1', '结束', '3', '2021-05-24 09:14:25', '1');

-- ----------------------------
-- Table structure for t_workflow_node_action
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node_action`;
CREATE TABLE `t_workflow_node_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `workflow_id` int(11) DEFAULT NULL COMMENT '流程id',
  `node_id` int(11) DEFAULT NULL COMMENT '节点id',
  `action` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '动作，通过-next；驳回-back；send-转发',
  `action_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '动作名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_node_action流程节点流转动作表';

-- ----------------------------
-- Records of t_workflow_node_action
-- ----------------------------
INSERT INTO `t_workflow_node_action` VALUES ('1', '1', '1', 'submit', '提交申请');
INSERT INTO `t_workflow_node_action` VALUES ('2', '1', '2', 'next', '通过');
INSERT INTO `t_workflow_node_action` VALUES ('3', '1', '3', 'reject', '驳回');

-- ----------------------------
-- Table structure for t_workflow_node_link
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node_link`;
CREATE TABLE `t_workflow_node_link` (
  `workflow_id` int(11) NOT NULL COMMENT '流程id',
  `curr_node_id` int(11) NOT NULL COMMENT '当前流程节点',
  `next_node_id` int(11) NOT NULL COMMENT '下一流程节点',
  `action_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '流程流转描述',
  `action` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '流程流转标识,通过-next,驳回-back，用来标识此流转是通过还是驳回',
  `workflow_status` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '此步骤是否结束流程1-不结束，2-结束    ',
  PRIMARY KEY (`workflow_id`,`curr_node_id`,`next_node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_node_link流程节点流向表';

-- ----------------------------
-- Records of t_workflow_node_link
-- ----------------------------
INSERT INTO `t_workflow_node_link` VALUES ('1', '1', '2', '提交申请', 'submit', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '2', '1', '驳回', 'reject', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '2', '3', '通过', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '2', '4', '通过', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '2', '5', '通过', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '3', '1', '驳回', 'reject', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '3', '4', '通过', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '4', '1', '驳回', 'reject', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '4', '5', '通过', 'next', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '5', '1', '驳回', 'reject', '1');
INSERT INTO `t_workflow_node_link` VALUES ('1', '5', '6', '通过', 'next', '2');

-- ----------------------------
-- Table structure for t_workflow_node_x_role
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node_x_role`;
CREATE TABLE `t_workflow_node_x_role` (
  `node_id` int(11) NOT NULL COMMENT '流程节点id',
  `role_id` int(11) NOT NULL COMMENT '流程角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='t_workflow_node_x_role流程和角色关联表，流程和角色可以是一对多关系	 ';

-- ----------------------------
-- Records of t_workflow_node_x_role
-- ----------------------------
INSERT INTO `t_workflow_node_x_role` VALUES ('1', '6');
INSERT INTO `t_workflow_node_x_role` VALUES ('2', '2');
INSERT INTO `t_workflow_node_x_role` VALUES ('3', '3');
INSERT INTO `t_workflow_node_x_role` VALUES ('4', '4');
INSERT INTO `t_workflow_node_x_role` VALUES ('5', '5');
