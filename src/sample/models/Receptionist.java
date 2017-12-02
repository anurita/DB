package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Utility.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Receptionist {
    public static ObservableList<Patient> searchPatients() throws Exception {
        String selectStmt = "SELECT * FROM Patient";
        try {
            ResultSet patients = Utility.execute(selectStmt);
            ObservableList<Patient> patList = getPatientList(patients);
            return patList;
        } catch (SQLException e) {
            throw e;
        }
    }

    private static ObservableList<Patient> getPatientList(ResultSet rs) throws Exception {
        ObservableList<Patient> patList = FXCollections.observableArrayList();
        while (rs.next()) {
            Patient pat = new Patient();
            pat.setPatientId(rs.getInt("PatientId"));
            pat.setName(rs.getString("name"));
            pat.setAddress(rs.getString("Address"));
            pat.setAge(rs.getInt("age"));
            pat.setPhone(rs.getInt("Phone"));
            patList.add(pat);
        }
        return patList;
    }

    public static void addPatient(String name, String addr, Integer age, Integer Phone, Integer DoctorId) throws Exception {
        String query = "{call Hospital_Managment_System.addPatient(?,?,?,?,?)}";


        try {


            Utility.executeProc(query,name,addr,age,Phone,DoctorId);
            int i = 1;

        } catch (Exception e) {
            throw e;
        }
    }


}


