package com.example.dataStructure;

import java.util.ArrayList;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/26 15:39
 */
public class MyArrayStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    //向栈顶加入元素
    public void push(E val) {
        list.add(val);
    }

    //从栈顶弹出元素

    public E pop() {
        return list.remove(list.size()-1);
    }

    //查看栈顶元素
    public E peel() {
        return list.get(list.size()-1);
    }

    //返回栈内元素
    public int size() {
        return list.size();
    }
}
