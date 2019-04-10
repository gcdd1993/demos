package com.gcdd1993.spring.framework.spel;

import com.gcdd1993.spring.framework.base.domain.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.GregorianCalendar;

/**
 * @author gaochen
 * @date 2019/3/28
 */
public class SpELTest {

    @Test
    public void test_simpleUsage() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello World'");
        String value = (String) expression.getValue();
        Assert.assertEquals(value, "Hello World");
    }

    @Test
    public void test_concat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello World'.concat('!')");
        String value = (String) expression.getValue();
        Assert.assertEquals(value, "Hello World!");
    }

    @Test
    public void test_bytes() {
        ExpressionParser parser = new SpelExpressionParser();
        // i.e. prop1.prop2
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        Assert.assertEquals("Hello World".getBytes().length, bytes.length);

        // i.e. prop1.prop2.prop3
        exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
        Assert.assertEquals("Hello World".getBytes().length, length);
    }

    @Test
    public void test_method() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        Assert.assertEquals("HELLO WORLD", message);
    }

    @Test
    public void test_otherUsage() {
        Person person = new Person();
        person.setName("xiaowang");
        person.setAge(20);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");
        String name = (String) exp.getValue(person);
        Assert.assertEquals("xiaowang", name);

        exp = parser.parseExpression("name == 'xiaowang'");
        Boolean b = exp.getValue(person, Boolean.class);
        Assert.assertTrue(b);
    }

}
