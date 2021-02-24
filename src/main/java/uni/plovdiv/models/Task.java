package uni.plovdiv.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Task entity
 */
@Setter
@Getter
public class Task {

    /**
     * Unique id, autoincrement
     */
    private int id;

    /**
     * The task name
     */
    private String name;

    /**
     * The project to which the task is assigned
     */
    private Project project;

    /**
     * The parent task on which the current depends
     */
    private Task parentTask;

    /**
     * The current status of the task
     */
    private TaskStatus currentStatus;

    /**
     * The responsible employee about the task
     */
    private Employee assignedEmployee;

    /**
     * The date of creation
     */
    private Date createdAt;

    /**
     * The date of last update
     */
    private Date updatedAt;

    /**
     * The date record has been deleted.
     */
    private Date deletedAt;

    /**
     * Relationship One-to-Many
     * All attached sub task
     */
    private List<Task> assignedTasks = new ArrayList<>();

    /**
     * Returns the Id and casts it
     *
     * @return the id casted in Integer object
     */
    public Integer getId() {
        return id;
    }

    /**
     * Retrieve the list with assigned sub-tasks
     *
     * @return List with Task object
     */
    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    /**
     * Add a task to the list with sub-tasks
     *
     * @param task representation of Task object. Valid not {@code NULL}
     */
    public void assignSubTask(Task task) {
        this.assignedTasks.add(task);
    }
}
