package com.xsq.juc.thread.example.BoundedBufferProblem2Object;

public class Consumer extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.objLock) {
                if (Desk.count == 0)
                    break;
                else {
                    if (Desk.flag) {
                        //有
                        System.out.println("吃货在吃汉堡包");
                        Desk.flag = false;
                        Desk.objLock.notifyAll();
                        Desk.count--;
                    } else {
                        try {
                            //没有就等待
                            //使用什么对象当做锁,那么就必须用这个对象去调用等待和唤醒的方法.
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
