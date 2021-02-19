package uni.plovdiv.unit.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.repositories.TaskMessageRepo;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskMessageRepoTest {

    private TaskMessageRepoInterface taskMessageRepo;

    @BeforeEach
    void setUp() {
        this.taskMessageRepo = new TaskMessageRepo();

        TaskMessage message = new TaskMessage();

        message.setStatus(TaskStatus.NEW);
        message.setMessage("MTEST");
        message.setTask(new Task());

        this.taskMessageRepo.save(message);
    }

    @Test
    void findAll() {
        List<TaskMessage> messages = this.taskMessageRepo.findAll();
        assertNotNull(messages);
    }

    @Test
    void findByIdSuccess() {

        TaskMessage message = this.taskMessageRepo.findById(1);
        assertEquals("MTEST", message.getMessage());
    }

    @Test
    void findByIdNull() {
        TaskMessage message = this.taskMessageRepo.findById(11);
        assertNull(message);
    }

    @Test
    void testSaveNew() {
        TaskMessage message = new TaskMessage();
        message.setMessage("M1");
        this.taskMessageRepo.save(message);

        assertEquals(2, message.getId());
    }

    @Test
    void testSaveUpdate() {
        TaskMessage message = new TaskMessage();
        message.setMessage("M1");
        this.taskMessageRepo.save(message);

        message = this.taskMessageRepo.save(message);

        message.setMessage("M2");
        message = this.taskMessageRepo.save(message);

        assertEquals(2, message.getId());
    }
}