package mu.integration.consumer.rabbitmq.service;

import mu.integration.consumer.rabbitmq.dto.CsvLineInformation;

/**
 * Exposes service operations related to CSV line {@link CsvLineInformation}
 *
 * @author Priteela
 */
public interface CsvLineValidationService {

    /**
     * Validates the provided the CSV line
     *
     * @param csvLineInformation
     * @return the updated csvLineInformation with its status
     */
    CsvLineInformation validate(CsvLineInformation csvLineInformation);
}
