package com.gaochen.java8NewFeature.collectionAPIImprovements;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author: gaochen
 * Date: 2019/1/12
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Spliterator<Integer> spliterator = list.spliterator();
        //创建顺序流
        Stream<Integer> stream = StreamSupport.stream(spliterator, false);
        //创建并行流
        Stream<Integer> parallelStream = StreamSupport.stream(spliterator, true);
    }
}
