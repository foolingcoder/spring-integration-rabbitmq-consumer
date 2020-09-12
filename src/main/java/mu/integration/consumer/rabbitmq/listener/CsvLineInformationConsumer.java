package mu.integration.consumer.rabbitmq.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.dto.CsvLineInformation;
import mu.integration.consumer.rabbitmq.service.CsvLineInformationSender;
import mu.integration.consumer.rabbitmq.service.CsvLineValidationService;

/**
 *
 * @author priteela
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class CsvLineInformationConsumer {

    private final CsvLineValidationService csvLineValidationService;
    private final CsvLineInformationSender csvLineInformationSender;
    private final ObjectMapper mapper;

    @StreamListener(Processor.INPUT)
    public void receiveOrder(@Header Message<String> header, @Payload CsvLineInformation csvLineInformation)
            throws JsonProcessingException {

        log.debug("\n\n CsvLine received: {}", mapper.writeValueAsString(csvLineInformation));
        log.debug("\n\n Header received: {}", header);

        //update csv line information
        csvLineInformation = csvLineValidationService.validate(csvLineInformation);

        Message reply = MessageBuilder.withPayload(csvLineInformation)
                .copyHeaders(header.getHeaders())
                .build();

        csvLineInformationSender.send(reply);

    }
}