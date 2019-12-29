package com.blue.thrift.java.thread.pool.waitandnotify;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zs on 2017/5/19.
 */
public class ObjectWait {
    private static ObjectWait object = null;
    public Map<String, Object> ObjectMap = new HashMap<String, Object>(5);

    public static ObjectWait getInstanceObject() {
        if (null == object) {
            object = new ObjectWait();
        }
        return object;
    }

    public Object setKey(String key) {
        Object ob = ObjectMap.get(key);
        if (null == ob) {
            ob = new Object();
            ObjectMap.put(key, ob);
        }
        return ob;
    }

    public Object getObject(String key) {
        return ObjectMap.get(key);
    }
}