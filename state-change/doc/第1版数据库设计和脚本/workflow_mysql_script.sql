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
   workflow_id          int not null comment '����id',
   node_id              int not null comment '�ڵ�id',
   user_id              int comment '������',
   primary key (id)
);

alter table approver comment '������Ա��approver';

/*==============================================================*/
/* Table: finance_apply                                         */
/*==============================================================*/
create table finance_apply
(
   id                   int not null auto_increment comment '������id',
   money                float comment '�������',
   user_id              int comment '������Ա',
   category             varchar(45) comment '�������',
   project_code         varchar(45) comment '������Ŀ
            ������Ŀ',
   money_list_note      varchar(200) comment '������ϸ',
   state                int comment '״̬��1-δ������2-�ѽ���',
   primary key (id)
);

alter table finance_apply comment '���������finance_apply';

/*==============================================================*/
/* Table: workflow                                              */
/*==============================================================*/
create table workflow
(
   workflow_id          int not null auto_increment comment '����id',
   workflow_name        varchar(100) comment '������',
   workflow_desc        varchar(200) comment '��������',
   primary key (workflow_id)
);

alter table workflow comment '���̱�workflow';

/*==============================================================*/
/* Table: workflow_link                                         */
/*==============================================================*/
create table workflow_link
(
   workflow_link_id     int not null auto_increment comment '������id',
   workflow_id          int not null comment '����id',
   workflow_link_name   varchar(45) not null comment '����������',
   workflow_link_pre_node int not null comment '��������һ�ڵ�',
   workflow_link_next_node int comment '��������һ���ڵ�',
   primary key (workflow_link_id)
);

alter table workflow_link comment '�����߱�workflow_link';

/*==============================================================*/
/* Table: workflow_node                                         */
/*==============================================================*/
create table workflow_node
(
   id                   int not null auto_increment comment '���̽ڵ�id',
   workflow_id          int not null comment '����id',
   node_name            varchar(100) not null comment '�ڵ�����',
   primary key (id)
);

alter table workflow_node comment '���̽ڵ��workflow_node';

/*==============================================================*/
/* Table: workflow_x_business                                   */
/*==============================================================*/
create table workflow_x_business
(
   id                   int not null auto_increment comment 'id',
   workflow_id          int not null comment '����id',
   business_id          int not null comment 'ҵ���id',
   node_id              int not null comment '��ǰ�ڵ�id',
   suggestion           varchar(200) comment '��������',
   approval_user_id     int comment '�����ˣ�����user_id',
   apply_user_id        int comment '������id',
   primary key (id)
);

alter table workflow_x_business comment '����ҵ���workflow_x_business';


INSERT INTO `finance_apply` VALUES ('1', '32', '1', '�򿪷�', '1', null, '1');


INSERT INTO `workflow` VALUES ('1', '������������', '����Ա������������');


INSERT INTO `workflow_link` VALUES ('1', '1', '�������ύ��Ŀ��������', '1', '2');
INSERT INTO `workflow_link` VALUES ('2', '1', '��Ŀ�����ύ������������', '2', '3');
INSERT INTO `workflow_link` VALUES ('3', '1', '���������ύ�ܾ�������', '3', '4');
INSERT INTO `workflow_link` VALUES ('4', '1', '�ܾ����ύ��������', '4', '5');
INSERT INTO `workflow_link` VALUES ('5', '1', '��Ŀ�����ύ�ܾ�������', '2', '4');
INSERT INTO `workflow_link` VALUES ('6', '1', '��Ŀ�����ύ��������', '2', '5');
INSERT INTO `workflow_link` VALUES ('7', '1', '��Ŀ������', '2', '1');
INSERT INTO `workflow_link` VALUES ('8', '1', '�������ܲ���', '3', '1');
INSERT INTO `workflow_link` VALUES ('9', '1', '�ܾ�����', '4', '1');
INSERT INTO `workflow_link` VALUES ('10', '1', '���񲵻�', '5', '1');
INSERT INTO `workflow_link` VALUES ('11', '1', '����', '5', '6');

INSERT INTO `workflow_node` VALUES ('1', '1', '������');
INSERT INTO `workflow_node` VALUES ('2', '1', '��Ŀ����');
INSERT INTO `workflow_node` VALUES ('3', '1', '��������');
INSERT INTO `workflow_node` VALUES ('4', '1', '�ܾ���');
INSERT INTO `workflow_node` VALUES ('5', '1', '����');


INSERT INTO `workflow_x_business` VALUES ('1', '1', '1', '1', null, '1', '1');




