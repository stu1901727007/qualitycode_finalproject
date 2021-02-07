package uni.plovdiv.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;
import uni.plovdiv.services.EmployeeService;
import uni.plovdiv.services.interfaces.EmployeeServiceInterface;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class EmployeeRepoTest {

    private EmployeeRepoInterface employeeRepo;

    @BeforeEach
    void setUp() {

        this.employeeRepo = mock(EmployeeRepoInterface.class);

        Employee employee = new Employee();
        employee.setFirstName("Vitali");
        employee.setLastName("Atias");
        employee.setRole(EmployeeRoles.REGULAR_DEVELOPER);

        List<Employee> employees = Arrays.asList(employee);

        doReturn(employees).when(this.employeeRepo).findAll();
        doReturn(employee).when(this.employeeRepo).findById(1);
    }

    @Test
    void findAll() {

        List<Employee> employee = this.employeeRepo.findAll();
        assertNotNull(employee);
    }

    @Test
    void findById() {

        Employee employee = this.employeeRepo.findById(1);
        assertEquals("Vitali", employee.getFirstName());
    }
}