package com.thread.lock;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

/**
 * Created by 10068 on 2017/6/25.
 */
public class ReadWriteLockTest {

    private String data;

    @Test
    public void test() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    read();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    write();
                    try {
                        Thread.sleep(RandomUtils.nextInt(200));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        int i = RandomUtils.nextInt();
        System.out.println("start to read : " + i);
        try {
            Thread.sleep(RandomUtils.nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("read Data : " + i + " , data : " + data);
    }

    public void write() {
        int i = RandomUtils.nextInt();
        System.out.println("start to write Data : " + i);
        try {
            Thread.sleep(RandomUtils.nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = String.valueOf(i);
        System.out.println("write Data success : " + data);
    }

    @Test
    public void testReadWriteLock() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    new Thread(){
                        @Override
                        public void run() {
                            readLock();
                        }
                    }.start();

                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    writeLock();
                    try {
                        Thread.sleep(RandomUtils.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void readLock() {
        LockContexts.readWriteLock.readLock().lock();
        try {
            int i = RandomUtils.nextInt();
            System.out.println("start to read : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("read Data : " + i + " , data : " + data);
        } finally {
            LockContexts.readWriteLock.readLock().unlock();
        }


    }

    public void writeLock() {
        LockContexts.readWriteLock.writeLock().lock();
        try {
            int i = RandomUtils.nextInt();
            System.out.println("start to write Data : " + i);
            try {
                Thread.sleep(RandomUtils.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = String.valueOf(i);
            System.out.println("write Data success : " + data);
        } finally {
            LockContexts.readWriteLock.writeLock().unlock();
        }

    }


}
