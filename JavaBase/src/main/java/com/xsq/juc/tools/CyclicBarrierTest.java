package com.xsq.juc.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static CyclicBarrier barrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try {
            barrier.await();
        } catch (Exception e) {

        }
        System.out.println(2);
    }
}
