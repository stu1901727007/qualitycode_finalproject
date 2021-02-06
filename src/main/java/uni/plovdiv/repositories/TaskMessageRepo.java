package uni.plovdiv.repositories;

import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;

import java.util.Collections;
import java.util.List;

public class TaskMessageRepo implements TaskMessageRepoInterface {

    /**
     * @return
     */
    @Override
    public List<TaskMessage> findAll() {
        return Collections.emptyList();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public TaskMessage findById(int id){ return null; }
}
