package com.netease.yidun.sdk.core.validation.descriptor;

import com.netease.yidun.sdk.core.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanHierarchyDescriptor {

    private List<BeanDescriptor> hierarchies;

    private Class<?> beanClass;

    private BeanHierarchyDescriptor(Class clazz) {
        this.beanClass = clazz;
    }

    /**
     * 创建bean所有继承层级的描述对象
     *
     * @param clazz clazz
     * @return {@link BeanHierarchyDescriptor}
     */
    public static BeanHierarchyDescriptor createBeanHierarchy(Class clazz) {
        BeanHierarchyDescriptor beanHierarchyDescriptor = new BeanHierarchyDescriptor(clazz);
        List<Class> hierarchyClasses = ClassUtils.getHierarchyClass(clazz);
        List<BeanDescriptor> descriptors = new ArrayList<>(hierarchyClasses.size());
        for (Class hierarchyClass : hierarchyClasses) {
            if (!ClassUtils.isYidunClass(hierarchyClass)) {
                continue;
            }
            BeanDescriptor beanDescriptor = BeanDescriptorFactory.getBeanDescriptor(hierarchyClass);
            if (beanDescriptor != null) {
                descriptors.add(beanDescriptor);
            }
        }
        beanHierarchyDescriptor.setHierarchies(descriptors);
        return beanHierarchyDescriptor;
    }

    public List<BeanDescriptor> getHierarchies() {
        return hierarchies;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    void setHierarchies(List<BeanDescriptor> hierarchies) {
        this.hierarchies = hierarchies;
    }
}
