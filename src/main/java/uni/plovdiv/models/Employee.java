package uni.plovdiv.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Employee entity
 */
@Setter
@Getter
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

}
