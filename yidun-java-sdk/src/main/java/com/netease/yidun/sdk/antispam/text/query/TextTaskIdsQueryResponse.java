/*
 * @(#) TextTaskIdsQueryResponse.java 2024-04-15
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.text.query;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.netease.yidun.sdk.core.response.CommonResponse;
import com.netease.yidun.sdk.core.utils.StringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuliyang02
 * @version 2024-04-15
 */
@Data
public class TextTaskIdsQueryResponse extends CommonResponse {

    private List<TextTaskIdsQueryResult> result;

    @Data
    public static class TextTaskIdsQueryResult {
        private String callback;
        private int action;
        private String taskId;
        private int status;
        private List<LabelInfo> labels = new ArrayList<>();
        private Integer censorSource;
        private Long censorTime;
        private String censor;
    }

    @Data
    public static class LabelInfo {
        private int label;
        private int level;
        private String subLabel;
        /**
         * 风险描述
         */
        private String riskDescription;
        private HintInfo details;
        public LabelInfo() {
        }
        public LabelInfo(int spamType, String hint, int action, String subLabel) {
            this.label = spamType;
            this.subLabel = subLabel;
            details = new HintInfo(hint);
            this.level = action;
        }
    }

    @Data
    public static class HintInfo {
        private List<String> hint;
        public HintInfo() {
        }
        public HintInfo(String hint) {
            if (StringUtils.isNotBlank(hint)) {
                this.hint = new Gson().fromJson(hint, new TypeToken<List<String>>() {}.getType());
            } else {
                this.hint = new ArrayList<>();
            }
        }
    }
}
