/*
SQLyog Ultimate v13.1.1 (64 bit)
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

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `phone_number` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `Verification` char(6) COLLATE utf8mb3_bin DEFAULT NULL,
  `Verification_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `EMAIL` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`phone_number`,`avatar`,`Verification`,`Verification_time`) values 
(1,'Ogawa Yota','T1q8aWio1U','yotaogawa5@hotmail.com','(20) 2923 7574',NULL,NULL,NULL),
(2,'Gladys Butler','xl85yhmVlu','gladysbutle@gmail.com','20-429-6125',NULL,NULL,NULL),
(3,'Mario Cooper','j5a4ZBB6jk','mcooper@gmail.com','183-1608-1321',NULL,NULL,NULL),
(4,'Ota Yuto','1DZ0lWrhGW','otayut78@gmail.com','330-927-5228',NULL,NULL,NULL),
(5,'Willie Guzman','uhMf8Mgikk','wguzman224@outlook.com','90-5251-2445',NULL,NULL,NULL),
(6,'Tang Ting Fung','gJkIbbUFM9','tftang@icloud.com','330-455-8956',NULL,NULL,NULL),
(7,'Watanabe Airi','4fhiKRGflT','awatanabe610@gmail.com','838-608-6083',NULL,NULL,NULL),
(8,'Loui Hok Yau','pff8fNQ6Ev','lohokyau@gmail.com','52-922-5860',NULL,NULL,NULL),
(9,'Chin Hok Yau','oKfU4LTMUk','chin1993@yahoo.com','(1223) 09 5718',NULL,NULL,NULL),
(10,'Angela Richardson','AQbH1yelAP','richa@gmail.com','80-3316-5719',NULL,NULL,NULL),
(59,NULL,NULL,'1@qq.com',NULL,NULL,'460231','2023-12-30 19:51:57');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
