package com.xsq.jvm;

public class testJDK {
    public static void main(String[] args) {
        //System.exit()-->Runtime.getRuntime().exit()-->Shutdown.exit()-->
        //halt()-->halt0()-->static native void halt0()
        System.exit(0);
        //使用本地方法初始化对象out
        System.out.println();
        String s = "\\|";
    }
}
