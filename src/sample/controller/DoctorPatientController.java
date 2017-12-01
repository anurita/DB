package sample.controller;

        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.AnchorPane;
        import javafx.stage.Stage;
        import sample.Main;
        import sample.Utility.Utility;
        import sample.models.DoctorPatient;
        import sample.models.Employee;
        import sample.models.Patient;

        import java.sql.ResultSet;
        import java.sql.SQLException;

/**
 * Created by anu on 11/27/2017.
 */
public class DoctorPatientController {

    @FXML
    private TextField patientId;
    @FXML
    private TextField diagnosis;

    @FXML
    private TableView patientDiagnosisTable;
    @FXML
    private TableColumn<DoctorPatient, Integer> patIdColumn;
    @FXML
    private TableColumn<DoctorPatient, String>  diagColumn;
    private Stage primaryStage = new Stage();
    @FXML
    private void initialize()
    {
        patIdColumn.setCellValueFactory(cellData -> cellData.getValue().PatientIdProperty().asObject());
        diagColumn.setCellValueFactory(cellData -> cellData.getValue().DiagnosisProperty());

    }

    @FXML
    private void searchPatient(ActionEvent actionEvent) throws Exception{
        try {
            //ObservableList<DoctorPatient> patData = PatientUtil.searchPatients();
            //populatePatients(patData);
        } catch (Exception e){

            throw e;
        }
    }

    @FXML
    private void ViewPatient()
    {
        try {
            Integer PatientId = Integer.parseInt(patientId.getText());
            String Diagnosis = diagnosis.getText();
            String stmt = "Select * from DoctorPatient";
            ResultSet rs = Utility.execute(stmt);
                if (rs.isBeforeFirst()) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/DoctorView.fxml"));
                    primaryStage.setTitle("Doctor Details");
                    AnchorPane doctorView = (AnchorPane) loader.load();

                    Scene scene = new Scene(doctorView); //We are sending rootLayout to the Scene.
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
        private void updatePatient(ActionEvent actionEvent) throws Exception{
           // PatientUtil.updatePatient(txtPatId.getText(), txtDig.getText());
        }

        @FXML
            private void populatePatients (ObservableList<DoctorPatient> docData) throws ClassNotFoundException {
                //Set items to the DoctorPatientTable
            patientDiagnosisTable.setItems(docData);
            }
}
