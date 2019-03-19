package topicExchange;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import util.ConnectionFactoryUtils;

/**
 * Created by gaochen on 2018/4/28.
 * 我们没有使用只有虚拟广播的扇出交换，而是使用了直接交换，并获得了选择性接收日志的可能性。
 * 尽管使用直接交换改进了我们的系统，但它仍然有局限性 - 它不能根据多个标准进行路由。
 *
 * 话题交换
 * 发送到话题交换的消息不能有任意的routing_key - 它必须是由点分隔的单词列表。
 *
 * 绑定键也必须是相同的形式。
 * 话题交换背后的逻辑类似于直接话题 - 使用特定路由键发送的消息将被传递到与匹配绑定键绑定的所有队列。
 * 但是绑定键有两个重要的特殊情况：
 * *（星号）可以代替一个字。
 * ＃（散列）可以替代零个或多个单词。
 */
public class EmitLogTopic {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) {
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = ConnectionFactoryUtils.getInstance();

            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

            String routingKey = getRouting(argv);
            String message = getMessage(argv);

            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

        }
        catch  (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (Exception ignore) {}
            }
        }
    }

    private static String getRouting(String[] strings){
        if (strings.length < 1)
            return "anonymous.info";
        return strings[0];
    }

    private static String getMessage(String[] strings){
        if (strings.length < 2)
            return "Hello World!";
        return joinStrings(strings, " ", 1);
    }

    private static String joinStrings(String[] strings, String delimiter, int startIndex) {
        int length = strings.length;
        if (length == 0 ) return "";
        if (length < startIndex ) return "";
        StringBuilder words = new StringBuilder(strings[startIndex]);
        for (int i = startIndex + 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
