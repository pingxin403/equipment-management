drop table if exists `tb_device_task`;
drop table if exists `tb_worker`;
drop table if exists `tb_service_team`;
drop table if exists `tb_device_detail`;
drop table if exists `tb_device_group`;
drop table if exists `tb_maintenance_task`;
drop table if exists `tb_maintenance_schedule`;
drop table if exists `tb_device_class`;
drop table if exists `tb_device_address`;



CREATE TABLE `tb_device_class`
(
  `id`            int          NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) NOT NULL,
  `function`      varchar(255) NULL,
  `scene`         varchar(255) NULL,
  `create_time`   datetime     NULL DEFAULT NOW(),
  `modified_time` datetime     NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `flag`          int               default 1,
  PRIMARY KEY (`id`)
);
CREATE TABLE `tb_device_task`
(
  `id`            int          NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) NOT NULL,
  `desc`          text         NULL,
  `create_time`   datetime     NULL DEFAULT NOW(),
  `modified_time` datetime     NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `type`          tinyint      NULL COMMENT '任务类型',
  `status`        tinyint      NULL,
  `d_id`          integer      NULL,
  `fix_id`        integer      NULL,
  `fix_name`      varchar(255) NULL,
  `service_id`    integer      NULL,
  `service_name`  varchar(255) NULL,
  `flag`          int               default 1,
  PRIMARY KEY (`id`)
);
CREATE TABLE `tb_worker`
(
  `id`            int          NOT NULL AUTO_INCREMENT,
  `nick_name`     varchar(255) NOT NULL,
  `real_name`     varchar(255) NOT NULL,
  `desc`          text         NULL,
  `create_time`   datetime     NULL DEFAULT NOW(),
  `modified_time` datetime     NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `avatar_url`    varchar(255) NULL,
  `open_id`       VARCHAR(255) NULL,
  `service_id`    int(11)      NULL,
  `service_name`  varchar(255) NULL,
  `phone`         varchar(255) NULL,
  `password`      varchar(255) not null,
  `flag`          int               default 1,
  PRIMARY KEY (`id`)
);
CREATE TABLE `tb_service_team`
(
  `id`            int          NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) NOT NULL,
  `desc`          text         NULL,
  `create_time`   datetime     NULL DEFAULT NOW(),
  `modified_time` datetime     NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `flag`          int               default 1,
  PRIMARY KEY (`id`)
);
CREATE TABLE `tb_device_group`
(
  `id`            int            NOT NULL AUTO_INCREMENT,
  `name`          varchar(255)   NOT NULL,
  `firm`          varchar(255)   NULL,
  `price`         decimal(10, 2) NULL,
  `durable_years` tinyint        NULL,
  `desc`          text           NULL,
  `create_time`   datetime       NULL DEFAULT NOW(),
  `modified_time` datetime       NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `clz_id`        integer        NULL,
  `clz_name`      varchar(255)   NULL,
  `ms_id`         INTEGER        null,
  `flag`          int                 default 1,

  PRIMARY KEY (`id`)
);
CREATE TABLE `tb_device_detail`
(
  `id`            int          NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) NOT NULL,
  `code`          varchar(255) NULL,
  `end_date`      date         NULL,
  `status`        tinyint      NULL,
  `create_time`   datetime     NULL DEFAULT NOW(),
  `modified_time` datetime     NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `clz_id`        integer      NULL,
  `clz_name`      varchar(255) NULL,
  `group_id`      integer      NULL,
  `group_name`    varchar(255) NULL,
  `address_name`  varchar(255) NULL,
  `install_date`  date         NULL,
  `mt_id`         INTEGER      null,
  `flag`          int               default 1,

  PRIMARY KEY (`id`)
);
CREATE TABLE `tb_maintenance_schedule`
(
  `id`            int          NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) NOT NULL,
  `period`        smallint     NULL,
  `create_time`   datetime     NULL DEFAULT NOW(),
  `modified_time` datetime     NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `flag`          int               default 1,
  PRIMARY KEY (`id`)
);
CREATE TABLE `tb_device_address`
(
  `id`            int          NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) NOT NULL,
  `desc`          text         NULL,
  `create_time`   datetime     NULL DEFAULT NOW(),
  `modified_time` datetime     NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `flag`          int               default 1,
  PRIMARY KEY (`id`)
);
CREATE TABLE `tb_maintenance_task`
(
  `id`            int      NOT NULL,
  `next_days`     date     NULL,
  `create_time`   datetime NULL DEFAULT NOW(),
  `modified_time` datetime NULL DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
  `ms_id`         integer  NULL,
  `flag`          int           default 1,
  PRIMARY KEY (`id`)
);

