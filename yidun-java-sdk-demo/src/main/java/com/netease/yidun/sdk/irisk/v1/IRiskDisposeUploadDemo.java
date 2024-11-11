package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.irisk.v1.dispose.IRiskDisposeUploadRequest;
import com.netease.yidun.sdk.irisk.v1.dispose.IRiskDisposeUploadResponse;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/7 09:55
 */
public class IRiskDisposeUploadDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        IRiskClient iRiskClient = IRiskClient.getInstance("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
        // ClientProfile profile = createProfile("secretId", "secretKey");
        // IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskDisposeUploadRequest request = new IRiskDisposeUploadRequest("businessId");
        // 需要进行处置的对象的类型
        request.setHandleObjectType(1);
        // 账号
        request.setActionDes("actionDes");
        // 处置动作
        request.setAction(1);
        // 处置原因
        request.setReason("reason");
        // 封禁/处置对象的ID
        request.setObjectId("objectId");
        // 角色ID
        request.setRoleId("roleId");
        IRiskDisposeUploadResponse disposeUploadResponse = null;
        try {
            disposeUploadResponse = iRiskClient.disposeUpload(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (disposeUploadResponse != null && disposeUploadResponse.getCode() == 200) {
            // 上报成功
        }
    }
}
