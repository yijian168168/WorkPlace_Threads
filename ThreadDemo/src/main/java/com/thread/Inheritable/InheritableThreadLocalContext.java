package com.thread.Inheritable;

/**
 * 线程上下文，可以访问父线程上下文
 * Created by Lenovo-PC-QR on 2016/11/21.
 */
public class InheritableThreadLocalContext {

    public static InheritableThreadLocal<String> context = new InheritableThreadLocal();

    public static String get(){
        return context.get();
    }

    public static void set(String value){
        context.set(value);
    }
}
