package uni.plovdiv.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.utils.DateUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project instance;

    @BeforeEach
    void setUp() {
        this.instance = new Project();
    }

    @Test
    void testGetterSetterId() {
        instance.setId(123);
        assertEquals(123, instance.getId());
    }

    @Test
    void testGetterSetterName() {
        instance.setName("asd@@");
        assertEquals("asd@@", instance.getName());
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

    @Test
    void testGetterSetterDeletedAt() {
        Date date = DateUtils.Time();
        instance.setDeletedAt(date);
        assertEquals(date, instance.getDeletedAt());
    }
}