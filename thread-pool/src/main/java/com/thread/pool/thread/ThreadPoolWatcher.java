package com.thread.pool.thread;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Date;

/**
 * Created by ZhangQingrong on 2017/6/12.
 */
public class ThreadPoolWatcher implements Runnable {

    private ThreadPoolTaskExecutor threadPool;

    public ThreadPoolWatcher(ThreadPoolTaskExecutor threadPool) {
        this.threadPool = threadPool;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss.SSS") +  " ，活跃线程数 : " + threadPool.getPoolSize()
                        + ", 队列已用量 : " + threadPool.getThreadPoolExecutor().getQueue().size()
                        + " , 队列剩余量 : " + threadPool.getThreadPoolExecutor().getQueue().remainingCapacity()
                );
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
