/*
Navicat MySQL Data Transfer

Source Server         : 2
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : goods

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-05-28 12:56:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `ID` int(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Count` int(10) NOT NULL,
  `Price` double(10,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('3', '方便面', '4500', '5.00');
INSERT INTO `goods` VALUES ('12', '矿泉水', '2000', '3.00');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Role` varchar(10) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('a', 'a', '0');
INSERT INTO `login` VALUES ('admin', 'admin', '0');
