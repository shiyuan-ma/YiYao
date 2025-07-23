package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PhotoInfo;
import com.ruoyi.system.domain.UploadResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 照片信息Service接口
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public interface IPhotoInfoService 
{
    /**
     * 查询照片信息
     * 
     * @param id 照片信息主键
     * @return 照片信息
     */
    public PhotoInfo selectPhotoInfoById(Long id);

    /**
     * 查询照片信息列表
     * 
     * @param photoInfo 照片信息
     * @return 照片信息集合
     */
    public List<PhotoInfo> selectPhotoInfoList(PhotoInfo photoInfo);

    /**
     * 根据相册ID查询照片列表
     * 
     * @param albumId 相册ID
     * @return 照片信息集合
     */
    public List<PhotoInfo> selectPhotoInfoByAlbumId(Long albumId);

    /**
     * 新增照片信息
     * 
     * @param photoInfo 照片信息
     * @return 结果
     */
    public int insertPhotoInfo(PhotoInfo photoInfo);

    /**
     * 修改照片信息
     * 
     * @param photoInfo 照片信息
     * @return 结果
     */
    public int updatePhotoInfo(PhotoInfo photoInfo);

    /**
     * 批量删除照片信息
     * 
     * @param ids 需要删除的照片信息主键集合
     * @return 结果
     */
    public int deletePhotoInfoByIds(Long[] ids);

    /**
     * 删除照片信息信息
     * 
     * @param id 照片信息主键
     * @return 结果
     */
    public int deletePhotoInfoById(Long id);

    /**
     * 批量上传照片
     * 
     * @param files 文件列表
     * @param albumId 相册ID
     * @return 结果
     */
    public int batchUploadPhotos(List<MultipartFile> files, Long albumId);

    /**
     * 批量上传照片（带详细结果）
     * 
     * @param files 文件列表
     * @param albumId 相册ID
     * @return 上传结果
     */
    public UploadResult batchUploadPhotosWithResult(List<MultipartFile> files, Long albumId);

    /**
     * 检查文件是否重复
     * 
     * @param albumId 相册ID
     * @param fileHash 文件哈希值
     * @return 是否重复
     */
    public boolean checkDuplicateFile(Long albumId, String fileHash);

    /**
     * 根据相册ID查询所有文件哈希值
     * 
     * @param albumId 相册ID
     * @return 哈希值列表
     */
    public List<String> getHashesByAlbumId(Long albumId);

    /**
     * 计算文件的SHA256哈希值
     * 
     * @param file 文件
     * @return SHA256哈希值
     */
    public String calculateFileHash(MultipartFile file);
}