package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PhotoAlbumMapper;
import com.ruoyi.system.mapper.PhotoInfoMapper;
import com.ruoyi.system.domain.PhotoAlbum;
import com.ruoyi.system.service.IPhotoAlbumService;

/**
 * 相册管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@Service
public class PhotoAlbumServiceImpl implements IPhotoAlbumService 
{
    @Autowired
    private PhotoAlbumMapper photoAlbumMapper;

    @Autowired
    private PhotoInfoMapper photoInfoMapper;

    /**
     * 查询相册管理
     * 
     * @param id 相册管理主键
     * @return 相册管理
     */
    @Override
    public PhotoAlbum selectPhotoAlbumById(Long id)
    {
        return photoAlbumMapper.selectPhotoAlbumById(id);
    }

    /**
     * 查询相册管理列表
     * 
     * @param photoAlbum 相册管理
     * @return 相册管理
     */
    @Override
    public List<PhotoAlbum> selectPhotoAlbumList(PhotoAlbum photoAlbum)
    {
        return photoAlbumMapper.selectPhotoAlbumList(photoAlbum);
    }

    /**
     * 新增相册管理
     * 
     * @param photoAlbum 相册管理
     * @return 结果
     */
    @Override
    public int insertPhotoAlbum(PhotoAlbum photoAlbum)
    {
        photoAlbum.setCreateTime(DateUtils.getNowDate());
        return photoAlbumMapper.insertPhotoAlbum(photoAlbum);
    }

    /**
     * 修改相册管理
     * 
     * @param photoAlbum 相册管理
     * @return 结果
     */
    @Override
    public int updatePhotoAlbum(PhotoAlbum photoAlbum)
    {
        photoAlbum.setUpdateTime(DateUtils.getNowDate());
        return photoAlbumMapper.updatePhotoAlbum(photoAlbum);
    }

    /**
     * 批量删除相册管理
     * 
     * @param ids 需要删除的相册管理主键
     * @return 结果
     */
    @Override
    public int deletePhotoAlbumByIds(Long[] ids)
    {
        return photoAlbumMapper.deletePhotoAlbumByIds(ids);
    }

    /**
     * 删除相册管理信息
     * 
     * @param id 相册管理主键
     * @return 结果
     */
    @Override
    public int deletePhotoAlbumById(Long id)
    {
        return photoAlbumMapper.deletePhotoAlbumById(id);
    }

    /**
     * 更新相册照片数量
     * 
     * @param albumId 相册ID
     * @return 结果
     */
    @Override
    public int updatePhotoCount(Long albumId)
    {
        int count = photoInfoMapper.countPhotoByAlbumId(albumId);
        return photoAlbumMapper.updatePhotoCount(albumId, count);
    }
}