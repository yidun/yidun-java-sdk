package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;
import java.util.List;

public class ImageV5UserRiskResp implements Serializable {
    private static final long serialVersionUID = 6601801210002238971L;
    /**
     * 即易盾生成的uuid，唯一标识一张图片
     */
    private String taskId;
    /**
     * 产品方传的图片标识，原样返回
     */
    private String name;
    /**
     * 客户图片唯一标识
     */
    private String dataId;
    /**
     * 命中详细结果
     */
    private List<ImageV5UserRiskDetail> details;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public List<ImageV5UserRiskDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ImageV5UserRiskDetail> details) {
        this.details = details;
    }
}
