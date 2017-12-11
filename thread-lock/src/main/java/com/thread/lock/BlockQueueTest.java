package com.thread.lock;

import org.junit.Test;

import java.util.concurrent.locks.Condition;

/**
 * Created by 10068 on 2017/6/25.
 */
public class BlockQueueTest {

    private Condition notFull = LockContexts.lock.newCondition();
    private Condition notEmpty = LockContexts.lock.newCondition();
    private String[] queue = new String[3];
    private volatile int count = 0;

    @Test
    public void test(){
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    new Thread(){
                        @Override
                        public void run() {
                            in();
                        }
                    }.start();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    new Thread(){
                        @Override
                        public void run() {
                            out();
                        }
                    }.start();
                }
            }
        }.start();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void in(){
        LockContexts.lock.lock();
        try {
            while (count >= queue.length){
                notFull.await();
            }
            count++;
            System.out.println("in success : " + count);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LockContexts.lock.unlock();
        }
    }

    private void out(){
        LockContexts.lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            count--;
            Thread.sleep(1000);
            System.out.println("out success : " + count);
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LockContexts.lock.unlock();
        }
    }
}
