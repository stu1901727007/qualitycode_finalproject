package uni.plovdiv.repositories;

import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Task repository
 */
public class TaskRepo implements TaskRepoInterface {

    /**
     * List with records
     */
    private List<Task> tasks = new ArrayList<>();

    /**
     * Fetch all tasks
     *
     * @return List with all tasks
     */
    @Override
    public List<Task> findAll() {
        return this.tasks;
    }

    /**
     * Fetch tasks based on the @param id
     *
     * @param id
     * @return Task object
     */
    @Override
    public Task findById(int id) {

        Optional<Task> task = this.tasks.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (task.isPresent())
            return task.get();
        else
            return null;
    }

    /**
     * Saves changes to the List
     *
     * @param task
     * @return
     */
    @Override
    public Task save(Task task) {

        if (task.getId() == 0) {
            task.setId((int) (this.tasks.size() + 1));
            this.tasks.add(task);
        } else {
            this.tasks.set(task.getId() - 1, task);
        }

        return task;
    }
}
