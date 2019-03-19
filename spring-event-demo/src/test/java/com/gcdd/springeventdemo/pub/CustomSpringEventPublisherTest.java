package com.gcdd.springeventdemo.pub;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gaochen
 * @date 2019/3/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomSpringEventPublisherTest {

    @Autowired
    private StringGenericSpringEventPublisher publisher;

    @Test
    public void publishStringEventTest() {
        publisher.doStuffAndPublishAnEvent("success", true);
        publisher.doStuffAndPublishAnEvent("failed", false);
    }
}