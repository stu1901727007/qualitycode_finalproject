package uni.plovdiv.services;

import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;
import uni.plovdiv.services.interfaces.TaskMessageServiceInterface;
import java.util.Date;

public class TaskMessageService implements TaskMessageServiceInterface {

    final TaskMessageRepoInterface taskMessageRepo;

    /**
     * @param taskMessageRepo
     */
    public TaskMessageService(TaskMessageRepoInterface taskMessageRepo) {
        this.taskMessageRepo = taskMessageRepo;
    }

    public TaskMessage createMessage(Task task, TaskStatus status, String message) throws IllegalArgumentException
    {
        if( message == null )
            throw new IllegalArgumentException("Please provide valid message attribute");

        TaskMessage taskMessage = new TaskMessage();
        taskMessage.setTask(task);
        taskMessage.setStatus(status);
        taskMessage.setMessage(message);
        taskMessage.setCreatedAt(new Date());
        taskMessage.setUpdatedAt(new Date());

        //this.taskMessageRepo.save(taskMessage); //if there is a database

        return taskMessage;
    }
}
