package com.thread.test1;

/**
 *
 * Created by QR on 2016/8/16.
 */
public class Product {

    public static Object LOCK = new Object();

    /**
     * 仓库最大容量
     */
    public static final int MAX_PRODUCT = 3;
    /**
     * 仓库最小容量
     */
    public static final int MIN_PRODUCT = 0;
    /**
     * 当前产品数量
     */
    public static int product = 0;
}
