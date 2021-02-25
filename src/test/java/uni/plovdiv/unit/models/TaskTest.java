package uni.plovdiv.unit.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task instance;

    /**
     * Init before each run
     */
    @BeforeEach
    void setUp() {
        this.instance = new Task();
    }

    /**
     * Tests getter & setter
     */
    @Test
    void testGetterSetterId() {
        instance.setId(123);
        assertEquals(123, instance.getId());
    }

    /**
     * Tests getter & setter
     */
    @Test
    void testGetterSetterName() {
        instance.setName("asd@@");
        assertEquals("asd@@", instance.getName());
    }

    /**
     * Tests task assigment
     */
    @Test
    void testAssignTask()
    {
        List<Task> parentTasksBefore = new ArrayList<>(this.instance.getAssignedTasks());
        this.instance.assignSubTask(new Task());
        assertNotEquals(parentTasksBefore, this.instance.getAssignedTasks());
    }

    /**
     * Tests getter & setter
     */
    @Test
    void testSetterGetterParentTask()
    {
        this.instance.setParentTask(new Task());
        assertNotNull(this.instance.getParentTask());
    }


    @Test
    void testSetterGetterProject()
    {
        this.instance.setProject(new Project());
        assertNotNull(this.instance.getProject());
    }

    /**
     * Tests getter & setter
     */
    @Test
    void testGetterSetterCreatedAt() {
        Date date = DateUtils.Time();
        instance.setCreatedAt(date);
        assertEquals(date, instance.getCreatedAt());
    }

    /**
     * Tests getter & setter
     */
    @Test
    void testGetterSetterUpdateAt() {
        Date date = DateUtils.Time();
        instance.setUpdatedAt(date);
        assertEquals(date, instance.getUpdatedAt());
    }

    /**
     * Tests getter & setter
     */
    @Test
    void testGetterSetterDeletedAt() {
        Date date = DateUtils.Time();
        instance.setDeletedAt(date);
        assertEquals(date, instance.getDeletedAt());
    }
}