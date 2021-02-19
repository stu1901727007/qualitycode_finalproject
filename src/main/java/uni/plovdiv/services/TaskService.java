package uni.plovdiv.services;

import uni.plovdiv.models.Employee;
import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.repositories.TaskMessageRepo;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;
import uni.plovdiv.services.interfaces.TaskServiceInterface;
import uni.plovdiv.utils.DateUtils;

import java.util.Objects;

/**
 * Task's services
 * Keeps the base logic to manipulate tasks
 */
public class TaskService implements TaskServiceInterface {

    final TaskRepoInterface taskRepo;

    /**
     * Constructor
     *
     * @param taskRepo instace of TaskRepoInterface
     */
    public TaskService(TaskRepoInterface taskRepo) {
        this.taskRepo = taskRepo;
    }

    /**
     * Create new task
     *
     * @param name      String representation of task name. Valid not {@code NULL}
     * @param project   Instance of Project. The project to which the task belongs.
     *                  Valid not {@code NULL}
     * @return Instance of Task object
     * @throws NullPointerException
     */
    @Override
    public Task createTask(String name, Project project) throws NullPointerException {

        Task task = new Task();
        task.setName( Objects.requireNonNull(name, "Заглавието на задачата не може да е Null"));
        task.setProject(Objects.requireNonNull(project, "Проектът не може да е Null"));
        task.setCreatedAt(DateUtils.Time());
        task.setUpdatedAt(DateUtils.Time());
        task.setCurrentStatus(TaskStatus.NEW);

        //this.taskRepo.save(task); //if there is a database

        return task;
    }

    /**
     * Delete task. The method is going to change the flag deletedAt
     *
     * @param task  Object instance of Task. Valid not {@code NULL}
     * @return Boolean true|false
     */
    @Override
    public Boolean deleteTask(Task task) {

        task.setDeletedAt(DateUtils.Time());

        //this.taskRepo.save(task); //if there is a database

        return true;
    }

    /**
     * Assign subtask to the task
     *
     * @param task      Instance of Task. The task to which we want to assign subtask.
     *                  Valid not {@code NULL}
     * @param subTask   Instance of Task. The actual task that we are going to assign
     *                  Valid not {@code NULL}
     * @return Instance of Task object
     */
    @Override
    public Task assignSubTask(Task task, Task subTask) {

        task.assignSubTask(subTask);

        //this.taskRepo.save(task); //if there is a database
        
        return task;
    }

    /**
     * Change the status of task. It's going to create and record in the task's messages
     *
     * @param task      Instance of Task. The actual task to which we change the status.
     *                  Valid not {@code NULL}
     * @param status    Instance of TaskStatus.Valid not {@code NULL}
     * @param message   String representation for message that explains why we changed the status.
     *                  Valid not {@code NULL}
     * @return Instance of Task object
     * @throws Exception
     */
    @Override
    public Task changeTaskStatus(Task task, TaskStatus status, String message) throws Exception {

        if( task.getCurrentStatus() == TaskStatus.COMPLETED )
            throw new Exception("Не може да смените статуса на приключена задача!");

        if( task.getAssignedEmployee() == null )
            throw new Exception("Не може да смените статуса задача без да има служител!");

        task.setCurrentStatus( status );

        this.taskRepo.save(task); //if there is a database

        //Create new message
        TaskMessageService taskMessageService = new TaskMessageService( new TaskMessageRepo());
        taskMessageService.createMessage(task, status, message);

        return task;
    }

    /**
     * Assign task to any employee
     *
     * @param task      Instance of Task. The actual task to which we want to assign employee.
     *                  Valid not {@code NULL}
     * @param employee  Instance of Employee. The employee which we want to assign to the task
     *                  Valid not {@code NULL}
     * @return Instance of Task object
     */
    @Override
    public Task assignEmployee(Task task, Employee employee) {

        task.setAssignedEmployee(employee);

        this.taskRepo.save(task); //if there is a database

        return task;
    }
}
