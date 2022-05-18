package com.netease.yidun.sdk.core.response;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ResultResponseTest {

    @Test
    public void testToString() {
        ResultResponse<String> response = new ResultResponse<>(2, "msg-2", "result-2");

        TestResponseForString superResponse = new TestResponseForString();
        superResponse.setCode(response.getCode());
        superResponse.setMsg(response.getMsg());

        String expectedStr = "ResultResponse(" +
                "super=" + superResponse +
                ", result=result-2)";

        assertEquals(expectedStr, response.toString());
    }

    @Test
    public void testGetterSetter() {
        ResultResponse<String> response = new ResultResponse<>(2, "msg-2", "result-2");
        assertEquals("result-2", response.getResult());

        response.setResult("result-3");
        assertEquals("result-3", response.getResult());
    }

    private static class TestResponseForString extends CommonResponse {
    }
}
