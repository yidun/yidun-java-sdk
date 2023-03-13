
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Max;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;


public abstract class AbstractMaxValidator<T> implements LimitationValidator<Max, T> {

    protected long maxValue;

    public AbstractMaxValidator(Max max) {
        this.maxValue = max.value();
    }

    @Override
    public boolean isValid(T value) {
        if (value == null) {
            return true;
        }

        return compare(value) <= 0;
    }

    protected abstract int compare(T number);
}
