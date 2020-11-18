package mu.integration.consumer.rabbitmq.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.binder.TransportProcessor;
import mu.integration.consumer.rabbitmq.dto.TransportIntegrationResultVO;

/**
 * Receives a message from topic exchange.
 *
 * @author Priteela
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class TransportIntegrationStatusConsumer {
    private final ObjectMapper mapper;

    @StreamListener(TransportProcessor.INTEGRATION_RESPONSE_INPUT)
    public void processIntegrationResponse(@Header Message<String> header, @Payload TransportIntegrationResultVO transportIntegrationResultVO)
            throws JsonProcessingException {

        log.info("\n\n TransportProcessor received: {}", mapper.writeValueAsString(transportIntegrationResultVO));


    }
}
