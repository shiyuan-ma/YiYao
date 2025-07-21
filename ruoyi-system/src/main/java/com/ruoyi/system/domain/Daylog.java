package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【日报管理】对象 daylog
 * 
 * @author ruoyi
 * @date 2025-07-04
 */
public class Daylog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日报ID */
    @Excel(name = "日报ID")
    private Long id;

    /** 日报内容 */
    @Excel(name = "日报内容")
    private String text;

    /** 提交时间 */
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /** 主题ID */
    @Excel(name = "主题ID")
    private Long topicid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setText(String text) 
    {
        // 确保换行符统一为LF格式
        this.text = text.replaceAll("\r\n", "\n").replaceAll("\r", "\n");
    }

    public String getText() 
    {
        return text;
    }

    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }

    public void setTopicid(Long topicid) 
    {
        this.topicid = topicid;
    }

    public Long getTopicid() 
    {
        return topicid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("text", getText())
            .append("time", getTime())
            .append("topicid", getTopicid())
            .toString();
    }
}
