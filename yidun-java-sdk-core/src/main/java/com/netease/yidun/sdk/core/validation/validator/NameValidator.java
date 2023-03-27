package com.netease.yidun.sdk.core.validation.validator;

import java.util.regex.Pattern;
import com.netease.yidun.sdk.core.utils.StringUtils;
import com.netease.yidun.sdk.core.validation.limitation.CheckName;

public class NameValidator implements LimitationValidator<CheckName, String> {

    public static final Pattern NAME_PATTERN = Pattern
            .compile("^[\\u2E80-\\u9FFF0]+([\\•|\\· ]){0,1}([\\u2E80-\\u9FFF0]+)*$");

    @Override
    public boolean isValid(String name) {
        int maxLength = 32;
        if (StringUtils.isBlank(name) || name.length() > maxLength) {
            return false;
        }
        return NAME_PATTERN.matcher(name).find();
    }
}
