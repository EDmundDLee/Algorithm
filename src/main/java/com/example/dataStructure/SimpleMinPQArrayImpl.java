package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description 最小堆使用数组实现
 * @date 2024/8/9 16:14
 */
public class SimpleMinPQArrayImpl {

    private int [] data;

    private int size;

    public SimpleMinPQArrayImpl(int cap) {
        data = new int [cap+1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    // 某节点的父节点坐标
    public int parentNode(int node) {
        return node/2;
    }

    // 某节点的父节点坐标
    public int leftChild(int node) {
        return 2*node;
    }

    public int rightChild(int node) {
        return 2*node+1;
    }

    public void push(int val) {
        //把值插入到最后
        data[++size] = val;
        //进行上浮操作
        swin(size);
    }

    public int peek() {
        return data[1];
    }

    public int pop() {
        int res = data[1];
        // 把堆底元素放到堆顶
        data[1] = data[size--];
        // 然后下沉到正确位置
        sink(1);
        return res;

    }

    private void sink(int x) {

       while (leftChild(x)<=size||rightChild(x)<=size) {
           int min = x;
           if (data[leftChild(x)] < data[min]) {
                min = leftChild(x);
           }
           if (data[rightChild(x)]<data[min]) {
               min = rightChild(x);
           }
            if (x == min) {
                break;
            }
            swap(x,min);
            x = min;
       }
    }


    public void swin(int x) {
        while (x>1 && data[parentNode(x)]>data[x]) {
            swap(parentNode(x),x);
            x = parentNode(x);
        }
    }

    private void swap(int i,int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


}
