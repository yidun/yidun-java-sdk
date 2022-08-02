package com.netease.yidun.sdk.antispam.recover;

import java.util.Collection;

/**
 * 失败恢复工具
 * 
 * <pre>
 * 原理：
 *     数据抛出异常失败-->捕获数据异步存储到文件中-->恢复线程定期重试恢复数据-->恢复成功清空文件
 * 注意：
 *      在恢复处理方法上需要做去重处理，以免重复数据异常导致数据一直尝试恢复
 * 用法：
 * 
 *  1:a class name=B
 *  
 *  2:目前有三种方式
 *  2.1:在类上增加配置恢复处理器
 *  <code>
    private Recover<B> recover = new DefaultRecover<B>(new RecoverHandler<B>() {}

        public boolean tryRecover(B data) {
            boolean recovered = false;
            try {
                //去重
                //handle data
                recovered = true;
            } catch (Exception e) {
                // 忽略吧
            }
            return recovered;
        }
    }, B.class.getSimpleName() + ".insert", B.class);
    </code>
    2.2:继承WrapRecover类,一个恢复逻辑共用一个恢复文件
    2.3:继承WrapMultiHandlerRecover,多个恢复逻辑共用一个恢复文件
    
    3:在抛出异常的捕获点捕获数据
 * </pre>
 * 
 * @author hzleishaobo
 * @version 2017年9月6日
 * @param <T>
 */
public interface Recover<T> extends LifeCycle {

    /**
     * 恢复一条数据
     * 
     * @param data
     */
    void recover(T data);

    /**
     * 恢复多条数据
     * 
     * @param datas
     */
    void recover(Collection<T> datas);
}
