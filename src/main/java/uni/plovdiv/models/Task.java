package uni.plovdiv.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Task entity
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public TaskStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(TaskStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void assignSubTask(Task task) {
        this.assignedTasks.add(task);
    }
}
