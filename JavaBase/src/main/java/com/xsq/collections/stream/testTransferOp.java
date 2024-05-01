package com.xsq.collections.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream<T> filter(Predicate predicate)：用于对流中的数据进行过滤
 * <R> Stream<R> map(Function<? super T,? extends  R> mapper) ：对集合中的元素做自定义操作，并保留操作后的元素
 * final <R> Stream<R> flatMap(Function<? super P_OUT, ? extends Stream<? extends R>> mapper)：参数Function的返回值要求是一个Stream，该方法可以将多个Stream中的元素聚合在一起进行返回
 * IntStream mapToInt(ToIntFunction<? super T> mapper)：同map，防止自动装拆箱，节省性能(mapToInt、mapToLong、mapToDouble、flatMapToInt、flatMapToLong、flatMapToDouble)
 * Stream<T> peek(Consumer<? super T> action):可以通过peek方法做些打印元素之类的操作，某些情况下它并不会生效，不建议使用
 *
 * Stream<T> limit(long maxSize)：截取指定参数个数的数据
 * Stream<T> skip(long n)：跳过指定参数个数的数据
 * static <T> Stream<T> concat(Stream a,Stream b)：合并a和b两个流为一个流
 * Stream<T> distinct()：去除流中重复的元素，依赖(hashCode和equals方法)
 */
public class testTransferOp {
    public static void main(String[] args) {
        //method1();
        //method2();
        //method3();
        //method4();
        method5();
        //method6();
    }

    /**
     * Stream<T> filter(Predicate predicate)：用于对流中的数据进行过滤
     *      Predicate中的方法：boolean test(T t)：对给定的参数进行判断
     */
    private static void method1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("张翠山");
        list.add("王二麻子");
        list.add("张良");
        list.add("谢广坤");

        //filter方法获取流中每一个数据，而test方法中的s依次表示流中每一个数据
        //在test中对每一个s进行判断即可,true留false弃

/*        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                boolean result = s.startsWith("张");
                return result;
            }
        }).forEach(s->{
            System.out.println(s);
        });*/

        //Predicate接口中只有一个抽象方法test，所以可以用lambda来优化
/*        list.stream().filter((String s)->{
            boolean result = s.startsWith("张");
            return result;
        }).forEach(s-> System.out.println(s));*/
        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
    }

    /**
     * <R> Stream<R> map(Function<? super T,? extends  R> mapper) ：对集合中的元素做自定义操作，并保留操作后的元素
     */
    private static void method2() {
        Stream.of(1,2,3).map(o -> Math.pow(o, 2)).forEach(System.out::println);
    }

    /**
     * Stream<T> limit(long maxSize)：截取指定参数个数的数据
     * Stream<T> skip(long n)：跳过指定参数个数的数据
     * static <T> Stream<T> concat(Stream a,Stream b)：合并a和b两个流为一个流
     * Stream<T> distinct()：去除流中重复的元素，依赖(hashCode和equals方法)
     */
    private static void method3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("张翠山");
        list.add("王二麻子");
        list.add("张良");
        list.add("谢广坤");
        list.add("谢广坤");
        list.add("谢广坤");

        list.stream().limit(3).forEach(s -> {
            System.out.println(s);
        });
        System.out.println("--------------------------------------");

        list.stream().skip(2).forEach(s -> {
            System.out.println(s);
        });
        System.out.println("----------------------------------------");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("张三丰");
        list2.add("张无忌");
        list2.add("张翠山");
        list2.add("王二麻子");
        list2.add("张良");
        list2.add("谢广坤");
        list2.add("谢广坤");
        list2.add("谢广坤");
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = list2.stream();
        Stream<String> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("---------------------------------------------");

        list.stream().distinct().forEach(s -> {
            System.out.println(s);
        });
    }

    /**
     * final <R> Stream<R> flatMap(Function<? super P_OUT, ? extends Stream<? extends R>> mapper)：参数Function的返回值要求是一个Stream，该方法可以将多个Stream中的元素聚合在一起进行返回
     */
    private static void method4(){
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<List<Integer>> lists = Arrays.asList(list1, list2);
        lists.stream().flatMap(o -> o.stream()).forEach(System.out::println);
    }

    /**
     * IntStream mapToInt(ToIntFunction<? super T> mapper)：同map，防止自动装拆箱，节省性能(mapToInt、mapToLong、mapToDouble、flatMapToInt、flatMapToLong、flatMapToDouble)
     */
    private static void method5(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3).map(o -> o * 2);
        IntStream intStream = Stream.of(1, 2, 3).mapToInt(o -> o * 2);//防止自动装、拆箱，节省性能
    }

    /**
     * Stream<T> peek(Consumer<? super T> action):可以通过peek方法做些打印元素之类的操作，某些情况下它并不会生效，不建议使用
     */
    private static void method6(){
        Stream.of(1, 2, 3).peek(System.out::println);//不执行
        Stream.of(1, 2, 3).peek(System.out::println).count();//执行
        System.out.println("-------");
        List<Integer> list = Stream.of(1, 2, 3).peek(System.out::println).collect(Collectors.toList());//执行
        System.out.println(list);
    }
}
