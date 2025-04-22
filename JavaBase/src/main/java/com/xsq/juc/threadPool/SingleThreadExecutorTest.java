package com.xsq.juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程线程池只有一个线程来执行任务，任务会按照提交顺序依次执行，确保所有任务串行执行
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        //创建单线程线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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