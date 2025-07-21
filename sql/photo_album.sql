-- 相册管理表
DROP TABLE IF EXISTS `photo_album`;
CREATE TABLE `photo_album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '相册ID',
  `album_name` varchar(100) NOT NULL COMMENT '相册名称',
  `description` varchar(500) DEFAULT NULL COMMENT '相册描述',
  `cover_image` varchar(500) DEFAULT NULL COMMENT '封面图片',
  `photo_count` int(11) DEFAULT 0 COMMENT '照片数量',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='相册管理表';

-- 照片信息表
DROP TABLE IF EXISTS `photo_info`;
CREATE TABLE `photo_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '照片ID',
  `album_id` bigint(20) NOT NULL COMMENT '相册ID',
  `photo_name` varchar(200) NOT NULL COMMENT '照片名称',
  `original_name` varchar(200) DEFAULT NULL COMMENT '原始文件名',
  `file_path` varchar(500) NOT NULL COMMENT '文件路径',
  `file_url` varchar(500) NOT NULL COMMENT '访问URL',
  `file_size` bigint(20) DEFAULT NULL COMMENT '文件大小(字节)',
  `file_type` varchar(50) DEFAULT NULL COMMENT '文件类型',
  `width` int(11) DEFAULT NULL COMMENT '图片宽度',
  `height` int(11) DEFAULT NULL COMMENT '图片高度',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_album_id` (`album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='照片信息表';

-- 插入测试数据
INSERT INTO `photo_album` VALUES (1, '默认相册', '系统默认相册，用于存放上传的照片', NULL, 0, 'admin', NOW(), 'admin', NOW(), '系统默认相册');

-- 菜单 SQL (适配若依框架的sys_menu表结构)
-- 删除可能存在的旧菜单
DELETE FROM sys_menu WHERE menu_name IN ('相册管理', '相册列表', '照片上传') AND menu_id >= 2100;

-- 1. 主菜单：相册管理
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2100, '相册管理', 0, 6, '#', '', 'M', '0', '1', '', 'fa fa-photo', 'admin', sysdate(), '', null, '相册管理目录');

-- 2. 子菜单：相册列表
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2101, '相册列表', 2100, 1, '/album/list', '', 'C', '0', '1', 'album:list:view', 'fa fa-list', 'admin', sysdate(), '', null, '相册列表菜单');

-- 3. 子菜单：照片上传
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2102, '照片上传', 2100, 2, '/album/upload', '', 'C', '0', '1', 'album:upload:view', 'fa fa-upload', 'admin', sysdate(), '', null, '照片上传菜单');

-- 4. 按钮权限
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2103, '相册查询', 2101, 1, '#', '', 'F', '0', '1', 'album:list:query', '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2104, '相册新增', 2101, 2, '#', '', 'F', '0', '1', 'album:list:add', '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2105, '相册修改', 2101, 3, '#', '', 'F', '0', '1', 'album:list:edit', '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2106, '相册删除', 2101, 4, '#', '', 'F', '0', '1', 'album:list:remove', '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2107, '照片上传', 2102, 1, '#', '', 'F', '0', '1', 'album:upload:add', '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES (2108, '照片删除', 2102, 2, '#', '', 'F', '0', '1', 'album:upload:remove', '#', 'admin', sysdate(), '', null, '');