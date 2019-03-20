package com.gaochen.java8NewFeature.javaIOImprovements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

/**
 * @author: gaochen
 * Date: 2019/1/13
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        //返回目录下的元素集合流
        Stream<Path> list = Files.list(new File("C:\\Users\\Administrator\\Desktop").toPath());
        list.forEach(System.out::println);

        //返回文件中的所有行数
        Stream<String> lines = Files.lines(new File("C:\\Users\\Administrator\\Desktop\\new 3.txt").toPath());
        lines.forEach(System.out::println);

        //返回符合判断条件的Path流
        Stream<Path> stream = Files.find(new File("C:\\Users\\Administrator\\Desktop").toPath(),
                1,
                (path, basicFileAttributes) -> basicFileAttributes.isDirectory());
        stream.forEach(System.out::println);

        //返回文件中的所有行数,类似Files.lines()
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\new 3.txt"));
        Stream<String> stringStream = br.lines();
        stringStream.forEach(System.out::println);
    }
}
