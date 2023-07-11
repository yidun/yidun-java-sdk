package com.netease.yidun.sdk.irisk.v6;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.irisk.v6.IRiskV6Client;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Request;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;


public class IRiskV6ClientTest {

    @Test
    public void check() {
        IRiskCheckV6Request request = mock(IRiskCheckV6Request.class);
        IRiskCheckV6Response expectedResponse = mock(IRiskCheckV6Response.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        IRiskV6Client iRiskCheckClient = new IRiskV6Client(innerClient);
        IRiskCheckV6Response actualResponse = iRiskCheckClient.check(request);
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
        IRiskV6Client iRiskCheckClient = new IRiskV6Client(innerClient);
        String actualStr = iRiskCheckClient.toString();

        assertEquals(expectedStr, actualStr);
    }


    @Test
    public void testGetter() {
        Client innerClient = mock(Client.class);

        IRiskV6Client iRiskCheckV6Client = new IRiskV6Client(innerClient);

        assertSame(innerClient, iRiskCheckV6Client.getClient());
        assertSame(innerClient, iRiskCheckV6Client.client());
    }

    @Test
    public void testConstructorWithSecretIdKey() {
        String secretId = "secret-id-1";
        String secretKey = "secret-key-1";

        IRiskV6Client iRiskCheckV6Client = new IRiskV6Client(secretId, secretKey);

        DefaultClient innerClient = (DefaultClient) iRiskCheckV6Client.client();
        assertEquals(secretId, innerClient.credentials().secretId());
        assertEquals(secretKey, innerClient.credentials().getSecretKey());
    }

    @Test
    public void testConstructorWithProfile() {
        String secretId = "secret-id-1";
        String secretKey = "secret-key-1";
        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey);

        IRiskV6Client iRiskV6Client = new IRiskV6Client(profile);

        DefaultClient innerClient = (DefaultClient) iRiskV6Client.client();
        assertEquals(secretId, innerClient.credentials().secretId());
        assertEquals(secretKey, innerClient.credentials().getSecretKey());
    }

}
