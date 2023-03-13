
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Min;

public class MinValidatorForLong extends AbstractMinValidator<Long> {

    public MinValidatorForLong(Min min) {
        super(min);
    }

    @Override
    protected int compare(Long number) {
        return number.compareTo(minValue);
    }
}
