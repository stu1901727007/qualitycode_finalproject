package uni.plovdiv.services;

import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;
import uni.plovdiv.services.interfaces.EmployeeServiceInterface;
import uni.plovdiv.utils.DateUtils;

import java.util.Objects;

public class EmployeeService implements EmployeeServiceInterface {

    final EmployeeRepoInterface employeeRepo;

    /**
     * @param employeeRepo
     */
    public EmployeeService(EmployeeRepoInterface employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee createEmployee(String firstName, String lastName, EmployeeRoles role) throws NullPointerException {

        Employee employee = new Employee();

        employee.setFirstName(Objects.requireNonNull(firstName, "Въведете валидно име"));
        employee.setLastName(Objects.requireNonNull(lastName, "Въведете валидно презиме"));
        employee.setRole(Objects.requireNonNull(role, "Въведете валидна роля"));
        employee.setCreatedAt(DateUtils.Time());
        employee.setUpdatedAt(DateUtils.Time());

        //this.employeeRepo.save(employee); //if there is a database

        return employee;

    }

    @Override
    public Boolean deleteEmployee(Employee employee) {

        employee.setDeletedAt(DateUtils.Time());

        //this.employeeRepo.save(employee); //if there is a database

        return true;
    }
}
