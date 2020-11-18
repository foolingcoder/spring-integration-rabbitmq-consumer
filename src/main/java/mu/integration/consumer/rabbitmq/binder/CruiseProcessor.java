package mu.integration.consumer.rabbitmq.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Bindable interface with separate input and output channels for cruise.
 *
 * @author Priteela
 * @see org.springframework.cloud.stream.annotation.EnableBinding
 */
public interface CruiseProcessor {

    String CRUISE_OUTPUT = "cruiseOutput";
    String CRUISE_INPUT = "cruiseInput";

    @Output(CRUISE_OUTPUT)
    MessageChannel cruiseOutput();

    @Input(CRUISE_INPUT)
    SubscribableChannel cruiseInput();
}
