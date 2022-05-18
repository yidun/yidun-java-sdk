package com.netease.yidun.sdk.antispam.livevideo.query.v1.request;

import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveWallMonitorRecordQueryResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * 点播根据id查询请求
 */
@Getter
@Setter
public class LiveWallMonitorRecordQueryReq extends BizPostFormRequest<LiveWallMonitorRecordQueryResp> {

    /**
     * 直播taskId;
     */
    private String taskId;

    public LiveWallMonitorRecordQueryReq() {
        productCode = "liveVideo";
        uriPattern = "/v1/livewall/query/monitor";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskId", getTaskId());
        return params;
    }

    /**
     * @return
     */
    @Override
    public Class<LiveWallMonitorRecordQueryResp> getResponseClass() {
        return LiveWallMonitorRecordQueryResp.class;
    }
}
