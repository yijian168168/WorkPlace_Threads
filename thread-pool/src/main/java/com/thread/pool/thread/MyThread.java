package com.thread.pool.thread;

/**
 * Created by ZhangQingrong on 2017/6/12.
 */
public class MyThread implements Runnable {

    private String id;

    public MyThread() {
    }

    public MyThread(String id) {
        this.id = id;
    }

    public void run() {
        System.out.println("start to deal : " + id);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
