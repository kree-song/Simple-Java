package com.xsq.collections.collection.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class testCollection02 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.add("d");
        collection.add("e");
        Iterator<String> it = collection.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
