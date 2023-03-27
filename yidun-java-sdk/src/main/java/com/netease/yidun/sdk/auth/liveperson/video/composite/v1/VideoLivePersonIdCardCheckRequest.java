package com.netease.yidun.sdk.auth.liveperson.video.composite.v1;

import java.util.List;
import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.validation.limitation.CheckIdCard;
import com.netease.yidun.sdk.core.validation.limitation.CheckName;
import com.netease.yidun.sdk.auth.constant.VideoType;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 视频活体人脸核身请求
 */
public class VideoLivePersonIdCardCheckRequest extends BizPostFormRequest<VideoLivePersonIdCardCheckResponse> {

    private static final Gson gson = new Gson();

    /**
     * 用户真实姓名
     */
    @CheckName
    private String name;

    /**
     * 用户身份证号码，支持15位和18位
     */
    @CheckIdCard
    private String cardNo;

    /**
     * 动作序列
     */
    @NotNull(message = "actions不能为空")
    private List<String> actions;

    /**
     * 对应视频序列
     */
    @NotNull(message = "actionVideos不能为空")
    private List<String> actionVideos;

    /**
     * 视频格式
     */
    @NotNull(message = "videoType不能为空")
    private VideoType videoType;

    /**
     * 是否需要返回正面照
     */
    private boolean needAvatar = false;

    @Size(max = 64, message = "dataId长度不合法")
    private String dataId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VideoLivePersonIdCardCheckRequest name(String name) {
        this.name = name;
        return this;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public VideoLivePersonIdCardCheckRequest cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public VideoLivePersonIdCardCheckRequest actions(List<String> actions) {
        this.actions = actions;
        return this;
    }

    public List<String> getActionVideos() {
        return actionVideos;
    }

    public void setActionVideos(List<String> actionVideos) {
        this.actionVideos = actionVideos;
    }

    public VideoLivePersonIdCardCheckRequest actionVideos(List<String> actionVideos) {
        this.actionVideos = actionVideos;
        return this;
    }

    public VideoType getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoType videoType) {
        this.videoType = videoType;
    }

    public VideoLivePersonIdCardCheckRequest videoType(VideoType videoType) {
        this.videoType = videoType;
        return this;
    }

    public boolean isNeedAvatar() {
        return needAvatar;
    }

    public void setNeedAvatar(boolean needAvatar) {
        this.needAvatar = needAvatar;
    }

    public VideoLivePersonIdCardCheckRequest needAvatar(boolean needAvatar) {
        this.needAvatar = needAvatar;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public VideoLivePersonIdCardCheckRequest dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public VideoLivePersonIdCardCheckRequest(String businessId) {
        productCode = "auth";
        version = "v1";
        uriPattern = "/v1/liveperson/h5/audit";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("name", name);
        params.put("cardNo", cardNo);
        params.put("actions", gson.toJson(actions));
        params.put("videoType", String.valueOf(videoType.getType()));
        params.put("needAvatar", String.valueOf(needAvatar));
        params.put("dataId", dataId);
        return params;
    }

    @Override
    protected Map<String, String> getNonSignParams() {
        StringHashMap params = new StringHashMap();
        // 视频不参与签名
        params.put("actionVideos", gson.toJson(actionVideos));
        return params;
    }

    @Override
    public Class<VideoLivePersonIdCardCheckResponse> getResponseClass() {
        return VideoLivePersonIdCardCheckResponse.class;
    }

    @Override
    public String toString() {
        // actionVideos 可能是视频原始数据（base64编码），数据量较大，不适合在此处输出
        return "VideoLivePersonIdCardCheckRequest(" +
                "super=" + super.toString() +
                ", name=" + name +
                ", cardNo=" + cardNo +
                ", actions=" + actions +
                ", videoType=" + videoType +
                ", needAvatar=" + needAvatar +
                ", dataId=" + dataId +
                ")";
    }
}
