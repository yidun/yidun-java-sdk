
package com.netease.yidun.sdk.core.validation.validator.size;

import com.netease.yidun.sdk.core.exception.YidunValidationException;
import com.netease.yidun.sdk.core.validation.limitation.Size;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;


public abstract class AbstractSizeValidator<T> implements LimitationValidator<Size, T> {

    protected int min;
    protected int max;

    public AbstractSizeValidator(Size size) {
        this.min = size.min();
        this.max = size.max();
        if (this.max < this.min) {
            throw new YidunValidationException("Size min must be smaller than max");
        }
    }

}
