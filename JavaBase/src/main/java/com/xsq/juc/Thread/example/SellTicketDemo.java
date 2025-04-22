package com.xsq.juc.Thread.example;

import java.util.concurrent.FutureTask;

public class SellTicketDemo {
    public static void main(String[] args) {
        //CallableTest();
        RunableTest();
    }

    public static void RunableTest() {
        SellTicket2 st = new SellTicket2();
        Thread t1 = new Thread(st, "窗口一");
        Thread t2 = new Thread(st, "窗口二");
        Thread t3 = new Thread(st, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }

    public static void CallableTest() {
        SellTicket st = new SellTicket();
        FutureTask ft = new FutureTask(st);
        FutureTask ft2 = new FutureTask(st);
        FutureTask ft3 = new FutureTask(st);

        Thread t1 = new Thread(ft, "窗口一");
        Thread t2 = new Thread(ft2, "窗口二");
        Thread t3 = new Thread(ft3, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
