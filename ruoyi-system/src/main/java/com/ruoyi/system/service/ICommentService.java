package com.ruoyi.system.service;


import com.ruoyi.system.domain.Comment;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 单位日志表Service接口
 * 
 * @author ruoyi
 * @date 2025-07-08
 */
public interface ICommentService 
{
    /**
     * 查询单位日志表
     * 
     * @param id 单位日志表主键
     * @return 单位日志表
     */
    public Comment selectCommentById(Long id);

    /**
     * 查询单位日志表列表
     * 
     * @param comment 单位日志表
     * @return 单位日志表集合
     */
    public List<Comment> selectCommentList(Comment comment);

    /**
     * 新增单位日志表
     * 
     * @return 结果
     */
    public String insertComment(String logContent,
                             String topicIdStr,
                             String postTimeStr,
                             String logPerson, HttpServletRequest request);

    /**
     * 修改单位日志表
     * 
     * @param comment 单位日志表
     * @return 结果
     */
    public int updateComment(Comment comment);

    /**
     * 批量删除单位日志表
     * 
     * @param ids 需要删除的单位日志表主键集合
     * @return 结果
     */
    public int deleteCommentByIds(Long[] ids);

    /**
     * 删除单位日志表信息
     * 
     * @param id 单位日志表主键
     * @return 结果
     */
    public int deleteCommentById(Long id);
}
