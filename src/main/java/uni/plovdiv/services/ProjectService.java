package uni.plovdiv.services;

import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.repositories.ProjectRepo;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;
import uni.plovdiv.services.interfaces.ProjectServiceInterface;

import java.util.Date;

public class ProjectService implements ProjectServiceInterface {

    final ProjectRepoInterface projectRepo;

    /**
     * @param projectRepo
     */
    public ProjectService(ProjectRepoInterface projectRepo) {
        this.projectRepo = projectRepo;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Project createProject(String name) {

        return new Project(name);
    }

    /**
     * @param project
     * @return
     */
    @Override
    public Boolean deleteProject(Project project) {

        project.setDeletedAt(new Date());

        //this.projectRepo.save(project); //if there is a database

        return true;
    }

    /**
     * @param project
     * @param task
     * @return
     */
    @Override
    public Project assignTask(Project project, Task task) {
        project.assignTask(task);

        //this.projectRepo.save(project); //if there is a database

        return project;
    }

    @Override
    public Project assignProject(Project project, Project attachProject) {

        project.assignProject(attachProject);

        //this.projectRepo.save(project); //if there is a database

        return project;
    }
}
