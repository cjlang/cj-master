/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7-3306
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : cj-db

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 17/09/2022 12:48:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cj_dict
-- ----------------------------
DROP TABLE IF EXISTS `cj_dict`;
CREATE TABLE `cj_dict` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '字典编码',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '字典名称',
  `order_num` int(11) NOT NULL DEFAULT '999' COMMENT '排序',
  `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '创建者',
  `update_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='数据字典';

-- ----------------------------
-- Table structure for cj_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `cj_dict_item`;
CREATE TABLE `cj_dict_item` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_id` bigint(64) NOT NULL DEFAULT '1' COMMENT '字典类型ID',
  `code` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '字典编码',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '字典名称',
  `order_num` int(11) NOT NULL DEFAULT '999' COMMENT '排序',
  `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='数据字典-子项';

-- ----------------------------
-- Table structure for cj_global_config
-- ----------------------------
DROP TABLE IF EXISTS `cj_global_config`;
CREATE TABLE `cj_global_config` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '配置组',
  `config_name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '配置项名称',
  `config_value` text COLLATE utf8mb4_bin NOT NULL COMMENT '配置值',
  `active` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否启用',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统全局配置';

-- ----------------------------
-- Records of cj_global_config
-- ----------------------------
BEGIN;
INSERT INTO `cj_global_config` VALUES (13, 'system', 'desktop-menu', '[{\"menuCode\":\"recycleBin100\",\"iconColor\":\"#FF0000\",\"menuName\":\"垃圾箱\",\"urlPath\":\"recyclebin\",\"component\":\"\",\"imgOrIcon\":\"image\",\"Inx\":1,\"imgUrl\":\"/web/static/img/rcani.011e16a5.png\",\"layerX\":20,\"layerY\":20}]', 0, '2022-09-13 13:37:11', 0, 0, '2022-09-13 14:26:23', 0);
INSERT INTO `cj_global_config` VALUES (14, 'system', 'loginBg', '1', 0, '2022-09-14 01:57:59', 0, 0, '2022-09-16 13:40:28', 0);
COMMIT;

-- ----------------------------
-- Table structure for cj_log
-- ----------------------------
DROP TABLE IF EXISTS `cj_log`;
CREATE TABLE `cj_log` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bll_module` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '模块名',
  `session_id` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '会话ID',
  `thread_id` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '线程ID',
  `calss_info` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '类信息',
  `content` text COLLATE utf8mb4_bin COMMENT '日志内容',
  `log_time` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '精确到毫秒',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=979 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='业务日志';

