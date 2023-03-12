/*
 Navicat Premium Data Transfer

 Source Server         : java
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : dormitory

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 13/03/2023 02:59:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for absent
-- ----------------------------
DROP TABLE IF EXISTS `absent`;
CREATE TABLE `absent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_id` int(11) NULL DEFAULT NULL,
  `dormitory_id` int(11) NULL DEFAULT NULL,
  `student_id` int(11) NULL DEFAULT NULL,
  `dormitory_admin_id` int(11) NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of absent
-- ----------------------------
INSERT INTO `absent` VALUES (13, 1, 2, 5, 8, '2022-04-16', '请假');
INSERT INTO `absent` VALUES (14, 1, 1, 1, 1, '2022-04-26', '请假');
INSERT INTO `absent` VALUES (15, 2, 5, 25, 1, '2022-04-26', '请假');
INSERT INTO `absent` VALUES (16, 18, 41, 25, 9, '2023-02-14', '请假');

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduction` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES (1, '1号楼', '计算机学院宿舍楼', 1);
INSERT INTO `building` VALUES (2, '2号楼', '计算机学院宿舍楼', 2);
INSERT INTO `building` VALUES (3, '3号楼', '体育学院宿舍楼', 4);
INSERT INTO `building` VALUES (16, '5号楼', '电信学院宿舍楼', 3);
INSERT INTO `building` VALUES (18, '测试楼宇1', '测试楼宇1', 4);

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_id` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES (1, 1, '101', 4, 0, '88230001');
INSERT INTO `dormitory` VALUES (2, 1, '102', 4, 0, '88230002');
INSERT INTO `dormitory` VALUES (3, 1, '211', 4, 0, '88230007');
INSERT INTO `dormitory` VALUES (4, 2, '212', 6, 0, '88230008');
INSERT INTO `dormitory` VALUES (5, 2, '321', 8, 6, '88230013');
INSERT INTO `dormitory` VALUES (6, 2, '322', 10, 10, '88230016');
INSERT INTO `dormitory` VALUES (36, 1, '666', 6, 2, '88136666');
INSERT INTO `dormitory` VALUES (37, 3, '测试宿舍1', 100, 96, '11111111');
INSERT INTO `dormitory` VALUES (38, 3, '测试宿舍2', 100, 96, '22222222');
INSERT INTO `dormitory` VALUES (41, 18, '测试宿舍1-1', 10, 8, '16494989519');

-- ----------------------------
-- Table structure for dormitory_admin
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_admin`;
CREATE TABLE `dormitory_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory_admin
-- ----------------------------
INSERT INTO `dormitory_admin` VALUES (1, 'll', '123123', '宋玉', '女', '13312345678');
INSERT INTO `dormitory_admin` VALUES (2, 'ww', '123123', '王力', '男', '13612345678');
INSERT INTO `dormitory_admin` VALUES (3, 'zz', '123123', '张三', '女', '13312345678');
INSERT INTO `dormitory_admin` VALUES (4, 'test1', '123456', '测试1', '男', '12346');
INSERT INTO `dormitory_admin` VALUES (5, 'test2', '123465', '测试2', '女', '123456');
INSERT INTO `dormitory_admin` VALUES (6, 'test3', '123465', '测试3', '男', '123456');
INSERT INTO `dormitory_admin` VALUES (7, 'test4', '123465', '测试4', '男', '1');
INSERT INTO `dormitory_admin` VALUES (8, 'test5', '123465', '测试5', '男', '2');
INSERT INTO `dormitory_admin` VALUES (9, 'admin', '123456', '宿管钟斌林', '男', '123456');

-- ----------------------------
-- Table structure for moveout
-- ----------------------------
DROP TABLE IF EXISTS `moveout`;
CREATE TABLE `moveout`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NULL DEFAULT NULL,
  `dormitory_id` int(50) NULL DEFAULT NULL,
  `reason` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of moveout
-- ----------------------------
INSERT INTO `moveout` VALUES (15, 19, 6, '毕业', '2022-04-17');
INSERT INTO `moveout` VALUES (17, 18, 4, '毕业', '2022-04-27');
INSERT INTO `moveout` VALUES (18, 25, 5, '毕业', '2023-02-13');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_id` int(11) NULL DEFAULT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '001', '王伟', '男', 1, '入住', '2022-04-14');
INSERT INTO `student` VALUES (2, '002', '曹海', '男', 1, '入住', '2022-04-14');
INSERT INTO `student` VALUES (3, '003', '李力', '男', 1, '入住', '2022-04-14');
INSERT INTO `student` VALUES (4, '004', '赵昭', '男', 1, '入住', '2022-04-14');
INSERT INTO `student` VALUES (5, '005', '王维利', '男', 2, '入住', '2022-04-14');
INSERT INTO `student` VALUES (6, '006', '李双', '女', 2, '入住', '2022-04-14');
INSERT INTO `student` VALUES (7, '007', '李小峰', '男', 2, '入住', '2022-04-14');
INSERT INTO `student` VALUES (8, '008', '孙奇', '男', 2, '入住', '2022-04-14');
INSERT INTO `student` VALUES (9, '009', '李立', '女', 3, '入住', '2022-04-14');
INSERT INTO `student` VALUES (10, '010', '周华发', '男', 3, '入住', '2022-04-14');
INSERT INTO `student` VALUES (11, '011', '赵正义', '男', 3, '入住', '2022-04-14');
INSERT INTO `student` VALUES (12, '012', '李明', '男', 3, '入住', '2022-04-14');
INSERT INTO `student` VALUES (13, '013', '许鹏飞', '男', 4, '入住', '2022-04-14');
INSERT INTO `student` VALUES (14, '014', '朱海', '男', 4, '入住', '2022-04-14');
INSERT INTO `student` VALUES (15, '015', '苏苏苏', '男', 4, '入住', '2022-04-14');
INSERT INTO `student` VALUES (16, '016', '李雪', '女', 4, '入住', '2022-04-14');
INSERT INTO `student` VALUES (17, '017', '李爽', '女', 4, '入住', '2022-04-14');
INSERT INTO `student` VALUES (18, '018', '王纯', '女', 4, '迁出', '2022-04-14');
INSERT INTO `student` VALUES (19, '019', '小明', '男', 5, '迁出', '2022-04-17');
INSERT INTO `student` VALUES (20, '020', '学生20', '男', 37, '入住', '2023-02-09');
INSERT INTO `student` VALUES (21, '021', '学生21', '女', 38, '入住', '2023-02-09');
INSERT INTO `student` VALUES (22, '025', '测试123', '男', 4, '入住', '2023-02-12');
INSERT INTO `student` VALUES (23, '029', '测试2', '女', 5, '入住', '2023-02-12');
INSERT INTO `student` VALUES (24, '020', '一一', '男', 41, '入住', '2023-02-13');
INSERT INTO `student` VALUES (25, '200', '二二', '女', 41, '迁出', '2023-02-13');

-- ----------------------------
-- Table structure for system_admin
-- ----------------------------
DROP TABLE IF EXISTS `system_admin`;
CREATE TABLE `system_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_admin
-- ----------------------------
INSERT INTO `system_admin` VALUES (1, 'admin1', '123123', '管理员1', '88132001');
INSERT INTO `system_admin` VALUES (2, 'admin2', '123123', '管理员2', '88132002');
INSERT INTO `system_admin` VALUES (3, 'admin', '123456', '管理员钟斌林', '12345678');

SET FOREIGN_KEY_CHECKS = 1;
