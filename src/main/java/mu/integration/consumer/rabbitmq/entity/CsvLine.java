package mu.integration.consumer.rabbitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author priteela
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CsvLine {
    private String col1;

    private String col2;

    private String col3;
}
