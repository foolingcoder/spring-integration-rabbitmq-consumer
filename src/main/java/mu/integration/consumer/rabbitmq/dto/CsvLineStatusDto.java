package mu.integration.consumer.rabbitmq.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mu.integration.consumer.rabbitmq.entity.CsvLine;

/**
 *
 * @author priteela
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CsvLineStatusDto implements Serializable {

    private String status = "";
    private CsvLine csvLine;

}
