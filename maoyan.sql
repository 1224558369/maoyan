/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - maoyan
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`maoyan` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `maoyan`;

/*Table structure for table `authority` */

DROP TABLE IF EXISTS `authority`;

CREATE TABLE `authority` (
  `auth_id` int(200) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `auth_alias` varchar(200) DEFAULT NULL,
  `auto_description` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci DEFAULT NULL,
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `authority` */

insert  into `authority`(`auth_id`,`auth_name`,`auth_alias`,`auto_description`) values (20,'后台管理','user_root','用户管理'),(21,'用户购票','user_insert','购票 '),(22,'评论','user_comment','评论');

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `brand_id` bigint(20) unsigned NOT NULL COMMENT '品牌id',
  `brand_name` varchar(50) NOT NULL COMMENT '品牌名称',
  `brand_status` int(1) NOT NULL DEFAULT '0' COMMENT '0:下架 1:上架',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `brand` */

insert  into `brand`(`brand_id`,`brand_name`,`brand_status`) values (188982,'万达影城',1),(188983,'MC影城',1),(188984,'大地影院',1),(908887,'其他',1),(1411953352180985858,'徐攀影城',0);

/*Table structure for table `cinema` */

DROP TABLE IF EXISTS `cinema`;

CREATE TABLE `cinema` (
  `cinema_id` bigint(20) unsigned NOT NULL COMMENT '电影院id',
  `cinema_name` varchar(50) NOT NULL COMMENT '电影院名称',
  `cinema_img` varchar(200) DEFAULT NULL COMMENT '电影院图片',
  `cinema_site` varchar(50) NOT NULL COMMENT '电影院具体位置',
  `cinema_phone` varchar(50) NOT NULL COMMENT '电影院联系电话',
  `cinema_service` varchar(50) DEFAULT NULL COMMENT '电影服务',
  `brand_id` bigint(50) NOT NULL COMMENT '0代表其他品牌',
  `cinema_status` int(1) NOT NULL DEFAULT '0' COMMENT '0:下架 1:上映',
  PRIMARY KEY (`cinema_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cinema` */

insert  into `cinema`(`cinema_id`,`cinema_name`,`cinema_img`,`cinema_site`,`cinema_phone`,`cinema_service`,`brand_id`,`cinema_status`) values (12345,'MC影城环奥店','https://huyuya.oss-cn-hangzhou.aliyuncs.com/2021/07/05/f518bc67b9a84107806176d196850e36file.png','望城区雷锋大道668号环球奥特莱斯内','0731-82665966','可改签',188983,0),(202162801,'丽发新城店','http://qvriw4lye.hn-bkt.clouddn.com/2021/07/08/b80208e910634bc783c35b1583fa26b0file.png','天心区暮云街道万家丽南路二段989号丽发新城丽发商业大楼102号4-5层','0731-88286699','可退票,可改签',188982,1),(202162802,'长沙正荣财富店','https://huyuya.oss-cn-hangzhou.aliyuncs.com/2021/07/05/3e2a1170d5874b9c82d40f2533999a4bfile.png','望城区湖南省长沙市正荣财富中心三楼','0731-88329563','可改签',188984,1),(202162803,'龙塘店','https://huyuya.oss-cn-hangzhou.aliyuncs.com/2021/07/05/e19f250b4d7545f89deb0fdd75a8820dfile.png','长沙县星沙区龙塘小区a5栋4-5楼','0731-23131321','可退票',188982,1),(1412254497345933314,'龙塘二店','http://qvriw4lye.hn-bkt.clouddn.com/2021/07/06/87045cc3c2f44af3affe9b550fe4bbedfile.png','长沙县星沙区龙塘小区a6栋4-5楼','13221231321','可退票',908887,0),(1415493796827447297,'徐攀私人影院','http://qvriw4lye.hn-bkt.clouddn.com/2021/07/15/87f249b51cfb4772ac40013217e58e61file.png','长沙市长沙县湘龙街道龙塘小区a5栋503','10086','大折扣,可退票,可改签',1411953352180985858,0);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `comments_id` bigint(20) NOT NULL COMMENT '评论编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `user_nickname` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `comments_score` int(11) NOT NULL COMMENT '评分',
  `comments_content` varchar(256) NOT NULL COMMENT '评论内容',
  `film_id` bigint(20) NOT NULL COMMENT '所属电影编号',
  `create_time` datetime NOT NULL COMMENT '评论时间',
  `comments_like` bigint(20) NOT NULL COMMENT '点赞',
  PRIMARY KEY (`comments_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

insert  into `comments`(`comments_id`,`user_id`,`user_nickname`,`comments_score`,`comments_content`,`film_id`,`create_time`,`comments_like`) values (222,1,'胡煜',5,'还可以',1231231,'2021-07-09 09:26:07',121),(1231,2,'管理员',7,'一般般吧',1231231,'2021-07-13 10:14:18',19),(2221,1,'胡煜',6,'还不错',1377098,'2021-07-09 09:49:18',21),(1415120918019117057,1,'胡煜',3,'真不行   ',1231231,'2021-07-14 09:28:13',0),(1415501619825201154,1,'胡煜',5,'徐攀觉得好差       ',1231231,'2021-07-15 10:40:59',0),(1415835461924651010,1,'胡煜',8,'123        ',1377099,'2021-07-16 08:47:33',0),(1415835509223817218,1,'胡煜',9,'很喜欢      ',1410859216409374721,'2021-07-16 08:47:45',0),(1415835586487091201,1,'胡煜',2,'丢漫威的脸      ',1413316982509465602,'2021-07-16 08:48:03',0),(1415835671992172546,1,'胡煜',10,'新海诚yyds        ',1413317417941135361,'2021-07-16 08:48:23',0),(1415842197521059841,1,'胡煜',2,'烂片 狗都不看 ',1415200203210485761,'2021-07-16 09:14:19',0);

/*Table structure for table `film` */

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
  `film_id` bigint(20) NOT NULL COMMENT '电影id',
  `film_name` varchar(50) NOT NULL COMMENT '电影名称',
  `film_actor` varchar(50) NOT NULL COMMENT '电影主演',
  `film_type` varchar(50) NOT NULL COMMENT '电影类型用逗号隔开',
  `film_source` varchar(50) NOT NULL COMMENT '电影产区',
  `film_release` datetime NOT NULL COMMENT '上映时间',
  `film_duration` int(11) NOT NULL COMMENT '电影时长',
  `film_img` varchar(200) DEFAULT NULL COMMENT '电影封面',
  `film_description` varchar(500) DEFAULT NULL COMMENT '电影描述',
  `film_likesum` bigint(200) DEFAULT '0' COMMENT '喜欢人数',
  `film_status` int(1) NOT NULL DEFAULT '0' COMMENT '1:上架 0:下架 2:即将上映',
  PRIMARY KEY (`film_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `film` */

insert  into `film`(`film_id`,`film_name`,`film_actor`,`film_type`,`film_source`,`film_release`,`film_duration`,`film_img`,`film_description`,`film_likesum`,`film_status`) values (1231231,'中国医生','张涵予 袁泉 朱亚文','剧情','中国大陆','2021-07-09 00:00:00',129,'http://qvriw4lye.hn-bkt.clouddn.com/2021/07/07/9ce69649b64e4f948df05c15be02a0d7file.png','电影《中国医生》根据新冠肺炎疫情防控斗争的真实事件改编，以武汉市金银潭医院为核心故事背景，同时兼顾武汉同济医院、武汉市肺科医院、武汉协和医院、武汉大学人民医院（湖北省人民医院）、火神山医院、方舱医院等兄弟单位，以武汉医护人员、全国各省市援鄂医疗队为人物原型，全景式记录波澜壮阔、艰苦卓绝的抗疫斗争。',20002,0),(1377098,'1921','黄轩,倪妮,王仁君','爱情,喜剧','中国大陆','2021-07-01 08:00:00',137,'http://qvriw4lye.hn-bkt.clouddn.com/2021/07/12/4c62d670ca5341ba8dbfdcd447064b5afile.png','影片以时代“横截面”视角切入，聚焦1921年前后的故事，全景式重现了百年前波澜壮阔、开天辟地的历史时刻——来自五湖四海平均年龄仅28岁的热血青年们，突破国际各股复杂势力的监控和追踪，聚集上海召开中国共产党第一次代表大会，见证中国共产党的成立。',19090,1),(1377099,'我没谈完的那场恋爱','邱泽,许玮甯,蔡振南','剧情,历史','中国大陆','2021-06-25 08:00:00',97,'https://huyuya.oss-cn-hangzhou.aliyuncs.com/2021/06/28/b755aaa66e174ccb9bafb0b5445fb35176b8842586867b761de63b42c2d325751523113.jpg','本片讲述了两个千差万别却同样迷茫的年轻音乐人，一个是多年打拼,事业毫无起色,又屡遭生活暴击的和声歌手珊妮,一个是身患重病,隐姓埋名等待死亡降临的前摇滚乐手董东,对生命感到绝望的二人在自我了断时相遇......自杀计划流产,他们的生活也因彼此的出现发生改变。另外一个时空的故事,从珊妮意外发现的一本1970年代的日记中铺陈开来,一段没有下文的悲伤爱情竟然在珊妮的努力下尘埃落定。跟音乐、爱情和人生有关的种种,让珊妮与董东的相遇愈发神奇。千丝万缕中,是否每一种爱都能开花结果? 他们能否找到继续爱这个世界的理由?',123124,1),(1410859216409374721,'革命者','张颂文,李易峰,佟丽娅','剧情,历史','中国大陆','2021-07-01 00:00:00',121,'https://huyuya.oss-cn-hangzhou.aliyuncs.com/2021/07/02/e0a6ae06e0384567a77a13ba5174744cfile.png','1927年4月26日，距离李大钊被执行绞刑还有38小时。此时，我党各方力量仍在积极组织着对他的营救行动，而敌人也在千方百计对他施以酷刑，但依旧毫无进展。焦灼之时，一个年轻警察进入狱中欲对守常先生施以新刑，而关于守常先生一生的革命回忆，也就此拉开帷幕……',13210,0),(1413316982509465602,'X战警：黑凤凰','徐攀,周少','剧情,科幻','美国','2021-07-02 09:59:17',140,'http://qvriw4lye.hn-bkt.clouddn.com/2021/07/09/543452b5c39c440e83f68cccc61fa2d4file.png','非常炫酷的战斗 徐攀奋勇杀敌',21211,0),(1413317417941135361,' 你好世界','北村江海','爱情,奇幻,动画','日本','2021-07-08 10:01:14',98,'http://qvriw4lye.hn-bkt.clouddn.com/2021/07/09/c68142b62b034fa1a8a3e8558b0bede6file.png','在京都居住的内向男高中生直实（北村匠海 配音）的面前，突然出现从10年后穿越而来26岁的自己（松坂桃李 配音）。未来的直实告诉他，自己不久便会与琉璃（滨边美波 配音）相爱，可是之后烟花大会时她却会因为一场事故意外离世。为了拯救爱人，16岁的直实卷入了这场现实与虚拟的记忆世界，经历了一系列超乎想象的事情。即使世界毁灭，我也想再见你一面。',424211,0),(1415200203210485761,'大学','徐攀','纪录片','中国大陆','2021-07-09 00:00:00',110,'http://qvriw4lye.hn-bkt.clouddn.com/2021/07/14/b57d0e46796f4ac3a646fed69346d439file.png','在清华园里，有四个人正站在自己人生的路口。他们之中，有刚历经高考、一波三折地考入心仪学府的第一代“00”后大学生，有即将离开象牙塔、面临艰难抉择的博士毕业生，有旅美归来入职清华、满怀“观天”理想却挑战重重的青年教师，有耄耋之年、荣休后依然坚持站立三尺讲台的老院士。影片以三年的悠悠光景，诉说了四个清华人一生的理想，以及在他们身后属于这所大学的永恒青春。',123,0);

/*Table structure for table `hall` */

DROP TABLE IF EXISTS `hall`;

CREATE TABLE `hall` (
  `hall_id` bigint(20) unsigned NOT NULL COMMENT '放映场次id',
  `cinema_id` bigint(20) unsigned NOT NULL COMMENT '电影院id',
  `videohall_id` bigint(20) NOT NULL COMMENT '放映厅id',
  `film_id` bigint(20) unsigned NOT NULL COMMENT '电影id',
  `film_name` varchar(50) NOT NULL COMMENT '电影名称',
  `hall_date` date NOT NULL COMMENT '放映日期',
  `hall_begin_time` time NOT NULL COMMENT '开始放映时间',
  `hall_end_time` time NOT NULL COMMENT '放映结束时间',
  `hall_language` varchar(50) NOT NULL COMMENT '语言版本',
  `hall_price` decimal(10,0) NOT NULL COMMENT '售价',
  `hall_status` int(1) DEFAULT '0' COMMENT '0:下架',
  PRIMARY KEY (`hall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hall` */

insert  into `hall`(`hall_id`,`cinema_id`,`videohall_id`,`film_id`,`film_name`,`hall_date`,`hall_begin_time`,`hall_end_time`,`hall_language`,`hall_price`,`hall_status`) values (202,202162801,1,1377099,'我没谈完的那场恋爱','2021-07-07','09:00:28','11:00:28','原版3D','72',1),(2021105881,202162801,1,1377099,'我没谈完的那场恋爱','2021-06-29','11:45:00','13:39:00','原版2D','65',1),(1412664087963271169,202162803,1412663943595327490,1231231,'中国医生','2021-07-08','08:40:00','10:30:00','国语3D','35',1),(1412664734645256194,202162803,1412663943595327490,1231231,'中国医生','2021-07-08','10:30:00','12:00:00','国语2D','50',0),(1412665684592197634,202162803,1412663943595327490,1231231,'中国医生','2021-07-08','13:00:00','15:00:00','国版2D','36',0),(1415492904774483970,12345,1231,1415200203210485761,'大学','2021-07-08','08:30:00','10:00:00','2D','36',0),(1415493130079911938,202162802,1415493034902765569,1413316982509465602,'X战警：黑凤凰','2021-07-14','08:30:00','10:00:00','3D','67',0),(1415493360535945217,1412254497345933314,1415493247121965058,1410859216409374721,'革命者','2021-07-14','08:50:00','10:45:00','2D','42',0),(1415494059961303042,1415493796827447297,1415493922186805249,1377099,'我没谈完的那场恋爱','2021-07-15','10:10:00','12:00:00','5D','199',0);

/*Table structure for table `halltype` */

DROP TABLE IF EXISTS `halltype`;

CREATE TABLE `halltype` (
  `halltype_id` bigint(20) NOT NULL COMMENT '放映厅类型id',
  `halltype_name` varchar(50) NOT NULL COMMENT '放映厅类型名称',
  `halltype_status` int(1) NOT NULL DEFAULT '0' COMMENT '0:删除',
  PRIMARY KEY (`halltype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `halltype` */

insert  into `halltype`(`halltype_id`,`halltype_name`,`halltype_status`) values (2000,'普通厅',1),(2001,'IMAX厅',1),(2002,'4D厅',1);

/*Table structure for table `likes` */

DROP TABLE IF EXISTS `likes`;

CREATE TABLE `likes` (
  `like_id` bigint(20) NOT NULL COMMENT '主键',
  `film_id` bigint(20) NOT NULL COMMENT '电影id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `is_like` int(1) NOT NULL DEFAULT '0' COMMENT '0:喜欢 1:不喜欢',
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `likes` */

insert  into `likes`(`like_id`,`film_id`,`user_id`,`is_like`) values (1414760959972597762,1231231,1,0),(1415111397561364481,1231231,2,0),(1415123795110334465,1377099,1,0),(1415850085773754370,1413317417941135400,1,0),(1415850220641599489,1410859216409374700,1,0),(1415861112406036481,1413316982509465600,1,0),(1415868244245393409,1410859216409374721,1,0);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` bigint(20) unsigned NOT NULL COMMENT '电影票订单流水号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `user_nick` varchar(50) NOT NULL COMMENT '用户昵称',
  `hall_id` bigint(20) NOT NULL COMMENT '场次id',
  `show_time` time NOT NULL COMMENT '电影放映时间',
  `show_date` date NOT NULL COMMENT '放映日期',
  `cinema_id` bigint(20) NOT NULL COMMENT '电影院id',
  `hall_name` varchar(50) NOT NULL COMMENT '放映厅名称',
  `film_id` bigint(20) NOT NULL COMMENT '所属电影编号',
  `film_name` varchar(50) NOT NULL COMMENT '电影名称（中文）',
  `order_position` varchar(50) NOT NULL COMMENT '电影票座位（x排x座）',
  `order_price` decimal(10,0) NOT NULL COMMENT '订单价格',
  `create_time` datetime NOT NULL COMMENT '订单创建时间',
  `order_time` datetime DEFAULT NULL COMMENT '订单支付时间',
  `order_status` int(10) NOT NULL DEFAULT '0' COMMENT '0:支付中 1:支付完成 2:取消订单 3:退票',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`order_id`,`user_id`,`user_nick`,`hall_id`,`show_time`,`show_date`,`cinema_id`,`hall_name`,`film_id`,`film_name`,`order_position`,`order_price`,`create_time`,`order_time`,`order_status`) values (123,1,'胡煜',202,'09:00:28','2021-07-07',202162801,'一号厅',1377099,'我没谈完的那场恋爱','1-3','36','2021-06-24 19:43:43','2021-07-15 16:10:23',1),(1417331339681660929,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','1-1','36','2021-07-09 19:43:45','2021-07-16 16:10:21',1),(1417737755821830146,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','9-8,9-7','72','2021-07-21 14:46:35','2021-07-23 16:10:18',1),(1418497125962682369,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','1-2,1-3','72','2021-07-23 17:04:03','2021-07-23 16:10:15',1),(1420295197929107458,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','1-4','36','2021-07-28 16:08:57','2021-07-28 16:11:35',1),(1420298524175740929,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','1-8','36','2021-07-28 16:22:10',NULL,2),(1420302737077235713,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','1-8','36','2021-07-28 16:38:55','2021-07-28 16:39:31',3),(1420357370747363329,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','2-1','36','2021-07-28 20:16:00',NULL,2),(1420357422488297474,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','3-1','36','2021-07-28 20:03:13',NULL,2),(1420363265724137474,1,'胡煜',1415492904774483970,'08:30:00','2021-07-08',12345,'高级厅',1415200203210485761,'大学','2-1','36','2021-07-28 20:39:26','2021-07-28 20:40:31',3);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_czech_ci DEFAULT NULL COMMENT '角色描述',
  `role_status` int(1) unsigned DEFAULT NULL COMMENT '角色状态',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`,`role_description`,`role_status`) values (1,'管理员','管理员拥有所有权限',1),(2,'会员用户','会员可以购票 发表评论',1),(3,'普通用户','可以购票',1);

/*Table structure for table `role_authority` */

DROP TABLE IF EXISTS `role_authority`;

CREATE TABLE `role_authority` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `role_id` int(100) NOT NULL,
  `auth_id` int(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `role_authority` */

insert  into `role_authority`(`id`,`role_id`,`auth_id`) values (1,1,20),(2,2,21),(3,2,22),(4,3,21),(5,1,21),(6,1,22);

/*Table structure for table `role_user` */

DROP TABLE IF EXISTS `role_user`;

CREATE TABLE `role_user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(100) NOT NULL,
  `role_id` int(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role_user` */

insert  into `role_user`(`id`,`user_id`,`role_id`) values (1,1,2),(2,2,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) unsigned NOT NULL,
  `user_name` varchar(255) NOT NULL DEFAULT '',
  `user_pass` varchar(255) NOT NULL DEFAULT '',
  `user_nickname` varchar(255) NOT NULL DEFAULT '',
  `user_email` varchar(100) DEFAULT '',
  `user_url` varchar(100) DEFAULT '',
  `user_avatar` varchar(255) DEFAULT NULL,
  `user_last_login_ip` varchar(255) DEFAULT NULL,
  `user_register_time` datetime DEFAULT NULL,
  `user_last_login_time` datetime DEFAULT NULL,
  `user_status` int(1) unsigned DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_pass`,`user_nickname`,`user_email`,`user_url`,`user_avatar`,`user_last_login_ip`,`user_register_time`,`user_last_login_time`,`user_status`) values (1,'huyu','123456','胡煜','1224558369@qq.com','http://huyuya.com','https://huyuya.oss-cn-hangzhou.aliyuncs.com/mm01.jpg','113.246.219.134','2017-10-06 21:56:33','2021-04-14 21:49:34',1),(2,'admin','admin','admin','122455836@qq.com','http://huyuya.com','https://huyuya.oss-cn-hangzhou.aliyuncs.com/mm01.jpg','0:0:0:0:0:0:0:1','2021-07-23 09:57:22','2021-07-28 10:25:13',1);

/*Table structure for table `videohall` */

DROP TABLE IF EXISTS `videohall`;

CREATE TABLE `videohall` (
  `videohall_id` bigint(20) unsigned NOT NULL COMMENT '放映厅编号',
  `videohall_name` varchar(50) NOT NULL COMMENT '放映厅名称',
  `cinema_id` bigint(20) NOT NULL COMMENT '所属电影院',
  `halltype_id` bigint(20) NOT NULL COMMENT '放映厅类型',
  `videohall_seating` decimal(10,0) NOT NULL COMMENT '放映厅座位数',
  PRIMARY KEY (`videohall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `videohall` */

insert  into `videohall`(`videohall_id`,`videohall_name`,`cinema_id`,`halltype_id`,`videohall_seating`) values (1,'一号厅',202162801,2000,'64'),(2,'二号厅',202162801,2001,'86'),(1231,'高级厅',12345,2001,'88'),(1412229438970191873,'一号厅',12345,2000,'64'),(1412663943595327490,'MAX厅',202162803,2001,'64'),(1415493034902765569,'一号厅',202162802,2000,'64'),(1415493247121965058,'三号厅',1412254497345933314,2002,'108'),(1415493922186805249,'神秘厅',1415493796827447297,2001,'6');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
