package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.irisk.v1.mediacheck.*;

import java.util.List;

/**
 * 【智能风控】图片外挂检测结果批量查询接口demo
 */
public class IRiskMediaBatchQueryDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = IRiskClient.getInstance("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskMediaBatchQueryRequest request = new IRiskMediaBatchQueryRequest("businessId");
        // 协议类型，HTTP/HTTPS
        request.setProtocol(ProtocolEnum.HTTP);
        // 检测任务 ID
        request.setTaskIds("[\"tpavc9q43b0ihy5ekc5g2axgdd00aaxs\",\"1ggpjkqx07qoopc35w8b2ybgdd00aaxs\"]");

        IRiskMediaBatchQueryResponse response = null;
        try {
            response = iRiskClient.mediaBatchQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            List<IRiskMediaQueryResult> data = response.getData();
            if (!data.isEmpty()) {
                for (IRiskMediaQueryResult result : data) {
                    //请求收到时间
                    Long receiveTime = result.getReceiveTime();
                    //用户/玩家的IP
                    String ip = result.getIp();
                    //用户/玩家的角色ID
                    String roleId = result.getRoleId();
                    //用户/玩家的昵称
                    String nickname = result.getNickname();
                    //用户/玩家的角色的服务器名称
                    String server = result.getServer();
                    //检测状态：-1:未检测， 0:正常， 1:异常
                    Integer status = result.getStatus();
                    //命中标签名称列表
                    List<String> tagNameList = result.getTagNameList();
                    //详情
                    String reason = result.getReason();
                }
            }
        }

    }
}
