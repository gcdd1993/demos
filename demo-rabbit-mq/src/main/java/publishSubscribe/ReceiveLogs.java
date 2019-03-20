package publishSubscribe;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by gaochen on 2018/4/28.
 */
public class ReceiveLogs {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.142.130");
        factory.setUsername("gaochen");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        //在Java客户端中，当我们不向queueDeclare（）提供参数时，我们使用生成的名称创建一个非持久，独占的自动删除队列：
        String queueName = channel.queueDeclare().getQueue();
        //现在我们需要告诉交换所将消息发送到我们的队列。
        //交换和队列之间的关系称为绑定
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