ALTER TABLE `tb_device_detail`
  ADD CONSTRAINT `fk_tb_device_detail_tb_device_group_1` FOREIGN KEY (`group_id`) REFERENCES `tb_device_group` (`id`);
ALTER TABLE `tb_maintenance_task`
  ADD CONSTRAINT `fk_tb_maintenance_task_tb_maintenance_schedule_1` FOREIGN KEY (`ms_id`) REFERENCES `tb_maintenance_schedule` (`id`);
ALTER TABLE `tb_device_group`
  ADD CONSTRAINT `fk_tb_device_group_tb_maintenance_schedule_1` FOREIGN KEY (`ms_id`) REFERENCES `tb_maintenance_schedule` (`id`);

ALTER TABLE `tb_device_detail`
  ADD CONSTRAINT `fk_tb_device_detail_tb_maintenance_task_1` FOREIGN KEY (`mt_id`) REFERENCES `tb_maintenance_task` (`id`);


ALTER TABLE `tb_device_group`
  ADD CONSTRAINT `fk_tb_device_group_tb_device_class_1` FOREIGN KEY (`clz_id`) REFERENCES `tb_device_class` (`id`);
ALTER TABLE `tb_device_task`
  ADD CONSTRAINT `fk_tb_device_task_tb_device_detail_1` FOREIGN KEY (`d_id`) REFERENCES `tb_device_detail` (`id`);
ALTER TABLE `tb_device_task`
  ADD CONSTRAINT `fk_tb_device_task_tb_user_1` FOREIGN KEY (`fix_id`) REFERENCES `tb_worker` (`id`);
ALTER TABLE `tb_worker`
  ADD CONSTRAINT `fk_tb_device_repairer_tb_service_team_1` FOREIGN KEY (`service_id`) REFERENCES `tb_service_team` (`id`);
ALTER TABLE `tb_device_task`
  ADD CONSTRAINT `fk_tb_device_task_tb_service_team_1` FOREIGN KEY (`service_id`) REFERENCES `tb_service_team` (`id`);


-- data

insert into `tb_device_address`
values (1, '主楼一楼', '人流较多', NOW(), NOW(), 0)
     , (2, '副楼一楼', '人流较少，', NOW(), NOW(), 0)
     , (3, '数据中心一楼', '人流少，重要地点', NOW(), NOW(), 0);

insert into `tb_maintenance_schedule`
values (1, '短期检查', 5, NOW(), NOW(), 0)
     , (2, '中短期检查', 10, NOW(), NOW(), 0)
     , (3, '中期检查', 15, NOW(), NOW(), 0)
     , (4, '月期检查', 30, NOW(), NOW(), 0)
     , (5, '半年期检查', 150, NOW(), NOW(), 0)
     , (6, '年期检查', 360, NOW(), NOW(), 0);

insert into `tb_maintenance_task`
values (1, '2020-1-5', NOW(), NOW(), 4, 0)
     , (2, '2020-2-5', NOW(), NOW(), 4, 0)
     , (3, '2020-2-5', NOW(), NOW(), 4, 0)
     , (4, '2020-1-1', NOW(), NOW(), 4, 1)
;

