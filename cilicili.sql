/*
SQLyog Professional v12.14 (64 bit)
MySQL - 8.0.32 : Database - cilicili
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cilicili` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `cilicili`;

/*Table structure for table `fan` */

DROP TABLE IF EXISTS `fan`;

CREATE TABLE `fan` (
  `uid` int unsigned NOT NULL,
  `fanId` int unsigned NOT NULL,
  PRIMARY KEY (`uid`,`fanId`) USING BTREE,
  KEY `fanId` (`fanId`) USING BTREE,
  CONSTRAINT `fan_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fan_ibfk_2` FOREIGN KEY (`fanId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `fan` */

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `uid` int unsigned NOT NULL,
  `vid` int unsigned NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`uid`,`vid`) USING BTREE,
  KEY `vid` (`vid`) USING BTREE,
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `history_ibfk_2` FOREIGN KEY (`vid`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `history` */

insert  into `history`(`uid`,`vid`,`time`) values 
(82,30,'2024-01-19 01:20:52'),
(82,31,'2024-01-19 01:20:59'),
(82,32,'2024-01-19 01:09:40'),
(82,33,'2024-01-19 01:10:14'),
(82,34,'2024-01-19 01:10:59'),
(82,35,'2024-01-19 01:11:37'),
(82,36,'2024-01-19 01:12:12'),
(82,37,'2024-01-19 01:13:06'),
(82,42,'2024-01-19 01:20:23');

/*Table structure for table `star` */

DROP TABLE IF EXISTS `star`;

CREATE TABLE `star` (
  `uid` int unsigned NOT NULL,
  `vid` int unsigned NOT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `group` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`uid`,`vid`) USING BTREE,
  KEY `vid` (`vid`,`uid`) USING BTREE,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `vid` FOREIGN KEY (`vid`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `star` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `phoneNumber` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `verification` char(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `verificationTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `USERNAME` (`username`) USING BTREE,
  UNIQUE KEY `EMAIL` (`email`) USING BTREE,
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`phoneNumber`,`avatar`,`verification`,`verificationTime`) values 
(82,'Et3rn1ty','1','l0vehzzz@foxmail.com',NULL,NULL,'null','2024-01-19 00:52:41');

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `videoPath` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `coverPath` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `subtitle` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin,
  `starNumber` int unsigned DEFAULT '0',
  `playNumber` int DEFAULT '0',
  `videoTime` time DEFAULT NULL,
  `uid` int unsigned DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `video_ibfk_1` (`uid`) USING BTREE,
  CONSTRAINT `video_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `video` */

insert  into `video`(`id`,`videoPath`,`coverPath`,`title`,`subtitle`,`starNumber`,`playNumber`,`videoTime`,`uid`,`createTime`) values 
(30,'82/1705597139777.mp4','82/1705597496696.jpg','丁达尔效应_阳光_森林_雾——“光是最好的画笔”','test',0,3,NULL,82,'2024-01-19 00:58:59'),
(31,'82/1705597514229.mp4','82/1705597533881.jpg','“前奏太好听啦！”—《Chance》','22222222',0,4,NULL,82,'2024-01-19 01:05:14'),
(32,'82/1705597668198.mp4','82/1705597792351.jpg','“少与人纠缠，多看大自然”','undefined',0,3,NULL,82,'2024-01-19 01:07:48'),
(33,'82/1705597675973.mp4','82/1705597823675.jpg','「人群太吵了 我想一个人看这段风景 安静和孤独 踏实又自由」','你好 hello world',0,1,NULL,82,'2024-01-19 01:07:55'),
(34,'82/1705597682261.mp4','82/1705597869248.jpg','【MHWI_新纪录】太刀 黑龙 7分38秒 TA规则','1234567890',0,1,NULL,82,'2024-01-19 01:08:02'),
(35,'82/1705597687683.mp4','82/1705597904915.jpg','【The Finals】这个b音乐是不是掺东西了？','66666666666666666',0,1,NULL,82,'2024-01-19 01:08:07'),
(36,'82/1705597691188.mp4','82/1705597940831.jpg','百万级录音棚听《Seven Nation Army》(The Glitch Mob Remix)','百万级录音棚听《Seven Nation Army》(The Glitch Mob Remix)',0,1,NULL,82,'2024-01-19 01:08:11'),
(37,'82/1705597696418.mp4','82/1705598033198.jpg','Under No Flag','Under No Flag',0,1,NULL,82,'2024-01-19 01:08:16'),
(38,'82/1705598228812.mp4','82/1705598236366.jpg','弟弟的早餐。','弟弟的早餐。',0,0,NULL,82,'2024-01-19 01:17:08'),
(39,'82/1705598263773.mp4','82/1705598273138.jpg',NULL,NULL,0,0,NULL,82,'2024-01-19 01:17:43'),
(40,'82/1705598300158.mp4','82/1705598348403.jpg','那些难以超越的电影台词和画面','那些难以超越的电影台词和画面',0,0,NULL,82,'2024-01-19 01:18:20'),
(41,'82/1705598377091.mp4','82/1705598391366.jpg','如何使用HTML、CSS和Javascript创建毛玻璃质感的侧边栏菜单 _ 源码下载','如何使用HTML、CSS和Javascript创建毛玻璃质感的侧边栏菜单 _ 源码下载',0,0,NULL,82,'2024-01-19 01:19:37'),
(42,'82/1705598403272.mp4','82/1705598413587.jpg','1111222','222223432543654',0,1,NULL,82,'2024-01-19 01:20:03');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
