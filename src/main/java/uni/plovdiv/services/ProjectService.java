package uni.plovdiv.services;

import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;
import uni.plovdiv.services.interfaces.ProjectServiceInterface;
import uni.plovdiv.utils.DateUtils;

import java.util.Objects;

/**
 * Project's services
 * Keeps the base logic to manipulate projects
 */
public class ProjectService implements ProjectServiceInterface {

    final ProjectRepoInterface projectRepo;

    /**
     * Constructor
     *
     * @param projectRepo instance of ProjectRepoInterface
     */
    public ProjectService(ProjectRepoInterface projectRepo) {
        this.projectRepo = projectRepo;
    }

    /**
     * Create new project
     *
     * @param name  String representation of project name. Valid not {@code NULL}
     * @return
     * @throws NullPointerException
     */
    @Override
    public Project createProject(String name) throws NullPointerException {

        Project project = new Project();
        project.setName(Objects.requireNonNull(name, "Моля, въвдете валидно име на проект"));
        project.setCreatedAt(DateUtils.Time());
        project.setUpdatedAt(DateUtils.Time());

        return project;
    }

    /**
     * Delete project. The method is going to change the flag deletedAt
     *
     * @param project  Object instance of Project. Valid not {@code NULL}
     * @return Boolean true|false
     */
    @Override
    public Boolean deleteProject(Project project) {

        project.setDeletedAt(DateUtils.Time());

        //this.projectRepo.save(project); //if there is a database

        return true;
    }

    /**
     * Assign task to selected project
     *
     * @param project Instance of Project. The project to which we are going to attach task
     *                Valid not {@code NULL}
     * @param task    Instance of Task. The actual task that we are going to attach.
     *                Valid not {@code NULL}
     * @return Project object
     */
    @Override
    public Project assignTask(Project project, Task task) {
        project.assignTask(task);

        //this.projectRepo.save(project); //if there is a database

        return project;
    }

    /**
     * Assign subprojects to selected project
     *
     * @param project        Instance of Project. The project to which we are going to attach task
     *                       Valid not {@code NULL}
     * @param attachProject  Instance of Project. The actual project that we are going to attach.
     *                       Valid not {@code NULL}
     * @return
     */
    @Override
    public Project assignProject(Project project, Project attachProject) {

        project.assignProject(attachProject);

        //this.projectRepo.save(project); //if there is a database

        return project;
    }
}
