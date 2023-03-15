
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArraysOfBoolean implements LimitationValidator<NotEmpty, boolean[]> {

    @Override
    public boolean isValid(boolean[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
