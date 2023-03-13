
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Min;

import java.math.BigDecimal;

public class MinValidatorForBigDecimal extends AbstractMinValidator<BigDecimal> {

    public MinValidatorForBigDecimal(Min min) {
        super(min);
    }

    @Override
    protected int compare(BigDecimal number) {
        return number.compareTo(BigDecimal.valueOf(minValue));
    }
}
