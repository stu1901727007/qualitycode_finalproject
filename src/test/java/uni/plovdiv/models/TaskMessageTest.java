package uni.plovdiv.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskMessageTest {

    private TaskMessage instance;

    @BeforeEach
    void setUp() {
        this.instance = new TaskMessage();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTask() {
        Task task = new Task();
        instance.setTask(task);
        assertEquals(task, instance.getTask());
    }

    @Test
    void setTask() {
        Task task = new Task();
        instance.setTask(task);
        assertEquals(task, instance.getTask());
    }

    @Test
    void getStatus() {
        instance.setStatus(TaskStatus.COMPLETED);
        assertEquals(TaskStatus.COMPLETED, instance.getStatus());
    }

    @Test
    void setStatus() {
        instance.setStatus(TaskStatus.NEW);
        assertEquals(TaskStatus.NEW, instance.getStatus());
    }

    @Test
    void getMessage() {
        instance.setMessage("asd@@");
        assertEquals("asd@@", instance.getMessage());
    }

    @Test
    void setMessage() {
        instance.setMessage("abc1");
        assertEquals("abc1", instance.getMessage());
    }
}