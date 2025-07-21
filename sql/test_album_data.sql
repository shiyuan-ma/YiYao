-- 测试相册数据
-- 先删除可能存在的测试数据
DELETE FROM photo_album WHERE id >= 1;

-- 插入测试相册数据
INSERT INTO photo_album (id, album_name, description, cover_image, photo_count, create_by, create_time, update_by, update_time, remark) 
VALUES 
(1, '默认相册', '系统默认相册，用于存放上传的照片', NULL, 0, 'admin', NOW(), 'admin', NOW(), '系统默认相册'),
(2, '风景照片', '美丽的风景照片收集', NULL, 0, 'admin', NOW(), 'admin', NOW(), '风景照片相册'),
(3, '生活随拍', '日常生活照片记录', NULL, 0, 'admin', NOW(), 'admin', NOW(), '生活随拍相册');

-- 检查插入结果
SELECT * FROM photo_album;