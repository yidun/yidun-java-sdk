package com.netease.yidun.sdk.core.request;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.SignatureMethodEnum;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.auth.SignerImpl;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.http.HttpRequest;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.StringUtils;

public class PostFormRequestTest {

    private static final ProtocolEnum protocol = ProtocolEnum.HTTPS;
    private static final String domain = "test.org";
    private static final String uriPattern = "/api/v1/getname/[id]";
    private static final String version = "v1";
    private static final long timestamp = 1623294426383L;
    private static final String nonce = "564bd3a7c52544c6a5a53c41a7d3b1e2";
    private static final SignatureMethodEnum signatureMethod = SignatureMethodEnum.SM3;
    private static final boolean gzipCompress = true;
    private static final Map<String, String> customSignParams;
    private static final Map<String, String> nonSignParams;
    private static final Map<String, String> pathParameters;
    private static final Map<String, String> queryParameters;
    private static final Signer signer = SignerImpl.INSTANCE;
    private static final Credentials credentials = new Credentials("secret-id-1", "secret-key-1");

    private static final Map<String, String> expectedCommonHeaders;
    private static final Map<String, String> expectedGzipHeaders;
    private static final byte[] expectedCommonBody = new byte[] {115, 105, 103, 110, 97, 116, 117, 114, 101, 61, 48,
            102, 48, 102, 54, 51, 53, 48, 54, 51, 102, 101, 99, 98, 98, 48, 101, 55, 50, 99, 52, 56, 102, 48, 52, 49,
            57, 50, 102, 97, 55, 55, 38, 110, 115, 112, 49, 61, 110, 115, 112, 45, 118, 45, 49, 38, 115, 101, 99, 114,
            101, 116, 73, 100, 61, 115, 101, 99, 114, 101, 116, 45, 105, 100, 45, 49, 38, 118, 101, 114, 115, 105, 111,
            110, 61, 118, 49, 38, 110, 111, 110, 99, 101, 61, 53, 54, 52, 98, 100, 51, 97, 55, 99, 53, 50, 53, 52, 52,
            99, 54, 97, 53, 97, 53, 51, 99, 52, 49, 97, 55, 100, 51, 98, 49, 101, 50, 38, 99, 115, 112, 49, 61, 99, 115,
            112, 45, 118, 45, 49, 38, 116, 105, 109, 101, 115, 116, 97, 109, 112, 61, 49, 54, 50, 51, 50, 57, 52, 52,
            50, 54, 51, 56, 51};
    private static final byte[] expectedCommonBodyWithSignMethod = new byte[] {
            115, 105, 103, 110, 97, 116, 117, 114, 101, 61, 55, 56, 57, 57, 102, 56, 101, 56, 56, 101, 102, 56, 54, 54,
            50, 56, 54, 98, 53, 54, 53, 57, 99, 101, 53, 55, 53, 56, 97, 51, 98, 56, 99, 57, 56, 54, 53, 52, 48, 54, 57,
            52, 51, 53, 49, 50, 48, 49, 98, 97, 49, 49, 51, 48, 52, 97, 52, 56, 52, 98, 48, 52, 56, 102, 38, 110, 115,
            112, 49, 61, 110, 115, 112, 45, 118, 45, 49, 38, 115, 105, 103, 110, 97, 116, 117, 114, 101, 77, 101, 116,
            104, 111, 100, 61, 83, 77, 51, 38, 115, 101, 99, 114, 101, 116, 73, 100, 61, 115, 101, 99, 114, 101, 116,
            45, 105, 100, 45, 49, 38, 118, 101, 114, 115, 105, 111, 110, 61, 118, 49, 38, 110, 111, 110, 99, 101, 61,
            53, 54, 52, 98, 100, 51, 97, 55, 99, 53, 50, 53, 52, 52, 99, 54, 97, 53, 97, 53, 51, 99, 52, 49, 97, 55,
            100, 51, 98, 49, 101, 50, 38, 99, 115, 112, 49, 61, 99, 115, 112, 45, 118, 45, 49, 38, 116, 105, 109, 101,
            115, 116, 97, 109, 112, 61, 49, 54, 50, 51, 50, 57, 52, 52, 50, 54, 51, 56, 51
    };
    private static final byte[] expectedGzippedBody = new byte[] {31, -117, 8, 0, 0, 0, 0, 0, 0, 0, 45, -116, 49, 14,
            -61, 32, 12, 0, 127, -61, 22, 9, 99, 3, -55, -64, 3, -6, 12, 99, 76, -59, 16, 82, 5, -102, -9, 55, 85, -69,
            -100, 78, 55, -36, 104, -49, -50, -13, 125, 106, -78, -43, -42, -128, -34, 6, -84, 42, 57, 91, -115, 78,
            104, -83, -106, 96, 115, -107, 99, 52, 125, -68, 32, -35, 88, -82, 5, -52, 80, 57, 117, 62, 74, -6, -55,
            -46, -54, 29, 47, 61, 71, 59, 122, -70, -64, -12, -93, -117, 38, 31, 40, 23, -28, 40, -34, 121, 34, 9, -20,
            -39, -93, 16, 112, 44, -104, 65, -99, -111, -17, 83, -2, -49, -39, 118, 29, -109, -9, 87, -126, -32, -48,
            109, 68, 46, -32, -118, 31, -40, 82, 109, -75, -93, 0, 0, 0};
    private static final byte[] expectedGzippedBodyWithSignMethod = new byte[] {
            31, -117, 8, 0, 0, 0, 0, 0, 0, 0, 53, -115, 57, -114, -61, 48, 16, 4, 127, -61, 76, -128, -122, 115, 104,
            24, -16, 1, 14, 28, -7, 5, 60, 70, 107, 5, -90, 12, -111, -42, -5, -41, 11, 123, -109, 66, 7, -123, -82,
            -66, -3, -76, 52, 94, -121, -59, 69, 67, 88, -43, 84, 109, 85, 17, -81, -110, 89, 56, 20, -29, -123, 53, 97,
            -42, 18, 84, -104, 102, 9, -124, 12, 126, -122, -100, 0, 112, -90, 68, 74, 121, 38, 93, 93, -21, 79, -120,
            111, 76, -25, 4, -82, -1, -1, 94, 109, -36, -9, 26, 111, 87, 116, -35, -54, 97, -29, 82, -29, 103, 76, 91,
            125, -117, -89, 29, 125, -37, 91, 60, -63, -75, -67, 21, -117, 44, -108, 43, -90, -91, -80, 103, -94, 34,
            -119, 19, 99, 33, 72, 75, -59, 12, -26, 93, -7, -21, -108, 111, 103, 108, 15, -21, 35, 61, -98, 17, -60,
            -93, 15, 68, 94, 80, -15, 23, 54, 12, -119, -12, -41, 0, 0, 0
    };

