-- 为照片表添加重复检查功能的数据库更新脚本

-- 1. 检查并添加 file_hash 字段（如果不存在的话）
ALTER TABLE photo_info 
ADD COLUMN IF NOT EXISTS file_hash VARCHAR(64) COMMENT '文件SHA256哈希值';

-- 2. 为 (album_id, file_hash) 创建唯一索引，防止重复文件
CREATE UNIQUE INDEX IF NOT EXISTS uk_album_file_hash ON photo_info(album_id, file_hash);

-- 3. 为 file_hash 字段创建普通索引，提高查询性能
CREATE INDEX IF NOT EXISTS idx_photo_file_hash ON photo_info(file_hash);

-- 4. 为 album_id 创建索引（如果不存在），提高相册查询性能
CREATE INDEX IF NOT EXISTS idx_photo_album_id ON photo_info(album_id);

-- 5. 为 upload_time 创建索引，提高按时间排序的查询性能
CREATE INDEX IF NOT EXISTS idx_photo_upload_time ON photo_info(upload_time);

-- 6. 查看表结构，确认字段和索引
DESCRIBE photo_info;

-- 7. 查看索引信息
SHOW INDEX FROM photo_info;

-- 8. 统计当前数据情况
SELECT 
    COUNT(*) as total_photos,
    COUNT(DISTINCT album_id) as total_albums,
    COUNT(file_hash) as photos_with_hash,
    COUNT(*) - COUNT(file_hash) as photos_without_hash
FROM photo_info;

-- 9. 如果有现有数据没有哈希值，可以运行以下查询查看
SELECT id, album_id, original_name, file_hash 
FROM photo_info 
WHERE file_hash IS NULL OR file_hash = ''
LIMIT 10;