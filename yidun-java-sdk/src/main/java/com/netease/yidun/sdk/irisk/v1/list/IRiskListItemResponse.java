package com.netease.yidun.sdk.irisk.v1.list;


/**
 * @author zhouyutong01
 * 名单查询详情-返回
 */
public class IRiskListItemResponse {
    /**
     * 名单库
     */
    private String listGroupCode;
    /**
     * 名单项
     */
    private String content;
    /**
     * 释放时间
     */
    private Long expireTime;
    /**
     * 添加原因
     */
    private String description;
    /**
     * 命中次数
     */
    private Long hitCount;
    /**
     * 名单状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long modifyTime;
    /**
     * 创建人
     */
    private String createBy;

    public String getListGroupCode() {
        return listGroupCode;
    }

    public void setListGroupCode(String listGroupCode) {
        this.listGroupCode = listGroupCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getHitCount() {
        return hitCount;
    }

    public void setHitCount(Long hitCount) {
        this.hitCount = hitCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "IRiskListItemResponse(" +
                "listGroupCode='" + listGroupCode + '\'' +
                ", content='" + content + '\'' +
                ", expireTime=" + expireTime +
                ", description='" + description + '\'' +
                ", hitCount=" + hitCount +
                ", status=" + status +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", createBy='" + createBy + '\'' +
                ')';
    }
}
