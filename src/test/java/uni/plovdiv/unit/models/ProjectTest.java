package uni.plovdiv.unit.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Project;
import uni.plovdiv.utils.DateUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project instance;

    /**
     * Init before each run
     */
    @BeforeEach
    void setUp() {
        this.instance = new Project();
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