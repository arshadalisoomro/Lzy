
CREATE DATABASE `lzy`;

USE `lzy`;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert  into `book`(`id`,`name`,`author`,`price`) values (1,'JAVA核心技术 卷I:基础知识','Cay S.Horstmann',99),(2,'深入理解Java虚拟机','周志明',79),(3,'Effective Java','Joshua Bloch',52),(4,'Java并发编程的艺术','方腾飞',59),(5,'Java网络编程精解','孙卫琴',50),(6,'深入剖析Tomcat','Budi Kumiawan Paul Deck',59),(7,'分布式Java 基础与实践','林昊',30),(8,'大型网站系统与Java中间件实践','曾宪杰',65),(9,'从Paxos到Zookeeper','倪超',75),(10,'Introduction to Algorithms','Thomas H.cormen Charles E. Leiserson Ron',128);
