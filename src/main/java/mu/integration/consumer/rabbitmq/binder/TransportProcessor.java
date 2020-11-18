package mu.integration.consumer.rabbitmq.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Bindable interface with separate input and output channels for flight and cruise respectively.
 *
 * @author Priteela
 * @see org.springframework.cloud.stream.annotation.EnableBinding
 */
public interface TransportProcessor extends CruiseProcessor, FlightProcessor {
    String INTEGRATION_RESPONSE_OUTPUT = "integrationResponseOutput";
    String INTEGRATION_RESPONSE_INPUT = "integrationResponseInput";

    @Output(INTEGRATION_RESPONSE_OUTPUT)
    MessageChannel integrationResponseOutput();

    @Input(INTEGRATION_RESPONSE_INPUT)
    SubscribableChannel integrationResponseInput();
}
