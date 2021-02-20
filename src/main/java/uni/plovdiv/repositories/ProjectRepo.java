package uni.plovdiv.repositories;

import uni.plovdiv.models.Project;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Projects repository
 */
public class ProjectRepo implements ProjectRepoInterface {

    /**
     * List with records
     */
    private List<Project> projects = new ArrayList<>();

    /**
     * Fetch all projects
     *
     * @return List with all projects
     */
    @Override
    public List<Project> findAll() {
        return this.projects;
    }

    /**
     * Fetch projects based on the @param id
     *
     * @param id
     * @return Project object
     */
    @Override
    public Project findById(int id) {

        Optional<Project> project = this.projects.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (project.isPresent())
            return project.get();
        else
            return null;
    }

    /**
     * Saves changes to the List
     *
     * @param project Instance of Project. Valid not {@code NULL
     * @return
     */
    @Override
    public Project save(Project project) {

        if (project.getId() == 0) {
            project.setId((int) (this.projects.size() + 1));
            this.projects.add(project);
        }
        else
        {
            this.projects.set(project.getId() - 1, project);
        }

        return project;
    }
}
