package com.blue.thrift.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhishuai.zhou on 2019/12/19.
 */
public class LRUCache extends LinkedHashMap {

    private int maxCapacity;

    public LRUCache(int maxCapacity) {
        super(maxCapacity, 0.75f, true);
        this.maxCapacity = maxCapacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxCapacity;
    }


    public static void main(String[] as) {

        LRUCache cache = new LRUCache(5);
        cache.put("1", "11");
        cache.put("2", "22");
        cache.put("3", "33");
        cache.put("4", "44");
        cache.put("5", "55");
        cache.put("6", "66");

        System.out.println(cache.toString());

        System.out.println(cache.get("3"));

        System.out.println(cache.toString());

    }


}
