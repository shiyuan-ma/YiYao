package com.ruoyi.web.controller.album;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PhotoAlbum;
import com.ruoyi.system.service.IPhotoAlbumService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 相册管理Controller
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@Controller
@RequestMapping("/album/list")
public class PhotoAlbumController extends BaseController
{
    private String prefix = "album";
    
    @Autowired
    private IPhotoAlbumService photoAlbumService;

    /**
     * 相册管理页面
     */
    @RequiresPermissions("album:list:view")
    @GetMapping()
    public String list()
    {
        return prefix + "/list";
    }

    /**
     * 新增相册页面
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 修改相册页面
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PhotoAlbum photoAlbum = photoAlbumService.selectPhotoAlbumById(id);
        mmap.put("photoAlbum", photoAlbum);
        return prefix + "/edit";
    }

    /**
     * 查询相册管理列表
     */
    @RequiresPermissions("album:list:query")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PhotoAlbum photoAlbum)
    {
        startPage();
        List<PhotoAlbum> list = photoAlbumService.selectPhotoAlbumList(photoAlbum);
        return getDataTable(list);
    }

    /**
     * 导出相册管理列表
     */
    @RequiresPermissions("album:list:export")
    @Log(title = "相册管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response, PhotoAlbum photoAlbum)
    {
        List<PhotoAlbum> list = photoAlbumService.selectPhotoAlbumList(photoAlbum);
        ExcelUtil<PhotoAlbum> util = new ExcelUtil<PhotoAlbum>(PhotoAlbum.class);
        util.exportExcel(response, list, "相册管理数据");
    }

    /**
     * 获取相册管理详细信息
     */
    @RequiresPermissions("album:list:query")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(photoAlbumService.selectPhotoAlbumById(id));
    }

    /**
     * 新增相册管理
     */
    @RequiresPermissions("album:list:add")
    @Log(title = "相册管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PhotoAlbum photoAlbum)
    {
        return toAjax(photoAlbumService.insertPhotoAlbum(photoAlbum));
    }

    /**
     * 修改相册管理
     */
    @RequiresPermissions("album:list:edit")
    @Log(title = "相册管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PhotoAlbum photoAlbum)
    {
        return toAjax(photoAlbumService.updatePhotoAlbum(photoAlbum));
    }

    /**
     * 删除相册管理
     */
    @RequiresPermissions("album:list:remove")
    @Log(title = "相册管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(photoAlbumService.deletePhotoAlbumByIds(ids));
    }

    /**
     * 获取所有相册列表（用于下拉选择）
     */
    @GetMapping("/all")
    @ResponseBody
    public AjaxResult getAllAlbums()
    {
        try {
            PhotoAlbum photoAlbum = new PhotoAlbum();
            List<PhotoAlbum> list = photoAlbumService.selectPhotoAlbumList(photoAlbum);
            System.out.println("=== 相册列表调试信息 ===");
            System.out.println("查询到的相册数量: " + (list != null ? list.size() : 0));
            if (list != null && !list.isEmpty()) {
                for (PhotoAlbum album : list) {
                    System.out.println("相册ID: " + album.getId() + ", 名称: " + album.getAlbumName());
                }
            }
            return AjaxResult.success(list);
        } catch (Exception e) {
            System.err.println("获取相册列表异常: " + e.getMessage());
            e.printStackTrace();
            return AjaxResult.error("获取相册列表失败：" + e.getMessage());
        }
    }
}