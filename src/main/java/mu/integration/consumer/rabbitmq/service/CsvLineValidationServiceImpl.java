package mu.integration.consumer.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.dto.CsvLineInformation;

/**
 *
 * @author priteela
 */
@Transactional(readOnly = true)
@Slf4j
@Service
public class CsvLineValidationServiceImpl implements CsvLineValidationService {
    private static int i = 0;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public CsvLineInformation validate(CsvLineInformation csvLineInformation) {

        if (i++ % 2 == 0) {
            csvLineInformation.setStatus("SUCCESS");
        } else {
            csvLineInformation.setStatus("FAILURE");
        }
        return csvLineInformation;
    }
}
