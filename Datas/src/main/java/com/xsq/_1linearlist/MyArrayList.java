package com.xsq._1linearlist;

/**
 * 通过数组实现线性表
 */
public class MyArrayList implements MyList {
    private static final int DEFAULT_CAPACITY = 16;//数组的默认初始化容量
    private Object[] elements;//定义数组保存数据元素
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];//默认数组容量
    }

    public MyArrayList(int initialCapacity) { //由参数指定数组容量
        elements = new Object[initialCapacity];
    }


    /**
     * 1.返回元素的个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 2.判断线性表是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 3.增加元素
     * @param i
     * @param e
     */
    @Override
    public void insert(int i, Object e) {
        //判断索引值i是否越界
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        //若数组已满，对数组扩容
        if (size > elements.length) {
            expandSpace();
        }
        //从i开始把元素e依次后移
        for (int j = size; j > i; j--) {
            elements[j] = elements[j - 1];
        }
        //把元素e存储到i位置
        elements[i] = e;
        //元素的个数+1
        size++;
    }

    /**
     * 数组扩容
     */
    private void expandSpace() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 4.判断当前线性表中是否包含元素e
     * @param e
     * @return
     */
    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    /**
     * 5.返回元素e第一次在线性表中出现的索引值，如果不存在返回-1
     * @param e
     * @return
     */
    @Override
    public int indexOf(Object e) {
        if (e == null) {
            //线性表中用户可能添加null
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 6.在线性表中删除第一个与e相同的元素
     * @param e
     * @return
     */
    @Override
    public Object remove(Object e) {
        //获得e在线性表中的索引值
        int index = indexOf(e);
        if (index < 0) {
            return null;
        }
        return remove(index);
    }

    /**
     * 7.删除指定索引值的元素
     * @param i
     * @return
     */
    @Override
    public Object remove(int i) {
        //判断i是否越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        //把要删除的元素保存起来
        Object old = elements[i];
        //把i+1开始的元素依次前移
        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        //把最后的元素置为null
        elements[size - 1] = null;
        //修改元素的个数
        size--;
        //把删除的元素返回
        return old;
    }

    /**
     * 8.把索引值为i的元素替换为e
     * @param i
     * @param e
     * @return
     */
    @Override
    public Object replace(int i, Object e) {
        //判断索引值是否越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Object old = elements[i];//保存原来的值
        //替换
        elements[i] = e;
        //返回原来的元素值
        return old;
    }

    /**
     * 9.返回指定位置（索引值）的元素
     * @param i
     * @return
     */
    @Override
    public Object get(int i) {
        // 判断索引值是否越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        return elements[i];
    }

    /**
     * 10.在指定元素前插入一个元素
     * @param p
     * @param e
     * @return
     */
    @Override
    public boolean insertBefore(Object p, Object e) {
        //确定元素p在线性表中的位置
        int index = indexOf(p);
        if (index < 0) {
            return false;//p元素不存在，插入不成功
        }
        //插入元素
        insert(index, e);
        return true;
    }

    /**
     * 11.在指定元素后插入一个元素
     * @param p
     * @param e
     * @return
     */
    @Override
    public boolean insertafter(Object p, Object e) {
        //确定元素p在线性表中的位置
        int index = indexOf(p);
        if (index < 0) {
            return false;//p元素不存在，插入不成功
        }
        //插入元素
        insert(index + 1, e);
        return true;
    }

    @Override
    public String toString() {
        //把线性表中的每个元素连接起来，遍历数组中已添加的元素
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
