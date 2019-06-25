/*
 Navicat Premium Data Transfer

 Source Server         : MySQL Server
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : semester5-frontend-framework

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 21/06/2019 18:26:08
*/

CREATE DATABASE `semester5-frontend-framework`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_box
-- ----------------------------
DROP TABLE IF EXISTS `chat_box`;
CREATE TABLE `chat_box` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `last_message_id` bigint(20) DEFAULT NULL,
  `last_message_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_box
-- ----------------------------
BEGIN;
INSERT INTO `chat_box` VALUES (1, 171, '2019-05-07 16:28:51');
INSERT INTO `chat_box` VALUES (2, 6, '2019-04-02 19:25:21');
INSERT INTO `chat_box` VALUES (4, 8, '2019-04-04 20:25:21');
COMMIT;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `chat_box_id` bigint(20) unsigned NOT NULL,
  `read_status` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `FK_MEMBER_USER` (`user_id`),
  KEY `FK_MEMBER_CHATBOX` (`chat_box_id`),
  CONSTRAINT `FK_MEMBER_CHATBOX` FOREIGN KEY (`chat_box_id`) REFERENCES `chat_box` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_MEMBER_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
BEGIN;
INSERT INTO `member` VALUES (1, 6, 1, b'1');
INSERT INTO `member` VALUES (2, 3, 1, b'0');
INSERT INTO `member` VALUES (3, 6, 2, b'1');
INSERT INTO `member` VALUES (4, 7, 2, b'0');
INSERT INTO `member` VALUES (5, 6, 4, b'1');
INSERT INTO `member` VALUES (6, 1, 4, b'0');
COMMIT;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `content` varchar(2000) NOT NULL,
  `date` datetime NOT NULL,
  `type` enum('TEXT','IMAGE','VIDEO','FILE','ICON','STICKER') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `member_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_MESSAGE_MEMBER` (`member_id`),
  CONSTRAINT `FK_MESSAGE_MEMBER` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
BEGIN;
INSERT INTO `message` VALUES (1, 'Aloooo. Có đó không?', '2019-03-29 19:25:21', 'TEXT', 1);
INSERT INTO `message` VALUES (2, 'Không', '2019-03-29 19:27:21', 'TEXT', 2);
INSERT INTO `message` VALUES (3, 'Em ăn cơm chưa', '2019-04-01 19:25:21', 'TEXT', 3);
INSERT INTO `message` VALUES (6, 'Em uống nước rồi', '2019-04-02 19:25:21', 'TEXT', 4);
INSERT INTO `message` VALUES (7, 'Đi nhậu không anh?', '2019-04-03 19:25:21', 'TEXT', 5);
INSERT INTO `message` VALUES (8, 'Deadline ngập mặt nhậu gì em ơi', '2019-04-04 20:25:21', 'TEXT', 6);
INSERT INTO `message` VALUES (171, 'Không vậy thôi', '2019-05-07 16:28:51', 'TEXT', 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `photo_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `provider` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `provider_id` varchar(50) NOT NULL,
  `token` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ_PROVIDER_PROVIDERID` (`provider`,`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'truongtunglam@gmail.com', 'Trương Tùng Lâm', 'https://scontent.fsgn5-4.fna.fbcdn.net/v/t1.0-1/p100x100/42404865_1873120216058036_8859179623565492224_n.jpg?_nc_cat=104&_nc_ht=scontent.fsgn5-4.fna&oh=c1c1390150ac384731be1f2b9834cad7&oe=5D4E6FEC', 'FACEBOOK', '100000802288789', 'EAAEZCKoQwFLcBAKPruyVgvLAtNdIrbIZAQsx5d97kQvbFkYmH0hUtmKTP6c1VRAS5tYdqrUUYPhIA5Sh9JCOOOFiUyvTWwCLsdt319t0YMEYjSgbsf4ITJWTcqu3353WRKavvkwWzZCJe9ZBZAGNSNzUZB9LoCe30uBZAAnFZA495imIwtzz1f0bF2HomZCLoZBGHioZBDlRNdQ6YYWHtefuR6y');
