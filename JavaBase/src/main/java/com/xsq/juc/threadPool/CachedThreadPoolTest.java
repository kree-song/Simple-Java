package com.xsq.juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓存线程池会根据需要创建新线程，如果有空闲线程则复用。线程池中的线程如果在60秒内未被使用，会被终止并从池中移除
 * 若任务执行时间较短，后续任务可能会复用之前创建的空闲线程
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        //创建缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            final int taskNumber = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskNumber + " is running on thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskNumber + " has finished.");
            });
        }

        // 关闭线程池，不再接受新任务
        executorService.shutdown();
    }
}