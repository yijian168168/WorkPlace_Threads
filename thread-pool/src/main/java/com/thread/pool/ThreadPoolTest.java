package com.thread.pool;

import com.thread.pool.thread.CallableThread;
import com.thread.pool.thread.MyThread;
import com.thread.pool.thread.ThreadPoolWatcher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;

/**
 * Created by ZhangQingrong on 2017/6/12.
 */
public class ThreadPoolTest {

    @Test
    public void test1() throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/thread-pool.xml");
        ThreadPoolTaskExecutor threadPool = applicationContext.getBean(ThreadPoolTaskExecutor.class);
        new Thread(new ThreadPoolWatcher(threadPool)).start();
        for (int i = 0; i < 50; i++) {
            MyThread myThread = new MyThread(String.valueOf(i));
            Thread.sleep(1000);
            threadPool.execute(myThread);
        }
        Thread.sleep(1000000);
    }

    @Test
    public void test2() throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        ThreadPoolTaskExecutor threadPool = (ThreadPoolTaskExecutor) applicationContext.getBean("testThreadPool");
//        new Thread(new ThreadPoolWatcher(threadPool)).start();
        for (int i = 0; i < 1; i++) {
            MyThread myThread = new MyThread(String.valueOf(i));
            Thread.sleep(1000);
            threadPool.execute(myThread);
        }
        Thread.sleep(1000000);
    }

    @Test
    public void test3() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        ThreadPoolTaskExecutor threadPool = (ThreadPoolTaskExecutor) applicationContext.getBean("testThreadPool");
        List<Future<String>> fatures = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            CallableThread callableThread = new CallableThread(String.valueOf(i));
            Future<String> submit = threadPool.submit(callableThread);
            fatures.add(submit);
        }
        for (Future<String> submit : fatures){
            System.out.println("result : " + submit.get());
        }
    }

    @Test
    public void test4() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        ThreadPoolTaskExecutor threadPool = (ThreadPoolTaskExecutor) applicationContext.getBean("testThreadPool");
        CompletionService<String> completionService = new ExecutorCompletionService<String>(threadPool);
        for (int i = 0; i < 10; i++) {
            CallableThread callableThread = new CallableThread(String.valueOf(i));
            completionService.submit(callableThread);
        }
        for (int i = 0; i < 10; i++) {
            String resutl = completionService.take().get();
            System.out.println("result  ：" + resutl);
        }
    }




}
