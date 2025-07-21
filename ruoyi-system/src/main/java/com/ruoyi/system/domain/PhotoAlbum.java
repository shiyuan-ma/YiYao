package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 相册管理对象 photo_album
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public class PhotoAlbum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 相册ID */
    private Long id;

    /** 相册名称 */
    @Excel(name = "相册名称")
    private String albumName;

    /** 相册描述 */
    @Excel(name = "相册描述")
    private String description;

    /** 封面图片 */
    @Excel(name = "封面图片")
    private String coverImage;

    /** 照片数量 */
    @Excel(name = "照片数量")
    private Integer photoCount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAlbumName(String albumName) 
    {
        this.albumName = albumName;
    }

    public String getAlbumName() 
    {
        return albumName;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setCoverImage(String coverImage) 
    {
        this.coverImage = coverImage;
    }

    public String getCoverImage() 
    {
        return coverImage;
    }
    public void setPhotoCount(Integer photoCount) 
    {
        this.photoCount = photoCount;
    }

    public Integer getPhotoCount() 
    {
        return photoCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("albumName", getAlbumName())
            .append("description", getDescription())
            .append("coverImage", getCoverImage())
            .append("photoCount", getPhotoCount())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}