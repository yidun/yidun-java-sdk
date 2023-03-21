package com.netease.yidun.sdk.captcha.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

public class CaptchaClientTest {

    @Test
    public void check() {
        CaptchaVerifyRequest request = mock(CaptchaVerifyRequest.class);
        CaptchaVerifyResponse expectedResponse = mock(CaptchaVerifyResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        CaptchaClient captchaClient = new CaptchaClient(innerClient);
        CaptchaVerifyResponse actualResponse = captchaClient.verify(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }

    @Test
    public void testConstructorWithSecretIdKey() {
        String secretId = "secret-id-1";
        String secretKey = "secret-key-1";
        CaptchaClient captchaClient = new CaptchaClient(secretId, secretKey);
        DefaultClient innerClient = (DefaultClient) captchaClient.client();
        assertEquals(secretId, innerClient.credentials().secretId());
        assertEquals(secretKey, innerClient.credentials().getSecretKey());
    }

    @Test
    public void testConstructorWithProfile() {
        String secretId = "secret-id-1";
        String secretKey = "secret-key-1";
        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey);
        CaptchaClient captchaClient = new CaptchaClient(profile);
        DefaultClient innerClient = (DefaultClient) captchaClient.client();
        assertEquals(secretId, innerClient.credentials().secretId());
        assertEquals(secretKey, innerClient.credentials().getSecretKey());
    }

    @Test
    public void testToString() {
        String innerClientString = "inner-client-info";
        String expectedStr = "CaptchaClient(client=inner-client-info)";
        Client innerClient = mock(Client.class);
        when(innerClient.toString()).thenReturn(innerClientString);
        CaptchaClient captchaClient = new CaptchaClient(innerClient);
        String actualStr = captchaClient.toString();
        assertEquals(expectedStr, actualStr);
    }

    @Test
    public void testGetter() {
        Client innerClient = mock(Client.class);
        CaptchaClient captchaClient = new CaptchaClient(innerClient);
        assertSame(innerClient, captchaClient.getClient());
        assertSame(innerClient, captchaClient.client());
    }
}
