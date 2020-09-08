package mu.integration.consumer.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 *
 * @author priteela
 */
@Component
public class RabbitmqListener {


    @RabbitListener(queues = "myQueue")
    @SendTo("foo_response")
    public Message<String> receive(Message<String> message) {

        System.out.println("\n\n*********************");

        System.out.println(message.getHeaders());

        Pojo record = new Pojo();

        String[] array = message.getPayload().split(",");
        record.setCol1(array[0]);
        record.setCol2(array[1]);
        record.setCol3(array[2]);

        System.out.println(record.toString());

        return MessageBuilder.withPayload("Hello")
                .setHeader(MessageHeaders.CONTENT_TYPE, "application/json")
                .build();

    }


    @Bean
    public Queue queue() {
        return new Queue("foo_response", false);
    }

}
