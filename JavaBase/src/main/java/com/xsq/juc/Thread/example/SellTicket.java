package com.xsq.juc.Thread.example;

import java.util.concurrent.Callable;

public class SellTicket implements Callable {
    private int tickets = 100;

    @Override
    public Object call() throws Exception {
        while (true) {
            if (tickets <= 0)
                break;
            else {
                //Thread.sleep(1000);
                tickets--;
                System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + tickets + "张票");
            }
        }
        return null;
    }
}
