package com.ruoyi.system.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.image.ThumbnailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.system.mapper.PhotoInfoMapper;
import com.ruoyi.system.domain.PhotoInfo;
import com.ruoyi.system.domain.UploadResult;
import com.ruoyi.system.service.IPhotoInfoService;
import com.ruoyi.system.service.IPhotoAlbumService;

/**
 * 照片信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@Service
public class PhotoInfoServiceImpl implements IPhotoInfoService 
{
    @Autowired
    private PhotoInfoMapper photoInfoMapper;

    @Autowired
    private IPhotoAlbumService photoAlbumService;

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 查询照片信息
     * 
     * @param id 照片信息主键
     * @return 照片信息
     */
    @Override
    public PhotoInfo selectPhotoInfoById(Long id)
    {
        return photoInfoMapper.selectPhotoInfoById(id);
    }

    /**
     * 查询照片信息列表
     * 
     * @param photoInfo 照片信息
     * @return 照片信息
     */
    @Override
    public List<PhotoInfo> selectPhotoInfoList(PhotoInfo photoInfo)
    {
        return photoInfoMapper.selectPhotoInfoList(photoInfo);
    }

    /**
     * 根据相册ID查询照片列表
     * 
     * @param albumId 相册ID
     * @return 照片信息集合
     */
    @Override
    public List<PhotoInfo> selectPhotoInfoByAlbumId(Long albumId)
    {
        return photoInfoMapper.selectPhotoInfoByAlbumId(albumId);
    }

    /**
     * 新增照片信息
     * 
     * @param photoInfo 照片信息
     * @return 结果
     */
    @Override
    public int insertPhotoInfo(PhotoInfo photoInfo)
    {
        photoInfo.setCreateTime(DateUtils.getNowDate());
        return photoInfoMapper.insertPhotoInfo(photoInfo);
    }

    /**
     * 修改照片信息
     * 
     * @param photoInfo 照片信息
     * @return 结果
     */
    @Override
    public int updatePhotoInfo(PhotoInfo photoInfo)
    {
        photoInfo.setUpdateTime(DateUtils.getNowDate());
        return photoInfoMapper.updatePhotoInfo(photoInfo);
    }

    /**
     * 批量删除照片信息
     * 
     * @param ids 需要删除的照片信息主键
     * @return 结果
     */
    @Override
    public int deletePhotoInfoByIds(Long[] ids)
    {
        return photoInfoMapper.deletePhotoInfoByIds(ids);
    }

    /**
     * 删除照片信息信息
     * 
     * @param id 照片信息主键
     * @return 结果
     */
    @Override
    public int deletePhotoInfoById(Long id)
    {
        return photoInfoMapper.deletePhotoInfoById(id);
    }

    /**
     * 生成缩略图
     * 
     * @param file 原始文件
     * @param fileName 原图文件名（相对路径，如：/profile/upload/2025/07/22/xxx_20250722162341A006.jpg）
     * @return 缩略图URL，如果生成失败返回null
     */
    private String generateThumbnailForFile(MultipartFile file, String fileName)
    {
        try
        {
            // 生成缩略图
            byte[] originalImageBytes = file.getBytes();
            byte[] thumbnailBytes = ThumbnailUtils.generateThumbnail(originalImageBytes);
            
            // 生成缩略图文件名（保持与原图相同的目录结构）
            String thumbnailFileName = ThumbnailUtils.generateThumbnailFileName(fileName);
            
            // 计算缩略图的物理保存路径
            // fileName格式：/profile/upload/2025/07/22/xxx_20250722162341A006.jpg
            // 需要去掉/profile前缀，得到：upload/2025/07/22/xxx_20250722162341A006.jpg
            String relativePath = fileName.substring(Constants.RESOURCE_PREFIX.length() + 1); // 去掉"/profile/"
            String thumbnailRelativePath = ThumbnailUtils.generateThumbnailFileName(relativePath);
            
            // 缩略图的完整物理路径
            String thumbnailFilePath = RuoYiConfig.getProfile() + File.separator + thumbnailRelativePath;
            File thumbnailFile = new File(thumbnailFilePath);
            
            // 确保目录存在
            thumbnailFile.getParentFile().mkdirs();
            ThumbnailUtils.saveThumbnailToFile(thumbnailBytes, thumbnailFile);
            
            // 生成缩略图访问URL
            String thumbnailUrl = serverConfig.getUrl() + thumbnailFileName;
            
            // 调试信息
            System.out.println("=== 缩略图生成调试信息 ===");
            System.out.println("原图文件名: " + fileName);
            System.out.println("原图相对路径: " + relativePath);
            System.out.println("缩略图文件名: " + thumbnailFileName);
            System.out.println("缩略图相对路径: " + thumbnailRelativePath);
            System.out.println("Profile路径: " + RuoYiConfig.getProfile());
            System.out.println("缩略图物理路径: " + thumbnailFilePath);
            System.out.println("缩略图访问URL: " + thumbnailUrl);
            System.out.println("缩略图文件是否存在: " + thumbnailFile.exists());
            if (thumbnailFile.exists()) {
                System.out.println("缩略图文件大小: " + thumbnailFile.length() + " bytes");
            }
            
            return thumbnailUrl;
        }
        catch (Exception e)
        {
            System.err.println("生成缩略图失败: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 批量上传照片
     * 
     * @param files 文件列表
     * @param albumId 相册ID
     * @return 结果
     */
    @Override
    public int batchUploadPhotos(List<MultipartFile> files, Long albumId)
    {
        int successCount = 0;
        int duplicateCount = 0;
        String filePath = RuoYiConfig.getUploadPath();
        
        for (MultipartFile file : files)
        {
            try
            {
                // 计算文件哈希值
                String fileHash = calculateFileHash(file);
                
                // 检查文件是否重复
                if (checkDuplicateFile(albumId, fileHash))
                {
                    duplicateCount++;
                    continue; // 跳过重复文件
                }
                
                // 上传文件
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                
                // 获取图片尺寸
                BufferedImage image = null;
                int width = 0;
                int height = 0;
                String thumbnailUrl = null;
                
                try
                {
                    image = ImageIO.read(file.getInputStream());
                    if (image != null)
                    {
                        width = image.getWidth();
                        height = image.getHeight();
                        
                        // 生成缩略图
                        thumbnailUrl = generateThumbnailForFile(file, fileName);
                    }
                }
                catch (Exception e)
                {
                    // 如果不是图片文件或生成缩略图失败，宽高设为0，缩略图URL为空
                    width = 0;
                    height = 0;
                    thumbnailUrl = null;
                }
                
                // 创建照片信息
                PhotoInfo photoInfo = new PhotoInfo();
                photoInfo.setAlbumId(albumId);
                photoInfo.setPhotoName(file.getOriginalFilename());
                photoInfo.setOriginalName(file.getOriginalFilename());
                photoInfo.setFilePath(fileName);
                photoInfo.setFileUrl(url);
                photoInfo.setFileSize(file.getSize());
                photoInfo.setFileType(file.getContentType());
                photoInfo.setWidth(width);
                photoInfo.setHeight(height);
                photoInfo.setUploadTime(new Date());
                photoInfo.setFileHash(fileHash); // 设置文件哈希值
                photoInfo.setThumbnailUrl(thumbnailUrl); // 设置缩略图URL
                photoInfo.setCreateBy(ShiroUtils.getLoginName());
                photoInfo.setCreateTime(new Date());
                
                // 保存到数据库
                if (insertPhotoInfo(photoInfo) > 0)
                {
                    successCount++;
                }
            }
            catch (IOException e)
            {
                // 记录错误日志，继续处理下一个文件
                e.printStackTrace();
            }
            catch (Exception e)
            {
                // 记录错误日志，继续处理下一个文件
                e.printStackTrace();
            }
        }
        
        // 更新相册照片数量
        if (successCount > 0)
        {
            photoAlbumService.updatePhotoCount(albumId);
        }
        
        return successCount;
    }

    /**
     * 检查文件是否重复
     * 
     * @param albumId 相册ID
     * @param fileHash 文件哈希值
     * @return 是否重复
     */
    @Override
    public boolean checkDuplicateFile(Long albumId, String fileHash)
    {
        return photoInfoMapper.checkDuplicateFile(albumId, fileHash) > 0;
    }

    /**
     * 根据相册ID获取所有文件哈希值
     * 
     * @param albumId 相册ID
     * @return 哈希值列表
     */
    @Override
    public List<String> getHashesByAlbumId(Long albumId)
    {
        return photoInfoMapper.selectHashesByAlbumId(albumId);
    }

    /**
     * 计算文件哈希值
     * 
     * @param file 文件
     * @return SHA256哈希值
     */
    @Override
    public String calculateFileHash(MultipartFile file)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] fileBytes = file.getBytes();
            byte[] hashBytes = digest.digest(fileBytes);
            
            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes)
            {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException | IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 批量上传照片（带详细结果）
     * 
     * @param files 文件列表
     * @param albumId 相册ID
     * @return 上传结果
     */
    @Override
    public UploadResult batchUploadPhotosWithResult(List<MultipartFile> files, Long albumId)
    {
        int successCount = 0;
        int duplicateCount = 0;
        int failedCount = 0;
        int totalCount = files.size();
        String filePath = RuoYiConfig.getUploadPath();
        
        for (MultipartFile file : files)
        {
            try
            {
                // 计算文件哈希值
                String fileHash = calculateFileHash(file);
                if (fileHash == null)
                {
                    failedCount++;
                    continue;
                }
                
                // 检查文件是否重复
                if (checkDuplicateFile(albumId, fileHash))
                {
                    duplicateCount++;
                    continue;
                }
                
                // 上传文件
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                
                // 获取图片尺寸
                BufferedImage image = null;
                int width = 0;
                int height = 0;
                String thumbnailUrl = null;
                
                try
                {
                    image = ImageIO.read(file.getInputStream());
                    if (image != null)
                    {
                        width = image.getWidth();
                        height = image.getHeight();
                        
                        // 生成缩略图
                        thumbnailUrl = generateThumbnailForFile(file, fileName);
                    }
                }
                catch (Exception e)
                {
                    // 如果不是图片文件或生成缩略图失败，宽高设为0，缩略图URL为空
                    width = 0;
                    height = 0;
                    thumbnailUrl = null;
                }
                
                // 创建照片信息
                PhotoInfo photoInfo = new PhotoInfo();
                photoInfo.setAlbumId(albumId);
                photoInfo.setPhotoName(file.getOriginalFilename());
                photoInfo.setOriginalName(file.getOriginalFilename());
                photoInfo.setFilePath(fileName);
                photoInfo.setFileUrl(url);
                photoInfo.setFileSize(file.getSize());
                photoInfo.setFileType(file.getContentType());
                photoInfo.setWidth(width);
                photoInfo.setHeight(height);
                photoInfo.setUploadTime(new Date());
                photoInfo.setFileHash(fileHash); // 设置文件哈希值
                photoInfo.setThumbnailUrl(thumbnailUrl); // 设置缩略图URL
                photoInfo.setCreateBy(ShiroUtils.getLoginName());
                photoInfo.setCreateTime(DateUtils.getNowDate());
                
                // 保存到数据库
                if (insertPhotoInfo(photoInfo) > 0)
                {
                    successCount++;
                }
                else
                {
                    failedCount++;
                }
            }
            catch (IOException e)
            {
                // 记录错误日志，继续处理下一个文件
                e.printStackTrace();
                failedCount++;
            }
            catch (Exception e)
            {
                // 记录错误日志，继续处理下一个文件
                e.printStackTrace();
                failedCount++;
            }
        }
        
        // 更新相册照片数量
        if (successCount > 0)
        {
            photoAlbumService.updatePhotoCount(albumId);
        }
        
        return new UploadResult(successCount, duplicateCount, failedCount, totalCount);
    }
}