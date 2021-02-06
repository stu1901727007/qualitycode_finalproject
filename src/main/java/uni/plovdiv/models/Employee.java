package uni.plovdiv.models;

public class Employee {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private EmployeeRoles role;

    /**
     *
     * @param firstName
     * @param lastName
     * @param role
     */
    public Employee(String firstName, String lastName, EmployeeRoles role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeRoles getRole() {
        return role;
    }

    public void setRole(EmployeeRoles role) {
        this.role = role;
    }
}
