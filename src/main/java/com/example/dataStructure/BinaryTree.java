package com.example.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lijiaxu
 * @Description 二叉树
 * @date 2024/8/1 15:42
 */
public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public static class TreeNode {
        int val;
        TreeNode left,right;

        TreeNode(int value) {
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }

    public void traverse(TreeNode root) {
        if (root ==null) {
            return;
        }

        traverse(root.left);

        traverse(root.right);
    }

    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);

        if (root ==null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (value <current.val) {
                    current = current.left;
                    if(current==null) {
                        parent.left =newNode;
                        return;
                    }
                } else {

                    current = current.right;
                    if (current==null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void perOrderTraversal(TreeNode root) {
        if (root ==null) {
            return;
        }
        System.out.println(root.val);
        perOrderTraversal(root.left);

        perOrderTraversal(root.right);
    }


    public void inOrderTraversal(TreeNode root) {
        if (root ==null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }


    public void postOrderTraversal(TreeNode root) {
        if (root ==null) {
            return;
        }

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);

        System.out.println(root.val);
    }
    //层序遍历

    public void sequenceOrderTraversal(TreeNode root) {
        if (root ==null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            System.out.println(cur.val);

            if (cur.left!=null) {
                queue.add(cur.left);
            }


            if (cur.right!=null) {
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(7);
        binaryTree.insert(5);
        binaryTree.insert(20);
        binaryTree.insert(9);
        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(1);
        binaryTree.insert(55);

        binaryTree.sequenceOrderTraversal(binaryTree.root);
    }


}
