package uni.plovdiv.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;
import uni.plovdiv.services.interfaces.ProjectServiceInterface;
import uni.plovdiv.services.interfaces.TaskServiceInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ProjectServiceTest {

    private ProjectServiceInterface projectService;
    private ProjectRepoInterface projectRepo;

//    private TaskServiceInterface taskService;
//    private TaskRepoInterface taskRepo;

    @BeforeEach
    void setUp() {
        this.projectRepo = mock(ProjectRepoInterface.class);

        //Sub project
        Project subProject = new Project();
        subProject.setName("Project 1");

        //Parent project
        Project project = new Project();
        project.setName("Project 2");
        project.assignProject(subProject);

        List<Project> projects = Arrays.asList(project, subProject);

        doReturn(projects).when(this.projectRepo).findAll();
        doReturn(project).when(this.projectRepo).findById(1);
        doReturn(subProject).when(this.projectRepo).findById(2);

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
    void testCreateProjectWithCorrectName() {

        assertTrue(this.projectService.createProject("Project 1") instanceof Project);
    }

    @Test
    void deleteProject() {
        Project project = this.projectRepo.findById(1);
        this.projectService.deleteProject(project);
        assertNotNull(project.getDeletedAt());
    }

    @Test
    void testAssignTask() {
        Project project = this.projectRepo.findById(1);
        Task task = new Task();
        task.setName("Task 1");

        List<Task> listTasksBefore = new ArrayList<>(project.getAssignedTasks());

        this.projectService.assignTask(project, task);
        assertNotSame(listTasksBefore, project.getAssignedTasks());
    }

    @Test
    void testAssignProject() {

        Project project = this.projectRepo.findById(1);
        Project newProject = new Project();
        newProject.setName("Project ABC");

        List<Project> listProjectsBefore = new ArrayList<>(project.getAssignedProjects());

        this.projectService.assignProject(project, newProject);
        assertNotSame(listProjectsBefore, project.getAssignedProjects());
    }
}