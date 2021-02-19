package uni.plovdiv.models;

import java.util.Date;

/**
 * Employee entity
 */
public class Employee {

    /**
     * Unique id, autoincrement
     */
    private int id;

    /**
     * Employee first name
     */
    private String firstName;

    /**
     * Employee last name
     */
    private String lastName;

    /**
     * Employee role
     */
    private EmployeeRoles role;

    /**
     * The date of creation
     */
    private Date createdAt;

    /**
     * The date of last update
     */
    private Date updatedAt;

    /**
     * Soft delete flag. The date record has been deleted.
     */
    private Date deletedAt;


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
