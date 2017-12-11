package com.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 10068 on 2017/6/25.
 */
public class LockContexts {

    /**
     * 单一锁
     * */
    public static Lock lock = new ReentrantLock();

    /**
     * 读写锁
     * */
    public static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
}
