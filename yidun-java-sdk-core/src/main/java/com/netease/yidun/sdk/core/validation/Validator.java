package com.netease.yidun.sdk.core.validation;

import com.netease.yidun.sdk.core.exception.YidunValidationException;
import com.netease.yidun.sdk.core.validation.descriptor.BeanDescriptor;
import com.netease.yidun.sdk.core.validation.descriptor.BeanHierarchyDescriptor;
import com.netease.yidun.sdk.core.validation.descriptor.BeanHierarchyFactory;
import com.netease.yidun.sdk.core.validation.descriptor.LimitationDescriptor;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Validator {


    /**
     * 参数回归性验证
     *
     * @param obj 待验证的对象实例
     * @return
     */
    public static List<String> validate(Object obj) {
        List<String> errorMsgs = new ArrayList<>();
        try {
            BeanHierarchyDescriptor beanHierarchyDescriptor = BeanHierarchyFactory.getBeanHierarchy(obj.getClass());
            for (BeanDescriptor beanDescriptor : beanHierarchyDescriptor.getHierarchies()) {
                errorMsgs.addAll(validate(obj, beanDescriptor));
            }
        } catch (YidunValidationException e) {
            throw e;
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }

        return errorMsgs;
    }

    private static List<String> validate(Object obj, BeanDescriptor beanDescriptor) {
        List<String> failMsg = new ArrayList<>();
        Map<Field, List<LimitationDescriptor>> limitationDescriptorsMap = beanDescriptor.getLimitationDescriptors();
        for (Map.Entry<Field, List<LimitationDescriptor>> entry : limitationDescriptorsMap.entrySet()) {
            Field field = entry.getKey();
            List<LimitationDescriptor> limitationDescriptors = entry.getValue();
            Object fieldValue;
            try {
                fieldValue = field.get(obj);
            } catch (IllegalAccessException e) {
                // should never happen
                e.printStackTrace();
                continue;
            }

            for (LimitationDescriptor limitationDescriptor : limitationDescriptors) {
                LimitationValidator limitationValidator = limitationDescriptor.getLimitationValidator();
                if (limitationValidator == null) {
                    continue;
                }
                boolean valid = limitationValidator.isValid(fieldValue);
                if (!valid) {
                    failMsg.add(MessageFormatter.format(limitationDescriptor));
                }
            }

        }
        return failMsg;
    }
}
