package com.thread.test2;

/**
 * Created by QR on 2016/8/16.
 */
public class ProducerThread implements Runnable {

    private Factory factory;

    public ProducerThread(Factory factory) {
        this.factory = factory;
    }

    public void run() {
        factory.produce();
    }
}
