package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

/**
 * 审核扩展字段实体类
 */
public class CensorExtension implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * 质检任务创建时间
     */
    private Long inspTaskCreateTime;

    /**
     * 质检任务ID
     */
    private String qualityInspectionTaskId;

    public Long getInspTaskCreateTime() {
        return inspTaskCreateTime;
    }

    public void setInspTaskCreateTime(Long inspTaskCreateTime) {
        this.inspTaskCreateTime = inspTaskCreateTime;
    }

    public String getQualityInspectionTaskId() {
        return qualityInspectionTaskId;
    }

    public void setQualityInspectionTaskId(String qualityInspectionTaskId) {
        this.qualityInspectionTaskId = qualityInspectionTaskId;
    }

    @Override
    public String toString() {
        return "CensorExtension{" +
                "inspTaskCreateTime=" + inspTaskCreateTime +
                ", qualityInspectionTaskId='" + qualityInspectionTaskId + '\'' +
                '}';
    }
}