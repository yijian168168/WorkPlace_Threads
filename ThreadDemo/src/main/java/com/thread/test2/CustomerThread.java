package com.thread.test2;

/**
 * Created by QR on 2016/8/16.
 */
public class CustomerThread implements Runnable {

    private Factory factory;

    public CustomerThread(Factory factory) {
        this.factory = factory;
    }

    public void run() {
        factory.consume();
    }
}
