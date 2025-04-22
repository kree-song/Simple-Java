package com.xsq.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建10个线程抢100张票
 */
public class TicketBookingWithThread implements Runnable {
    private static int count = 100;
    private final String name;

    public TicketBookingWithThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (count > 0) {
                    count--;
                    System.out.println(name + " 抢到一张票，余票为" + count);
                } else {
                    System.out.println(name + " 票已售罄");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new TicketBookingWithThread("线程" + i));
//            thread.start();
//        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new TicketBookingWithThread("线程" + i));
        }
        executorService.shutdown();
    }
}
