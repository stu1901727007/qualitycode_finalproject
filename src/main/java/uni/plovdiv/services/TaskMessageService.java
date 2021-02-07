package uni.plovdiv.services;

import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;
import uni.plovdiv.services.interfaces.TaskMessageServiceInterface;
import uni.plovdiv.utils.DateUtils;

import java.util.Objects;

public class TaskMessageService implements TaskMessageServiceInterface {

    final TaskMessageRepoInterface taskMessageRepo;

    /**
     * @param taskMessageRepo
     */
    public TaskMessageService(TaskMessageRepoInterface taskMessageRepo) {
        this.taskMessageRepo = taskMessageRepo;
    }

    public TaskMessage createMessage(Task task, TaskStatus status, String message) throws Exception
    {
        if( task.getCurrentStatus() == TaskStatus.COMPLETED )
            throw new Exception("Не може да смените статуса на приключена задача!");

        TaskMessage taskMessage = new TaskMessage();
        taskMessage.setTask(task);
        taskMessage.setStatus(status);
        taskMessage.setMessage(Objects.requireNonNull(message, "Моля, подайте валидна стойност за съобщението"));
        taskMessage.setCreatedAt(DateUtils.Time());
        taskMessage.setUpdatedAt(DateUtils.Time());

        //this.taskMessageRepo.save(taskMessage); //if there is a database

        return taskMessage;
    }
}
