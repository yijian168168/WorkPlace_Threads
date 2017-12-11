package com.thread.Inheritable;

import org.junit.Test;

/**
 * Created by Lenovo-PC-QR on 2016/11/21.
 */
public class ThreadLocalTest {

    @Test
    public void test1() throws InterruptedException {

        ThreadLocalContext.set("ThreadLocalContext");
        InheritableThreadLocalContext.set("InheritableThreadLocalContext");

        for (int i=1;i<10;i++){
            Thread thread = new Thread(){

                @Override
                public void run() {
                    System.out.println("aaaaaaaaaaaaaaaaaaa : " + Thread.currentThread().getName() + " - ThreadLocalContext :  " + ThreadLocalContext.get());
                    System.out.println("bbbbbbbbbbbbbbbbbbb : " + Thread.currentThread().getName() + " - InheritableThreadLocalContext :  " + InheritableThreadLocalContext.get());
                }
            };

            thread.setName("" + i);
            thread.start();
        }
        System.out.println("ccccccccccccccccccc : " + Thread.currentThread().getName() + "  - ThreadLocalContext :  " + ThreadLocalContext.get());
        System.out.println("ddddddddddddddddddd : " + Thread.currentThread().getName() + " - InheritableThreadLocalContext :  " + InheritableThreadLocalContext.get());
        Thread.sleep(6000);

    }
}

