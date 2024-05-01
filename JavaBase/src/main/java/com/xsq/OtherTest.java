package com.xsq;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OtherTest {
    private static Vector<Integer> vector = new Vector<>();
    private AtomicInteger cnt = new AtomicInteger();

    public static void main(String[] args) {
        //VectorUnsafeExample();
        testLocalVariable();
    }

    /**
     * 相对线程安全
     */
    public static void VectorUnsafeExample() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                vector.add(i);
            }
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        Integer oldValue = vector.remove(i);
                        System.out.println("remove:" + oldValue);
                    }
                }
            });
            executorService.execute(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        Integer value = vector.get(i);
                        System.out.println("get:" + value);
                    }
                }
            });
            executorService.shutdown();
        }
    }

    /**
     * <h3>栈封闭</h3>
     * 多个线程访问同一个方法的局部变量时，不会出现线程安全问题，因为局部变量存储在虚拟机栈中，属于线程私有的
     */
    public static void testLocalVariable() {
        StackClosedExample example = new StackClosedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.add100());
        executorService.execute(() -> example.add100());
        executorService.shutdown();
    }

    /**
     * AtomicInteger中的CAS操作
     */
    public void add() {
        //底层调用unsafe#getAndAddInt --> unsafe#compareAndSwapInt
        cnt.incrementAndGet();
    }

    private static class StackClosedExample {
        public void add100() {
            int cnt = 0;
            for (int i = 0; i < 100; i++) {
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
