package mu.integration.consumer.rabbitmq.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import mu.integration.consumer.rabbitmq.constant.FileStatus;
import mu.integration.consumer.rabbitmq.dto.TransportIntegrationVO;

/**
 *
 * @author priteela
 */
@Transactional(readOnly = true)
@Slf4j
@Service
public class TransportIntegrationServiceImpl implements TransportIntegrationService {
    private static int i = 0;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public TransportIntegrationVO validate(TransportIntegrationVO transportIntegrationVO) {

        if (i++ % 2 == 0) {
            transportIntegrationVO.setStatus(FileStatus.SUCCESS);
        } else {
            transportIntegrationVO.setStatus(FileStatus.FAILURE);
            Set<String> errorMessage = new HashSet<>();
            errorMessage.add("error+" + i);
            transportIntegrationVO.setErrorMessage(errorMessage);
        }
        return transportIntegrationVO;
    }
}
