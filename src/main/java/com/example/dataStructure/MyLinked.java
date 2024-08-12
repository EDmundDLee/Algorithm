package com.example.dataStructure;

import java.util.NoSuchElementException;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/29 08:38
 */
public class MyLinked<E> {
    final private  Node<E> head = new Node<>(null);
    final private  Node<E> tail = new Node<>(null);
    private int size;

    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    public MyLinked () {
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public void addLast (E val) {
        Node<E> x = new Node<>(val);
        Node<E> temp = tail.prev;
        temp.next = x;
        x.prev = temp;
        x.next = tail;
        tail.prev = x;

        size++;
    }


    public void addFirst (E val) {
        Node<E> x = new Node<>(val);
        Node<E> temp = head.next;
        head.next = x;
        x.prev = head;
        x.next = temp;
        temp.prev = x;
        size++;
    }

    public void add(int index,E val) {
        checkPointIndex(index);
        if (index == size) {
            addLast(val);
        }
        Node<E> x = new Node<>(val);
        Node<E> p = getNode(index);
        Node<E> temp = p.prev;
        temp.next = x;
        x.prev = temp;
        p.prev = x;
        x.next =temp;
        size++;

    }

    public E removeFirst () {
        if(size<1) {
            throw new NoSuchElementException();
        }
        Node<E> x = head.next;
        Node<E> temp = x.next;
        temp.prev = head;
        head.next = temp;
        x.prev = null;
        x.next = null;
        size--;
        return x.val;
    }


    public E removeLast () {
        if(size<1) {
            throw new NoSuchElementException();
        }
        Node<E> x = tail.prev;
        Node<E> temp = x.prev;
        temp.next = tail;
        tail.prev = temp;
        x.prev = null;
        x.next = null;
        size--;
        return x.val;
    }

    public E remove (int index) {
        checkElementIndex(index);
        Node<E> x = getNode(index);
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        prev.next = next;
        next.prev = prev;
        x.prev = null;
        x.next = null;
        size--;
        return x.val;
    }

    public E getFirst () {
        if (size<1) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast () {
        if (size<1) {
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }


    public E get(int index) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        return node.val;
    }

    public E set (int index,E val) {
        checkElementIndex(index);
        Node<E> temp = getNode(index);
        E oldVal = temp.val;
        temp.val = val;
        return oldVal;
    }


    public Node<E> getNode(int index) {
        //从head节点开始遍历
        Node<E> p = head.next;
        for (int i=0; i<index;i++) {
            p =p.next;
        }
        return p;
    }

    public int getSize() {
        return size;
    }

    private void checkPointIndex(int index) {
        if (!isCheckPointIndex(index)) {
            throw new IndexOutOfBoundsException("size:"+size+";index:"+index);
        }

    }

    private void checkElementIndex(int index) {
        if (!isCheckElementIndex(index)) {
            throw new IndexOutOfBoundsException("size:"+size+";index:"+index);
        }

    }

    private boolean isCheckPointIndex(int index) {
        return index>=0 && index<=size;
    }

    private boolean isCheckElementIndex(int index) {
        return index>=0 && index<size;
    }



}
