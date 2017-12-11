package com.thread.blockingqueue.array;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by QR on 2016/8/16.
 */
public class Storage {

    BlockingQueue<Product> queues = new LinkedBlockingQueue<Product>(10);

    /**
     * 生产
     *
     * @param p
     *            产品
     * @throws InterruptedException
     */
    public void push(Product p) throws InterruptedException {
        queues.put(p);
    }

    /**
     * 消费
     *
     * @return 产品
     * @throws InterruptedException
     */
    public Product pop() throws InterruptedException {
        return queues.take();
    }
}

