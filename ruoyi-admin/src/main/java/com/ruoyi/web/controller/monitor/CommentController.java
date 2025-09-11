package com.ruoyi.web.controller.monitor;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.czdb.DbSearcher;
import com.ruoyi.common.utils.czdb.IpSearcher;
import com.ruoyi.common.utils.czdb.QueryType;
import com.ruoyi.common.utils.czdb.exception.IpFormatException;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Comment; // 假设您的Comment实体在system模块
import com.ruoyi.system.enumn.AccountEnum;
import com.ruoyi.system.service.ICommentService; // 假设您的Service在system模块
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // 1. 【关键修改】@Controller
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import static com.ruoyi.common.enums.DataSourceType.SLAVE;

/**
 * 单位日志表 Controller (前后端不分离版)
 *
 * @author ruoyi
 */
@Controller // 2. 【关键修改】使用 @Controller
@RequestMapping("/monitor/comment") // 3. 定义基础URL
@DataSource(SLAVE) // 指定使用从数据源
public class CommentController extends BaseController {

    private String prefix = "monitor/comment"; // 4. Thymeleaf模板路径前缀

    @Autowired
    private ICommentService commentService;
    @Autowired
    private IpSearcher ipSearcher;

    // 5. 【新增方法】返回主页面
    @RequiresPermissions("monitor:comment:view")
    @GetMapping()
    public String comment() {
        return prefix + "/comment";
    }

    // 6. 【修改后】查询列表数据的方法，必须加 @ResponseBody
    @RequiresPermissions("monitor:comment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Comment comment) {
        startPage();
        comment.setUserName(AccountEnum.getIdByRemark(comment.getUserName()));
        List<Comment> list = commentService.selectCommentList(comment);
        for (Comment comment1 : list) {
            String userId = comment1.getUserName(); // 你调用的方法
            String remark = AccountEnum.getRemarkById(userId);
            comment1.setUserName(remark); // 直接修改对象属性，而不是把对象放入新List

            String newFormat = ipSearcher.searchIpAddress(comment1.getIp());
            comment1.setIp(newFormat);
        }
        // 您原来的转换逻辑可以保留
        return getDataTable(list);
    }

    // 7. 【修改后】导出方法，必须加 @ResponseBody
    @Log(title = "单位日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("monitor:comment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Comment comment) {
        // 应用查询条件时的用户名转换
        if (comment.getUserName() != null && !comment.getUserName().isEmpty()) {
            comment.setUserName(AccountEnum.getIdByRemark(comment.getUserName()));
        }
        
        List<Comment> list = commentService.selectCommentList(comment);
        
        // 导出前进行用户名转换（从ID转换为可读名称）
        for (Comment comment1 : list) {
            String userId = comment1.getUserName();
            if (userId != null && !userId.isEmpty()) {
                String remark = AccountEnum.getRemarkById(userId);
                comment1.setUserName(remark);
            }
        }
        
        ExcelUtil<Comment> util = new ExcelUtil<Comment>(Comment.class);
        return util.exportExcel(list, "单位日志数据");
    }


    /**
     * 返回新增页面 (保持不变)
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }
    /**
     * 新增保存 (【关键修改】采用您指定的签名)
     */
    @RequiresPermissions("monitor:comment:add")
    @Log(title = "单位日志", businessType = BusinessType.INSERT)
    @PostMapping("/add") // URL 保持 /add
    @ResponseBody
    public AjaxResult addSave(@RequestParam("content") String logContent,
                              @RequestParam("topicId") String topicIdStr,
                              @RequestParam("postTime") String postTimeStr,
                              @RequestParam("userName") String logPerson, // 表单字段名为 userName
                              HttpServletRequest request)
    {
        // 调用Service层，Service层会返回一个结果字符串
        String resultMsg = commentService.insertComment(logContent, topicIdStr, postTimeStr, logPerson, request);
        // 根据Service返回的字符串判断操作是否成功
        if ("日志提交成功！".equals(resultMsg)) {
            return success(resultMsg);
        } else {
            return error(resultMsg);
        }
    }

    // 10. 【新增方法】返回修改页面，并将数据带到页面
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Comment comment = commentService.selectCommentById(id);
        mmap.put("comment", comment);
        return prefix + "/edit";
    }

    // 11. 【修改后】修改保存方法，必须加 @ResponseBody
    @RequiresPermissions("monitor:comment:edit")
    @Log(title = "单位日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Comment comment) {
        return toAjax(commentService.updateComment(comment));
    }

    // 12. 【修改后】删除方法，必须加 @ResponseBody
    /**
     * 删除单位日志 (类型转换修正版)
     */
    @RequiresPermissions("monitor:comment:remove")
    @Log(title = "单位日志", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) { // 2. 方法签名接收一个名为 "ids" 的字符串

        // 3. 【核心转换】使用若依自带的 Convert.toLongArray() 工具进行转换
        Long[] commentIds = Convert.toLongArray(ids);
        // 4. 调用 Service 层，传递转换后的 Long[] 数组
        return toAjax(commentService.deleteCommentByIds(commentIds));
    }

    public static void main(String[] args) {
        DbSearcher searcher = null;
        try {
            searcher = new DbSearcher("ruoyi-admin/src/main/resources/offlineIP/cz88_public_v4.czdb", QueryType.MEMORY, "dWWs6VJ3wQlWLT18SCfBFw==");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            String IpAddressInfo = searcher.search("114.254.1.228");
            String newFormat = IpAddressInfo.replaceAll("\\s+", "-");
            System.out.println(newFormat);
        } catch (IpFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
