package mu.integration.consumer.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.dto.CsvLineInformation;

/**
 * Builds a message and publishes it to the remote topic using {@link Source} bean
 *
 * @author Priteela
 */
@Slf4j
@Service
public class CsvLineInformationSender {

    @Autowired
    private Source source;

    public void send(Message<String> header, CsvLineInformation updatedCsvLineInformation) {

        Message<CsvLineInformation> reply = MessageBuilder.withPayload(updatedCsvLineInformation)
                .copyHeaders(header.getHeaders())
                .build();

        log.debug("\n\n CsvLine sent: {}", reply);
        this.source.output().send(reply);
    }
}