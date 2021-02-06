package uni.plovdiv.repositories.interfaces;

import uni.plovdiv.models.Employee;

import java.util.List;

public interface EmployeeRepoInterface {

    /**
     *
     * @return
     */
    List<Employee> findAll();

    /**
     *
     * @param id
     * @return
     */
    Employee findById(int id);

}
