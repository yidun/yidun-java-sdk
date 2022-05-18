package com.netease.yidun.sdk.core.auth;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SignatureMethodEnumTest {

    @Test
    public void testMd5() {
        String str = "a-string-to-hash";
        String expectedValue = "c6b763343cfeada6a408772701329d30";

        String actualValue = SignatureMethodEnum.MD5.calcSign(str);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSha1() {
        String str = "a-string-to-hash";
        String expectedValue = "db88cd2de9438097edb09014442ed5efebe214a9";

        String actualValue = SignatureMethodEnum.SHA1.calcSign(str);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSha256() {
        String str = "a-string-to-hash";
        String expectedValue = "47bd5d1c4ab68a55391f0b5304481eb11cb6a7a33066bb8d69c114a69254fdb2";

        String actualValue = SignatureMethodEnum.SHA256.calcSign(str);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSm3() {
        String str = "a-string-to-hash";
        String expectedValue = "10bd18e0e96b6e9d79f8726c04df6c5aecdda4cf3f8e5c227c76eb3d3c850498";

        String actualValue = SignatureMethodEnum.SM3.calcSign(str);

        assertEquals(expectedValue, actualValue);
    }
}
