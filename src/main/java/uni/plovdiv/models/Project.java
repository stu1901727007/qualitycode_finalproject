package uni.plovdiv.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project entity
 */

public class Project {

    /**
     * Unique id, autoincrement
     */
    private int id;

    /**
     * Project name
     */
    private String name;

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
     * One-to-Many
     */
    private List<Task> assignedTasks = new ArrayList<>();

    /**
     * One-to-Many
     */
    private List<Project> assignedProjects = new ArrayList<>();;

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
        return this.assignedTasks;
    }

    public List<Project> getAssignedProjects() {
        return this.assignedProjects;
    }

    public Project assignTask(Task task) {
        this.assignedTasks.add(task);
        return this;
    }

    public Project assignProject(Project project) {

        this.assignedProjects.add(project);
        return this;
    }
}
