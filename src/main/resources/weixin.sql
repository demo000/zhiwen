/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.22-log : Database - weixin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`weixin` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `weixin`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `questionId` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `star` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `comment` */

insert  into `comment`(`id`,`questionId`,`user_id`,`content`,`user_name`,`createDate`,`star`) values 
(1,1,1,'????','admin','2019-01-18 11:58:53',0),
(2,2,1,'11111','admin','2019-01-18 12:03:29',0);

/*Table structure for table `focususer` */

DROP TABLE IF EXISTS `focususer`;

CREATE TABLE `focususer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `genre` bit(1) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `focususer` */

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `commentNumber` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `question` */

insert  into `question`(`id`,`title`,`content`,`user_id`,`userName`,`createDate`,`commentNumber`) values 
(1,'test','<p>????UEditor?</p>',1,'admin','2019-01-18 11:54:19',NULL),
(2,'RabbitMQ','<p><span style=\"color: rgb(51, 51, 51); font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">MQ???Message Queue,&nbsp;</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97/4751675\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">????</a><span style=\"color: rgb(51, 51, 51); font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">?MQ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%BF%9C%E7%A8%8B%E8%BF%87%E7%A8%8B%E8%B0%83%E7%94%A8/7854346\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">??????</a><span style=\"color: rgb(51, 51, 51); font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">??????????????? ??????????????????????????????????????MQ???IBM WEBSPHERE MQ???</span></p><p><span style=\"color: rgb(51, 51, 51); font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\"></span></p><h2 class=\"title-text\" style=\"margin: 0px; padding: 0px 8px 0px 18px; font-size: 22px; color: rgb(0, 0, 0); float: left; line-height: 24px; font-weight: 400; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\">MQ??</h2><p><a class=\"edit-icon j-edit-link\" style=\"color: rgb(136, 136, 136); display: block; float: right; height: 22px; line-height: 22px; padding-left: 24px; font-size: 12px; font-family: SimSun; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span class=\"cmn-icon wiki-lemma-icons wiki-lemma-icons_edit-lemma\" style=\"font-family: baikeFont_layout; -webkit-font-smoothing: antialiased; speak: none; font-variant-numeric: normal; font-variant-east-asian: normal; line-height: 1; outline: 0px; margin: 0px 3px 0px 0px; vertical-align: text-bottom; color: rgb(170, 170, 170);\"></span>??</a></p><p><a target=\"_blank\" href=\"https://baike.baidu.com/item/MQ\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">MQ</a>???-?????????????????<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">????</a>????????????????????????????MQ?<a target=\"_blank\" href=\"https://baike.baidu.com/item/JMS\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">JMS</a>????????JMS?SUN JAVA<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B6%88%E6%81%AF%E4%B8%AD%E9%97%B4%E4%BB%B6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">?????</a>????????API????MQ?????AMQP???????????</p><p><a class=\"lemma-anchor para-title\" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a><a class=\"lemma-anchor \" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a><a class=\"lemma-anchor \" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a></p><h2 class=\"title-text\" style=\"margin: 0px; padding: 0px 8px 0px 18px; font-size: 22px; color: rgb(0, 0, 0); float: left; line-height: 24px; font-weight: 400; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\">????</h2><p><a class=\"edit-icon j-edit-link\" style=\"color: rgb(136, 136, 136); display: block; float: right; height: 22px; line-height: 22px; padding-left: 24px; font-size: 12px; font-family: SimSun; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span class=\"cmn-icon wiki-lemma-icons wiki-lemma-icons_edit-lemma\" style=\"font-family: baikeFont_layout; -webkit-font-smoothing: antialiased; speak: none; font-variant-numeric: normal; font-variant-east-asian: normal; line-height: 1; outline: 0px; margin: 0px 3px 0px 0px; vertical-align: text-bottom; color: rgb(170, 170, 170);\"></span>??</a></p><p>????????????????????????????<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%BC%82%E6%AD%A5%E5%A4%84%E7%90%86\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">????</a>?????????????????????<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%AF%B7%E6%B1%82%E5%93%8D%E5%BA%94%E6%97%B6%E9%97%B4\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">??????</a>?????????????</p><p><a class=\"lemma-anchor para-title\" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a><a class=\"lemma-anchor \" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a><a class=\"lemma-anchor \" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a></p><h2 class=\"title-text\" style=\"margin: 0px; padding: 0px 8px 0px 18px; font-size: 22px; color: rgb(0, 0, 0); float: left; line-height: 24px; font-weight: 400; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\">??</h2><p><a class=\"edit-icon j-edit-link\" style=\"color: rgb(136, 136, 136); display: block; float: right; height: 22px; line-height: 22px; padding-left: 24px; font-size: 12px; font-family: SimSun; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span class=\"cmn-icon wiki-lemma-icons wiki-lemma-icons_edit-lemma\" style=\"font-family: baikeFont_layout; -webkit-font-smoothing: antialiased; speak: none; font-variant-numeric: normal; font-variant-east-asian: normal; line-height: 1; outline: 0px; margin: 0px 3px 0px 0px; vertical-align: text-bottom; color: rgb(170, 170, 170);\"></span>??</a></p><p><span style=\"font-weight: 700;\">RabbitMQ</span>????<a target=\"_blank\" href=\"https://baike.baidu.com/item/AMQP\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">AMQP</a>?????????????????????<span style=\"font-weight: 700;\">Mozilla Public License</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%BC%80%E6%BA%90%E5%8D%8F%E8%AE%AE\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">????</a>?</p><p><span style=\"color: rgb(51, 51, 51); font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\"><br/></span><br/></p>',1,'admin','2019-01-18 11:57:47',NULL),
(3,'rabbitmq','<p><span style=\"color: rgb(51, 51, 51); font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">MQ???Message Queue,&nbsp;</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97/4751675\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">????</a><span style=\"color: rgb(51, 51, 51); font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">?MQ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????</span><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%BF%9C%E7%A8%8B%E8%BF%87%E7%A8%8B%E8%B0%83%E7%94%A8/7854346\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">??????</a><span style=\"color: rgb(51, 51, 51); font-family: arial, ??, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">??????????????? ??????????????????????????????????????MQ???IBM WEBSPHERE MQ???</span></p>',1,'admin','2019-01-18 12:02:18',NULL);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tb_name` varchar(50) DEFAULT NULL,
  `sex` smallint(2) DEFAULT NULL,
  `birthdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `class_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

/*Table structure for table `tb_class` */

DROP TABLE IF EXISTS `tb_class`;

CREATE TABLE `tb_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tb_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_class` */

/*Table structure for table `tearcher` */

DROP TABLE IF EXISTS `tearcher`;

CREATE TABLE `tearcher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tb_name` varchar(50) DEFAULT NULL,
  `class_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tearcher` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `passWord` varchar(50) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `birthDay` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sex` varchar(5) DEFAULT NULL,
  `createDate` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`passWord`,`email`,`birthDay`,`sex`,`createDate`) values 
(1,'admin','36A7C9E95A47010A2F6E498502D06388','354079281@qq.com','2019-01-01 00:00:00','male','2019-01-18 11:53:53');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
