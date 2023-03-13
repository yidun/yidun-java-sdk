
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Max;

import java.math.BigInteger;

public class MaxValidatorForBigInteger extends AbstractMaxValidator<BigInteger> {

    public MaxValidatorForBigInteger(Max max) {
        super(max);
    }

    @Override
    protected int compare(BigInteger number) {
        return number.compareTo(BigInteger.valueOf(maxValue));
    }
}
