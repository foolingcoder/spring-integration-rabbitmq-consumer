package mu.integration.consumer.rabbitmq.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Bindable interface with separate input and output channels for flight
 *
 * @author Priteela
 * @see org.springframework.cloud.stream.annotation.EnableBinding
 */
public interface FlightProcessor {

    String FLIGHT_OUTPUT = "flightOutput";
    String FLIGHT_INPUT = "flightInput";

    @Output(FLIGHT_OUTPUT)
    MessageChannel flightOutput();

    @Input(FLIGHT_INPUT)
    SubscribableChannel flightInput();

}
