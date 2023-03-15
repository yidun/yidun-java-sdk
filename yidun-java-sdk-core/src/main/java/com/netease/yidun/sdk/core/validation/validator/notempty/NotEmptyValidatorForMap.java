
package com.netease.yidun.sdk.core.validation.validator.notempty;

import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

import java.util.Map;

public class NotEmptyValidatorForMap implements LimitationValidator<NotEmpty, Map> {

    @Override
    public boolean isValid(Map map) {
        if (map == null) {
            return false;
        }
        return map.size() > 0;
    }
}
