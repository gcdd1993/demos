package com.gcdd1993.spring.framework.validator_databind_typeConversion.bean_wrapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * @author gaochen
 * @date 2019/3/27
 */
public class BeanWrapperTest {

    /**
     * test on {@link org.springframework.beans.BeanWrapper} with
     * {@link Company} and {@link Employee}
     */
    @Test
    public void test_beanWrapper() {
        BeanWrapper company = new BeanWrapperImpl(new Company());
        company.setPropertyValue("name", "Some Company Inc.");
        // or like this
        company.setPropertyValue(new PropertyValue("name", "Some Company Inc."));

        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        jim.setPropertyValue("salary", "1.11f");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        float salary = (float) company.getPropertyValue("managingDirector.salary");

    }
}
