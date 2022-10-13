package com.netease.yidun.sdk.antispam.image;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.v5.ImageClient;
import com.netease.yidun.sdk.antispam.image.v5.check.ImageV5CheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.request.ImageV5AsyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.response.ImageV5AsyncCheckResp;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.request.ImageV5SyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.recover.AbstractRequestRecoverHandler;
import com.netease.yidun.sdk.antispam.recover.DefaultRequestRecover;
import com.netease.yidun.sdk.antispam.recover.RecoverConfig;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ImageRecoverTest {

    private List<ImageV5CheckRequest.ImageBeanRequest> images;

    @Before
    public void preImageList() {

        List<String> lines = Arrays.asList(
                "https://nos.netease.com/yidun/FTX-vdv04MuDi7k8Qn5q",
                "http://zyspam1.iupvideo.net/zyvd/81/20/aa61-5cf7-4f66-af7b-fbd0cd33db0f/00006.jpg",
                "http://nisptools.nos.netease.com/9f6ea61306c648d09460b3c38e0c40b0.jpeg",
                "http://nisptools.nos.netease.com/626494c755694abb9094133ca28aa71a.jpeg",
                "http://nisptools.nos.netease.com/ab71863b603444bfba3d3a67394fe6b7.png");
        images = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            ImageV5CheckRequest.ImageBeanRequest imageBean = new ImageV5CheckRequest.ImageBeanRequest();
            imageBean.setName("" + i);
            imageBean.setType(1);
            imageBean.setData(lines.get(i));
            images.add(imageBean);
        }
        AntispamRequester antispamRequester = new AntispamRequester(Constants.SECRET_ID, Constants.SECRET_KEY);
    }

    @Test
    public void testRecoverFallback() {
        ClientProfile clientProfile = ClientProfile.defaultProfile(Constants.SECRET_ID, Constants.SECRET_KEY);
        RecoverConfig recoverConfig = new RecoverConfig();
        recoverConfig.setRecoverFileDir("/Users/zhaojipu/Downloads");
        recoverConfig.setInitialDelayInSec(10);
        DefaultRequestRecover requestRecover = DefaultRequestRecover.createRecover(recoverConfig);
        requestRecover.registerRecoverHandler(new AbstractRequestRecoverHandler<ImageV5CheckResponse>() {
            @Override
            public void handle(ImageV5CheckResponse response) {
                System.out.println("1111111111111111" + new Gson().toJson(response));
            }
        });
        ImageV5CheckResponse fallbackResp = new ImageV5CheckResponse();
        fallbackResp.setCode(100);
        fallbackResp.setMsg("error return");
        requestRecover.registerFallback(fallbackResp);
        requestRecover.start();
        clientProfile.setRequestRecover(requestRecover);


        AntispamRequester antispamRequester = new AntispamRequester(clientProfile);
        ImageClient imageClient = new ImageClient(antispamRequester);


        ImageV5SyncCheckRequest request = new ImageV5SyncCheckRequest();
        request.setBusinessId(Constants.BUSINESS_ID);
        request.setProtocol(ProtocolEnum.HTTP);
        request.setImages(images);
        request.setDomain("http://test.recover.com");

        ImageV5CheckResponse result = imageClient.syncCheckImage(request);

        System.out.println(new Gson().toJson(result));

        Assert.assertNotNull(result);
        Assert.assertEquals(100, result.getCode());

    }

    @Test
    public void testRecoverWithoutFallback() throws InterruptedException {
        ClientProfile clientProfile = ClientProfile.defaultProfile(Constants.SECRET_ID, Constants.SECRET_KEY);
        RecoverConfig recoverConfig = new RecoverConfig();
        recoverConfig.setRecoverFileDir("/Users/zhaojipu/Downloads");
        recoverConfig.setInitialDelayInSec(10);
        DefaultRequestRecover requestRecover = DefaultRequestRecover.createRecover(recoverConfig);
        requestRecover.registerRecoverHandler(new AbstractRequestRecoverHandler<ImageV5CheckResponse>() {
            @Override
            public void handle(ImageV5CheckResponse response) {
                System.out.println("1111111111111111" + new Gson().toJson(response));
            }
        });
        requestRecover.start();
        clientProfile.setRequestRecover(requestRecover);

        AntispamRequester antispamRequester = new AntispamRequester(clientProfile);
        ImageClient imageClient = new ImageClient(antispamRequester);


        ImageV5SyncCheckRequest request = new ImageV5SyncCheckRequest();
        request.setBusinessId(Constants.BUSINESS_ID);
        request.setProtocol(ProtocolEnum.HTTP);
        request.setImages(images);
        request.setDomain("http://test.recover.com");

        ImageV5CheckResponse result = imageClient.syncCheckImage(request);

        System.out.println(new Gson().toJson(result));

        Assert.assertNotNull(result);
        Assert.assertEquals(200, result.getCode());
    }

    @Test
    public void testRecoverMulti() throws InterruptedException {
        ClientProfile clientProfile = ClientProfile.defaultProfile(Constants.SECRET_ID, Constants.SECRET_KEY);
        RecoverConfig recoverConfig = new RecoverConfig();
        recoverConfig.setRecoverFileDir("/Users/zhaojipu/Downloads");
        recoverConfig.setInitialDelayInSec(10);
        recoverConfig.setRecoverFailRetryIntervalInSec(10);
        DefaultRequestRecover requestRecover = DefaultRequestRecover.createRecover(recoverConfig);
        clientProfile.setRequestRecover(requestRecover);
        requestRecover.registerRecoverHandler(new AbstractRequestRecoverHandler<ImageV5CheckResponse>() {
            @Override
            public void handle(ImageV5CheckResponse response) {
                System.out.println("1111111111111111" + new Gson().toJson(response));
            }
        });
        requestRecover.registerRecoverHandler(new AbstractRequestRecoverHandler<TextCheckResponse>() {
            @Override
            public void handle(TextCheckResponse response) {
                System.out.println("22222222222222222" + new Gson().toJson(response));
            }
        });
        requestRecover.registerRecoverHandler(new AbstractRequestRecoverHandler<ImageV5AsyncCheckResp>() {
            @Override
            public void handle(ImageV5AsyncCheckResp response) {
                System.out.println("3333333333333333333" + new Gson().toJson(response));
            }
        });

        ImageV5CheckResponse fallbackResp = new ImageV5CheckResponse();
        fallbackResp.setCode(100);
        TextCheckResponse textFallback = new TextCheckResponse();
        textFallback.setCode(110);

        requestRecover.registerFallback(fallbackResp);
        requestRecover.registerFallback(textFallback);

        AntispamRequester antispamRequester = new AntispamRequester(clientProfile);
        ImageClient imageClient = new ImageClient(antispamRequester);

        ImageV5SyncCheckRequest request = new ImageV5SyncCheckRequest();
        request.setBusinessId(Constants.BUSINESS_ID);
        request.setProtocol(ProtocolEnum.HTTP);
        request.setImages(images);

        ImageV5CheckResponse result = imageClient.syncCheckImage(request);
        System.out.println(new Gson().toJson(result));
        Assert.assertEquals(100, result.getCode());

        try {
            ImageV5AsyncCheckRequest asyncCheckRequest = new ImageV5AsyncCheckRequest();
            asyncCheckRequest.setImages(images);
            asyncCheckRequest.setBusinessId(Constants.BUSINESS_ID);
            asyncCheckRequest.setProtocol(ProtocolEnum.HTTP);
            ImageV5AsyncCheckResp v5AsyncCheckResp = imageClient.asyncCheckImage(asyncCheckRequest);
            Assert.assertEquals(200, v5AsyncCheckResp.getCode());
        } catch (YidunSdkException e) {
            Assert.assertNotNull(e);
        }


        TextCheckRequest textCheckRequest = new TextCheckRequest();
        textCheckRequest.protocol(ProtocolEnum.HTTP);
        textCheckRequest.setBusinessId("410791d89b4c1631b03f34fbb9016091");
        textCheckRequest.setDataId("" + System.currentTimeMillis());
        textCheckRequest.setContent("测试文本单次同步检测操");
        textCheckRequest.setTitle("测试文本单次同步检测操");
        textCheckRequest.setDataType(0);
        textCheckRequest.setCallback("callback");

        TextClient textClient = new TextClient(antispamRequester);
        TextCheckResponse textCheckResponse = textClient.syncCheckText(textCheckRequest);
        System.out.println(new Gson().toJson(textCheckResponse));
        Assert.assertEquals(110, textCheckResponse.getCode());

        Thread.sleep(600000);
    }
}
