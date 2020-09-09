package mu.integration.consumer.rabbitmq;

import org.springframework.stereotype.Service;

/**
 *
 * @author priteela
 */

@Service
public class LineProcessor {

    public Result validate(String csvLine, String correlationId) {

        //Call a service class to validate pojo
        Pojo record = new Pojo(csvLine);
        System.out.println(record.toString());

        return new Result("success", correlationId);
    }
}
