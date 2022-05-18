
package com.netease.yidun.sdk.antispam.audio.query.v3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.audio.AudioClient;
import com.netease.yidun.sdk.antispam.audio.query.v3.request.AudioQueryV3Request;
import com.netease.yidun.sdk.antispam.audio.query.v3.response.AudioAsrContextResponseV3;
import com.netease.yidun.sdk.antispam.audio.query.v3.response.AudioLanguageResponseV3;
import com.netease.yidun.sdk.antispam.audio.query.v3.response.AudioQueryUnitResponseV3;
import com.netease.yidun.sdk.antispam.audio.query.v3.response.AudioQueryV3Response;
import com.netease.yidun.sdk.antispam.audio.query.v3.response.AudioVoiceResponseV3;

public class AudioQueryDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        AudioClient audioClient = new AudioClient(antispamRequester);

        // 实例化反馈请求对象
        AudioQueryV3Request queryRequest = new AudioQueryV3Request();
        // 设置易盾内容安全分配的businessId
        queryRequest.setBusinessId("BusinessId");
        Set<String> taskIds = new HashSet<>();
        taskIds.add("需要查询的音频任务 id 1");
        taskIds.add("需要查询的音频任务 id 2");
        queryRequest.setTaskIds(taskIds);
        AudioQueryV3Response audioQueryV3Response = null;
        try {
            // 发起查询请求
            audioQueryV3Response = audioClient.query(queryRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (audioQueryV3Response != null && audioQueryV3Response.getCode() == 200) {
            // 同步检测结果
            List<AudioQueryUnitResponseV3> antispam = audioQueryV3Response.getAntispam();
            List<AudioLanguageResponseV3> language = audioQueryV3Response.getLanguage();
            List<AudioAsrContextResponseV3> asr = audioQueryV3Response.getAsr();
            List<AudioVoiceResponseV3> voice = audioQueryV3Response.getVoice();
        }

    }
}
