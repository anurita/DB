package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.models.Employee;
import sample.models.EmployeeUtil;
import java.sql.Date;
import java.sql.SQLException;

public class EmployeeController {
    @FXML
    private TextField empId;
    @FXML
    private TextArea address;
    @FXML
    private TextField name;
    @FXML
    private TextField nameText;
    @FXML
    private TextField password;
    @FXML
    private TextField salary;
    @FXML
    private TextField SSN;
    @FXML
    private TableView employeeTable;
    @FXML
    private TableColumn<Employee, Integer>  empIdColumn;
    @FXML
    private TableColumn<Employee, String>  empNameColumn;
    @FXML
    private TableColumn<Employee, String> empAddressColumn;
    @FXML
    private TableColumn<Employee, String> empPasswordColumn;
    @FXML
    private TableColumn<Employee, Integer> empSalaryColumn;
    @FXML
    private TableColumn<Employee, String> empHireDateColumn;
    @FXML
    private TableColumn<Employee, Integer> empSSNColumn;


    @FXML
    private void searchEmployees(ActionEvent actionEvent) throws Exception{
        try {
            //Get all Employees information
            ObservableList<Employee> empData = EmployeeUtil.searchEmployees();

            populateEmployees(empData);
        } catch (SQLException e){

            throw e;
        }
    }


    @FXML
    private void initialize () {

        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        empAddressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        empSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());
        empSSNColumn.setCellValueFactory(cellData -> cellData.getValue().SSNProperty().asObject());
        empHireDateColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfJoiningProperty());
    }

    //Populate Employee
    @FXML
    private void populateEmployee (Employee emp) throws ClassNotFoundException {


    }
        //Populate Employees for TableView
    @FXML
    private void populateEmployees (ObservableList<Employee> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }


}