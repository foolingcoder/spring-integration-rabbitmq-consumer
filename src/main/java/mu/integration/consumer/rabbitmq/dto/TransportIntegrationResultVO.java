package mu.integration.consumer.rabbitmq.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * View object for CSV Import Status
 *
 * @author Priteela
 */
@Data
@NoArgsConstructor
public class TransportIntegrationResultVO implements Serializable {

    private String fileName;
    // private List<Set<String>> errorMessageList;
    private long numberRecordUpload;
    private long numberRecordSuccess;
    private long numberRecordFail;
}
