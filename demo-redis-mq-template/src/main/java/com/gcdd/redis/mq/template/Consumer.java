package com.gcdd.redis.mq.template;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author gaochen
 * @date 2019/3/4
 */
@Service
public class Consumer {
    @Autowired
    private RedissonClient redisson;

    @PostConstruct
    public void consume() {
        for (int i = 0; i < 2; i++) {
            RTopic topic = redisson.getTopic("anyTopic");
            topic.addListener(MyMessage.class, new MessageListener<MyMessage>() {
                @Override
                public void onMessage(CharSequence channel, MyMessage msg) {
                    System.out.println(Thread.currentThread().getName() + "consume receive message " + msg);
                }
            });
        }
    }

}
