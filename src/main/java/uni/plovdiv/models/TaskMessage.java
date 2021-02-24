package uni.plovdiv.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Task messages entity
 */
@Setter
@Getter
public class TaskMessage {

    /**
     * Unique id, autoincrement
     */
    private int id;

    /**
     * The task to which the message depends
     */
    private Task task;

    /**
     * The new task status
     */
    private TaskStatus status;

    /**
     * The message that explains why the status has been changed
     */
    private String message;

    /**
     * The date of creation
     */
    private Date createdAt;

    /**
     * The date of last update
     */
    private Date updatedAt;

    /**
     * Returns the Id and casts it
     *
     * @return the id casted in Integer object
     */
    public Integer getId() {
        return id;
    }
}
