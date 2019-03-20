package com.gaochen.java8NewFeature.collectionAPIImprovements;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: gaochen
 * Date: 2019/1/12
 */
public class Test5 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        //key存在，使用函数替换原来的value
        map.compute("1", (k, v) -> v + " computed");
        System.out.println("key存在" + map.get("1"));
        //key不存在
        map.compute("6", (k, v) -> "F");
        System.out.println("key不存在" + map.get("6"));
        //key存在，设置为null
        map.compute("1", (k, v) -> null);
        System.out.println("key存在，设置为null " + map.get("1"));
    }
}
