package com.xsq.collections.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream流的获取
 * 单列集合：集合对象.stream();
 * 双列集合：不能直接获取，需要间接获取
 *         集合对象.keySet().stream();
 *         集合对象.entrySet().stream();
 * 数组   ：Arrays.stream(数组名)；
 * 同种数据类型的多个数据：Stream.of(数据1，数据2，数据3.....)
 *
 * 创建并行流： S parallel()
 *            default Stream<E> parallelStream()
 *            S sequential()
 */
public class testGetStream {
    public static void main(String[] args) {
        //method1();
        method2();
        //method3();
        //method4();
        //method5();
    }

    /**
     * List
     */
    private static void method1() {
        //单列集合
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
       /* Stream<String> stream = list.stream();
        stream.forEach(s->{
            System.out.println(s);
        });*/
        list.stream().forEach(System.out::println);
    }

    /**
     * Map
     */
    private static void method2() {
        //双列集合
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("zhansan", 23);
        hm.put("lisi", 21);
        hm.put("wangwu", 20);

        //双列集合不能直接获取Stream流
        //KeySet：先获取所有的键，再把这个Set集合中所有的键放到Stream流中
        hm.keySet().stream().forEach(System.out::println);
        hm.values().stream().forEach(System.out::println);

        //entrySet：先获取到所有的键值对对象，再把这个Set集合中所有的键值对对象放到Stream流中
        hm.entrySet().stream().forEach(System.out::println);
    }

    /**
     * Array
     */
    private static void method3() {
        //数组
        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * 可变参数
     */
    private static void method4() {
        //同种数据类型的多个数据
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).forEach(System.out::println);
    }

    /**
     * 创建并行流
     * 在原有的Stream对象上面设置了一个并行参数
     *  S parallel()
     *  default Stream<E> parallelStream()
     *  S sequential()
     */
    private static void method5(){
        Stream<Integer> parallelStream = Stream.of(1, 2, 3).parallel();
        Stream<Integer> integerStream = Arrays.asList(1, 2, 3).parallelStream();
        Stream<Integer> sequentialStream = Stream.of(1, 2, 3).parallel().sequential();//并行流转换为串行流
    }
}
