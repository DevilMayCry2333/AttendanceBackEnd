/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 127.0.0.1
 Source Database       : attendsys

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : utf-8

 Date: 07/08/2019 15:30:13 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `attend`
-- ----------------------------
DROP TABLE IF EXISTS `attend`;
CREATE TABLE `attend` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `EarlyTime` varchar(255) DEFAULT NULL,
  `LateTime` varchar(255) DEFAULT NULL,
  `EmpName` varchar(255) DEFAULT NULL,
  `ClassId` varchar(255) DEFAULT NULL,
  `attendStatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=521 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `attend`
-- ----------------------------
BEGIN;
INSERT INTO `attend` VALUES ('518', '2019-07-08 09:00:00', '2019-07-08 20:00:00', '游开钰', '2', '正常'), ('519', '2019-07-08 09:00:00', '2019-07-08 21:00:00', '小小', '2', '正常'), ('520', '2019-07-08 08:00:00', '2019-07-08 21:00:00', '肖腾跃', '2', '正常');
COMMIT;

-- ----------------------------
--  Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `ClassId` varchar(10) DEFAULT NULL,
  `Cname` varchar(15) DEFAULT NULL,
  `Mtime` time(6) DEFAULT NULL,
  `Atime` time(6) DEFAULT NULL,
  `Descri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `ClassId` (`ClassId`)
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `classes`
-- ----------------------------
BEGIN;
INSERT INTO `classes` VALUES ('22', '1', '管理', '09:00:00.000000', '15:00:00.000000', null), ('214', '2', 'JUnitTest2', '09:00:00.000000', '16:00:00.000000', null), ('666', '3', '测试', '08:58:00.000000', '17:58:03.000000', null);
COMMIT;

-- ----------------------------
--  Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `departmentId` varchar(10) DEFAULT NULL,
  `Dname` varchar(15) DEFAULT NULL,
  `Dprincipal` varchar(10) DEFAULT NULL,
  `Dability` varchar(255) DEFAULT NULL,
  `Sdepartment` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `department`
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES ('22', '1', '销售部门', '游开钰', '销售', '销售'), ('23', '2', '开发部门', '游开钰', '开发', '开发');
COMMIT;

