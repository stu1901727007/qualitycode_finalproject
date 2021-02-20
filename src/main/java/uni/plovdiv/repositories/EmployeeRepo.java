package uni.plovdiv.repositories;

import uni.plovdiv.models.Employee;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Employees repository
 */
public class EmployeeRepo implements EmployeeRepoInterface {

    /**
     * List with records
     */
    private List<Employee> employees = new ArrayList<>();

    /**
     * Fetch all employees
     *
     * @return List with all employees
     */
    @Override
    public List<Employee> findAll() {
        return this.employees;
    }

    /**
     * Fetch employee based on the @param id
     *
     * @param id Represents the unique number from employees. Valid not {@code NULL}
     * @return Employee object
     */
    @Override
    public Employee findById(int id) {

        Optional<Employee> employee = this.employees.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (employee.isPresent())
            return employee.get();
        else
            return null;
    }

    /**
     * Saves changes to the List
     *
     * @param employee Object instance of Employee. Valid not {@code NULL}
     * @return
     */
    @Override
    public Employee save(Employee employee) {

        if (employee.getId() == 0) {
            employee.setId((int) (this.employees.size() + 1));
            this.employees.add(employee);
        } else {
            this.employees.set(employee.getId() - 1, employee);
        }

        return employee;
    }
}
