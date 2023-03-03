package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckResponse;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckRequest;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckResponse;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigRequest;
import com.netease.yidun.sdk.irisk.v1.config.IRiskConfigResponse;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailRequest;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailResponse;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;


public class IRiskClientTest {

    @Test
    public void check() {
        IRiskCheckRequest request = mock(IRiskCheckRequest.class);
        IRiskCheckResponse expectedResponse = mock(IRiskCheckResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        IRiskClient iRiskCheckClient = new IRiskClient(innerClient);
        IRiskCheckResponse actualResponse = iRiskCheckClient.check(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }

    @Test
    public void getConfig() {
        IRiskConfigRequest request = mock(IRiskConfigRequest.class);
        IRiskConfigResponse expectedResponse = mock(IRiskConfigResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        IRiskClient iRiskClient = new IRiskClient(innerClient);
        IRiskConfigResponse actualResponse = iRiskClient.getConfig(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }


    @Test
    public void getDetail() {
        IRiskDetailRequest request = mock(IRiskDetailRequest.class);
        IRiskDetailResponse expectedResponse = mock(IRiskDetailResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        IRiskClient iRiskClient = new IRiskClient(innerClient);
        IRiskDetailResponse actualResponse = iRiskClient.getDetail(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }

    @Test
    public void mediaCheck() {
        IRiskMediaCheckRequest request = mock(IRiskMediaCheckRequest.class);
        IRiskMediaCheckResponse expectedResponse = mock(IRiskMediaCheckResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        IRiskClient iRiskClient = new IRiskClient(innerClient);
        IRiskMediaCheckResponse actualResponse = iRiskClient.mediaCheck(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }


    @Test
    public void testToString() {
        String innerClientString = "inner-client-info";
        String expectedStr = "IRiskCheckClient(client=inner-client-info)";
        Client innerClient = mock(Client.class);
        when(innerClient.toString()).thenReturn(innerClientString);
        IRiskClient iRiskCheckClient = new IRiskClient(innerClient);
        String actualStr = iRiskCheckClient.toString();

        assertEquals(expectedStr, actualStr);
    }


    @Test
    public void testGetter() {
        Client innerClient = mock(Client.class);

        IRiskClient iRiskCheckClient = new IRiskClient(innerClient);

        assertSame(innerClient, iRiskCheckClient.getClient());
        assertSame(innerClient, iRiskCheckClient.client());
    }

    @Test
    public void testConstructorWithSecretIdKey() {
        String secretId = "secret-id-1";
        String secretKey = "secret-key-1";

        IRiskClient iRiskCheckClient = new IRiskClient(secretId, secretKey);

        DefaultClient innerClient = (DefaultClient) iRiskCheckClient.client();
        assertEquals(secretId, innerClient.credentials().secretId());
        assertEquals(secretKey, innerClient.credentials().getSecretKey());
    }

    @Test
    public void testConstructorWithProfile() {
        String secretId = "secret-id-1";
        String secretKey = "secret-key-1";
        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey);

        IRiskClient iRiskCheckClient = new IRiskClient(profile);

        DefaultClient innerClient = (DefaultClient) iRiskCheckClient.client();
        assertEquals(secretId, innerClient.credentials().secretId());
        assertEquals(secretKey, innerClient.credentials().getSecretKey());
    }

}