-- ----------------------------
-- Table structure for cj_menu
-- ----------------------------
DROP TABLE IF EXISTS `cj_menu`;
CREATE TABLE `cj_menu` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '类型：1目录，2菜单，3权限,4，系统菜单',
  `menu_code` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '菜单编码，权限标识,menuCode',
  `pid` bigint(64) NOT NULL DEFAULT '0' COMMENT '父ID',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '菜单层级',
  `menu_name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '菜单名称，权限名称，目录名称,menuName',
  `url_path` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '菜单路径',
  `component` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '组件路径',
  `iframe` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否外链接：0否1是',
  `iframe_path` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '外链接路径',
  `icon` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '图标',
  `layer_x` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'X位置',
  `layer_y` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'Y位置',
  `width` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '窗口宽度',
  `height` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '窗口高度',
  `min_width` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '最小宽度',
  `min_height` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '最小高度',
  `sys_window` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否系统窗口：0否1是',
  `icon_color` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '图标颜色',
  `img_or_icon` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT 'image' COMMENT '图片还是图标：image 或者 icon',
  `img_url` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '图片路径',
  `span` tinyint(4) NOT NULL DEFAULT '1' COMMENT '横跨列',
  `order_num` int(11) NOT NULL DEFAULT '0' COMMENT '菜单排序',
  `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '创建者',
  `update_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统菜单';

-- ----------------------------
-- Records of cj_menu
-- ----------------------------
BEGIN;
INSERT INTO `cj_menu` VALUES (79, 1, '', 0, 0, '系统窗口', '', '', 0, '', '', '', '', '', '', '', '', 1, '', 'image', '', 1, 1, '', '2022-09-12 01:58:57', 0, 0, '2022-09-12 01:58:57', 0);
INSERT INTO `cj_menu` VALUES (80, 1, '', 0, 0, '基础管理', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'image', '', 1, 2, '', '2022-09-12 01:59:14', 0, 0, '2022-09-12 01:59:14', 0);
INSERT INTO `cj_menu` VALUES (81, 1, '', 0, 0, '权限管理', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'image', '', 1, 2, '', '2022-09-12 01:59:25', 0, 0, '2022-09-12 01:59:25', 1);
INSERT INTO `cj_menu` VALUES (82, 2, 'system_setting', 79, 1, '系统设置', 'system_setting', 'sys/setting/sysconfig/index.vue', 0, '', '', '', '', '', '', '', '', 1, 'rgba(214, 214, 214, 1)', 'image', '3', 1, 1, '', '2022-09-12 09:40:14', 0, 0, '2022-09-12 09:40:14', 0);
INSERT INTO `cj_menu` VALUES (83, 2, 'systeminfo', 80, 1, '系统信息', 'systeminfo', 'sys/setting/info.vue', 0, '', '', '', '', '', '', '', '', 0, '', 'image', '4', 1, 1, '', '2022-09-12 14:55:02', 0, 0, '2022-09-12 14:55:02', 0);
INSERT INTO `cj_menu` VALUES (84, 2, 'userinfo', 80, 1, '用户管理名字超级长', 'userinfo', 'sys/userList.vue', 0, '', '', '', '', '', '', '', '', 0, 'rgba(1, 204, 255, 1)', 'icon', '5', 1, 2, '', '2022-09-16 02:19:40', 0, 0, '2022-09-16 02:19:40', 0);
INSERT INTO `cj_menu` VALUES (85, 2, 'roleinfo', 80, 1, '角色管理', 'roleinfo', 'sys/roleList.vue', 0, '', '', '', '', '', '', '', '', 0, '', 'image', '2', 1, 3, '', '2022-09-12 12:07:09', 0, 0, '2022-09-12 12:07:09', 0);
INSERT INTO `cj_menu` VALUES (86, 2, 'menuinfo', 80, 1, '菜单管理', 'menuinfo', 'sys/menu/index.vue', 0, '', '', '', '', '', '', '', '', 0, '', 'image', '6', 1, 4, '', '2022-09-12 14:52:08', 0, 0, '2022-09-12 14:52:08', 0);
INSERT INTO `cj_menu` VALUES (87, 2, '', 79, 1, '主题设置', '', '', 0, '', '', '', '', '', '', '', '', 1, '', 'image', '2', 1, 1, '', '2022-09-12 12:20:08', 0, 0, '2022-09-12 12:20:08', 1);
INSERT INTO `cj_menu` VALUES (88, 2, '', 81, 1, '角色赋予', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'image', '5', 1, 1, '', '2022-09-13 00:47:53', 0, 0, '2022-09-13 00:47:53', 1);
INSERT INTO `cj_menu` VALUES (94, 1, '', 0, 0, 'awdad', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'image', '', 1, 1, '', '2022-09-16 13:39:52', 0, 0, '2022-09-16 13:39:52', 0);
INSERT INTO `cj_menu` VALUES (95, 1, '', 0, 0, 'awdadqw', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'image', '', 1, 1, '', '2022-09-16 13:39:54', 0, 0, '2022-09-16 13:39:54', 0);
COMMIT;

-- ----------------------------
-- Table structure for cj_role
-- ----------------------------
DROP TABLE IF EXISTS `cj_role`;
CREATE TABLE `cj_role` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '角色编码',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '角色名称',
  `type` char(1) COLLATE utf8mb4_bin NOT NULL DEFAULT '2' COMMENT '类型1:系统角色2:业务角色3:机构角色',
  `order_num` int(11) NOT NULL DEFAULT '999' COMMENT '角色排序',
  `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '创建者',
  `update_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户角色';

-- ----------------------------
-- Records of cj_role
-- ----------------------------
BEGIN;
INSERT INTO `cj_role` VALUES (1, 'mycode', '我的角色', '2', 999, '', '2022-08-30 02:28:14', 2, 2, '2022-08-30 02:28:14', 0);
COMMIT;

-- ----------------------------
-- Table structure for cj_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `cj_role_menu`;
CREATE TABLE `cj_role_menu` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(64) NOT NULL DEFAULT '2' COMMENT '角色id',
  `menu_id` bigint(64) NOT NULL DEFAULT '1' COMMENT '菜单id',
  `create_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '创建者',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色菜单关系';

-- ----------------------------
-- Records of cj_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `cj_role_menu` VALUES (1, 1, 1, 2, '2022-08-30 02:32:27', 2, '2022-08-30 02:32:27', 0);
COMMIT;

