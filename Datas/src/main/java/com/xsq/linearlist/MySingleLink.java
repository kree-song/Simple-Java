package com.xsq.linearlist;

/**
 * 通过单向链表实现线性表
 */
public class MySingleLink implements MyList {
    private Node head;
    private int size;

    //定义一个内部类表示单向链表中的节点
    private class Node {
        Object data;  //保存数据
        Node next;    //下一个节点的引用

        public Node(Object data, Node next) {
            super();
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //在线性表中插入元素
    @Override
    public void insert(int i, Object e) {
        //判断索引值是否越界
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        //创建结点
        Node newNode = new Node(e, null);
        //头节点为null的情况，链表不存在，刚刚添加的结点就是头结点
        if (head == null) {
            head = newNode;
        } else {
            //在0的位置插入结点
            if (i == 0) {
                newNode.next = head;//修改新结点的next域指向原来的头结点
                head = newNode;//刚插入的结点就是头结点
            } else {
                //插入结点，先找到i-1这个结点
                Node pNode = head;
                for (int x = 1; x < i; x++) {
                    pNode = pNode.next;
                }
                //注意，先修改新结点的next指针域，再修改i-1结点的指针域
                newNode.next = pNode.next;
                pNode.next = newNode;
            }
        }
        //元素个数+0
        size++;
    }

    //判断线性表中是否包含指定的元素
    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    //返回元素e在线性表中第一次出现的索引值
    @Override
    public int indexOf(Object e) {
        int i = 0;//保存元素e的索引值
        Node pNode = head;
        while (pNode != null) {
            if (e == null && pNode.data == null) {
                return i;
            } else if (e != null && e.equals(pNode.data)) {
                return i;
            }
            i++;
            pNode = pNode.next;
        }
        return -1;
    }

    //从线性表中删除第一个与e相同的元素
    @Override
    public Object remove(Object e) {
        int index = indexOf(e);
        if (index < 0) {
            return null;
        }
        return remove(index);
    }

    @Override
    public Object remove(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Node pNode = head;
        if (i == 0) {
            head = head.next;
            size--;
            return pNode.data;//返回删除头结点的数据
        }
        //找到i-1的结点
        for (int x = 1; x < i; x++) {
            pNode = pNode.next;
        }
        Object old = pNode.next.data;//保存删除结点的数据
        pNode.next = pNode.next.next;//修改i-1结点的next指针域，指向i+1结点
        size--;
        return old;
    }

    @Override
    public Object replace(int i, Object e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Node pNode = getNode(i);
        Object old = pNode.data;
        pNode.data = e;
        return old;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Node pNode = getNode(i);
        return pNode.data;
    }

    //定义一个方法返回i索引值的元素
    private Node getNode(int i) {
        if (i < 0 || i > size) {
            return null;
        }
        if (i == 0) {
            return head;
        }
        Node pNode = head;
        for (int x = 1; x <= i; x++) {
            pNode = pNode.next;
        }
        return pNode;
    }

    @Override
    public boolean insertBefore(Object p, Object e) {
        int index = indexOf(p);
        if (index == 0) {
            return false;
        }
        insert(index, e);
        return true;
    }

    @Override
    public boolean insertafter(Object p, Object e) {
        int index = indexOf(p);
        if (index == 0) {
            return false;
        }
        insert(index + 1, e);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node pNode = head;
        while (pNode != null) {
            sb.append(pNode.data);
            if (pNode.next != null) {
                sb.append(",");
            }
            pNode = pNode.next;
        }
        sb.append("]");
        return sb.toString();
    }



}
