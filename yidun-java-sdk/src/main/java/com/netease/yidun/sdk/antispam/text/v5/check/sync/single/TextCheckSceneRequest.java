package com.netease.yidun.sdk.antispam.text.v5.check.sync.single;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 文本检测请求基类
 */
public class TextCheckSceneRequest<T extends BaseResponse> extends BizPostFormRequest<T> {

    /**
     * 数据唯一标识，能够根据该值定位到该条数据
     */
    @NotBlank(message = "dataId不能为空")
    @Size(max = 128, message = "dataId最长128个字符")
    private String dataId;
    /**
     * 用户发表内容，建议对内容中json、表情符、HTML标签、UBB标签等做过滤，只传递纯文本，以减少误判概率
     */
    @NotBlank(message = "content不能为空")
    @Size(max = 10000, message = "content最长10000个字符")
    private String content;
    /**
     * 内容标题，适用于贴子、博客的文章标题等场景，建议抄送，辅助机审策略精准调优
     */
    @Size(max = 512, message = "title最长512个字符")
    private String title;
    /**
     * 大小限制 子数据类型，与易盾内容安全服务约定即可
     */
    private Integer dataType;
    /**
     * 数据回调参数，调用方根据业务情况自行设计，当调用文本结果获取接口-轮询模式或文本结果获取接口-推送模式时，该接口会原样返回该字段。
     */
    @Size(max = 65535, message = "callback最长65535个字符")
    private String callback;
    /**
     * 发表时间，UNIX 时间戳(毫秒值)
     */
    private Long publishTime;
    /**
     * 人工审核结果回调通知到客户的URL
     */
    @Size(max = 256, message = "callbackUrl最长256个字符")
    private String callbackUrl;
    /**
     * 来源，用于展示渠道名称，应用名称等
     */
    @Size(max = 128, message = "category最长128个字符")
    private String category;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String dataId() {
        return dataId;
    }

    public TextCheckSceneRequest<T> dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }

    public TextCheckSceneRequest<T> content(String content) {
        this.content = content;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }

    public TextCheckSceneRequest<T> title(String title) {
        this.title = title;
        return this;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer dataType() {
        return dataType;
    }

    public TextCheckSceneRequest<T> dataType(Integer dataType) {
        this.dataType = dataType;
        return this;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String callback() {
        return callback;
    }

    public TextCheckSceneRequest<T> callback(String callback) {
        this.callback = callback;
        return this;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public Long publishTime() {
        return publishTime;
    }

    public TextCheckSceneRequest<T> publishTime(Long publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String callbackUrl() {
        return callbackUrl;
    }

    public TextCheckSceneRequest<T> callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String category() {
        return category;
    }

    public TextCheckSceneRequest<T> category(String category) {
        this.category = category;
        return this;
    }

    @Override
    public Class<T> getResponseClass() {
        return null;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("dataId", dataId);
        params.put("content", content);
        params.put("title", title);
        params.put("dataType", dataType != null ? String.valueOf(dataType) : null);
        params.put("callback", callback);
        params.put("publishTime", publishTime != null ? String.valueOf(publishTime) : null);
        params.put("callbackUrl", callbackUrl);
        params.put("category", category);
        return params;
    }

    @Override
    public String toString() {
        return "TextCheckSceneRequest("
                + "super=" + super.toString()
                + ", dataId=" + dataId
                + ", content=" + content
                + ", title=" + title
                + ", dataType=" + dataType
                + ", callback=" + callback
                + ", publishTime=" + publishTime
                + ", callbackUrl=" + callbackUrl
                + ", category=" + category
                + ")";
    }
}
