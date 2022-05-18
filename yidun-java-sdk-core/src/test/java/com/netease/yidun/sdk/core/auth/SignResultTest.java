package com.netease.yidun.sdk.core.auth;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SignResultTest {

    @Test
    public void testToString() {
        SignResult result = new SignResult(SignatureMethodEnum.MD5, "a-secret-id-1", "a-sign-1");
        String expectedStr = "SignResult(signMethod=MD5, secretId=a-secret-id-1, signature=a-sign-1)";

        String actualStr = result.toString();

        assertEquals(expectedStr, actualStr);
    }
}
