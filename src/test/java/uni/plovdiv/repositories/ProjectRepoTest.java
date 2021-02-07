package uni.plovdiv.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.models.Project;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;
import uni.plovdiv.repositories.interfaces.ProjectRepoInterface;
import uni.plovdiv.services.ProjectService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ProjectRepoTest {

    private ProjectRepoInterface projectRepo;

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
    }

    @Test
    void findAll() {

        List<Project> projects = this.projectRepo.findAll();
        assertNotNull(projects);
    }

    @Test
    void findById() {

        Project project = this.projectRepo.findById(1);
        assertEquals("Project 2", project.getName());
    }
}