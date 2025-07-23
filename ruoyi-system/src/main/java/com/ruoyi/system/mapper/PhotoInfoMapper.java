package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PhotoInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 照片信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public interface PhotoInfoMapper 
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
     * 删除照片信息
     * 
     * @param id 照片信息主键
     * @return 结果
     */
    public int deletePhotoInfoById(Long id);

    /**
     * 批量删除照片信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePhotoInfoByIds(Long[] ids);

    /**
     * 根据相册ID统计照片数量
     * 
     * @param albumId 相册ID
     * @return 照片数量
     */
    public int countPhotoByAlbumId(Long albumId);

    /**
     * 检查文件是否重复
     * 
     * @param albumId 相册ID
     * @param fileHash 文件哈希值
     * @return 重复文件数量
     */
    public int checkDuplicateFile(@Param("albumId")Long albumId, @Param("fileHash")String fileHash);

    /**
     * 根据相册ID查询所有文件哈希值
     * 
     * @param albumId 相册ID
     * @return 哈希值列表
     */
    public List<String> selectHashesByAlbumId(Long albumId);
}