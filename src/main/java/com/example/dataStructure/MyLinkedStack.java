package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description 使用链表实现栈
 * @date 2024/7/29 10:45
 */
//栈特点 先进后出
public class MyLinkedStack<E> {
    private MyLinked<E> list = new MyLinked<>();

    public void push(E e) {
        list.addLast(e);
    }

    public E pop() {
        return list.removeLast();
    }

    public E peek() {
        return list.getLast();
    }

    public int getSize() {
        return list.getSize();
    }
}
