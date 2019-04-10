package com.gcdd1993.spring.framework.validator_databind_typeConversion.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author gaochen
 * @date 2019/3/28
 */
public class StringToInteger implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }
}
