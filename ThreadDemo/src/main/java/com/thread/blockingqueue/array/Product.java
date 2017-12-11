package com.thread.blockingqueue.array;

/**
 * Created by QR on 2016/8/16.
 */
public class Product {

    private int id;

    public Product(int id) {
        this.id = id;
    }

    public String toString() {// 重写toString方法
        return "产品：" + this.id;
    }
}

