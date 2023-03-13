package com.netease.yidun.sdk.core.validation.descriptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanDescriptorFactory {
    private static final Map<Class, BeanDescriptor> beanDescriptorCache = new ConcurrentHashMap<>();

    public static BeanDescriptor getBeanDescriptor(Class beanClass) {
        BeanDescriptor beanDescriptor = beanDescriptorCache.get(beanClass);
        if (beanDescriptor != null) {
            return beanDescriptor;
        }

        beanDescriptor = BeanDescriptor.createBeanDescriptor(beanClass);

        BeanDescriptor previous = beanDescriptorCache.putIfAbsent(beanClass, beanDescriptor);
        if (previous != null) {
            return previous;
        }

        return beanDescriptor;
    }

}
