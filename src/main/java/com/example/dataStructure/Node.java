package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/23 16:29
 */
public class Node<E> {
    private E val;

    private Node<E> next;

    private Node<E> prev;


    public Node(E val, Node<E> next, Node<E> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public Node(Object val) {
    }
}
