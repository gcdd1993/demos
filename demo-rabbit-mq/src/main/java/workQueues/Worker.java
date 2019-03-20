package workQueues;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by gaochen on 2018/4/28.
 */
public class Worker {
    private final static String QUEUE_NAME = "task_queue";

    public static void main(String[] argv)
            throws IOException,
            InterruptedException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.142.130");
        factory.setUsername("gaochen");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //当RabbitMQ退出或崩溃时，它会忘记队列和消息，除非您告诉它不要。
        //需要做两件事来确保消息不会丢失：我们需要将队列和消息标记为持久。
        //首先，我们需要确保RabbitMQ永远不会失去我们的队列。
        //为了做到这一点，我们需要宣布它是持久的：
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        //我们即将告诉服务器将队列中的消息传递给我们。
        //由于它会异步推送消息，因此我们以对象的形式提供回调，该消息将缓冲消息，直到我们准备好使用它们。
        //这是一个DefaultConsumer子类的作用
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        boolean autoAck = false; // acknowledgment is covered below
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }

    private static void doWork(String task) {
        for (char ch: task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
