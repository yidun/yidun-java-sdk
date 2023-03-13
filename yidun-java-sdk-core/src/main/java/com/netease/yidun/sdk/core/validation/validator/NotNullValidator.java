
package com.netease.yidun.sdk.core.validation.validator;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;

public class NotNullValidator implements LimitationValidator<NotNull, Object> {

    @Override
    public boolean isValid(Object value) {
        return value != null;
    }
}
