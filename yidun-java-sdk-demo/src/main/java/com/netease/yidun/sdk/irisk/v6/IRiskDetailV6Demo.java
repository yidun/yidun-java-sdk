package com.netease.yidun.sdk.irisk.v6;

import com.google.gson.Gson;
import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.core.utils.CollectionUtils;
import com.netease.yidun.sdk.irisk.v6.detail.DetailDataV6;
import com.netease.yidun.sdk.irisk.v6.detail.IRiskDetailV6Request;
import com.netease.yidun.sdk.irisk.v6.detail.IRiskDetailV6Response;
import com.netease.yidun.sdk.irisk.v6.detail.IRiskDetailV6Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuhanyu@corp.netease.com
 * @version 2024/2/4
 */
public class IRiskDetailV6Demo extends AbstractDemo {

    public static void main(String[] args) {

        IRiskV6Client client = IRiskV6Client.getInstance("SecretId", "SecretKey");
        IRiskDetailV6Request request = new IRiskDetailV6Request("businessId");
        request.setTimestamp(System.currentTimeMillis());
        request.setNonce("dsdsfabnfadsfascfadsfamnfadsfasd");
        request.setBeginTimestamp(1706977448665L);
        request.setEndTimestamp(1707013473238L);
        request.setAccount("account1");
        List<String> accList = new ArrayList<>();
        accList.add("account1");
        request.setAccounts(new Gson().toJson(accList));
        IRiskDetailV6Response iRiskDetailV6Response = client.detailV6(request);
        if (iRiskDetailV6Response != null && iRiskDetailV6Response.getCode() == 200) {
            IRiskDetailV6Result data = iRiskDetailV6Response.getData();
            if (data == null || data.getSize() == 0 || CollectionUtils.isEmpty(data.getDetail())) {
                System.out.println("data is null");
                return;
            }
            List<DetailDataV6> detail = data.getDetail();
            for (DetailDataV6 detailDataV6 : detail) {
                System.out.println(detailDataV6);
            }
        }
    }
}
