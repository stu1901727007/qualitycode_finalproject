package uni.plovdiv.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Project;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;
import uni.plovdiv.services.interfaces.ProjectServiceInterface;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ProjectServiceTest {

    private ProjectServiceInterface projectService;
    private ProjectRepoInterface projectRepo;


    @BeforeEach
    void setUp() {
        this.projectRepo = mock(ProjectRepoInterface.class);

        Project project = new Project();
        project.setName("Project 1");

        List<Project> projects = Arrays.asList(project);

        doReturn(projects).when(this.projectRepo).findAll();
        doReturn(project).when(this.projectRepo).findById(1);

        this.projectService = new ProjectService(this.projectRepo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateProjectWithNullName() {

        assertThrows(Exception.class, () -> this.projectService.createProject(null));
    }

    @Test
    void deleteProject() {
        Project project = this.projectRepo.findById(1);
        this.projectService.deleteProject(project);
        assertNotNull(project.getDeletedAt());
    }

    @Test
    void assignTask() {
    }

    @Test
    void assignTasks() {
    }
}