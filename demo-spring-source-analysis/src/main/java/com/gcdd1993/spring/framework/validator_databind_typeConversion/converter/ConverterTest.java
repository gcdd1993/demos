package com.gcdd1993.spring.framework.validator_databind_typeConversion.converter;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Arrays;
import java.util.List;

/**
 * @author gaochen
 * @date 2019/3/28
 */
public class ConverterTest {

    @Test
    public void test_typeDescriptor() {
        DefaultConversionService cs = new DefaultConversionService();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> stringList = (List<String>) cs.convert(list,
                TypeDescriptor.forObject(list),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)));
        stringList.forEach(System.out::println);
    }
}
