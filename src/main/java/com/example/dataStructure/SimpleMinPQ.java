package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description 二叉堆接口
 * @date 2024/8/4 16:20
 */
public interface SimpleMinPQ {
    // 返回队列中的元素个数
    public int size();

    // 向队列中插入一个元素
    public void push(int x);

    // 返回队列中的最小元素（堆顶元素）
    public int peek();

    // 删除并返回队列中的最小元素（堆顶元素）
    public int pop();

}
