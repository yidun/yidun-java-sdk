package com.netease.yidun.sdk.fingerprint;

import com.netease.yidun.sdk.core.http.ProtocolEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DeviceClientTest {

    @Test
    public void query() {
        DeviceQueryRequest deviceQueryRequest = new DeviceQueryRequest("businessId");
        deviceQueryRequest.setProtocol(ProtocolEnum.HTTP);
        deviceQueryRequest.setToken("token");
        DeviceClient deviceClient = new DeviceClient("secretId","secretKey");
        DeviceQueryResponse query = deviceClient.query(deviceQueryRequest);
        assertEquals(401, query.getCode());
    }
}