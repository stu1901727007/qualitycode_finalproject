package uni.plovdiv.services.interfaces;

import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;

public interface ProjectServiceInterface {

    /**
     * @param name
     * @return
     */
    Project createProject(String name) throws NullPointerException;

    /**
     * @param project
     * @return
     */
    Boolean deleteProject(Project project);

    /**
     * @param task
     * @return Boolean
     */
    Project assignTask(Project project, Task task);

    /**
     *
     * @param project
     * @param attachProject
     * @return
     */
    Project assignProject(Project project, Project attachProject);
}
