package com.xsq.collections.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 简单聚合
 * void forEach(Consumer action)：对此流中的每个元素执行操作
 * void forEachOrdered(Consumer<? super T> action)：同forEach方法，在并行流中始终按照顺序执行
 * long count()：返回此流中的元素数
 * boolean allMatch(Predicate<? super T> predicate)：判断条件里的元素，所有的都是，返回true
 * boolean noneMatch(Predicate<? super T> predicate)：与allMatch相反，判断条件里的元素，所有的都不是，返回true
 * boolean anyMatch(Predicate<? super T> predicate)：判断的条件里，任意一个元素成功，返回true
 * Optional<T> findFirst()：返回Stream中的第一个元素，Stream可能为空所以返回值用Optional处理
 * Optional<T> findAny()：返回Stream中的任意一个元素，串型流中一般是第一个元素，Stream可能为空所以返回值用Optional处理
 *
 * 规约
 * Optional reduce(BinaryOperator accumulator)：根据指定的计算模型将Stream中的值计算得到一个最终结果
 * T reduce(T identity, BinaryOperator accumulator)：带初始值，根据指定的计算模型将Stream中的值计算得到一个最终结果
 * Optional<T> max(Comparator<? super T> comparator)：利用规约求最大值
 * OptionalInt max()：[IntStream]利用规约求最大值
 * Optional<T> min(Comparator<? super T> comparator)：利用规约求最小值
 *
 * 收集器
 * R collect(Collector collector)：Stream流的收集方法
 * 工具类Collectors提供了具体的收集方式
 * static <T> Collector toList()：把元素收集到List集合中
 * static <T> Collector toSet()：把元素收集到Set集合中
 * static Collector toMap(Function keyMapper,Function valueMapper)：把元素收集到Map集合中
 * static <T, K, U> Collector<T, ?, ConcurrentMap<K,U>> toConcurrentMap(Function<? super T, ? extends K> keyMapper,Function<? super T, ? extends U> valueMapper)：返回一个线程安全的Map
 *  分组
 * static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier)：以计算结果作为key值，符合条件的值加入对应集合
 * static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,Collector<? super T, A, D> downstream)：第二个参数指定收集器
 * static <T, K> Collector<T, ?, ConcurrentMap<K, List\<T>>> groupingByConcurrent(Function<? super T, ? extends K> classifier)：在并行时提高分组效率，但是是不保证顺序
 *  分区
 *
**/
public class testEndOp {
    public static void main(String[] args) {
        //method1();
        //method2();
        //method3();
        //method4();
        //method5();
        //method6();
        //method7();
        //method8();
        method9();
    }


    /**
     * void forEach(Consumer action)：对此流中的每个元素执行操作
     *      Consumer接口中的方法：void accept(T t)：对给定的参数执行此操作
     * void forEachOrdered(Consumer<? super T> action)：同forEach方法，在并行流中始终按照顺序执行
     */
    private static void method1() {
        //在foreach方法的底层，会循环获取到流中的每一个数据，并循环调用accept方法，并把每一个数据传递给accept方法
        //s就表示流中每一个数据，故只要在accept中写上处理的业务逻辑就可以了
        Stream.of("A","B","C", "D").forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("--------------------");

        //Consumer接口中只有一个accept方法，故可用lambda简化
        Stream.of("A","B","C", "D").forEach((String s) -> {
            System.out.println(s);
        });
        System.out.println("--------------------");

        Stream.of("A","B","C", "D").parallel().forEach(System.out::println);
        System.out.println("---");
        Stream.of("A","B","C", "D").parallel().forEachOrdered(System.out::println);
    }

    /**
     * long count()：返回此流中的元素数
     */
    private static void method2() {
        long count = Stream.of(1, 2, 3).count();
        System.out.println(count);
    }

    /**
     * boolean allMatch(Predicate<? super T> predicate)：判断条件里的元素，所有的都是，返回true
     * boolean noneMatch(Predicate<? super T> predicate)：与allMatch相反，判断条件里的元素，所有的都不是，返回true
     * boolean anyMatch(Predicate<? super T> predicate)：判断的条件里，任意一个元素成功，返回true
     */
    private static void method3(){
        boolean a = Stream.of(1, 1, 2, 1, 1).allMatch(o -> o == 1);//false
        boolean b = Stream.of(1, 2, 3, 4, 5).noneMatch(o -> o == 5);//false
        boolean c = Stream.of(1, 2, 3, 4, 5).anyMatch(o -> o == 5);//true
        System.out.println(a + "--" + b + "--" + c);
    }

    /**
     * Optional<T> findFirst()：返回Stream中的第一个元素，Stream可能为空所以返回值用Optional处理
     * Optional<T> findAny()：返回Stream中的任意一个元素，串型流中一般是第一个元素，Stream可能为空所以返回值用Optional处理
     */
    private static void method4(){
        Optional<Integer> first = Stream.of(1, 1, 2, 1, 1).findFirst();
        System.out.println(first.orElse(0));//1

        Optional<Integer> any = Stream.of(1, 1, 2, 1, 1).parallel().findAny();
        System.out.println(any.orElse(0));
    }

