-- 将日报管理和单位日志菜单移动到根目录（方案1：保持现有路径）

-- 1. 首先查看当前的菜单结构
SELECT menu_id, menu_name, parent_id, url, perms FROM sys_menu 
WHERE menu_name IN ('日报管理', '单位日志') OR url LIKE '%daylog%' OR url LIKE '%comment%'
ORDER BY menu_id;

-- 2. 查找并更新日报管理相关菜单
UPDATE sys_menu SET parent_id = 0, order_num = 7, icon = 'fa fa-edit' 
WHERE url = '/system/daylog' OR perms = 'system:daylog:view';

-- 3. 查找并更新单位日志相关菜单
UPDATE sys_menu SET parent_id = 0, order_num = 8, icon = 'fa fa-file-text' 
WHERE url = '/monitor/comment' OR perms = 'monitor:comment:view';

-- 4. 如果上述更新没有影响任何行，说明菜单不存在，则创建新菜单

-- 创建日报管理根菜单
INSERT INTO sys_menu (menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES ('日报管理', 0, 7, '/system/daylog', '', 'C', '0', '1', 'system:daylog:view', 'fa fa-edit', 'admin', sysdate(), '', null, '日报管理菜单')
ON DUPLICATE KEY UPDATE parent_id = 0, order_num = 7;

-- 创建单位日志根菜单
INSERT INTO sys_menu (menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, update_by, update_time, remark) 
VALUES ('单位日志', 0, 8, '/monitor/comment', '', 'C', '0', '1', 'monitor:comment:view', 'fa fa-file-text', 'admin', sysdate(), '', null, '单位日志菜单')
ON DUPLICATE KEY UPDATE parent_id = 0, order_num = 8;

-- 5. 查看更新后的根菜单结构
SELECT menu_id, menu_name, parent_id, order_num, url, icon FROM sys_menu 
WHERE parent_id = 0 
ORDER BY order_num;