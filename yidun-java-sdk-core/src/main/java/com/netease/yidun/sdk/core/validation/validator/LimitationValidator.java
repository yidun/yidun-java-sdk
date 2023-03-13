package com.netease.yidun.sdk.core.validation.validator;

import java.lang.annotation.Annotation;

public interface LimitationValidator<A extends Annotation, T> {

    boolean isValid(T value);
}
