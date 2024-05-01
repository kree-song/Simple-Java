package com.xsq.Thread.example;

public class SellTicket2 implements Runnable {
    private int tickets = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj) {
            while (true) {
                if (tickets <= 0)
                    break;
                else {
                    //Thread.sleep(1000);
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + tickets + "张票");
                }
            }
        }
    }
}
