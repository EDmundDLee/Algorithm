package com.example.dataStructure;

import java.util.Collections;
import java.util.List;

/**
 * @author lijiaxu
 * @Description 无向加权图
 * @date 2024/8/2 16:06
 */
public class WeightedUndigraph implements Graph{
    private WeightedDigraph graph;

    public WeightedUndigraph(int n) {
       graph = new WeightedDigraph(n);
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        graph.addEdge(from,to,weight);
        graph.addEdge(to,from,weight);
    }

    @Override
    public void removeEdgge(int from, int to) {
        graph.removeEdgge(from,to);
        graph.removeEdgge(to,from);
    }

    @Override
    public boolean isConnected(int from, int to) {
        return  graph.isConnected(to,from);
    }

    @Override
    public List<Edge> neighbors(int v) {
        return graph.neighbors(v);
    }

    @Override
    public int size() {
        return graph.size();
    }

    public static void main(String[] args) {
        WeightedUndigraph graph = new WeightedUndigraph(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.isConnected(0, 1)); // true
        System.out.println(graph.isConnected(1, 0)); // true

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " <-> " + edge.getTo() + ", wight: " + edge.getWeight());
        });
        // 2 <-> 0, wight: 3
        // 2 <-> 1, wight: 4

        graph.removeEdgge(0, 1);
        System.out.println(graph.isConnected(0, 1)); // false
        System.out.println(graph.isConnected(1, 0)); // false
    }
}
