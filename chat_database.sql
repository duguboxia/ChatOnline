# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: chat_database
# ------------------------------------------------------
# Server version 5.1.42-community

CREATE DATABASE `chat_database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `chat_database`;

#
# Source for table friends
#

CREATE TABLE `friends` (
  `id` char(10) NOT NULL,
  `friends_id` char(10) NOT NULL,
  `friends_name` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table friends
#
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;

INSERT INTO `friends` VALUES ('123','465','afjdvuiasn');
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;

#
# Source for table news
#

CREATE TABLE `news` (
  `number` int(8) NOT NULL AUTO_INCREMENT,
  `to_id` char(10) NOT NULL DEFAULT '',
  `from_id` char(10) NOT NULL DEFAULT '',
  `content` char(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` char(13) DEFAULT NULL,
  `hava_read` char(1) DEFAULT '未',
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8;

#
# Dumping data for table news
#
/*!40000 ALTER TABLE `news` DISABLE KEYS */;

INSERT INTO `news` VALUES (103,'123','all','','2019-01-08','14 : 44 : 12','2');
INSERT INTO `news` VALUES (104,'123','all','','2019-01-08','14 : 52 : 38','2');
INSERT INTO `news` VALUES (105,'123','all','','2019-01-08','15 : 01 : 44','2');
INSERT INTO `news` VALUES (106,'123','all','','2019-01-08','15 : 06 : 42','2');
INSERT INTO `news` VALUES (107,'123','all','','2019-01-08','15 : 08 : 45','2');
INSERT INTO `news` VALUES (108,'123','all','瞧你们吗','2019-01-08','15 : 11 : 03','2');
INSERT INTO `news` VALUES (109,'123','all','瞧你们吗','2019-01-08','15 : 11 : 23','2');
INSERT INTO `news` VALUES (110,'123','all','瞧你们吗','2019-01-08','15 : 11 : 24','2');
INSERT INTO `news` VALUES (111,'123','all','瞧你们吗','2019-01-08','15 : 11 : 24','2');
INSERT INTO `news` VALUES (112,'123','all','敲你们吗b','2019-01-08','15 : 16 : 52','2');
INSERT INTO `news` VALUES (113,'123','all','敲你们吗b','2019-01-08','15 : 16 : 52','2');
INSERT INTO `news` VALUES (114,'123','all','敲你们吗b','2019-01-08','15 : 16 : 52','2');
INSERT INTO `news` VALUES (115,'123','all','敲你们吗b','2019-01-08','15 : 16 : 52','2');
INSERT INTO `news` VALUES (116,'123','all','敲你们吗b','2019-01-08','15 : 16 : 52','2');
INSERT INTO `news` VALUES (117,'123','all','敲你们吗b','2019-01-08','15 : 16 : 52','2');
INSERT INTO `news` VALUES (118,'123','all','敲你们吗b','2019-01-08','15 : 16 : 52','2');
INSERT INTO `news` VALUES (119,'123','all','哦ID发货那你看你','2019-01-08','15 : 19 : 05','2');
INSERT INTO `news` VALUES (120,'123','all','123','2019-01-08','16 : 10 : 23','2');
INSERT INTO `news` VALUES (121,'123','all','你好','2019-01-08','16 : 10 : 38','2');
INSERT INTO `news` VALUES (122,'123','all','你好','2019-01-08','16 : 13 : 46','2');
INSERT INTO `news` VALUES (123,'123','all','123456','2019-01-08','16 : 16 : 05','2');
INSERT INTO `news` VALUES (124,'123','all','12345','2019-01-08','16 : 26 : 42','2');
INSERT INTO `news` VALUES (125,'123','all','你好','2019-01-08','16 : 26 : 58','2');
INSERT INTO `news` VALUES (126,'123','all','4651653','2019-01-08','16 : 34 : 53','2');
INSERT INTO `news` VALUES (127,'123','all','56165498456','2019-01-08','16 : 36 : 49','2');
INSERT INTO `news` VALUES (128,'123','all','你好','2019-01-08','16 : 37 : 00','2');
INSERT INTO `news` VALUES (129,'123','all','敲你吗','2019-01-08','16 : 37 : 06','2');
INSERT INTO `news` VALUES (130,'123','all','你好啊','2019-01-08','16 : 39 : 51','2');
INSERT INTO `news` VALUES (131,'123','all','你也好啊','2019-01-08','16 : 40 : 04','2');
INSERT INTO `news` VALUES (132,'123','all','子线程','2019-01-08','16 : 46 : 12','2');
INSERT INTO `news` VALUES (133,'123','all','在洗擦as第三方士大夫vfsfDDDSDszvz','2019-01-08','16 : 46 : 43','2');
INSERT INTO `news` VALUES (134,'123','all','你好','2019-01-08','17 : 33 : 37','2');
INSERT INTO `news` VALUES (135,'123','all','456486','2019-01-08','17 : 34 : 45','2');
INSERT INTO `news` VALUES (136,'123','all','+561246416584658','2019-01-08','17 : 42 : 27','2');
INSERT INTO `news` VALUES (137,'123','all','oshesfosjfjlsdkj','2019-01-08','17 : 43 : 32','2');
INSERT INTO `news` VALUES (138,'123','all','sfdghffsgdfdg','2019-01-08','17 : 43 : 44','2');
INSERT INTO `news` VALUES (139,'123','all','1654','2019-01-08','17 : 47 : 03','2');
INSERT INTO `news` VALUES (140,'123','all','你好','2019-01-08','17 : 47 : 11','2');
INSERT INTO `news` VALUES (141,'123','all','456456','2019-01-08','17 : 59 : 52','2');
INSERT INTO `news` VALUES (142,'123','all','456456你好啊','2019-01-08','18 : 00 : 04','2');
INSERT INTO `news` VALUES (143,'123','all','你好','2019-01-08','18 : 07 : 31','2');
INSERT INTO `news` VALUES (144,'123','all','你是谁','2019-01-08','18 : 07 : 37','2');
INSERT INTO `news` VALUES (145,'123','all','敲你吗','2019-01-08','18 : 07 : 51','2');
INSERT INTO `news` VALUES (146,'123','all','你好啊','2019-01-08','18 : 24 : 20','2');
INSERT INTO `news` VALUES (147,'123','all','你也好啊','2019-01-08','18 : 24 : 26','2');
INSERT INTO `news` VALUES (148,'123','all','你好啊','2019-01-08','18 : 25 : 13','2');
INSERT INTO `news` VALUES (149,'123','all','123','2019-01-08','20 : 13 : 28','2');
INSERT INTO `news` VALUES (150,'123','all','123','2019-01-08','20 : 23 : 18','2');
INSERT INTO `news` VALUES (151,'Wuchuan','all','31354561','2019-01-08','20 : 39 : 20','2');
INSERT INTO `news` VALUES (152,'123','all','34563453','2019-01-08','20 : 39 : 39','2');
INSERT INTO `news` VALUES (153,'Wuchuan','all','111','2019-01-08','20 : 39 : 48','2');
INSERT INTO `news` VALUES (154,'Wuchuan','all','22222','2019-01-08','20 : 39 : 57','2');
INSERT INTO `news` VALUES (155,'Wuchuan','all','测试','2019-01-08','20 : 53 : 50','2');
INSERT INTO `news` VALUES (156,'123abc','all','我也测试下','2019-01-08','20 : 54 : 06','2');
INSERT INTO `news` VALUES (157,'逗逗','all','入户套给','2019-01-08','20 : 56 : 39','2');
INSERT INTO `news` VALUES (158,'Wuchuan','all','？？','2019-01-08','20 : 56 : 56','2');
INSERT INTO `news` VALUES (159,'Wuchuan','all','555555','2019-01-08','20 : 57 : 22','2');
INSERT INTO `news` VALUES (160,'Wuchuan','all','','2019-01-08','20 : 57 : 24','2');
INSERT INTO `news` VALUES (161,'Wuchuan','all','哈哈哈','2019-01-08','20 : 57 : 30','2');
INSERT INTO `news` VALUES (162,'Wuchuan','all','哈哈哈','2019-01-08','20 : 57 : 41','2');
INSERT INTO `news` VALUES (163,'Wuchuan','all','55','2019-01-08','20 : 58 : 46','2');
INSERT INTO `news` VALUES (164,'Wuchuan','all','怒','2019-01-08','20 : 59 : 06','2');
INSERT INTO `news` VALUES (165,'Wuchuan','all','你好','2019-01-08','21 : 06 : 58','2');
INSERT INTO `news` VALUES (166,'Wuchuan','all','你好？','2019-01-08','21 : 07 : 08','2');
INSERT INTO `news` VALUES (167,'Wuchuan','all','怎么了','2019-01-08','21 : 07 : 27','2');
INSERT INTO `news` VALUES (168,'123','all','你看到我了吗','2019-01-08','21 : 07 : 41','2');
INSERT INTO `news` VALUES (169,'Wuchuan','all','2222','2019-01-08','21 : 07 : 55','2');
INSERT INTO `news` VALUES (170,'Wuchuan','all','？？？？？','2019-01-08','21 : 09 : 51','2');
INSERT INTO `news` VALUES (171,'123','all','你说啥','2019-01-08','21 : 13 : 45','2');
INSERT INTO `news` VALUES (172,'Wuchuan','all','你好','2019-01-08','21 : 19 : 48','2');
INSERT INTO `news` VALUES (173,'Wuchuan','all','你好？？？','2019-01-08','21 : 19 : 54','2');
INSERT INTO `news` VALUES (174,'Wuchuan','all','你好','2019-01-08','21 : 21 : 47','2');
INSERT INTO `news` VALUES (175,'hh','123','1111','2019-01-08','21 : 22 : 10','未');
INSERT INTO `news` VALUES (176,'123','123','1','2019-01-08','21 : 26 : 10','未');
INSERT INTO `news` VALUES (177,'123','sadfsa','123456','2019-01-08','21 : 30 : 57','未');
INSERT INTO `news` VALUES (178,'123','all','123','2019-01-08','21 : 43 : 07','2');
INSERT INTO `news` VALUES (179,'123','fhayibv','你好小兄弟','2019-01-08','23 : 20 : 00','未');
INSERT INTO `news` VALUES (180,'123','sdfvhdau','你好小兄弟','2019-01-08','23 : 20 : 03','未');
INSERT INTO `news` VALUES (181,'123','adsfasvcad','你好小兄弟','2019-01-08','23 : 20 : 10','未');
INSERT INTO `news` VALUES (182,'all','123','1345645687','2019-01-09','03 : 21 : 04','未');
INSERT INTO `news` VALUES (183,'all','123','1456456','2019-01-09','03 : 24 : 44','未');
INSERT INTO `news` VALUES (184,'all','123','法国红酒工程分发给','2019-01-09','03 : 24 : 48','未');
INSERT INTO `news` VALUES (185,'all','123','测试','2019-01-09','03 : 25 : 00','未');
INSERT INTO `news` VALUES (186,'all','123','4656456','2019-01-09','03 : 46 : 24','未');
INSERT INTO `news` VALUES (187,'all','Wuchuan','456456456','2019-01-09','03 : 46 : 30','未');
INSERT INTO `news` VALUES (188,'Wuchuan','123','123123','2019-01-09','03 : 55 : 14','未');
INSERT INTO `news` VALUES (189,'Wuchuan','Wuchuan','97867853','2019-01-09','03 : 55 : 49','未');
INSERT INTO `news` VALUES (190,'Wuchuan','123','123123','2019-01-09','03 : 55 : 54','未');
INSERT INTO `news` VALUES (191,'Wuchuan','123','123123','2019-01-09','03 : 55 : 57','未');
INSERT INTO `news` VALUES (192,'Wuchuan','Wuchuan','97867853','2019-01-09','03 : 56 : 42','未');
INSERT INTO `news` VALUES (193,'Wuchuan','Wuchuan','97867853','2019-01-09','03 : 56 : 49','未');
INSERT INTO `news` VALUES (194,'123','123','私聊测试','2019-01-09','03 : 58 : 41','未');
INSERT INTO `news` VALUES (195,'123','123','自己和自己聊天','2019-01-09','03 : 58 : 53','未');
INSERT INTO `news` VALUES (196,'123','123','123','2019-01-09','04 : 01 : 08','未');
INSERT INTO `news` VALUES (197,'123','123','123','2019-01-09','04 : 01 : 10','未');
INSERT INTO `news` VALUES (198,'123','123','123','2019-01-09','04 : 03 : 26','未');
INSERT INTO `news` VALUES (199,'123','123','123123','2019-01-09','04 : 03 : 29','未');
INSERT INTO `news` VALUES (200,'123','123','123123123123','2019-01-09','04 : 04 : 07','未');
INSERT INTO `news` VALUES (201,'123','123','123','2019-01-09','04 : 04 : 22','未');
INSERT INTO `news` VALUES (202,'123','123','123456789','2019-01-09','04 : 05 : 09','未');
INSERT INTO `news` VALUES (203,'123','123','123456789','2019-01-09','04 : 06 : 46','未');
INSERT INTO `news` VALUES (204,'123','123','123','2019-01-09','04 : 08 : 47','未');
INSERT INTO `news` VALUES (205,'123','123','123','2019-01-09','04 : 09 : 26','未');
INSERT INTO `news` VALUES (206,'123','123','123','2019-01-09','04 : 09 : 47','未');
INSERT INTO `news` VALUES (207,'123','123','测试','2019-01-09','04 : 09 : 52','未');
INSERT INTO `news` VALUES (208,'123','123','自己和自己聊天','2019-01-09','04 : 09 : 57','未');
INSERT INTO `news` VALUES (209,'123','123','最后一次测试','2019-01-09','04 : 11 : 02','未');
INSERT INTO `news` VALUES (210,'123','123','私聊','2019-01-09','04 : 11 : 05','未');
INSERT INTO `news` VALUES (211,'123','123','自己和自己聊天','2019-01-09','04 : 11 : 11','未');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

