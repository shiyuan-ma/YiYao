# 手机相册上传功能使用说明

## 功能概述

本功能为若依框架新增了完整的手机相册上传管理系统，支持：

- 📱 **手机端友好**: 专门优化的手机相册选择和上传体验
- 🖼️ **相册管理**: 创建和管理多个相册分类
- 📤 **批量上传**: 支持一次选择多张照片批量上传
- 🎨 **图片预览**: 网格式照片展示，支持点击预览
- 📊 **详细信息**: 显示图片尺寸、文件大小等详细信息
- 🗑️ **删除管理**: 支持单张或批量删除照片

## 安装步骤

### 1. 执行数据库脚本

运行 `sql/photo_album.sql` 文件中的SQL语句，这将：
- 创建相册管理表 (`photo_album`)
- 创建照片信息表 (`photo_info`) 
- 插入默认相册数据
- 添加菜单权限配置

### 2. 重启应用

重启若依应用以加载新的功能模块。

### 3. 分配权限

登录系统后，在 **系统管理 > 角色管理** 中为相应角色分配以下权限：
- `album:list:view` - 相册列表查看
- `album:list:query` - 相册查询
- `album:list:add` - 相册新增
- `album:list:edit` - 相册修改
- `album:list:remove` - 相册删除
- `album:upload:view` - 照片上传页面
- `album:upload:add` - 照片上传
- `album:upload:remove` - 照片删除

## 使用方法

### 桌面端使用

1. **访问相册管理**
   - 登录系统后，在左侧菜单找到 "相册管理"
   - 点击 "相册列表" 查看和管理相册

2. **创建相册**
   - 在相册列表页面点击 "添加" 按钮
   - 填写相册名称、描述等信息
   - 可选择上传封面图片

3. **上传照片**
   - 点击 "照片上传" 菜单
   - 选择目标相册
   - 点击上传区域选择文件或直接拖拽文件
   - 支持批量选择多张照片

### 手机端使用

1. **打开手机浏览器**
   - 访问若依系统地址
   - 登录账号

2. **选择相册上传**
   - 进入 "相册管理 > 照片上传"
   - 选择要上传到的相册

3. **从相册选择照片**
   - 点击上传按钮
   - 手机会自动打开相册选择界面
   - 可以多选照片进行批量上传
   - 支持直接拍照上传

## 技术特性

### 手机端优化
- 响应式设计，自适应手机屏幕
- 支持手机相册直接选择
- 触摸友好的操作界面
- 优化的图片展示网格

### 文件处理
- 自动获取图片尺寸信息
- 记录文件大小和类型
- 生成唯一文件名避免冲突
- 支持常见图片格式 (JPG, PNG, GIF, BMP)

### 安全性
- 基于Shiro的权限控制
- 文件类型验证
- 文件大小限制
- 防止恶意文件上传

## 文件结构

```
ruoyi-system/
├── domain/
│   ├── PhotoAlbum.java          # 相册实体类
│   └── PhotoInfo.java           # 照片实体类
├── mapper/
│   ├── PhotoAlbumMapper.java    # 相册数据访问层
│   ├── PhotoInfoMapper.java     # 照片数据访问层
│   └── xml/
│       ├── PhotoAlbumMapper.xml
│       └── PhotoInfoMapper.xml
└── service/
    ├── IPhotoAlbumService.java  # 相册服务接口
    ├── IPhotoInfoService.java   # 照片服务接口
    └── impl/
        ├── PhotoAlbumServiceImpl.java
        └── PhotoInfoServiceImpl.java

ruoyi-admin/
├── controller/album/
│   ├── PhotoAlbumController.java    # 相册控制器
│   └── PhotoUploadController.java   # 上传控制器
└── templates/album/
    ├── list.html                    # 相册列表页面
    ├── add.html                     # 新增相册页面
    ├── edit.html                    # 编辑相册页面
    └── upload.html                  # 照片上传页面

sql/
└── photo_album.sql                  # 数据库脚本
```

## 常见问题

### Q: 手机上传失败怎么办？
A: 检查以下几点：
- 确保已选择相册
- 检查网络连接
- 确认文件格式是否支持
- 查看文件大小是否超限

### Q: 如何修改上传文件大小限制？
A: 在 `application.yml` 中配置：
```yaml
spring:
  servlet:
    multipart:
      max-file-size: 10MB
      max-request-size: 100MB
```

### Q: 如何自定义上传路径？
A: 在 `application.yml` 中配置：
```yaml
ruoyi:
  profile: /path/to/upload
```

## 扩展建议

1. **图片压缩**: 可以集成图片压缩功能减少存储空间
2. **缩略图生成**: 自动生成缩略图提高加载速度
3. **图片水印**: 添加水印功能保护版权
4. **相册分享**: 实现相册分享链接功能
5. **图片标签**: 添加图片标签和搜索功能

## 技术支持

如有问题，请检查：
1. 数据库表是否正确创建
2. 权限是否正确分配
3. 文件上传路径是否可写
4. 日志文件中的错误信息

---

**开发完成时间**: 2025-07-16  
**兼容版本**: 若依 v4.8.1  
**技术栈**: Spring Boot + MyBatis + Thymeleaf + Bootstrap