package uni.plovdiv.unit.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;
import uni.plovdiv.services.EmployeeService;
import uni.plovdiv.services.interfaces.EmployeeServiceInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class EmployeeServiceTest {

    private EmployeeRepoInterface employeeRepo;
    private EmployeeServiceInterface employeeService;

    /**
     * Init before each run
     */
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

        this.employeeService = new EmployeeService(this.employeeRepo);
    }

    /**
     * Streams arguments to test employee creations process
     *
     * @return Stream<Arguments>
     */
    private static Stream<Arguments> NotValidEmployerDetails() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of("a", null, null),
                Arguments.of("a", "b", null),
                Arguments.of(null, "b", null),
                Arguments.of("b", null, EmployeeRoles.REGULAR_DEVELOPER),
                Arguments.of(null, null, EmployeeRoles.REGULAR_DEVELOPER),
                Arguments.of("a", "b", null)
        );
    }

    /**
     * Tests not valid employee details
     *
     * @param firstName String representation of first name
     * @param lastName String representation of last name
     * @param role String representation of role
     */
    @ParameterizedTest
    @MethodSource("NotValidEmployerDetails")
    void testCreateEmployeeWithInvalidDetails(String firstName, String lastName, EmployeeRoles role) {
        assertThrows(NullPointerException.class, ()-> this.employeeService.createEmployee(firstName, lastName, role));
    }

    /**
     * Tests creation of employee with valid details
     */
    @Test
    void testCreateEmployeeWithValidDetails() {
        assertTrue(this.employeeService.createEmployee("a", "b", EmployeeRoles.REGULAR_DEVELOPER) instanceof Employee);
    }

    /**
     * Tests employee deletion
     */
    @Test
    void testDeleteEmployee() {
        Employee employee = this.employeeRepo.findById(1);
        this.employeeService.deleteEmployee(employee);
        assertNotNull(employee.getDeletedAt());
    }
}