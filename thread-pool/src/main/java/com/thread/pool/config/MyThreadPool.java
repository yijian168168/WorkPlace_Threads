package com.thread.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by ZhangQingrong on 2017/6/12.
 */
@Configuration
public class MyThreadPool {

    @Bean(name = "testThreadPool")
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        //核心线程数
        threadPool.setCorePoolSize(3);
        //队列大小
        threadPool.setQueueCapacity(20);
        //最大线程数
        threadPool.setMaxPoolSize(20);
        //线程空闲时间，单位：秒
        threadPool.setKeepAliveSeconds(3);
        return threadPool;
    }
}
