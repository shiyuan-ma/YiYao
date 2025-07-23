-- 为photo_info表添加缩略图支持
-- 添加文件哈希字段和缩略图URL字段

-- 添加file_hash字段（用于重复文件检测）
ALTER TABLE `photo_info` ADD COLUMN `file_hash` varchar(64) DEFAULT NULL COMMENT '文件SHA256哈希值' AFTER `upload_time`;

-- 添加thumbnail_url字段（用于存储缩略图访问URL）
ALTER TABLE `photo_info` ADD COLUMN `thumbnail_url` varchar(500) DEFAULT NULL COMMENT '缩略图URL' AFTER `file_hash`;

-- 为file_hash字段添加索引，提高查询性能
ALTER TABLE `photo_info` ADD INDEX `idx_file_hash` (`file_hash`);

-- 为album_id和file_hash组合添加索引，用于重复文件检测
ALTER TABLE `photo_info` ADD INDEX `idx_album_hash` (`album_id`, `file_hash`);