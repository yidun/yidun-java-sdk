package com.netease.yidun.sdk.core.validation.validator;

import com.netease.yidun.sdk.core.utils.StringUtils;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;

public class NotBlankValidator implements LimitationValidator<NotBlank, CharSequence> {

	@Override
	public boolean isValid(CharSequence value) {
		return StringUtils.isNotBlank(value);
	}
}