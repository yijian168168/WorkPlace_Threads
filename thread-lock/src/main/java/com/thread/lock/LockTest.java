package com.thread.lock;

import org.junit.Test;

/**
 * Created by 10068 on 2017/6/25.
 */
public class LockTest {

    @Test
    public void test(){
        while (true){
            new Thread(){
                @Override
                public void run() {
                    work("zhangqingrong");
                }
            }.start();
            new Thread(){
                @Override
                public void run() {
                    work("zhuoyuqin");
                }
            }.start();
        }
    }

    public void work(String value){
        char[] chars = value.toCharArray();
        for (char ch : chars){
            System.out.printf(String.valueOf(ch));
        }
        System.out.println("");
    }

    @Test
    public void testLock(){
        while (true){
            new Thread(){
                @Override
                public void run() {
                    workLock("zhangqingrong");
                }
            }.start();
            new Thread(){
                @Override
                public void run() {
                    workLock("zhuoyuqin");
                }
            }.start();
        }
    }

    public void workLock(String value){
        LockContexts.lock.lock();
        try {
            char[] chars = value.toCharArray();
            for (char ch : chars){
                System.out.printf(String.valueOf(ch));
            }
            System.out.println("");
        }finally {
            LockContexts.lock.unlock();
        }
    }
}
