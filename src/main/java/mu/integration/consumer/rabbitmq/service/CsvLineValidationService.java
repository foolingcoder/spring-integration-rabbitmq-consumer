package mu.integration.consumer.rabbitmq.service;

import mu.integration.consumer.rabbitmq.entity.CsvLineInformation;

/**
 *
 * @author priteela
 */
public interface CsvLineValidationService {

    CsvLineInformation validate(CsvLineInformation csvLineInformation);
}
