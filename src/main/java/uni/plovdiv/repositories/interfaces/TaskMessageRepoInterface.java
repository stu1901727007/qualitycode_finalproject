package uni.plovdiv.repositories.interfaces;

import uni.plovdiv.models.TaskMessage;

import java.util.List;

public interface TaskMessageRepoInterface {

    /**
     * 
     * @return
     */
    List<TaskMessage> findAll();

    /**
     *
     * @param id
     * @return
     */
    TaskMessage findById(int id);
}
