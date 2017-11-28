package sample.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;
/**
 * Created by anu on 11/26/2017.
 */
public class Employee {
    IntegerProperty employeeId;
    StringProperty name;
    StringProperty address;
    StringProperty password;
    StringProperty dateOfJoining;
    IntegerProperty salary;
    IntegerProperty SSN;

    public Employee() {
        this.employeeId = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.dateOfJoining = new SimpleStringProperty();
        this.salary = new SimpleIntegerProperty();
        this.SSN = new SimpleIntegerProperty();
    }

    public int getEmployeeId() {
        return employeeId.get();
    }

    public IntegerProperty employeeIdProperty() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId.set(employeeId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getDateOfJoining() {
        return dateOfJoining.get();
    }

    public StringProperty dateOfJoiningProperty() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining.set(dateOfJoining);
    }

    public int getSalary() {
        return salary.get();
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    public int getSSN() {
        return SSN.get();
    }

    public IntegerProperty SSNProperty() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN.set(SSN);
    }
}
