package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Daylog;
import com.ruoyi.system.service.IDaylogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // 1. 【关键修改】必须是 @Controller
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 【日报管理】Controller (前后端不分离版)
 *
 * @author ruoyi
 * @date 2025-07-04
 */
@Controller // 2. 【关键修改】将 @RestController 改为 @Controller
@RequestMapping("/system/daylog") // 3. 【关键修改】路径必须和菜单URL完全一致
public class DaylogController extends BaseController
{
    // 定义Thymeleaf模板文件所在的文件夹路径
    private String prefix = "system/daylog";

    @Autowired
    private IDaylogService daylogService;

    /**
     * 打开日报管理主页面
     */
    @RequiresPermissions("system:daylog:view")
    @GetMapping()
    public String daylog()
    {
        // 返回值 "system/daylog/daylog" 会被Thymeleaf解析为:
        // /resources/templates/system/daylog/daylog.html
        return prefix + "/daylog";
    }

    /**
     * 查询【日报管理】列表数据
     */
    @RequiresPermissions("system:daylog:list")
    @PostMapping("/list")
    @ResponseBody // 4. 【保持不变】返回数据的方法，需要单独加 @ResponseBody
    public TableDataInfo list(Daylog daylog)
    {
        startPage();
        List<Daylog> list = daylogService.selectDaylogList(daylog);
        return getDataTable(list);
    }

    /**
     * 导出【日报管理】列表
     */
    @RequiresPermissions("system:daylog:export")
    @Log(title = "日报管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Daylog daylog)
    {
        List<Daylog> list = daylogService.selectDaylogList(daylog);
        ExcelUtil<Daylog> util = new ExcelUtil<Daylog>(Daylog.class);
        return util.exportExcel(list, "日报数据");
    }

    /**
     * 打开新增【日报管理】页面
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add"; // 指向 /resources/templates/system/daylog/add.html
    }

    /**
     * 新增保存【日报管理】
     */
    @RequiresPermissions("system:daylog:add")
    @Log(title = "日报管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Daylog daylog) // 5. 【优化修改】去掉了 @RequestBody，以接收标准表单提交
    {
        return toAjax(daylogService.insertDaylog(daylog));
    }

    /**
     * 打开修改【日报管理】页面
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Daylog daylog = daylogService.selectDaylogById(id);
        mmap.put("daylog", daylog);
        return prefix + "/edit"; // 指向 /resources/templates/system/daylog/edit.html
    }

    /**
     * 修改保存【日报管理】
     */
    @RequiresPermissions("system:daylog:edit")
    @Log(title = "日报管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Daylog daylog) // 6. 【优化修改】去掉了 @RequestBody
    {
        return toAjax(daylogService.updateDaylog(daylog));
    }

//    /**
//     * 删除【日报管理】
//     */
//    @RequiresPermissions("system:daylog:remove")
//    @Log(title = "日报管理", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove") // 改为PostMapping以接收表单提交的ids
//    @ResponseBody
//    public AjaxResult remove(String ids) // ids 通常是以逗号分隔的字符串
//    {
//        return toAjax(daylogService.deleteDaylogByIds(Long.parseLong(ids)));
//    }
}
