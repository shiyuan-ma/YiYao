package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 单位日志表对象 comment
 *
 * @author ruoyi
 * @date 2025-07-08
 */
public class Comment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 日志内容 */
    @Excel(name = "日志内容")
    private String content;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private String user;


    private String rawContent; // 用户原始输入的纯文本（带换行）

    public String getRawContent() {
        return rawContent;
    }

    public void setRawContent(String rawContent) {
        this.rawContent = rawContent;
    }

    /** ip信息 */
    @Excel(name = "ip信息")
    private String ip;

    /** isStaff */
    @Excel(name = "isStaff")
    private Integer isStaff;

    /** 更新时间 */
    /** 提交时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    /** 提交时间 */
    /** 提交时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date postTime;

    /** quote */
    @Excel(name = "quote")
    private String quote;

    /** quoteIdGroup */
    @Excel(name = "quoteIdGroup")
    private String quoteIdGroup;

    /** quoteUpdateId */
    @Excel(name = "quoteUpdateId")
    private String quoteUpdateId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 帖子id */
    @Excel(name = "帖子id")
    private Long topicId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 阅读人 */
    @Excel(name = "阅读人")
    private String readUsers;

    /** 点赞人 */
    @Excel(name = "点赞人")
    private String zanUsers;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIsStaff(Integer isStaff)
    {
        this.isStaff = isStaff;
    }

    public Integer getIsStaff()
    {
        return isStaff;
    }

    public void setLastUpdateTime(Date lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public void setPostTime(Date postTime)
    {
        this.postTime = postTime;
    }

    public Date getPostTime()
    {
        return postTime;
    }

    public void setQuote(String quote)
    {
        this.quote = quote;
    }

    public String getQuote()
    {
        return quote;
    }

    public void setQuoteIdGroup(String quoteIdGroup)
    {
        this.quoteIdGroup = quoteIdGroup;
    }

    public String getQuoteIdGroup()
    {
        return quoteIdGroup;
    }

    public void setQuoteUpdateId(String quoteUpdateId)
    {
        this.quoteUpdateId = quoteUpdateId;
    }

    public String getQuoteUpdateId()
    {
        return quoteUpdateId;
    }

    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }

    public void setTopicId(Long topicId)
    {
        this.topicId = topicId;
    }

    public Long getTopicId()
    {
        return topicId;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setReadUsers(String readUsers)
    {
        this.readUsers = readUsers;
    }

    public String getReadUsers()
    {
        return readUsers;
    }

    public void setZanUsers(String zanUsers)
    {
        this.zanUsers = zanUsers;
    }

    public String getZanUsers()
    {
        return zanUsers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("content", getContent())
                .append("ip", getIp())
                .append("isStaff", getIsStaff())
                .append("lastUpdateTime", getLastUpdateTime())
                .append("postTime", getPostTime())
                .append("quote", getQuote())
                .append("quoteIdGroup", getQuoteIdGroup())
                .append("quoteUpdateId", getQuoteUpdateId())
                .append("status", getStatus())
                .append("topicId", getTopicId())
                .append("userName", getUserName())
                .append("readUsers", getReadUsers())
                .append("zanUsers", getZanUsers())
                .toString();
    }
}
