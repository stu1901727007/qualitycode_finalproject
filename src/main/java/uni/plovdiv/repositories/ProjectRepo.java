package uni.plovdiv.repositories;

import uni.plovdiv.models.Project;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;

import java.util.Collections;
import java.util.List;

public class ProjectRepo implements ProjectRepoInterface {

    /**
     * @return
     */
    @Override
    public List<Project> findAll() {
        return Collections.emptyList();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Project findById(int id){ return null; }
}
