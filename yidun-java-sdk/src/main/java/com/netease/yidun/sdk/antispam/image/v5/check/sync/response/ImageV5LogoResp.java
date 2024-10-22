package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
public class ImageV5LogoResp implements Serializable {
    private static final long serialVersionUID = 1773991345069025705L;
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
     * 质量检测结果
     */
    private List<ImageV5LogoDetail> details;

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

    public List<ImageV5LogoDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ImageV5LogoDetail> details) {
        this.details = details;
    }
}
