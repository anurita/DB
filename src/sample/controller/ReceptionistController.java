package sample.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.models.Patient;
import sample.models.Receptionist;


import java.sql.Date;
import java.sql.SQLException;
public class ReceptionistController {
    @FXML
    private TableView patientTable;
    @FXML
    private TableColumn<Patient, Integer>  patIdColumn;
    @FXML
    private TableColumn<Patient, String>  patNameColumn;
    @FXML
    private TableColumn<Patient, Integer> patageColumn;
    @FXML
    private TableColumn<Patient, String> patAddressColumn;
    @FXML
    private TableColumn<Patient, Integer> patPhoneColumn;
    @FXML
    private TextField txtName;
    @FXML
    private TextArea txtAddr;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtage;

    @FXML
    private void searchPatients(ActionEvent actionEvent) throws Exception{
        try {
            ObservableList<Patient> patData = Receptionist.searchPatients();
            populatePatients(patData);
        } catch (SQLException e){

            throw e;
        }
    }
    @FXML
    private void addPatients(ActionEvent actionEvent) throws Exception{
        Receptionist.addPatient(txtName.getText(), txtAddr.getText(), Integer.parseInt(txtage.getText()),
                Integer.parseInt(txtPhone.getText()));
    }
    @FXML
    private void initialize () {

        patIdColumn.setCellValueFactory(cellData -> cellData.getValue().patientIdProperty().asObject());
        patNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        patAddressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        patageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        patPhoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());
    }

    @FXML
    private void populatePatients (ObservableList<Patient> patData) throws ClassNotFoundException {
        //Set items to the patientTable
        patientTable.setItems(patData);
    }


}
