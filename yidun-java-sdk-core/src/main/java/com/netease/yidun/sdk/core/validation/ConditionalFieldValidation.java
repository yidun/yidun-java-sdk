package com.netease.yidun.sdk.core.validation;

import java.util.List;

public interface ConditionalFieldValidation {
    boolean shouldSkipFieldValidation(String fieldName);

    List<String> validateConditionalFields();
}
