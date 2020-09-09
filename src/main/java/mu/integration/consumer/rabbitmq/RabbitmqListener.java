package mu.integration.consumer.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author priteela
 */
@Component
public class RabbitmqListener {

    private static final String AMQ_CORRELATION_ID = "amqp_correlationId";

    @Autowired
    private LineProcessor lineProcessor;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "myQueue")
    public Message<Result> receive(Message<String> message) {

        System.out.println("\n\n*********** Message Received ***********");
        System.out.println(message);

        String correlationId = (String) message.getHeaders().get(AMQ_CORRELATION_ID);
        Result result = lineProcessor.validate(message.getPayload(), correlationId);

        String jsonInString = "";
        try {
            jsonInString = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        Message reply = MessageBuilder.withPayload(jsonInString)
                .setHeader(MessageHeaders.CONTENT_TYPE, "application/json")
                .setHeader(AMQ_CORRELATION_ID, message.getHeaders().get(AMQ_CORRELATION_ID))
                .build();

        System.out.println("\n\n*********** Reply Sent ***********");
        System.out.println(reply);

        return reply;

    }


}
