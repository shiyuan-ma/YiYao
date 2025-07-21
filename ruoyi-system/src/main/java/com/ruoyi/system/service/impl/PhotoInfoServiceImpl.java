package com.ruoyi.system.service.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.system.mapper.PhotoInfoMapper;
import com.ruoyi.system.domain.PhotoInfo;
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
        String filePath = RuoYiConfig.getUploadPath();
        
        for (MultipartFile file : files)
        {
            try
            {
                // 上传文件
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                
                // 获取图片尺寸
                BufferedImage image = ImageIO.read(file.getInputStream());
                int width = image != null ? image.getWidth() : 0;
                int height = image != null ? image.getHeight() : 0;
                
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
}