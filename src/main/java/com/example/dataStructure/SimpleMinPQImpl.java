package com.example.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/8/4 16:22
 */
public class SimpleMinPQImpl implements SimpleMinPQ{

    private HeadNode root;

    private int size;

    class HeadNode {
        private int val;
        private HeadNode left,right,parent;

        public HeadNode(int val) {
            this.val = val;
        }
    }

    public SimpleMinPQImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     *
     *往堆里面插入就是找到最后一个节点然后节点上浮
     * @param x
     */

    @Override
    public void push(int x) {
        HeadNode newNode = new HeadNode(x);
        if (size == 0) {
           root = newNode;
        } else {
            HeadNode parent = getParnetOfNextNode();
            if (parent.left==null) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            newNode.parent = parent;
            heapifyUp(newNode);
        }
        size ++;

    }


    private void heapifyUp(HeadNode node) {
        while (node.parent != null && node.val < node.parent.val) {
            swap(node, node.parent);
            node = node.parent;
        }
    }

    private HeadNode getParnetOfNextNode() {
        Queue<HeadNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            HeadNode parent = queue.poll();
            if (parent.left ==null || parent.right ==null) {
                return parent;
            }
            queue.add(parent.left);
            queue.add(parent.right);
        }
        return null;
    }

    /**
     * 最小堆 的root值是最小值 直接去root.val就可以
     * @return
     */
    @Override
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return root.val;
    }

    /**
     * 弹出最小值 就是把root删除 然后取最后一个node值
     * 把root往下沉
     * @return
     */
    @Override
    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int minVal = root.val;
        if (size==1) {
            root = null;
        } else {
            HeadNode lastNode = getLastNode();
            root.val=lastNode.val;
            removeLastVal(lastNode);
            heapifyDown(root);
        }
        size--;
        return minVal;
    }

    private void heapifyDown(HeadNode root) {
        while (root.left != null) {
            HeadNode smallerChild = root.left;
            if (root.right != null && root.right.val < root.left.val) {
                smallerChild = root.right;
            }
            if (root.val <= smallerChild.val) {
                break;
            }
            swap(root, smallerChild);
            root = smallerChild;
        }
    }

    private void swap(HeadNode node1, HeadNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    private void removeLastVal(HeadNode lastNode) {
        if (lastNode.parent != null) {
            if (lastNode.parent.left == lastNode) {
                lastNode.parent.left = null;
            } else {
                lastNode.parent.right = null;
            }
        }
    }

    private HeadNode getLastNode() {
        Queue<HeadNode> queue = new LinkedList<>();
        queue.add(root);
        HeadNode lastNode = null;
        while (!queue.isEmpty()) {
              lastNode = queue.poll();
            if (lastNode.left != null) {
                queue.add(lastNode.left);
            }
            if (lastNode.right != null) {
                queue.add(lastNode.right);
            }
            
        }
        return lastNode;

    }
}
