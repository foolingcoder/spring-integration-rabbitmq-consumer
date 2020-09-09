package mu.integration.consumer.rabbitmq;

import java.io.Serializable;

/**
 *
 * @author priteela
 */
public class Result implements Serializable {

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    private String correlationId;
    
    public Result(String status, String correlationId) {
        this.status = status;
        this.correlationId = correlationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

}