    static {
        customSignParams = Collections.singletonMap("csp1", "csp-v-1");
        nonSignParams = Collections.singletonMap("nsp1", "nsp-v-1");
        pathParameters = Collections.singletonMap("p1", "p-v-1");
        queryParameters = Collections.singletonMap("q1", "q-v-1");
        Map<String, String> commonMap = new HashMap<>();
        commonMap.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        commonMap.put("SdkVer", "1.0");

        expectedCommonHeaders = Collections.unmodifiableMap(commonMap);

        Map<String, String> tmpExpectedGzipHeader = new HashMap<>(expectedCommonHeaders);
        tmpExpectedGzipHeader.put("Content-Encoding", "gzip");
        expectedGzipHeaders = Collections.unmodifiableMap(tmpExpectedGzipHeader);
    }

    @Test
    public void testToHttpRequest() {
        PostFormRequest<?> request = createRequestWithFluentApi();

        HttpRequest gzipHttpRequest = request.toHttpRequest(signer, credentials);
        assertHttpRequest(gzipHttpRequest, false, true);

        HttpRequest httpRequest = request.gzipCompress(false).toHttpRequest(signer, credentials);
        assertHttpRequest(httpRequest, false, false);
    }

    @Test
    public void testToHttpRequestWithSignMethod() {
        PostFormRequest<?> request = createRequestWithFluentApi();
        request.signatureMethod(signatureMethod);

        HttpRequest gzipHttpRequest = request.toHttpRequest(signer, credentials);
        assertHttpRequest(gzipHttpRequest, true, true);

        HttpRequest httpRequest = request.gzipCompress(false).toHttpRequest(signer, credentials);
        assertHttpRequest(httpRequest, true, false);
    }