#
# Source for table user
#

CREATE TABLE `user` (
  `name` char(10) NOT NULL,
  `account` char(10) NOT NULL,
  `password` char(10) NOT NULL,
  `visi` char(1) DEFAULT '否',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table user
#
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` VALUES ('','','密码','否');
INSERT INTO `user` VALUES ('10000','10000','123','否');
INSERT INTO `user` VALUES ('12','12','123','否');
INSERT INTO `user` VALUES ('client','123','123','在');
INSERT INTO `user` VALUES ('1234567','1234567','1234567','否');
INSERT INTO `user` VALUES ('123abc','123abc','123abc','否');
INSERT INTO `user` VALUES ('201918','201918','201918','否');
INSERT INTO `user` VALUES ('465','4684','123','否');
INSERT INTO `user` VALUES ('978964494','978964494','123','否');
INSERT INTO `user` VALUES ('ASDF','ASDF','123','否');
INSERT INTO `user` VALUES ('ASDFG','ASDFG','123','否');
INSERT INTO `user` VALUES ('hh','hh','123456','否');
INSERT INTO `user` VALUES ('QWE','QWE','123','否');
INSERT INTO `user` VALUES ('Wuchuan','Wuchuan','123456','否');
INSERT INTO `user` VALUES ('逗逗','逗逗','zbyyhihy.','否');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
