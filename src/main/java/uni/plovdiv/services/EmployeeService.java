package uni.plovdiv.services;

import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;
import uni.plovdiv.services.interfaces.EmployeeServiceInterface;
import uni.plovdiv.utils.DateUtils;

import java.util.Date;

public class EmployeeService implements EmployeeServiceInterface {

    final EmployeeRepoInterface employeeRepo;

    /**
     * @param employeeRepo
     */
    public EmployeeService(EmployeeRepoInterface employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee createEmployee(String firstName, String lastName, EmployeeRoles role) throws IllegalArgumentException {

        if( firstName == null )
            throw new IllegalArgumentException("Въведете валидно име");

        if( lastName == null )
            throw new IllegalArgumentException("Въведете валидно презиме");

        if( role == null )
            throw new IllegalArgumentException("Въведете валидна роля");

        Employee employee = new Employee();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setRole(role);
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
