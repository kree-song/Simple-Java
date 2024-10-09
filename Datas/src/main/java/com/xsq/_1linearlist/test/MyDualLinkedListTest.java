package com.xsq._1linearlist.test;

import com.xsq._1linearlist.MyDualLinkedList;

public class MyDualLinkedListTest {
    public static void main(String[] args) {
        MyDualLinkedList linkedList = new MyDualLinkedList();

        System.out.println(linkedList.getSize());
        System.out.println(linkedList.isEmpty());

        linkedList.insert(0, "gg");
        linkedList.insert(0, "jj");
        linkedList.insert(1, "dd");
        linkedList.insert(3, "mm");
        System.out.println(linkedList);//[jj,dd,gg,mm]

        System.out.println(linkedList.indexOf("jj"));
        System.out.println(linkedList.indexOf("DD"));
        System.out.println(linkedList.contains("xx"));
        System.out.println(linkedList.contains("gg"));

        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);
        System.out.println(linkedList.remove("mm"));
        System.out.println(linkedList);

        linkedList.replace(0, "xx");
        System.out.println(linkedList.get(1));
        System.out.println(linkedList);//[xx,gg]
        linkedList.insertBefore("xx", "yy");
        linkedList.insertafter("xx", "oo");
        System.out.println(linkedList);//[yy,xx,oo,gg]

        linkedList.addFirst("TT");
        linkedList.addLast("MM");
        System.out.println(linkedList);//[TT,yy,xx,oo,gg,MM]
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);//[yy,xx,oo,gg]

    }

}
