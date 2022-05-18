package com.netease.yidun.sdk.core.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CommonResponseTest {

    @Test
    public void testToString() {
        String expectedStr = "CommonResponse(code=2, msg=msg-2)";

        CommonResponse response = new TestResponse(2, "msg-2");

        assertEquals(expectedStr, response.toString());
    }

    @Test
    public void testConstructorAndGetterSetter() {
        CommonResponse noParamResponse = new TestResponse();
        assertEquals(0, noParamResponse.getCode());
        assertNull(noParamResponse.getMsg());

        CommonResponse parameterized = new TestResponse(1, "msg-1");
        assertEquals(1, parameterized.getCode());
        assertEquals("msg-1", parameterized.getMsg());

        parameterized.setCode(2);
        parameterized.setMsg("msg-2");
        assertEquals(2, parameterized.getCode());
        assertEquals("msg-2", parameterized.getMsg());
    }

    private static class TestResponse extends CommonResponse {
        private TestResponse() {
            super();
        }

        private TestResponse(int code, String msg) {
            super(code, msg);
        }
    }
}
