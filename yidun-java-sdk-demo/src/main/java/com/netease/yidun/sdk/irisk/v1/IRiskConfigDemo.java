package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigRequest;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigResponse;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigResult;

/**
 * 【智能风控】配置下发接口demo
 */
public class IRiskConfigDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = IRiskClient.getInstance("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskConfigRequest request = new IRiskConfigRequest("businessId");
        // 协议类型，HTTP/HTTPS
        request.setProtocol(ProtocolEnum.HTTP);
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
