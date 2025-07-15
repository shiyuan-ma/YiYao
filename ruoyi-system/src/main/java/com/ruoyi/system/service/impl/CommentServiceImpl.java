package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Comment;
import com.ruoyi.system.mapper.CommentMapper;
import com.ruoyi.system.service.ICommentService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 单位日志表Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-08
 */
@Service
public class CommentServiceImpl implements ICommentService
{
    @Autowired
    private CommentMapper commentMapper;


    /**
     * 查询单位日志表
     * 
     * @param id 单位日志表主键
     * @return 单位日志表
     */
    @Override
    public Comment selectCommentById(Long id)
    {
        return commentMapper.selectCommentById(id);
    }

    /**
     * 查询单位日志表列表
     * 
     * @param comment 单位日志表
     * @return 单位日志表
     */
    @Override
    public List<Comment> selectCommentList(Comment comment)
    {
        return commentMapper.selectCommentList(comment);
    }

    /**
     * 新增单位日志表
     * 
     * @return 结果
     */
    @Override
    public String insertComment(String logContent,
                             String topicIdStr,
                             String postTimeStr,
                             String logPerson,HttpServletRequest request)
    {
        // --- 参数校验 ---
        if (StringUtils.isEmpty(topicIdStr)) {
            return "日志主题ID不能为空！";
        }
        if (StringUtils.isEmpty(logPerson)) { // ★★★ 校验提交人
            return "请选择提交人！";
        }
        if (StringUtils.isEmpty(postTimeStr)) {
            return "发布时间不能为空！";
        }

        long topicId;
        try {
            topicId = Long.parseLong(topicIdStr);
        } catch (NumberFormatException e) {
            return "日志主题ID必须是数字！";
        }

        // 2. 解析时间字符串
        Date postTime;
        // 定义与前端 flatpickr 中 dateFormat 一致的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            postTime = sdf.parse(postTimeStr);
        } catch (ParseException e) {
            return "提交的日期时间格式不正确，请使用 '年-月-日 时:分:秒' 格式。";
        }

        // --- 动态获取 IP 地址 ---
        String ipAddress = getClientIpAddr(request);

        // --- 构建业务对象 ---
        String[] lines = logContent.split("\r?\n");
        StringBuilder contentHtml = new StringBuilder();
        contentHtml.append("<p><strong>完成工作：</strong></p>");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                contentHtml.append("<p>").append(line.trim()).append("</p>");
            }
        }
        contentHtml.append("<p><strong>需重点说明，协调与帮助：</strong></p><p><span>无</span></p>");
        contentHtml.append("<p><strong>明日工作计划：</strong></p><p><span>无</span></p>");

        Comment commentToInsert = new Comment();
        commentToInsert.setContent(contentHtml.toString());
        commentToInsert.setIp(ipAddress); // ★★★ 使用动态获取的IP
        commentToInsert.setIsStaff(0);
        commentToInsert.setPostTime(postTime); // ★★★ 使用从前端选择的时间
        commentToInsert.setQuoteIdGroup(",");
        commentToInsert.setQuoteUpdateId(",");
        commentToInsert.setStatus(20L);
        commentToInsert.setTopicId(topicId);
        commentToInsert.setUserName(logPerson);

        System.out.println(topicId+""+logPerson+""+postTime+""+contentHtml.toString()+ipAddress);

//        // --- 执行数据库操作 ---
        try {
            int result = commentMapper.insertComment(commentToInsert);
            if (result > 0) {
                return "日志提交成功！IP: " + ipAddress + ", 时间: " + sdf.format(postTime);
            } else {
                return "日志提交失败，数据库未受影响。";
            }
        } catch (Exception e) {
            e.printStackTrace(); // 打印错误到后台日志
            return "日志提交失败，发生服务器内部错误。";
        }
    }

    // 放在 StudentController 类的内部
    private String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP，多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }


    /**
     * 修改单位日志表
     * 
     * @param comment 单位日志表
     * @return 结果
     */
    @Override // 建议加上 @Override 注解
    public int updateComment(Comment comment) {
        // ---【核心修复】---
        // 不再需要从 rawContent 生成 HTML。
        // 前端已经将编辑器里的完整HTML内容绑定到了 comment.content 字段。
        // 我们只需要直接将这个 comment 对象传递给 mapper 进行更新即可。

        // 最好在后端设置更新时间，以服务器时间为准
        comment.setLastUpdateTime(new Date());
        return commentMapper.updateComment(comment);
    }
    // Helper 方法：将纯文本转换为HTML内容
    private String generateContentFromRaw(String rawContent) {
        StringBuilder html = new StringBuilder();
        html.append("<p><strong>完成工作：</strong></p>");
        if (StringUtils.isNotBlank(rawContent)) {
            String[] lines = rawContent.split("\\r?\\n");
            for (String line : lines) {
                String escaped = StringEscapeUtils.escapeHtml4(line);
                html.append("<p>").append(escaped).append("</p>");
            }
        } else {
            html.append("<p>无</p>");
        }
        html.append("<p><strong>需重点说明，协调与帮助：</strong></p><p>无</p>");
        html.append("<p><strong>明日工作计划：</strong></p><p>无</p>");
        return html.toString();
    }


    /**
     * 批量删除单位日志表
     * 
     * @param ids 需要删除的单位日志表主键
     * @return 结果
     */
    @Override
    public int deleteCommentByIds(Long[] ids)
    {
        return commentMapper.deleteCommentByIds(ids);
    }

    /**
     * 删除单位日志表信息
     * 
     * @param id 单位日志表主键
     * @return 结果
     */
    @Override
    public int deleteCommentById(Long id)
    {
        return commentMapper.deleteCommentById(id);
    }
}
