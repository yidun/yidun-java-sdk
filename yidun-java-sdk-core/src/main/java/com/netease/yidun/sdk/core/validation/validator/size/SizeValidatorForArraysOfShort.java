
package com.netease.yidun.sdk.core.validation.validator.size;

import com.netease.yidun.sdk.core.validation.limitation.Size;

public class SizeValidatorForArraysOfShort extends AbstractSizeValidator<short[]> {

    public SizeValidatorForArraysOfShort(Size size) {
        super(size);
    }

    @Override
    public boolean isValid(short[] array) {
        if (array == null) {
            return true;
        }
        return array.length >= min && array.length <= max;
    }
}
