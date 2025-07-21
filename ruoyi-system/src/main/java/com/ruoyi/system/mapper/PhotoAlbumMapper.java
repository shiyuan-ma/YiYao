package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.system.domain.PhotoAlbum;

/**
 * 相册管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public interface PhotoAlbumMapper 
{
    /**
     * 查询相册管理
     * 
     * @param id 相册管理主键
     * @return 相册管理
     */
    public PhotoAlbum selectPhotoAlbumById(Long id);

    /**
     * 查询相册管理列表
     * 
     * @param photoAlbum 相册管理
     * @return 相册管理集合
     */
    public List<PhotoAlbum> selectPhotoAlbumList(PhotoAlbum photoAlbum);

    /**
     * 新增相册管理
     * 
     * @param photoAlbum 相册管理
     * @return 结果
     */
    public int insertPhotoAlbum(PhotoAlbum photoAlbum);

    /**
     * 修改相册管理
     * 
     * @param photoAlbum 相册管理
     * @return 结果
     */
    public int updatePhotoAlbum(PhotoAlbum photoAlbum);

    /**
     * 删除相册管理
     * 
     * @param id 相册管理主键
     * @return 结果
     */
    public int deletePhotoAlbumById(Long id);

    /**
     * 批量删除相册管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePhotoAlbumByIds(Long[] ids);

    /**
     * 更新相册照片数量
     * 
     * @param albumId 相册ID
     * @param count 照片数量
     * @return 结果
     */
    public int updatePhotoCount(@Param("albumId") Long albumId, @Param("count") Integer count);
}