package mu.integration.consumer.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.entity.CsvLineInformation;

@Slf4j
@Service
public class CsvLineInformationSender {

    @Autowired
    private Source source;

    public void send(CsvLineInformation csvLineInformation) {
        Message message = MessageBuilder.withPayload(csvLineInformation).build();
        log.info("\n\nCsvLine sent: {}", message);
        this.source.output().send(MessageBuilder.withPayload(csvLineInformation).build());
    }


}