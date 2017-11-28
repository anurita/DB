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
    private TextField txtName;
    @FXML
    private TextArea txtAddr;
    @FXML
    private TextField txtSSN;
    @FXML
    private TextField txtSalary;
    @FXML
    private TextField txtDate;


    @FXML
    private void searchEmployees(ActionEvent actionEvent) throws Exception{
        try {
            ObservableList<Employee> empData = EmployeeUtil.searchEmployees();
            populateEmployees(empData);
        } catch (SQLException e){

            throw e;
        }
    }


    @FXML
    private void addEmployees(ActionEvent actionEvent) throws Exception{
        EmployeeUtil.addEmployee(txtName.getText(), txtAddr.getText(), Integer.parseInt(txtSalary.getText()),
                Integer.parseInt(txtSSN.getText()), txtDate.getText());
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

    @FXML
    private void populateEmployees (ObservableList<Employee> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }


}