package ru.senkin.lesson3.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCount {

    private final Lock lock;

    private Integer count;

    private final Integer maxCount;


    public LockCount(Integer maxCount) {

        this.maxCount = maxCount;

        this.lock = new ReentrantLock();

        this.count = 0;

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LockClass(i, this.maxCount));
            thread.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public class LockClass implements Runnable{

        private final Integer threadCount;

        private final Integer iterCount;
        public LockClass(Integer threadCount, Integer iterCount) {
            this.threadCount = threadCount;
            this.iterCount = iterCount;
        }

        @Override
        public void run() {
            boolean locked = false;
            while (count < iterCount) {
                try {
                    locked = lock.tryLock(100,
                            TimeUnit.MILLISECONDS);
                    if (locked) {
                        count = count + 1;
                        System.out.println("thread " + threadCount + ": count = " + count);
                        lock.unlock();
                        locked = false;
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (locked) {
                        lock.unlock();
                    }
                }
            }
        }
    }

}
