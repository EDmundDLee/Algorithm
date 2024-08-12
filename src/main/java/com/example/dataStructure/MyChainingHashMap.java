package com.example.dataStructure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lijiaxu
 * @Description 拉链法实现hashMap
 * @date 2024/7/29 15:37
 */
public class MyChainingHashMap<K ,V> {

    private static class KVNode<K,V> {
        K key;
        V value;

        KVNode(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<KVNode<K,V>>[] table;

    private int size;

    private static final int INIT_CCAP = 4;

    private MyChainingHashMap() {
        this(INIT_CCAP);
    }

    private MyChainingHashMap(int initialCapacity) {
        size = 0;
        initialCapacity = initialCapacity==0?1:initialCapacity;
        table = new LinkedList[initialCapacity];
        for (int i=0; i<table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }


    //增，改
    private void put(K key, V value) {
       if (key ==null) {
           throw new IllegalArgumentException("key is null");
       }
       LinkedList<KVNode<K,V>> list = table[hash(key)];

        for (KVNode<K, V> kvkvNode : list) {
            if(kvkvNode.key.equals(key)) {
                kvkvNode.value =value;
                return;
            }
        }

        list.add(new KVNode<>(key,value));

        size++;

        if(size>=table.length*0.75) {
            resize(2*table.length);
        }

    }
    
    //删除
    private void remove(K key) {
        if(key ==null) {
            throw new IllegalArgumentException("key is null");
        }
        LinkedList<KVNode<K,V>> list = table[hash(key)];
        for (KVNode<K, V> kvkvNode : list) {
            if(kvkvNode.key.equals(key)) {
                list.remove(kvkvNode);
                size--;

                if(size<=table.length/8) {
                    resize(table.length/4);
                }

                return ;
            }
        }

    }

    //查询返回key对应的 value
    private V get(K key) {
        if(key ==null) {
            throw new IllegalArgumentException("key is null");
        }

        LinkedList<KVNode<K,V>> list = table[hash(key)];

        for (KVNode<K, V> kvkvNode : list) {
            if (kvkvNode.key.equals(key)) {
                return kvkvNode.value;
            }
        }

        return null;
    }

    public List<K> keys() {
        List<K> keys = new LinkedList<>();
        for (LinkedList<KVNode<K,V>> kvNodes : table) {
            for (KVNode<K, V> kvNode : kvNodes) {
                keys.add(kvNode.key);
            }
        }
        return keys;
    }





    private int hash(K key) {
        int h = key.hashCode();
        return (h&0x7fffffff)%table.length;
    }

    private void resize(int newCapacity) {
        LinkedList<KVNode<K,V>>[] oldTable = table;
        MyChainingHashMap<K, V> newMap = new MyChainingHashMap<>(newCapacity);
        for (LinkedList<KVNode<K, V>> kvNodes : oldTable) {
            for (KVNode<K, V> kvNode : kvNodes) {
                newMap.put(kvNode.key,kvNode.value);
            }
        }

        table = newMap.table;
    }

}
