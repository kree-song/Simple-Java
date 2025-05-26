package com.xsq.juc.thread.example.BoundedBufferProblem2Object;

public class Producter extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.objLock) {
                if (Desk.count == 0)
                    break;
                else {
                    if (!Desk.flag) {
                        //生产
                        System.out.println("厨师正在生产汉堡包");
                        Desk.flag = true;
                        Desk.objLock.notifyAll();
                    } else {
                        try {
                            Desk.objLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
