/*
 Navicat Premium Data Transfer

 Source Server         : 175.24.199.48 mysql8
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : 175.24.199.48:3307
 Source Schema         : shoom_order

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 06/05/2023 09:29:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NULL DEFAULT NULL,
  `product_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `count` int NULL DEFAULT NULL,
  `product_price` decimal(10, 0) NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `order_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `confirm_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (1, 120, '凍七啡 Special Iced Coffee Soda', 1, 5, '2023-05-04 02:05:49', '1', 2, NULL);
INSERT INTO `order_detail` VALUES (2, 51, '紅燒乳鴿 Deep Fried Crispy Squab', 1, 27, '2023-05-04 02:07:02', '2', 0, NULL);
INSERT INTO `order_detail` VALUES (3, 52, '涼拌海蜇 Chilled Jelly Fish', 1, 19, '2023-05-04 02:07:02', '2', 1, NULL);
INSERT INTO `order_detail` VALUES (4, 53, '椒鹽雞膝 (小 snack) Fried Chicken Joints w/Chili Pepper Salt', 1, 17, '2023-05-04 02:07:02', '2', 1, NULL);
INSERT INTO `order_detail` VALUES (5, 54, '椒鹽豆腐 ( 小 snack) Deep Fried Tofu with Chili Pepper Salt', 1, 15, '2023-05-04 02:07:02', '2', 0, NULL);
INSERT INTO `order_detail` VALUES (6, 41, '金沙虾球脆脆 Salted Golden Egg Yolk Prawns and Flakes', 1, 33, '2023-05-04 02:30:19', '3', 0, NULL);
INSERT INTO `order_detail` VALUES (7, 42, '金沙蝦球 Salted Egg Yolk Prawn', 1, 33, '2023-05-04 02:30:19', '3', 0, NULL);
INSERT INTO `order_detail` VALUES (8, 11, 'H01 熱咖啡 Hot HK Style Coffee', 1, 4, '2023-05-04 02:31:16', '4', 0, NULL);
INSERT INTO `order_detail` VALUES (9, 12, 'H03 熱檸茶 Hot HK Style Lemon Tea', 2, 4, '2023-05-04 02:31:16', '4', 1, NULL);
INSERT INTO `order_detail` VALUES (10, 11, 'H01 熱咖啡 Hot HK Style Coffee', 1, 4, '2023-05-04 02:35:35', '5', 1, NULL);
INSERT INTO `order_detail` VALUES (11, 51, '紅燒乳鴿 Deep Fried Crispy Squab', 1, 27, '2023-05-04 02:37:13', '6', 1, NULL);
INSERT INTO `order_detail` VALUES (12, 117, 'I08 凍朱古力 Iced Chocolate', 1, 5, '2023-05-05 06:56:41', '7', 0, NULL);
INSERT INTO `order_detail` VALUES (13, 118, 'I09 凍檸蜜 Iced Honey Lemon Water', 1, 5, '2023-05-05 06:56:41', '7', 0, NULL);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `table_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `waiter_id` int NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `finish_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_finished` tinyint NULL DEFAULT NULL,
  `confirm_time` timestamp NULL DEFAULT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '66', 8, '2023-05-04 02:05:49', '2023-05-04 02:06:36', 1, NULL, 4.95);
INSERT INTO `orders` VALUES (2, '14', 8, '2023-05-04 02:07:02', '2023-05-04 02:07:02', 0, NULL, 77.80);
INSERT INTO `orders` VALUES (3, '55', 8, '2023-05-04 02:30:19', '2023-05-04 02:30:19', 0, NULL, 65.90);
INSERT INTO `orders` VALUES (4, '8', 8, '2023-05-04 02:31:16', '2023-05-04 02:31:16', 0, NULL, 11.85);
INSERT INTO `orders` VALUES (5, '77', 8, '2023-05-04 02:35:35', '2023-05-04 02:35:35', 0, NULL, 3.95);
INSERT INTO `orders` VALUES (6, '9', 8, '2023-05-04 02:37:13', '2023-05-04 02:37:13', 0, NULL, 26.95);
INSERT INTO `orders` VALUES (7, '11', 8, '2023-05-05 06:56:41', '2023-05-05 06:56:41', 0, NULL, 9.90);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_price` decimal(10, 0) NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `image_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for table_info
-- ----------------------------
DROP TABLE IF EXISTS `table_info`;
CREATE TABLE `table_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `available` tinyint NULL DEFAULT NULL,
  `desk_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table_info
-- ----------------------------
INSERT INTO `table_info` VALUES (1, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
