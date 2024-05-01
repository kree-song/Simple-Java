package com.xsq.collections.collection.TreeSet;

import java.util.HashSet;
import java.util.Iterator;

public class testHashSet {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("java");
        hs.add("java");
        hs.add("java");
        hs.add("java");

        Iterator<String> iterator = hs.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println("----------------------------------------------------");
        for (String h : hs) {
            System.out.println(h);
        }
    }
}
