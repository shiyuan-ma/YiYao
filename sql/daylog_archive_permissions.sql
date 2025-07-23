-- 为日报管理添加归档相关权限

-- 1. 添加归档权限
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark) 
SELECT '日报归档', menu_id, 4, '', '', 1, 0, 'F', '0', '0', 'system:daylog:archive', '#', 'admin', sysdate(), '', null, '日报归档权限'
FROM sys_menu WHERE menu_name = '日报管理' AND menu_type = 'C';

-- 2. 添加查看归档页面的菜单项
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark) 
SELECT '归档日报', (SELECT parent_id FROM sys_menu WHERE menu_name = '日报管理' AND menu_type = 'C'), 2, 'archived', 'system/daylog/archived', 1, 0, 'C', '0', '0', 'system:daylog:archived', 'fa fa-archive', 'admin', sysdate(), '', null, '归档日报菜单'
FROM sys_menu WHERE menu_name = '日报管理' AND menu_type = 'C';

-- 3. 为归档日报页面添加基本权限
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark) 
SELECT '归档日报查询', menu_id, 1, '', '', 1, 0, 'F', '0', '0', 'system:daylog:archived:list', '#', 'admin', sysdate(), '', null, '归档日报查询权限'
FROM sys_menu WHERE menu_name = '归档日报' AND menu_type = 'C';

-- 4. 添加恢复权限
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark) 
SELECT '日报恢复', menu_id, 2, '', '', 1, 0, 'F', '0', '0', 'system:daylog:restore', '#', 'admin', sysdate(), '', null, '日报恢复权限'
FROM sys_menu WHERE menu_name = '归档日报' AND menu_type = 'C';

-- 5. 为admin角色分配新权限（假设admin角色ID为1）
INSERT INTO sys_role_menu (role_id, menu_id) 
SELECT 1, menu_id FROM sys_menu WHERE perms IN ('system:daylog:archive', 'system:daylog:archived', 'system:daylog:archived:list', 'system:daylog:restore');

-- 查看添加的权限
SELECT menu_id, menu_name, perms, menu_type FROM sys_menu WHERE perms LIKE 'system:daylog:%' ORDER BY menu_id;