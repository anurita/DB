package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Utility.Utility;
import sample.models.DoctorPatient;

import java.sql.ResultSet;

/**
 * Created by anu on 11/27/2017.
 */
public class DoctorPatientController {

    @FXML
    private TextField txtPatId;
    @FXML
    private TextField txtDiag;

    @FXML
    private TableView patientDiagnosisTable;
    @FXML
    private TableColumn<DoctorPatient, Integer> patIdColumn;
    @FXML
    private TableColumn<DoctorPatient, String> diagColumn;
    private Stage primaryStage = new Stage();
    @FXML
    private Label lblDocId;

    @FXML
    private void initialize() {
        patIdColumn.setCellValueFactory(cellData -> cellData.getValue().PatientIdProperty().asObject());
        diagColumn.setCellValueFactory(cellData -> cellData.getValue().DiagnosisProperty());

    }

    @FXML
    private void showPatient(ActionEvent actionEvent) throws Exception {
        try {
            String selectStmt = "SELECT * FROM Doctor_Patient where DoctorId = " + Integer.parseInt(lblDocId.getText());
            ResultSet patients = Utility.execute(selectStmt);
            ObservableList<DoctorPatient> patList = getPatientList(patients);
            populatePatients(patList);


        } catch (Exception e) {

            throw e;
        }
    }

    @FXML
    private void updatePatient() {
        try {
            Integer patientId = Integer.parseInt(txtPatId.getText());
            String diagnosis = txtDiag.getText();
            String stmt = "Update Doctor_Patient set Diagnosis= '" + diagnosis + "' where PatientId = " + patientId;
            Utility.update(stmt);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void populatePatients(ObservableList<DoctorPatient> patData) throws ClassNotFoundException {
        //Set items to the DoctorPatientTable
        patientDiagnosisTable.setItems(patData);
    }

    private static ObservableList<DoctorPatient> getPatientList(ResultSet rs) throws Exception {
        ObservableList<DoctorPatient> patList = FXCollections.observableArrayList();
        while (rs.next()) {
            DoctorPatient pat = new DoctorPatient();
            pat.setPatientId(rs.getInt("PatientId"));
            pat.setDiagnosis(rs.getString("Diagnosis"));
            patList.add(pat);
        }
        return patList;
    }

}
