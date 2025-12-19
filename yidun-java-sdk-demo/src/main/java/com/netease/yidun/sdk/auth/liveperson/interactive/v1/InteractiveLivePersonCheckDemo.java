package com.netease.yidun.sdk.auth.liveperson.interactive.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.liveperson.LivePersonClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 交互式活体检测demo
 */
public class InteractiveLivePersonCheckDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        LivePersonClient livePersonClient = new LivePersonClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        LivePersonClient client = new LivePersonClient(profile);
        // 填充请求参数
        InteractiveLivePersonCheckRequest request = new InteractiveLivePersonCheckRequest("businessId");
        // SDK认证通过的token，唯一标记一次活体检测(必填)
        request.setToken("a621n2hju51n43");
        // 是否需要返回正面照(非必填)
        request.setNeedAvatar(true);
        // 返回的正面照图片类型(非必填)
        request.setPicType(PicType.URL);
        // 数据标识，可传入用户标识等数据，便于数据查询(非必填)
        request.setDataId("dataId");
        //协议类型http
        request.setProtocol(ProtocolEnum.HTTP);

        InteractiveLivePersonCheckResponse response = null;
        try {
            response = livePersonClient.checkInteractive(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            InteractiveLivePersonCheckResult result = response.getResult();
            // result 为校验结果数据
        }
    }
}
