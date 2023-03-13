
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Min;

public class MinValidatorForShort extends AbstractMinValidator<Short> {

    public MinValidatorForShort(Min min) {
        super(min);
    }

    @Override
    protected int compare(Short number) {
        return ((Long) number.longValue()).compareTo(minValue);
    }
}
