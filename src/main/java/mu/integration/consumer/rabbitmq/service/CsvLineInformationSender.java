package mu.integration.consumer.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CsvLineInformationSender {

    @Autowired
    private Source source;

    public void send(Message message) {
        log.debug("\n\n CsvLine sent: {}", message);
        this.source.output().send(message);
    }
}