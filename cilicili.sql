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

 Date: 18/01/2024 19:22:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fan
-- ----------------------------
DROP TABLE IF EXISTS `fan`;
CREATE TABLE `fan`  (
  `uid` int UNSIGNED NOT NULL,
  `fanId` int UNSIGNED NOT NULL,
  PRIMARY KEY (`uid`, `fanId`) USING BTREE,
  INDEX `fanId`(`fanId` ASC) USING BTREE,
  CONSTRAINT `fan_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fan_ibfk_2` FOREIGN KEY (`fanId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fan
-- ----------------------------
INSERT INTO `fan` VALUES (5, 1);
INSERT INTO `fan` VALUES (5, 3);
INSERT INTO `fan` VALUES (2, 5);
INSERT INTO `fan` VALUES (4, 5);

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `uid` int UNSIGNED NOT NULL,
  `vid` int UNSIGNED NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`uid`, `vid`) USING BTREE,
  INDEX `vid`(`vid` ASC) USING BTREE,
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `history_ibfk_2` FOREIGN KEY (`vid`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (1, 19, '2024-01-13 17:52:36');
INSERT INTO `history` VALUES (73, 20, '2024-01-18 18:59:40');

-- ----------------------------
-- Table structure for star
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star`  (
  `uid` int UNSIGNED NOT NULL,
  `vid` int UNSIGNED NOT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `group` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  PRIMARY KEY (`uid`, `vid`) USING BTREE,
  INDEX `vid`(`vid` ASC, `uid` ASC) USING BTREE,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `vid` FOREIGN KEY (`vid`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of star
-- ----------------------------
INSERT INTO `star` VALUES (73, 20, '2024-01-18 17:42:09', 'default');

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
  `verificationTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `USERNAME`(`username` ASC) USING BTREE,
  UNIQUE INDEX `EMAIL`(`email` ASC) USING BTREE,
  INDEX `id`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

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
INSERT INTO `user` VALUES (9, 'Chin Hok Yau', 'oKfU4LTMUk', 'chin1993@yahoo.com', '(1223) 09 5718', NULL, '1111', NULL);
INSERT INTO `user` VALUES (10, 'Angela Richardson', 'AQbH1yelAP', 'richa@gmail.com', '80-3316-5719', NULL, '1111', NULL);
INSERT INTO `user` VALUES (69, '2', '1', '1@qq.com', NULL, NULL, 'null', '2024-01-05 15:19:49');
INSERT INTO `user` VALUES (72, NULL, NULL, '', NULL, NULL, '285784', '2024-01-16 13:51:43');
INSERT INTO `user` VALUES (73, 'fpoint666', 'fpoint', '1367637939@qq.com', '110', NULL, 'null', '2024-01-16 14:53:37');
INSERT INTO `user` VALUES (75, 'fpoint1', 'fpoint1', NULL, NULL, NULL, '331811', '2024-01-16 14:29:01');
INSERT INTO `user` VALUES (78, NULL, NULL, '111', NULL, NULL, '673711', '2024-01-16 14:40:42');

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
  `starNumber` int UNSIGNED NULL DEFAULT 0,
  `playNumber` int NULL DEFAULT 0,
  `videoTime` time NULL DEFAULT NULL,
  `uid` int UNSIGNED NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `video_ibfk_1`(`uid` ASC) USING BTREE,
  CONSTRAINT `video_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (16, '11705139151271.mp4', NULL, NULL, NULL, 0, 0, NULL, 1, '2024-01-13 17:45:51');
INSERT INTO `video` VALUES (17, '11705139242006.mp4', NULL, NULL, NULL, 0, 0, NULL, 1, '2024-01-13 17:47:22');
INSERT INTO `video` VALUES (18, '11705139382147.mp4', NULL, NULL, NULL, 0, 0, NULL, 1, '2024-01-13 17:51:43');
INSERT INTO `video` VALUES (19, '1/1705139536768.mp4', NULL, NULL, NULL, 0, 0, NULL, 1, '2024-01-13 17:52:16');
INSERT INTO `video` VALUES (20, '73/1705400859502.mp4', '73/1705416464579.jpg', 'Te1st', 'test2111', 0, 0, NULL, 73, '2024-01-16 18:27:39');
INSERT INTO `video` VALUES (21, '73/1705414368821.mp4', NULL, NULL, NULL, 0, 0, NULL, 73, '2024-01-16 22:12:48');
INSERT INTO `video` VALUES (22, '73/1705416027143.mp4', '73/1705416571078.jpg', 'Te1st', 'test2111', 0, 0, NULL, 73, '2024-01-16 22:40:27');
INSERT INTO `video` VALUES (23, '73/1705416030476.mp4', NULL, NULL, NULL, 0, 0, NULL, 73, '2024-01-16 22:40:30');
INSERT INTO `video` VALUES (24, '73/1705416498833.mp4', NULL, NULL, NULL, 0, 0, NULL, 73, '2024-01-16 22:48:18');
INSERT INTO `video` VALUES (25, '73/1705416547875.mp4', NULL, NULL, NULL, 0, 0, NULL, 73, '2024-01-16 22:49:07');
INSERT INTO `video` VALUES (26, '73/1705502403439.mp4', NULL, NULL, NULL, 0, 0, NULL, 73, '2024-01-17 22:40:03');
INSERT INTO `video` VALUES (27, '73/1705512839564.mp4', NULL, NULL, NULL, 0, 0, NULL, 73, '2024-01-18 01:34:06');
INSERT INTO `video` VALUES (28, '73/1705512986442.mp4', NULL, NULL, NULL, 0, 0, NULL, 73, '2024-01-18 01:36:26');
INSERT INTO `video` VALUES (29, '73/1705515546133.mp4', NULL, NULL, NULL, 0, 0, NULL, 73, '2024-01-18 02:19:06');

SET FOREIGN_KEY_CHECKS = 1;
