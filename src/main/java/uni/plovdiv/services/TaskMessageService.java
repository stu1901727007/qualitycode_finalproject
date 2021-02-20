package uni.plovdiv.services;

import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;
import uni.plovdiv.services.interfaces.TaskMessageServiceInterface;
import uni.plovdiv.utils.DateUtils;

import java.util.Objects;

/**
 * Message's services
 * Keeps the base logic to manipulate task messages
 */
public class TaskMessageService implements TaskMessageServiceInterface {

    final TaskMessageRepoInterface taskMessageRepo;

    /**
     * Constructor
     *
     * @param taskMessageRepo instance of TaskMessageRepoInterface
     */
    public TaskMessageService(TaskMessageRepoInterface taskMessageRepo) {
        this.taskMessageRepo = taskMessageRepo;
    }

    /**
     * Create new message about the task
     *
     * @param task      Instance of Task. The actual task to which we change the status.
     *                  Valid not {@code NULL}
     * @param status    Instance of TaskStatus.Valid not {@code NULL}
     * @param message   String representation for message that explains why we changed the status.
     *                  Valid not {@code NULL}
     * @return Instance of TaskMessage object
     * @throws Exception
     */
    public TaskMessage createMessage(Task task, TaskStatus status, String message) throws Exception
    {
        //Това е само история! Проверката ще е в TaskService!
        //if( task.getCurrentStatus() == TaskStatus.COMPLETED )
        //    throw new Exception("Не може да смените статуса на приключена задача!");

        TaskMessage taskMessage = new TaskMessage();
        taskMessage.setTask(Objects.requireNonNull(task, "Не може задачата да е Null"));
        taskMessage.setStatus(Objects.requireNonNull(status, "Моля, подайте валидна статус"));
        taskMessage.setMessage(Objects.requireNonNull(message, "Моля, подайте валидна стойност за съобщението"));
        taskMessage.setCreatedAt(DateUtils.Time());
        taskMessage.setUpdatedAt(DateUtils.Time());

        this.taskMessageRepo.save(taskMessage);

        return taskMessage;
    }
}
