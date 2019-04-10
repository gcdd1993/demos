package com.gcdd1993.spring.framework.validator_databind_typeConversion.validator;

import com.gcdd1993.spring.framework.base.domain.Person;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class ValidatorTest {
    @Test
    public void test_ConfigureDataBind() {
        Person target = new Person();
        DataBinder binder = new DataBinder(target);
        binder.setValidator(new PersonValidator());

        List<PropertyValue> propertyValues = new ArrayList<>();
        propertyValues.add(new PropertyValue("name", ""));
        propertyValues.add(new PropertyValue("age", 20));
        binder.bind(new MutablePropertyValues(propertyValues));

        binder.validate();
        BindingResult results = binder.getBindingResult();
        System.out.println(results);
    }
}
