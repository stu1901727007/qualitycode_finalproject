package uni.plovdiv.services.interfaces;

import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;

public interface EmployeeServiceInterface {

    /**
     *
     * @param firstName
     * @param lastName
     * @param role
     * @return
     */
    Employee createEmployee(String firstName, String lastName, EmployeeRoles role) throws IllegalArgumentException;

    /**
     *
     * @param employee
     * @return
     */
    Boolean deleteEmployee(Employee employee);
}
