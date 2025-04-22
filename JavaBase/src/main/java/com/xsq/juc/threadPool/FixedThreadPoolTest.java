package com.xsq.juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定大小线程池会创建一个指定数量线程的线程池，线程池中的线程数量始终保持不变。
 * 当有新任务提交时，如果线程池中有空闲线程，则立即执行任务；否则，任务会被放入队列中等待，直到有线程可用
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        //创建一个固定大小为3的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //由于线程池大小为3，前3个任务会立即由3个线程并行执行，剩下的2个任务会在队列中等待，当有线程完成任务后，会从队列中取出任务继续执行
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