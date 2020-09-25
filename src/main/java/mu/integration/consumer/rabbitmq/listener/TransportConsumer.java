package mu.integration.consumer.rabbitmq.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.dto.TransportIntegrationVO;
import mu.integration.consumer.rabbitmq.service.TransportIntegrationSender;
import mu.integration.consumer.rabbitmq.service.TransportIntegrationService;

/**
 * Receives a message from topic exchange.
 *
 * @author Priteela
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class TransportConsumer {

    private final TransportIntegrationService transportIntegrationService;
    private final TransportIntegrationSender transportIntegrationSender;
    private final ObjectMapper mapper;

    @StreamListener(Sink.INPUT)
    public void receiveOrder(@Header Message<String> header, @Payload TransportIntegrationVO transportIntegrationVO)
            throws JsonProcessingException {

        log.info("\n\n payload received: {}", mapper.writeValueAsString(transportIntegrationVO));

        //update csv line information
        TransportIntegrationVO updatedTransportIntegrationVO = transportIntegrationService.validate(transportIntegrationVO);

        transportIntegrationSender.send(header, updatedTransportIntegrationVO);

    }
}
