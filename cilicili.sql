/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : cilicili

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 02/01/2024 17:37:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for star
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star`  (
  `uid` int UNSIGNED NOT NULL,
  `vid` int UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `vid`(`vid` ASC) USING BTREE,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `vid` FOREIGN KEY (`vid`) REFERENCES `video` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `phoneNumber` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `verification` char(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `verificationTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `EMAIL`(`email` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Ogawa Yota', 'T1q8aWio1U', 'yotaogawa5@hotmail.com', '(20) 2923 7574', NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'Gladys Butler', 'xl85yhmVlu', 'gladysbutle@gmail.com', '20-429-6125', NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 'Mario Cooper', 'j5a4ZBB6jk', 'mcooper@gmail.com', '183-1608-1321', NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, 'Ota Yuto', '1DZ0lWrhGW', 'otayut78@gmail.com', '330-927-5228', NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, 'Willie Guzman', 'uhMf8Mgikk', 'wguzman224@outlook.com', '90-5251-2445', NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, 'Tang Ting Fung', 'gJkIbbUFM9', 'tftang@icloud.com', '330-455-8956', NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, 'Watanabe Airi', '4fhiKRGflT', 'awatanabe610@gmail.com', '838-608-6083', NULL, NULL, NULL);
INSERT INTO `user` VALUES (8, 'Loui Hok Yau', 'pff8fNQ6Ev', 'lohokyau@gmail.com', '52-922-5860', NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, 'Chin Hok Yau', 'oKfU4LTMUk', 'chin1993@yahoo.com', '(1223) 09 5718', NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, 'Angela Richardson', 'AQbH1yelAP', 'richa@gmail.com', '80-3316-5719', NULL, NULL, NULL);
INSERT INTO `user` VALUES (59, '2', '1', '1@qq.com', NULL, NULL, NULL, '2023-12-31 19:10:14');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `videoPath` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `coverPath` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `subtitle` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL,
  `likeNumber` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
