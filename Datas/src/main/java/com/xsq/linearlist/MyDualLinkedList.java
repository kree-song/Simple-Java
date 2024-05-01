package com.xsq.linearlist;

/**
 * 通过双向链表实现线性表
 */
public class MyDualLinkedList implements MyList {
    private Node first;
    private Node last;
    private int size;

    //定义一个内部类描述双向链表的结点
    private class Node {
        Object data;
        Node prev;
        Node next;

        public Node(Object data, Node prev, Node next) {
            super();
            this.data = data;
            this.prev = prev;
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

    @Override
    public void insert(int i, Object e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            //找到i结点，在i结点的前面插入元素
            Node pNode = getNode(i);
            Node prevNode = pNode.prev;
            //生成新的结点
            Node newNode = new Node(e, prevNode, pNode);
            //修改前驱结点的后续
            prevNode.next = newNode;
            pNode.prev = newNode;
            size++;
        }
    }

    //返回指定索引值的结点
    private Node getNode(int i) {
        Node pNode = first;
        for (int x = 0; x < i; x++) {
            pNode = pNode.next;
        }
        return pNode;
    }


    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    @Override
    public int indexOf(Object e) {
        int i = 0;//保存元素e在链表中的索引值
        //依次遍历链表中的各个结点，比较结点的元素与指定的e是否相同
        if (e == null) {
            for (Node pNode = first; pNode != null; pNode = pNode.next) {
                if (pNode.data == null) {
                    return i;
                }
                i++;
            }
        } else {
            for (Node pNode = first; pNode != null; pNode = pNode.next) {
                if (e.equals(pNode.data)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

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
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Node pNode = getNode(i);
        Node prevNode = pNode.prev;
        Node nextNode = pNode.next;

        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
        }
        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
        }
        size--;
        return pNode.data;
    }

    //修改指定索引值的元素，把原来的元素返回
    @Override
    public Object replace(int i, Object e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Node pNode = getNode(i);
        Object oldData = pNode.data;
        pNode.data = e;
        return oldData;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Node pNode = getNode(i);
        return pNode.data;
    }

    @Override
    public boolean insertBefore(Object p, Object e) {
        int index = indexOf(p);
        if (index < 0) {
            return false;
        }
        insert(index, e);
        return true;
    }

    @Override
    public boolean insertafter(Object p, Object e) {
        int index = indexOf(p);
        if (index < 0) {
            return false;
        }
        insert(index + 1, e);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node node = first; node != null; node = node.next) {
            sb.append(node.data);
            if (node != last) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    //在头部添加元素e
    public void addFirst(Object e) {
        Node pNode = first;
        //生成一个新的结点
        Node newNode = new Node(e, null, first);
        first = newNode;//修改first指向新的结点
        if (pNode == null) {
            last = newNode;
        } else {
            pNode.prev = newNode;
        }
        size++;
    }

    //在尾部添加元素
    public void addLast(Object e) {
        Node pNode = last;
        Node newNode = new Node(e, last, null);
        if (pNode == null) {
            first = newNode;
        } else {
            pNode.next = newNode;
        }
        last = newNode;
        size++;
    }

    //删除第一个元素，删除头元素
    public Object removeFirst() {
        return remove(0);
    }

    //删除最后一个元素(尾元素)
    public Object removeLast() {
        return remove(size - 1);
    }

    //返回头元素
    public Object getFirst() {
        return get(0);
    }

    //返回尾元素
    public Object getLast() {
        return get(size - 1);
    }

}
