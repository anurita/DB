package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Utility.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeUtil {

    public static ObservableList<Employee> searchEmployees() throws Exception {
        String selectStmt = "SELECT * FROM Employee";
        try {
            ResultSet employees = Utility.execute(selectStmt);
            ObservableList<Employee> empList = getEmployeeList(employees);
            return empList;
        } catch (SQLException e) {
            throw e;
        }
    }

    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws Exception {
        ObservableList<Employee> empList = FXCollections.observableArrayList();
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmployeeId(rs.getInt("EmployeeId"));
            emp.setName(rs.getString("Name"));
            emp.setAddress(rs.getString("Address"));
            emp.setSalary(rs.getInt("Salary"));
            emp.setDateOfJoining(rs.getString("Date_Of_Joining"));
            emp.setPassword(rs.getString("Password"));
            empList.add(emp);
        }
        return empList;
    }

    public static void addEmployee(String name, String addr, Integer salary, Integer SSN, String date) throws Exception {
        String query = "{ call Hospital_Managment_System.GetMaxId()}";

        //String insertStmt = "Insert into Employee(Name, Address, Salary, SSN, Date_Of_Joining) values (" +
          //      name + "," + addr + "," + salary + "," + SSN + "," + date;
        try {
           // Utility.update(insertStmt);

            ResultSet id = Utility.executeProcedure(query);
            int i = 1;

        } catch (Exception e) {
            throw e;
        }
    }
}
