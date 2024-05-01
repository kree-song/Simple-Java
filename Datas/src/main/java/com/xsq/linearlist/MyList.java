package com.xsq.linearlist;

/**
 * 通过接口定义一组线性表中的操作
 */
public interface MyList {
    int getSize();//1.返回线性表中元素的个数

    boolean isEmpty();//2.判断线性表是否为空

    void insert(int i, Object e);//3.在线性表的i索引值添加元素额e

    boolean contains(Object e);//4.判断线性表中是否包含元素e

    int indexOf(Object e);//5.返回e的索引值

    Object remove(Object e);//6.删除线性表中第一个与e相同的元素，并返回该元素

    Object remove(int i);//7.删除线性表中索引值为i的元素，并返回该元素

    Object replace(int i, Object e);//8.使用元素e代替线性表中索引值为i的元素，并返回旧的元素

    Object get(int i);//9.返回指定位置（索引值）的元素

    boolean insertBefore(Object p, Object e);//10.在元素p的前面添加元素e

    boolean insertafter(Object p, Object e);//11.在元素p的后面添加元素e
}