INSERT INTO `user` VALUES (3, 'mytien@gmail.com', 'Võ Thanh Mỹ Tiên', 'https://scontent.fsgn5-4.fna.fbcdn.net/v/t1.0-1/c0.0.100.100a/p100x100/56681367_2194102287520252_7641178326358294528_n.jpg?_nc_cat=104&_nc_ht=scontent.fsgn5-4.fna&oh=06ca9f28805eb87edf745de467ac0dfb&oe=5D435C56', 'FACEBOOK', '100007615053028', 'EAAEZCKoQwFLcBAKPruyVgvLAtNdIrbIZAQsx5d97kQvbFkYmH0hUtmKTP6c1VRAS5tYdqrUUYPhIA5Sh9JCOOOFiUyvTWwCLsdt319t0YMEYjSgbsf4ITJWTcqu3353WRKavvkwWzZCJe9ZBZAGNSNzUZB9LoCe30uBZAAnFZA495imIwtzz1f0bF2HomZCLoZBGHioZBDlRNdQ6YYWHtefuR63');
INSERT INTO `user` VALUES (6, 'thanhtai17071997@gmail.com', 'Võ Thành Tài', 'https://graph.facebook.com/982392238618347/picture?type=normal', 'FACEBOOK', '982392238618347', 'EAAEZCKoQwFLcBAOK1VvuZA7sdbSZCgHnPh9r4c5OiagfdohS61rR1hY4fZBtKUr2HeZChIZBopbysPsdUsEsYc5pcuRrZC0u7xgV5Lqiatg6qNvRXkBztse2lCahb4njhAHJdNpRKiZAzrYCbVqeMgKp5HSjMFa6cPsXdM8pjwBhcQLmA0aqbdtu5qae4lPws1k3tUOpby2KWJol466gAJDZA');
INSERT INTO `user` VALUES (7, 'haimy@gmail.com', 'Trần Hải My', 'https://scontent.fsgn5-7.fna.fbcdn.net/v/t1.0-1/p100x100/51585750_800173830329890_2939834964411154432_n.jpg?_nc_cat=103&_nc_ht=scontent.fsgn5-7.fna&oh=e9508c84f440971e678c1d735cb055f6&oe=5D3ED5B3', 'FACEBOOK', '9129312319231823', 'EAAEZCKoQwFLcBAKPruyVgvLAtNdIrbIZAQsx5d97kQvbFkYmH0hUtmKTP6c1VRAS5tYdqrUUYPhIA5Sh9JCOOOFiUyvTWwCLsdt319t0YMEYjSgbsf4ITJWTcqu3353WRKavvkwWzZCJe9ZBZAGNSNzUZB9LoCe30uBZAAnFZA495imIwtzz1f0bF2HomZCLoZBGHioZBDlRNdQ6YYWHtefuR19');
INSERT INTO `user` VALUES (8, 'thuongnguyen@gmail.com', 'Thươngg Nguyễn', 'https://scontent.fsgn5-6.fna.fbcdn.net/v/t1.0-1/p100x100/52783863_1208958329270642_1174207577274187776_n.jpg?_nc_cat=109&_nc_ht=scontent.fsgn5-6.fna&oh=c07da52c9a140e1f62a69d7088558400&oe=5D36DB81', 'FACEBOOK', '100004694593137', 'EAAEZCKoQwFLcBAKPruyVgvLAtNdIrbIZAQsx5d97kQvbFkYmH0hUtmKTP6c1VRAS5tYdqrUUYPhIA5Sh9JCOOOFiUyvTWwCLsdt319t0YMEYjSgbsf4ITJWTcqu3353WRKavvkwWzZCJe9ZBZAGNSNzUZB9LoCe30uBZAAnFZA495imIwtzz1f0bF2HomZCLoZBGHioZBDlRNdQ6YYWHtefuR90');
INSERT INTO `user` VALUES (13, 'mzepxknsfc_1555509460@tfbnw.net', 'Jackson Wisemanberg', 'https://graph.facebook.com/106996967169820/picture?type=normal', 'FACEBOOK', '106996967169820', 'EAAEZCKoQwFLcBAGMuDzYnM3ELqsC0b23zZCRURsnpgsto1xJVbHi2rYQwtAFwobWOZByva9fQwvs6QqHxeJ5RIrjPMMkUh7KWryAJ2zZCfTyOo9BHTixOJXWdrXEJsCUm1JaRv8e27Gi724EGZBFWxxb2kjTbuvTHlsDEqdBOZBGYlI1hLit1ZAFBFc7143PJNqvtGnfhMtt6fdChnd6Mg5');
INSERT INTO `user` VALUES (14, 'pgxucdtxxw_1555516189@tfbnw.net', 'Linda Occhinoman', 'https://graph.facebook.com/106029907266432/picture?type=normal', 'FACEBOOK', '106029907266432', 'EAAEZCKoQwFLcBAG1BD5kKXgOvyfbdb1ZASB7S3VwJn3KqHZAoiG6EF2j063wbIwXjfDAlugCSH5MDTptdNSUa0MKIeFgKifZBcbzuDCWRzlAjP6vQIEdpMnbrH8MNMUdPPmZBAKxFzJWlOaqEmZAZBWwWe0sw0vHmL2PviLHYDqmZA21N2vBFVxBKfrZBBLewM7YJtIseCdtUGH3h5ciUz5AgDqfee6rtYroZD');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
