package helloWorld;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by gaochen on 2018/4/28.
 */
public class Recv {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv)
            throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.142.130");
        factory.setUsername("gaochen");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        //我们即将告诉服务器将队列中的消息传递给我们。
        //由于它会异步推送消息，因此我们以对象的形式提供回调，该消息将缓冲消息，直到我们准备好使用它们。
        //这是一个DefaultConsumer子类的作用
        channel.basicConsume(QUEUE_NAME,true,new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        });
    }
}
