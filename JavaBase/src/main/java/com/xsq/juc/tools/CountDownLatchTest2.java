package com.xsq.juc.tools;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {
    public static void main(String[] args) {
        int numTasks = 5;
        CountDownLatch latch = new CountDownLatch(numTasks);

        for (int i = 0; i < numTasks; i++) {
            new Thread(new Task(latch)).start();
        }

        try {
            // 主线程等待，直到latch的计数为0
            latch.await();
            System.out.println("所有任务已完成，主线程继续执行。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        private final CountDownLatch latch;

        Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // 模拟任务执行
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " 任务完成。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 任务完成后，将latch的计数减1
                latch.countDown();
            }
        }
    }
}


