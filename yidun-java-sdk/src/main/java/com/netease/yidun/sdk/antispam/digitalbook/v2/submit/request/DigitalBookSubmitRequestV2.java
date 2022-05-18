package com.netease.yidun.sdk.antispam.digitalbook.v2.submit.request;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.response.DigitalBookCheckResponseV2;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.utils.StringUtils;

/**
 * 数字阅读检测提交v2接口
 */
public class DigitalBookSubmitRequestV2 extends PostFormRequest<DigitalBookCheckResponseV2> {
    private static final Gson GSON = new Gson();

    /**
     * 用户IP地址
     */
    @Size(max = 128, message = "ip最长128个字符")
    private String ip;

    /**
     * 用户账号
     */
    @Size(max = 128, message = "account最长128个字符")
    private String account;

    /**
     * 用户设备id
     */
    @Size(max = 128, message = "deviceId最长128个字符")
    private String deviceId;

    /**
     * 用户设备类型
     */
    @Size(max = 4, message = "deviceType最长4个字符")
    private String deviceType;

    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    @Size(max = 128, message = "dataId最长128个字符")
    private String dataId;

    /**
     * 标题
     */
    @Size(max = 512, message = "title最长512个字符")
    private String title;
    /**
     * 支持多种类型内容同时过检，包括文本，图片，点播语音,点播音视频，文档
     */
    @Valid
    private List<DataItem> content;

    /**
     * 用户自定义解析字段
     */
    private Map<String, List<DataItem>> customParseFieldMap;

    /**
     * 用户自定义不解析解析字段
     */
    private Map<String, String> customUnParseFieldMap;

    /**
     * 回调数据
     */
    @Size(max = 512, message = "callback最长512个字符")
    private String callback;

    /**
     * 回调地址
     */
    @Size(max = 1024, message = "callbackUrl最长1024个字符")
    private String callbackUrl;

    /**
     * publishTime
     */
    private Long publishTime;

    /**
     * 反作弊的 token，当开通反作弊时，抄送到反作弊服务
     */
    @Size(max = 256, message = "token最长256个字符")
    private String token;

    /**
     * 书籍id
     */
    @NotBlank(message = "bookId不能为空")
    @Size(max = 64, message = "bookId最长64个字符")
    private String bookId;

    /**
     * 章节号
     */
    private Integer chapterNumber;

    /**
     * 章节总数
     */
    private Integer totalChapters;

    /**
     * 作品名称
     */
    @Valid
    private List<DataItem> bookName;

    /**
     * 作品封面图片
     */
    @Valid
    private List<DataItem> bookCover;

    /**
     * 作品信息
     */
    @Valid
    private List<DataItem> bookInformation;

    /**
     * 作者名
     */
    @Size(max = 64, message = "authorName最长64个字符")
    private String authorName;

    /**
     * 作者作品总数
     */
    private Integer totalBooks;

    /**
     * 作者粉丝数
     */
    private Integer totalFans;

    /**
     * 作者创作天数
     */
    private Integer totalCreationDays;

    /**
     * 作者等级
     */
    @Size(max = 64, message = "authorRank最长64个字符")
    private String authorRank;

    /**
     * 场景分类 1 提交只包含书的一章，2 表示提交包含整本书内容
     */
    @NotNull(message = "type不能为空")
    @Size(max = 64, message = "type最长64个字符")
    private String type;

