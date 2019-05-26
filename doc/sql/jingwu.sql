/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : jingwu

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 26/05/2019 21:56:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for add_point
-- ----------------------------
DROP TABLE IF EXISTS `add_point`;
CREATE TABLE `add_point`  (
  `addId` int(6) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加分人Id',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加分人名称',
  `addPoint` int(4) NULL DEFAULT NULL COMMENT '加分分数',
  `addDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加分描述',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '加分时间',
  PRIMARY KEY (`addId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of add_point
-- ----------------------------
INSERT INTO `add_point` VALUES (1, '3', '严子义', 1, '被子叠的好', '2019-03-29 09:56:27');
INSERT INTO `add_point` VALUES (2, '3', '严子义', 2, '积极参加团学活动', '2019-04-09 21:00:21');
INSERT INTO `add_point` VALUES (3, '3', '严子义', 2, '帮助大队整理台账', '2019-04-08 21:00:26');
INSERT INTO `add_point` VALUES (4, '3', '严子义', 2, '队列会操优胜', '2019-04-11 21:00:31');
INSERT INTO `add_point` VALUES (5, '3', '严子义', 2, '帮助同学', '2019-04-12 21:00:36');
INSERT INTO `add_point` VALUES (6, '3', '严子义', 2, '内务整理到位', '2019-04-06 21:00:41');
INSERT INTO `add_point` VALUES (7, '3', '严子义', 2, 'ctf比赛获奖', '2019-04-05 21:00:45');
INSERT INTO `add_point` VALUES (8, '3', '严子义', 2, '取证比赛获奖', '2019-04-09 21:00:48');

-- ----------------------------
-- Table structure for delete_point
-- ----------------------------
DROP TABLE IF EXISTS `delete_point`;
CREATE TABLE `delete_point`  (
  `deleteId` int(6) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被扣分人Id',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被扣分人名称',
  `deletePoint` int(4) NULL DEFAULT NULL COMMENT '扣除分数',
  `deleteDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扣分描述',
  `deleteTime` datetime(0) NULL DEFAULT NULL COMMENT '扣分时间',
  `checkId` int(11) NULL DEFAULT NULL COMMENT '扣分项目id',
  PRIMARY KEY (`deleteId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of delete_point
-- ----------------------------
INSERT INTO `delete_point` VALUES (1, '3', '严子义', 1, '被子不整齐', '2019-05-25 09:58:10', 1);
INSERT INTO `delete_point` VALUES (2, '3', '严子义', 1, '被子不整齐', '2019-05-25 09:58:11', NULL);
INSERT INTO `delete_point` VALUES (3, '3', '严子义', 1, '牙杯摆放不到位', '2019-05-25 09:58:12', NULL);
INSERT INTO `delete_point` VALUES (4, '3', '严子义', 1, '毛巾摆放不到位', '2019-05-25 09:58:13', NULL);
INSERT INTO `delete_point` VALUES (5, '3', '严子义', 2, '地面脏', '2019-05-25 09:58:14', NULL);
INSERT INTO `delete_point` VALUES (6, '3', '严子义', 2, '厕所地面脏', '2019-05-25 09:58:15', NULL);
INSERT INTO `delete_point` VALUES (8, '3', '严子义', 2, '书架脏', '2019-05-25 09:58:16', NULL);
INSERT INTO `delete_point` VALUES (9, '3', '严子义', 2, '脸盆架脏', '2019-05-25 09:58:17', NULL);
INSERT INTO `delete_point` VALUES (14, '1526002', '同学11', 1, '被子质量较差', '2019-05-25 09:58:18', NULL);
INSERT INTO `delete_point` VALUES (15, '3', '严子义', 1, '集合迟到', '2019-05-25 09:58:19', NULL);

-- ----------------------------
-- Table structure for punish
-- ----------------------------
DROP TABLE IF EXISTS `punish`;
CREATE TABLE `punish`  (
  `punishId` int(6) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被惩罚人Id',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被惩罚人名称',
  `punishReason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '惩罚原因',
  `punishComplete` int(1) NULL DEFAULT NULL COMMENT '惩罚是否完成 1：完成 2：未完成',
  `punishDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '惩罚描述',
  `punishTime` datetime(0) NULL DEFAULT NULL COMMENT '惩罚时间',
  PRIMARY KEY (`punishId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punish
-- ----------------------------
INSERT INTO `punish` VALUES (1, '3', '严子义', '扣班级分数1', 1, '10圈', '2019-03-27 10:03:59');
INSERT INTO `punish` VALUES (2, '3', '严子义', '扣班级分数2', 2, '10圈', '2019-04-11 22:27:56');
INSERT INTO `punish` VALUES (3, '3', '严子义', '扣班级分数3', 1, '10圈', '2019-04-09 22:27:59');
INSERT INTO `punish` VALUES (4, '3', '严子义', '扣班级分数4', 1, '10圈', '2019-04-08 22:28:03');
INSERT INTO `punish` VALUES (5, '3', '严子义', '扣班级分数5', 2, '10圈', '2019-04-02 22:57:14');

-- ----------------------------
-- Table structure for reward
-- ----------------------------
DROP TABLE IF EXISTS `reward`;
CREATE TABLE `reward`  (
  `rewardId` int(6) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rewardReason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖励原因',
  `rewardDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖励描述',
  `rewardTime` datetime(0) NULL DEFAULT NULL COMMENT '奖励时间',
  PRIMARY KEY (`rewardId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reward
-- ----------------------------
INSERT INTO `reward` VALUES (1, '3', '严子义', '一等奖', '浙江警察学院ctf大赛', '2019-04-11 21:41:33');
INSERT INTO `reward` VALUES (2, '3', '严子义', '二等奖', '浙江警察学院电子取证大赛', '2019-04-12 21:42:25');
INSERT INTO `reward` VALUES (3, '3', '严子义', '三等奖', '浙江警察学院程序设计大赛', '2019-04-13 21:42:45');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `qdId` int(6) NOT NULL AUTO_INCREMENT,
  `qdbm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区队编码',
  `qdmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区队名称',
  `qdkp` int(4) NULL DEFAULT NULL COMMENT '区队考评分数',
  `qdrs` int(5) NULL DEFAULT NULL COMMENT '区队人数',
  PRIMARY KEY (`qdId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (1, 'zjjcxy001', '15网安一区队', 1089, 30);
INSERT INTO `team` VALUES (2, 'zjjcxy002', '15网安二区队', 1100, 30);
INSERT INTO `team` VALUES (3, 'zjjcxy003', '15网安三区队', 1199, 30);
INSERT INTO `team` VALUES (4, 'zjjcxy004', '15反恐一区队', 1200, 30);

-- ----------------------------
-- Table structure for team_del
-- ----------------------------
DROP TABLE IF EXISTS `team_del`;
CREATE TABLE `team_del`  (
  `qdId` int(6) NULL DEFAULT NULL COMMENT '区队Id',
  `qdbm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区队编码',
  `kf` int(4) NULL DEFAULT NULL COMMENT '扣除分数',
  `kfTime` datetime(0) NULL DEFAULT NULL COMMENT '扣分时间',
  `xqs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学期：如2018第2学期',
  `checkId` int(6) NULL DEFAULT NULL COMMENT '扣分项目Id',
  `weekNum` int(2) NULL DEFAULT NULL COMMENT '周数'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_del
-- ----------------------------
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 7, '2019-02-22 16:25:12', '2019第1学期', 1, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 10, '2019-02-22 16:25:17', '2019第1学期', 1, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 4, '2019-02-23 16:25:21', '2019第1学期', 2, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 6, '2019-02-22 16:25:26', '2019第1学期', 2, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy003', 7, '2019-02-24 16:25:30', '2019第1学期', 2, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy003', 3, '2019-02-24 16:25:33', '2019第1学期', 2, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 8, '2019-04-19 16:25:37', '2019第1学期', 3, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 4, '2019-04-18 16:25:41', '2019第1学期', 3, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 6, '2019-04-18 16:26:29', '2019第1学期', 5, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy003', 5, '2019-04-17 16:26:32', '2019第1学期', 4, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy004', 6, '2019-04-16 16:26:37', '2019第1学期', 4, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy004', 4, '2019-04-15 16:26:41', '2019第1学期', 5, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy004', 2, '2019-04-16 16:26:44', '2019第1学期', 6, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy003', 9, '2019-04-25 16:26:49', '2019第1学期', 6, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 9, '2019-04-22 16:26:53', '2019第1学期', 6, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 6, '2018-09-01 16:15:20', '2018第2学期', 3, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 3, '2018-09-08 16:16:20', '2018第2学期', 2, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 2, '2018-09-02 18:15:20', '2018第2学期', 1, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 6, '2018-09-03 17:15:20', '2018第2学期', 1, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 9, '2018-09-10 16:18:01', '2018第2学期', 5, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy003', 6, '2018-09-04 19:38:37', '2018第2学期', 1, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy003', 5, '2018-09-15 19:37:37', '2018第2学期', 3, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy004', 6, '2018-09-05 19:38:37', '2018第2学期', 4, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy004', 5, '2018-09-13 19:36:37', '2018第2学期', 3, 2);
INSERT INTO `team_del` VALUES (1, 'zjjcxy003', 3, '2018-09-06 18:28:37', '2018第2学期', 6, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy004', 5, '2018-09-07 18:27:37', '2018第2学期', 4, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 5, '2018-09-06 18:28:09', '2018第2学期', 2, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 2, '2018-09-05 18:28:03', '2018第2学期', 4, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy001', 7, '2018-09-04 18:28:45', '2018第2学期', 5, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 4, '2018-09-03 18:15:20', '2018第2学期', 2, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 3, '2018-09-04 18:15:20', '2018第2学期', 3, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 6, '2018-09-05 18:15:20', '2018第2学期', 4, 1);
INSERT INTO `team_del` VALUES (1, 'zjjcxy002', 4, '2018-09-06 18:15:20', '2018第2学期', 5, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permissionDegree` int(1) NULL DEFAULT NULL COMMENT '权限级别',
  `qdbm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区队编码',
  `kpfs` double(4, 0) NULL DEFAULT NULL COMMENT '考评分数',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `qshm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寝室号码',
  `xb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王勋', '1', 1, '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('1526001', '同学10', '123456', 3, 'zjjcxy001', 90, '18189754895', '5984848@qq.com', '26-522', '男');
INSERT INTO `user` VALUES ('1526002', '同学11', '123456', 3, 'zjjcxy001', 99, '18189754895', '5984849@qq.com', '26-523', '男');
INSERT INTO `user` VALUES ('1526003', '同学12', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984850@qq.com', '26-524', '男');
INSERT INTO `user` VALUES ('1526004', '同学13', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984851@qq.com', '26-525', '男');
INSERT INTO `user` VALUES ('1526005', '同学14', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984852@qq.com', '26-526', '男');
INSERT INTO `user` VALUES ('1526006', '同学15', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984853@qq.com', '26-527', '男');
INSERT INTO `user` VALUES ('1526007', '同学16', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984854@qq.com', '26-528', '男');
INSERT INTO `user` VALUES ('1526008', '同学17', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984855@qq.com', '26-529', '男');
INSERT INTO `user` VALUES ('1526009', '同学18', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984856@qq.com', '26-530', '男');
INSERT INTO `user` VALUES ('1526010', '同学19', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984857@qq.com', '26-531', '男');
INSERT INTO `user` VALUES ('1526011', '同学20', '123456', 3, 'zjjcxy001', 100, '18189754895', '5984858@qq.com', '26-532', '男');
INSERT INTO `user` VALUES ('1526012', '同学21', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984859@qq.com', '26-533', '男');
INSERT INTO `user` VALUES ('1526013', '同学22', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984860@qq.com', '26-534', '男');
INSERT INTO `user` VALUES ('1526014', '同学23', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984861@qq.com', '26-535', '男');
INSERT INTO `user` VALUES ('1526015', '同学24', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984862@qq.com', '26-536', '男');
INSERT INTO `user` VALUES ('1526016', '同学25', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984863@qq.com', '26-537', '男');
INSERT INTO `user` VALUES ('1526017', '同学26', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984864@qq.com', '26-538', '男');
INSERT INTO `user` VALUES ('1526018', '同学27', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984865@qq.com', '26-539', '男');
INSERT INTO `user` VALUES ('1526019', '同学28', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984866@qq.com', '26-540', '男');
INSERT INTO `user` VALUES ('1526020', '同学29', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984867@qq.com', '26-541', '男');
INSERT INTO `user` VALUES ('1526021', '同学30', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984868@qq.com', '26-542', '男');
INSERT INTO `user` VALUES ('1526022', '同学31', '123456', 3, 'zjjcxy002', 100, '18189754895', '5984869@qq.com', '26-543', '男');
INSERT INTO `user` VALUES ('1526023', '同学32', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984870@qq.com', '26-544', '男');
INSERT INTO `user` VALUES ('1526024', '同学33', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984871@qq.com', '26-545', '男');
INSERT INTO `user` VALUES ('1526025', '同学34', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984872@qq.com', '26-546', '男');
INSERT INTO `user` VALUES ('1526026', '同学35', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984873@qq.com', '26-547', '男');
INSERT INTO `user` VALUES ('1526027', '同学36', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984874@qq.com', '26-548', '男');
INSERT INTO `user` VALUES ('1526028', '同学37', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984875@qq.com', '26-549', '男');
INSERT INTO `user` VALUES ('1526029', '同学38', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984876@qq.com', '26-550', '男');
INSERT INTO `user` VALUES ('1526030', '同学39', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984877@qq.com', '26-551', '男');
INSERT INTO `user` VALUES ('1526031', '同学40', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984878@qq.com', '26-552', '男');
INSERT INTO `user` VALUES ('1526032', '同学41', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984879@qq.com', '26-553', '男');
INSERT INTO `user` VALUES ('1526033', '同学42', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984880@qq.com', '26-554', '男');
INSERT INTO `user` VALUES ('1526034', '同学43', '123456', 3, 'zjjcxy004', 100, '18189754895', '5984881@qq.com', '26-555', '男');
INSERT INTO `user` VALUES ('1526060', '同学1', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984848@qq.com', '26-522', '男');
INSERT INTO `user` VALUES ('1526061', '同学2', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984849@qq.com', '26-523', '男');
INSERT INTO `user` VALUES ('1526062', '同学3', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984850@qq.com', '26-524', '男');
INSERT INTO `user` VALUES ('1526063', '同学4', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984851@qq.com', '26-525', '男');
INSERT INTO `user` VALUES ('1526064', '同学5', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984852@qq.com', '26-526', '男');
INSERT INTO `user` VALUES ('1526065', '同学6', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984853@qq.com', '26-527', '男');
INSERT INTO `user` VALUES ('1526066', '同学7', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984854@qq.com', '26-528', '男');
INSERT INTO `user` VALUES ('1526067', '同学8', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984855@qq.com', '26-529', '男');
INSERT INTO `user` VALUES ('1526068', '同学9', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984856@qq.com', '26-530', '男');
INSERT INTO `user` VALUES ('1526069', '同学10', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984857@qq.com', '26-531', '男');
INSERT INTO `user` VALUES ('1526089', '包珂华', '123456', 3, 'zjjcxy003', 100, '18189754895', '5984848@qq.com', '26-522', '男');
INSERT INTO `user` VALUES ('2', '干部', '2', 2, 'zjjc1591801', 100, '17757180496', 'cccc@qq.com', '7-202', '女');
INSERT INTO `user` VALUES ('3', '严子义', '3', 3, 'zjjcxy003', 99, '15700122303', 'dddz97@163.com', '6-503', '男');

-- ----------------------------
-- Table structure for user_wj
-- ----------------------------
DROP TABLE IF EXISTS `user_wj`;
CREATE TABLE `user_wj`  (
  `wjId` int(6) NOT NULL AUTO_INCREMENT,
  `wjMs` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪描述',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪人名称',
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪人Id',
  `wjPoint` int(4) NULL DEFAULT NULL COMMENT '违纪扣除分数',
  `wjTime` datetime(0) NULL DEFAULT NULL COMMENT '违纪时间',
  `wjcl` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪处理结果',
  `wjdj` int(1) NULL DEFAULT NULL COMMENT '违纪等级1-5',
  `wjdjms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪等级说明',
  PRIMARY KEY (`wjId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_wj
-- ----------------------------
INSERT INTO `user_wj` VALUES (1, '学校违纪学生通报 XXXX年X月X日上午九点三十七分，X班XXX在XXX楼二楼楼道对XXX进行殴打。上述X名的违纪行为，事实清楚，情节恶劣。严重违反校规、校纪。给学校正常的教育教学活动带来严重冲击，影响极坏。', '严子义', '3', 50, '2019-05-04 20:53:48', '依据XXX中学学生违纪处罚条例，经过校委会研究决定，本着帮助教育的原则，给她们一个改正错误的机会，决定给予以上X名同学开除学籍，留校察看一年处分。受到纪律处分的五名同学在处分没有撤销前，不能评为“三好学生”，', 1, '口头警告');
INSERT INTO `user_wj` VALUES (2, '学校违纪学生通报 XXXX年X月X日上午九点三十七分，X班XXX在XXX楼二楼楼道对XXX进行殴打，造成XXX至今还在医院治疗。上述X名的违纪行为，事实清楚，情节恶劣。严重违反校规、校纪。给学校正常的教育教学活动带来严重冲击，影响极坏。', '严子义', '3', 50, '2019-05-04 20:53:48', '依据XXX中学学生违纪处罚条例，经过校委会研究决定，本着帮助教育的原则，给她们一个改正错误的机会，决定给予以上X名同学开除学籍，留校察看一年处分。受到纪律处分的五名同学在处分没有撤销前，不能评为“三好学生”，', 2, '警告');
INSERT INTO `user_wj` VALUES (3, '学校违纪学生通报 XXXX年X月X日上午九点三十七分，X班XXX在XXX楼二楼楼道对XXX进行殴打，造成XXX至今还在医院治疗。上述X名的违纪行为，事实清楚，情节恶劣。严重违反校规、校纪。给学校正常的教育教学活动带来严重冲击，影响极坏。', '严子义', '3', 50, '2019-05-04 20:53:48', '依据XXX中学学生违纪处罚条例，经过校委会研究决定，本着帮助教育的原则，给她们一个改正错误的机会，决定给予以上X名同学开除学籍，留校察看一年处分。受到纪律处分的五名同学在处分没有撤销前，不能评为“三好学生”，', 3, '严重警告');
INSERT INTO `user_wj` VALUES (4, '学校违纪学生通报 XXXX年X月X日上午九点三十七分，X班XXX在XXX楼二楼楼道对XXX进行殴打，造成XXX至今还在医院治疗。上述X名的违纪行为，事实清楚，情节恶劣。严重违反校规、校纪。给学校正常的教育教学活动带来严重冲击，影响极坏。', '严子义', '3', 50, '2019-05-04 20:53:48', '依据XXX中学学生违纪处罚条例，经过校委会研究决定，本着帮助教育的原则，给她们一个改正错误的机会，决定给予以上X名同学开除学籍，留校察看一年处分。受到纪律处分的五名同学在处分没有撤销前，不能评为“三好学生”，', 4, '记过');
INSERT INTO `user_wj` VALUES (5, '学校违纪学生通报 XXXX年X月X日上午九点三十七分，X班XXX在XXX楼二楼楼道对XXX进行殴打，造成XXX至今还在医院治疗。上述X名的违纪行为，事实清楚，情节恶劣。严重违反校规、校纪。给学校正常的教育教学活动带来严重冲击，影响极坏。', '严子义', '3', 50, '2019-05-04 20:53:48', '依据XXX中学学生违纪处罚条例，经过校委会研究决定，本着帮助教育的原则，给她们一个改正错误的机会，决定给予以上X名同学开除学籍，留校察看一年处分。受到纪律处分的五名同学在处分没有撤销前，不能评为“三好学生”，', 5, '记大过');
INSERT INTO `user_wj` VALUES (9, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', '女干部', '2', 10, '2019-04-29 00:00:00', 'cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc', 3, '严重警告');
INSERT INTO `user_wj` VALUES (10, '顶顶顶', '同学10', '1526001', 10, '2019-05-10 00:00:00', 'sss', 2, '警告');

-- ----------------------------
-- Table structure for user_wj_tj
-- ----------------------------
DROP TABLE IF EXISTS `user_wj_tj`;
CREATE TABLE `user_wj_tj`  (
  `wjId` int(6) NOT NULL AUTO_INCREMENT,
  `wjMs` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪描述',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪人名称',
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪人Id',
  `wjPoint` int(4) NULL DEFAULT NULL COMMENT '违纪扣除分数',
  `wjTime` datetime(0) NULL DEFAULT NULL COMMENT '违纪时间',
  `wjcl` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪处理结果',
  `wjdj` int(1) NULL DEFAULT NULL COMMENT '违纪等级1-5',
  `wjdjms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪等级说明',
  PRIMARY KEY (`wjId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for weak_check
-- ----------------------------
DROP TABLE IF EXISTS `weak_check`;
CREATE TABLE `weak_check`  (
  `checkId` int(6) NOT NULL AUTO_INCREMENT,
  `checkName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查名称',
  `checkDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查描述',
  `checkPoint` int(4) NULL DEFAULT NULL COMMENT '检查分数',
  `isNow` int(1) NULL DEFAULT NULL COMMENT '1本周，2上周',
  PRIMARY KEY (`checkId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weak_check
-- ----------------------------
INSERT INTO `weak_check` VALUES (1, '寝室卫生清洁度', '寝室卫生清洁度', 10, 2);
INSERT INTO `weak_check` VALUES (2, '寝室卫生摆放', '寝室卫生摆放', 10, 2);
INSERT INTO `weak_check` VALUES (3, '集合秩序', '集合秩序', 10, 2);
INSERT INTO `weak_check` VALUES (4, '警容风纪', '警容风纪', 10, 2);
INSERT INTO `weak_check` VALUES (5, '队列秩序', '队列秩序', 10, 2);
INSERT INTO `weak_check` VALUES (6, '上课秩序', '上课秩序', 10, 2);

SET FOREIGN_KEY_CHECKS = 1;
