package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description 用环形数组实现队列
 * @date 2024/7/26 16:15
 */
public class MyArrayQueue<E> {
    private CycleArray<E> data;

    public MyArrayQueue() {
        data = new CycleArray<>();
    }

    public void push(E element) {
        data.addLast(element);
    }

    public E pop() {
        return data.removeFirst();
    }

    public E peek() {
        return data.getFirst();
    }

    public int size() {
        return data.getSize();
    }
}
