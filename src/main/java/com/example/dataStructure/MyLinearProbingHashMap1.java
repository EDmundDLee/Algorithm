package com.example.dataStructure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lijiaxu
 * @Description rehash版本hashmap
 * @date 2024/7/30 11:09
 */
public class MyLinearProbingHashMap1<K,V> {

    private KVNode<K,V>[]  table;

    private int size;

    private static final int INIT_CAP = 4;

    public MyLinearProbingHashMap1() {
        this(INIT_CAP);
    }

    public MyLinearProbingHashMap1(int intialCapacity) {
        table = (KVNode<K, V>[]) new KVNode[intialCapacity];
        this.size = 0;
    }

    private static class KVNode<K,V> {
        private K key;
        private V value;
        public KVNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    //增加/修改
    public void put(K key,V value) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }

        if (size>table.length*0.75) {
            resize(2*table.length);
        }

        int index = getKeyIndex(key);
        //key已存在修改
        if (table[index]!=null) {
            table[index].value = value;
            return;
        }
        //key不存在 空值插入
        table[index] = new KVNode<>(key,value);
        size++;
    }

    //删除
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }

        // 缩容，当负载因子小于 0.125 时，缩容
        if (size <= table.length / 8) {
            resize(table.length / 4);
        }
        int index = getKeyIndex(key);
        if (table[index]==null) {
            // key 不存在，不需要 remove
            return;
        }
        table[index] = null;
        size--;
        // 保持元素连续性，进行 rehash
        index = (index+1)% table.length;
       for (;table[index]!=null;index=(index+1)%table.length) {
           KVNode<K, V> kvkvNode = table[index];
           table[index] = null;
           size--;
           put(kvkvNode.key,kvkvNode.value);
       }
    }

    //查询
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }

        int index = getKeyIndex(key);

        if (table[index] ==null) {
            return null;
        }
        return table[index].value;
    }

    //返回所有的keys
    public List<K> keys() {
        List<K> keys = new LinkedList<>();
        for (KVNode<K, V> kvkvNode : table) {
            if (kvkvNode!=null) {
                keys.add(kvkvNode.key);
            }
        }
        return keys;
    }

    //返回当前数组的大小
    public int size() {
        return size;
    }


    private int getKeyIndex(K key) {
        int index;
        for (index = hash(key);table[index]!=null;index = (index+1)% table.length) {
            if (table[index].key.equals(key)) {
                return index;
            }
        }
        return index;
    }

    public int hash(K key) {
        int h = key.hashCode();
        return (h&0x7fffffff)% table.length;
    }

    private void resize(int newCapacity) {
        MyLinearProbingHashMap1<K, V> newKvNode = new MyLinearProbingHashMap1<>(newCapacity);
        for (KVNode<K, V> kvkvNode : table) {
            if (kvkvNode!=null) {
                newKvNode.put(kvkvNode.key,kvkvNode.value);
            }
        }
        table = newKvNode.table;
    }

    public static void main(String[] args) {
        MyLinearProbingHashMap1<Integer, Integer> map = new MyLinearProbingHashMap1<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(10, 10);
        map.put(20, 20);
        map.put(30, 30);
        map.put(3, 3);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2)); // 2
        System.out.println(map.get(20)); // 20

        map.put(1, 100);
        System.out.println(map.get(1)); // 100

        map.remove(20);
        System.out.println(map.get(20)); // null
        System.out.println(map.get(30)); // 30
    }
}
