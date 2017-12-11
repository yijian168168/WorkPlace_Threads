package com.thread.test1;

/**
 * Created by QR on 2016/8/16.
 */
public class Procucer implements Runnable{

    /**
     * 生产产品
     * */
    public void run() {

        synchronized (Product.LOCK){

            if (Product.product >= Product.MAX_PRODUCT) {
                try {
                    System.out.println(Thread.currentThread().getName() + "产品已满,请稍候再生产");
                    wait();
                    System.out.println(Thread.currentThread().getName() + "缺产品，被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            Product.product++;
            System.out.println(Thread.currentThread().getName() + "生产者生产第" + Product.product + "个产品.");
            Product.LOCK.notify();
            //notifyAll();   //通知等待区的消费者可以取出产品了
        }
    }
}
