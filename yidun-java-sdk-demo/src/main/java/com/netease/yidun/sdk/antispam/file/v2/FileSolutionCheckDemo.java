package com.netease.yidun.sdk.antispam.file.v2;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.file.v2.submit.request.FileSubmitV2Request;
import com.netease.yidun.sdk.antispam.file.v2.submit.response.FileSubmitV2Response;

/**
 * 文档解决方案Demo
 * 检测提交接口
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/596426875864846336?docId=596429879784906752
 */
public class FileSolutionCheckDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        FileSolutionClient fileSolutionClient = FileSolutionClient.getInstance(antispamRequester);

        // 实例化请求对象
        FileSubmitV2Request request = new FileSubmitV2Request();
        request.setUrl("http://nisptools.nos.netease.com/3cd824f0e64744a1b0f18f9698495c97.doc");
        request.setAccount("file_mock");
        request.setFileName("fileName_mock");
        request.setIp("127.0.0.1");
        request.setDataId("dataId_" + request.getUrl());
        request.setCallback("callback_" + request.getUrl());

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        FileSubmitV2Response response = null;
        try {
            // 发起同步检测的请求
            response = fileSolutionClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            if (response.getResult() != null){
                //doSomething
            }
        }

    }
}
