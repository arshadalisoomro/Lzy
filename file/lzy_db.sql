/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.20 : Database - lzy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lzy` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `lzy`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`author`,`price`) values (1,'JAVA核心技术 卷I:基础知识','Cay S.Horstmann',99),(2,'深入理解Java虚拟机','周志明',79),(3,'Effective Java','Joshua Bloch',52),(4,'Java并发编程的艺术','方腾飞',59),(5,'Java网络编程精解','孙卫琴',50),(6,'深入剖析Tomcat','Budi Kumiawan Paul Deck',59),(7,'分布式Java 基础与实践','林昊',30),(8,'大型网站系统与Java中间件实践','曾宪杰',65),(9,'从Paxos到Zookeeper','倪超',75),(10,'Introduction to Algorithms','Thomas H.cormen Charles E. Leiserson Ron',128);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
