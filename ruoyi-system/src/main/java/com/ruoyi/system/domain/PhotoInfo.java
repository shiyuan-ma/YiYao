package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 照片信息对象 photo_info
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public class PhotoInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 照片ID */
    private Long id;

    /** 相册ID */
    @Excel(name = "相册ID")
    private Long albumId;

    /** 照片名称 */
    @Excel(name = "照片名称")
    private String photoName;

    /** 原始文件名 */
    @Excel(name = "原始文件名")
    private String originalName;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 访问URL */
    @Excel(name = "访问URL")
    private String fileUrl;

    /** 文件大小(字节) */
    @Excel(name = "文件大小", readConverterExp = "字=节")
    private Long fileSize;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 图片宽度 */
    @Excel(name = "图片宽度")
    private Integer width;

    /** 图片高度 */
    @Excel(name = "图片高度")
    private Integer height;

    /** 上传时间 */
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date uploadTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAlbumId(Long albumId) 
    {
        this.albumId = albumId;
    }

    public Long getAlbumId() 
    {
        return albumId;
    }
    public void setPhotoName(String photoName) 
    {
        this.photoName = photoName;
    }

    public String getPhotoName() 
    {
        return photoName;
    }
    public void setOriginalName(String originalName) 
    {
        this.originalName = originalName;
    }

    public String getOriginalName() 
    {
        return originalName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }
    public void setFileSize(Long fileSize) 
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize() 
    {
        return fileSize;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setWidth(Integer width) 
    {
        this.width = width;
    }

    public Integer getWidth() 
    {
        return width;
    }
    public void setHeight(Integer height) 
    {
        this.height = height;
    }

    public Integer getHeight() 
    {
        return height;
    }
    public void setUploadTime(Date uploadTime) 
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime() 
    {
        return uploadTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("albumId", getAlbumId())
            .append("photoName", getPhotoName())
            .append("originalName", getOriginalName())
            .append("filePath", getFilePath())
            .append("fileUrl", getFileUrl())
            .append("fileSize", getFileSize())
            .append("fileType", getFileType())
            .append("width", getWidth())
            .append("height", getHeight())
            .append("uploadTime", getUploadTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}