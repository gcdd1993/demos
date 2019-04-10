package com.gcdd1993.spring.framework.validator_databind_typeConversion.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author gaochen
 * @date 2019/3/28
 */
@Service
public class MyService {
    @Autowired
    private ConversionService conversionService;

    public Integer doIt() {
        return this.conversionService.convert("1", Integer.class);
    }
}
