package uni.plovdiv.services;

import uni.plovdiv.models.*;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;
import uni.plovdiv.services.interfaces.EmployeeServiceInterface;
import uni.plovdiv.services.interfaces.TaskMessageServiceInterface;

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
            throw new IllegalArgumentException("Please provide valid first name");

        if( lastName == null )
            throw new IllegalArgumentException("Please provide valid last name");

        Employee employee = new Employee();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setRole(role);
        employee.setCreatedAt(new Date());
        employee.setUpdatedAt(new Date());

        //this.employeeRepo.save(employee); //if there is a database

        return employee;

    }

    @Override
    public Boolean deleteEmployee(Employee employee) {

        employee.setDeletedAt(new Date());

        //this.employeeRepo.save(employee); //if there is a database

        return true;
    }
}
