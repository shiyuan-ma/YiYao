package com.ruoyi.web.controller.album;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PhotoInfo;
import com.ruoyi.system.domain.UploadResult;
import com.ruoyi.system.service.IPhotoInfoService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 照片上传Controller
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@Controller
@RequestMapping("/album/upload")
public class PhotoUploadController extends BaseController
{
    private String prefix = "album";
    
    @Autowired
    private IPhotoInfoService photoInfoService;

    /**
     * 照片上传页面
     */
    @RequiresPermissions("album:upload:view")
    @GetMapping()
    public String upload()
    {
        return prefix + "/upload";
    }

    /**
     * 查询照片信息列表
     */
    @RequiresPermissions("album:upload:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PhotoInfo photoInfo)
    {
        startPage();
        List<PhotoInfo> list = photoInfoService.selectPhotoInfoList(photoInfo);
        return getDataTable(list);
    }


    /**
     * 查询相册里面的hash值
     * @param albumId
     * @return
     */
    @RequiresPermissions("album:upload:view")
    @GetMapping("/hashes/{albumId}")
    @ResponseBody
    public AjaxResult getPhotosAllHashes(@PathVariable("albumId") Long albumId)
    {
        List<String> hashes = photoInfoService.getHashesByAlbumId(albumId);
        return AjaxResult.success(hashes);
    }

    /**
     * 根据相册ID查询照片列表
     */
    @RequiresPermissions("album:upload:view")
    @GetMapping("/album/{albumId}")
    @ResponseBody
    public AjaxResult getPhotosByAlbumId(@PathVariable("albumId") Long albumId)
    {
        List<PhotoInfo> list = photoInfoService.selectPhotoInfoByAlbumId(albumId);
        return AjaxResult.success(list);
    }

    /**
     * 批量上传照片
     */
    @RequiresPermissions("album:upload:add")
    @Log(title = "照片上传", businessType = BusinessType.INSERT)
    @PostMapping("/batch")
    @ResponseBody
    public AjaxResult batchUpload(@RequestParam("files") List<MultipartFile> files, 
                                  @RequestParam(value = "albumId", required = false) String albumIdStr)
    {
        if (files == null || files.isEmpty())
        {
            return AjaxResult.error("请选择要上传的文件");
        }
        
        if (albumIdStr == null || albumIdStr.trim().isEmpty() || "null".equals(albumIdStr))
        {
            return AjaxResult.error("请选择相册");
        }
        
        Long albumId;
        try {
            albumId = Long.parseLong(albumIdStr);
        } catch (NumberFormatException e) {
            return AjaxResult.error("相册ID格式错误");
        }
        
        // 调用批量上传服务，返回上传结果
        UploadResult result = photoInfoService.batchUploadPhotosWithResult(files, albumId);
        
        if (result.getSuccessCount() > 0)
        {
            String message = "成功上传 " + result.getSuccessCount() + " 个文件";
            if (result.getDuplicateCount() > 0)
            {
                message += "，跳过 " + result.getDuplicateCount() + " 个重复文件";
            }
            if (result.getFailedCount() > 0)
            {
                message += "，" + result.getFailedCount() + " 个文件上传失败";
            }
            return AjaxResult.success(message);
        }
        else if (result.getDuplicateCount() > 0)
        {
            return AjaxResult.error("所有文件都已存在，跳过 " + result.getDuplicateCount() + " 个重复文件");
        }
        else
        {
            return AjaxResult.error("上传失败");
        }
    }

    /**
     * 删除照片信息
     */
    @RequiresPermissions("album:upload:remove")
    @Log(title = "照片信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(photoInfoService.deletePhotoInfoByIds(ids));
    }

    /**
     * 获取照片详细信息
     */
    @RequiresPermissions("album:upload:view")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(photoInfoService.selectPhotoInfoById(id));
    }
}