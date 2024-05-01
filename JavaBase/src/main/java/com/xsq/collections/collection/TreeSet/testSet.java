package com.xsq.collections.collection.TreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class testSet {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("ddd");
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------------------------------");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
