import java.time.LocalDate;

public class Patient extends Person{

    int patientNo;

    public Patient(String name, String surname, LocalDate dateofBirth, int mobileNo, int patientNo) {
        super(name, surname, dateofBirth, mobileNo);
        this.patientNo=patientNo;
    }

    public int getPatientNo(){
        return patientNo;
    }

    public void setPatientNo(int patientNo) {
        this.patientNo = patientNo;
    }
}
