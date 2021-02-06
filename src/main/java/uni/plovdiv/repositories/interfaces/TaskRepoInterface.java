package uni.plovdiv.repositories.interfaces;

import uni.plovdiv.models.Task;

import java.util.List;

public interface TaskRepoInterface {

    /**
     * 
     * @return
     */
    List<Task> findAll();

    /**
     *
     * @param id
     * @return
     */
    Task findById(int id);
}
