package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description 图遍历框架
 * @date 2024/8/2 16:50
 */
public class DigraphTraverse {

    public static class Vertex {
        private int id;
        private Vertex[] neighbors;
    }



    boolean [] visited;

    public void traverse(Vertex vertex) {
        if (vertex==null) {
            return;
        }

        if (visited[vertex.id]) {
            return;
        }

        visited[vertex.id] = true;

        System.out.println("visit:"+ vertex.id);

        for (Vertex neighbor : vertex.neighbors) {
            traverse(neighbor);
        }
    }

}
