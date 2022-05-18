package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.image.v5.callback.ImageCallback;
import com.netease.yidun.sdk.antispam.image.v5.check.ImageV5CheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.request.ImageV5SyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片同步检测demo
 */
public class ImageSyncCheckDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ImageClient imageClient = new ImageClient(antispamRequester);

        // 图片检测结果会由于算法升级或者人工鉴别可能产生最新准确的结果，强烈建议通过轮询回调或者主动回调（2选1）的方式，来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
//        CallbackProfile callbackProfile = new CallbackProfile("BusinessId");
//        // 调整轮询回调的最大线程数，不设置则默认值为3
//        callbackProfile.setConcurrency(2);
//        ImageCallback imageCallback = new ImageCallback(callbackProfile) {
//            @Override
//            public void handle(List<ImageV5Result> callbackData) {
//                // 处理轮询回调的结果，需保证幂等性
//            }
//        };
//        // 为了保证服务进程关闭时，回调数据能够被有效处理，不会因为进程关闭而丢失，建议在进程关闭的hook（例如：spring中的@PreDestroy）中调用 imageCallback.close()
//
//        ImageClient imageClient = new ImageClient(antispamRequester, imageCallback);

        // 实例化请求对象
        ImageV5SyncCheckRequest checkRequest = new ImageV5SyncCheckRequest();
        // 设置易盾内容安全分配的businessId
        checkRequest.setBusinessId("BusinessId");

        // 根据需要设置请求的检测节点，默认杭州，现阶段只支持检测接口
        checkRequest.setRegionCode("cn-hangzhou");

        // 实例化要检测的图片对象
        ImageV5CheckRequest.ImageBeanRequest image = new ImageV5CheckRequest.ImageBeanRequest();
        image.setData("待检测的图片url 或者 图片base64");
        image.setName("图片名称(或图片标识)");
        // 设置图片数据的类型，1：图片URL，2:图片BASE64
        image.setType(1);
        // 非必填，强烈建议通过轮询回调或者主动回调（2选1）的方式，来获取最新的检测结果。主动回调数据接口超时时间默认设置为2s，为了保证顺利接收数据，需保证接收接口性能稳定并且保证幂等性。
        image.setCallbackUrl("主动回调地址");

        // 设置需要检测的图片列表，最大32张或者10M
        List<ImageV5CheckRequest.ImageBeanRequest> images = new ArrayList<>();
        images.add(image);
        checkRequest.setImages(images);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        ImageV5CheckResponse checkResponse = null;
        try {
            // 发起同步检测的请求
            checkResponse = imageClient.syncCheckImage(checkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            for (ImageV5Result imageV5Result : checkResponse.getResult()) {
                // 根据需要获取每张图片的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
            }
        }

    }
}
