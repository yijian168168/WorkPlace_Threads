package com.thread.test2;

import org.junit.Test;

/**
 * Created by QR on 2016/8/16.
 */
public class Test2 {

    @Test
    public void test1() {
        Factory factory = new Factory();
        for (int i = 0; i < 1; i++) {
            factory.consume();
            factory.produce();
        }

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() throws InterruptedException {
        Factory factory = new Factory();

        CustomerThread customerThread = new CustomerThread(factory);
        ProducerThread producerThread = new ProducerThread(factory);

        for (int i=0;i<10;i++){
            new Thread(customerThread,"Thread_C_"+i).start();
//            Thread.sleep(1000);
            new Thread(producerThread,"Thread_P_"+i).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
