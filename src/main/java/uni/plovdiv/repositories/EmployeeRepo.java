package uni.plovdiv.repositories;

import uni.plovdiv.models.Employee;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;

import java.util.Collections;
import java.util.List;

/**
 * Employees repository
 */
public class EmployeeRepo implements EmployeeRepoInterface {

    /**
     * Fetch all employees
     * @return List with all employees
     */
    @Override
    public List<Employee> findAll() {
        return Collections.emptyList();
    }

    /**
     * Fetch employee based on the @param id
     * @param id
     * @return Employee object
     */
    @Override
    public Employee findById(int id) {
        return null;
    }
}
