package com.example.dataStructure;

import java.util.NoSuchElementException;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/26 10:47
 */
public class CycleArray<T> {

    private T[] array;

    private int size;

    private int start;

    private int end;

    private int count;

    public  CycleArray() {
        this(1);
    }

    public CycleArray(int size) {
        array = (T[]) new Object[size];
        this.size = size;
        start = 0;
        end = 0;
        count = 0;
    }

    public void addFirst(T data) {
        if (isFull()) {
            resize(2*size);
        }
        start = (start-1+size)%size;
        array[start] = data;
        count++;
    }

    public void addLast(T data) {
        if (isFull()) {
            resize(2*size);
        }
        array[end] = data;
        end = (end+1)%size;
        count++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw  new IllegalStateException("Array is empty");
        }
        T result = array[start];
        array[start] = null;
        start = (start+1)%size;
        count--;

        //判断是否需要所容
        if(count>0&&count<size/4) {
            resize(size/2);
        }
        return result;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw  new IllegalStateException("Array is empty");
        }
        end = (end-1+size)%size;
        array[end] = null;
        count--;
        //判断是否需要所容
        if(count>0&&count<size/4) {
            resize(size/2);
        }

    }

    // 获取数组头部元素，时间复杂度 O(1)
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return array[start];
    }

    // 获取数组尾部元素，时间复杂度 O(1)
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // end 是开区间，指向的是下一个元素的位置，所以要减 1
        return array[(end - 1 + size) % size];
    }

    //删除任意元素

    public T delete(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
       if(index<0||index>=size) {
           throw  new ArrayIndexOutOfBoundsException("数组下标越界");
       }
       T result = array[(start+index)%size];
       for (int i =index; i <size-1; i++) {
           array[(start+i)%size] = array[(start+i+1)%size];
       }
       array[end] = null;
       end = (end-1+size)%size;
       count--;
       return  result;

    }



    private boolean isFull(){
        return  count == size;
    }

    private boolean isEmpty(){
        return  count == 0;
    }

    private void resize(int newSize){
        T[] newArray = (T[]) new Object[newSize];
        for (int i=0; i<count; i++) {
            newArray[i] = array[(start+i)%size];
        }
        array = newArray;
        start =0;
        end = count;
        size = newSize;
    }

    public int getSize() {
        return count;
    }

    public static void main(String[] args) {
        CycleArray<Integer> integerCycleArray = new CycleArray<>(5);
        integerCycleArray.addFirst(1);
        integerCycleArray.addFirst(5);
        integerCycleArray.addLast(3);
        integerCycleArray.addLast(10);
        Integer delete = integerCycleArray.delete(3);
        System.out.println(delete);
        System.out.println(integerCycleArray);
    }
}
