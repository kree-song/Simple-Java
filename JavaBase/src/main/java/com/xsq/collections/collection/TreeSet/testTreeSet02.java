package com.xsq.collections.collection.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class testTreeSet02 {
    public static void main(String[] args) {
        TreeSet<Teacher> ts = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                //o1表示现在要存入的那个元素
                //o2表示已经存入到集合中的元素
                int result = o1.getAge() - o2.getAge();
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });
        Teacher t1 = new Teacher("zhangsan", 23);
        Teacher t2 = new Teacher("lisi", 22);
        Teacher t3 = new Teacher("wangwu", 24);
        Teacher t4 = new Teacher("zhaoliu", 23);

        ts.add(t1);
        ts.add(t2);
        ts.add(t3);
        ts.add(t4);
        System.out.println(ts);
    }
}
