package com.netease.yidun.sdk.core.auth;

import com.netease.yidun.sdk.core.exception.YidunSdkException;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OpenApiSignerImplTest {

    private static final Credentials credentials;
    private static final Map<String, String> params;

    static {
        credentials = new Credentials("a-secret-id-1", "a-secret-key-1");

        Map<String, String> tmpParams = new HashMap<>();
        tmpParams.put("x", null);
        tmpParams.put("y", "");
        tmpParams.put("arg0", "value-of-arg0");
        tmpParams.put("param1", "value-of-param1");
        tmpParams.put("input2", "value-of-input2");
        params = Collections.unmodifiableMap(tmpParams);
    }

    @Test
    public void testWithSha1() {
        String expectedSignature = "24080052f8f2a630cfb17d4c5426784d";

        test(expectedSignature);
    }

    private void test(String expectedSignature) {
        Map<String, String> paramsCopy = new HashMap<>(params);

        SignResult signResult = SignerImpl.INSTANCE.genSignature(credentials, paramsCopy);

        assertEquals(expectedSignature, signResult.getSignature());
    }
}
