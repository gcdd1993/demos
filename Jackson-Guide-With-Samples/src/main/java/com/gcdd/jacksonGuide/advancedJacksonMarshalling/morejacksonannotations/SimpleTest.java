package com.gcdd.jacksonGuide.advancedJacksonMarshalling.morejacksonannotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * @author: gaochen
 * Date: 2019/1/25
 */
public class SimpleTest {
    @Test
    public void test1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BeanWithoutIdentityReference bean
                = new BeanWithoutIdentityReference(1, "Bean Without Identity Reference Annotation");
        String jsonString = mapper.writeValueAsString(bean);
        System.out.println(jsonString);
    }
}
