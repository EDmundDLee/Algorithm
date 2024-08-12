package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/8/2 15:19
 */
public class Edge {

    private int to;

    private int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}
