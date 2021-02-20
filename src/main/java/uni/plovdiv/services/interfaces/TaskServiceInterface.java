package uni.plovdiv.services.interfaces;

import uni.plovdiv.models.Employee;
import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskStatus;

public interface TaskServiceInterface {

    /**
     * @param name
     * @return
     */
    Task createTask(String name, Project project) throws NullPointerException;

    /**
     * @param task
     * @param status
     * @param message
     * @return
     */
    Task changeTaskStatus(Task task, TaskStatus status, String message) throws Exception;


    /**
     * @param task
     * @return
     */
    Boolean deleteTask(Task task);

    /**
     * @param task
     * @param subTask
     * @return
     */
    Task assignSubTask(Task task, Task subTask);

    /**
     * @param task
     * @param employee
     * @return
     */
    Task assignEmployee(Task task, Employee employee);
}
