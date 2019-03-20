package com.gaochen.java8NewFeature.collectionAPIImprovements;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: gaochen
 * Date: 2019/1/12
 */
public class Test6 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        //存在key为1,输出 Amerge
        System.out.println(map.merge("1", "merge", (k, v) -> k + v));
        //新值为null，删除key，输出 null
        System.out.println(map.merge("1", "merge", (k, v) -> null));
        //不存在key为6，输出 "merge"
        System.out.println(map.merge("6", "merge", (k, v) -> k + v));
    }
}
