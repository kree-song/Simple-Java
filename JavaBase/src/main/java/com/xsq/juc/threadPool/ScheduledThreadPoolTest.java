package com.xsq.juc.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 周期任务线程池可以执行定时任务和周期任务
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个周期任务线程池，初始线程数为2
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        // 延迟3秒后执行任务
//        executorService.schedule(() -> {
//            System.out.println("Delayed task is running on thread " + Thread.currentThread().getName());
//        }, 3, TimeUnit.SECONDS);

        // 延迟1秒后开始执行任务，之后每隔2秒执行一次
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task is running on thread " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        // 关闭线程池，不再接受新任务
        // 注意：这里如果不调用shutdown，主线程结束后线程池可能不会退出
      //  executorService.shutdown();
    }
}