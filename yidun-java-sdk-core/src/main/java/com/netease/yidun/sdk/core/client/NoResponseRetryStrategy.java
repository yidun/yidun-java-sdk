package com.netease.yidun.sdk.core.client;

import org.apache.hc.client5.http.HttpRequestRetryStrategy;
import org.apache.hc.core5.concurrent.CancellableDependency;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.NoHttpResponseException;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.TimeValue;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 用于keep alive失效的链接在请求时返回NoHttpResponseException，需要重试
 */
public class NoResponseRetryStrategy implements HttpRequestRetryStrategy {

    private static final Integer DEFAULT_MAX_RETRY_COUNT = 1;
    private static final Integer DEFAULT_RETRY_INTERVAL = 10;

    private Set<Class<? extends Exception>> retryExceptions;
    private Integer maxRetryCount;
    private TimeValue retryInterval;

    public NoResponseRetryStrategy() {
        this(DEFAULT_MAX_RETRY_COUNT, DEFAULT_RETRY_INTERVAL);
    }

    public NoResponseRetryStrategy(int maxRetryCount, int retryInterval) {
        this.maxRetryCount = maxRetryCount;
        this.retryInterval = TimeValue.ofMilliseconds(retryInterval);
        this.retryExceptions = new HashSet<>();
        this.retryExceptions.add(NoHttpResponseException.class);
    }

    /**
     * Determines if a method should be retried after an I/O exception
     * occurred during execution.
     *
     * @param request   the request failed due to an I/O exception
     * @param exception the exception that occurred
     * @param execCount the number of times this method has been
     *                  unsuccessfully executed
     * @param context   the context for the request execution
     * @return {@code true} if the request should be retried, {@code false}
     * otherwise
     */
    @Override
    public boolean retryRequest(HttpRequest request, IOException exception, int execCount, HttpContext context) {
        if (execCount > this.maxRetryCount) {
            // Do not retry if over max retries
            return false;
        }

        if (request == null || exception == null) {
            return false;
        }

        if (request instanceof CancellableDependency && ((CancellableDependency) request).isCancelled()) {
            return false;
        }

        if (retryExceptions.contains(exception.getClass())) {
            return true;
        }

        for (final Class<? extends Exception> retryEx : this.retryExceptions) {
            if (retryEx.isInstance(exception)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if a method should be retried given the response from
     * the target server.
     *
     * @param response  the response from the target server
     * @param execCount the number of times this method has been
     *                  unsuccessfully executed
     * @param context   the context for the request execution
     * @return {@code true} if the request should be retried, {@code false}
     * otherwise
     */
    @Override
    public boolean retryRequest(HttpResponse response, int execCount, HttpContext context) {
        return false;
    }

    /**
     * Determines the retry interval between subsequent retries.
     *
     * @param response  the response from the target server
     * @param execCount the number of times this method has been
     *                  unsuccessfully executed
     * @param context   the context for the request execution
     * @return the retry interval between subsequent retries
     */
    @Override
    public TimeValue getRetryInterval(HttpResponse response, int execCount, HttpContext context) {
        return retryInterval;
    }
}
