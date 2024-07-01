package com.netease.yidun.sdk.antispam.videosolution.submit.v2.request;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.video.submit.v4.request.AdvancedFrequencyRequest;
import com.netease.yidun.sdk.antispam.videosolution.submit.v2.response.VideoSolutionSubmitV2Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class VideoSolutionSubmitV2Req extends PostFormRequest<VideoSolutionSubmitV2Resp> {
    private static final Gson GSON = new Gson();
    /**
     * 用户IP地址
     */
    private String ip;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户设备id
     */
    private String deviceId;

    /**
     * 用户设备类型
     */
    private String deviceType;

    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    private String dataId;

    /**
     * 文件标题
     */
    private String title;

    /**
     * 图片检测列表参数
     */
    private List<ImageBeanRequest> images;

    /**
     * 音视频url
     */
    private String url;

    /**
     * 回调数据
     */
    private String callback;

    /**
     * 回调地址
     */
    private String callbackUrl;


    /**
     * 截图帧数，默认5
     */
    private String scFrequency;
    /**
     * 固定截帧数
     */
    private Integer checkFrameCount;

    /**
     * 高级截图频率配置，结构是json结构
     */
    private AdvancedFrequencyRequest advancedFrequency;

    /**
     * 简介内容
     */
    private String content;

    /**
     * 去重key
     */
    private String uniqueKey;

    /**
     * 指定过检测类型
     */
    private Integer detectType;

    /**
     * 用于聚合的id
     */
    private String relationId;

    /**
     * 关联查询id
     */
    private String relationSearchId;

    /**
     * 自定义排序字段
     */
    private Long priorityId;

    /**
     * 用户自定义标签
     */
    private List<String> tags;
    /**
     * 指定语言检测音频内容，需以易盾标准填入
     */
    private String checkLanguageCode;

    private String nickname;

    private String subProduct;

    private String extStr1;

    private String extStr2;

    private Long extLon1;

    private Long extLon2;

    private Integer level;

    private Long registerTime;

    private Integer gender;

    private Integer age;

    private String phone;

    /**
     * 用户个人主页地址
     */
    private String profileUrl;

    public VideoSolutionSubmitV2Req() {
        productCode = "videoSolutionCheck";
        uriPattern = "/v2/videosolution/submit";
        version = "v2.1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("ip", getIp());
        params.put("account", getAccount());
        params.put("level", getLevel());
        params.put("registerTime", getRegisterTime());
        params.put("gender", getGender());
        params.put("age", getAge());
        params.put("phone", getPhone());
        params.put("deviceId", getDeviceId());
        params.put("deviceType", getDeviceType());
        params.put("dataId", getDataId());
        params.put("title", getTitle());
        if (getImages() != null) {
            params.put("images", new Gson().toJson(getImages()));
        }
        params.put("url", getUrl());
        params.put("callback", getCallback());
        params.put("callbackUrl", getCallbackUrl());
        params.put("scFrequency", getScFrequency());
        if (advancedFrequency != null) {
            params.put("advancedFrequency", GSON.toJson(getAdvancedFrequency()));
        }
        params.put("content", getContent());
        params.put("uniqueKey", getUniqueKey());
        params.put("detectType", getDetectType());
        params.put("relationId", getRelationId());
        params.put("relationSearchId", getRelationSearchId());
        params.put("priorityId", getPriorityId());
        params.put("checkFrameCount", getCheckFrameCount());
        params.put("checkLanguageCode", getCheckLanguageCode());
        params.put("nickname", getNickname());
        if (getTags() != null) {
            params.put("tags", new Gson().toJson(getTags()));
        }
        params.put("subProduct", getSubProduct());
        params.put("profileUrl", getProfileUrl());
        params.put("extStr1", getExtStr1());
        params.put("extStr2", getExtStr2());
        params.put("extLon1", getExtLon1());
        params.put("extLon2", getExtLon2());
        return params;
    }

    @Override
    public Class<VideoSolutionSubmitV2Resp> getResponseClass() {
        return VideoSolutionSubmitV2Resp.class;
    }

    public static class ImageBeanRequest {
        /**
         * 图片唯一标识
         */
        private String name;
        /**
         * 图片data字段的类型，包括url，base64编码等，具体定义见
         * 
         * @see com.netease.yidun.sdk.antispam.image.v5.enums.ImageTypeEnum
         */
        private int type;
        /**
         * 图片内容，根据type字段传不同的值
         */
        private String data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
