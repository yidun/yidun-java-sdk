package com.netease.yidun.sdk.irisk.v6;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.core.utils.GsonUtils;
import com.netease.yidun.sdk.irisk.v6.check.v600.deviceinfo.AndroidDeviceInfoResult;
import com.netease.yidun.sdk.irisk.v6.check.v602.HitInfoV602;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneInfo;
import com.netease.yidun.sdk.irisk.v6.check.v604.IRiskCheckV604Request;
import com.netease.yidun.sdk.irisk.v6.check.v604.IRiskCheckV604Result;
import com.netease.yidun.sdk.irisk.v6.check.v604.account.AccountRiskInfo;
import com.netease.yidun.sdk.irisk.v6.check.v604.device.DeviceRiskInfo;
import com.netease.yidun.sdk.irisk.v6.check.v604.ip.IpRiskInfoV604;
import com.netease.yidun.sdk.irisk.v6.check.v604.phone.PhoneRiskInfoV604;

import java.util.List;

public class IRiskCheckV604Demo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskV6Client iRiskClient = IRiskV6Client.getInstance("SecretId", "SecretKey");

        // 填充请求参数
        IRiskCheckV604Request request = new IRiskCheckV604Request("businessId");
        // 协议类型，HTTP/HTTPS
        request.setProtocol(ProtocolEnum.HTTP);
        request.setTimestamp(System.currentTimeMillis());
        request.setNonce("fadsfasdfadsfasdfadsfasdfadsfasd");

        request.setToken("nRoN3S/jk1tFJlQAQUaAgCFM8e3ETfKa");

        request.setIp("192.168.1.1");
        request.setRoleId("001");
        request.setAccount("001");
        request.setNickname("");
        request.setLevel("");
        request.setPhone("");
        request.setActivityId("");
        request.setEmail("");
        request.setRegisterTime(System.currentTimeMillis());
        request.setRegisterIp("");
        request.setDeviceId("");
        request.setExtData("");

        // 不同场景接入需要提供的场景数据字段如请参照官网文档。
        // 注意：如接入场景未在已罗列支持的场景范围之内，sceneData内容可传入空串
        // 此处示例为注册场景的场景数据
        request.setSceneData(
                "{\"clickId\":\"\",\"gender\":\"male\",\"hashPassword\":\"\",\"inviter\":\"\",\"registerChannel\":\"qq\",\"registerType\":\"userPassword\",\"sceneType\":\"\"}");

        DataResponse<IRiskCheckV604Result> checkResponse = null;
        try {
            checkResponse = iRiskClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            IRiskCheckV604Result data = checkResponse.getData();

            List<HitInfoV602> hitInfos = data.getHitInfos();

            // 手机号风险信息
            PhoneInfo<PhoneBasicInfo, PhoneRiskInfoV604> phoneInfo = data.getPhoneInfo();
            PhoneRiskInfoV604 phoneRiskInfo = phoneInfo != null ? phoneInfo.getPhoneRiskInfo() : null;
            String phoneRecentTopRisk = phoneRiskInfo != null ? phoneRiskInfo.getRecentTopRisk() : null;

            // IP风险信息
            IpInfo<IpBasicInfo, IpRiskInfoV604> ipInfo = data.getIpInfo();
            IpBasicInfo ipBasicInfo = ipInfo != null ? ipInfo.getBasicInfo() : null;
            String countryCode = ipBasicInfo != null ? ipBasicInfo.getCountryCode() : null;
            IpRiskInfoV604 ipRiskInfo = ipInfo != null ? ipInfo.getIpRiskInfo() : null;
            String ipRecentTopRisk = ipRiskInfo != null ? ipRiskInfo.getRecentTopRisk() : null;

            // 设备风险信息（v604新增）
            DeviceRiskInfo deviceRiskInfo = data.getDeviceRiskInfo();
            String deviceRecentTopRisk = deviceRiskInfo != null ? deviceRiskInfo.getRecentTopRisk() : null;

            // 账号风险信息（v604新增）
            AccountRiskInfo accountRiskInfo = data.getAccountRiskInfo();
            String accountRecentTopRisk = accountRiskInfo != null ? accountRiskInfo.getRecentTopRisk() : null;

            // data 数据即为所需的check结果
            // deviceInfo: if Android then
            AndroidDeviceInfoResult deviceInfoAndroid = new Gson().fromJson(GsonUtils.toJson(data.getDeviceInfo()), AndroidDeviceInfoResult.class);
            String emulatorDid = deviceInfoAndroid.getEmulatorDid();
        }
    }

}
