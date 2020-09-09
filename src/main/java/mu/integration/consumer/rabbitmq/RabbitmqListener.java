package mu.integration.consumer.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 *
 * @author priteela
 */
@Component
public class RabbitmqListener {

    private static final String AMQ_CORRELATION_ID = "amqp_correlationId";

    @RabbitListener(queues = "myQueue")

    public Message<String> receive(Message<String> message) {

        System.out.println("\n\n*********** Message Received ***********");

        //Call a service class to validate pojo
        Pojo record = new Pojo(message.getPayload());
        System.out.println(record.toString());

        return MessageBuilder.withPayload("PROCESSED: " + message.getHeaders().get(AMQ_CORRELATION_ID))
                .setHeader(MessageHeaders.CONTENT_TYPE, "application/json")
                .build();

    }


}
