package com.gaochen.java8NewFeature.collectionAPIImprovements;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author: gaochen
 * Date: 2019/1/12
 */
public class Test4 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        //replaceAll方法
        map.replaceAll((s, s2) -> s + s2);
        System.out.println(map);
    }
}
