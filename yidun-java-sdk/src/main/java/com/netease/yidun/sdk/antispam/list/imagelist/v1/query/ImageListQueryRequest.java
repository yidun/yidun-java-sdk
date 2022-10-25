package com.netease.yidun.sdk.antispam.list.imagelist.v1.query;


import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 图片名单查询请求
 */
@Data
public class ImageListQueryRequest extends PostFormRequest<ImageListQueryResponse> {
    /**
     * 名单分类，1: 白名单，2: 黑名单
     */
    private Integer listType;
    /**
     * 名单分类（加黑名单时传），100：色情，110：性感，200：广告，210：二维码，300：暴恐，400：违禁，500：涉政
     */
    private Integer imageLabel;
    /**
     * 名单类型，0: 相似名单，1: md5精确名单
     */
    @NotNull(message = "type不能为空")
    private Integer type;
    /**
     * 页数
     */
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;
    /**
     * 每页大小
     */
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    /**
     * 查询开始时间
     */
    @NotNull(message = "startTime不能为空")
    private Long startTime;
    /**
     * 查询结束时间
     */
    @NotNull(message = "endTime不能为空")
    private Long endTime;

    /**
     * 图片名单url
     */
    private String url;
    /**
     * 名单状态
     */
    private Integer status;
    /**
     * 排序方式
     */
    private Integer sortType;
    /**
     * 业务id
     */
    protected String businessId;

    public ImageListQueryRequest() {
        productCode = "imageList";
        version = "v1";
        uriPattern = "/v1/image/list/pageQuery";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("listType", listType != null ? String.valueOf(listType) : null);
        params.put("imageLabel", imageLabel != null ? String.valueOf(imageLabel) : null);
        params.put("type", type != null ? String.valueOf(type) : null);
        params.put("pageNum", pageNum != null ? String.valueOf(pageNum) : null);
        params.put("pageSize", pageSize != null ? String.valueOf(pageSize) : null);
        params.put("startTime", startTime != null ? String.valueOf(startTime) : null);
        params.put("endTime", endTime != null ? String.valueOf(endTime) : null);
        params.put("url", url);
        params.put("status", status != null ? String.valueOf(status) : null);
        params.put("sortType", sortType != null ? String.valueOf(sortType) : null);
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public Class<ImageListQueryResponse> getResponseClass() {
        return ImageListQueryResponse.class;
    }

}
