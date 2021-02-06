package uni.plovdiv.services;

import uni.plovdiv.models.*;
import uni.plovdiv.repositories.TaskMessageRepo;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;
import uni.plovdiv.services.interfaces.TaskServiceInterface;

import java.util.Date;

public class TaskService implements TaskServiceInterface {

    final TaskRepoInterface taskRepo;

    /**
     * @param taskRepo
     */
    public TaskService(TaskRepoInterface taskRepo) {
        this.taskRepo = taskRepo;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Task createTask(String name, Project project) {

        Task task = new Task();
        task.setName(name);
        task.setCreatedAt(new Date());
        task.setUpdatedAt(new Date());
        task.setCurrentStatus(TaskStatus.NEW);
        task.setProject(project);

        //this.taskRepo.save(task); //if there is a database

        return task;
    }

    /**
     * @param task
     * @return
     */
    @Override
    public Boolean deleteTask(Task task) {

        task.setDeletedAt(new Date());

        //this.taskRepo.save(task); //if there is a database

        return true;
    }

    /**
     * @param task
     * @param subTask
     * @return
     */
    @Override
    public Task assignSubTask(Task task, Task subTask) {

        task.assignSubTask(task);

        //this.taskRepo.save(task); //if there is a database
        
        return task;
    }

    /**
     *
     * @param task
     * @param message
     * @return
     */
    @Override
    public Task changeTaskStatus(Task task, TaskStatus status, String message) throws Exception {

        if( task.getCurrentStatus() == TaskStatus.COMPLETED )
            throw new Exception("Не може да смените статуса на приключена задача!");

        task.setCurrentStatus( status );

        //this.taskRepo.save(task); //if there is a database

        //Create new message
        TaskMessageService taskMessageService = new TaskMessageService( new TaskMessageRepo());
        taskMessageService.createMessage(task, status, message);

        return task;
    }


    @Override
    public Task assignEmployee(Task task, Employee employee) {

        task.setAssignedEmployee(employee);

        //this.taskRepo.save(task); //if there is a database

        return task;
    }
}
