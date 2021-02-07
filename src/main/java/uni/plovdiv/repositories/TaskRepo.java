package uni.plovdiv.repositories;

import uni.plovdiv.models.Task;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;

import java.util.Collections;
import java.util.List;

/**
 * Task repository
 */
public class TaskRepo implements TaskRepoInterface {

    /**
     * Fetch all tasks
     * @return List with all tasks
     */
    @Override
    public List<Task> findAll() {
        return Collections.emptyList();
    }

    /**
     * Fetch tasks based on the @param id
     * @param id
     * @return Task object
     */
    @Override
    public Task findById(int id){ return null; }
}
