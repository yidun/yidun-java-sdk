package com.netease.yidun.sdk.profile;

import com.netease.yidun.sdk.profile.v1.ProfileClient;
import com.netease.yidun.sdk.profile.v1.check.CollectInfo;
import com.netease.yidun.sdk.profile.v1.check.ProfileCheckRequest;
import com.netease.yidun.sdk.profile.v1.check.ProfileCheckResponse;
import com.netease.yidun.sdk.profile.v1.check.ProfileCheckResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 【风险画像】风险画像数据上报接口demo
 */
public class ProfileCheckDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        ProfileClient profileClient = new ProfileClient("SecretId", "SecretKey");
        // 填充请求参数
        ProfileCheckRequest request = new ProfileCheckRequest("businessId");

        List<CollectInfo> collectInfoList = new ArrayList<>();
        CollectInfo collectInfo = new CollectInfo();
        collectInfo.dataId("testDataId")
                .ip("127.0.0.1")
                .phone("17312341234")
                .title("测试标题")
                // 用户发表内容，建议对内容中JSON、表情符、HTML标签、UBB标签等做过滤，只传递纯文本，以减少误判概率
                .content("这是一些测试的内容")
                .receiveUid("testUid")
                // 注意这里是13位长度的long类型时间戳
                .publishTime(1677671006000L)
                .account("testAccount");

        collectInfoList.add(collectInfo);
        request.setTexts(collectInfoList);

        ProfileCheckResponse checkResponse = null;
        try {
            checkResponse = profileClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            ProfileCheckResult data = checkResponse.getData();
            // token为数据上传成功的唯一标识
            String token = data.getToken();
        }
    }
}
