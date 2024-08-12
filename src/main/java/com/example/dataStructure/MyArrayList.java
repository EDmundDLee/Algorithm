package com.example.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/23 10:07
 */
public class MyArrayList<E> {

    //数组底层的数据结构
    private E[] data;

    //初始化容量
    private static final int initCap = 10;

    //初始化当前元素个数
    private int size = 0;

    public MyArrayList() {
        this(initCap);
    }


    public MyArrayList(int initCap) {
        data = (E[]) new Object[initCap];
        size = 0;
    }

    public void addLast(E e) {
        int cap = data.length;
        if (size == cap) {
            resize(2*cap);
        }
        data[size] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0,e);
    }

    public void add(int index,E e) {
        //检查数组下标是否越界
        checkPostitionIndex(index);

        int cap = data.length;
        if (size == cap) {
            resize(2*cap);
        }

        for (int i = size-1; i>=index ;i--) {
            data [i+1] = data[i];
        }

        data[index] = e;

        size++;
    }

    public E deleteLast() {
        //没有元素
        if(size ==0) {
          throw new NoSuchElementException();
        }

        int cap = data.length;

        if(size ==cap/4) {
            resize(cap/2);
        }
        E deleteVal = data[size-1];
        data[size-1] = null;
        size--;

        return deleteVal;

    }

    public E deleteFirst() {
        return delete(0);
    }

    public E delete (int index) {
        //检查索引是否越界
        checkElementIndex(index);

        int cap = data.length;

        if (size == cap/4) {
            resize(cap/2);
        }
        E deleteVal = data[index];

        for (int i = index+1; i<size;i++) {
            data[i-1] = data[i];
        }
        data[size-1] = null;

        size--;

        return deleteVal;

    }

    public E get(int index) {
        //检查索引越界
        checkElementIndex(index);

        return data[index];
    }

    public E set(int index,E e) {
        //检查是否索引越界
        checkElementIndex(index);

        //修改数据
        E oldval = data[index];

        data[index] = e;

        return oldval;
    }

    //工具方法
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    protected void resize(int newCap) {
        E[] temp = (E []) new Object[newCap];
        for (int i = 0; i <size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private void checkPostitionIndex(int index) {
        if(!isCheckPostitionIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkElementIndex(int index) {
        if(!isCheckElementIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isCheckPostitionIndex(int index) {
        return index>=0 && index <= size;
    }

    private boolean isCheckElementIndex(int index) {
        return index>=0 && index < size;
    }

    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(3);
        for (int i =0; i<=5; i++) {
            arr.addLast(i);
        }
        arr.display();

        arr.delete(3);
        arr.add(1,9);
        arr.addFirst(10);
        arr.deleteLast();
        for (int i =0; i< arr.getSize();i++) {
            System.out.println(arr.get(i));
        }
    }



}
