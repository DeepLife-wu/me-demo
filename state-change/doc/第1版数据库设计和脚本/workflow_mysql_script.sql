/*==============================================================*/
/* Database name:  Database_1                                   */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/5/21 14:41:16                           */
/*==============================================================*/


drop database if exists Database_1;

/*==============================================================*/
/* Database: Database_1                                         */
/*==============================================================*/
create database Database_1;

use Database_1;

/*==============================================================*/
/* Table: approver                                              */
/*==============================================================*/
create table approver
(
   id                   int not null auto_increment comment 'id',
   workflow_id          int not null comment '流程id',
   node_id              int not null comment '节点id',
   user_id              int comment '审批人',
   primary key (id)
);

alter table approver comment '审批人员表approver';

/*==============================================================*/
/* Table: finance_apply                                         */
/*==============================================================*/
create table finance_apply
(
   id                   int not null auto_increment comment '财务报销id',
   money                float comment '报销金额',
   user_id              int comment '报销人员',
   category             varchar(45) comment '报销类别',
   project_code         varchar(45) comment '报销项目
            报销项目',
   money_list_note      varchar(200) comment '费用明细',
   state                int comment '状态：1-未结束；2-已结束',
   primary key (id)
);

alter table finance_apply comment '财务申请表finance_apply';

/*==============================================================*/
/* Table: workflow                                              */
/*==============================================================*/
create table workflow
(
   workflow_id          int not null auto_increment comment '流程id',
   workflow_name        varchar(100) comment '流程名',
   workflow_desc        varchar(200) comment '流程描述',
   primary key (workflow_id)
);

alter table workflow comment '流程表workflow';

/*==============================================================*/
/* Table: workflow_link                                         */
/*==============================================================*/
create table workflow_link
(
   workflow_link_id     int not null auto_increment comment '流程线id',
   workflow_id          int not null comment '流程id',
   workflow_link_name   varchar(45) not null comment '流程线名称',
   workflow_link_pre_node int not null comment '流程线上一节点',
   workflow_link_next_node int comment '流程线下一个节点',
   primary key (workflow_link_id)
);

alter table workflow_link comment '流程线表workflow_link';

/*==============================================================*/
/* Table: workflow_node                                         */
/*==============================================================*/
create table workflow_node
(
   id                   int not null auto_increment comment '流程节点id',
   workflow_id          int not null comment '流程id',
   node_name            varchar(100) not null comment '节点名称',
   primary key (id)
);

alter table workflow_node comment '流程节点表workflow_node';

/*==============================================================*/
/* Table: workflow_x_business                                   */
/*==============================================================*/
create table workflow_x_business
(
   id                   int not null auto_increment comment 'id',
   workflow_id          int not null comment '流程id',
   business_id          int not null comment '业务表id',
   node_id              int not null comment '当前节点id',
   suggestion           varchar(200) comment '审批建议',
   approval_user_id     int comment '审批人；关联user_id',
   apply_user_id        int comment '申请人id',
   primary key (id)
);

alter table workflow_x_business comment '流程业务表workflow_x_business';


INSERT INTO `finance_apply` VALUES ('1', '32', '1', '打开费', '1', null, '1');


INSERT INTO `workflow` VALUES ('1', '财务审批流程', '用于员工个财务审批');


INSERT INTO `workflow_link` VALUES ('1', '1', '申请人提交项目经理审批', '1', '2');
INSERT INTO `workflow_link` VALUES ('2', '1', '项目经理提交人事主管审批', '2', '3');
INSERT INTO `workflow_link` VALUES ('3', '1', '人事主管提交总经理审批', '3', '4');
INSERT INTO `workflow_link` VALUES ('4', '1', '总经理提交财务审批', '4', '5');
INSERT INTO `workflow_link` VALUES ('5', '1', '项目经理提交总经理审批', '2', '4');
INSERT INTO `workflow_link` VALUES ('6', '1', '项目经理提交财务审批', '2', '5');
INSERT INTO `workflow_link` VALUES ('7', '1', '项目经理驳回', '2', '1');
INSERT INTO `workflow_link` VALUES ('8', '1', '人事主管驳回', '3', '1');
INSERT INTO `workflow_link` VALUES ('9', '1', '总经理驳回', '4', '1');
INSERT INTO `workflow_link` VALUES ('10', '1', '财务驳回', '5', '1');
INSERT INTO `workflow_link` VALUES ('11', '1', '结束', '5', '6');

INSERT INTO `workflow_node` VALUES ('1', '1', '申请人');
INSERT INTO `workflow_node` VALUES ('2', '1', '项目经理');
INSERT INTO `workflow_node` VALUES ('3', '1', '人事主管');
INSERT INTO `workflow_node` VALUES ('4', '1', '总经理');
INSERT INTO `workflow_node` VALUES ('5', '1', '财务');


INSERT INTO `workflow_x_business` VALUES ('1', '1', '1', '1', null, '1', '1');