    @Test
    public void testToString() {
        PostFormRequest<?> request = createRequestWithFluentApi();

        BaseRequest<BaseResponse> superRequest = new TestRequestForString()
                .regionCode(request.regionCode())
                .protocol(request.protocol())
                .domain(request.domain());
        superRequest.productCode = request.productCode();
        superRequest.uriPattern = request.uriPattern();
        superRequest.method = request.method();

        String expectedStr = "PostFormRequest(" +
                "super=" + superRequest +
                ", version=" + version +
                ", timestamp=" + timestamp +
                ", nonce=" + nonce +
                ", gzipCompress=" + gzipCompress +
                ")";
        String expectedStrWithSignMethod = "PostFormRequest(" +
                "super=" + superRequest +
                ", version=" + version +
                ", timestamp=" + timestamp +
                ", nonce=" + nonce +
                ", signatureMethod=" + signatureMethod.name() +
                ", gzipCompress=" + gzipCompress +
                ")";

        // 验证：未指定 signatureMethod
        assertEquals(expectedStr, request.toString());

        // 验证：已指定 signatureMethod
        request.signatureMethod(signatureMethod);
        assertEquals(expectedStrWithSignMethod, request.toString());
    }

    @Test
    public void testDefaultValue() {
        long startTimeMillis = System.currentTimeMillis();

        PostFormRequest<?> request = new TestRequest();
        assertNull(request.version());
        assertTrue(startTimeMillis <= request.timestamp());
        assertTrue(request.timestamp() <= System.currentTimeMillis());
        assertTrue(StringUtils.isNotBlank(request.nonce()));
        assertFalse(request.gzipCompress());

        Map<String, String> customSignParams = request.getCustomSignParams();
        assertEquals(0, customSignParams.size());

        request.version = version;
        Map<String, String> signParams = request.getSignParams();
        assertEquals(3, signParams.size());
        assertEquals(request.version(), signParams.get("version"));
        assertEquals(String.valueOf(request.timestamp()), signParams.get("timestamp"));
        assertEquals(request.nonce(), signParams.get("nonce"));

        Map<String, String> nonSignParams = request.getNonSignParams();
        assertEquals(0, nonSignParams.size());

        assertEquals(expectedCommonHeaders, request.getHeaders());

        // 指明gzip压缩时，header需指明Content-Encoding为gzip
        request.gzipCompress(true);
        assertEquals(expectedGzipHeaders, request.getHeaders());
    }

    @Test
    public void testGetterSetter() {
        PostFormRequest<?> request = new TestRequest(
                protocol, domain, uriPattern, version,
                customSignParams, nonSignParams, pathParameters, queryParameters);
        request.setTimestamp(timestamp);
        request.setNonce(nonce);
        request.setSignatureMethod(signatureMethod);
        request.setGzipCompress(gzipCompress);

        assertEquals(version, request.getVersion());
        assertEquals(timestamp, request.getTimestamp());
        assertEquals(nonce, request.getNonce());
        assertEquals(signatureMethod, request.getSignatureMethod());
        assertEquals(gzipCompress, request.isGzipCompress());
    }

