package uni.plovdiv.repositories;

import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Task's messages repository
 */
public class TaskMessageRepo implements TaskMessageRepoInterface {

    /**
     * List with records
     */
    private List<TaskMessage> messages = new ArrayList<>();

    /**
     * Fetch all task's messages
     *
     * @return List with all messages
     */
    @Override
    public List<TaskMessage> findAll() {
        return this.messages;
    }

    /**
     * Fetch message based on the @param id
     *
     * @param id
     * @return TaskMessage object
     */
    @Override
    public TaskMessage findById(int id) {

        Optional<TaskMessage> message = this.messages.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (message.isPresent())
            return message.get();
        else
            return null;
    }

    /**
     * Saves changes to the List
     *
     * @param message  Instance of Task. Valid not {@code NULL}
     * @return
     */
    @Override
    public TaskMessage save(TaskMessage message) {

        if (message.getId() == 0) {
            message.setId((int) (this.messages.size() + 1));
            this.messages.add(message);
        } else {
            this.messages.set(message.getId() - 1, message);
        }

        return message;
    }
}
