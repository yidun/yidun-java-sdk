
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Min;

import java.math.BigInteger;

public class MinValidatorForBigInteger extends AbstractMinValidator<BigInteger> {

	public MinValidatorForBigInteger(Min min) {
		super(min);
	}

	@Override
	protected int compare(BigInteger number) {
		return number.compareTo(BigInteger.valueOf(minValue));
	}
}
