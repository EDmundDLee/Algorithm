package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/29 14:00
 */
public interface Map<K,V> {

     V get(K key);

    void put(K key,V value);

    void remove(K key);
}
