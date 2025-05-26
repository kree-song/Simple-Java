package com.xsq.juc.keywords;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ThreadLocalTotal {
    public static void main(String[] args) {
        ThreadLocalTotal t = new ThreadLocalTotal();
        try {
            t.sellCar();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 模拟门店三个销售一共卖出多少辆车
     * @throws InterruptedException
     */
    public void sellCar() throws InterruptedException {
        SU7 su7 = new SU7();
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    int num = new Random().nextInt(3) + 1;
                    for (int j = 1; j <= num; j++) {
                        su7.sale();
                        System.out.println("线程" + Thread.currentThread().getName() + "\t销售" + j + "\t销售额：" + su7.getSaleTotal());
                    }
                } finally {
                    latch.countDown();
                }
            }, String.valueOf(i)).start();
        }
        latch.await();

        System.out.println("线程" + Thread.currentThread().getName() + "\t" + "销售总额：" + su7.getSaleTotal());
    }

    class SU7 {
        private int saleTotal;

        public int getSaleTotal() {
            return saleTotal;
        }

        public synchronized void sale() {
            saleTotal++;
        }
    }
}