-- ----------------------------
-- Table structure for cj_user
-- ----------------------------
DROP TABLE IF EXISTS `cj_user`;
CREATE TABLE `cj_user` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `real_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '真实姓名',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 1:正常，0:禁用',
  `pwd_expire_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '密码过期时间',
  `last_pwd_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后密码修改时间',
  `last_login_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `last_login_ip` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '最后登录ip',
  `org_id` bigint(64) NOT NULL DEFAULT '1' COMMENT '机构id',
  `create_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '创建者',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息';

-- ----------------------------
-- Records of cj_user
-- ----------------------------
BEGIN;
INSERT INTO `cj_user` VALUES (5, 'admin', '123456', '管理员', 1, '2022-10-18 04:00:00', '2022-07-22 06:39:45', '2022-07-22 06:39:45', '', 0, 0, '2022-07-22 06:39:45', 0, '2022-07-22 06:39:45', 0);
INSERT INTO `cj_user` VALUES (6, 'lcj', '123456', '郎朝金', 1, '2022-10-18 04:00:00', '2022-07-22 07:12:47', '2022-07-22 07:12:47', '', 1, 1, '2022-07-22 07:12:47', 1, '2022-07-22 07:12:47', 0);
INSERT INTO `cj_user` VALUES (7, 'lang', '123123', 'langchoajin', 0, '2022-07-22 08:02:24', '2022-07-22 08:02:24', '2022-07-22 08:02:24', '', 0, 0, '2022-07-22 08:02:24', 0, '2022-07-22 08:02:24', 0);
COMMIT;

-- ----------------------------
-- Table structure for cj_user_config
-- ----------------------------
DROP TABLE IF EXISTS `cj_user_config`;
CREATE TABLE `cj_user_config` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户',
  `group_name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '配置组',
  `config_name` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '配置项名称',
  `config_value` text COLLATE utf8mb4_bin NOT NULL COMMENT '配置值',
  `active` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否启用',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_by` bigint(64) NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户个性化配置';

