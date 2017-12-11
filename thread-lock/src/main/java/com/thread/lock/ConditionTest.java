package com.thread.lock;

import org.junit.Test;

import java.util.concurrent.locks.Condition;

/**
 * Created by 10068 on 2017/6/25.
 */
public class ConditionTest {

    private Condition work1 = LockContexts.lock.newCondition();

    private Condition work2 = LockContexts.lock.newCondition();

    private volatile String control = "work1";

    @Test
    public void test() throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    new Thread(){
                        @Override
                        public void run() {
                            work1();
                        }
                    }.start();

                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    new Thread(){
                        @Override
                        public void run() {
                            work2();
                        }
                    }.start();

                }
            }
        }.start();
        Thread.sleep(60000);
    }

    public void work1() {
        try {
            LockContexts.lock.lock();
            while (!control.equals("work1")){
                work1.await();
            }
//            work1.await();
            control = "work2";
            System.out.println("work1 ... ");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
//            work2.signal();
            work1.signal();
            LockContexts.lock.unlock();
        }
    }

    public void work2(){
        try {
            LockContexts.lock.lock();
            while (!control.equals("work2")){
                work1.await();
            }
//            work2.await();
            control = "work1";
            System.out.println("work2 ... ");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
//            work1.signal();
            work1.signal();
            LockContexts.lock.unlock();
        }
    }
}
