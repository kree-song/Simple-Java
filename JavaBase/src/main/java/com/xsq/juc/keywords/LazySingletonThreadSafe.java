package com.xsq.juc.keywords;

public class LazySingletonThreadSafe {
    private static volatile LazySingletonThreadSafe instance;

    private LazySingletonThreadSafe(){};

    public static LazySingletonThreadSafe gThreadSafe() {
        if (instance == null) {
            synchronized (LazySingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new LazySingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}
