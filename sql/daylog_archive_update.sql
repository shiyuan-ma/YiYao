-- 为日报表添加归档字段（如果不存在的话）
-- 检查并添加 archived 字段
ALTER TABLE daylog 
ADD COLUMN IF NOT EXISTS archived INT(1) DEFAULT 0 COMMENT '是否归档 (0=正常 1=已归档)';

-- 为已存在的数据设置默认值
UPDATE daylog SET archived = 0 WHERE archived IS NULL;

-- 创建索引以提高查询性能
CREATE INDEX IF NOT EXISTS idx_daylog_archived ON daylog(archived);
CREATE INDEX IF NOT EXISTS idx_daylog_time ON daylog(time);

-- 查看表结构
DESCRIBE daylog;