-- ----------------------------
-- Records of cj_user_config
-- ----------------------------
BEGIN;
INSERT INTO `cj_user_config` VALUES (3, 'admin', 'system', 'desktopBg', '6', 0, '2022-09-14 02:30:26', 0, 0, '2022-09-16 13:40:22', 0);
INSERT INTO `cj_user_config` VALUES (4, 'admin', 'system', 'themeColor', '#0095FF', 0, '2022-09-14 02:35:47', 0, 0, '2022-09-15 09:17:12', 0);
INSERT INTO `cj_user_config` VALUES (5, 'admin', 'system', 'topWindowColor', 'rgba(83, 162, 245, 1)', 0, '2022-09-14 02:38:55', 0, 0, '2022-09-15 03:51:43', 0);
INSERT INTO `cj_user_config` VALUES (6, 'admin', 'system', 'startMenuBg', '3', 0, '2022-09-14 03:00:05', 0, 0, '2022-09-16 02:55:13', 0);
INSERT INTO `cj_user_config` VALUES (7, 'admin', 'system', 'startPureColor', '0', 0, '2022-09-14 03:13:30', 0, 0, '2022-09-16 02:55:12', 0);
INSERT INTO `cj_user_config` VALUES (8, 'admin', 'system', 'startMenuLeftColor', 'rgba(0, 0, 0, 0.57)', 0, '2022-09-14 03:14:06', 0, 0, '2022-09-14 05:09:51', 0);
INSERT INTO `cj_user_config` VALUES (9, 'admin', 'system', 'noticePanelColor', 'rgba(0, 0, 0, 0.52)', 0, '2022-09-14 03:57:24', 0, 0, '2022-09-16 02:50:59', 0);
INSERT INTO `cj_user_config` VALUES (10, 'admin', 'system', 'bottomTaskColor', 'rgba(0, 0, 0, 0.5)', 0, '2022-09-14 03:57:31', 0, 0, '2022-09-14 05:09:28', 0);
INSERT INTO `cj_user_config` VALUES (11, 'admin', 'system', 'moreFuncColor', 'rgba(68, 68, 68, 0.55)', 0, '2022-09-14 03:57:35', 0, 0, '2022-09-16 02:50:48', 0);
INSERT INTO `cj_user_config` VALUES (12, 'admin', 'system', 'startMenuCenterColor', 'rgba(0, 0, 0, 0.46)', 0, '2022-09-14 05:09:36', 0, 0, '2022-09-14 05:10:04', 0);
INSERT INTO `cj_user_config` VALUES (13, 'admin', 'system', 'startMenuRightColor', 'rgba(0, 0, 0, 0.56)', 0, '2022-09-14 05:09:42', 0, 0, '2022-09-14 05:10:08', 0);
INSERT INTO `cj_user_config` VALUES (14, 'lcj', 'system', 'desktopMenu', '[{\"menuCode\":\"recycleBin100\",\"iconColor\":\"#FF0000\",\"menuName\":\"垃圾箱\",\"urlPath\":\"recyclebin\",\"component\":\"\",\"imgOrIcon\":\"image\",\"Inx\":1,\"imgUrl\":\"/web/static/img/rcani.011e16a5.png\",\"layerX\":20,\"layerY\":20},{\"id\":\"84\",\"type\":2,\"menuCode\":\"userinfo\",\"pid\":80,\"level\":1,\"menuName\":\"用户管理\",\"urlPath\":\"userinfo\",\"component\":\"sys/userList.vue\",\"iframe\":0,\"iframePath\":\"\",\"icon\":\"\",\"layerX\":20,\"layerY\":100,\"width\":\"\",\"height\":\"\",\"minWidth\":\"\",\"minHeight\":\"\",\"sysWindow\":0,\"iconColor\":\"\",\"imgOrIcon\":\"image\",\"imgUrl\":\"/web/static/img/5.3ef0a40b.png\",\"span\":1,\"orderNum\":2,\"remark\":\"\",\"createDate\":\"2022-09-12 20:06:34\",\"createBy\":0,\"updateBy\":0,\"updateDate\":\"2022-09-12 20:06:34\",\"delFlag\":0,\"children\":null,\"Inx\":2,\"imgUrlName\":\"5\"}]', 0, '2022-09-14 09:13:38', 0, 0, '2022-09-15 01:40:14', 0);
INSERT INTO `cj_user_config` VALUES (15, 'admin', 'system', 'unActiveWindowColor', 'rgba(198, 198, 198, 0.87)', 0, '2022-09-15 03:51:30', 0, 0, '2022-09-15 03:51:30', 0);
INSERT INTO `cj_user_config` VALUES (16, 'admin', 'system', 'manualOrderIcon', '0', 0, '2022-09-16 06:57:26', 0, 0, '2022-09-16 13:39:24', 0);
INSERT INTO `cj_user_config` VALUES (18, 'admin', 'system', 'desktopMenu', '[{\"menuCode\":\"recycleBin100\",\"iconColor\":\"#FF0000\",\"menuName\":\"垃圾箱\",\"urlPath\":\"recyclebin\",\"component\":\"\",\"imgOrIcon\":\"image\",\"Inx\":1,\"imgUrl\":\"/web/static/img/rcani.011e16a5.png\"},{\"id\":\"86\",\"type\":2,\"menuCode\":\"menuinfo\",\"pid\":80,\"level\":1,\"menuName\":\"菜单管理\",\"urlPath\":\"menuinfo\",\"component\":\"sys/menu/index.vue\",\"iframe\":0,\"iframePath\":\"\",\"icon\":\"\",\"layerX\":20,\"layerY\":100,\"width\":\"\",\"height\":\"\",\"minWidth\":\"\",\"minHeight\":\"\",\"sysWindow\":0,\"iconColor\":\"\",\"imgOrIcon\":\"image\",\"imgUrl\":\"/web/static/img/6.ef5776d9.png\",\"span\":1,\"orderNum\":4,\"remark\":\"\",\"createDate\":\"2022-09-12 22:52:08\",\"createBy\":0,\"updateBy\":0,\"updateDate\":\"2022-09-12 22:52:08\",\"delFlag\":0,\"children\":null,\"Inx\":2,\"imgUrlName\":\"6\"},{\"id\":\"85\",\"type\":2,\"menuCode\":\"roleinfo\",\"pid\":80,\"level\":1,\"menuName\":\"角色管理\",\"urlPath\":\"roleinfo\",\"component\":\"sys/roleList.vue\",\"iframe\":0,\"iframePath\":\"\",\"icon\":\"\",\"layerX\":20,\"layerY\":180,\"width\":\"\",\"height\":\"\",\"minWidth\":\"\",\"minHeight\":\"\",\"sysWindow\":0,\"iconColor\":\"\",\"imgOrIcon\":\"image\",\"imgUrl\":\"/web/static/img/2.51317a70.png\",\"span\":1,\"orderNum\":3,\"remark\":\"\",\"createDate\":\"2022-09-12 20:07:09\",\"createBy\":0,\"updateBy\":0,\"updateDate\":\"2022-09-12 20:07:09\",\"delFlag\":0,\"children\":null,\"Inx\":3,\"imgUrlName\":\"2\"}]', 0, '2022-09-16 13:39:01', 0, 0, '2022-09-16 13:39:05', 0);
COMMIT;

-- ----------------------------
-- Table structure for cj_user_role
-- ----------------------------
DROP TABLE IF EXISTS `cj_user_role`;
CREATE TABLE `cj_user_role` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(64) NOT NULL DEFAULT '1' COMMENT '用户id',
  `role_id` bigint(64) NOT NULL DEFAULT '2' COMMENT '角色id',
  `create_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '创建者',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(64) NOT NULL DEFAULT '2' COMMENT '更新者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记0:保留,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户角色关系';

-- ----------------------------
-- Records of cj_user_role
-- ----------------------------
BEGIN;
INSERT INTO `cj_user_role` VALUES (1, 5, 1, 2, '2022-08-30 02:28:34', 2, '2022-08-30 02:28:34', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
