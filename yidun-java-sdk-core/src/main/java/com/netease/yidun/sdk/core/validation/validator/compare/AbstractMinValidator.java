
package com.netease.yidun.sdk.core.validation.validator.compare;


import com.netease.yidun.sdk.core.validation.limitation.Min;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public abstract class AbstractMinValidator<T> implements LimitationValidator<Min, T> {

    protected long minValue;

    public AbstractMinValidator(Min min) {
        this.minValue = min.value();
    }

    public boolean isValid(T value) {
        if (value == null) {
            return true;
        }

        return compare(value) >= 0;
    }

    protected abstract int compare(T number);
}
