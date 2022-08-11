package com.netease.yidun.sdk.antispam.recover;

public abstract class AbstractRequestRecoverHandler<T> {

    public abstract void handle(T response);
}
