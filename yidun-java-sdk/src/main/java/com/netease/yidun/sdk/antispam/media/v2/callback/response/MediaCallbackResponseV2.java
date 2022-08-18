package com.netease.yidun.sdk.antispam.media.v2.callback.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntiCheatResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntispamResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaCensorResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaValueAddServiceResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 融媒体v2版本回调结果
 */
public class MediaCallbackResponseV2 extends CommonResponse {

    private List<MediaCheckResult> result;

    public List<MediaCheckResult> getResult() {
        return result;
    }

    public void setResult(List<MediaCheckResult> result) {
        this.result = result;
    }

    public static class MediaCheckResult {
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
         * 审核信息
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
    }
}
