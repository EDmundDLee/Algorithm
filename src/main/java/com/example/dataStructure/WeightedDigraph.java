package com.example.dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lijiaxu
 * @Description 有向加权图 临接表实现
 * @date 2024/8/2 15:22
 */
public class WeightedDigraph implements Graph{


    private List<Edge>[] graph;

    public WeightedDigraph(int n) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        List<Edge> edges = graph[from];
        Edge edge = new Edge(to,weight);
        edges.add(edge);
    }

    @Override
    public void removeEdgge(int from, int to) {
        List<Edge> edges = graph[from];

        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getTo()==to) {
                edges.remove(i);
                break;
            }

        }
    }

    @Override
    public boolean isConnected(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.getTo()==to) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Edge> neighbors(int v) {
        return graph[v];
    }

    @Override
    public int size() {
        int size = 0;
        for (List<Edge> edges: graph) {
            size += edges.size();
        }
        return size;
    }

    public void traverse(Graph graph,int s, boolean [] visited) {
        if (graph==null) {
            return;
        }

        if (visited[s]) {
            return;
        }

        visited[s] = true;
        for (Edge e: graph.neighbors(s)) {
            traverse(graph,e.getTo(),visited);
        }
    }






    public static void main(String[] args) {
        WeightedDigraph graph = new WeightedDigraph(3);

        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.isConnected(0, 1)); // true
        System.out.println(graph.isConnected(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.getTo() + ", wight: " + edge.getWeight());
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

//        graph.removeEdgge(0, 1);
        System.out.println(graph.isConnected(0, 1)); // false

        boolean [] visited = new boolean[graph.size()];
        graph.traverse(graph,0,visited);


    }

}
