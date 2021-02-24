package uni.plovdiv.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project entity
 */
@Setter
@Getter
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
     * Returns the Id and casts it
     *
     * @return the id casted in Integer object
     */
    public Integer getId() {
        return id;
    }

    /**
     * One-to-Many
     */
    private List<Project> assignedProjects = new ArrayList<>();;

    /**
     * Add a task to the list with assigned tasks
     *
     * @return Project object for chaining
     */
    public Project assignTask(Task task) {
        this.assignedTasks.add(task);
        return this;
    }

    /**
     * Add a  project to the list with assigned projects
     *
     * @param project representation of Project object. Valid not {@code NULL}
     * @return Project object for chaining
     */
    public Project assignProject(Project project) {

        this.assignedProjects.add(project);
        return this;
    }
}
