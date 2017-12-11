package com.thread.Inheritable;

/**
 * 线程上下文
 * 线程结束删除
 * Created by Lenovo-PC-QR on 2016/11/21.
 */
public class ThreadLocalContext {

    private static ThreadLocal<String> context = new ThreadLocal<String>();

    public static void set(String value){
        context.set(value);
    }

    public static String get(){
        return context.get();
    }
}
