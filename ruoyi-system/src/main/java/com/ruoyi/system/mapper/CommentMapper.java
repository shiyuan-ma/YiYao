package com.ruoyi.system.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DataSource(DataSourceType.SLAVE)
public interface CommentMapper {


    List<Comment> selectAll(String username);

    int updateByPrimaryKey(Comment row);

    List<Comment> selectIsInsert(@Param("userName") String userName, @Param("topicId") Long topicId);


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
     * @param comment 单位日志表
     * @return 结果
     */
    public int insertComment(Comment comment);

    /**
     * 修改单位日志表
     *
     * @param comment 单位日志表
     * @return 结果
     */
    public int updateComment(Comment comment);

    /**
     * 删除单位日志表
     *
     * @param id 单位日志表主键
     * @return 结果
     */
    public int deleteCommentById(Long id);

    /**
     * 批量删除单位日志表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCommentByIds(Long[] ids);
}