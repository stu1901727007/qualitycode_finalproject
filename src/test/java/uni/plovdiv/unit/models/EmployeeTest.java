package uni.plovdiv.unit.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.utils.DateUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    private Employee instance;

    /**
     * Init before each run
     */
    @BeforeEach
    void setUp() {
        this.instance = new Employee();
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
    void testGetterSetterFirstName() {
        instance.setFirstName("a");
        assertEquals("a", instance.getFirstName());
    }

    /**
     * Tests getter & setter
     */
    @Test
    void testGetterSetterLastName() {
        instance.setLastName("b");
        assertEquals("b", instance.getLastName());
    }

    /**
     * Tests getter & setter
     */
    @Test
    void testGetterSetterRole() {
        instance.setRole(EmployeeRoles.REGULAR_DEVELOPER);
        assertEquals(EmployeeRoles.REGULAR_DEVELOPER, instance.getRole());
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