    public DigitalBookSubmitRequestV2() {
        productCode = "digitalBook";
        uriPattern = "/v2/digital/submit";
        version = "v2";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("ip", getIp());
        params.put("account", getAccount());
        params.put("deviceId", getDeviceId());
        params.put("deviceType", getDeviceType());
        params.put("dataId", getDataId());
        params.put("title", getTitle());
        params.put("callback", getCallback());
        params.put("callbackUrl", getCallbackUrl());
        params.put("publishTime", getPublishTime());
        params.put("token", getToken());
        params.put("bookId", bookId);
        params.put("authorName", authorName);
        params.put("authorRank", authorRank);
        params.put("type", type);
        if (chapterNumber != null) {
            params.put("chapterNumber", chapterNumber);
        }
        if (totalChapters != null) {
            params.put("totalChapters", totalChapters);
        }
        if (totalBooks != null) {
            params.put("totalBooks", totalBooks);
        }
        if (totalFans != null) {
            params.put("totalFans", totalFans);
        }
        if (totalCreationDays != null) {
            params.put("totalCreationDays", totalCreationDays);
        }
        if (content != null && !content.isEmpty()) {
            params.put("content", GSON.toJson(getContent()));
        }
        if (bookCover != null && !bookCover.isEmpty()) {
            params.put("bookCover", GSON.toJson(bookCover));
        }
        if (bookName != null && !bookName.isEmpty()) {
            params.put("bookName", GSON.toJson(bookName));
        }
        if (bookInformation != null && !bookInformation.isEmpty()) {
            params.put("bookInformation", GSON.toJson(bookInformation));
        }
        if (customParseFieldMap != null && !customParseFieldMap.isEmpty()) {
            for (Map.Entry<String, List<DataItem>> filed : customParseFieldMap.entrySet()) {
                List<DataItem> dataItemList = filed.getValue();
                if (StringUtils.isNotBlank(filed.getKey()) && dataItemList != null && !dataItemList.isEmpty()) {
                    params.put(filed.getKey(), GSON.toJson(dataItemList));
                }
            }
        }
        if (customUnParseFieldMap != null && !customUnParseFieldMap.isEmpty()) {
            for (Map.Entry<String, String> filed : customUnParseFieldMap.entrySet()) {
                String data = filed.getValue();
                if (StringUtils.isNotBlank(filed.getKey()) && StringUtils.isNotBlank(data)) {
                    params.put(filed.getKey(), data);
                }
            }
        }
        return params;
    }

    @Override
    public Class<DigitalBookCheckResponseV2> getResponseClass() {
        return DigitalBookCheckResponseV2.class;
    }

    public static class DataItem {
        @NotBlank(message = "type不能为空")
        @Size(min = 1, max = 10, message = "type最长10个字符")
        private String type;
        @NotBlank(message = "data不能为空")
        @Size(min = 1, max = 5000, message = "data最长5000个字符")
        private String data;
        @Size(max = 128, message = "dataId最长128个字符")
        private String dataId;

        public DataItem type(String type) {
            this.type = type;
            return this;
        }

        public DataItem data(String data) {
            this.data = data;
            return this;
        }

        public DataItem dataId(String dataId) {
            this.dataId = dataId;
            return this;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        @Override
        public String toString() {
            return "DataItem{" +
                    "type='" + type + '\'' +
                    ", data='" + data + '\'' +
                    ", dataId='" + dataId + '\'' +
                    '}';
        }
    }

    public DigitalBookSubmitRequestV2 ip(String ip) {
        this.ip = ip;
        return this;
    }

    public DigitalBookSubmitRequestV2 account(String account) {
        this.account = account;
        return this;
    }

    public DigitalBookSubmitRequestV2 deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public DigitalBookSubmitRequestV2 deviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public DigitalBookSubmitRequestV2 dataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public DigitalBookSubmitRequestV2 title(String title) {
        this.title = title;
        return this;
    }

    public DigitalBookSubmitRequestV2 content(List<DataItem> content) {
        this.content = content;
        return this;
    }

    public DigitalBookSubmitRequestV2 customParseFieldMap(Map<String, List<DataItem>> customParseFieldMap) {
        this.customParseFieldMap = customParseFieldMap;
        return this;
    }

    public DigitalBookSubmitRequestV2 customUnParseFieldMap(Map<String, String> customUnParseFieldMap) {
        this.customUnParseFieldMap = customUnParseFieldMap;
        return this;
    }

    public DigitalBookSubmitRequestV2 callback(String callback) {
        this.callback = callback;
        return this;
    }

