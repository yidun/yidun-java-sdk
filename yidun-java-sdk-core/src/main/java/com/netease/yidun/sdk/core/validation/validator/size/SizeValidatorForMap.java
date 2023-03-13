
package com.netease.yidun.sdk.core.validation.validator.size;

import com.netease.yidun.sdk.core.validation.limitation.Size;
import java.util.Map;

public class SizeValidatorForMap extends AbstractSizeValidator<Map> {

    public SizeValidatorForMap(Size size) {
        super(size);
    }

    @Override
    public boolean isValid(Map map) {
        if (map == null) {
            return true;
        }
        int size = map.size();
        return size >= min && size <= max;
    }
}
