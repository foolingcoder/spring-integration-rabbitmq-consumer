package mu.integration.consumer.rabbitmq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import mu.integration.consumer.rabbitmq.binder.TransportProcessor;

@EnableBinding(TransportProcessor.class)
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
