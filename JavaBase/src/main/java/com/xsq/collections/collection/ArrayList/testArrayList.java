package com.xsq.collections.collection.ArrayList;

import java.util.ArrayList;
import java.util.stream.Stream;

public class testArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ddd");
        arrayList.add("ccc");
        arrayList.add("cee");
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println(arrayList);
        arrayList.set(0, "111");
        String s = arrayList.get(0);
        System.out.println(s);
        int size = arrayList.size();
        System.out.println(size);
        System.out.println(arrayList);
        arrayList.forEach(a -> System.out.println(a));
        System.out.println("------------------------------------------------");
        Stream<String> stream = arrayList.stream();
        Stream<String> c = stream.filter(m -> m.startsWith("c"));
        c.forEach(a -> {
            System.out.println(a);
        });
    }
}
