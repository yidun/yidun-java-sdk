package com.netease.yidun.sdk.profile.v1;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpQueryRequest;
import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpQueryResponse;
import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneQueryRequest;
import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneQueryResponse;
import com.netease.yidun.sdk.profile.v1.riskquery.ProfileRiskQueryRequest;
import com.netease.yidun.sdk.profile.v1.riskquery.ProfileRiskQueryResponse;
import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserQueryRequest;
import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserQueryResponse;
import com.netease.yidun.sdk.profile.v1.check.ProfileCheckRequest;
import com.netease.yidun.sdk.profile.v1.check.ProfileCheckResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;


public class ProfileClientTest {

    @Test
    public void check() {
        ProfileCheckRequest request = mock(ProfileCheckRequest.class);
        ProfileCheckResponse expectedResponse = mock(ProfileCheckResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        ProfileClient profileClient = new ProfileClient(innerClient);
        ProfileCheckResponse actualResponse = profileClient.check(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }

    @Test
    public void ipQuery() {
        ProfileIpQueryRequest request = mock(ProfileIpQueryRequest.class);
        ProfileIpQueryResponse expectedResponse = mock(ProfileIpQueryResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        ProfileClient profileClient = new ProfileClient(innerClient);
        ProfileIpQueryResponse actualResponse = profileClient.ipQuery(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }


    @Test
    public void userQuery() {
        ProfileUserQueryRequest request = mock(ProfileUserQueryRequest.class);
        ProfileUserQueryResponse expectedResponse = mock(ProfileUserQueryResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        ProfileClient profileClient = new ProfileClient(innerClient);
        ProfileUserQueryResponse actualResponse = profileClient.userQuery(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }


    @Test
    public void phoneQuery() {
        ProfilePhoneQueryRequest request = mock(ProfilePhoneQueryRequest.class);
        ProfilePhoneQueryResponse expectedResponse = mock(ProfilePhoneQueryResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        ProfileClient profileClient = new ProfileClient(innerClient);
        ProfilePhoneQueryResponse actualResponse = profileClient.phoneQuery(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }

    @Test
    public void riskQuery() {
        ProfileRiskQueryRequest request = mock(ProfileRiskQueryRequest.class);
        ProfileRiskQueryResponse expectedResponse = mock(ProfileRiskQueryResponse.class);
        Client innerClient = mock(Client.class);
        when(innerClient.execute(request)).thenReturn(expectedResponse);
        ProfileClient profileClient = new ProfileClient(innerClient);
        ProfileRiskQueryResponse actualResponse = profileClient.riskQuery(request);
        assertSame(expectedResponse, actualResponse);
        verify(innerClient, times(1)).execute(request);
        verifyNoMoreInteractions(innerClient);
    }

    @Test
    public void testToString() {
        String innerClientString = "inner-client-info";
        String expectedStr = "ProfileClient(client=inner-client-info)";
        Client innerClient = mock(Client.class);
        when(innerClient.toString()).thenReturn(innerClientString);
        ProfileClient profileClient = new ProfileClient(innerClient);
        String actualStr = profileClient.toString();

        assertEquals(expectedStr, actualStr);
    }


    @Test
    public void testGetter() {
        Client innerClient = mock(Client.class);

        ProfileClient iRiskCheckClient = new ProfileClient(innerClient);

        assertSame(innerClient, iRiskCheckClient.getClient());
        assertSame(innerClient, iRiskCheckClient.client());
    }

    @Test
    public void testConstructorWithSecretIdKey() {
        String secretId = "secret-id-1";
        String secretKey = "secret-key-1";

        ProfileClient iRiskCheckClient = new ProfileClient(secretId, secretKey);

        DefaultClient innerClient = (DefaultClient) iRiskCheckClient.client();
        assertEquals(secretId, innerClient.credentials().secretId());
        assertEquals(secretKey, innerClient.credentials().getSecretKey());
    }

    @Test
    public void testConstructorWithProfile() {
        String secretId = "secret-id-1";
        String secretKey = "secret-key-1";
        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey);

        ProfileClient iRiskCheckClient = new ProfileClient(profile);

        DefaultClient innerClient = (DefaultClient) iRiskCheckClient.client();
        assertEquals(secretId, innerClient.credentials().secretId());
        assertEquals(secretKey, innerClient.credentials().getSecretKey());
    }

}
