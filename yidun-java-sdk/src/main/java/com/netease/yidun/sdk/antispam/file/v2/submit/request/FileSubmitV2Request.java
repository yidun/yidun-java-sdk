package com.netease.yidun.sdk.antispam.file.v2.submit.request;

import com.netease.yidun.sdk.antispam.file.v2.submit.response.FileSubmitV2Response;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.Map;

public class FileSubmitV2Request extends PostFormRequest<FileSubmitV2Response> {

    private static final int DEFAULT_CHECK_FLAG = 7;
    /**
     * 数据ID
     */
    @Size(max = 128, message = "dataId最长128个字符")
    private String dataId;

    /**
     * 子数据类型，与易盾内容安全服务约定即可
     */
    private Integer dataType;

    /**
     * 文件名称/标题
     */
    private String fileName;

    /**
     * 文件类型
     */
    private Integer fileType;

    /**
     * 文档URL
     */
    @Size(max = 512, message = "文档下载的URL最长512个字符")
    private String url;

    /**
     * 文档内容, 不能和url同时为空，也不能和url同时有值
     */
    @Size(max = 100000, message = "文档的内容")
    private String content;

    /**
     * 检测标记 1: 仅检测文本， 2: 仅检测图片， 3：检测文本+图片， 7:检测文本+图片+img标签中的图片url，8：仅检测音视频，15：检测文本+图片+音视频，默认值为7
     */
    private Integer checkFlag = DEFAULT_CHECK_FLAG;

    /**
     * 用户唯一标识，如果无需登录则为空
     */
    @Size(max = 128, message = "account最长128个字符")
    private String account;

    /**
     * 用户IP地址
     */
    @Size(max = 128, message = "ip最长128个字符")
    private String ip;

    /**
     * 数据回调参数，调用方根据业务情况自行设计
     */
    @Size(max = 512, message = "callback最长512个字符")
    private String callback;

    /**
     * 异步检测结果回调通知的URL
     */
    @Size(max = 1024, message = "callbackUrl最长1024个字符")
    private String callbackUrl;

    /**
     * 额外过的策略组
     */
    private String checkStrategyGroupIds;

    public FileSubmitV2Request() {
        productCode = "file";
        uriPattern = "/v2/file/submit";
        version = "v2.0";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("url", getUrl());
        params.put("dataId", getDataId());
        params.put("dataType", getDataType());
        params.put("fileName", getFileName());
        params.put("fileType", getFileType());
        params.put("content", getContent());
        params.put("checkFlag", getCheckFlag() == null ? DEFAULT_CHECK_FLAG : getCheckFlag());
        params.put("account", getAccount());
        params.put("ip", getIp());
        params.put("callback", getCallback());
        params.put("callbackUrl", getCallbackUrl());

        return params;
    }

    @Override
    public Class<FileSubmitV2Response> getResponseClass() {
        return FileSubmitV2Response.class;
    }

    public static int getDefaultCheckFlag() {
        return DEFAULT_CHECK_FLAG;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCheckStrategyGroupIds() {
        return checkStrategyGroupIds;
    }

    public void setCheckStrategyGroupIds(String checkStrategyGroupIds) {
        this.checkStrategyGroupIds = checkStrategyGroupIds;
    }

    @Override
    public String toString() {
        return "FileSubmitV2Request{" +
                "dataId='" + dataId + '\'' +
                ", dataType=" + dataType +
                ", fileName='" + fileName + '\'' +
                ", fileType=" + fileType +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", checkFlag=" + checkFlag +
                ", account='" + account + '\'' +
                ", ip='" + ip + '\'' +
                ", callback='" + callback + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}
