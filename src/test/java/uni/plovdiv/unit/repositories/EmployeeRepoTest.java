package uni.plovdiv.unit.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.repositories.EmployeeRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeRepoTest {

    private EmployeeRepo employeeRepo;

    /**
     * Init before each run
     */
    @BeforeEach
    void setUp() {
        this.employeeRepo = new EmployeeRepo();

        Employee employee = new Employee();
        employee.setFirstName("a");
        employee.setLastName("b");
        employee.setRole(EmployeeRoles.REGULAR_DEVELOPER);

        this.employeeRepo.save(employee);
    }

    /**
     * Tests find all
     */
    @Test
    void findAll() {
        List<Employee> employee = this.employeeRepo.findAll();
        assertNotNull(employee);
    }

    /**
     * Tests find by id with successful result
     */
    @Test
    void findByIdSuccess() {
        Employee employee = this.employeeRepo.findById(1);
        assertEquals("a", employee.getFirstName());
    }

    /**
     * Tests find by id with null result
     */
    @Test
    void findByIdNull() {
        Employee employee = this.employeeRepo.findById(11);
        assertNull(employee);
    }

    /**
     * Tests save new record
     */
    @Test
    void testSaveNew() {
        Employee employee = new Employee();
        employee.setFirstName("a1");
        employee.setLastName("b1");
        employee.setRole(EmployeeRoles.REGULAR_DEVELOPER);
        this.employeeRepo.save(employee);

        assertEquals(2, employee.getId());
    }

    /**
     * Tests save with update
     */
    @Test
    void testSaveUpdate() {
        Employee employee = new Employee();
        employee.setFirstName("a2");
        employee.setLastName("b2");
        employee.setRole(EmployeeRoles.REGULAR_DEVELOPER);

        employee = this.employeeRepo.save(employee);

        employee.setLastName("c1");
        employee = this.employeeRepo.save(employee);

        assertEquals(2, employee.getId());
    }
}