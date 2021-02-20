package uni.plovdiv.repositories.interfaces;

import uni.plovdiv.models.Project;

import java.util.List;

public interface ProjectRepoInterface {

    /**
     * @return
     */
    List<Project> findAll();

    /**
     * @param id
     * @return
     */
    Project findById(int id);


    /**
     * @param project
     * @return
     */
    Project save(Project project);
}
