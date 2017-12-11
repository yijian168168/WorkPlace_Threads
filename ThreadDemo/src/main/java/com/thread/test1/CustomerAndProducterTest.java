package com.thread.test1;

import org.junit.Test;

/**
 * Created by QR on 2016/8/16.
 */
public class CustomerAndProducterTest {

    @Test
    public void test1() throws InterruptedException {

        Customer customer = new Customer();
        Procucer procucer = new Procucer();

        for (int i=0;i<1;i++){
            new Thread(customer,"Thread_C_" + i).start();
            new Thread(procucer,"Thread_P_" + i).start();
        }

        Thread.sleep(50000);
    }
}
