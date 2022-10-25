package com.netease.yidun.sdk.antispam.list.imagelist.v1.submit;


import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 图片名单添加请求
 */
@Data
public class ImageListSubmitRequest extends PostFormRequest<ImageListSubmitResponse> {
    /**
     * 图片url或者base64，json数组格式，最多200条
     */
    @NotBlank(message = "images不能为空")
    private String images;
    /**
     * 名单分类，1: 白名单，2: 黑名单
     */
    @NotNull(message = "listType不能为空")
    private Integer listType;
    /**
     * 名单分类（加黑名单时传），100：色情，110：性感，200：广告，210：二维码，300：暴恐，400：违禁，500：涉政
     */
    @NotNull(message = "imageLabel不能为空")
    private Integer imageLabel;
    /**
     * 名单类型，0: 相似名单，1: md5精确名单
     */
    @NotNull(message = "type不能为空")
    private Integer type;
    /**
     * 图片类型，包括url，base64编码等
     */
    private Integer imageType;
    /**
     * 描述
     */
    private String description;
    /**
     * 易盾分组
     */
    private String tagGroup;
    /**
     * 子标签
     */
    private String tagName;
    /**
     * 业务id
     */
    protected String businessId;

    public ImageListSubmitRequest() {
        productCode = "imageList";
        version = "v1";
        uriPattern = "/v1/image/list/submit";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("images", images);
        params.put("listType", listType != null ? String.valueOf(listType) : null);
        params.put("imageLabel", imageLabel != null ? String.valueOf(imageLabel) : null);
        params.put("type", type != null ? String.valueOf(type) : null);
        params.put("imageType", imageType != null ? String.valueOf(imageType) : null);
        params.put("description", description);
        params.put("tagGroup", tagGroup);
        params.put("tagName", tagName);
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public Class<ImageListSubmitResponse> getResponseClass() {
        return ImageListSubmitResponse.class;
    }

}
