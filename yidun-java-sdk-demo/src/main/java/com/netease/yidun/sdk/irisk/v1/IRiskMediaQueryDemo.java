package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.irisk.v1.mediacheck.*;

import java.util.List;

/**
 * 【智能风控】图片外挂检测结果查询接口demo
 */
public class IRiskMediaQueryDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = IRiskClient.getInstance("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskMediaQueryRequest request = new IRiskMediaQueryRequest("businessId");
        // 检测任务 ID
        request.setTaskId("e6ewxylcm62kh1a7yra3hxdgdd00a7p4");

        IRiskMediaQueryResponse response = null;
        try {
            response = iRiskClient.mediaQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            IRiskMediaQueryResult data = response.getData();
            //请求收到时间
            Long receiveTime = data.getReceiveTime();
            //用户/玩家的IP
            String ip = data.getIp();
            //用户/玩家的角色ID
            String roleId = data.getRoleId();
            //用户/玩家的昵称
            String nickname = data.getNickname();
            //用户/玩家的角色的服务器名称
            String server = data.getServer();
            //检测状态：-1:未检测， 0:正常， 1:异常
            Integer status = data.getStatus();
            //命中标签名称列表
            List<String> tagNameList = data.getTagNameList();
            //详情
            String reason = data.getReason();
        }

    }
}
