package com.netease.yidun.sdk.core.auth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CredentialsTest {

    @Test
    public void blankSecretId() {
        IllegalArgumentException e = null;
        try {
            new Credentials(" ", "a-secret-key-1");
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        assertNotNull(e);
        assertEquals("secret id should not be blank", e.getMessage());
    }

    @Test
    public void blankSecretKey() {
        IllegalArgumentException e = null;
        try {
            new Credentials("a-secret-id-1", " ");
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        assertNotNull(e);
        assertEquals("secret key should not be blank", e.getMessage());
    }

    @Test
    public void valid() {
        String secretId = "a-secret-id-1";
        String secretKey = "a-secret-key-1";

        Credentials credentials = new Credentials(secretId, secretKey);

        assertEquals(secretId, credentials.getSecretId());
        assertEquals(secretId, credentials.secretId());

        assertEquals(secretKey, credentials.getSecretKey());
        assertEquals(secretKey, credentials.secretKey());
    }

}
