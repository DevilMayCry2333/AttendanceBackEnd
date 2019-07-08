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

 Date: 07/05/2019 20:12:57 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=456 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `attend`
-- ----------------------------
BEGIN;
INSERT INTO `attend` VALUES ('454', '2019-06-26 07:00:00', '2019-06-26 17:22:00', '游开钰', '214', '正常'), ('455', '2019-06-26 07:00:00', '2019-06-26 17:22:00', '游开钰', '214', '迟到');
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `classes`
-- ----------------------------
BEGIN;
INSERT INTO `classes` VALUES ('19', '22', '销售', '07:00:00.000000', '17:00:00.000000', '修改测试'), ('23', '214', '开发', '00:00:00.000000', '00:00:00.000000', null), ('25', '666', '管理', '09:00:00.000000', '15:00:00.000000', null), ('28', '444', 'JUnitTest2', '10:07:00.000000', '21:00:00.000000', null), ('30', '666', 'JUnitUpdate', '19:00:00.000000', '08:00:00.000000', 'None'), ('31', '444', 'JUnitTest2', '10:07:00.000000', '21:00:00.000000', null);
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `department`
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES ('7', '444', '测试修改', '游', 'CEO', '无'), ('11', '11', '测试', '游开钰', '开发', 'CEO'), ('12', '266', 'JUnitDepTest', 'CEO', '管理', 'ROOT'), ('13', '266', 'JUnitDepTest', 'CEO', '管理', 'ROOT'), ('17', '666', 'JUnitUpdateTest', 'ROOT', '直接负责人', 'ROOT'), ('21', '266', 'JUnitDepTest', 'CEO', '管理', 'ROOT');
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
  KEY `ClassId` (`ClassId`),
  CONSTRAINT `ClassId` FOREIGN KEY (`ClassId`) REFERENCES `classes` (`ClassId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `employ`
-- ----------------------------
BEGIN;
INSERT INTO `employ` VALUES ('1', '1', '游开钰', '中国', '35XX', '1000', '137', '137', 'CEO', '22', '18', '男', '214'), ('11', '2', '家香', '3', '3', '3', '3', '3', '214', '3', '3', '男', '214'), ('12', '2', '林善凯', '66', '66', '66', '66', '66', '214', '22', '66', '男', '214'), ('15', '6677', '测试1', '1', '1', '1', '1', '1', '214', '22', '66', '男', '214'), ('16', '2', '吴', '汉', '3501', '1000', '66', '66', '214', '测试', '19', '女', '214'), ('17', '11', '测试2', '66', '66', '66', '66', '66', '214', '66', '66', '男', '214'), ('18', '测试6', '11', '22', '33', '44', '55', '22', '214', '66', '22', '男', '214'), ('19', '2', '肖腾跃', '汉', '350122', '10000', '137', '137', '214', '男', '19', '男', '214'), ('20', '3', '林煊鸿', '汉', '350122', '10000', '137', '137', '214', '男', '20', '男', '214'), ('21', '4', 'CEO', '汉', '350122', '1000000', '100000', '10000', '214', '10000', '20', '男', '214'), ('22', '222', 'CFO', '汉', '350122', '1000', '1000', '1000', '214', '男', '12', '男', '214'), ('23', '测试', '22', '44', '350122', '111', '2223', '333', '22', '444', '112', '男', '214'), ('24', '2222', 'Update', '中国', '350122', '10000', '137', '137', '测试', '描述', '13', '男', '214'), ('28', '66666', 'Update', '中国', '350122', '10000', '137', '137', '测试', '描述', '13', '男', '214'), ('29', '2222', 'Update', '中国', '350122', '10000', '137', '137', '测试', '描述', '13', '男', '214');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `myleave`
-- ----------------------------
BEGIN;
INSERT INTO `myleave` VALUES ('22', '33', '2019-07-04 11:11:00.000000', '2019-07-04 11:11:00.000000', '12', '5'), ('6', '测试请假', '2019-07-04 11:00:00.000000', '2019-07-04 11:00:00.000000', '123', '6'), ('22', 'Joker', '2019-07-05 08:00:00.000000', '2019-07-05 12:00:00.000000', '回家', '7');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `punch`
-- ----------------------------
BEGIN;
INSERT INTO `punch` VALUES ('1', '214', '游开钰', '2019-06-26 07:00:00.000000', '22', '1'), ('2', '214', '游开钰', '2019-06-26 17:22:00.000000', '213', '9'), ('5', '214', '吴', '2019-06-26 07:00:00.000000', '213', '12'), ('6', '214', '家香', '2019-06-26 20:22:00.000000', '', '13'), ('56', '214', '林善凯', '2019-06-26 16:00:00.000000', '22', '14');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `station`
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `JobId` varchar(10) DEFAULT NULL,
  `Pname` varchar(15) DEFAULT NULL,
  `Adepartment` varchar(10) DEFAULT NULL,
  `Isuperior` varchar(10) DEFAULT NULL,
  `Jcategory` enum('管理类','我就是董事长','技术类') DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `station`
-- ----------------------------
BEGIN;
INSERT INTO `station` VALUES ('9', '9', '测试', '0', '0', '');
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





SET FOREIGN_KEY_CHECKS = 1;
