package com.example.dataStructure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/30 14:32
 */
public class MyLinearProbingHashMap2<K,V> {
    private static class KVNode<K,V> {
        K key;
        V value;
        KVNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private final KVNode<K,V> DUMMY = new KVNode<>(null, null);

    private int size;

    private KVNode<K,V>[] table;

    private static final int INITIAL_CAPACITY = 4;

    public MyLinearProbingHashMap2() {
        this(INITIAL_CAPACITY);
    }

    public MyLinearProbingHashMap2(int capacity) {
        table = new KVNode[capacity];
        this.size = 0;
    }

    //基础接口
    public int size() {
        return size;
    }

    public void put(K key, V value) {
        if (key==null) {
            throw new IllegalArgumentException("key is null");
        }
        if (size> table.length*0.75) {
            resize(2*table.length);
        }
        int index =getKeyIndex(key);
        if (index !=-1) {
            // key 已存在，修改对应的 val
            table[index].value = value;
            return;
        }

        KVNode<K, V> x = new KVNode<>(key, value);
        int h = hash(key);
        while (table[h]!=null&&table[h]!=DUMMY) {
            h = (h+1)% table.length;
        }
        table[h] = x;
        size++;

    }



    public void remove(K key) {
        if (key==null) {
            throw new IllegalArgumentException("key is null");
        }
        // 缩容
        if (size < table.length / 8) {
            resize(table.length / 2);
        }

        int index = getKeyIndex(key);
        if (index==-1) {
            return;
        }

        // 开始 remove
        // 直接用占位符表示删除
        table[index] = DUMMY;
        size--;


    }

    public V get(K key) {
        if (key==null) {
            throw new IllegalArgumentException("key is null");
        }
        int index = getKeyIndex(key);

        if (index==-1) {
            return null;
        }

        KVNode<K, V> x = table[index];
        return x.value;
    }

    private int getKeyIndex(K key) {
        int step = 0;
        int index;
        for (index = hash(key);table[index]!=null;index = (index+1)% table.length) {
            KVNode<K, V> kvkvNode = table[index];
            if (kvkvNode ==DUMMY) {
                continue;
            }

            if (kvkvNode.key.equals(key)) {
                return index;
            }
            step++;
            if (step == table.length) {
                //触发一次resize清除占位符
                resize(table.length);
                return -1;
            }
        }
        return -1;
    }

    public int hash(K key) {
        int h = key.hashCode();
        return (h&0x7fffffff)%table.length;
    }

    public List<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (KVNode<K, V> entry : table) {
            if (entry != null) {
                keys.addLast(entry.key);
            }
        }
        return keys;
    }



    private void resize(int newCapacity) {
        MyLinearProbingHashMap2 newMap = new MyLinearProbingHashMap2(newCapacity);
        for (KVNode<K,V> node : table) {
            if (node!=null && node!=DUMMY) {
                newMap.put(node.key, node.value);
            }
        }
        table = newMap.table;
    }

    public static void main(String[] args) {
        MyLinearProbingHashMap2<Integer, Integer> map = new MyLinearProbingHashMap2<>();
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
