package com.netease.yidun.sdk.antispam.image;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.callback.CallbackProfile;
import com.netease.yidun.sdk.antispam.image.v5.ImageClient;
import com.netease.yidun.sdk.antispam.image.v5.callback.ImageCallback;
import com.netease.yidun.sdk.antispam.image.v5.check.ImageV5CheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.request.ImageV5AsyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.response.ImageV5AsyncCheckResp;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.request.ImageV5SyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;
import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.SignatureMethodEnum;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.http.HttpClientConfig;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ImageClientTest {

    @Test
    public void testImageClientInstance() {
        ImageClient imageClient1 = ImageClient.getInstance(AntispamRequester.getInstance("111sid", "111sk"));
        ImageClient imageClient2 = ImageClient.getInstance(AntispamRequester.getInstance("111sid", "111sk"));
        Assert.assertTrue(imageClient1 == imageClient2);

        ImageClient imageClient3 = ImageClient.getInstance(AntispamRequester.getInstance(ClientProfile.defaultProfile("111sid", "111sk")));
        Assert.assertTrue(imageClient1 == imageClient3);

        ImageClient imageClient4 = ImageClient.getInstance(AntispamRequester.getInstance("111sid", "111sk"), new ImageCallbackImpl("111bid"));
        Assert.assertTrue(imageClient1 == imageClient4);

        ImageClient imageClient5 = ImageClient.getInstance(AntispamRequester.getInstance("111sid", "111sk"), new ImageCallbackImpl("111bid"), new ImageCallbackImpl("112bid"));
        Assert.assertTrue(imageClient1 == imageClient5);

        ImageClient imageClient6 = ImageClient.getInstance(AntispamRequester.getInstance("112sid", "111sk"), new ImageCallbackImpl("111bid"), new ImageCallbackImpl("112bid"));
        Assert.assertTrue(imageClient1 != imageClient6);
    }

    @Test
    public void testImageClientInstanceConcurrent() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(30, 30, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        List<ImageClient> imageClients = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            ImageClient imageClient = executor.submit(() -> ImageClient.getInstance(AntispamRequester.getInstance("111sid", "111sk"))).get();
            imageClients.add(imageClient);
        }
        ImageClient imageClient = imageClients.get(0);
        for (ImageClient current : imageClients) {
            Assert.assertTrue(imageClient == current);
        }
    }

    public static class ImageCallbackImpl extends ImageCallback {

        public ImageCallbackImpl(String businessId) {
            super(businessId);
        }

        public ImageCallbackImpl(CallbackProfile profile) {
            super(profile);
        }

        /**
         * 获取到待回调数据交给业务方处理，现阶段的实现方式，无法保证数据不重复
         *
         * @param callbackData
         */
        @Override
        public void handle(List<ImageV5Result> callbackData) {

        }
    }
}
