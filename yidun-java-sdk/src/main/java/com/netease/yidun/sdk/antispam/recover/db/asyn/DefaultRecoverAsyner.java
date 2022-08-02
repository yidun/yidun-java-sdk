package com.netease.yidun.sdk.antispam.recover.db.asyn;

import com.netease.yidun.sdk.antispam.recover.RecoverConfig;
import com.netease.yidun.sdk.antispam.recover.db.DefaultRecoverRepository;
import com.netease.yidun.sdk.antispam.recover.db.RecoverRepositoryReadHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 默认异步存储处理实现
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 * @param <T>
 */
@Slf4j
public class DefaultRecoverAsyner<T> extends DefaultRecoverRepository<T> implements RecoverAsyner<T> {

    private final BlockingQueue<T> blockingQueue = new LinkedBlockingQueue<>(2048);

    private static final int BATCH_SIZE = 400;

    private volatile boolean isStoped = false;

    private Class<T> entityClass;

    public class StoreThread extends Thread {
        @Override
        public void run() {
            List<T> list = new ArrayList<>();
            while (!isStoped) {

                try {
                    int count = 0;
                    while (count <= DefaultRecoverAsyner.BATCH_SIZE) {
                        T data = blockingQueue.take();
                        list.add(data);
                        count++;
                        if (blockingQueue.isEmpty()) {
                            break;
                        }
                    }
                    store(list);
                } catch (InterruptedException e) {
                    DefaultRecoverAsyner.log.error(e.getMessage(), e);
                    Thread.currentThread().interrupt();
                } finally {
                    list.clear();
                }
            }
        }
    }

    public DefaultRecoverAsyner(String dbPath, Class<T> entityClass,
                                RecoverRepositoryReadHandler<T> recoverRepositoryReadHandler,
                                RecoverConfig recoverConfig) {
        super(dbPath, entityClass, recoverRepositoryReadHandler, recoverConfig);
        this.entityClass = entityClass;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public void asyn(final T data) {
        checkFileSizeLimit();
        try {
            blockingQueue.put(data);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void asyn(Collection<T> datas) {
        for (T data : datas) {
            asyn(data);
        }
    }

    @Override
    public void start() {
        super.start();
        StoreThread storeThread = new StoreThread();
        storeThread.setName("recover-store-thread-" + this.entityClass.getSimpleName());
        storeThread.start();
    }

    @Override
    public void stop() {
        super.stop();
        isStoped = true;
    }
}
