/*
 Navicat Premium Data Transfer

 Source Server         : 172.17.0.3_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 172.17.0.3:3306
 Source Schema         : device

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 05/01/2020 15:11:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_device_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_device_address`;
CREATE TABLE `tb_device_address`
(
  `id`            int(11)     NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `desc`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time`   datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `flag`          int(11)     NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_device_address
-- ----------------------------
INSERT INTO `tb_device_address`
VALUES (1, '主楼一楼', '人流较多', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_device_address`
VALUES (2, '副楼一楼', '人流较少，', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_device_address`
VALUES (3, '数据中心一楼', '人流少，重要地点', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);

-- ----------------------------
-- Table structure for tb_device_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_device_class`;
CREATE TABLE `tb_device_class`
(
  `id`            int(11)     NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `function`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `scene`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time`   datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `flag`          int(11)     NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_device_class
-- ----------------------------
INSERT INTO `tb_device_class`
VALUES (1, '路由器', '网络路由', '接电、接入网线', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_device_class`
VALUES (2, '交换机', '电信号转发', '接电、接入网线', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_device_class`
VALUES (3, '防火墙', '软件和硬件设备组合而成的保护屏障', '接电、接入网线', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_device_class`
VALUES (4, '服务器', '高性能计算机', '接电、接入网线', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);

-- ----------------------------
-- Table structure for tb_device_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_device_detail`;
CREATE TABLE `tb_device_detail`
(
  `id`            int(11)     NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `code`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `end_date`      date        NULL DEFAULT NULL,
  `status`        tinyint(4)  NULL DEFAULT NULL,
  `create_time`   datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `clz_id`        int(11)     NULL DEFAULT NULL,
  `clz_name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `group_id`      int(11)     NULL DEFAULT NULL,
  `group_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `install_date`  date        NULL DEFAULT NULL,
  `mt_id`         int(11)     NULL DEFAULT NULL,
  `flag`          int(11)     NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX           `fk_tb_device_detail_tb_device_group_1`(`group_id`) USING BTREE,
  INDEX           `fk_tb_device_detail_tb_maintenance_task_1`(`mt_id`) USING BTREE,
  CONSTRAINT `fk_tb_device_detail_tb_device_group_1` FOREIGN KEY (`group_id`) REFERENCES `tb_device_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_tb_device_detail_tb_maintenance_task_1` FOREIGN KEY (`mt_id`) REFERENCES `tb_maintenance_task` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_device_detail
-- ----------------------------
INSERT INTO `tb_device_detail`
VALUES (1, '华为 AR1200', '001122', '2025-05-01', 1, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 1, '路由器', 1,
        '华为 AR1200', NULL, NULL, NULL, 0);
INSERT INTO `tb_device_detail`
VALUES (2, '华为 AR1200', '001124', '2025-05-01', 3, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 1, '路由器', 1,
        '华为 AR1200', '数据中心一楼', '2025-05-01', 1, 0);
INSERT INTO `tb_device_detail`
VALUES (3, '华为 AR1200', '001123', '2026-09-01', 2, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 1, '路由器', 1,
        '华为 AR1200', '主楼一楼', '2019-09-01', 2, 0);
INSERT INTO `tb_device_detail`
VALUES (4, '浪潮 NF5280M5', '001155', '2030-05-01', 4, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 4, '服务器', 10,
        '浪潮 NF5280M5', '副楼一楼', '2025-05-01', 3, 0);
INSERT INTO `tb_device_detail`
VALUES (5, '华为USG6350', '001133', '2025-05-01', 5, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 3, '防火墙', 8,
        '华为USG6350', '数据中心一楼', '2020-01-01', 4, 0);

-- ----------------------------
-- Table structure for tb_device_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_device_group`;
CREATE TABLE `tb_device_group`
(
  `id`            int(11)        NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `firm`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price`         decimal(10, 2) NULL DEFAULT NULL,
  `durable_years` tinyint(4)     NULL DEFAULT NULL,
  `desc`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time`   datetime(0)    NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0)    NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `clz_id`        int(11)        NULL DEFAULT NULL,
  `clz_name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ms_id`         int(11)        NULL DEFAULT NULL,
  `flag`          int(11)        NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX           `fk_tb_device_group_tb_maintenance_schedule_1`(`ms_id`) USING BTREE,
  INDEX           `fk_tb_device_group_tb_device_class_1`(`clz_id`) USING BTREE,
  CONSTRAINT `fk_tb_device_group_tb_device_class_1` FOREIGN KEY (`clz_id`) REFERENCES `tb_device_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_tb_device_group_tb_maintenance_schedule_1` FOREIGN KEY (`ms_id`) REFERENCES `tb_maintenance_schedule` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_device_group
-- ----------------------------
INSERT INTO `tb_device_group`
VALUES (1, '华为 AR1200', '华为', 2770.00, 10, '端口结构：模块化	\n网络管理：升级管理、设备管理 \n 防火墙：内置防火墙	\n Qos支持：支持 \nVPN支持：支持\n',
        '2020-01-05 07:09:32', '2020-01-05 07:09:32', 1, '路由器', 4, 0);
INSERT INTO `tb_device_group`
VALUES (2, 'TP-LINK TL-R406', 'TP-LINK', 56.00, 4,
        '端口结构：非模块化	\n广域网接口：1个 \n局域网接口：4个	\n传输速率：10/100Mbps \n网络管理：系统安全日志 远程Web管理 TFTP软件升级\n', '2020-01-05 07:09:32',
        '2020-01-05 07:09:32', 1, '路由器', 4, 0);
INSERT INTO `tb_device_group`
VALUES (3, 'Linksys MR9000X', 'Linksys', 1126.00, 8,
        '路由器类型：家用路由器	\n广域网接口：1个 \n局域网接口：4个	\n传输速率：867Mbps 5GHz+867Mbps \n网络管理：支持 \n', '2020-01-05 07:09:32',
        '2020-01-05 07:09:32', 1, '路由器', 4, 0);
INSERT INTO `tb_device_group`
VALUES (4, '华为S5720S-28P-LI-AC', '华为', 1900.00, 8,
        '产品类型：千兆以太网交换机	\n 传输速率：10/100/1000Mbps \n 端口数量：24个	\n 背板带宽：336Gbps/2.56Tbps \nVLAN：支持4K个VLAN支持Guest VLAN、Voice VL \n',
        '2020-01-05 07:09:32', '2020-01-05 07:09:32', 2, '交换机', 4, 0);
INSERT INTO `tb_device_group`
VALUES (5, 'H3C S5130S-28P-EI', 'H3C', 2539.00, 8,
        '产品类型：千兆以太网交换\n	应用层级：二层 \n 传输速率：10/100/1000Mbps \n	端口数量：28个 \n背板带宽：336Gbps/3.36Tbps \n',
        '2020-01-05 07:09:32', '2020-01-05 07:09:32', 2, '交换机', 4, 0);
INSERT INTO `tb_device_group`
VALUES (6, '锐捷网络 RG-S5750-H', '锐捷网络', 345000.00, 15,
        '产品类型：千兆以太网交换机 \n	传输速率：10/100/1000Mbps \n端口数量：44个	\nVLAN：支持4K 802.1Q VLAN \n网络管理：SNMPv1/v2c/v3、CLI(Telnet/Console) \n',
        '2020-01-05 07:09:32', '2020-01-05 07:09:32', 2, '交换机', 4, 0);
INSERT INTO `tb_device_group`
VALUES (7, '深信服NGAF-1000-B400', '深信服', 49000.00, 10,
        '设备类型：下一代防火墙	\n 网络吞吐量：三层吞吐量2G，应用层 \n 并发连接数：500000	\n 网络端口：4个电网口 \n VPN支持：隧道数（最大）1000个IPSec VPN加密速 \n',
        '2020-01-05 07:09:32', '2020-01-05 07:09:32', 3, '防火墙', 4, 0);
INSERT INTO `tb_device_group`
VALUES (8, '华为USG6350', '华为', 19300.00, 5,
        '设备类型：下一代防火墙	\n吞吐量：16Gbps \n 并发连接数：2800000	 \n 网络端口：最大配置为26个接口 \n VPN支持：支持 \n', '2020-01-05 07:09:32',
        '2020-01-05 07:09:32', 3, '防火墙', 4, 0);
INSERT INTO `tb_device_group`
VALUES (9, '天融信NGFW4000-UF', '天融信', 255000.00, 12,
        '设备类型：下一代防火墙	 \n 网络端口：4GE+2Combo \n其他性能：扩展槽位：2×WSIC接	\n电源：AC 100-240V；170W \n 外形设计：1U \n',
        '2020-01-05 07:09:32', '2020-01-05 07:09:32', 3, '防火墙', 4, 0);
INSERT INTO `tb_device_group`
VALUES (10, '浪潮 NF5280M5', '浪潮', 27199.00, 10,
        '产品类别：机架式	\n CPU型号：Xeon Silver 4110 2. \n 标配CPU数量：1颗	\n 内存容量：64GB DDR4 \n标配硬盘容量：1TB\n', '2020-01-05 07:09:32',
        '2020-01-05 07:09:32', 4, '服务器', 4, 0);
INSERT INTO `tb_device_group`
VALUES (11, '华为 2288H V5', '华为', 10238.00, 10,
        '产品类别：机架式 \n	产品类型：企业级 \n CPU型号：Xeon Bronze 3106 1.	\n 标配CPU数量：1颗 \n 内存容量：16GB DDR4', '2020-01-05 07:09:32',
        '2020-01-05 07:09:32', 4, '服务器', 4, 0);
INSERT INTO `tb_device_group`
VALUES (12, '戴尔易安信 PowerEdge R730 机架', '戴尔易安信', 11800.00, 10,
        '产品类别：机架式	 \n CPU型号：Xeon E5-2603 v3 1.6 \n 标配CPU数量：1颗	内存容量：8GB DDR4 \n 标配硬盘容量：1.2TB \n',
        '2020-01-05 07:09:32', '2020-01-05 07:09:32', 4, '服务器', 4, 0);

-- ----------------------------
-- Table structure for tb_device_task
-- ----------------------------
DROP TABLE IF EXISTS `tb_device_task`;
CREATE TABLE `tb_device_task`
(
  `id`            int(11)     NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `desc`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time`   datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `type`          tinyint(4)  NULL DEFAULT NULL COMMENT '任务类型',
  `status`        tinyint(4)  NULL DEFAULT NULL,
  `d_id`          int(11)     NULL DEFAULT NULL,
  `fix_id`        int(11)     NULL DEFAULT NULL,
  `fix_name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `service_id`    int(11)     NULL DEFAULT NULL,
  `service_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `flag`          int(11)     NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX           `fk_tb_device_task_tb_device_detail_1`(`d_id`) USING BTREE,
  INDEX           `fk_tb_device_task_tb_user_1`(`fix_id`) USING BTREE,
  INDEX           `fk_tb_device_task_tb_service_team_1`(`service_id`) USING BTREE,
  CONSTRAINT `fk_tb_device_task_tb_device_detail_1` FOREIGN KEY (`d_id`) REFERENCES `tb_device_detail` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_tb_device_task_tb_service_team_1` FOREIGN KEY (`service_id`) REFERENCES `tb_service_team` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_tb_device_task_tb_user_1` FOREIGN KEY (`fix_id`) REFERENCES `tb_worker` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_device_task
-- ----------------------------
INSERT INTO `tb_device_task`
VALUES (1, '日常检查', '编号001123的华为 AR1200，位置主楼一楼', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 1, 1, 2, NULL, NULL, 2,
        '物业一组', 0);
INSERT INTO `tb_device_task`
VALUES (2, '维护', '编号001155的浪潮 NF5280M5，位置副楼一楼', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 2, 1, 4, NULL, NULL, 1,
        '维修一组', 0);
INSERT INTO `tb_device_task`
VALUES (3, '过期质检', '编号001133的华为USG6350，位置数据中心一楼', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 3, 1, 5, NULL, NULL, 3,
        '维修二组', 0);
INSERT INTO `tb_device_task`
VALUES (4, '日常检查', '编号001155的浪潮 NF5280M5，位置副楼一楼', '2019-05-01 00:00:00', '2020-01-05 07:09:32', 1, 3, 2, 1, '张工', 2,
        '物业一组', 0);

-- ----------------------------
-- Table structure for tb_maintenance_schedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_maintenance_schedule`;
CREATE TABLE `tb_maintenance_schedule`
(
  `id`            int(11)     NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `period`        smallint(6) NULL DEFAULT NULL,
  `create_time`   datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `flag`          int(11)     NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_maintenance_schedule
-- ----------------------------
INSERT INTO `tb_maintenance_schedule`
VALUES (1, '短期检查', 5, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_maintenance_schedule`
VALUES (2, '中短期检查', 10, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_maintenance_schedule`
VALUES (3, '中期检查', 15, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_maintenance_schedule`
VALUES (4, '月期检查', 30, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_maintenance_schedule`
VALUES (5, '半年期检查', 150, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_maintenance_schedule`
VALUES (6, '年期检查', 360, '2020-01-05 07:09:32', '2020-01-05 07:09:32', 0);

-- ----------------------------
-- Table structure for tb_maintenance_task
-- ----------------------------
DROP TABLE IF EXISTS `tb_maintenance_task`;
CREATE TABLE `tb_maintenance_task`
(
  `id`            int(11)     NOT NULL,
  `next_days`     date        NULL DEFAULT NULL,
  `create_time`   datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `ms_id`         int(11)     NULL DEFAULT NULL,
  `flag`          int(11)     NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX           `fk_tb_maintenance_task_tb_maintenance_schedule_1`(`ms_id`) USING BTREE,
  CONSTRAINT `fk_tb_maintenance_task_tb_maintenance_schedule_1` FOREIGN KEY (`ms_id`) REFERENCES `tb_maintenance_schedule` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_maintenance_task
-- ----------------------------
INSERT INTO `tb_maintenance_task`
VALUES (1, '2020-01-05', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 4, 0);
INSERT INTO `tb_maintenance_task`
VALUES (2, '2020-02-05', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 4, 0);
INSERT INTO `tb_maintenance_task`
VALUES (3, '2020-02-05', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 4, 0);
INSERT INTO `tb_maintenance_task`
VALUES (4, '2020-01-01', '2020-01-05 07:09:32', '2020-01-05 07:09:32', 4, 1);

-- ----------------------------
-- Table structure for tb_service_team
-- ----------------------------
DROP TABLE IF EXISTS `tb_service_team`;
CREATE TABLE `tb_service_team`
(
  `id`            int(11)     NOT NULL AUTO_INCREMENT,
  `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `desc`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time`   datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `flag`          int(11)     NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_service_team
-- ----------------------------
INSERT INTO `tb_service_team`
VALUES (1, '维修一组', '第一线维修员', '2018-02-01 00:00:00', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_service_team`
VALUES (2, '物业一组', '日常设备检查', '2018-02-01 00:00:00', '2020-01-05 07:09:32', 0);
INSERT INTO `tb_service_team`
VALUES (3, '维修二组', '设备安装、卸载', '2018-02-01 00:00:00', '2020-01-05 07:09:32', 0);

-- ----------------------------
-- Table structure for tb_worker
-- ----------------------------
DROP TABLE IF EXISTS `tb_worker`;
CREATE TABLE `tb_worker`
(
  `id`            int(11)     NOT NULL AUTO_INCREMENT,
  `nick_name`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `real_name`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `desc`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time`   datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `avatar_url`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `open_id`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `service_id`    int(11)     NULL DEFAULT NULL,
  `service_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `flag`          int(11)     NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX           `fk_tb_device_repairer_tb_service_team_1`(`service_id`) USING BTREE,
  CONSTRAINT `fk_tb_device_repairer_tb_service_team_1` FOREIGN KEY (`service_id`) REFERENCES `tb_service_team` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_worker
-- ----------------------------
INSERT INTO `tb_worker`
VALUES (1, '张工', '张三', '5年经验维修工', '2018-02-01 00:00:00', '2020-01-05 07:09:32',
        'https://s2.ax1x.com/2020/01/05/lBOWkV.png', '123456', 1, '维修一组', '1234567891', '123456', 0);
INSERT INTO `tb_worker`
VALUES (2, '李工', '李三', '3年经验维修工', '2018-02-01 00:00:00', '2020-01-05 07:09:32',
        'https://s2.ax1x.com/2020/01/05/lBOxpD.png', '123456', 1, '维修一组', '1234567891', '123456', 0);
INSERT INTO `tb_worker`
VALUES (3, '王工', '王二', '2年经验检查员', '2018-02-01 00:00:00', '2020-01-05 07:09:32',
        'https://s2.ax1x.com/2020/01/05/lBXi7t.png', '123456', 2, '物业一组', '1234567891', '123456', 0);
INSERT INTO `tb_worker`
VALUES (4, '赵工', '赵四', '2年经验维修工', '2018-02-01 00:00:00', '2020-01-05 07:09:32',
        'https://s2.ax1x.com/2020/01/05/lBXY3F.png', '123456', 3, '维修二组', '1234567891', '123456', 0);

SET FOREIGN_KEY_CHECKS = 1;

