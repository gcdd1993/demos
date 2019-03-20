package com.gaochen.java8NewFeature.collectionAPIImprovements;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: gaochen
 * Date: 2019/1/12
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Iterator<Integer> iterator = list.iterator();
        //创建一个消费者
        Consumer<Integer> consumer = i -> System.out.println("consumer print " + i);
        //iterator的forEachRemaining将集合中的每个元素消费
        iterator.forEachRemaining(consumer);
    }
}
