package mu.integration.consumer.rabbitmq.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.entity.CsvLineInformation;
import mu.integration.consumer.rabbitmq.service.CsvLineInformationSender;
import mu.integration.consumer.rabbitmq.service.CsvLineValidationService;

/**
 *
 * @author priteela
 */
@Slf4j
@Component
public class RabbitmqListener {

    private static final String CORRELATION_ID = "correlationId";

    @Autowired
    private CsvLineValidationService csvLineValidationService;

    @Autowired
    private CsvLineInformationSender csvLineInformationSender;

    @Autowired
    private ObjectMapper mapper;

    @StreamListener(Processor.INPUT)
    public void receiveOrder(CsvLineInformation csvLineInformation) throws JsonProcessingException {
        log.info("\n\nCsvLine received: {}", mapper.writeValueAsString(csvLineInformation));

        //update csv line information
        csvLineInformation = csvLineValidationService.validate(csvLineInformation);

        csvLineInformationSender.send(csvLineInformation);

    }
}
