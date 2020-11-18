package mu.integration.consumer.rabbitmq.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mu.integration.consumer.rabbitmq.constant.FileStatus;
import mu.integration.consumer.rabbitmq.constant.TransportType;

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
    private FileStatus status;
    private TransportType transportType;
    private Set<String> errorMessage;

    /**
     * Method to concat line and list of error message
     *
     * @return string
     */
    public String toCsv() {
        return this.line + "," + this.errorMessage;
    }
}