    @Test
    public void testFluentGetterSetter() {
        PostFormRequest<?> request = createRequestWithFluentApi();
        request.signatureMethod(signatureMethod);

        assertEquals(version, request.version());
        assertEquals(timestamp, request.timestamp());
        assertEquals(nonce, request.nonce());
        assertEquals(signatureMethod, request.signatureMethod());
        assertEquals(gzipCompress, request.gzipCompress());
    }

    private void assertHttpRequest(HttpRequest httpRequest, boolean withSignMethod, boolean bodyGzipped) {
        assertEquals(protocol, httpRequest.protocol());
        assertEquals(HttpMethodEnum.POST, httpRequest.method());
        assertEquals(domain, httpRequest.domain());
        assertEquals(uriPattern, httpRequest.uriPattern());

        Map<String, String> expectedHeaders = bodyGzipped ? expectedGzipHeaders : expectedCommonHeaders;
        assertEquals(expectedHeaders, httpRequest.headers());

        assertEquals(pathParameters, httpRequest.pathParameters());
        assertEquals(queryParameters, httpRequest.queryParameters());

        if (withSignMethod) {
            byte[] expectedBody = bodyGzipped ? expectedGzippedBodyWithSignMethod : expectedCommonBodyWithSignMethod;
            assertArrayEquals(expectedBody, httpRequest.body());
        } else {
            byte[] expectedBody = bodyGzipped ? expectedGzippedBody : expectedCommonBody;
            assertArrayEquals(expectedBody, httpRequest.body());
        }
    }

    private PostFormRequest<?> createRequestWithFluentApi() {
        PostFormRequest<?> request = new TestRequest(
                protocol, domain, uriPattern, version,
                customSignParams, nonSignParams, pathParameters, queryParameters);

        return request.timestamp(timestamp)
                .nonce(nonce)
                .gzipCompress(gzipCompress);
    }

    private static class TestRequest extends PostFormRequest<BaseResponse> {

        private Map<String, String> customSignParamsForTest = null;
        private Map<String, String> nonSignParamsForTest = null;
        private Map<String, String> pathParametersForTest = null;
        private Map<String, String> queryParametersForTest = null;

        private TestRequest() {
        }

        private TestRequest(
                ProtocolEnum protocol,
                String domain,
                String uriPattern,
                String version,
                Map<String, String> customSignParams,
                Map<String, String> nonSignParams,
                Map<String, String> pathParameters,
                Map<String, String> queryParameters) {
            this.protocol = protocol;
            this.domain = domain;
            this.uriPattern = uriPattern;
            this.version = version;
            this.customSignParamsForTest = customSignParams;
            this.nonSignParamsForTest = nonSignParams;
            this.pathParametersForTest = pathParameters;
            this.queryParametersForTest = queryParameters;
        }

        @Override
        protected Map<String, String> getCustomSignParams() {
            return customSignParamsForTest == null
                    ? super.getCustomSignParams()
                    : new HashMap<>(customSignParamsForTest);
        }

        @Override
        protected Map<String, String> getNonSignParams() {
            return nonSignParamsForTest == null
                    ? super.getNonSignParams()
                    : new HashMap<>(nonSignParamsForTest);
        }

        @Override
        public Map<String, String> getPathParameters() {
            return pathParametersForTest == null
                    ? super.getPathParameters()
                    : new HashMap<>(pathParametersForTest);
        }

        @Override
        public Map<String, String> getQueryParameters() {
            return queryParametersForTest == null
                    ? super.getQueryParameters()
                    : new HashMap<>(queryParametersForTest);
        }

        @Override
        public Class<BaseResponse> getResponseClass() {
            return null;
        }
    }

    private static class TestRequestForString extends BaseRequest<BaseResponse> {

        @Override
        public Class<BaseResponse> getResponseClass() {
            return null;
        }

        @Override
        public HttpRequest toHttpRequest(Signer signer, Credentials credentials) {
            return null;
        }
    }
}
