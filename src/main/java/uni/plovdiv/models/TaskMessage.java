package uni.plovdiv.models;

import java.util.Date;

public class TaskMessage {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private Task task;

    /**
     *
     */
    private TaskStatus status;

    /**
     *
     */
    private String message;

    /**
     *
     */
    private Date createdAt;

    /**
     *
     */
    private Date updatedAt;

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Task getTask() {
        return task;
    }

    /**
     *
     * @param task
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     *
     * @return
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
