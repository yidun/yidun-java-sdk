package com.netease.yidun.sdk.core.validation.descriptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanHierarchyFactory {

    private static final Map<Class, BeanHierarchyDescriptor> beanHierarchyCache = new ConcurrentHashMap<>();

    /**
     * 获取bean的所有层级的描述
     *
     * @param beanClass bean类
     * @return {@link BeanHierarchyDescriptor}
     */
    public static BeanHierarchyDescriptor getBeanHierarchy(Class beanClass) {
        // 没有使用computeIfAbsent是防止class继承关系过多，createBeanHierarchy时间较长，高并发时导致锁等待时间更长
        BeanHierarchyDescriptor beanHierarchyDescriptor = beanHierarchyCache.get(beanClass);
        if (beanHierarchyDescriptor != null) {
            return beanHierarchyDescriptor;
        }

        beanHierarchyDescriptor = BeanHierarchyDescriptor.createBeanHierarchy(beanClass);

        BeanHierarchyDescriptor previous = beanHierarchyCache.putIfAbsent(beanClass, beanHierarchyDescriptor);
        if (previous != null) {
            return previous;
        }
        return beanHierarchyDescriptor;
    }
}
