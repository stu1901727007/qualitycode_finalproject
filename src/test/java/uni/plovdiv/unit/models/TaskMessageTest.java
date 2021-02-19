package uni.plovdiv.unit.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testGetterSetterId() {
        instance.setId(123);
        assertEquals(123, instance.getId());
    }

    @Test
    void testGetterSetterParentTask() {
        Task task = new Task();
        instance.setTask(task);
        assertEquals(task, instance.getTask());
    }

    @Test
    void testGetterSetterStatus() {
        instance.setStatus(TaskStatus.NEW);
        assertEquals(TaskStatus.NEW, instance.getStatus());
    }

    @Test
    void testGetterSetterMessage() {
        instance.setMessage("asd@@");
        assertEquals("asd@@", instance.getMessage());
    }

    @Test
    void testGetterSetterCreatedAt() {
        Date date = DateUtils.Time();
        instance.setCreatedAt(date);
        assertEquals(date, instance.getCreatedAt());
    }

    @Test
    void testGetterSetterUpdateAt() {
        Date date = DateUtils.Time();
        instance.setUpdatedAt(date);
        assertEquals(date, instance.getUpdatedAt());
    }
}