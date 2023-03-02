package com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.liveperson.LivePersonClient;

/**
 * 交互式人脸核身接口demo
 */
public class InteractiveLivePersonIdCardCheckDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        LivePersonClient livePersonClient = new LivePersonClient("secretId", "secretKey");
        // 填充请求参数
        InteractiveLivePersonIdCardCheckRequest request = new InteractiveLivePersonIdCardCheckRequest("businessId")
                .cardNo("111234120001011236")
                // 数据的唯一标识
                .dataId("123456")
                .name("张三")
                // 是否需要返回正面照,默认不返照
                .needAvatar(false)
                // 返回的正面照图片类型(非必填)
                .picType(PicType.URL)
                .token("a621n2hju51n43");

        InteractiveLivePersonIdCardCheckResponse response = null;
        try {
            response = livePersonClient.checkCompositeInteractive(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            InteractiveLivePersonIdCardCheckResult result = response.getResult();
            // result 为校验结果数据，具体字段详细信息可参考官网文档
        }
    }

}
