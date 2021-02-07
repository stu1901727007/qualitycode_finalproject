package uni.plovdiv.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uni.plovdiv.models.Employee;
import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;
import uni.plovdiv.services.interfaces.TaskServiceInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class TaskServiceTest {

    private TaskServiceInterface taskService;
    private TaskRepoInterface taskRepo;

    @BeforeEach
    void setUp() {
        this.taskRepo = mock(TaskRepoInterface.class);

        Task task = new Task();
        task.setName("Task 1");

        List<Task> tasks = Arrays.asList(task);

        doReturn(tasks).when(this.taskRepo).findAll();
        doReturn(task).when(this.taskRepo).findById(1);

        this.taskService = new TaskService(this.taskRepo);
    }

    @AfterEach
    void tearDown() {
    }


    /**
     * @return
     */
    private static Stream<Arguments> NotValidTaskDetails() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("a", null),
                Arguments.of(null, new Project())
        );
    }

    @ParameterizedTest
    @MethodSource("NotValidTaskDetails")
    void testCreateTaskWithInvalidDetails(String name, Project project) {
        assertThrows(NullPointerException.class, () -> this.taskService.createTask(name, project));
    }

    @Test
    void testCreateTaskWithCorrectName() {
        assertTrue(this.taskService.createTask("Task 1", new Project()) instanceof Task);
    }

    @Test
    void testDeleteTask() {
        Task task = this.taskRepo.findById(1);
        this.taskService.deleteTask(task);
        assertNotNull(task.getDeletedAt());
    }

    @Test
    void testAssignSubTask() {

        Task task = this.taskRepo.findById(1);

        Task subTask = new Task();
        subTask.setName("Task 1");
        subTask.setParentTask(task);

        List<Task> parentTasksBefore = new ArrayList<>(task.getAssignedTasks());

        this.taskService.assignSubTask(task, subTask);
        assertNotEquals(parentTasksBefore, task.getAssignedTasks());
    }

    @Test
    void testChangeTaskStatusCompletedTask() throws Exception  {
        Task task = this.taskService.createTask("Test task", new Project());
        assertThrows(Exception.class, () -> this.taskService.changeTaskStatus(task, TaskStatus.COMPLETED, "some text"));
    }

    @Test
    void testChangeTaskStatusWithoutEmployeeTask() throws Exception  {
        Task task = this.taskService.createTask("Test task", new Project());
        assertThrows(Exception.class, () -> this.taskService.changeTaskStatus(task, TaskStatus.IN_PROGRESS, "some text"));
    }

    @Test
    void testChangeTaskStatusWithEmployeeTask() throws Exception  {
        Task task = this.taskService.createTask("Test task", new Project());
        task.setAssignedEmployee(new Employee());
        this.taskService.changeTaskStatus(task, TaskStatus.IN_PROGRESS, "some text");

        assertEquals(task.getCurrentStatus(), TaskStatus.IN_PROGRESS);
    }

    @Test
    void assignEmployee() {
    }
}