package com.example.dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/8/2 15:56
 */
public class WeightedDigraph2 implements Graph{
    // 邻接矩阵，matrix[from][to] 存储从节点 from 到节点 to 的边的权重
    // 0 表示没有连接
    private int[][] matrix;

    public WeightedDigraph2(int n) {
        matrix = new int[n][n];
    }



    @Override
    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
    }

    @Override
    public void removeEdgge(int from, int to) {
        matrix[from][to] = 0;
    }

    @Override
    public boolean isConnected(int from, int to) {
        if (matrix[from][to]>0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Edge> neighbors(int v) {
        List<Edge> edges = new ArrayList<>();
        for (int i=0; i<matrix[v].length;i++) {
            if (matrix[v][i]>0) {
                edges.add(new Edge(i,matrix[v][i]));
            }
        }
        return edges;
    }

    @Override
    public int size() {
        return matrix.length;
    }


    public static void main(String[] args) {
        WeightedDigraph2 graph = new WeightedDigraph2(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 0, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.isConnected(0, 1)); // true
        System.out.println(graph.isConnected(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.getTo() + ", wight: " + edge.getWeight());
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

        graph.removeEdgge(0, 1);
        System.out.println(graph.isConnected(0, 1)); // false
    }

}
