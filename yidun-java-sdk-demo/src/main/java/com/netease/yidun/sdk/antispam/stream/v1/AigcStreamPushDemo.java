package com.netease.yidun.sdk.antispam.stream.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.stream.v1.push.AigcStreamPushRequestV1;
import com.netease.yidun.sdk.antispam.stream.v1.push.AigcStreamPushResponseV1;
import com.netease.yidun.sdk.core.http.ProtocolEnum;


/**
 * AIGC流式解决方案Demo
 * 检测提交接口
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/953823904240750592?docId=953841408377774080
 */
public class AigcStreamPushDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        AigcStreamClient aigcStreamClient = AigcStreamClient.getInstance(antispamRequester);

        String sessionId = "yourSessionId" + System.currentTimeMillis();
        // 输入会话检测 demo
        pushDemoForInputCheck(aigcStreamClient, sessionId);
        
        // 输出会话流式检测 demo 
        pushDemoForOutputStreamCheck(aigcStreamClient, sessionId);
        
        // 输出会话完毕后关闭会话 demo
        pushDemoForOutputStreamClose(aigcStreamClient, sessionId);
    }
    
    private static void pushDemoForInputCheck(AigcStreamClient aigcStreamClient, String sessionId) {
        // type = 2：content必传，流式检测场景下输入内容，建议对内容中json、表情符、HTML标签、UBB标签等做过滤，只传递纯文本，以减少误判概率，对应传入AIGC-输入文本中，最大长度10000
        AigcStreamPushRequestV1 request = new AigcStreamPushRequestV1();
        request.setProtocol(ProtocolEnum.HTTP);
        request.setSessionId(sessionId);
        request.setType(StreamCheckPushType.INPUT_CHECK.getCode());
        request.setDataId("yourDataId");
        request.setContent("当前会话输入的内容");
        request.setPublishTime(System.currentTimeMillis());
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        AigcStreamPushResponseV1 response = null;
        try {
            // 发起同步检测的请求
            response = aigcStreamClient.push(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            if (response.getResult() != null){
                //doSomething
            }
        }
    }

    private static void pushDemoForOutputStreamCheck(AigcStreamClient aigcStreamClient, String sessionId) {
        // type = 1：content必传，流式检测内容片段，可对应aigc场景流式输出的tokens，检测片段传入AIGC-输出文本中，最大长度200
        AigcStreamPushRequestV1 request = new AigcStreamPushRequestV1();
        request.setProtocol(ProtocolEnum.HTTP);
        request.setSessionId(sessionId);
        request.setType(StreamCheckPushType.STREAM_OUTPUT_CHECK.getCode());
        request.setDataId("yourDataId");
        request.setContent("当前输出片段1");
        request.setPublishTime(System.currentTimeMillis());
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        AigcStreamPushResponseV1 response = null;
        try {
            // 发起同步检测的请求
            response = aigcStreamClient.push(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            if (response.getResult() != null){
                //doSomething
            }
        }
    }

    private static void pushDemoForOutputStreamClose(AigcStreamClient aigcStreamClient, String sessionId) {
        // type = 3：会话结束，content不需要传，如果传了则合并后一起检测
        AigcStreamPushRequestV1 request = new AigcStreamPushRequestV1();
        request.setProtocol(ProtocolEnum.HTTP);
        request.setSessionId(sessionId);
        request.setType(StreamCheckPushType.SESSION_END.getCode());
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        AigcStreamPushResponseV1 response = null;
        try {
            // 发起同步检测的请求
            response = aigcStreamClient.push(request);
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
