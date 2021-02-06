package uni.plovdiv.repositories;

import uni.plovdiv.models.Employee;
import uni.plovdiv.repositories.interfaces.EmployeeRepoInterface;

import java.util.Collections;
import java.util.List;

public class EmployeeRepo implements EmployeeRepoInterface {

    /**
     *
     * @return
     */
    @Override
    public List<Employee> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Employee findById(int id) {
        return null;
    }
}
