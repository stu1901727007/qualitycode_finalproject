package uni.plovdiv.unit.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Project;
import uni.plovdiv.repositories.ProjectRepo;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepoTest {

    private ProjectRepoInterface projectRepo;

    @BeforeEach
    void setUp() {

        this.projectRepo = new ProjectRepo();

        //Sub project
        Project subProject = new Project();
        subProject.setName("Project 1");

        //Parent project
        Project project = new Project();
        project.setName("Project 2");
        project.assignProject(subProject);

        this.projectRepo.save(project);
    }

    @Test
    void findAll() {
        List<Project> projects = this.projectRepo.findAll();
        assertNotNull(projects);
    }

    @Test
    void findByIdSuccess() {

        Project project = this.projectRepo.findById(1);
        assertEquals("Project 2", project.getName());
    }

    @Test
    void findByIdNull() {
        Project project = this.projectRepo.findById(11);
        assertNull(project);
    }

    @Test
    void testSaveNew() {

        Project project = new Project();
        project.setName("Project 2");
        this.projectRepo.save(project);

        assertEquals(2, project.getId());
    }

    @Test
    void testSaveUpdate() {
        Project project = new Project();
        project.setName("Project 2");
        this.projectRepo.save(project);

        project = this.projectRepo.save(project);

        project.setName("Project 2 new");
        project = this.projectRepo.save(project);

        assertEquals(2, project.getId());
    }

}