package com.xsq.juc.thread.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(
                        1,
                        3,
                        20,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(1),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
