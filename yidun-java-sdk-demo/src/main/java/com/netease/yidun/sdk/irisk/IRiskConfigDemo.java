package com.netease.yidun.sdk.irisk;

import com.netease.yidun.sdk.irisk.v1.IRiskClient;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigRequest;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigResponse;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigResult;

/**
 * 【智能风控】配置下发接口demo
 */
public class IRiskConfigDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = new IRiskClient("SecretId", "SecretKey");
        // 填充请求参数
        IRiskConfigRequest request = new IRiskConfigRequest("businessId");
        request.setIp("192.168.0.1");
        // 从风控客户端SDK获取的拉取配置的参数,原封不动传递给该参数
        request.setSdkData("xxxxxxxxxxxx");

        IRiskConfigResponse configResponse = null;
        try {
            configResponse = iRiskClient.getConfig(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (configResponse != null && configResponse.getCode() == 200) {
            IRiskConfigResult data = configResponse.getData();
            String configData = data.getConfigData();
            // configData即为需要返回给客户端的数据
        }
    }
}
