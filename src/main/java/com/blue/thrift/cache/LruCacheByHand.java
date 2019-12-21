package com.blue.thrift.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhishuai.zhou on 2019/12/19.
 */
public class LruCacheByHand {


    private int maxCapacity;
    /**
     * 头结点存最新数据
     */
    private LruNode head;
    private LruNode tail;
    private HashMap<String, LruNode> cacheMap;

    public LruCacheByHand(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        cacheMap = new HashMap(maxCapacity);
    }


    public void set(String key, Object value) {
        LruNode node = cacheMap.get(key);
        //命中缓存
        if (node != null) {
            //更新缓存值
            node.value = value;
            removeNode(node, false);
        } else {
            /**
             * 缓存不存在，已满
             */
            if (cacheMap.size() >= maxCapacity) {
                removeNode(tail, true);
            }
            node = new LruNode(key, value);
            cacheMap.put(key, node);
        }
        //添加节点为首节点
        setHead(node);
    }


    public Object get(String key) {
        LruNode node = cacheMap.get(key);
        if (node != null) {
            removeNode(node, false);
            //移动命中节点到头部
            setHead(node);
            return node.value;
        }
        return null;
    }


    /**
     * 删除节点
     *
     * @param deleteFromMap 是否删除缓存map中的节点
     */
    private void removeNode(LruNode node, boolean deleteFromMap) {
        if (node.preNode != null) {
            node.preNode.nextNode = node.nextNode;
        } else {
            //删除节点为首节点
            head = node.nextNode;
        }

        if (node.nextNode != null) {
            node.nextNode.preNode = node.preNode;
        } else {
            //删除节点为尾节点
            tail = node.preNode;
        }
        //清除自己的引用
        node.nextNode = null;
        node.preNode = null;

        if (deleteFromMap) {
            cacheMap.remove(node.key);
        }
    }

    /**
     * 将节点添加到表头，注意首节点和尾节点
     */
    private void setHead(LruNode node) {
        if (head != null) {
            head.preNode = node;
            node.nextNode = head;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        LruNode node = head;
        while (node != null) {
            s.append(node.key + "_" + node.value + ",");
            node = node.nextNode;
        }
        return s.toString();
    }


    /**
     * 双向链表节点
     */
    static class LruNode {
        private String key;
        private Object value;
        private LruNode preNode;
        private LruNode nextNode;

        public LruNode(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "_" + value;
        }
    }


    public static void main(String[] aa) {
//        LruCacheByHand cache = new LruCacheByHand(3);
//        cache.set("1", "11");
//        cache.set("2", "22");
//        cache.set("3", "33");
//        cache.set("4", "44");
//
//        System.out.println(cache);
//
//        System.out.println(cache.get("3"));
//        cache.set("3", "330");
//        System.out.println(cache.get("3"));
//
//        System.out.println(cache);
//
//        cache.set("5", "55");
//        System.out.println(cache);


        int[] asda = {4, 1, 1, 9, 1};
        System.out.println(dp(asda));

    }


    /**
     * 动态规划，选与不选
     */
    private static int dp(int[] arr) {
        int[] out = new int[arr.length];

        out[0] = arr[0];
        out[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int a = out[i - 2] + arr[i];
            int b = out[i - 1];
            out[i] = Math.max(a, b);
        }
        return out[out.length - 1];
    }

    /**
     * 递归实现
     */
    private static int rec_dp(int arr) {

        Map<String, Object> amp = new ConcurrentHashMap<String, Object>(3);
        amp.put();

        Map<String, Object> hashMap = new HashMap<String, Object>(3);
        hashMap.put();


    }


}
