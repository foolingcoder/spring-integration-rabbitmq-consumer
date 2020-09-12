package mu.integration.consumer.rabbitmq.service;

import mu.integration.consumer.rabbitmq.dto.CsvLineInformation;

/**
 *
 * @author priteela
 */
public interface CsvLineValidationService {

    CsvLineInformation validate(CsvLineInformation csvLineInformation);
}
