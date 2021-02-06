package uni.plovdiv.services.interfaces;

import uni.plovdiv.models.*;

public interface TaskServiceInterface {

    /**
     * @param name
     * @return
     */
    Task createTask(String name, Project project);

    /**
     *
     * @param task
     * @param message
     * @return
     */
    Task changeTaskStatus(Task task, TaskMessage message);


    /**
     * @param task
     * @return
     */
    Boolean deleteTask(Task task);

    /**
     *
     * @param task
     * @param subTask
     * @return
     */
    Task assignSubTask(Task task, Task subTask);

    /**
     *
     * @param task
     * @param employee
     * @return
     */
    Task assignEmployee(Task task, Employee employee);
}
