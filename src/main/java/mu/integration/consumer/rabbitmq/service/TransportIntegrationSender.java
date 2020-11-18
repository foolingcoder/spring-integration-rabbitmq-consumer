package mu.integration.consumer.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.binder.TransportProcessor;
import mu.integration.consumer.rabbitmq.dto.TransportIntegrationVO;

/**
 * Builds a message and publishes it to the remote topic using {@link Source} bean
 *
 * @author Priteela
 */
@Slf4j
@Service
public class TransportIntegrationSender {

    @Autowired
    private TransportProcessor transportProcessor;

    public void send(Message<String> header, TransportIntegrationVO updatedCTransportIntegrationVO) {

        Message<TransportIntegrationVO> reply = MessageBuilder.withPayload(updatedCTransportIntegrationVO)
                .copyHeaders(header.getHeaders())
                .build();

        //log.info("\n\n CsvLine sent: {}", reply);
        this.transportProcessor.flightOutput().send(reply);
    }
}