insert into `tb_device_class`
values (1, '路由器', '网络路由', '接电、接入网线', NOW(), NOW(), 0)
     , (2, '交换机', '电信号转发', '接电、接入网线', NOW(), NOW(), 0)
     , (3, '防火墙', '软件和硬件设备组合而成的保护屏障', '接电、接入网线', NOW(), NOW(), 0)
     , (4, '服务器', '高性能计算机', '接电、接入网线', NOW(), NOW(), 0);

insert into `tb_device_group`
values (1, '华为 AR1200', '华为', 2770, 10, '端口结构：模块化	\n网络管理：升级管理、设备管理 \n 防火墙：内置防火墙	\n Qos支持：支持 \nVPN支持：支持\n', NOW(),
        NOW(), 1, '路由器', 4, 0)
     , (2, 'TP-LINK TL-R406', 'TP-LINK', 56, 4,
        '端口结构：非模块化	\n广域网接口：1个 \n局域网接口：4个	\n传输速率：10/100Mbps \n网络管理：系统安全日志 远程Web管理 TFTP软件升级\n', NOW(), NOW(), 1, '路由器',
        4, 0)
     , (3, 'Linksys MR9000X', 'Linksys', 1126, 8,
        '路由器类型：家用路由器	\n广域网接口：1个 \n局域网接口：4个	\n传输速率：867Mbps 5GHz+867Mbps \n网络管理：支持 \n', NOW(), NOW(), 1, '路由器', 4, 0)
     , (4, '华为S5720S-28P-LI-AC', '华为', 1900, 8,
        '产品类型：千兆以太网交换机	\n 传输速率：10/100/1000Mbps \n 端口数量：24个	\n 背板带宽：336Gbps/2.56Tbps \nVLAN：支持4K个VLAN支持Guest VLAN、Voice VL \n',
        NOW(), NOW(), 2, '交换机', 4, 0)
     , (5, 'H3C S5130S-28P-EI', 'H3C', 2539, 8,
        '产品类型：千兆以太网交换\n	应用层级：二层 \n 传输速率：10/100/1000Mbps \n	端口数量：28个 \n背板带宽：336Gbps/3.36Tbps \n', NOW(), NOW(), 2,
        '交换机', 4, 0)
     , (6, '锐捷网络 RG-S5750-H', '锐捷网络', 345000, 15,
        '产品类型：千兆以太网交换机 \n	传输速率：10/100/1000Mbps \n端口数量：44个	\nVLAN：支持4K 802.1Q VLAN \n网络管理：SNMPv1/v2c/v3、CLI(Telnet/Console) \n',
        NOW(), NOW(), 2, '交换机', 4, 0)
     , (7, '深信服NGAF-1000-B400', '深信服', 49000, 10,
        '设备类型：下一代防火墙	\n 网络吞吐量：三层吞吐量2G，应用层 \n 并发连接数：500000	\n 网络端口：4个电网口 \n VPN支持：隧道数（最大）1000个IPSec VPN加密速 \n', NOW(),
        NOW(), 3, '防火墙', 4, 0)
     , (8, '华为USG6350', '华为', 19300, 5,
        '设备类型：下一代防火墙	\n吞吐量：16Gbps \n 并发连接数：2800000	 \n 网络端口：最大配置为26个接口 \n VPN支持：支持 \n', NOW(), NOW(), 3, '防火墙', 4, 0)
     , (9, '天融信NGFW4000-UF', '天融信', 255000, 12,
        '设备类型：下一代防火墙	 \n 网络端口：4GE+2Combo \n其他性能：扩展槽位：2×WSIC接	\n电源：AC 100-240V；170W \n 外形设计：1U \n', NOW(), NOW(), 3,
        '防火墙', 4, 0)
     , (10, '浪潮 NF5280M5', '浪潮', 27199, 10,
        '产品类别：机架式	\n CPU型号：Xeon Silver 4110 2. \n 标配CPU数量：1颗	\n 内存容量：64GB DDR4 \n标配硬盘容量：1TB\n', NOW(), NOW(), 4,
        '服务器', 4, 0)
     , (11, '华为 2288H V5', '华为', 10238, 10,
        '产品类别：机架式 \n	产品类型：企业级 \n CPU型号：Xeon Bronze 3106 1.	\n 标配CPU数量：1颗 \n 内存容量：16GB DDR4', NOW(), NOW(), 4,
        '服务器', 4, 0)
     , (12, '戴尔易安信 PowerEdge R730 机架', '戴尔易安信', 11800, 10,
        '产品类别：机架式	 \n CPU型号：Xeon E5-2603 v3 1.6 \n 标配CPU数量：1颗	内存容量：8GB DDR4 \n 标配硬盘容量：1.2TB \n', NOW(), NOW(), 4,
        '服务器', 4, 0);


