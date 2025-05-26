package com.xsq.juc.thread.example.BoundedBufferProblem2BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Producter extends Thread {
    private ArrayBlockingQueue<String> bq;

    public Producter(ArrayBlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bq.put("汉堡");
                System.out.println("生产了一个汉堡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
