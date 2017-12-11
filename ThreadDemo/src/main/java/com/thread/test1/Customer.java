package com.thread.test1;

/**
 * Created by QR on 2016/8/16.
 */
public class Customer implements Runnable {

    /**
     * 消费产品
     */
    public synchronized void run() {

        synchronized (Product.LOCK){

            if (Product.product <= Product.MIN_PRODUCT) {
                try {
                    System.out.println(Thread.currentThread().getName() + "缺货,稍候再取");
                    wait();
                    System.out.println(Thread.currentThread().getName() + "有产品，被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }

            System.out.println(Thread.currentThread().getName() + "消费者取走了第" + Product.product + "个产品.");
            Product.product--;
            Product.LOCK.notify();
            //notifyAll();   //通知等待去的生产者可以生产产品了
        }
    }
}
