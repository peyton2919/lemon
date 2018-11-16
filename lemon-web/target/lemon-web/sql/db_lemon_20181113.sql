/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : db_lemon

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 13/11/2018 16:59:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_acl
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl`;
CREATE TABLE `sys_acl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限名称',
  `acl_module_id` int(11) NOT NULL DEFAULT 0 COMMENT '权限所在的权限模块id',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求的url, 可以填正则表达式',
  `type` int(11) NOT NULL DEFAULT 3 COMMENT '类型，1：菜单，2：按钮，3：其他',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态，1：正常，0：冻结',
  `seq` int(11) NOT NULL DEFAULT 0 COMMENT '权限在当前模块下的顺序，由小到大',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '备注',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `operate_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一个更新者的ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_acl
-- ----------------------------
INSERT INTO `sys_acl` VALUES (1, '20171015095130_26', '进入产品管理界面', 1, '/sys/product/product.page', 1, 1, 1, '', 'Admin', '2017-10-15 09:51:30', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (2, '20171015095322_14', '查询产品列表', 1, '/sys/product/page.json', 2, 1, 2, '', 'Admin', '2017-10-15 09:53:22', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (3, '20171015095350_69', '产品上架', 1, '/sys/product/online.json', 2, 1, 3, '', 'Admin', '2017-10-15 09:53:51', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (4, '20171015095420_7', '产品下架', 1, '/sys/product/offline.json', 2, 1, 4, '', 'Admin', '2017-10-15 10:11:28', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (5, '20171015212626_63', '进入订单页', 2, '/sys/order/order.page', 1, 1, 1, '', 'Admin', '2017-10-15 21:26:27', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (6, '20171015212657_12', '查询订单列表', 2, '/sys/order/list.json', 2, 1, 2, '', 'Admin', '2017-10-15 21:26:57', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (7, '20171015212907_36', '进入权限管理页', 7, '/sys/aclModule/acl.page', 1, 1, 1, '', 'Admin', '2017-10-15 21:29:07', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (8, '20171015212938_27', '进入角色管理页', 8, '/sys/role/role.page', 1, 1, 1, '', 'Admin', '2017-10-16 17:49:38', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (9, '20171015213009_0', '进入用户管理页', 9, '/sys/dept/dept.page', 1, 1, 1, '', 'Admin', '2017-10-15 21:30:09', '127.0.0.1');
INSERT INTO `sys_acl` VALUES (10, '20171016230429_8', '进入权限更新记录页面', 11, '/sys/log/log.page', 1, 1, 1, '', 'Admin', '2017-10-16 23:04:49', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_acl_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl_module`;
CREATE TABLE `sys_acl_module`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限模块编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限模块名称',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '上级权限模块id',
  `level` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限模块层级',
  `seq` int(11) NOT NULL DEFAULT 0 COMMENT '权限模块在当前层级下的顺序，由小到大',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态，1：正常，0：冻结',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '备注',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_acl_module
