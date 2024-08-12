package com.example.dataStructure;

import java.util.List;

/**
 * @author lijiaxu
 * @Description 图接口
 * @date 2024/8/2 15:15
 */
public interface Graph {

    //添加一条边
    void addEdge(int from,int to,int weight);

    //删除一条边
    void removeEdgge(int from,int to);

    //判断两个节点是否相邻
    boolean isConnected(int from,int to);

    //返回某个节点所有邻节点和对应权重
    List<Edge> neighbors(int v);

    //返回节点数量
    int size();

}