insert into `tb_device_detail`
values (1, '华为 AR1200', '001122', '2025-05-01', 1, NOW(), NOW(), 1, '路由器', 1, '华为 AR1200', null, null, null, 0)
     , (3, '华为 AR1200', '001123', '2026-09-01', 2, NOW(), NOW(), 1, '路由器', 1, '华为 AR1200', '主楼一楼', '2019-09-01', 2, 0)
     , (2, '华为 AR1200', '001124', '2025-05-01', 3, NOW(), NOW(), 1, '路由器', 1, '华为 AR1200', '数据中心一楼', '2019-05-01', 1, 0)
     , (4, '浪潮 NF5280M5', '001155', '2030-05-01', 4, NOW(), NOW(), 4, '服务器', 10, '浪潮 NF5280M5', '副楼一楼', '2019-05-01', 3,
        0)
     , (5, '华为USG6350', '001133', '2025-05-01', 5, NOW(), NOW(), 3, '防火墙', 8, '华为USG6350', '数据中心一楼', '2019-01-01', 4,
        0);

insert into `tb_service_team`
values (1, '维修一组', '第一线维修员', '2018-02-01', NOW(), 0)
     , (2, '物业一组', '日常设备检查', '2018-02-01', NOW(), 0)
     , (3, '维修二组', '设备安装、卸载', '2018-02-01', NOW(), 0);
insert into `tb_worker`
values (1, '张工', '张三', '5年经验维修工', '2018-02-1', NOW(), 'https://s2.ax1x.com/2020/01/05/lBOWkV.png', '123456', 1, '维修一组',
        '1234567891', '123456', 0)
     , (2, '李工', '李三', '3年经验维修工', '2018-02-1', NOW(), 'https://s2.ax1x.com/2020/01/05/lBOxpD.png', '123456', 1, '维修一组',
        '1234567891', '123456', 0)
     , (3, '王工', '王二', '2年经验检查员', '2018-02-1', NOW(), 'https://s2.ax1x.com/2020/01/05/lBXi7t.png', '123456', 2, '物业一组',
        '1234567891', '123456', 0)
     , (4, '赵工', '赵四', '2年经验维修工', '2018-02-1', NOW(), 'https://s2.ax1x.com/2020/01/05/lBXY3F.png', '123456', 3, '维修二组',
        '1234567891', '123456', 0);

insert into `tb_device_task`
values (1, '日常检查', '编号001123的华为 AR1200，位置主楼一楼', NOW(), NOW(), 1, 1, 2, null, null, 2, '物业一组', 0)
     , (2, '维护', '编号001155的浪潮 NF5280M5，位置副楼一楼', NOW(), NOW(), 2, 1, 4, null, null, 1, '维修一组', 0)
     , (3, '过期质检', '编号001133的华为USG6350，位置数据中心一楼', NOW(), NOW(), 3, 1, 5, null, null, 3, '维修二组', 0)
     , (4, '日常检查', '编号001155的浪潮 NF5280M5，位置副楼一楼', '2019-05-01', NOW(), 1, 3, 2, 1, '张工', 2, '物业一组', 0)
;