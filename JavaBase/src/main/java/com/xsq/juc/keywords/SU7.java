package com.xsq.juc.keywords;

public class SU7 {
    private int saleTotal;

    public int getSaleTotal() {
        return saleTotal;
    }

    public synchronized void saleMethod() {
        saleTotal++;
    }
}
