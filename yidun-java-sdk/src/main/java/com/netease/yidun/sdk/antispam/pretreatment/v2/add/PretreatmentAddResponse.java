package com.netease.yidun.sdk.antispam.pretreatment.v2.add;

import java.util.Map;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 自定义忽略词添加响应
 */
public class PretreatmentAddResponse extends CommonResponse {

    private PretreatmentAddResult result;

    public PretreatmentAddResult getResult() {
        return result;
    }

    public void setResult(PretreatmentAddResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PretreatmentAddResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }

    public static class PretreatmentAddResult {

        private Boolean pretreatmentAddResult;
        private Map<String, String> entityMap;

        public Boolean getPretreatmentAddResult() {
            return pretreatmentAddResult;
        }

        public void setPretreatmentAddResult(Boolean pretreatmentAddResult) {
            this.pretreatmentAddResult = pretreatmentAddResult;
        }

        public Map<String, String> getEntityMap() {
            return entityMap;
        }

        public void setEntityMap(Map<String, String> entityMap) {
            this.entityMap = entityMap;
        }

        @Override
        public String toString() {
            return "PretreatmentAddResult("
                    + "pretreatmentAddResult=" + pretreatmentAddResult
                    + ", entityMap=" + entityMap
                    + ")";
        }
    }
}
