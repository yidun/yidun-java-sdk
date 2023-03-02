package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.irisk.v1.detail.DetailData;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailRequest;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailResponse;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailResult;

import java.util.List;

/**
 * 【智能风控】数据查询接口demo
 */
public class IRiskDetailDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = new IRiskClient("SecretId", "SecretKey");
        // 填充请求参数
        IRiskDetailRequest request = new IRiskDetailRequest("businessId");
        // 传入查询时间范围，为毫秒时间戳，范围不能大于30天。（开始结束时间为必填字段）
        request.setBeginTimestamp(1676970236000L);
        request.setEndTimestamp(1677143036000L);

        request.setRoleId("用户/玩家的id");
        request.setIp("192.168.0.1");
        request.setAccount("用户/玩家的账号");
        // 客户端的包名
        request.setPackageName("com.xxx.test");
        // 用于分页查询的关联标记。第一次查询时，该字段填充空字符串""或不传该字段均可。
        // 后续查询时，需要判断上一次查询的返回数据中startFlag值，如果startFlag不为空字符串""，表示需要分页查询。
        request.setStartFlag("xxxxxxxxxxxxxxxxxxx");
        request.setRiskLevel(1);
        request.setAppVersion("1.0.0");
        IRiskDetailResponse detailResponse = null;
        try {
            detailResponse = iRiskClient.getDetail(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (detailResponse != null && detailResponse.getCode() == 200) {
            IRiskDetailResult result = detailResponse.getData();
            // 得到数据详情列表,具体字段请参考官方接口文档中字段说明
            List<DetailData> detailDataList = result.getDetail();
            // 本次返回的数据条数
            Integer size = result.getSize();
            // 用于分批查询的关联标记。
            // 1. 当查询需要分批返回数据时，表示下一批数据起始标记。
            // 2. 当该值返回为空字符串""时，表示数据都已经返回，不需要继续执行下一批查询
            String startFlag = result.getStartFlag();
        }
    }
}