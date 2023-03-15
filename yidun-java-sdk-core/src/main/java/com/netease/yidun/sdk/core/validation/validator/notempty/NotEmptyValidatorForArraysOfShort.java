
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArraysOfShort implements LimitationValidator<NotEmpty, short[]> {

    @Override
    public boolean isValid(short[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
