/*
 * @(#) CollectInfo.java 2022-04-21
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.profile.v1.check;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CollectInfo {

    /**
     * 用户唯一标识，与易盾账号画像库匹配
     */
    @NotNull(message = "account不能为空")
    @Length(max = 64, message = "用户唯一标识长度不能超过64")
    private String account;

    /**
     * 手机号，与易盾风险库匹配。默认国内手机号，如有海外手机，需包含国家地区代码，格式为“+447410xxx186（+44即为国家码）”。
     * 如果需要加密，支持传入hash值，hash算法：md5(phone)
     */
    @NotNull(message = "phone不能为空")
    @Length(max = 64, message = "手机号长度不能超过64")
    private String phone;

    /**
     * 接受消息的用户标识，私聊/评论回复场景使用，易盾可根据该id关联检测，辅助精准调优
     */
    @NotBlank(message = "receiveUid不能为空")
    @Length(max = 64, message = "接受消息的用户标识不能超过64")
    private String receiveUid;

    /**
     * 用户IP地址，与易盾IP画像库匹配
     */
    @NotBlank(message = "ip不能为空")
    @Length(max = 128, message = "用户IP地址不能超过128")
    private String ip;

    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    @NotBlank(message = "dataId不能为空")
    @Length(max = 128, message = "数据唯一标识不能超过128")
    private String dataId;

    @NotBlank(message = "content不能为空")
    @Length(max = 10000, message = "内容最大长度不能超过10000")
    private String content;

    /**
     * 内容标题，适用于贴子、博客的文章标题等场景，建议抄送
     */
    @NotBlank(message = "title不能为空")
    @Length(max = 512, message = "内容标题最大长度不能超过512")
    private String title;

    /**
     * 发表时间，UNIX 时间戳(毫秒值)
     */
    @NotNull(message = "publishTime不能为空")
    @Length(max = 13, min = 13, message = "发表时间时间戳长度必须为13")
    private Long publishTime;

    public CollectInfo account(String account) {
        this.account = account;
        return this;
    }

    public CollectInfo phone(String phone) {
        this.phone = phone;
        return this;
    }

    public CollectInfo receiveUid(String receiveUid) {
        this.receiveUid = receiveUid;
        return this;
    }

    public CollectInfo ip(String ip) {
        this.ip = ip;
        return this;
    }

    public CollectInfo dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public CollectInfo content(String content) {
        this.content = content;
        return this;
    }

    public CollectInfo title(String title) {
        this.title = title;
        return this;
    }

    public CollectInfo publishTime(Long publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiveUid() {
        return receiveUid;
    }

    public void setReceiveUid(String receiveUid) {
        this.receiveUid = receiveUid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

}
