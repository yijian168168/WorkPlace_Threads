package com.thread.pool.thread;

import org.apache.commons.lang.math.RandomUtils;

import java.util.concurrent.Callable;

/**
 * Created by 10068 on 2017/6/25.
 */
public class CallableThread implements Callable<String> {

    private String value;

    public CallableThread(String value) {
        this.value = value;
    }

    public String call() throws Exception {
        System.out.println("start to deal " + value);
        int random = RandomUtils.nextInt(10);
        Thread.sleep(random);
        return value;
    }
}
