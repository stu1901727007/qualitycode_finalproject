package uni.plovdiv.unit.services;

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
import uni.plovdiv.services.TaskService;
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

    /**
     * Init before each run
     */
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

    /**
     * Streams arguments to test tasks creations process
     *
     * @return Stream<Arguments>
     */
    private static Stream<Arguments> NotValidTaskDetails() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("a", null),
                Arguments.of(null, new Project())
        );
    }

    /**
     * Tests not valid task details
     *
     * @param name String representation of name
     * @param project representation of Project
     */
    @ParameterizedTest
    @MethodSource("NotValidTaskDetails")
    void testCreateTaskWithInvalidDetails(String name, Project project) {
        assertThrows(NullPointerException.class, () -> this.taskService.createTask(name, project));
    }

    /**
     * Tests creation of task with valid details
     */
    @Test
    void testCreateTaskWithCorrectName() {
        assertTrue(this.taskService.createTask("Task 1", new Project()) instanceof Task);
    }

    /**
     * Test task deletion
     */
    @Test
    void testDeleteTask() {
        Task task = this.taskRepo.findById(1);
        this.taskService.deleteTask(task);
        assertNotNull(task.getDeletedAt());
    }

    /**
     * Tests subtask assigment
     */
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

    /**
     * Test changing task status to completed
     *
     * @throws Exception
     */
    @Test
    void testChangeTaskStatusToCompletedTask() throws Exception  {
        Task task = this.taskService.createTask("Test task", new Project());

        task.setAssignedEmployee(new Employee());
        task.setCurrentStatus( TaskStatus.COMPLETED );

        assertThrows(Exception.class, () -> this.taskService.changeTaskStatus(task, TaskStatus.IN_PROGRESS, "some text"));
    }

    /**
     * Tests task status change without assigned employee
     *
     * @throws Exception
     */
    @Test
    void testChangeTaskStatusWithoutEmployeeTask() throws Exception  {
        Task task = this.taskService.createTask("Test task", new Project());
        assertThrows(Exception.class, () -> this.taskService.changeTaskStatus(task, TaskStatus.IN_PROGRESS, "some text"));
    }

    /**
     * Tests task status change with assigned employee
     *
     * @throws Exception
     */
    @Test
    void testChangeTaskStatusWithEmployeeTask() throws Exception  {
        Task task = this.taskService.createTask("Test task", new Project());
        task.setAssignedEmployee(new Employee());
        this.taskService.changeTaskStatus(task, TaskStatus.IN_PROGRESS, "some text");

        assertEquals(task.getCurrentStatus(), TaskStatus.IN_PROGRESS);
    }

    /**
     * Tests employee assigment
     *
     * @throws Exception
     */
    @Test
    void testAssignEmployee() {

        Task task = this.taskRepo.findById(1);
        this.taskService.assignEmployee(task, new Employee());
        assertNotNull(task.getAssignedEmployee());
    }
}