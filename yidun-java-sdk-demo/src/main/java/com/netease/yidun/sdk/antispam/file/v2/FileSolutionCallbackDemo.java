package com.netease.yidun.sdk.antispam.file.v2;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.file.v2.callback.request.FileCallbackV2Request;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 文档解决方案Demo
 * 结果获取-轮询模式
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/596426875864846336?docId=596429949429846016
 */
public class FileSolutionCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        FileSolutionClient fileSolutionClient = FileSolutionClient.getInstance(antispamRequester);

        // 实例化请求对象
        FileCallbackV2Request request = new FileCallbackV2Request();
        request.setProtocol(ProtocolEnum.HTTP);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        FileCallbackV2Response response = null;
        try {
            // 发起同步检测的请求
            response = fileSolutionClient.callback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            for (FileCallbackV2Response.FileCallbackV2Resp result : response.getResult()) {
                //doSomething
            }
        }

    }
}
