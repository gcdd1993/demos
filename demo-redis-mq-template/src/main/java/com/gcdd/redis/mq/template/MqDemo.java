package com.gcdd.redis.mq.template;

import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * @author gaochen
 * @date 2019/3/4
 */
@Service
public class MqDemo {

    @Autowired
    private RedissonClient redisson;

    @PostConstruct
    public void publish() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyTask());
            thread.setName("publish " + i);
            thread.start();
            System.out.println("publish " + i + " started...");
        }
    }

    public class MyTask implements Runnable {

        @Override
        public void run() {
            RTopic topic = redisson.getTopic("anyTopic");

            while (true) {
                Random random = new Random();
                MyMessage message = new MyMessage();
                message.setName("小明" + random.nextInt(10));
                message.setAge(random.nextInt(20));
                message.setGender("男");
                long clientsReceivedMessage = topic.publish(message);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
