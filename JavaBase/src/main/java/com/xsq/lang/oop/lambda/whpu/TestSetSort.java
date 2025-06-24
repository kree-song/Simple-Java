package com.xsq.lang.oop.lambda.whpu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSetSort {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("zhangsan", "lisi", "wangwu");
        //1.使用集合
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        //2.使用lamda表达式
        //第一种方式：
        Collections.sort(stringList, (String a, String b) -> {
            return b.compareTo(a);
        });
        //第二种方式：
        Collections.sort(stringList, (String a, String b) -> b.compareTo(a));
        // stringList.sort(Comparator.reverseOrder());//运用比较器

        for (String a : stringList) {
            System.out.print(a + " ");
        }
    }
    //0.准备一个List<User> listUser=new ArrayList<User>();
    //1.ResultSet,遍历这个结果集，每一条记录有userName、passWord
    //1.1以“userName”为key,从每一个结果集的记录中获取用户名
    //1.2以“passWord”为key,从每一个结果集的记录中获取密码
    //1.3构建一个User对象，调用该对象的setter方法，将1.1、1.2中获取的用户名和密码放到这个对象中
    //1.4将1.3中的对象放入第零步的listUser中(listUser.add(user))
    //2.return listUser


}
