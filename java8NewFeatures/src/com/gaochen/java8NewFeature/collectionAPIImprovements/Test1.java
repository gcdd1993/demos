package com.gaochen.java8NewFeature.collectionAPIImprovements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: gaochen
 * Date: 2019/1/12
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Predicate<Integer> predicate = i -> i > 1;
        list.removeIf(predicate);
        System.out.println("remove if left items : " + list);
    }
}
