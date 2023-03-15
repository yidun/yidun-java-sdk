
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArraysOfByte implements LimitationValidator<NotEmpty, byte[]> {

    public boolean isValid(byte[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
