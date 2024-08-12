package com.example.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lijiaxu
 * @Description 多插树遍历
 * @date 2024/8/2 10:21
 */
public class MultiwayTree {

    private Node root;

    private List<Integer> preOrder = new ArrayList<>();

    private List<Integer> postOrder = new ArrayList<>();


    private List<Integer> sequenceOrder = new ArrayList<>();

    public MultiwayTree(Node root) {
        this.root = root;
    }

    public static class Node{
        public int value;
        public List<Node> children;

        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public void addChildern(Node node) {
            if (node != null) {
                this.children.add(node);
            }
        }

        public void insert(int value) {
            Node node = new Node(value);

        }
    }


    public void traverse(Node root) {
        if (root == null) {
            return;
        }
        this.preOrder.add(root.value);
        for (Node child : root.children) {
            traverse(child);
        }
        this.postOrder.add(root.value);

    }

    //层序遍历
    public void  sequenceTraverse(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();
            sequenceOrder.add(poll.value);
            for (Node child : poll.children) {
                nodes.add(child);
            }

        }
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        Node children1 = new Node(3);
        Node children2 = new Node(8);
        Node children3 = new Node(15);
        Node children1_1 = new Node(1);
        Node children1_2 = new Node(2);
        Node children1_3 = new Node(4);
        Node children2_1 = new Node(7);
        Node children2_2 = new Node(9);
        Node children3_1 = new Node(1);
        root.addChildern(children1);
        root.addChildern(children2);
        root.addChildern(children3);
        children1.addChildern(children1_1);
        children1.addChildern(children1_2);
        children1.addChildern(children1_3);
        children2.addChildern(children2_1);
        children2.addChildern(children2_2);
        children3.addChildern(children3_1);
        MultiwayTree multiwayTree = new MultiwayTree(root);
        multiwayTree.traverse(root);
        System.out.println(multiwayTree.preOrder);
        System.out.println(multiwayTree.postOrder);


        multiwayTree.sequenceTraverse(root);
        System.out.println(multiwayTree.sequenceOrder);

    }


}
