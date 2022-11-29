/*
 * @(#) SolutionEnrichEvidence.java 2022-11-25
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import com.netease.yidun.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * @author luozhigang
 * @version 2022-11-25
 */
public class SolutionEnrichEvidence {

    private List<FailedUnit> failedUnits;

    public List<FailedUnit> getFailedUnits() {
        return failedUnits;
    }

    public void setFailedUnits(List<FailedUnit> failedUnits) {
        this.failedUnits = failedUnits;
    }

    public static class FailedUnit {
        private String dataId;
        private Integer failureReason;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public Integer getFailureReason() {
            return failureReason;
        }

        public void setFailureReason(Integer failureReason) {
            this.failureReason = failureReason;
        }
    }
}
