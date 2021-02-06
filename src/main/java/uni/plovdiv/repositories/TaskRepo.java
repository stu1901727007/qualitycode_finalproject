package uni.plovdiv.repositories;

import uni.plovdiv.models.Task;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;

import java.util.Collections;
import java.util.List;

public class TaskRepo implements TaskRepoInterface {

    /**
     * @return
     */
    @Override
    public List<Task> findAll() {
        return Collections.emptyList();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Task findById(int id){ return null; }
}
