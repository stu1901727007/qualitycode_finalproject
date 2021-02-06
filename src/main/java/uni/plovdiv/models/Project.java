package uni.plovdiv.models;

import java.util.Date;
import java.util.List;

public class Project {

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
     * One-to-Many
     */
    private List<Task> assignedTasks;

    /**
     * One-to-Many
     */
    private List<Project> assignedProjects;

    /**
     * @param name
     */
    public Project(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * @param task
     * @return
     */
    public Project assignTask(Task task) {
        this.assignedTasks.add(task);

        return this;
    }

    /**
     *
     * @param project
     * @return
     */
    public Project assignProject(Project project) {
        this.assignedProjects.add(project);

        return this;
    }
}
