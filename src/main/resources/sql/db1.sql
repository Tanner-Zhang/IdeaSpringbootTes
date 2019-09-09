/*
Navicat MySQL Data Transfer

Source Server         : cy
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-08-07 12:40:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `children`
-- ----------------------------
DROP TABLE IF EXISTS `children`;
CREATE TABLE `children` (
  `children_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `IsCurrent` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`children_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of children
-- ----------------------------
INSERT INTO `children` VALUES ('1', '角色管理', 'http://www.eq2iqm.com', '1');
INSERT INTO `children` VALUES ('2', '职位管理', 'http://www.qq.com', '1');
INSERT INTO `children` VALUES ('3', '部门管理', 'http://www.baidu.com', '1');
INSERT INTO `children` VALUES ('4', '修改账号', 'http://www.shareniu.com/flowable6.5_zh_document/bpm/index.html', '1');
INSERT INTO `children` VALUES ('5', '修改密码', 'http://www.uimaker.com/uimakerdown/bstemplate/125073.html', '1');
INSERT INTO `children` VALUES ('6', '资料查看', 'https://springcloud.cc/spring-cloud-dalston.html#_features', '1');
INSERT INTO `children` VALUES ('7', '添加菜单', 'http://www.qq.com', '1');
INSERT INTO `children` VALUES ('8', '删除菜单', 'http://www.qq.com', '1');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `isCurrent` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '用户管理', '&#xe63f', '1');
INSERT INTO `menu` VALUES ('2', '安全管理', '&#xe63f', '1');
INSERT INTO `menu` VALUES ('3', '资料管理', '&#xe63f', '1');
INSERT INTO `menu` VALUES ('4', '菜单管理', '&#xe63f', '1');

-- ----------------------------
-- Table structure for `mid_cid`
-- ----------------------------
DROP TABLE IF EXISTS `mid_cid`;
CREATE TABLE `mid_cid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of mid_cid
-- ----------------------------
INSERT INTO `mid_cid` VALUES ('1', '1', '1');
INSERT INTO `mid_cid` VALUES ('2', '1', '2');
INSERT INTO `mid_cid` VALUES ('3', '1', '3');
INSERT INTO `mid_cid` VALUES ('4', '2', '4');
INSERT INTO `mid_cid` VALUES ('5', '2', '5');
INSERT INTO `mid_cid` VALUES ('6', '3', '6');
INSERT INTO `mid_cid` VALUES ('7', '4', '7');
INSERT INTO `mid_cid` VALUES ('8', '4', '8');

-- ----------------------------
-- Table structure for `sid_mid`
-- ----------------------------
DROP TABLE IF EXISTS `sid_mid`;
CREATE TABLE `sid_mid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of sid_mid
-- ----------------------------
INSERT INTO `sid_mid` VALUES ('1', '1', '1');
INSERT INTO `sid_mid` VALUES ('2', '1', '2');
INSERT INTO `sid_mid` VALUES ('3', '1', '3');
INSERT INTO `sid_mid` VALUES ('4', '2', '4');

-- ----------------------------
-- Table structure for `systemmenu`
-- ----------------------------
DROP TABLE IF EXISTS `systemmenu`;
CREATE TABLE `systemmenu` (
  `systemMenu_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `isCurrent` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`systemMenu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of systemmenu
-- ----------------------------
INSERT INTO `systemmenu` VALUES ('1', '系统管理', '&#xe63f', '1');
INSERT INTO `systemmenu` VALUES ('2', '界面管理', '&#xe63f', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(111) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'aa', '1');
