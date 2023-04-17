package com.netease.yidun.sdk.antispam.list.imagelist;

import com.google.gson.Gson;
import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.list.ListClient;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitResp;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitResponse;

import java.util.HashSet;
import java.util.Set;

/**
 * 忽略词添加demo
 */
public class ImageListSubmitDemo extends AbstractDemo {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ListClient listClient = new ListClient(antispamRequester);
        // 实例化请求对象
        ImageListSubmitRequest submitRequest = new ImageListSubmitRequest();
        // 设置易盾内容安全分配的businessId
        submitRequest.setBusinessId("BusinessId");

        // 设置添加忽略词内容
        Set<String> images = new HashSet<>();
        images.add("url");
        submitRequest.setImages(GSON.toJson(images));
        submitRequest.setListType(2);
        submitRequest.setImageLabel(100);
        submitRequest.setImageType(1);
        submitRequest.setType(1);
        submitRequest.setDescription("图片名单描述");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        ImageListSubmitResponse submitResponse = null;
        try {
            // 发起提交请求
            submitResponse = listClient.submitImageList(submitRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (submitResponse != null && submitResponse.getCode() == 200) {
            ImageListSubmitResp result = submitResponse.getResult();
            // 根据需要获取忽略词的添加结果，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }


}
