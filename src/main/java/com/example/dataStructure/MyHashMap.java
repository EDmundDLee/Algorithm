package com.example.dataStructure;

import java.util.HashMap;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/29 14:01
 */
public class MyHashMap implements Map{
    private Object[] data;
    @Override
    public Object get(Object key) {
        int index =hash(key);
        return data[index];
    }

    @Override
    public void put(Object key, Object value) {
        int index = hash(key);
        data[index] = value;
    }

    @Override
    public void remove(Object key) {
        int index = hash(key);
        data[index] = null;
    }

    private int hash(Object key) {
        int i = key.hashCode();
        i = i & 0x7fffffff;
        return i%data.length;
    }

}
