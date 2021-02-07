package uni.plovdiv.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Project project;

    /**
     *
     */
    private Task parentTask;

    /**
     *
     */
    private TaskStatus currentStatus;

    /**
     *
     */
    private Employee assignedEmployee;

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
     */
    private Date deletedAt;

    /**
     * Relationship One-to-Many
     * All attached sub task
     */
    private List<Task> assignedTasks = new ArrayList<>();

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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Project getProject() {
        return project;
    }

    /**
     *
     * @param project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     *
     * @return
     */
    public Task getParentTask() {
        return parentTask;
    }

    /**
     *
     * @param parentTask
     */
    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    /**
     *
     * @return
     */
    public TaskStatus getCurrentStatus() {
        return currentStatus;
    }

    /**
     *
     * @param currentStatus
     */
    public void setCurrentStatus(TaskStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    /**
     *
     * @return
     */
    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    /**
     *
     * @param assignedEmployee
     */
    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
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

    /**
     *
     * @return
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     *
     * @param deletedAt
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     *
     * @return
     */
    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    /**
     *
     * @param task
     */
    public void assignSubTask(Task task)
    {
        this.assignedTasks.add(task);
    }
}
