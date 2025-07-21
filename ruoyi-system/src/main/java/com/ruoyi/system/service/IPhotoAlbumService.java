package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PhotoAlbum;

/**
 * 相册管理Service接口
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public interface IPhotoAlbumService 
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
     * 批量删除相册管理
     * 
     * @param ids 需要删除的相册管理主键集合
     * @return 结果
     */
    public int deletePhotoAlbumByIds(Long[] ids);

    /**
     * 删除相册管理信息
     * 
     * @param id 相册管理主键
     * @return 结果
     */
    public int deletePhotoAlbumById(Long id);

    /**
     * 更新相册照片数量
     * 
     * @param albumId 相册ID
     * @return 结果
     */
    public int updatePhotoCount(Long albumId);
}