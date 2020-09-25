package mu.integration.consumer.rabbitmq.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author priteela
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportIntegrationVO implements Serializable {
    private String id;
    private String line;
    private String fileName;
    private String status;

    public String toCsv() {
        return this.id + "," + this.line + "," + this.status + "," + this.fileName;
    }
}
