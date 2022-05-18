package com.netease.yidun.sdk.core.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.netease.yidun.sdk.core.ValidationHelper;
import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.http.HttpRequest;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.ValidationUtils;

public class BaseRequestTest {

    private static final String regionCode = "cn-hangzhou";
    private static final ProtocolEnum protocol = ProtocolEnum.HTTPS;
    private static final String domain = "test.org";
    private static final String productCode = "product-code-1";
    private static final String uriPattern = "/api/v1/getname/[id]";
    private static final HttpMethodEnum method = HttpMethodEnum.POST;

    @Test
    public void testToString() {
        String expectedStr = "BaseRequest(" +
                "regionCode=" + regionCode +
                ", protocol=" + protocol +
                ", domain=" + domain +
                ", productCode=" + productCode +
                ", uriPattern=" + uriPattern +
                ", method=" + method +
                ")";
        BaseRequest<?> request = createRequestWithFluentApi();

        assertEquals(expectedStr, request.toString());
    }

    @Test
    public void testGetterSetter() {
        BaseRequest<?> request = new TestRequest(productCode, uriPattern, method);
        request.setRegionCode(regionCode);
        request.setProtocol(protocol);
        request.setDomain(domain);

        assertEquals(regionCode, request.getRegionCode());
        assertEquals(protocol, request.getProtocol());
        assertEquals(domain, request.getDomain());
        assertEquals(productCode, request.getProductCode());
        assertEquals(uriPattern, request.getUriPattern());
        assertEquals(method, request.getMethod());
        assertEquals(0, request.getHeaders().size());
        assertEquals(0, request.getPathParameters().size());
        assertEquals(0, request.getQueryParameters().size());
        assertNull(request.getBody());
    }

    @Test
    public void testFluentGetterSetter() {
        BaseRequest<?> request = createRequestWithFluentApi();

        assertEquals(regionCode, request.regionCode());
        assertEquals(protocol, request.protocol());
        assertEquals(domain, request.domain());
        assertEquals(productCode, request.productCode());
        assertEquals(uriPattern, request.uriPattern());
        assertEquals(method, request.method());
    }

    @Test
    public void testValidationForValidRequest() {
        BaseRequest<?> request = createRequestWithFluentApi();
        ValidationUtils.validate(request);
    }

    @Test
    public void testBlankProductCode() {
        BaseRequest<?> request = new TestRequest(" ", uriPattern, method);
        ValidationHelper.testInvalidObject(request, "productCode不能为空");
    }

    @Test
    public void testBlankUriPattern() {
        BaseRequest<?> request = new TestRequest(productCode, " ", method);
        ValidationHelper.testInvalidObject(request, "uriPattern不能为空");
    }

    @Test
    public void testNullMethod() {
        BaseRequest<?> request = new TestRequest(productCode, uriPattern, null);
        ValidationHelper.testInvalidObject(request, "method不能为空");
    }

    @Test
    public void testDefaultValue() {
        TestRequest request = new TestRequest();

        assertNull(request.regionCode);
        assertNull(request.protocol);
        assertNull(request.domain);
        assertNull(request.productCode);
        assertNull(request.uriPattern);
        assertNull(request.method);
    }

    private BaseRequest<?> createRequestWithFluentApi() {
        return new TestRequest(productCode, uriPattern, method)
                .regionCode(regionCode)
                .protocol(protocol)
                .domain(domain);
    }

    private static class TestRequest extends BaseRequest<BaseResponse> {

        public TestRequest() {
        }

        private TestRequest(String productCode, String uriPattern, HttpMethodEnum method) {
            this.productCode = productCode;
            this.uriPattern = uriPattern;
            this.method = method;
        }

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
