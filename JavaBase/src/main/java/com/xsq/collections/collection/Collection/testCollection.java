package com.xsq.collections.collection.Collection;

import java.util.ArrayList;
import java.util.Collection;

public class testCollection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("dddd");
        //boolean removeif(Object o):根据条件进行删除
        //removeif底层会遍历集合，得到集合中每一个元素，然后就会把这每一个元素都到lambda表达式中判断一下，true则删除
        collection.removeIf(
                (String s) -> {
                    return s.length() == 3;
                }
        );
        System.out.println(collection);
    }
}
