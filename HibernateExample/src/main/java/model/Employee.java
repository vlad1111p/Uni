package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int employeeId;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "employeesList")
    private List<Project> projectsList;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Project> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<Project> projectsList) {
        this.projectsList = projectsList;
    }
}
