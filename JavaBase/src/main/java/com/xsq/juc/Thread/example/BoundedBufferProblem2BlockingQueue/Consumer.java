package com.xsq.juc.Thread.example.BoundedBufferProblem2BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer extends Thread {
    private ArrayBlockingQueue<String> bq;

    public Consumer(ArrayBlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String take = bq.take();
                System.out.println("消费了一个" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
