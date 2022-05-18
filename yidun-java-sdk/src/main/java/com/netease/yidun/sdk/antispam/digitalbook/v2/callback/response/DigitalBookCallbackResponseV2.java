package com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntiCheatResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntispamResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaCensorResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaValueAddServiceResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 数字阅读v2版本回调结果
 */
public class DigitalBookCallbackResponseV2 extends CommonResponse {

    private List<DigitalBookCheckResult> result;

    public List<DigitalBookCheckResult> getResult() {
        return result;
    }

    public void setResult(List<DigitalBookCheckResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DigitalBookCallbackResponseV2{" +
                "result=" + result +
                '}';
    }

    public static class DigitalBookCheckResult {
        /**
         * 反垃圾结果
         */
        private MediaAntispamResponse antispam;
        /**
         * 增值服务结果
         */
        private MediaValueAddServiceResponse valueAddService;

        /**
         * 反作弊信息
         */
        private MediaAntiCheatResponse anticheat;

        /**
         * 审核嘻嘻
         */
        private MediaCensorResponse censor;

        public MediaAntispamResponse getAntispam() {
            return antispam;
        }

        public void setAntispam(MediaAntispamResponse antispam) {
            this.antispam = antispam;
        }

        public MediaValueAddServiceResponse getValueAddService() {
            return valueAddService;
        }

        public void setValueAddService(MediaValueAddServiceResponse valueAddService) {
            this.valueAddService = valueAddService;
        }

        public MediaAntiCheatResponse getAnticheat() {
            return anticheat;
        }

        public void setAnticheat(MediaAntiCheatResponse anticheat) {
            this.anticheat = anticheat;
        }

        public MediaCensorResponse getCensor() {
            return censor;
        }

        public void setCensor(MediaCensorResponse censor) {
            this.censor = censor;
        }

        @Override
        public String toString() {
            return "MediaCheckResult{" +
                    "antispam=" + antispam +
                    ", valueAddService=" + valueAddService +
                    ", anticheat=" + anticheat +
                    ", censor=" + censor +
                    '}';
        }
    }
}
