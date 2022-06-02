/*
Navicat MySQL Data Transfer

Source Server         : web
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2022-06-01 09:34:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `good_id` varchar(255) NOT NULL,
  `good_name` varchar(255) NOT NULL,
  `nums` varchar(255) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `supplier_id` varchar(255) NOT NULL,
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`good_id`),
  KEY `goods_ibfk_1` (`supplier_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `shop` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `good_id` varchar(255) NOT NULL,
  `order_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `total_price` decimal(10,0) NOT NULL,
  `good_nums` int NOT NULL,
  KEY `order_ibfk_2` (`user_id`),
  KEY `order_ibfk_3` (`good_id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`good_id`) REFERENCES `goods` (`good_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `user_id` varchar(255) NOT NULL,
  `supplier_id` varchar(255) NOT NULL,
  `supplier_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category` varchar(255) NOT NULL,
  PRIMARY KEY (`supplier_id`,`user_id`) USING BTREE,
  KEY `supplier_id` (`supplier_id`),
  KEY `shop_ibfk_1` (`user_id`),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `user_id` varchar(255) NOT NULL,
  `good_id` varchar(255) NOT NULL,
  `nums` int NOT NULL,
  PRIMARY KEY (`user_id`,`good_id`),
  KEY `shoppingcart_ibfk_1` (`good_id`),
  CONSTRAINT `shoppingcart_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `goods` (`good_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userfavorite
-- ----------------------------
DROP TABLE IF EXISTS `userfavorite`;
CREATE TABLE `userfavorite` (
  `user_id` varchar(255) NOT NULL,
  `good_id` varchar(255) NOT NULL,
  KEY `userfavorite_ibfk_3` (`user_id`),
  KEY `userfavorite_ibfk_4` (`good_id`),
  CONSTRAINT `userfavorite_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userfavorite_ibfk_4` FOREIGN KEY (`good_id`) REFERENCES `goods` (`good_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_id` varchar(255) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`username`) USING BTREE,
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
