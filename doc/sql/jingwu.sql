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

 Date: 25/04/2019 17:59:56
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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of add_point
-- ----------------------------
INSERT INTO `add_point` VALUES (1, '2', '严子义', 10, '救人', '2019-03-29 09:56:27');
INSERT INTO `add_point` VALUES (2, '2', '严子义', 14, '救1人', '2019-04-09 21:00:21');
INSERT INTO `add_point` VALUES (3, '2', '严子义', 13, '救1人12', '2019-04-08 21:00:26');
INSERT INTO `add_point` VALUES (4, '2', '严子义', 11, '救1人我', '2019-04-11 21:00:31');
INSERT INTO `add_point` VALUES (5, '2', '严子义', 12, '救1人撒旦', '2019-04-12 21:00:36');
INSERT INTO `add_point` VALUES (6, '2', '严子义', 15, '萨芬', '2019-04-06 21:00:41');
INSERT INTO `add_point` VALUES (7, '2', '严子义', 16, '沙发', '2019-04-05 21:00:45');
INSERT INTO `add_point` VALUES (8, '2', '严子义', 17, 'f发', '2019-04-09 21:00:48');

-- ----------------------------
-- Table structure for advice
-- ----------------------------
DROP TABLE IF EXISTS `advice`;
CREATE TABLE `advice`  (
  `adviceId` int(6) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议题目',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议内容',
  `isCross` int(1) NULL DEFAULT NULL COMMENT '1：已通过，2：未通过',
  `orderTime` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`adviceId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被扣分人Id',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被扣分人名称',
  `deletePoint` int(4) NULL DEFAULT NULL COMMENT '扣除分数',
  `deleteDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扣分描述',
  `deleteTime` datetime(0) NULL DEFAULT NULL COMMENT '扣分时间',
  PRIMARY KEY (`deleteId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of delete_point
-- ----------------------------
INSERT INTO `delete_point` VALUES (1, '2', '严子义', 2, '被子不整齐', '2019-03-29 09:58:10');
INSERT INTO `delete_point` VALUES (2, '2', '严子义', 1, '被子不整齐', '2019-04-04 21:32:58');
INSERT INTO `delete_point` VALUES (3, '2', '严子义', 2, '撒打发', '2019-04-09 21:33:01');
INSERT INTO `delete_point` VALUES (4, '2', '严子义', 3, '飞洒', '2019-04-05 21:33:05');
INSERT INTO `delete_point` VALUES (5, '2', '严子义', 4, '更换尿布地方', '2019-04-07 21:33:09');
INSERT INTO `delete_point` VALUES (6, '2', '严子义', 5, '如果', '2019-04-01 21:33:12');
INSERT INTO `delete_point` VALUES (7, '2', '严子义', 6, '人我', '2019-04-02 21:33:18');
INSERT INTO `delete_point` VALUES (8, '2', '严子义', 5, '阿尔瓦', '2019-04-09 21:33:23');
INSERT INTO `delete_point` VALUES (9, '2', '严子义', 7, '范德萨', '2019-04-11 21:33:26');
INSERT INTO `delete_point` VALUES (10, '2', '严子义', 21, '购房价款', '2019-04-08 21:33:28');
INSERT INTO `delete_point` VALUES (11, '2', '严子义', 4, '发大水', '2019-04-11 21:33:32');
INSERT INTO `delete_point` VALUES (12, '2', '严子义', 56, '法国', '2019-04-02 21:33:35');
INSERT INTO `delete_point` VALUES (13, '2', '严子义', 4, '公认为', '2019-04-10 21:33:39');

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
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被惩罚人Id',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被惩罚人名称',
  `punishReason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '惩罚原因',
  `punishComplete` int(1) NULL DEFAULT NULL COMMENT '惩罚是否完成 1：完成 2：未完成',
  `punishDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '惩罚描述',
  `punishTime` datetime(0) NULL DEFAULT NULL COMMENT '惩罚时间',
  PRIMARY KEY (`punishId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punish
-- ----------------------------
INSERT INTO `punish` VALUES (1, '2', '严子义', '扣班级分数1', 1, '10圈', '2019-03-27 10:03:59');
INSERT INTO `punish` VALUES (2, '2', '严子义', '扣班级分数2', 2, '10圈', '2019-04-11 22:27:56');
INSERT INTO `punish` VALUES (3, '2', '严子义', '扣班级分数3', 1, '10圈', '2019-04-09 22:27:59');
INSERT INTO `punish` VALUES (4, '2', '严子义', '扣班级分数4', 1, '10圈', '2019-04-08 22:28:03');
INSERT INTO `punish` VALUES (5, '2', '严子义', '扣班级分数5', 2, '10圈', '2019-04-02 22:57:14');

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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reward
-- ----------------------------
INSERT INTO `reward` VALUES (1, '2', '严子义', '一等奖', '吃饭大赛荣获一等奖学金', '2019-04-11 21:41:33');
INSERT INTO `reward` VALUES (2, '2', '严子义', '2等奖', '吃饭大赛荣获2等奖学金', '2019-04-12 21:42:25');
INSERT INTO `reward` VALUES (3, '2', '严子义', '3等奖', '吃饭大赛3等奖', '2019-04-13 21:42:45');
INSERT INTO `reward` VALUES (9, '2', '严子义', '严子义', '严子义', '2019-04-10 22:58:07');
INSERT INTO `reward` VALUES (10, '2', '严子义', '严子义', '严子义', '2019-04-10 22:58:10');
INSERT INTO `reward` VALUES (11, '2', '严子义', '严子义', '严子义', '2019-04-10 22:58:13');
INSERT INTO `reward` VALUES (12, '2', '严子义', '严子义', '严子义', '2019-04-10 22:58:16');

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (1, 'zjjc1591801', '15级网络安全与执法一队', 100, 324);
INSERT INTO `team` VALUES (2, 'zjjc1111', '网络安全与执法2', 123, 333);

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
  `checkName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扣分项目',
  `weekNum` int(2) NULL DEFAULT NULL COMMENT '周数'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_del
-- ----------------------------
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-23 16:25:12', '2019第1学期', 1, '卫生', 2);
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-23 16:25:17', '2019第1学期', 1, '卫生', 2);
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-23 16:25:21', '2019第1学期', 2, NULL, 1);
INSERT INTO `team_del` VALUES (1, 'zjjc1111', 10, '2019-04-22 16:25:26', '2019第1学期', 2, NULL, 2);
INSERT INTO `team_del` VALUES (1, 'zjjc1111', 10, '2019-04-23 16:25:30', '2019第1学期', 2, NULL, 2);
INSERT INTO `team_del` VALUES (1, 'zjjc1111', 10, '2019-04-24 16:25:33', '2019第1学期', 2, NULL, 2);
INSERT INTO `team_del` VALUES (1, 'zjjc1111', 10, '2019-04-19 16:25:37', '2019第1学期', 3, NULL, 1);
INSERT INTO `team_del` VALUES (1, 'zjjc1111', 10, '2019-04-18 16:25:41', '2019第1学期', 3, NULL, 1);
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-18 16:26:29', '2019第1学期', 1, NULL, 1);
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-17 16:26:32', '2019第1学期', 4, NULL, 1);
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-16 16:26:37', '2019第1学期', 4, NULL, 1);
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-15 16:26:41', '2019第1学期', 5, NULL, 1);
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-16 16:26:44', '2019第1学期', 6, NULL, 1);
INSERT INTO `team_del` VALUES (1, 'zjjc1591801', 10, '2019-04-25 16:26:49', '2019第1学期', 6, NULL, 2);
INSERT INTO `team_del` VALUES (1, 'zjjc1111', 10, '2019-04-22 16:26:53', '2019第1学期', 6, NULL, 2);

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
INSERT INTO `user` VALUES ('1', '老师', '1', 1, '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('2', '女干部', '2', 2, 'zjjc1591801', 126, '17757180496', 'cccc@qq.com', '7-202', '女');
INSERT INTO `user` VALUES ('3', '严子义', '3', 3, 'zjjc1591801', 118, '15700122303', 'dddz97@163.com', '6-503', '男');

-- ----------------------------
-- Table structure for user_wj
-- ----------------------------
DROP TABLE IF EXISTS `user_wj`;
CREATE TABLE `user_wj`  (
  `wjId` int(6) NOT NULL AUTO_INCREMENT,
  `wjMs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪描述',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪人名称',
  `userId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪人Id',
  `wjPoint` int(4) NULL DEFAULT NULL COMMENT '违纪扣除分数',
  `wjTime` datetime(0) NULL DEFAULT NULL COMMENT '违纪时间',
  `wjcl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违纪处理结果',
  PRIMARY KEY (`wjId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `checkName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查名称',
  `checkDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查描述',
  `checkPoint` int(4) NULL DEFAULT NULL COMMENT '检查分数',
  `isNow` int(1) NULL DEFAULT NULL COMMENT '1本周，2上周',
  PRIMARY KEY (`checkId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weak_check
-- ----------------------------
INSERT INTO `weak_check` VALUES (1, '寝室卫生', '寝室卫生', 10, 2);
INSERT INTO `weak_check` VALUES (2, '晚自习纪律', '晚自习纪律', 10, 2);
INSERT INTO `weak_check` VALUES (3, '早自习出勤', '早自习出勤', 10, 2);
INSERT INTO `weak_check` VALUES (4, '彩虹晨跑出勤', '彩虹晨跑出勤', 10, 2);
INSERT INTO `weak_check` VALUES (5, '文艺汇演纪律', '文艺汇演纪律', 10, 2);
INSERT INTO `weak_check` VALUES (6, '上课报道情况', '上课报道情况', 10, 2);

SET FOREIGN_KEY_CHECKS = 1;
