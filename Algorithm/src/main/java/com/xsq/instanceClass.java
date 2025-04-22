package com.xsq;

public class instanceClass {
    public static volatile instanceClass instance = null;

    public static instanceClass getInstance() {
        if (instance == null) {
            synchronized (instanceClass.class) {
                if (instance == null) {
                    instance = new instanceClass();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        instanceClass instance1 = instanceClass.getInstance();
        System.out.println(instance1);
    }
}