    /**
     * Optional reduce(BinaryOperator accumulator)：根据指定的计算模型将Stream中的值计算得到一个最终结果
     * T reduce(T identity, BinaryOperator accumulator)：带初始值，根据指定的计算模型将Stream中的值计算得到一个最终结果
     */
    private static void method5(){
        Optional<Integer> optionalObj = Stream.of(1, 2, 3).reduce((a, b) -> a + b);
        Integer reduceNum = optionalObj.orElse(0);
        Integer reduceNum1 = Stream.of(1, 2, 3).reduce(1, (a, b) -> a + b);
        Integer reduceNum2 = Stream.of(1, 2, 3).reduce(1, Integer::sum);
        System.out.println(reduceNum + "--" + reduceNum1 + "--" + reduceNum2);
    }

    /**
     * Optional<T> max(Comparator<? super T> comparator)：利用规约求最大值
     * OptionalInt max()：[IntStream]利用规约求最大值
     * Optional<T> min(Comparator<? super T> comparator)：利用规约求最小值
     */
    private static void method6(){
        Optional<Integer> max = Stream.of(1, 2, 3).max((a, b) -> {
            if (a > b) {
                return 1;
            } else {
                return -1;
            }
        });
        Optional<Integer> max1 = Stream.of(1, 2, 3).max(Integer::compare);
        OptionalInt max2 = IntStream.of(1, 2, 3).max();
        System.out.println(max.orElse(0) + "--" + max1.orElse(0) + "--" + max2.orElse(0));
        Optional<Integer> min = Stream.of(1, 2, 3).min(Integer::compare);
        System.out.println(min.orElse(0));
    }

    /**
     * public static <T> Collector toList()：把元素收集到List集合中
     * public static <T> Collector toSet()：把元素收集到Set集合中
     */
    private static void method7() {
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }
        list1.add(10);
        list1.add(10);
        list1.add(10);
        list1.add(10);

        //filter负责过滤数据
        //collect负责收集数据：获取流中的数据，但是不负责创建容器，也不负责把数据添加到容器中
        //collections.toList()：在底层会创建一个List集合，并把所有的数据添加到List集合中
        List<Integer> list = list1.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println(list);

        Set<Integer> set = list1.stream().filter(number -> number % 2 == 0).collect(Collectors.toSet());
        System.out.println(set);
    }


    /**
     * static Collector toMap(Function keyMapper,Function valueMapper)：把元素收集到Map集合中
     * static <T, K, U> Collector<T, ?, ConcurrentMap<K,U>> toConcurrentMap(Function<? super T, ? extends K> keyMapper,Function<? super T, ? extends U> valueMapper)：返回一个线程安全的Map
     */
    private static void method8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan,23");
        list.add("lisi,24");
        list.add("wangwu,25");

        //collect方法只能获取到流中剩余的每一个数据，在底层不能创建容器，也不能把数据添加到容器当中
        //Collectors.toMap():创建一个Map集合并将数据添加到集合当中
        // s 依次表示流中每一个数据
        //第一个lambda表示如何获取到Map中的键
        //第二个lambda表示如何获取到Map中的值
        Map<String, Integer> map = list.stream().filter(
                s -> {
                    String[] spilt = s.split(",");
                    int age = Integer.parseInt(spilt[1]);
                    return age >= 24;
                }
        ).collect(Collectors.toMap(
                (String s) -> {
                    return s.split(",")[0];
                },
                (String s) -> {
                    return Integer.parseInt(s.split(",")[1]);
                }
        ));

        Map<String, Integer> map1 = list.stream().collect(Collectors.toConcurrentMap(s -> s.split(",")[0],s -> Integer.parseInt(s.split(",")[1])));
        System.out.println(map);
    }


    /**
     * static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier)：以计算结果作为key值，符合条件的值加入对应集合
     * static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,Collector<? super T, A, D> downstream)：第二个参数指定收集器
     * static <T, K> Collector<T, ?, ConcurrentMap<K, List\<T>>> groupingByConcurrent(Function<? super T, ? extends K> classifier)：在并行时提高分组效率，但是是不保证顺序
     */
    private static void method9() {
        ArrayList<Integer> nums = new ArrayList<>(2);
        for (int i = 1; i <= 10; i++) {
            nums.add(i);
        }
        Map<Boolean, List<Integer>> numMap = nums.stream().collect(Collectors.groupingBy(o -> o % 2 == 0));//以计算结果作为key值，符合条件的值加入对应集合
        Map<Boolean, Set<Integer>> numMap1 = nums.stream().collect(Collectors.groupingBy(o -> o % 2 == 0, Collectors.toSet()));//第二个参数指定收集器
        Map<Boolean, List<Integer>> numMap2 = nums.stream().collect(Collectors.groupingByConcurrent(o -> o % 2 == 0));//在并行时提高分组效率，但是不保证顺序
        System.out.println(numMap);
        System.out.println("---------------------");
        Map<Boolean, List<Integer>> numPartition = nums.stream().collect(Collectors.partitioningBy(o -> o % 2 == 0));
        Map<Boolean, Set<Integer>> numPartition2 = nums.stream().collect(Collectors.partitioningBy(o -> o % 2 == 0, Collectors.toSet()));
    }
}
