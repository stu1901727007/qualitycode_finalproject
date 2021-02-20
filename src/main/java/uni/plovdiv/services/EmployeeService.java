package uni.plovdiv.services;

import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;
import uni.plovdiv.services.interfaces.EmployeeServiceInterface;
import uni.plovdiv.utils.DateUtils;

import java.util.Objects;

/**
 * Employee's services
 * Keeps the base logic to manipulate Employees
 */
public class EmployeeService implements EmployeeServiceInterface {

    final EmployeeRepoInterface employeeRepo;

    /**
     * Constructor
     * @param employeeRepo instance of EmployeeRepoInterface
     */
    public EmployeeService(EmployeeRepoInterface employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /**
     * Create new employee
     *
     * @param firstName String representation for first name. Valid not {@code NULL} or
     *                  empty String
     * @param lastName  String representation for last name. Valid not {@code NULL} or
     *                  empty String
     * @param role      Object instance of EmployeeRoles. Valid not {@code NULL}
     * @return Employee object
     * @throws NullPointerException
     */
    @Override
    public Employee createEmployee(String firstName, String lastName, EmployeeRoles role) throws NullPointerException {

        Employee employee = new Employee();

        employee.setFirstName(Objects.requireNonNull(firstName, "Въведете валидно име"));
        employee.setLastName(Objects.requireNonNull(lastName, "Въведете валидно презиме"));
        employee.setRole(Objects.requireNonNull(role, "Въведете валидна роля"));
        employee.setCreatedAt(DateUtils.Time());
        employee.setUpdatedAt(DateUtils.Time());

        this.employeeRepo.save(employee);

        return employee;
    }

    /**
     * Delete employee. The method is going to change the flag deletedAt
     *
     * @param employee Object instance of Employee. Valid not {@code NULL}
     * @return Boolean true|false
     */
    @Override
    public Boolean deleteEmployee(Employee employee) {

        employee.setDeletedAt(DateUtils.Time());

        this.employeeRepo.save(employee);

        return true;
    }
}
