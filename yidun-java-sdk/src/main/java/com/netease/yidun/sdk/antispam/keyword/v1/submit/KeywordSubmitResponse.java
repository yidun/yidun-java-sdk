package com.netease.yidun.sdk.antispam.keyword.v1.submit;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 自定义关键词添加响应
 */
public class KeywordSubmitResponse extends CommonResponse {

    private List<KeywordSubmitResult> result;

    public List<KeywordSubmitResult> getResult() {
        return result;
    }

    public void setResult(List<KeywordSubmitResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "KeywordSubmitResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }

    public static class KeywordSubmitResult {

        private String keyword;
        private Long id;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "KeywordSubmitResult("
                    + "keyword=" + keyword
                    + ", id=" + id
                    + ")";
        }
    }
}
