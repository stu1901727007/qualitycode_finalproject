package uni.plovdiv.repositories;

import uni.plovdiv.models.Project;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;

import java.util.Collections;
import java.util.List;

/**
 * Projects repository
 */
public class ProjectRepo implements ProjectRepoInterface {

    /**
     * Fetch all projects
     * @return List with all projects
     */
    @Override
    public List<Project> findAll() {
        return Collections.emptyList();
    }

    /**
     * Fetch projects based on the @param id
     * @param id
     * @return Project object
     */
    @Override
    public Project findById(int id){ return null; }
}
