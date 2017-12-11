package com.thread.test2;

import static com.thread.test1.Product.MAX_PRODUCT;
import static com.thread.test1.Product.MIN_PRODUCT;

/**
 * Created by QR on 2016/8/16.
 */
public class Factory {

    /***
     * 当前产品数量
     */
    private int product = 0;

    /**
     * 生产者生产出来的产品交给店员
     */
    public synchronized void produce() {
        if (this.product >= MAX_PRODUCT) {
            try {
                System.out.println(Thread.currentThread().getName() + ", 产品已满,请稍候再生产");
                wait();
                System.out.println(Thread.currentThread().getName() + ", 缺产品，被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        this.product++;
        System.out.println(Thread.currentThread().getName() + ",生产者生产第" + this.product++ + "个产品.");
        notifyAll();   //通知等待区的消费者可以取出产品了
    }

    /**
     * 消费者从店员取产品
     */
    public synchronized void consume() {
        if (this.product <= MIN_PRODUCT) {
            try {
                System.out.println(Thread.currentThread().getName() + ", 缺货,稍后再取");
                wait();
                System.out.println(Thread.currentThread().getName() + ", 有产品，被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }

        System.out.println(Thread.currentThread().getName() + ", 消费者取走了第" + this.product + "个产品.");
        this.product--;
        notifyAll();   //通知等待去的生产者可以生产产品了
    }
}
