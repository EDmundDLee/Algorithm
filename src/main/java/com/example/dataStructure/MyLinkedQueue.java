package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description 使用双链表实现队列
 * @date 2024/7/29 10:36
 */
// 队列特点先进先出
public class MyLinkedQueue<E> {
    private MyLinked<E> list = new MyLinked<>();

    public void  push(E e) {
        list.addLast(e);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.getSize();
    }
}
