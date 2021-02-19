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

    @BeforeEach
    void setUp() {
        this.taskRepo = new TaskRepo();

        Task task = new Task();

        task.setName("TASK 1");
        task.setProject(new Project());

        this.taskRepo.save(task);
    }

    @Test
    void findAll() {
        List<Task> tasks = this.taskRepo.findAll();
        assertNotNull(tasks);
    }

    @Test
    void findByIdSuccess() {

        Task task = this.taskRepo.findById(1);
        assertEquals("TASK 1", task.getName());
    }

    @Test
    void findByIdNull() {
        Task task = this.taskRepo.findById(11);
        assertNull(task);
    }

    @Test
    void testSaveNew() {
        Task task = new Task();
        task.setName("M1");
        this.taskRepo.save(task);

        assertEquals(2, task.getId());
    }

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