package com.netease.yidun.sdk.core.validation.validator;

import com.netease.yidun.sdk.core.exception.YidunValidationException;
import com.netease.yidun.sdk.core.validation.limitation.Length;

public class LengthValidator implements LimitationValidator<Length, CharSequence> {

    private int min;
    private int max;


    public LengthValidator(Length length) {
        this.min = length.min();
        this.max = length.max();
        if (this.max < this.min) {
            throw new YidunValidationException("Length min must be smaller than max");
        }
    }

    @Override
    public boolean isValid(CharSequence value) {
        if (value == null) {
            return true;
        }
        int length = value.length();
        return length >= min && length <= max;
    }

}
