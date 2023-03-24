package com.netease.yidun.sdk.antispam.image.v5.check;

import com.netease.yidun.sdk.antispam.image.v5.enums.ImageTypeEnum;
import com.netease.yidun.sdk.core.response.BaseResponse;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

public abstract class ImageV5CheckRequest<T extends BaseResponse> extends ImageCheckSceneRequest<T> {

    /**
     * timestamp milliseconds
     */
    private Long publishTime;

    /**
     * 图片检测列表参数
     */
    @Valid
    @NotEmpty(message = "images不能为空")
    private List<ImageBeanRequest> images;

    /**
     * 邮箱(反作弊用)
     */
    private String email;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 扩展字段(反作弊用)
     */
    private String extension;

    /**
     * 图片过检分类
     */
    private Set<Integer> checkLabels;
    private String extStr1;
    private String extStr2;
    private Long extLon1;
    private Long extLon2;
    /**
     * 人审扩展字段，用于人审调度中心的规则匹配
     */
    private String censorExt;
    private String subProduct;

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public List<ImageBeanRequest> getImages() {
        return images;
    }

    public void setImages(List<ImageBeanRequest> images) {
        this.images = images;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Set<Integer> getCheckLabels() {
        return checkLabels;
    }

    public void setCheckLabels(Set<Integer> checkLabels) {
        this.checkLabels = checkLabels;
    }

    public String getExtStr1() {
        return extStr1;
    }

    public void setExtStr1(String extStr1) {
        this.extStr1 = extStr1;
    }

    public String getExtStr2() {
        return extStr2;
    }

    public void setExtStr2(String extStr2) {
        this.extStr2 = extStr2;
    }

    public Long getExtLon1() {
        return extLon1;
    }

    public void setExtLon1(Long extLon1) {
        this.extLon1 = extLon1;
    }

    public Long getExtLon2() {
        return extLon2;
    }

    public void setExtLon2(Long extLon2) {
        this.extLon2 = extLon2;
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
    }

    public String getCensorExt() {
        return censorExt;
    }

    public void setCensorExt(String censorExt) {
        this.censorExt = censorExt;
    }

    public static class ImageBeanRequest implements Serializable {
        private static final long serialVersionUID = -1695935042456581702L;
        /**
         * 客户图片唯一标识
         */
        private String dataId;
        /**
         * 图片名称
         */
        @NotEmpty(message = "图片名字不能为空")
        private String name;
        /**
         * 图片data字段的类型，包括url，base64编码等，具体定义见{@link ImageTypeEnum}
         */
        @NotNull(message = "图片数据类型不能为空")
        @Range(min = 1, max = 2, message = "图片数据类型不合法")
        private Integer type;
        /**
         * 图片内容，根据type字段传不同的值
         */
        @NotEmpty(message = "图片数据不能为空")
        private String data;
        /**
         * 主动回调url
         */
        private String callbackUrl;
        /**
         * taskId
         */
        private String taskId;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getCallbackUrl() {
            return callbackUrl;
        }

        public void setCallbackUrl(String callbackUrl) {
            this.callbackUrl = callbackUrl;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }
    }

}
