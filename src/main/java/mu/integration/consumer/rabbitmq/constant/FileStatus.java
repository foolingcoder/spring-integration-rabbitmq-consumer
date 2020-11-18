package mu.integration.consumer.rabbitmq.constant;

/**
 * Enumerator to indicate the status of the file import
 *
 * @author Priteela ,ganesh
 */
public enum FileStatus {

    /**
     * SUCCESS fileStatus enum
     */
    SUCCESS,

    /**
     * FAILURE fileStatus enum
     */
    FAILURE,

    /**
     *  PENDING VALIDATION fileStatus enum
     */
    PENDING_VALIDATION;

}