    public DigitalBookSubmitRequestV2 callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public DigitalBookSubmitRequestV2 publishTime(Long publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public DigitalBookSubmitRequestV2 token(String token) {
        this.token = token;
        return this;
    }

    public DigitalBookSubmitRequestV2 bookId(String bookId) {
        this.bookId = bookId;
        return this;
    }

    public DigitalBookSubmitRequestV2 chapterNumber(Integer chapterNumber) {
        this.chapterNumber = chapterNumber;
        return this;
    }

    public DigitalBookSubmitRequestV2 totalChapters(Integer totalChapters) {
        this.totalChapters = totalChapters;
        return this;
    }

    public DigitalBookSubmitRequestV2 bookName(List<DataItem> bookName) {
        this.bookName = bookName;
        return this;
    }

    public DigitalBookSubmitRequestV2 bookCover(List<DataItem> bookCover) {
        this.bookCover = bookCover;
        return this;
    }

    public DigitalBookSubmitRequestV2 bookInformation(List<DataItem> bookInformation) {
        this.bookInformation = bookInformation;
        return this;
    }

    public DigitalBookSubmitRequestV2 authorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public DigitalBookSubmitRequestV2 totalBooks(Integer totalBooks) {
        this.totalBooks = totalBooks;
        return this;
    }

    public DigitalBookSubmitRequestV2 totalFans(Integer totalFans) {
        this.totalFans = totalFans;
        return this;
    }

    public DigitalBookSubmitRequestV2 totalCreationDays(Integer totalCreationDays) {
        this.totalCreationDays = totalCreationDays;
        return this;
    }

    public DigitalBookSubmitRequestV2 authorRank(String authorRank) {
        this.authorRank = authorRank;
        return this;
    }

    public DigitalBookSubmitRequestV2 type(String type) {
        this.type = type;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataItem> getContent() {
        return content;
    }

    public void setContent(List<DataItem> content) {
        this.content = content;
    }

    public Map<String, List<DataItem>> getCustomParseFieldMap() {
        return customParseFieldMap;
    }

    public void setCustomParseFieldMap(Map<String, List<DataItem>> customParseFieldMap) {
        this.customParseFieldMap = customParseFieldMap;
    }

    public Map<String, String> getCustomUnParseFieldMap() {
        return customUnParseFieldMap;
    }

    public void setCustomUnParseFieldMap(Map<String, String> customUnParseFieldMap) {
        this.customUnParseFieldMap = customUnParseFieldMap;
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

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(Integer chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public Integer getTotalChapters() {
        return totalChapters;
    }

    public void setTotalChapters(Integer totalChapters) {
        this.totalChapters = totalChapters;
    }

    public List<DataItem> getBookName() {
        return bookName;
    }

    public void setBookName(List<DataItem> bookName) {
        this.bookName = bookName;
    }

    public List<DataItem> getBookCover() {
        return bookCover;
    }

    public void setBookCover(List<DataItem> bookCover) {
        this.bookCover = bookCover;
    }

    public List<DataItem> getBookInformation() {
        return bookInformation;
    }

    public void setBookInformation(List<DataItem> bookInformation) {
        this.bookInformation = bookInformation;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(Integer totalBooks) {
        this.totalBooks = totalBooks;
    }

    public Integer getTotalFans() {
        return totalFans;
    }

    public void setTotalFans(Integer totalFans) {
        this.totalFans = totalFans;
    }

    public Integer getTotalCreationDays() {
        return totalCreationDays;
    }

    public void setTotalCreationDays(Integer totalCreationDays) {
        this.totalCreationDays = totalCreationDays;
    }

    public String getAuthorRank() {
        return authorRank;
    }

    public void setAuthorRank(String authorRank) {
        this.authorRank = authorRank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DigitalBookSubmitRequestV2{" +
                "ip='" + ip + '\'' +
                ", account='" + account + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", dataId='" + dataId + '\'' +
                ", title='" + title + '\'' +
                ", content=" + content +
                ", customParseFieldMap=" + customParseFieldMap +
                ", customUnParseFieldMap=" + customUnParseFieldMap +
                ", callback='" + callback + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", publishTime=" + publishTime +
                ", token='" + token + '\'' +
                ", bookId='" + bookId + '\'' +
                ", chapterNumber=" + chapterNumber +
                ", totalChapters=" + totalChapters +
                ", bookName=" + bookName +
                ", bookCover=" + bookCover +
                ", bookInformation=" + bookInformation +
                ", authorName='" + authorName + '\'' +
                ", totalBooks=" + totalBooks +
                ", totalFans=" + totalFans +
                ", totalCreationDays=" + totalCreationDays +
                ", authorRank='" + authorRank + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