-- ----------------------------
--  Table structure for `employ`
-- ----------------------------
DROP TABLE IF EXISTS `employ`;
CREATE TABLE `employ` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `employId` varchar(20) DEFAULT NULL,
  `UserName` varchar(15) DEFAULT NULL,
  `Nation` varchar(10) DEFAULT NULL,
  `IDNumber` varchar(255) DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `EmeContact` varchar(20) DEFAULT NULL,
  `Job` varchar(20) DEFAULT NULL,
  `Describle` varchar(255) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `ClassId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `ClassId` (`ClassId`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `employ`
-- ----------------------------
BEGIN;
INSERT INTO `employ` VALUES ('34', '1', '游开钰', '汉', '350122', '1000', '137', '137', '销售', '为空', '22', '男', '3'), ('35', '2', '林煊鸿', '汉', '350111', '10000', '137', '137', '销售', '无', '20', '男', '3'), ('36', '3', '林善凯', '汉', '3501', '10000', '183', '183', '销售', '无', '20', '男', '3'), ('37', '4', '肖腾跃', '汉', '3501', '10000', '10086', '10086', '销售', '无', '30', '男', '3'), ('50', '22', '小小', '11', '11', '11', '11', '11', '开发', '11', '33', '男', '214'), ('51', '5', '小敏', '汉', '3501', '1000', '137', '137', '开发', '无', '20', '男', '2'), ('52', '7', '新晋员工', '汉', '137', '1000', '137', '137', '开发', '无', '20', '男', '2'), ('53', '8', 'Aimer', '汉', '350122', '10000', '137', '无', '管理', '无', '18', '女', '2'), ('54', '9', 'Alpha', '汉', '35011', '2000', '137', '137', '管理', '无', '22', '男', '2'), ('55', '10', 'Beta', '汉', '350122', '1000', '137', '137', '管理', '无', '19', '男', '2'), ('56', '11', '程序猿', '汉', '350122', '10000', '137', '137', '开发', '无', '18', '男', '2');
COMMIT;

-- ----------------------------
--  Table structure for `myleave`
-- ----------------------------
DROP TABLE IF EXISTS `myleave`;
CREATE TABLE `myleave` (
  `LeaveId` varchar(10) DEFAULT NULL,
  `LeaveName` varchar(15) DEFAULT NULL,
  `BeginDate` datetime(6) DEFAULT NULL,
  `EndDate` datetime(6) DEFAULT NULL,
  `LeaveReason` varchar(255) DEFAULT NULL,
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `myleave`
-- ----------------------------
BEGIN;
INSERT INTO `myleave` VALUES ('1', '小小', '2019-07-09 08:00:00.000000', '2019-07-09 08:00:00.000000', '看病', '8');
COMMIT;

-- ----------------------------
--  Table structure for `paysalary`
-- ----------------------------
DROP TABLE IF EXISTS `paysalary`;
CREATE TABLE `paysalary` (
  `PSId` varchar(10) DEFAULT NULL,
  `PSName` varchar(15) DEFAULT NULL,
  `Salary` decimal(6,0) DEFAULT NULL,
  `BeginDate` datetime(6) DEFAULT NULL,
  `EndDate` datetime(6) DEFAULT NULL,
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `paysalary`
-- ----------------------------
BEGIN;
INSERT INTO `paysalary` VALUES ('1', 'Joker', '10', '2019-06-22 00:07:04.000000', '2019-06-22 00:07:07.000000', '1');
COMMIT;

-- ----------------------------
--  Table structure for `punch`
-- ----------------------------
DROP TABLE IF EXISTS `punch`;
CREATE TABLE `punch` (
  `punchId` varchar(10) DEFAULT NULL,
  `ClassId` varchar(10) DEFAULT NULL,
  `UserName` varchar(15) DEFAULT NULL,
  `punchDate` datetime(6) DEFAULT NULL,
  `Remarks` varchar(255) DEFAULT NULL,
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `punch`
-- ----------------------------
BEGIN;
INSERT INTO `punch` VALUES ('1', '2', '游开钰', '2019-07-08 09:00:00.000000', '无', '22'), ('2', '2', '游开钰', '2019-07-08 20:00:00.000000', '无', '23'), ('3', '2', '小小', '2019-07-08 21:00:00.000000', '无', '24'), ('4', '2', '肖腾跃', '2019-07-08 21:00:00.000000', '无', '25');
COMMIT;

-- ----------------------------
--  Table structure for `repair`
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `repairId` varchar(10) DEFAULT NULL,
  `ClassId` varchar(10) DEFAULT NULL,
  `UserName` varchar(15) DEFAULT NULL,
  `repairDate` datetime(6) DEFAULT NULL,
  `Reason` varchar(255) DEFAULT NULL,
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `repair`
-- ----------------------------
BEGIN;
INSERT INTO `repair` VALUES ('1', '2', '小小', '2019-07-08 09:00:00.000000', '无', '7'), ('3', '2', '肖腾跃', '2019-07-08 08:00:00.000000', '无', '8'), ('22', '33', '测试', '2019-07-15 00:00:00.000000', '', '10');
COMMIT;

-- ----------------------------
--  Table structure for `station`
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `JobId` varchar(10) DEFAULT NULL,
  `Pname` varchar(15) DEFAULT NULL,
  `Adepartment` varchar(20) DEFAULT NULL,
  `Isuperior` varchar(10) DEFAULT NULL,
  `Jcategory` enum('管理类','我就是董事长','技术类') DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `station`
-- ----------------------------
BEGIN;
INSERT INTO `station` VALUES ('24', '1', '销售前台', '0', '2', '我就是董事长'), ('25', '2', '技术顾问', '管理', '三无软件技术总监', '管理类');
COMMIT;

-- ----------------------------
--  Table structure for `tLogin`
-- ----------------------------
DROP TABLE IF EXISTS `tLogin`;
CREATE TABLE `tLogin` (
  `Id` int(20) NOT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `PassWord` varchar(255) DEFAULT NULL,
  `UserId` varchar(20) DEFAULT NULL,
  `LoginCount` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `tLogin`
-- ----------------------------
BEGIN;
INSERT INTO `tLogin` VALUES ('1', 'root', '49c032802743b23f39b1304eb9414951cf0ad21389290f22', '1', '1');
COMMIT;

-- ----------------------------
--  View structure for `realacard`
-- ----------------------------
DROP VIEW IF EXISTS `realacard`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `realacard` AS select `punch`.`punchId` AS `punchId`,`punch`.`UserName` AS `UserName`,`punch`.`punchDate` AS `punchDate`,cast(`punch`.`punchDate` as date) AS `DaypunchDate`,`punch`.`ClassId` AS `ClassId` from `punch` where (cast(`punch`.`punchDate` as time(6)) > '12:00:00') union select `repair`.`repairId` AS `repairId`,`repair`.`UserName` AS `UserName`,`repair`.`repairDate` AS `repairDate`,cast(`repair`.`repairDate` as date) AS `DayrepairDate`,`repair`.`ClassId` AS `ClassId` from `repair` where (cast(`repair`.`repairDate` as time(6)) > '12:00:00');


-- ----------------------------
--  View structure for `realmcard`
-- ----------------------------
DROP VIEW IF EXISTS `realmcard`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `realmcard` AS select `punch`.`punchId` AS `punchId`,`punch`.`UserName` AS `UserName`,`punch`.`punchDate` AS `punchDate`,cast(`punch`.`punchDate` as date) AS `DaypunchDate`,`punch`.`ClassId` AS `ClassId` from `punch` where (cast(`punch`.`punchDate` as time(6)) < '12:00:00') union select `repair`.`repairId` AS `repairId`,`repair`.`UserName` AS `UserName`,`repair`.`repairDate` AS `repairDate`,cast(`repair`.`repairDate` as date) AS `DayrepairDate`,`repair`.`ClassId` AS `ClassId` from `repair` where (cast(`repair`.`repairDate` as time(6)) < '12:00:00');


-- ----------------------------
--  View structure for `realall`
-- ----------------------------
DROP VIEW IF EXISTS `realall`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `realall` AS select `realmcard`.`UserName` AS `UserName`,if((`realmcard`.`DaypunchDate` = `realacard`.`DaypunchDate`),`realmcard`.`punchDate`,`realmcard`.`punchDate`) AS `EarlyTime`,if((`realacard`.`DaypunchDate` = `realmcard`.`DaypunchDate`),`realacard`.`punchDate`,'缺勤') AS `LatTime`,`realmcard`.`ClassId` AS `ClassId` from (`realmcard` left join `realacard` on((`realmcard`.`UserName` = `realacard`.`UserName`))) union select `realacard`.`UserName` AS `UserName`,if((`realmcard`.`DaypunchDate` = `realacard`.`DaypunchDate`),`realmcard`.`punchDate`,'缺勤') AS `EarlyTime`,if((`realacard`.`DaypunchDate` = `realmcard`.`DaypunchDate`),`realacard`.`punchDate`,`realacard`.`punchDate`) AS `LatTime`,`realacard`.`ClassId` AS `ClassId` from (`realacard` left join `realmcard` on((`realmcard`.`UserName` = `realacard`.`UserName`)));



-- ----------------------------
--  View structure for `realsalary`
-- ----------------------------
DROP VIEW IF EXISTS `realsalary`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `realsalary` AS select `attend`.`Id` AS `idx`,`attend`.`EarlyTime` AS `EarlyTime`,`attend`.`LateTime` AS `LateTime`,`attend`.`EmpName` AS `EmpName`,`attend`.`ClassId` AS `ClassId`,`attend`.`attendStatus` AS `attendStatus`,`myleave`.`LeaveId` AS `LeaveId`,`myleave`.`BeginDate` AS `BeginDate`,`myleave`.`EndDate` AS `EndDate`,`myleave`.`LeaveReason` AS `LeaveReason`,`myleave`.`Id` AS `Id`,timestampdiff(HOUR,`myleave`.`BeginDate`,`myleave`.`EndDate`) AS `LeaveTime` from (`attend` left join `myleave` on((`attend`.`EmpName` = `myleave`.`LeaveName`)));

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
--  View structure for `absday`
-- ----------------------------
DROP VIEW IF EXISTS `absday`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `absday` AS select `realall`.`UserName` AS `UserName`,`realall`.`EarlyTime` AS `EarlyTime`,`realall`.`LatTime` AS `LatTime`,`realall`.`ClassId` AS `ClassId` from `realall` where (isnull(`realall`.`EarlyTime`) or isnull(`realall`.`LatTime`));

-- ----------------------------
--  View structure for `earlyafternoon`
-- ----------------------------
DROP VIEW IF EXISTS `earlyafternoon`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `earlyafternoon` AS select `realacard`.`punchId` AS `punchId`,`realacard`.`UserName` AS `UserName`,`realmcard`.`punchDate` AS `t1`,`realacard`.`punchDate` AS `t2`,`realacard`.`ClassId` AS `ClassId` from (`realacard` join `realmcard`) where ((cast(`realacard`.`punchDate` as time(6)) < (select `classes`.`Atime` from `classes` where (`realacard`.`ClassId` = `classes`.`ClassId`))) and (cast(`realmcard`.`punchDate` as date) = cast(`realacard`.`punchDate` as date)) and (`realmcard`.`UserName` = `realacard`.`UserName`));

-- ----------------------------
--  View structure for `intw`
-- ----------------------------
DROP VIEW IF EXISTS `intw`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `intw` AS select `realmcard`.`punchId` AS `punchId`,`realmcard`.`UserName` AS `UserName`,`realmcard`.`punchDate` AS `t1`,`realacard`.`punchDate` AS `t2`,`realmcard`.`ClassId` AS `ClassId` from (`realmcard` join `realacard`) where ((`realacard`.`UserName` = `realmcard`.`UserName`) and (cast(`realacard`.`punchDate` as date) = cast(`realmcard`.`punchDate` as date)));

-- ----------------------------
--  View structure for `latemorning`
-- ----------------------------
DROP VIEW IF EXISTS `latemorning`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `latemorning` AS select `realmcard`.`punchId` AS `punchId`,`realmcard`.`UserName` AS `UserName`,`realmcard`.`punchDate` AS `t1`,`realacard`.`punchDate` AS `t2`,`realmcard`.`ClassId` AS `ClassId` from (`realmcard` join `realacard`) where ((cast(`realmcard`.`punchDate` as time(6)) > (select `classes`.`Mtime` from `classes` where (`realmcard`.`ClassId` = `classes`.`ClassId`))) and (cast(`realmcard`.`punchDate` as date) = cast(`realacard`.`punchDate` as date)) and (`realmcard`.`UserName` = `realacard`.`UserName`));

-- ----------------------------
--  View structure for `pay`
-- ----------------------------
DROP VIEW IF EXISTS `pay`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pay` AS select `realsalary`.`ClassId` AS `ClassId`,`realsalary`.`EmpName` AS `EmpName`,sum((case `realsalary`.`attendStatus` when '正常' then 100 when '旷工' then -(100) when '迟到' then -(20) else (`realsalary`.`LeaveTime` * -(20)) end)) AS `Salary`,min(`realall`.`EarlyTime`) AS `BeginTime`,max(`realall`.`LatTime`) AS `EndTime` from (`realsalary` join `realall`) where (`realall`.`UserName` = `realsalary`.`EmpName`) group by `realsalary`.`EmpName`;