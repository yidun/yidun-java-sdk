package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
public class ImageV5AdResp implements Serializable {
    private static final long serialVersionUID = -1386479394384479293L;
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
     * 广告检测结果
     */
    private List<ImageV5AdDetail> details;

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

    public List<ImageV5AdDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ImageV5AdDetail> details) {
        this.details = details;
    }
}
