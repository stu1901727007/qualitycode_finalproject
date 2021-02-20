package uni.plovdiv.services.interfaces;

import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.models.TaskStatus;

public interface TaskMessageServiceInterface {

    /**
     * @param task
     * @param status
     * @param message
     * @return
     */
    TaskMessage createMessage(Task task, TaskStatus status, String message) throws Exception;

}