-- ----------------------------
INSERT INTO `sys_acl_module` VALUES (1, '产品管理', 0, '0', 1, 1, 'product', 'Admin', '2017-10-14 21:13:15', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (2, '订单管理', 0, '0', 2, 1, '', 'Admin', '2017-10-14 20:17:11', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (3, '公告管理', 0, '0', 3, 1, '', 'Admin', '2017-10-14 20:17:21', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (4, '出售中产品管理', 1, '0.1', 1, 1, '', 'Admin', '2017-10-14 21:13:39', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (5, '下架产品管理', 1, '0.1', 2, 1, '', 'Admin', '2017-10-14 20:18:02', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (6, '权限管理', 0, '0', 4, 1, '', 'Admin', '2017-10-15 21:27:37', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (7, '权限管理', 6, '0.6', 1, 1, '', 'Admin', '2017-10-15 21:27:57', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (8, '角色管理', 6, '0.6', 2, 1, '', 'Admin', '2017-10-15 21:28:22', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (9, '用户管理', 6, '0.6', 2, 1, '', 'Admin', '2017-10-15 21:28:36', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (10, '运维管理', 0, '0', 6, 1, '', 'Admin', '2017-10-16 23:03:37', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (11, '权限更新记录管理', 6, '0.6', 4, 1, '', 'Admin', '2017-10-16 23:04:07', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (12, '状态管理', 1, '0.1', 3, 1, '', 'admin', '2018-10-31 11:43:42', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES (13, '测试', 1, '0.1', 4, 1, '', 'admin', '2018-10-31 10:33:28', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `status` int(4) DEFAULT 1 COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
  `created` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `admin_encrypt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '加密串',
  `last_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '最后登录IP',
  `admin_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, 'admin', '25D55AD283AA400AF464C76D713C07AD', 1, '2018-08-22 09:12:03', '2018-08-22 09:12:03', 'adminencrypt', '127.0.0.1', NULL);

-- ----------------------------
-- Table structure for sys_category_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_category_info`;
CREATE TABLE `sys_category_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父编号',
  `cate_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `cate_url` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `cate_before_style` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '前样式',
  `cate_after_style` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '后样式',
  `cate_seq` int(11) DEFAULT NULL COMMENT '排序 从小到大排序',
  `cate_status` int(4) NOT NULL DEFAULT 1 COMMENT '状态 0 不可用 1 可用 2 删除 默认 1',
  `cate_type` int(4) DEFAULT NULL COMMENT '类目类型 0 顾客 1 供应商 2 员工 3 管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_category_info
-- ----------------------------
INSERT INTO `sys_category_info` VALUES (1, 0, '基础设置', '#', 'menu-icon fa fa-wrench', 'arrow fa fa-angle-down', 1, 1, 3);
INSERT INTO `sys_category_info` VALUES (2, 0, '权限管理', '#', 'menu-icon fa fa-user', 'arrow fa fa-angle-down', 2, 1, 3);
INSERT INTO `sys_category_info` VALUES (3, 0, '日志管理', '#', 'menu-icon fa fa-file-text-o', 'arrow fa fa-angle-down', 3, 1, 3);
INSERT INTO `sys_category_info` VALUES (4, 0, '系统管理', '#', 'menu-icon fa fa-cogs', 'arrow fa fa-angle-down', 4, 1, 3);
INSERT INTO `sys_category_info` VALUES (5, 1, '货运类型', '/sys/ft/freighttype.page', 'menu-icon fa fa-caret-right', '', 1, 1, 3);
INSERT INTO `sys_category_info` VALUES (6, 1, '仓库管理', '/sys/wh/warehouse.page', 'menu-icon fa fa-caret-right', '', 2, 1, 3);
INSERT INTO `sys_category_info` VALUES (7, 1, '运输管理', '/sys/sp/shipping.page', 'menu-icon fa fa-caret-right', '', 3, 1, 3);
INSERT INTO `sys_category_info` VALUES (8, 2, '用户管理', '/sys/dept/dept.page', 'menu-icon fa fa-caret-right', '', 1, 1, 3);
INSERT INTO `sys_category_info` VALUES (9, 2, '角色管理', '/sys/role/role.page', 'menu-icon fa fa-caret-right', '', 2, 1, 3);
INSERT INTO `sys_category_info` VALUES (10, 2, '权限管理', '/sys/aclModule/acl.page', 'menu-icon fa fa-caret-right', '', 3, 1, 3);
INSERT INTO `sys_category_info` VALUES (11, 3, '权限日志', '/', 'menu-icon fa fa-caret-right', '', 1, 1, 3);
INSERT INTO `sys_category_info` VALUES (12, 3, '异常日志', '/', 'menu-icon fa fa-caret-right', NULL, 2, 1, 3);
INSERT INTO `sys_category_info` VALUES (13, 3, '员工日志', '/', 'menu-icon fa fa-caret-right', NULL, 3, 1, 3);
INSERT INTO `sys_category_info` VALUES (14, 3, '顾客日志', '/', 'menu-icon fa fa-caret-right', NULL, 4, 1, 3);
INSERT INTO `sys_category_info` VALUES (15, 3, '供应商日志', '/', 'menu-icon fa fa-caret-right', '', 5, 1, 3);
INSERT INTO `sys_category_info` VALUES (16, 3, '登录日志', '/', 'menu-icon fa fa-caret-right', NULL, 6, 1, 3);
INSERT INTO `sys_category_info` VALUES (17, 4, '全局配置管理', '/sys/wc/index.page', 'menu-icon fa fa-caret-right', NULL, 1, 1, 3);
INSERT INTO `sys_category_info` VALUES (18, 4, '栏目设置', '/sys/cate/index.page', 'menu-icon fa fa-caret-right', NULL, 2, 1, 3);
INSERT INTO `sys_category_info` VALUES (19, 4, '栏目设置', '/', 'menu-icon fa fa-caret-right', '', 2, 0, 2);
INSERT INTO `sys_category_info` VALUES (20, 0, '测试', '', 'menu-icon fa fa-caret-right', '', 5, 0, 2);
INSERT INTO `sys_category_info` VALUES (21, 0, '商品管理', '#', 'menu-icon glyphicon glyphicon-th-list', 'arrow fa fa-angle-down', 1, 1, 2);
INSERT INTO `sys_category_info` VALUES (22, 21, '颜色管理', '/sys/color/color.page', 'menu-icon fa fa-caret-right', '', 10, 1, 2);
INSERT INTO `sys_category_info` VALUES (23, 21, '产地管理', '/sys/origin/origin.page', 'menu-icon fa fa-caret-right', '', 9, 1, 2);
INSERT INTO `sys_category_info` VALUES (24, 21, '品牌管理', '/sys/brand/brand.page', 'menu-icon fa fa-caret-right', '', 8, 1, 2);
INSERT INTO `sys_category_info` VALUES (25, 21, '商品分类管理', '/sys/coso/commoditysort.page', 'menu-icon fa fa-caret-right', '', 2, 1, 2);
INSERT INTO `sys_category_info` VALUES (26, 21, '商品类目管理', '/sys/coca/commoditycategory.page', 'menu-icon fa fa-caret-right', NULL, 1, 1, 2);
INSERT INTO `sys_category_info` VALUES (27, 0, '图片管理', '#', 'menu-icon  glyphicon  glyphicon-picture ', 'arrow fa fa-angle-down', 1, 1, 2);
INSERT INTO `sys_category_info` VALUES (28, 27, '图片管理', '/', '	menu-icon fa fa-caret-right', '', 1, 1, 2);
INSERT INTO `sys_category_info` VALUES (29, 27, '图片分类管理', '/', '	menu-icon fa fa-caret-right', '', 2, 1, 2);
INSERT INTO `sys_category_info` VALUES (30, 0, '供应商管理', '#', 'menu-icon glyphicon glyphicon-user', 'arrow fa fa-angle-down', 3, 1, 2);
INSERT INTO `sys_category_info` VALUES (31, 30, '供应商管理', '/sys/sup/sys-sup.page', 'menu-icon fa fa-caret-right', '', 1, 1, 2);
INSERT INTO `sys_category_info` VALUES (32, 21, '商品管理', '/sys/comm/commodity.page', 'menu-icon fa fa-caret-right', '', 0, 1, 2);
INSERT INTO `sys_category_info` VALUES (33, 21, '出入库管理', '/sys/stor/storage.page', 'menu-icon fa fa-caret-right', '', 0, 1, 2);
INSERT INTO `sys_category_info` VALUES (34, 21, '主库存管理', '/sys/inve/inventory.page', 'menu-icon fa fa-caret-right', '', 0, 1, 2);
INSERT INTO `sys_category_info` VALUES (35, 0, '会员管理', '#', 'menu-icon fa fa-user', 'arrow fa fa-angle-down', 2, 1, 2);
INSERT INTO `sys_category_info` VALUES (36, 35, '地区管理', '/sys/regi/region.page', 'menu-icon fa fa-caret-right', '', 1, 1, 2);
INSERT INTO `sys_category_info` VALUES (37, 35, '客户等级管理', '/sys/cugr/customergrade.page', 'menu-icon fa fa-caret-right', '', 1, 1, 2);
INSERT INTO `sys_category_info` VALUES (38, 35, '付款方式管理', '/sys/pamo/paymentmode.page', 'menu-icon fa fa-caret-right', '', 2, 1, 2);
INSERT INTO `sys_category_info` VALUES (39, 35, '会员管理', '/sys/cus/sys-cus.page', 'menu-icon fa fa-caret-right', '', 0, 1, 2);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '上级部门id',
  `level` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门层级',
  `seq` int(11) NOT NULL DEFAULT 0 COMMENT '部门在当前层级下的顺序，由小到大',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '备注',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '技术部', 0, '0', 1, '技术部', 'admin', '2018-08-28 14:46:59', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_dept` VALUES (2, '后端开发', 1, '0.1', 1, '后端', 'system-update', '2017-10-12 07:56:16', '127.0.0.1');
INSERT INTO `sys_dept` VALUES (3, '前端开发', 1, '0.1', 2, '', 'system-update', '2017-10-14 11:29:45', '127.0.0.1');
INSERT INTO `sys_dept` VALUES (4, 'UI设计', 1, '0.1', 3, '', 'system', '2017-10-12 07:55:43', '127.0.0.1');
INSERT INTO `sys_dept` VALUES (5, '产品部', 0, '0', 2, '', 'Admin', '2017-10-16 22:52:29', '127.0.0.1');
INSERT INTO `sys_dept` VALUES (6, '客服部', 0, '0', 4, '', 'admin', '2018-08-28 12:45:50', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_dept` VALUES (7, 'Jsp', 1, '0.1', 4, '', 'admin', '2018-10-31 09:34:15', '127.0.0.1');
INSERT INTO `sys_dept` VALUES (8, 'JQuery', 5, '0.5', 1, '', 'admin', '2018-10-31 15:57:56', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_employee
-- ----------------------------
DROP TABLE IF EXISTS `sys_employee`;
CREATE TABLE `sys_employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `emp_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `emp_login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名',
  `emp_pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `emp_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `emp_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `emp_add` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `emp_qq` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'qq',
  `emp_fax` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '传真',
  `emp_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `emp_birth` datetime(0) DEFAULT NULL COMMENT '出生日期 格式: yyyy/MM/dd',
  `emp_identity` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证',
  `emp_loc` int(11) DEFAULT 0 COMMENT '登录次数',
  `emp_status` int(4) DEFAULT 1 COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
  `dept_id` int(11) NOT NULL COMMENT '部门编号——部门表',
  `post_id` int(11) DEFAULT NULL COMMENT '职务编号',
  `emp_created` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `emp_updated` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `emp_encrypt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '加密串',
  `emp_last_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '最后登录IP',
  `emp_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_employee
-- ----------------------------
INSERT INTO `sys_employee` VALUES (1, 'Judy', 'Judy', 'E3EB552B2384D6285A74C49195D5BE5C', '059183261633,059183262919', '13500001234,18612345678', '福建省福州市台江区六一中路450号', '96067', '059183261234', '96067@qq.com', '1989-02-10 00:00:00', '', 0, 1, 3, 3, '2018-08-22 09:15:16', '2018-09-10 14:14:18', 'yzsFzuFNjv', '0:0:0:0:0:0:0:1', '福建省福州市台江区六一中路450号');
INSERT INTO `sys_employee` VALUES (2, 'tom', 'tom', '846A46518005831F396C8AC194441620', '', '', '', '', '', 'admin@qq.com', NULL, '', 0, 1, 5, 2, '2018-08-23 09:05:19', '2018-08-23 09:05:19', 'UCVpeOVlym', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO `sys_employee` VALUES (3, 'Jimin', 'Jimin', '7BD0A1F1D513C1E18933F168ACF5819F', '010832905678', '13188889999', '', '', '', '', NULL, '', 0, 1, 5, 1, '2018-08-23 15:59:17', '2018-08-23 15:59:17', 'EIciXQVrGB', '0:0:0:0:0:0:0:1', '测试数据');
INSERT INTO `sys_employee` VALUES (4, 'Kate', 'Kate', '3BE25E12949658E0783052425D7D6558', '', '13144445555', '', '', '', 'kate@qq.com', NULL, '', 0, 1, 6, 1, '2018-08-23 16:00:19', '2018-08-23 16:00:19', 'uUFGrzNDcx', '0:0:0:0:0:0:0:1', '');
INSERT INTO `sys_employee` VALUES (5, 'Jimmy', 'Jimmy', 'EDFD0CCC96443326978E8BA15DCC3140', NULL, '13812344311', NULL, NULL, NULL, 'jimmy@qq.com', NULL, NULL, 0, 1, 3, 1, '2018-08-23 16:01:05', '2018-08-23 16:40:16', 'tdAUAWnMvn', '0:0:0:0:0:0:0:1', NULL);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT 0 COMMENT '权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系',
  `target_id` int(11) NOT NULL COMMENT '基于type后指定的对象id，比如用户、权限、角色等表的主键',
  `old_value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '旧值',
  `new_value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '新值',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '当前是否复原过，0：没有，1：复原过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 6, 2, '[]', '[5,6]', 'admin', '2018-08-23 09:21:29', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (2, 6, 1, '[1,3,4,5]', '[1,3,4,5,6]', 'admin', '2018-08-23 15:47:23', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (3, 6, 1, '[1,3,4,5,6]', '[1,3,4,6]', 'admin', '2018-08-23 15:47:48', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (4, 7, 1, '[1]', '[1,2]', 'admin', '2018-08-23 15:49:59', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (5, 8, 5, '{\"id\":5,\"empName\":\"Jimmy\",\"empLoginName\":\"Jimmy\",\"empPwd\":\"EDFD0CCC96443326978E8BA15DCC3140\",\"empPhone\":\"13812344311\",\"empEmail\":\"jimmy@qq.com\",\"empLoc\":0,\"empStatus\":1,\"deptId\":3,\"postId\":1,\"empCreated\":1535011265000,\"empUpdated\":1535011265000,\"empEncrypt\":\"tdAUAWnMvn\",\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"abstractUserName\":\"Jimmy\",\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"primaryKey\":5,\"abstractUserTypeValue\":2}', '{\"id\":5,\"empName\":\"Jimmy\",\"empLoginName\":\"Jimmy\",\"empTel\":\"059412345678\",\"empPhone\":\"13812344311\",\"empQq\":\"225645\",\"empEmail\":\"jimmy@qq.com\",\"empLoc\":0,\"deptId\":3,\"postId\":1,\"empUpdated\":1535012711759,\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"abstractUserName\":\"Jimmy\",\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"primaryKey\":5,\"abstractUserTypeValue\":2}', 'Judy', '2018-08-23 16:25:12', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (6, 8, 5, '{\"id\":5,\"empName\":\"Jimmy\",\"empLoginName\":\"Jimmy\",\"empPwd\":\"EDFD0CCC96443326978E8BA15DCC3140\",\"empTel\":\"059412345678\",\"empPhone\":\"13812344311\",\"empQq\":\"225645\",\"empEmail\":\"jimmy@qq.com\",\"empLoc\":0,\"empStatus\":1,\"deptId\":3,\"postId\":1,\"empCreated\":1535011265000,\"empUpdated\":1535012712000,\"empEncrypt\":\"tdAUAWnMvn\",\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"abstractUserName\":\"Jimmy\",\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"primaryKey\":5,\"abstractUserTypeValue\":2}', '{\"id\":5,\"empName\":\"Jimmy\",\"empLoginName\":\"Jimmy\",\"empPwd\":\"EDFD0CCC96443326978E8BA15DCC3140\",\"empPhone\":\"13812344311\",\"empEmail\":\"jimmy@qq.com\",\"empLoc\":0,\"empStatus\":1,\"deptId\":3,\"postId\":1,\"empCreated\":1535011265000,\"empUpdated\":1535013492441,\"empEncrypt\":\"tdAUAWnMvn\",\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"abstractUserName\":\"Jimmy\",\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"primaryKey\":5,\"abstractUserTypeValue\":2}', 'Judy', '2018-08-23 16:38:14', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (7, 8, 5, '{\"id\":5,\"empName\":\"Jimmy\",\"empLoginName\":\"Jimmy\",\"empPwd\":\"EDFD0CCC96443326978E8BA15DCC3140\",\"empPhone\":\"13812344311\",\"empEmail\":\"jimmy@qq.com\",\"empLoc\":0,\"empStatus\":1,\"deptId\":3,\"postId\":1,\"empCreated\":1535011265000,\"empUpdated\":1535013492000,\"empEncrypt\":\"tdAUAWnMvn\",\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"abstractUserName\":\"Jimmy\",\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"primaryKey\":5,\"abstractUserTypeValue\":2}', '{\"id\":5,\"empName\":\"Jimmy\",\"empLoginName\":\"Jimmy\",\"empPhone\":\"13812344311\",\"empQq\":\"96067\",\"empEmail\":\"jimmy@qq.com\",\"empLoc\":0,\"deptId\":3,\"postId\":1,\"empUpdated\":1535013574550,\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"abstractUserName\":\"Jimmy\",\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"primaryKey\":5,\"abstractUserTypeValue\":2}', 'Judy', '2018-08-23 16:39:35', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (8, 8, 5, '{\"id\":5,\"empName\":\"Jimmy\",\"empLoginName\":\"Jimmy\",\"empPwd\":\"EDFD0CCC96443326978E8BA15DCC3140\",\"empPhone\":\"13812344311\",\"empQq\":\"96067\",\"empEmail\":\"jimmy@qq.com\",\"empLoc\":0,\"empStatus\":1,\"deptId\":3,\"postId\":1,\"empCreated\":1535011265000,\"empUpdated\":1535013575000,\"empEncrypt\":\"tdAUAWnMvn\",\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"abstractUserName\":\"Jimmy\",\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"primaryKey\":5,\"abstractUserTypeValue\":2}', '{\"id\":5,\"empName\":\"Jimmy\",\"empLoginName\":\"Jimmy\",\"empPwd\":\"EDFD0CCC96443326978E8BA15DCC3140\",\"empPhone\":\"13812344311\",\"empEmail\":\"jimmy@qq.com\",\"empLoc\":0,\"empStatus\":1,\"deptId\":3,\"postId\":1,\"empCreated\":1535011265000,\"empUpdated\":1535013615874,\"empEncrypt\":\"tdAUAWnMvn\",\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"abstractUserName\":\"Jimmy\",\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"primaryKey\":5,\"abstractUserTypeValue\":2}', 'Judy', '2018-08-23 16:40:16', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (9, 9, 4, '', '{\"id\":4,\"postName\":\"总裁\"}', 'Judy', '2018-08-23 16:54:14', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (10, 9, 3, '{\"id\":3,\"postName\":\"员工\"}', '{\"id\":3,\"postName\":\"员工1\"}', 'Judy', '2018-08-23 16:54:39', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (11, 9, 3, '{\"id\":3,\"postName\":\"员工1\"}', '{\"id\":3,\"postName\":\"员工\"}', 'Judy', '2018-08-23 16:54:50', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (12, 1, 6, '{\"id\":6,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508170975000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":6,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"admin\",\"operateTime\":1535431550491,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'admin', '2018-08-28 12:45:51', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (13, 1, 1, '{\"id\":1,\"name\":\"技术部\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"remark\":\"技术部\",\"operator\":\"system\",\"operateTime\":1507677700000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":1,\"name\":\"技术部\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"remark\":\"技术部\",\"operator\":\"admin\",\"operateTime\":1535438818518,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'admin', '2018-08-28 14:46:59', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (14, 9, 1, '{\"id\":1,\"postName\":\"高级员工\"}', '{\"id\":1,\"postName\":\"高级员工\"}', 'admin', '2018-08-28 16:44:03', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (15, 8, 1, '{\"id\":1,\"empName\":\"Judy\",\"empLoginName\":\"Judy\",\"empPwd\":\"E3EB552B2384D6285A74C49195D5BE5C\",\"empTel\":\"059183261633,059183262919\",\"empPhone\":\"13500001234,18612345678\",\"empAdd\":\"福建省福州市台江区六一中路450号\",\"empQq\":\"96067\",\"empFax\":\"059183261234\",\"empEmail\":\"96067@qq.com\",\"empBirth\":603043200000,\"empLoc\":0,\"empStatus\":1,\"deptId\":1,\"postId\":2,\"empCreated\":1534900516000,\"empUpdated\":1534900516000,\"empEncrypt\":\"yzsFzuFNjv\",\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"empExplain\":\"福建省福州市台江区六一中路450号\",\"primaryKey\":1,\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"abstractUserName\":\"Judy\",\"abstractUserTypeValue\":2}', '{\"id\":1,\"empName\":\"Judy\",\"empLoginName\":\"Judy\",\"empTel\":\"059183261633,059183262919\",\"empPhone\":\"13500001234,18612345678\",\"empAdd\":\"福建省福州市台江区六一中路450号\",\"empQq\":\"96067\",\"empFax\":\"059183261234\",\"empEmail\":\"96067@qq.com\",\"empLoc\":0,\"deptId\":3,\"postId\":3,\"empUpdated\":1535530822855,\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"empExplain\":\"福建省福州市台江区六一中路450号\",\"primaryKey\":1,\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"abstractUserName\":\"Judy\",\"abstractUserTypeValue\":2}', 'admin', '2018-08-29 16:20:23', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (16, 8, 1, '{\"id\":1,\"empName\":\"Judy\",\"empLoginName\":\"Judy\",\"empPwd\":\"E3EB552B2384D6285A74C49195D5BE5C\",\"empTel\":\"059183261633,059183262919\",\"empPhone\":\"13500001234,18612345678\",\"empAdd\":\"福建省福州市台江区六一中路450号\",\"empQq\":\"96067\",\"empFax\":\"059183261234\",\"empEmail\":\"96067@qq.com\",\"empBirth\":603043200000,\"empLoc\":0,\"empStatus\":1,\"deptId\":3,\"postId\":3,\"empCreated\":1534900516000,\"empUpdated\":1535530823000,\"empEncrypt\":\"yzsFzuFNjv\",\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"empExplain\":\"福建省福州市台江区六一中路450号\",\"abstractUserName\":\"Judy\",\"primaryKey\":1,\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"abstractUserTypeValue\":2}', '{\"id\":1,\"empName\":\"Judy\",\"empLoginName\":\"Judy\",\"empTel\":\"059183261633,059183262919\",\"empPhone\":\"13500001234,18612345678\",\"empAdd\":\"福建省福州市台江区六一中路450号\",\"empQq\":\"96067\",\"empFax\":\"059183261234\",\"empEmail\":\"96067@qq.com\",\"empLoc\":0,\"deptId\":3,\"postId\":3,\"empUpdated\":1536560058185,\"empLastIp\":\"0:0:0:0:0:0:0:1\",\"empExplain\":\"福建省福州市台江区六一中路450号\",\"abstractUserName\":\"Judy\",\"primaryKey\":1,\"userType\":\"47b01ef4-9e37-4453-8b49-df63367ea895\",\"abstractUserTypeValue\":2}', 'admin', '2018-09-10 14:14:18', '0:0:0:0:0:0:0:1', 1);
INSERT INTO `sys_log` VALUES (17, 1, 7, '', '{\"id\":7,\"name\":\"Jsp\",\"parentId\":1,\"level\":\"0.1\",\"seq\":4,\"operator\":\"admin\",\"operateTime\":1540949655192,\"operateIp\":\"127.0.0.1\"}', 'admin', '2018-10-31 09:34:15', '127.0.0.1', 1);
INSERT INTO `sys_log` VALUES (18, 3, 12, '', '{\"id\":12,\"name\":\"状态管理\",\"parentId\":1,\"level\":\"0.1\",\"seq\":3,\"status\":1,\"operator\":\"admin\",\"operateTime\":1540953130153,\"operateIp\":\"127.0.0.1\"}', 'admin', '2018-10-31 10:32:10', '127.0.0.1', 1);
INSERT INTO `sys_log` VALUES (19, 3, 13, '', '{\"id\":13,\"name\":\"测试\",\"parentId\":1,\"level\":\"0.1\",\"seq\":4,\"status\":1,\"operator\":\"admin\",\"operateTime\":1540953208081,\"operateIp\":\"127.0.0.1\"}', 'admin', '2018-10-31 10:33:28', '127.0.0.1', 1);
INSERT INTO `sys_log` VALUES (20, 3, 12, '{\"id\":12,\"name\":\"状态管理\",\"parentId\":1,\"level\":\"0.1\",\"seq\":3,\"status\":1,\"operator\":\"admin\",\"operateTime\":1540953130000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":12,\"name\":\"状态管理1\",\"parentId\":1,\"level\":\"0.1\",\"seq\":3,\"status\":1,\"operator\":\"admin\",\"operateTime\":1540957410583,\"operateIp\":\"127.0.0.1\"}', 'admin', '2018-10-31 11:43:31', '127.0.0.1', 1);
INSERT INTO `sys_log` VALUES (21, 3, 12, '{\"id\":12,\"name\":\"状态管理1\",\"parentId\":1,\"level\":\"0.1\",\"seq\":3,\"status\":1,\"operator\":\"admin\",\"operateTime\":1540957411000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":12,\"name\":\"状态管理\",\"parentId\":1,\"level\":\"0.1\",\"seq\":3,\"status\":1,\"operator\":\"admin\",\"operateTime\":1540957422086,\"operateIp\":\"127.0.0.1\"}', 'admin', '2018-10-31 11:43:42', '127.0.0.1', 1);
INSERT INTO `sys_log` VALUES (22, 1, 8, '', '{\"id\":8,\"name\":\"JQuery\",\"parentId\":5,\"level\":\"0.5\",\"seq\":1,\"operator\":\"admin\",\"operateTime\":1540972676169,\"operateIp\":\"127.0.0.1\"}', 'admin', '2018-10-31 15:57:56', '127.0.0.1', 1);

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职务名称',
  `post_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '职务描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, '高级员工', '');
INSERT INTO `sys_post` VALUES (2, '经理', '');
INSERT INTO `sys_post` VALUES (3, '员工', NULL);
INSERT INTO `sys_post` VALUES (4, '总裁', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` int(11) NOT NULL DEFAULT 1 COMMENT '角色的类型，1：管理员角色，2：其他',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态，1：可用，0：冻结',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '备注',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '产品管理员', 1, 1, '', 'Admin', '2017-10-15 12:42:47', '127.0.0.1');
INSERT INTO `sys_role` VALUES (2, '订单管理员', 1, 1, '', 'Admin', '2017-10-15 12:18:59', '127.0.0.1');
INSERT INTO `sys_role` VALUES (3, '公告管理员', 1, 1, '', 'Admin', '2017-10-15 12:19:10', '127.0.0.1');
INSERT INTO `sys_role` VALUES (4, '权限管理员', 1, 1, '', 'Admin', '2017-10-15 21:30:36', '127.0.0.1');
INSERT INTO `sys_role` VALUES (5, '运维管理员', 1, 1, '运维', 'Admin', '2017-10-17 00:23:28', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_role_acl
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_acl`;
CREATE TABLE `sys_role_acl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `acl_id` int(11) NOT NULL COMMENT '权限id',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `user_type` int(4) DEFAULT NULL COMMENT '用户类型 0 顾客; 1 供应商; 2 员工; 3 管理员; 默认 0',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `telephone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `mail` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '加密后的密码',
  `is_admin` int(4) DEFAULT 1,
  `dept_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户所在部门的id',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态，1：正常，0：冻结状态，2：删除',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '备注',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `operate_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '13500001234', 'admin@qq.com', '25D55AD283AA400AF464C76D713C07AD', 1, 1, 1, 'admin', 'System', '2017-12-14 10:45:19', '127.0.0.1');
INSERT INTO `sys_user` VALUES (2, 'Jimin', '13188889999', 'jimin@qq.com', '25D55AD283AA400AF464C76D713C07AD', 1, 1, 1, 'jimin.zheng', 'Admin', '2017-10-14 14:45:19', '127.0.0.1');
INSERT INTO `sys_user` VALUES (3, 'Jimmy', '13812344311', 'jimmy@qq.com', '25D55AD283AA400AF464C76D713C07AD', 1, 2, 1, '', 'Admin', '2017-10-16 12:57:35', '127.0.0.1');
INSERT INTO `sys_user` VALUES (4, 'Kate', '13144445555', 'kate@qq.com', '25D55AD283AA400AF464C76D713C07AD', 1, 1, 1, 'sss', 'Admin', '2017-10-16 23:02:51', '127.0.0.1');
INSERT INTO `sys_user` VALUES (5, '服务员A', '18677778888', 'service@qq.com', '25D55AD283AA400AF464C76D713C07AD', 1, 3, 1, '', 'Admin', '2017-10-17 00:22:15', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_web_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_web_config`;
CREATE TABLE `sys_web_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `web_title` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `web_link` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '链接地址',
  `web_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电子邮件',
  `web_logo_image` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'logo图片链接地址',
  `web_add` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `web_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `web_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `web_fax` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '传真',
  `web_icp` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ICP备案信息',
  `web_copy_right` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '版权',
  `web_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '站点名称',
  `web_keyword` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '关键词设置',
  `web_link_icon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器上显示的图标',
  `web_close_tip` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '关闭提示',
  `web_upload_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '上传文件目录',
  `web_skin` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '网站皮肤',
  `web_census_code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '统计代码',
  `web_status` int(4) DEFAULT 1 COMMENT '配置状态是否可用 1 可用, 0 不可用',
  `web_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '站点描述',
  `web_explain` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  `web_header` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '网站头部',
  `web_footer` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '网站底部',
  `web_created` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `web_updated` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_web_config
-- ----------------------------
INSERT INTO `sys_web_config` VALUES (1, '万姿百代', '万姿百代', 'wzbd@qq.com', '/img/sys/logo.ico1', '福建省福州市 台江区', '059183261633', '13512345678', '059183262919', '闽备12345678', 'peyton Application &copy; 2018', '万姿百代', '女包，男包，背包，休闲包', '/img/sys/headline.ico', '网站正在准备中，请稍候... 测试数据 。。。。', '/images/upload', 'gray', '测试数据 灵气', 1, '<p>\r\n	测试描述&nbsp;<span>测试描述&nbsp;<span>测试描述</span></span> \r\n</p>\r\n<p>\r\n	<span><span>测试描述</span></span> \r\n</p>', '测试说明', NULL, NULL, '2018-09-01 16:13:34', '2018-09-07 09:47:30');

-- ----------------------------
-- Table structure for tb_brand_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand_info`;
CREATE TABLE `tb_brand_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sup_id` bigint(20) NOT NULL COMMENT '供应商编号',
  `brand_logo` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '品牌LOGO 图片大小120px*60px',
  `brand_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '品牌名称',
  `brand_area` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属地区',
  `brand_seq` int(11) NOT NULL COMMENT '排序 从小到大',
  `brand_status` int(4) DEFAULT 1 COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
  `brand_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '品牌描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_brand_info
-- ----------------------------
INSERT INTO `tb_brand_info` VALUES (1, 1, '/img/logo/c86f9d6b543f4d4b866d639c05ea0ef3.jpg', '优朋', 'zh-CN', 1, 1, '测试数据1');
INSERT INTO `tb_brand_info` VALUES (2, 18, '/img/logo/bc8cbe69f8d64962997bfd1247825f46.jpg', '高盛', 'zh-CN', 0, 1, '测试数据124');
INSERT INTO `tb_brand_info` VALUES (3, 7, '/img/logo/0187368ca73343ea90e5b28450242acc.png', '欧米', '中国', 2, 0, '测试数据');

-- ----------------------------
-- Table structure for tb_cat_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_cat_info`;
CREATE TABLE `tb_cat_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cus_id` bigint(20) DEFAULT NULL COMMENT '顾客编号',
  `com_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '顾客编号',
  `cat_quantity` int(11) DEFAULT 0 COMMENT '数量',
  `checked` int(4) DEFAULT 0 COMMENT '是否选中: 0 未选中 1 选中',
  `cat_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  `cat_created` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cat_updated` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_color_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_color_info`;
CREATE TABLE `tb_color_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `col_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '颜色名称',
  `col_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '颜色代码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_color_info
-- ----------------------------
INSERT INTO `tb_color_info` VALUES (1, '黑咖啡色', '');
INSERT INTO `tb_color_info` VALUES (2, '黑色', '');
INSERT INTO `tb_color_info` VALUES (3, '红色', '');
INSERT INTO `tb_color_info` VALUES (4, '青色', '');
INSERT INTO `tb_color_info` VALUES (5, '橙色', '');
INSERT INTO `tb_color_info` VALUES (6, '灰色', '');
INSERT INTO `tb_color_info` VALUES (7, '紫色', '');
INSERT INTO `tb_color_info` VALUES (8, '粉红色', '');
INSERT INTO `tb_color_info` VALUES (9, '兰色', '');
INSERT INTO `tb_color_info` VALUES (10, '大红', '');
INSERT INTO `tb_color_info` VALUES (11, '黄色', '');
INSERT INTO `tb_color_info` VALUES (12, '深灰', '');

-- ----------------------------
-- Table structure for tb_commodity_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_commodity_category`;
CREATE TABLE `tb_commodity_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) DEFAULT 0 COMMENT '父编号',
  `coca_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `coca_level` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品分类层级',
  `coca_seq` int(4) DEFAULT 0 COMMENT '排序,按升序',
  `coca_explain` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  `coca_created` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `coca_updated` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_commodity_category
-- ----------------------------
INSERT INTO `tb_commodity_category` VALUES (12, 0, '箱包', '0', 1, '', '2018-10-11 10:26:13', '2018-10-11 10:26:13');
INSERT INTO `tb_commodity_category` VALUES (13, 12, '男式', '0.12', 1, '', '2018-10-11 10:26:43', '2018-10-11 10:26:43');
INSERT INTO `tb_commodity_category` VALUES (14, 12, '女式', '0.12', 2, '', '2018-10-11 10:26:55', '2018-10-11 10:26:55');
INSERT INTO `tb_commodity_category` VALUES (15, 12, '拉杆箱', '0.12', 3, '', '2018-10-11 10:27:14', '2018-10-11 10:27:14');
INSERT INTO `tb_commodity_category` VALUES (16, 13, '登山包', '0.12.13', 1, '', '2018-10-11 10:27:32', '2018-10-11 10:27:32');
INSERT INTO `tb_commodity_category` VALUES (17, 13, '手抓包', '0.12.13', 2, '', '2018-10-11 10:28:03', '2018-10-11 10:28:03');
INSERT INTO `tb_commodity_category` VALUES (18, 13, '背包', '0.12.13', 3, '', '2018-10-11 10:28:23', '2018-10-11 10:28:23');
INSERT INTO `tb_commodity_category` VALUES (19, 14, '休闲包', '0.12.14', 1, '', '2018-10-11 10:28:43', '2018-10-11 10:28:43');
INSERT INTO `tb_commodity_category` VALUES (20, 14, '背包', '0.12.14', 2, '', '2018-10-11 10:29:03', '2018-10-11 10:29:03');
INSERT INTO `tb_commodity_category` VALUES (21, 14, '便包', '0.12.14', 3, '', '2018-10-11 10:29:21', '2018-10-11 10:29:21');
INSERT INTO `tb_commodity_category` VALUES (22, 20, '皮料', '0.12.14.20', 1, '', '2018-10-11 10:29:52', '2018-10-11 10:29:52');
INSERT INTO `tb_commodity_category` VALUES (23, 20, '牛津布', '0.12.14.20', 2, '', '2018-10-11 10:30:12', '2018-10-11 10:30:12');
INSERT INTO `tb_commodity_category` VALUES (24, 20, '仿布', '0.12.14.20', 3, '', '2018-10-11 10:30:42', '2018-10-11 10:30:42');
INSERT INTO `tb_commodity_category` VALUES (25, 0, '日用品', '0', 2, '', NULL, '2018-10-11 10:31:12');
INSERT INTO `tb_commodity_category` VALUES (26, 0, '食品', '0', 3, '', '2018-10-11 10:31:07', '2018-10-11 10:31:07');
INSERT INTO `tb_commodity_category` VALUES (27, 25, '饮料', '0.25', 1, '', '2018-10-11 10:32:16', '2018-10-11 10:32:16');
INSERT INTO `tb_commodity_category` VALUES (28, 26, '快速画', '0.26', 1, '', '2018-10-11 10:32:36', '2018-10-11 10:32:36');
INSERT INTO `tb_commodity_category` VALUES (29, 14, '筒包', '0.12.14', 5, '', NULL, '2018-11-04 16:42:42');

-- ----------------------------
-- Table structure for tb_commodity_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_commodity_info`;
CREATE TABLE `tb_commodity_info`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `com_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `com_model` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '型号',
  `com_keyword` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关键词',
  `com_format` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '规格',
  `com_pack` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '包装',
  `com_unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '单位',
  `com_price` decimal(10, 2) DEFAULT NULL COMMENT '成本价',
  `com_retail` decimal(10, 2) DEFAULT NULL COMMENT '零售价',
  `com_wholesale` decimal(10, 2) DEFAULT NULL COMMENT '批发价',
  `com_main_img` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '主图地址',
  `com_images` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片Id集合{uuid生成jpg名,+ 从0开始数值; uuid,0,1,2,..,[图片格式后缀.jpg]},多个图片名用\",\"隔开',
  `com_status` int(4) DEFAULT 1 COMMENT '是否显示，1为显示，0不显示，默认为1',
  `com_comment` int(4) DEFAULT 1 COMMENT '是否可以评论，1可以评论,0不能评论',
  `com_barCode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '条形码',
  `com_hot` int(11) DEFAULT 0 COMMENT '商品热度点击1次加1',
  `com_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '详细',
  `com_created` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `com_updated` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `ori_id` int(11) DEFAULT NULL COMMENT '产地编号',
  `coso_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品分类编号的集合,[0,1,2...]',
  `coca_id` bigint(20) DEFAULT NULL COMMENT '商品类目编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_commodity_info
-- ----------------------------
INSERT INTO `tb_commodity_info` VALUES ('2a5c882f-d47e-4cba-bfd5-aa4718621395', ' 包包女2018新款潮时尚真皮手提包韩版女包百搭斜挎包简约女士大包', '226-0826', '2018新款潮时尚真皮手提包韩版女包百搭斜挎包简约女士大包', '34*30*11', '平装', '个', 336.00, 799.00, 398.00, '/img/product/95b1bff0af9249c79488844bb3d81c01.jpg', '/img/product/5353610d55ca49c9b2f9c61a08b303c4,0,1,2,3,4,.jpg', 1, 0, '', 0, '<p>\r\n	<br />\r\n</p>\r\n<ul class=\"attributes-list\" style=\"margin:0px;padding:0px 15px;list-style:none;clear:both;font-family:tahoma, arial, &quot;white-space:normal;background-color:#FFFFFF;\">\r\n	<li title=\"other/其他\" data-spm-anchor-id=\"2013.1.0.i18.2d485fbfMH153q\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		品牌:&nbsp;other/其他\r\n	</li>\r\n	<li title=\"大\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		大小:&nbsp;大\r\n	</li>\r\n	<li title=\"其他\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		流行款式名称:&nbsp;其他\r\n	</li>\r\n	<li title=\"青年\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		适用对象:&nbsp;青年\r\n	</li>\r\n	<li title=\"斜挎包\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		款式:&nbsp;斜挎包\r\n	</li>\r\n	<li title=\"斜挎单肩手提\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		背包方式:&nbsp;斜挎单肩手提\r\n	</li>\r\n	<li title=\"牛皮\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		质地:&nbsp;牛皮\r\n	</li>\r\n	<li title=\"头层牛皮\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		皮革材质:&nbsp;头层牛皮\r\n	</li>\r\n	<li title=\"软把\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		提拎部件类型:&nbsp;软把\r\n	</li>\r\n	<li title=\"拉链\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		闭合方式:&nbsp;拉链\r\n	</li>\r\n	<li title=\"卡位 拉链暗袋 手机袋 证件袋 夹层拉链袋\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		内部结构:&nbsp;卡位 拉链暗袋 手机袋 证件袋 夹层拉链袋\r\n	</li>\r\n	<li title=\"内贴袋\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		箱包外袋种类:&nbsp;内贴袋\r\n	</li>\r\n	<li title=\"镶钻\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		流行元素:&nbsp;镶钻\r\n	</li>\r\n	<li title=\"纯色\" data-spm-anchor-id=\"2013.1.0.i21.2d485fbfMH153q\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		图案:&nbsp;纯色\r\n	</li>\r\n	<li title=\"有\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		有无夹层:&nbsp;有\r\n	</li>\r\n	<li title=\"软\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		箱包硬度:&nbsp;软\r\n	</li>\r\n	<li title=\"否\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		是否可折叠:&nbsp;否\r\n	</li>\r\n	<li title=\"全新\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		成色:&nbsp;全新\r\n	</li>\r\n	<li title=\"休闲\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		适用场景:&nbsp;休闲\r\n	</li>\r\n	<li title=\"日韩\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		风格:&nbsp;日韩\r\n	</li>\r\n	<li title=\"横款方形\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		形状:&nbsp;横款方形\r\n	</li>\r\n	<li title=\"单根\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		肩带样式:&nbsp;单根\r\n	</li>\r\n	<li title=\"涤纶\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		里料材质:&nbsp;涤纶\r\n	</li>\r\n	<li title=\"np-0826\" data-spm-anchor-id=\"2013.1.0.i20.2d485fbfMH153q\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		货号:&nbsp;np-0826\r\n	</li>\r\n	<li title=\"新款镶钻女包\" style=\"margin:0px 20px 0px 0px;padding:0px;display:inline;float:left;width:206px;height:24px;overflow:hidden;text-indent:5px;line-height:24px;white-space:nowrap;text-overflow:ellipsis;\">\r\n		颜色分类:&nbsp;新款镶钻女包\r\n	</li>\r\n</ul>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	<br />\r\n</p>', '2018-10-11 11:01:41', '2018-11-04 16:22:43', 2, '12', 21);
INSERT INTO `tb_commodity_info` VALUES ('4ad33b2a-25bc-4c12-899a-dcac1e47d529', 'KIZZME2018秋季新款女包牛皮水桶包通勤大容量手提多种背法单肩包', '22564', 'KIZZME2018秋季新款女包牛皮水桶包通勤大容量手提多种背法单肩包', '', '平装', '个', 500.00, 636.00, 569.00, '/img/product/f70df819b4854983b9787177bb40d503.jpg', '/img/product/8b92f319d4fd48a5bf54c14daa9b33a9,0,1,2,3,4,5,6,7,8,9,.jpg', 1, 1, '', 0, '<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	<p class=\"title\" data-spm-anchor-id=\"2013.1.0.i14.5e7e6bc44O0KCt\" style=\"margin-top:0px;margin-bottom:0px;padding:0px;color:#FE702F;font-family:tahoma, arial, &quot;white-space:normal;background-color:#FFFFFF;\">\r\n		划线价格\r\n	</p>\r\n	<p class=\"info\" data-spm-anchor-id=\"2013.1.0.i12.5e7e6bc44O0KCt\" style=\"margin-top:0px;margin-bottom:15px;padding:0px;color:#666666;font-family:tahoma, arial, &quot;white-space:normal;background-color:#FFFFFF;\">\r\n		指商品的专柜价、吊牌价、正品零售价、厂商指导价或该商品的曾经展示过的销售价等，<span style=\"color:#333333;font-weight:600;\">并非原价</span>，仅供参考。\r\n	</p>\r\n	<p class=\"title\" style=\"margin-top:0px;margin-bottom:0px;padding:0px;color:#FE702F;font-family:tahoma, arial, &quot;white-space:normal;background-color:#FFFFFF;\">\r\n		未划线价格\r\n	</p>\r\n	<p class=\"info\" style=\"margin-top:0px;margin-bottom:15px;padding:0px;color:#666666;font-family:tahoma, arial, &quot;white-space:normal;background-color:#FFFFFF;\">\r\n		指商品的<span style=\"color:#333333;font-weight:600;\">实时标价</span>，不因表述的差异改变性质。具体成交价格根据商品参加活动，或会员使用优惠券、积分等发生变化，最终以订单结算页价格为准。\r\n	</p>\r\n	<p class=\"info\" style=\"margin-top:0px;margin-bottom:15px;padding:0px;color:#666666;font-family:tahoma, arial, &quot;white-space:normal;background-color:#FFFFFF;\">\r\n		商家详情页（含主图）以图片或文字形式标注的一口价、促销价、优惠价等价格可能是在使用优惠券、满减或特定优惠活动和时段等情形下的价格，具体请以结算页面的标价、优惠条件或活动规则为准。\r\n	</p>\r\n	<p class=\"info\" style=\"margin-top:0px;margin-bottom:15px;padding:0px;color:#666666;font-family:tahoma, arial, &quot;white-space:normal;background-color:#FFFFFF;\">\r\n		此说明仅当出现价格比较时有效，具体请参见《淘宝价格发布规范》。若商家单独对划线价格进行说明的，以商家的表述为准。\r\n	</p>\r\n</p>', '2018-11-04 15:58:12', '2018-11-04 15:58:12', 12, '15', 19);
INSERT INTO `tb_commodity_info` VALUES ('9260fc14-3c54-47a8-a33b-11a6ab0ed6c7', '复古圆筒水桶包女包小挎包真皮斜跨包植鞣牛皮手工包学院风硬皮包', '77896', '复古圆筒水桶包女包小挎包真皮斜跨包植鞣牛皮手工包学院风硬皮包', '15*17', '平装', '个', 156.00, 335.00, 186.00, '/img/product/084a41a5bb41407783cc7f0980300381.jpg', '/img/product/8cdbc00d4279498ba49c53d0e9ff96f3,0,1,2,3,4,5,6,.jpg', 1, 1, '', 0, '<p style=\"margin-top:1.12em;margin-bottom:1.12em;padding:0px;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;white-space:normal;background-color:#FFFFFF;text-align:center;\">\r\n	<span style=\"color:#666666;\"><strong><span data-spm-anchor-id=\"2013.1.0.i18.3d67c5c8RWDRdy\" style=\"color:#000000;\">葱木复古手工出品&nbsp;</span></strong></span><span style=\"color:#444444;\">vintage复古圆筒水桶包女包小挎包真皮斜跨包植鞣牛皮手工包学院风硬皮包</span> \r\n</p>\r\n<p style=\"margin-top:1.12em;margin-bottom:1.12em;padding:0px;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;white-space:normal;background-color:#FFFFFF;text-align:center;\">\r\n	<span style=\"font-size:12px;\"></span> \r\n</p>\r\n<p style=\"margin-top:1.12em;margin-bottom:1.12em;padding:0px;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;white-space:normal;background-color:#FFFFFF;text-align:center;\">\r\n	<span style=\"font-size:12px;\">意大利进口头层植鞣牛皮，皮质厚实耐用，复古定型圆筒包，</span> \r\n</p>\r\n<p style=\"margin-top:1.12em;margin-bottom:1.12em;padding:0px;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;white-space:normal;background-color:#FFFFFF;text-align:center;\">\r\n	<span style=\"font-size:12px;\"></span> \r\n</p>\r\n<p style=\"margin-top:1.12em;margin-bottom:1.12em;padding:0px;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;white-space:normal;background-color:#FFFFFF;text-align:center;\">\r\n	<span style=\"font-size:12px;\">可以单肩、斜跨、手提多种使用方法，长肩带足够长，包包容量适中，</span> \r\n</p>\r\n<p style=\"margin-top:1.12em;margin-bottom:1.12em;padding:0px;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;white-space:normal;background-color:#FFFFFF;text-align:center;\">\r\n	<span style=\"font-size:12px;\"></span> \r\n</p>\r\n<p style=\"margin-top:1.12em;margin-bottom:1.12em;padding:0px;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;white-space:normal;background-color:#FFFFFF;text-align:center;\">\r\n	<span style=\"font-size:12px;\">可以放日常随身小物品，因为皮质偏硬，所以可以存放一些怕挤压的物品。</span> \r\n</p>', '2018-10-11 10:46:06', '2018-10-11 11:04:39', 1, '14,12', 29);

-- ----------------------------
-- Table structure for tb_commodity_sort
-- ----------------------------
DROP TABLE IF EXISTS `tb_commodity_sort`;
CREATE TABLE `tb_commodity_sort`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cos_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `cos_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_commodity_sort
-- ----------------------------
INSERT INTO `tb_commodity_sort` VALUES (12, '热销', '比较热门的产品');
INSERT INTO `tb_commodity_sort` VALUES (13, '特价', '');
INSERT INTO `tb_commodity_sort` VALUES (14, '周年庆', '');
INSERT INTO `tb_commodity_sort` VALUES (15, '双十一', '');
INSERT INTO `tb_commodity_sort` VALUES (16, '清仓', '');

-- ----------------------------
-- Table structure for tb_customer_grade
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer_grade`;
CREATE TABLE `tb_customer_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cugr_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '等级名称',
  `cugr_dr` int(4) DEFAULT 100 COMMENT '折扣率，默认100为百分之百',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_customer_grade
-- ----------------------------
INSERT INTO `tb_customer_grade` VALUES (1, '普通会员', 99);
INSERT INTO `tb_customer_grade` VALUES (2, '黄金会员', 90);
INSERT INTO `tb_customer_grade` VALUES (3, '白金会员', 85);
INSERT INTO `tb_customer_grade` VALUES (4, '黑金会员', 80);
INSERT INTO `tb_customer_grade` VALUES (5, 'Vip会员', 95);
INSERT INTO `tb_customer_grade` VALUES (6, 'Vip2', 93);
INSERT INTO `tb_customer_grade` VALUES (7, 'VIP3', 91);
INSERT INTO `tb_customer_grade` VALUES (8, 'VIP4', 89);
INSERT INTO `tb_customer_grade` VALUES (9, 'VIP5', 87);
INSERT INTO `tb_customer_grade` VALUES (10, 'VIP6', 85);
INSERT INTO `tb_customer_grade` VALUES (11, 'VIP7', 83);
INSERT INTO `tb_customer_grade` VALUES (12, 'VIP8', 81);
INSERT INTO `tb_customer_grade` VALUES (13, 'VIP9', 79);
INSERT INTO `tb_customer_grade` VALUES (14, 'VIP10', 77);
INSERT INTO `tb_customer_grade` VALUES (15, 'VIP11', 75);
INSERT INTO `tb_customer_grade` VALUES (16, 'VIP12', 73);
INSERT INTO `tb_customer_grade` VALUES (17, 'VIP16', 71);

-- ----------------------------
-- Table structure for tb_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer_info`;
CREATE TABLE `tb_customer_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cus_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `cus_login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名',
  `cus_avatar` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '顾客头像地址',
  `cus_pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `cus_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `cus_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `cus_add` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `cus_qq` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'qq',
  `cus_fax` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '传真',
  `cus_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `cus_birth` datetime(0) DEFAULT NULL COMMENT '出生日期',
  `cus_identity` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证',
  `cus_loc` int(11) DEFAULT 0 COMMENT '登录次数',
  `cus_status` int(4) DEFAULT 1 COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
  `cus_hot` int(11) DEFAULT 0 COMMENT '经常使用，每点击一次加1',
  `regi_id` bigint(20) DEFAULT NULL COMMENT '地区编号',
  `cugr_id` int(11) DEFAULT NULL COMMENT '顾客等级编号',
  `cus_created` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cus_updated` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `cus_type` int(4) DEFAULT 1 COMMENT '取值范围 0为批发客户,1为零售客户 [默认为1]',
  `cus_encrypt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '加密串',
  `cus_last_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '最后登录IP',
  `cus_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_customer_info
-- ----------------------------
INSERT INTO `tb_customer_info` VALUES (1, '张无忌', 'zhangwuji', NULL, 'B8BE73AFFC241BE33B935CABB3D2511C', '059183260000', '13599129876', '测试数据1', '123456', '059183260001', '960672588@qq.com', '1991-03-15 00:00:00', '350127199103155231', 0, 1, 0, 9, 3, '2018-11-06 16:10:26', '2018-11-09 16:53:46', 1, 'ngbOfGIbaU', '127.0.0.1', '测试数据1');
INSERT INTO `tb_customer_info` VALUES (2, '乔峰', 'qiaofeng', NULL, '0EE20ECBD0B2DA452DDF77E588F04D68', '01077456698', '13012345678', '测试数据', '256434', '059183260001', 'qiaofeng@qq.com', '1980-02-06 00:00:00', '350127198002065324', 0, 1, 0, 7, 4, '2018-11-06 16:12:48', '2018-11-12 11:04:13', 0, 'dGVaDMXTCu', '127.0.0.1', '测试数据');
INSERT INTO `tb_customer_info` VALUES (3, '壹叶知秋', 'yi', NULL, 'C389CB42C9A7F1D24E5CA8705C3B902F', '059183260000', '', '', '', '', '', NULL, '', 0, 1, 0, 16, 17, '2018-11-12 11:12:12', '2018-11-12 16:11:09', 1, 'eusBmPERij', '127.0.0.1', '');
INSERT INTO `tb_customer_info` VALUES (4, 'xialong', 'xiaolong', NULL, 'C3D8CCCD8D312E62F512A2C13BA4B9AB', '02063124578', '13599129888', '测试数据 。。。。', '1259874', '02063124578', '1259874@qq.com', '1980-01-01 00:00:00', '510283198001015631', 0, 1, 0, 9, 4, '2018-11-13 09:46:36', '2018-11-13 09:46:36', 1, 'MbxlUFzPQX', '127.0.0.1', '测试数据 。。。。');
INSERT INTO `tb_customer_info` VALUES (5, '花无缺', 'fa', NULL, '539C0F49F8E6A47B2BB5AE003F5F6928', '', '', '', '', '', '', NULL, '', 0, 3, 0, 6, 17, '2018-11-13 09:49:00', '2018-11-13 09:49:00', 1, 'QaDYrYMmkj', '127.0.0.1', '');
INSERT INTO `tb_customer_info` VALUES (6, '剑十三', 'jian', NULL, '83DB967C9B1A65DF170368E93CD0EE0C', '', '', '', '', '', '', NULL, '', 0, 3, 0, 6, 2, '2018-11-13 10:00:07', '2018-11-13 10:00:07', 1, 'AIpTmIuyiD', '127.0.0.1', '');

-- ----------------------------
-- Table structure for tb_delete_picture
-- ----------------------------
DROP TABLE IF EXISTS `tb_delete_picture`;
CREATE TABLE `tb_delete_picture`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `status` int(4) DEFAULT 1 COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_freight_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_freight_type`;
CREATE TABLE `tb_freight_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `frt_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `frt_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `frt_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `frt_fax` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '传真',
  `frt_qq` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'qq',
  `frt_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `frt_add` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `frt_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  `frt_created` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `frt_updated` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_freight_type
-- ----------------------------
INSERT INTO `tb_freight_type` VALUES (1, '明可达', '059183260000', '13599129876', '059183260001', '123456', 'mkd@qq.com', '测试', '张家辉，1967年12月2日出生于香港，祖籍广东，中国香港男演员、导演。\r\n1989年在电影《壮志雄心》中出演少年警校学员，开始其演员生涯。1995年签约无线电视。1998年参演电影《赌侠1999》，获第18届香港电影金像奖最佳男配角提名。2003年12月8日与关咏荷在澳大利亚结婚。2004年出演杜琪峰导演的《大事件》。2008年，张家辉与谢霆锋、张静初合作主演《证人》，凭借该片张家辉荣获第53届亚太影展最佳男主角、', '2018-09-10 14:23:19', '2018-09-10 16:09:19');
INSERT INTO `tb_freight_type` VALUES (3, '永驰', '059183207788', '13065470000', '', '', '', '火箭筒', '<propertyname=\"mapperInterface\"value=\"com.sml.mapper.admin.DeskTopMapper\" /><property name=\"mapperInterface\" value=\"com.sml.mapper.admin.MenusInformationMapper\" />\r\n换个name试试知道是这个问题..但是不知道错在哪里..我换了name还是不行.', '2018-09-10 15:16:37', '2018-09-10 15:38:16');
INSERT INTO `tb_freight_type` VALUES (4, '快捷', '02099885643', '13900223456', '', '', '', '测试数据', '测试数据', NULL, '2018-09-13 11:34:06');

-- ----------------------------
-- Table structure for tb_inventory_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_inventory_info`;
CREATE TABLE `tb_inventory_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `inve_created` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `inve_detail` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '颜色编号1:数量,颜色编号2:数量,...颜色编号N:数量',
  `inve_tip` int(4) DEFAULT 0 COMMENT '库存提示，1为提示，0不提示，默认为0',
  `inve_com_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名称,用来模糊查找',
  `inve_total` int(11) DEFAULT 0 COMMENT '总数量',
  `war_id` int(11) DEFAULT NULL COMMENT '仓库编号',
  `com_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品编号',
  `inve_explain` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_inventory_info
-- ----------------------------
INSERT INTO `tb_inventory_info` VALUES (1, '2018-10-26 08:56:24', '9:21,10:48,11:40,12:50', 1, ' 包包女2018新款潮时尚真皮手提包韩版女包百搭斜挎包简约女士大包', 196, 3, '2a5c882f-d47e-4cba-bfd5-aa4718621395', '9号仓库');
INSERT INTO `tb_inventory_info` VALUES (2, '2018-10-26 15:52:48', '11:40,7:10', 1, '复古圆筒水桶包女包小挎包真皮斜跨包植鞣牛皮手工包学院风硬皮包', 50, 2, '9260fc14-3c54-47a8-a33b-11a6ab0ed6c7', '12仓库');

-- ----------------------------
-- Table structure for tb_origin_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_origin_info`;
CREATE TABLE `tb_origin_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `ori_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `ori_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_origin_info
-- ----------------------------
INSERT INTO `tb_origin_info` VALUES (1, '广州', '');
INSERT INTO `tb_origin_info` VALUES (2, '北京', '');
INSERT INTO `tb_origin_info` VALUES (3, '郑州', '');
INSERT INTO `tb_origin_info` VALUES (4, '厦门', '');
INSERT INTO `tb_origin_info` VALUES (5, '义乌', '');
INSERT INTO `tb_origin_info` VALUES (6, '上海', '');
INSERT INTO `tb_origin_info` VALUES (7, '白沟', '');
INSERT INTO `tb_origin_info` VALUES (8, '邵东', '');
INSERT INTO `tb_origin_info` VALUES (9, '长沙', '');
INSERT INTO `tb_origin_info` VALUES (10, '江西', '');
INSERT INTO `tb_origin_info` VALUES (12, '深圳', '');

-- ----------------------------
-- Table structure for tb_payment_mode
-- ----------------------------
DROP TABLE IF EXISTS `tb_payment_mode`;
CREATE TABLE `tb_payment_mode`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pamo_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `pamo_explain` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_payment_mode
-- ----------------------------
INSERT INTO `tb_payment_mode` VALUES (1, '现金付款', '现金付款112');
INSERT INTO `tb_payment_mode` VALUES (2, '支付宝', '网络流行付款之一');
INSERT INTO `tb_payment_mode` VALUES (3, '微信', '网络流行付款之一');

-- ----------------------------
-- Table structure for tb_region_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_region_info`;
CREATE TABLE `tb_region_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `regi_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `regi_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地区区码',
  `regi_seq` int(11) NOT NULL DEFAULT 0 COMMENT '排序,从小到大排序',
  `regi_level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地区层级',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父级编号，默认顶层为0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_region_info
-- ----------------------------
INSERT INTO `tb_region_info` VALUES (1, '福建省', '000', 1, '0', 0);
INSERT INTO `tb_region_info` VALUES (2, '福州市', '1', 1, '0.1', 1);
INSERT INTO `tb_region_info` VALUES (3, '台江区', '1', 1, '0.1.2', 2);
INSERT INTO `tb_region_info` VALUES (4, '晋安区', '1', 2, '0.1.2', 2);
INSERT INTO `tb_region_info` VALUES (5, '广东省', '25', 1, '0', 0);
INSERT INTO `tb_region_info` VALUES (6, '河南省', '1', 1, '0', 0);
INSERT INTO `tb_region_info` VALUES (7, '广州市', '1', 1, '0.5', 5);
INSERT INTO `tb_region_info` VALUES (8, '厦门市', '1', 1, '0.1', 1);
INSERT INTO `tb_region_info` VALUES (9, '泉州市', '1', 1, '0.1', 1);
INSERT INTO `tb_region_info` VALUES (10, '莆田市', '1', 1, '0.1', 1);
INSERT INTO `tb_region_info` VALUES (11, '深圳', '1', 1, '0.5', 5);
INSERT INTO `tb_region_info` VALUES (12, '汕头', '1', 1, '0.5', 5);
INSERT INTO `tb_region_info` VALUES (13, '龙岩', '1', 1, '0.1', 1);
INSERT INTO `tb_region_info` VALUES (14, '新疆', '1', 5, '0', 0);
INSERT INTO `tb_region_info` VALUES (15, '晋安', '', 5, '0.1.2', 2);
INSERT INTO `tb_region_info` VALUES (16, '测试', '', 6, '0', 0);

-- ----------------------------
-- Table structure for tb_shipping_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_shipping_info`;
CREATE TABLE `tb_shipping_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cust_id` bigint(20) NOT NULL COMMENT '顾客编号',
  `ship_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `ship_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `ship_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `ship_province` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '省份',
  `ship_city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '城市',
  `ship_district` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '区/县',
  `ship_address` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `ship_zip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮编',
  `ship_created` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ship_updated` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_storage_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_storage_detail`;
CREATE TABLE `tb_storage_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `stde_quantity` int(11) DEFAULT 0 COMMENT '数量',
  `stde_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  `stor_id` bigint(20) DEFAULT NULL COMMENT '入库编号',
  `col_id` int(11) DEFAULT NULL COMMENT '颜色编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_storage_detail
-- ----------------------------
INSERT INTO `tb_storage_detail` VALUES (1, 50, NULL, 1, 12);
INSERT INTO `tb_storage_detail` VALUES (2, 65, NULL, 1, 11);
INSERT INTO `tb_storage_detail` VALUES (3, 48, NULL, 1, 10);
INSERT INTO `tb_storage_detail` VALUES (4, 36, NULL, 1, 9);
INSERT INTO `tb_storage_detail` VALUES (7, 25, NULL, 3, 11);
INSERT INTO `tb_storage_detail` VALUES (8, 15, NULL, 3, 9);
INSERT INTO `tb_storage_detail` VALUES (29, 22, NULL, 2, 12);
INSERT INTO `tb_storage_detail` VALUES (30, 15, NULL, 2, 10);
INSERT INTO `tb_storage_detail` VALUES (31, 40, NULL, 4, 11);
INSERT INTO `tb_storage_detail` VALUES (32, 10, NULL, 4, 7);

-- ----------------------------
-- Table structure for tb_storage_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_storage_info`;
CREATE TABLE `tb_storage_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `stor_created` datetime(0) DEFAULT NULL COMMENT '入库时间，默认当前时间',
  `stor_updated` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `stor_direction` int(4) DEFAULT 0 COMMENT '出入库[0 入库, 1 出库],默认 0',
  `stor_status` int(4) DEFAULT 1 COMMENT '状态[0 废单,1 正常],默认 1',
  `stor_total` int(11) DEFAULT 0 COMMENT '总个数',
  `stor_com_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名称,用来模糊查找',
  `stor_image_url` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品图片地址',
  `stor_war_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '仓库名称',
  `stor_emp_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '员工名称',
  `war_id` int(11) DEFAULT NULL COMMENT '仓库编号',
  `com_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品编号',
  `emp_id` int(11) DEFAULT NULL COMMENT '员工编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_storage_info
-- ----------------------------
INSERT INTO `tb_storage_info` VALUES (1, '2018-10-26 08:56:24', '2018-10-26 08:56:24', 0, 1, 199, ' 包包女2018新款潮时尚真皮手提包韩版女包百搭斜挎包简约女士大包', '/img/product/95b1bff0af9249c79488844bb3d81c01.jpg', '9号仓库', 'Judy', 3, '2a5c882f-d47e-4cba-bfd5-aa4718621395', 1);
INSERT INTO `tb_storage_info` VALUES (2, '2018-10-26 09:17:22', '2018-10-26 09:54:13', 1, 2, 37, ' 包包女2018新款潮时尚真皮手提包韩版女包百搭斜挎包简约女士大包', '/img/product/95b1bff0af9249c79488844bb3d81c01.jpg', '9号仓库', 'Judy', 3, '2a5c882f-d47e-4cba-bfd5-aa4718621395', 1);
INSERT INTO `tb_storage_info` VALUES (3, '2018-10-26 09:21:50', '2018-10-26 09:21:50', 1, 1, 40, ' 包包女2018新款潮时尚真皮手提包韩版女包百搭斜挎包简约女士大包', '/img/product/95b1bff0af9249c79488844bb3d81c01.jpg', '9号仓库', 'Judy', 3, '2a5c882f-d47e-4cba-bfd5-aa4718621395', 1);
INSERT INTO `tb_storage_info` VALUES (4, '2018-10-26 15:52:48', '2018-10-26 15:52:48', 0, 1, 50, '复古圆筒水桶包女包小挎包真皮斜跨包植鞣牛皮手工包学院风硬皮包', '/img/product/084a41a5bb41407783cc7f0980300381.jpg', '12仓库', 'Judy', 2, '9260fc14-3c54-47a8-a33b-11a6ab0ed6c7', 1);

-- ----------------------------
-- Table structure for tb_supplier_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_supplier_info`;
CREATE TABLE `tb_supplier_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sup_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '供应商名称',
  `sup_login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '供应商登录名',
  `sup_avatar` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '供应商头像地址',
  `sup_pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `sup_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `sup_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `sup_add` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `sup_qq` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'qq',
  `sup_fax` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '传真',
  `sup_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `sup_loc` int(11) DEFAULT 0 COMMENT '登录次数',
  `sup_status` int(4) DEFAULT 1 COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
  `sup_created` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `sup_updated` datetime(0) DEFAULT NULL COMMENT '最后登录时间',
  `sup_encrypt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '加密串',
  `sup_last_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '最后登录IP',
  `sup_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  `sup_web_site` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '外接网址',
  `sup_web_code` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '连接外网标识码',
  `sup_hot` int(11) DEFAULT 0 COMMENT '经常使用，每点击一次加1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_supplier_info
-- ----------------------------
INSERT INTO `tb_supplier_info` VALUES (1, '名盛', '名盛', NULL, '471F1CD5E2C4937D528F9B9E9863A2B6', '057612345678', '13255668899', '测试数据 ', '1235678', '057612345678', 'minsen@qq.com', 0, 1, '2018-09-18 22:40:47', '2018-09-20 19:18:05', 'CEUIOqemPC', '127.0.0.1', '测试数据 ', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (2, '名盛1', '名盛1', NULL, '0AFBE037D95C05B4E1ED9DDE3E474420', '075512345678', '13922338765', '广东深圳', '968877', '075512345678', '12345678@tom.com', 0, 1, '2018-09-20 18:39:33', '2018-09-20 19:17:01', 'iEEjyEooms', '127.0.0.1', '测试数据', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (3, '利圆', '利圆', NULL, 'A6CB5B4B2BB705EC70B6F99A0BBA993D', '', '', '利圆', '', '', '', 0, 1, '2018-09-20 19:01:47', '2018-09-20 19:01:47', 'EpttFRYZNk', '127.0.0.1', '利圆', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (4, '测试', '测试', NULL, '4733290C5FDB14267166FFBE68A5B78D', '', '', '', '', '', '', 0, 1, '2018-09-20 20:52:32', '2018-09-20 20:52:32', 'UDzDFEXTXt', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (5, '测试', '测试1', NULL, '349360B52DF5D32A4F74DFB4FFFF5F8B', '', '', '', '', '', '', 0, 1, '2018-09-20 20:53:54', '2018-09-20 20:53:54', 'dbdPBkfcVr', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (6, '优朋', '优朋', NULL, '8B7DDCB7B2C6EFB1BDD5BB09B7B5E56F', '02088556644', '13255998866', '广东省广州市三元里。。。', '6547894521', '02088556644', 'youpan@ba.com', 0, 1, '2018-09-20 22:12:08', '2018-09-20 22:12:08', 'VOPxouPBVP', '127.0.0.1', '这是一组测试数据', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (7, '欧米', '欧米', NULL, 'AA5846999D30779461C1CB767A32397E', '', '', '', '', '', '', 0, 1, '2018-09-20 22:20:14', '2018-09-20 22:20:14', 'CeyyqdUfoC', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (8, 'Jeep', 'Jeep', NULL, '04777A17A04B448D9AA3931DD5F9148C', '02086347956', '13825893654', '广东省广州市三元里', '120456789', '02086347956', 'Jeep@qq.com', 0, 1, '2018-09-20 22:26:07', '2018-09-20 22:26:52', 'VkytlaQazW', '127.0.0.1', '测试数据', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (9, '盛大', '盛大', NULL, 'EA049B14CA4C2936A7396AA51A7752F7', '', '', '', '', '', '', 0, 1, '2018-09-20 22:31:17', '2018-09-20 22:31:17', 'aVBXCyjiAb', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (10, '测试2', '测试2', NULL, 'A288E252165566431C3F3C439D377C69', '', '', '', '', '', '', 0, 1, '2018-09-20 22:38:49', '2018-09-20 22:38:49', 'XqGdMmoZCP', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (11, '测试3', '测试3', NULL, 'BE7683834896246FBD1B2DC06A5F8152', '', '', '', '', '', '', 0, 1, '2018-09-20 22:43:25', '2018-09-20 22:43:25', 'NIsDlmGYsp', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (12, '测试4', '测试4', NULL, '8B39CBA95A1F0E3AF7761A7FE1CC5129', '', '', '', '', '', '', 0, 1, '2018-09-20 22:44:35', '2018-09-20 22:44:35', 'iRBCghmtnx', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (13, '测试5', '测试5', NULL, '684F5124A122AABA1ADFAF4C499464EA', '', '', '', '', '', '', 0, 1, '2018-09-20 22:45:27', '2018-09-20 22:45:27', 'IDBwNQWekO', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (14, '测试6', '测试6', NULL, '4BF080A8FCE59842EDCCA55578BC1B75', '', '', '', '', '', '', 0, 1, '2018-09-20 22:47:12', '2018-09-20 22:47:12', 'MRERIrBYiW', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (15, '测试7', '测试7', NULL, 'C6398CD99960E5609B29E8D0D139E1C2', '', '', '', '', '', '', 0, 1, '2018-09-20 22:51:06', '2018-09-20 22:51:06', 'PUlxoEQEkE', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (16, '测试8', '测试8', NULL, '1AF0F97D2DD05E980263446EF98B7641', '', '', '', '', '', '', 0, 1, '2018-09-20 22:54:19', '2018-09-20 22:54:19', 'ffQTGsvwfv', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (17, '测试9', '测试9', NULL, 'AE9E57E9EC9C7FF5D404FA87D26D4CB0', '', '', '', '', '', '', 0, 1, '2018-09-20 22:59:25', '2018-09-20 22:59:25', 'QQlFXrZBPP', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (18, '测试10', '测试10', NULL, '472C7F19993E8DC8A0249086FACE9B1C', '', '', '', '', '', '', 0, 1, '2018-09-20 23:00:20', '2018-09-20 23:00:20', 'ejyipqeOVF', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (19, '测试11', '测试11', NULL, '8DE6F3B7C03361A29C4F36269D583984', '', '', '', '', '', '', 0, 1, '2018-09-20 23:02:18', '2018-09-20 23:02:18', 'TbSYOUoxPI', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (20, '测试12', '测试12', NULL, '234A446254DFC176D32058F4DDA7E428', '', '', '', '', '', '', 0, 1, '2018-09-20 23:03:25', '2018-09-20 23:03:25', 'OCeCjPhPxn', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (21, '测试13', '测试13', NULL, '1D65299581575A724299B45936CE8D4D', '', '', '', '', '', '', 0, 1, '2018-09-20 23:05:16', '2018-09-20 23:05:16', 'XXDzFwkfMt', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (22, '测试14', '测试14', NULL, '611F7EAC29F35BDB85B482CC51D01B7D', '', '', '', '', '', '', 0, 1, '2018-09-20 23:06:41', '2018-09-20 23:06:41', 'VusvkpWyWB', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (23, '测试15', '测试15', NULL, '588DF7B8CDEB4042876C2B0187AEA91B', '', '', '', '', '', '', 0, 0, '2018-09-20 23:07:19', '2018-09-20 23:07:19', 'EGueVNoiGI', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (24, '测试16', '测试16', NULL, '4BB087332466341056F8E7EC82B49296', '', '', '', '', '', '', 0, 1, '2018-09-20 23:10:34', '2018-11-12 10:43:40', 'ESQEMCQwxh', '127.0.0.1', '', NULL, NULL, 0);
INSERT INTO `tb_supplier_info` VALUES (25, '利圆', 'liyuan', NULL, 'C2125AE64D16D8C2886ACD1AE38A51E3', '057699886677', '13512341234', '台州路桥', '125899', '057699886677', '125899@qq.com', 0, 3, '2018-11-13 10:13:10', '2018-11-13 10:13:10', 'PniuFidquW', '127.0.0.1', '测试测试数据中', NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_warehouse_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_warehouse_info`;
CREATE TABLE `tb_warehouse_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `war_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `war_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `war_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `war_add` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `war_qq` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'QQ',
  `war_location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '位置',
  `war_explain` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_warehouse_info
-- ----------------------------
INSERT INTO `tb_warehouse_info` VALUES (1, '13仓库', '059183261633', '13078941234', '测试数据 ', '123999', '123456', '测试数据 ');
INSERT INTO `tb_warehouse_info` VALUES (2, '12仓库', '059183260000', '13065470000', '仓库1234', '968112', '1236', '说明');
INSERT INTO `tb_warehouse_info` VALUES (3, '9号仓库', '059186549999', '13012345678', '福建省福州市台江区', '66589', '0', '测试数据');
INSERT INTO `tb_warehouse_info` VALUES (4, '7号仓库', '059177889966', '13566334477', '', '', '', '');
INSERT INTO `tb_warehouse_info` VALUES (5, '5号仓库', '059133335566', '', '', '', '', '');

SET FOREIGN_KEY_CHECKS = 1;
