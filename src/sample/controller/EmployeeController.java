package sample.controller;

import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.models.Employee;
import sample.models.EmployeeUtil;

import javax.xml.soap.Text;
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
    private TableColumn<Employee, String> empRoleColumn;
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
    private TextField txtRole;
    @FXML
    private TextField txtIdDel;

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
                Integer.parseInt(txtSSN.getText()), txtDate.getText(), txtRole.getText());
    }
    @FXML
    private void initialize () {

        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        empAddressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        empSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());
        empSSNColumn.setCellValueFactory(cellData -> cellData.getValue().SSNProperty().asObject());
        empHireDateColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfJoiningProperty());
        empRoleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        empPasswordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());

    }

    @FXML
    private void populateEmployees (ObservableList<Employee> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }


    @FXML
    private void deleteEmployee(ActionEvent actionEvent) throws Exception{
        EmployeeUtil.addEmployee(txtName.getText(), txtAddr.getText(), Integer.parseInt(txtSalary.getText()),
                Integer.parseInt(txtSSN.getText()), txtDate.getText(), txtRole.getText());
    }

}