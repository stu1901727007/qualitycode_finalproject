package uni.plovdiv.unit.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.repositories.TaskRepo;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskRepoTest {

    private TaskRepoInterface taskRepo;

    /**
     * Init before each run
     */
    @BeforeEach
    void setUp() {
        this.taskRepo = new TaskRepo();

        Task task = new Task();

        task.setName("TASK 1");
        task.setProject(new Project());

        this.taskRepo.save(task);
    }

    /**
     * Tests find all
     */
    @Test
    void findAll() {
        List<Task> tasks = this.taskRepo.findAll();
        assertNotNull(tasks);
    }

    /**
     * Tests find by id with successful result
     */
    @Test
    void findByIdSuccess() {

        Task task = this.taskRepo.findById(1);
        assertEquals("TASK 1", task.getName());
    }

    /**
     * Tests find by id with null result
     */
    @Test
    void findByIdNull() {
        Task task = this.taskRepo.findById(11);
        assertNull(task);
    }

    /**
     * Tests save new record
     */
    @Test
    void testSaveNew() {
        Task task = new Task();
        task.setName("M1");
        this.taskRepo.save(task);

        assertEquals(2, task.getId());
    }

    /**
     * Tests save with update
     */
    @Test
    void testSaveUpdate() {
        Task task = new Task();
        task.setName("T1");
        this.taskRepo.save(task);

        task = this.taskRepo.save(task);

        task.setName("T2");
        task = this.taskRepo.save(task);

        assertEquals(2, task.getId());
    }
}