package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Utility;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeUtil {

    public static ObservableList<Employee> searchEmployees() throws Exception {
        String selectStmt = "SELECT * FROM Employee;";
        try {

            ResultSet rsEmps = Utility.execute(selectStmt);
            ObservableList<Employee> empList = getEmployeeList(rsEmps);
            return empList;
        } catch (SQLException e) {

            throw e;
        }
    }

    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("EmployeeId"));
            employee.setName(rs.getString("Name"));
            employee.setAddress(rs.getString("Address"));
            employee.setDateOfJoining(rs.getString("Date_Of_Joining"));
            employee.setSalary(rs.getInt("Salary"));
            employees.add(employee);
        }
        return employees;
    }

}
