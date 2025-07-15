package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Long id;

    private String account;

    private Boolean allowuserdynamic;

    private String answer;

    private String avatarname;

    private Long cancelaccounttime;

    private BigDecimal deposit;

    private String email;

    private String issue;

    private String mobile;

    private String nickname;

    private String password;

    private String platformuserid;

    private Long point;

    private Boolean realnameauthentication;

    private Date registrationdate;

    private String salt;

    private Long securitydigest;

    private Integer state;

    private Integer type;

    private String username;

    private Integer userversion;

    private String headimg;

    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Boolean getAllowuserdynamic() {
        return allowuserdynamic;
    }

    public void setAllowuserdynamic(Boolean allowuserdynamic) {
        this.allowuserdynamic = allowuserdynamic;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getAvatarname() {
        return avatarname;
    }

    public void setAvatarname(String avatarname) {
        this.avatarname = avatarname == null ? null : avatarname.trim();
    }

    public Long getCancelaccounttime() {
        return cancelaccounttime;
    }

    public void setCancelaccounttime(Long cancelaccounttime) {
        this.cancelaccounttime = cancelaccounttime;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue == null ? null : issue.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPlatformuserid() {
        return platformuserid;
    }

    public void setPlatformuserid(String platformuserid) {
        this.platformuserid = platformuserid == null ? null : platformuserid.trim();
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Boolean getRealnameauthentication() {
        return realnameauthentication;
    }

    public void setRealnameauthentication(Boolean realnameauthentication) {
        this.realnameauthentication = realnameauthentication;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Long getSecuritydigest() {
        return securitydigest;
    }

    public void setSecuritydigest(Long securitydigest) {
        this.securitydigest = securitydigest;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUserversion() {
        return userversion;
    }

    public void setUserversion(Integer userversion) {
        this.userversion = userversion;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}