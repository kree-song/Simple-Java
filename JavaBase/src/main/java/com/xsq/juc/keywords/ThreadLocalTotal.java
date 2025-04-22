package com.xsq.juc.keywords;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ThreadLocalTotal {
    //模拟门店三个销售一共卖出多少辆车
    //那个地方  我觉得意思应该是模拟销售随机卖出几辆车 这个随机几辆  为啥在for循环里边？
    public static void main(String[] args) throws InterruptedException {
        SU7 su7 = new SU7();
        CountDownLatch cdl = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    int num = new Random().nextInt(3)+1;
                    for (int j = 1; j <= num; j++) {
                        su7.saleMethod();
                        System.out.println(Thread.currentThread().getName()+"\t"+ j +"\t" + su7.getSaleTotal());
                    }
                } finally {
                    cdl.countDown();
                }
            }, String.valueOf(i)).start();
        }
        cdl.await();
        System.out.println(Thread.currentThread().getName()+"\t"+"销售总额："+su7.getSaleTotal());
    }
}
