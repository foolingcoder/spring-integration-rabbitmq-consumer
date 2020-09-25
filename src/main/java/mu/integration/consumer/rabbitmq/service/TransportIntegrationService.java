package mu.integration.consumer.rabbitmq.service;

import mu.integration.consumer.rabbitmq.dto.TransportIntegrationVO;

/**
 * Exposes service operations related to CSV line {@link TransportIntegrationVO}
 *
 * @author Priteela
 */
public interface TransportIntegrationService {

    /**
     * Validates the provided the transport integration
     *
     * @param transportIntegrationVO
     * @return the updated transport integration with its status
     */
    TransportIntegrationVO validate(TransportIntegrationVO transportIntegrationVO);
}
