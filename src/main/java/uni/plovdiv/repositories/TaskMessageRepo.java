package uni.plovdiv.repositories;

import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;

import java.util.Collections;
import java.util.List;

/**
 * Task's messages repository
 */
public class TaskMessageRepo implements TaskMessageRepoInterface {

    /**
     * Fetch all task's messages
     * @return List with all messages
     */
    @Override
    public List<TaskMessage> findAll() {
        return Collections.emptyList();
    }

    /**
     * Fetch message based on the @param id
     * @param id
     * @return TaskMessage object
     */
    @Override
    public TaskMessage findById(int id){ return null; }
}
