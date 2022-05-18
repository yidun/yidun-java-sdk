package com.netease.yidun.sdk.core.auth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.netease.yidun.sdk.core.exception.YidunSdkException;

public class SignerImplTest {

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
    public void testWithDefaultMd5() {
        String givenSignatureMethod = null;
        SignatureMethodEnum expectedSignatureMethod = SignatureMethodEnum.MD5;
        String expectedSignature = "24080052f8f2a630cfb17d4c5426784d";

        test(givenSignatureMethod, expectedSignatureMethod, expectedSignature);
    }

    /**
     * 明确指定签名hash算法时，会额外添加参数 signatureMethod
     */
    @Test
    public void testWithExplicitMd5() {
        String givenSignatureMethod = "md5";
        SignatureMethodEnum expectedSignatureMethod = SignatureMethodEnum.MD5;
        String expectedSignature = "f367a2956a80ae92eded1d8798357513";

        test(givenSignatureMethod, expectedSignatureMethod, expectedSignature);
    }

    @Test
    public void testWithSha1() {
        String givenSignatureMethod = "sha1";
        SignatureMethodEnum expectedSignatureMethod = SignatureMethodEnum.SHA1;
        String expectedSignature = "cb14b0d023925b91e90bb24acc93ce206ebd42ce";

        test(givenSignatureMethod, expectedSignatureMethod, expectedSignature);
    }

    @Test
    public void testWithSha256() {
        String givenSignatureMethod = "sha256";
        SignatureMethodEnum expectedSignatureMethod = SignatureMethodEnum.SHA256;
        String expectedSignature = "36a8270f76d769e120e6d178b6d0ded81093ca11cb930e4bdbf5559a34f4c222";

        test(givenSignatureMethod, expectedSignatureMethod, expectedSignature);
    }

    @Test
    public void invalidSignatureMethod() {
        Map<String, String> paramsCopy = new HashMap<>(params);
        paramsCopy.put("signatureMethod", "an-invalid-signature-method");

        YidunSdkException e = null;
        try {
            SignerImpl.INSTANCE.genSignature(credentials, paramsCopy);
        } catch (YidunSdkException ex) {
            e = ex;
        }

        assertEquals("Unsupported signatureMethod: an-invalid-signature-method", e.getMessage());
        assertTrue(e.getCause() instanceof IllegalArgumentException);
    }

    private void test(
            String givenSignatureMethod,
            SignatureMethodEnum expectedSignatureMethod,
            String expectedSignature) {
        Map<String, String> paramsCopy = new HashMap<>(params);
        if (givenSignatureMethod != null) {
            paramsCopy.put("signatureMethod", givenSignatureMethod);
        }

        SignResult signResult = SignerImpl.INSTANCE.genSignature(credentials, paramsCopy);

        assertEquals(expectedSignatureMethod, signResult.getSignMethod());
        assertEquals(expectedSignature, signResult.getSignature());
    }
}
