package com.netease.yidun.sdk.core.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import com.netease.yidun.sdk.core.ValidationHelper;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.ValidationUtils;

public class BizPostFormRequestTest {

    private static final String businessId = "b2fb15e1d8da40e785acb778eb553bec";

    @Test
    public void getCustomSignParams() {
        BizPostFormRequest<?> request = new TestRequest()
                .businessId(businessId);

        Map<String, String> params = request.getCustomSignParams();

        assertEquals(1, params.size());
        assertEquals(businessId, params.get("businessId"));
    }

    @Test
    public void testToString() {
        TestRequest request = new TestRequest();
        request.businessId(businessId);

        PostFormRequest<BaseResponse> superRequest = new TestRequestForString(request)
                .timestamp(request.timestamp())
                .nonce(request.nonce());

        String expectedStr = "BizPostFormRequest(" +
                "super=" + superRequest +
                ", businessId=" + businessId +
                ")";

        assertEquals(expectedStr, request.toString());
    }

    @Test
    public void testGetterSetter() {
        BizPostFormRequest<?> request = new TestRequest()
                .businessId(businessId);

        assertEquals(businessId, request.businessId());
        assertEquals(businessId, request.getBusinessId());

        request.setBusinessId(null);
        assertNull(request.businessId);
        assertNull(request.getBusinessId());
    }

    @Test
    public void testValidation() {
        TestRequest request = new TestRequest();
        ValidationHelper.testInvalidObject(request, "businessId is invalid, businessId不能为空");

        request.setBusinessId(businessId);
        ValidationUtils.validate(request);
    }

    @Test
    public void testDefaultValue() {
        TestRequest request = new TestRequest();

        assertNull(request.businessId);
    }

    private static class TestRequest extends BizPostFormRequest<BaseResponse> {

        public TestRequest() {
            productCode = "p1";
            uriPattern = "/api/v1/go";
        }

        @Override
        public Class<BaseResponse> getResponseClass() {
            return null;
        }
    }

    private static class TestRequestForString extends PostFormRequest<BaseResponse> {

        TestRequestForString(TestRequest request) {
            productCode = request.productCode;
            uriPattern = request.uriPattern;
        }

        @Override
        public Class<BaseResponse> getResponseClass() {
            return null;
        }
    }
}
