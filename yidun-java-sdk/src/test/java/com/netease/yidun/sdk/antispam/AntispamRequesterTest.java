package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.http.HttpClientConfig;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AntispamRequesterTest {

    @Test
    public void testRequesterInstance() {
        AntispamRequester requester1 = AntispamRequester.getInstance("111sid", "111sk");
        AntispamRequester requester2 = AntispamRequester.getInstance("111sid", "111sk");
        Assert.assertTrue(requester1 == requester2);

        AntispamRequester requester3 = AntispamRequester.getInstance(ClientProfile.defaultProfile("111sid", "111sk"));
        Assert.assertTrue(requester1 == requester3);

        AntispamRequester requester4 = AntispamRequester.getInstance(ClientProfile.defaultProfile("111sid", "111sk")
                .httpClientConfig(HttpClientConfig.defaultConfig().connectionKeepAliveMillis(100001)));
        Assert.assertTrue(requester1 == requester4);

        AntispamRequester requester5 = AntispamRequester.getInstance("112sid", "111sk");
        Assert.assertTrue(requester1 != requester5);
    }

    @Test
    public void testRequesterInstanceConcurrent() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(30, 30, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        List<Future<AntispamRequester>> futures = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Future<AntispamRequester> future = executor.submit(() -> AntispamRequester.getInstance("111sid", "111sk"));
            futures.add(future);
        }
        AntispamRequester requester = futures.get(0).get();
        for (Future<AntispamRequester> future : futures) {
            AntispamRequester current = future.get();
            Assert.assertTrue(requester == current);
        }
    }

    @Test
    public void testInvalidParam() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            AntispamRequester.getInstance(null, "111sk");
        });
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            AntispamRequester.getInstance("111sid", null);
        });
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            AntispamRequester.getInstance(null);
        });
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            AntispamRequester.getInstance(ClientProfile.defaultProfile(null));
        });
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            AntispamRequester.getInstance(ClientProfile.defaultProfile(null, "111sk"));
        });
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            AntispamRequester.getInstance(ClientProfile.defaultProfile("111sid", null));
        });
    }
}
