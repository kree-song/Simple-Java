package com.xsq.lambda.whpu;

public interface IFormala {
    static double getRoot1(int a) {
        return Math.sqrt(a);
    }

    double getResult(int a);

    default double getRoot2(int a) {
        return Math.sqrt(a);
    }
}
