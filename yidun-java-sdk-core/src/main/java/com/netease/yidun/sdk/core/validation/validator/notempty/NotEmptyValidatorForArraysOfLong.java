
package com.netease.yidun.sdk.core.validation.validator.notempty;

import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArraysOfLong implements LimitationValidator<NotEmpty, long[]> {

    @Override
    public boolean isValid(long[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
