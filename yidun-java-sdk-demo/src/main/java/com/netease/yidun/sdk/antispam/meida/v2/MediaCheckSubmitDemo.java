package com.netease.yidun.sdk.antispam.meida.v2;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.media.v2.MediaClient;
import com.netease.yidun.sdk.antispam.media.v2.common.constant.DataType;
import com.netease.yidun.sdk.antispam.media.v2.submit.request.MediaSubmitRequestV2;
import com.netease.yidun.sdk.antispam.media.v2.submit.response.MediaCheckResponseV2;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 融媒体解决方案Demo
 * 检测提交接口
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/599750646047514624?docId=599764067733090304
 */
public class MediaCheckSubmitDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        MediaClient mediaClient = MediaClient.getInstance(antispamRequester);

        // 构建一个文本解析内容
        List<MediaSubmitRequestV2.DataItem> list = new ArrayList<>();
        MediaSubmitRequestV2.DataItem dataItem = new MediaSubmitRequestV2.DataItem();
        dataItem.data("测试文本内容，正常的正常的").type(DataType.TEXT.getType()).dataId("123");
        list.add(dataItem);

        //key = 可自定义 value = 自定义解析内容(详见官方文档了解可解析内容)
        Map<String, List<MediaSubmitRequestV2.DataItem>> map = new HashMap<>();
        map.put("text1", list);

        // 实例化请求对象
        MediaSubmitRequestV2 request = new MediaSubmitRequestV2().ip("127.0.0.1")
                .customParseFieldMap(map)

                .dataId("000000")
                .account("account1");
        request.setProtocol(ProtocolEnum.HTTP);
        //根据需要设置请求的检测节点，默认杭州，现阶段只支融媒体提交检测接口
        request.setRegionCode("cn-hangzhou");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        MediaCheckResponseV2 response = null;
        try {
            // 发起同步检测的请求
            response = mediaClient.submit(request);
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
