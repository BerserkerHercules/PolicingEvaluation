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

 Date: 10/04/2019 17:42:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for add_point
-- ----------------------------
DROP TABLE IF EXISTS `add_point`;
CREATE TABLE `add_point`  (
  `addId` int(6) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '加分人Id',
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '加分人名称',
  `addPoint` int(4) NULL DEFAULT NULL COMMENT '加分分数',
  `addDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '加分描述',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '加分时间',
  PRIMARY KEY (`addId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of add_point
-- ----------------------------
INSERT INTO `add_point` VALUES (1, '2', '严子义', 10, '救1人', '2019-03-29 09:56:27');
INSERT INTO `add_point` VALUES (2, '2', '严子义', 20, '救2人', '2019-04-10 15:12:10');
INSERT INTO `add_point` VALUES (3, '2', '严子义', 11, '3人', '2019-04-09 15:59:49');
INSERT INTO `add_point` VALUES (4, '2', '严子义', 22, '4人', '2019-04-08 15:59:54');
INSERT INTO `add_point` VALUES (5, '2', '严子义', 33, '5人', '2019-04-07 15:59:58');
INSERT INTO `add_point` VALUES (6, '2', '严子义', 44, '6人', '2019-04-06 16:00:01');
INSERT INTO `add_point` VALUES (7, '2', '严子义', 55, '7人', '2019-04-05 16:00:04');

-- ----------------------------
-- Table structure for advice
-- ----------------------------
DROP TABLE IF EXISTS `advice`;
CREATE TABLE `advice`  (
  `adviceId` int(6) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '建议题目',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '建议内容',
  `isCross` int(1) NULL DEFAULT NULL COMMENT '1：已通过，2：未通过',
  `orderTime` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`adviceId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advice
-- ----------------------------
INSERT INTO `advice` VALUES (1, '建议一', '放假', 1, '2019-03-28 11:30:54');

-- ----------------------------
-- Table structure for delete_point
-- ----------------------------
DROP TABLE IF EXISTS `delete_point`;
CREATE TABLE `delete_point`  (
  `deleteId` int(6) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被扣分人Id',
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被扣分人名称',
  `deletePoint` int(4) NULL DEFAULT NULL COMMENT '扣除分数',
  `deleteDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '扣分描述',
  `deleteTime` datetime(0) NULL DEFAULT NULL COMMENT '扣分时间',
  PRIMARY KEY (`deleteId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of delete_point
-- ----------------------------
INSERT INTO `delete_point` VALUES (1, '2', '严子义', 2, '被子不整齐', '2019-03-29 09:58:10');
INSERT INTO `delete_point` VALUES (2, '2', '严子义', 3, '被子不整齐21', '2019-04-11 16:18:42');
INSERT INTO `delete_point` VALUES (3, '2', '严子义', 3, '分被子不整齐', '2019-04-03 16:18:46');
INSERT INTO `delete_point` VALUES (4, '2', '严子义', 4, '被子不整齐人23', '2019-04-09 16:18:51');
INSERT INTO `delete_point` VALUES (5, '2', '严子义', 4, '被子不整齐访问', '2019-04-05 16:18:55');
INSERT INTO `delete_point` VALUES (6, '2', '严子义', 6, '被子不整齐去', '2019-04-01 16:18:59');
INSERT INTO `delete_point` VALUES (7, '2', '严子义', 6, '被子不整齐撒', '2019-04-02 16:19:03');
INSERT INTO `delete_point` VALUES (8, '2', '严子义', 67, '被子不整齐额为全额付', '2019-04-06 16:19:06');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `permissionId` int(6) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `permissionDegree` int(1) NULL DEFAULT NULL COMMENT '权限系数',
  `perUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限url',
  PRIMARY KEY (`permissionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '学生信息', 1, '/user/getUserList');

-- ----------------------------
-- Table structure for punish
-- ----------------------------
DROP TABLE IF EXISTS `punish`;
CREATE TABLE `punish`  (
  `punishId` int(6) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被惩罚人Id',
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被惩罚人名称',
  `punishReason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '惩罚原因',
  `punishComplete` int(1) NULL DEFAULT NULL COMMENT '惩罚是否完成 1：完成 2：未完成',
  `punishDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '惩罚描述',
  `punishTime` datetime(0) NULL DEFAULT NULL COMMENT '惩罚时间',
  PRIMARY KEY (`punishId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punish
-- ----------------------------
INSERT INTO `punish` VALUES (1, '1', 'zjwzjw', '扣班级分数', 1, '10圈', '2019-03-27 10:03:59');

-- ----------------------------
-- Table structure for reward
-- ----------------------------
DROP TABLE IF EXISTS `reward`;
CREATE TABLE `reward`  (
  `rewardId` int(6) NOT NULL,
  `userId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rewardReason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '奖励原因',
  `rewardDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '奖励描述',
  `rewardTime` datetime(0) NULL DEFAULT NULL COMMENT '奖励时间',
  PRIMARY KEY (`rewardId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `qdId` int(6) NOT NULL AUTO_INCREMENT,
  `qdbm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区队编码',
  `qdmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区队名称',
  `qdms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区队简介',
  `qdkh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区队口号',
  `qdkp` int(4) NULL DEFAULT NULL COMMENT '区队考评分数',
  PRIMARY KEY (`qdId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (1, 'zjjc1591801', '15级网络安全与执法一队', '浙江警察学院 15级 网络安全与执法专业 一班', '一班一班', 100);

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
INSERT INTO `user` VALUES ('1', 'admin', '123456', 1, '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('2', '严子义', '222', 3, 'zjjc1591801', 118, '15700122303', 'dddz97@163.com', '6-503', '男');

-- ----------------------------
-- Table structure for user_wj
-- ----------------------------
DROP TABLE IF EXISTS `user_wj`;
CREATE TABLE `user_wj`  (
  `wjId` int(6) NOT NULL AUTO_INCREMENT,
  `wjMs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '违纪描述',
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '违纪人名称',
  `userId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '违纪人Id',
  `wjPoint` int(4) NULL DEFAULT NULL COMMENT '违纪扣除分数',
  `wjTime` datetime(0) NULL DEFAULT NULL COMMENT '违纪时间',
  `wjcl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '违纪处理结果',
  PRIMARY KEY (`wjId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_wj
-- ----------------------------
INSERT INTO `user_wj` VALUES (1, '寝室火锅', 'zjwzjw', '15918135', 10, NULL, NULL);

-- ----------------------------
-- Table structure for weak_check
-- ----------------------------
DROP TABLE IF EXISTS `weak_check`;
CREATE TABLE `weak_check`  (
  `checkId` int(6) NOT NULL AUTO_INCREMENT,
  `checkName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '检查名称',
  `checkDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '检查描述',
  `checkPoint` int(4) NULL DEFAULT NULL COMMENT '检查分数',
  PRIMARY KEY (`checkId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weak_check
-- ----------------------------
INSERT INTO `weak_check` VALUES (1, '卫生', '寝室卫生', 10);

SET FOREIGN_KEY_CHECKS = 1;
