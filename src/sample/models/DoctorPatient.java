package sample.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class DoctorPatient {
    IntegerProperty PatientId;
    IntegerProperty DoctorId;
    StringProperty Diagnosis;

    public DoctorPatient() {
        this.PatientId = new SimpleIntegerProperty();
        this.DoctorId = new SimpleIntegerProperty();
        this.Diagnosis = new SimpleStringProperty();
    }

    public Integer getPateintId() {
        return PatientId.get();
    }

    public IntegerProperty PatientIdProperty() {
        return PatientId;
    }

    public void setPatientId(Integer PatientId) { this.PatientId.set(PatientId);
    }

    public int getDoctorId() { return DoctorId.get(); }

    public IntegerProperty DoctorIdProperty() { return DoctorId; }

    public void setDoctorId(int DoctorId) { this.DoctorId.set(DoctorId); }


   public String getDiagnosis() {return Diagnosis.get();}

   public StringProperty DiagnosisProperty() {return Diagnosis;}

   public void setDiagnosis(String Diagnosis) {this.Diagnosis.set(Diagnosis);}
}
