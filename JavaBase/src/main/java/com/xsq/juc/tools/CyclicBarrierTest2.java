package com.xsq.juc.tools;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
    public static void main(String[] args) {
        int numTasks = 5;
        CyclicBarrier barrier = new CyclicBarrier(numTasks, () -> {
            System.out.println("所有任务已完成，主线程继续执行。");
        });

        for (int i = 0; i < numTasks; i++) {
            new Thread(new TaskWithBarrier(barrier)).start();
        }
    }

    static class TaskWithBarrier implements Runnable {
        private final CyclicBarrier barrier;

        TaskWithBarrier(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                // 模拟任务执行
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " 任务完成。");
                // 到达屏障点
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}