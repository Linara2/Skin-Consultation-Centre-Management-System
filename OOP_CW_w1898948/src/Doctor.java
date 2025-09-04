import java.time.LocalDate;

public class Doctor extends Person {

    int mediLicenceNo;

    String specialisation;


    public Doctor(String name, String surname, LocalDate dateofBirth, int mobileNo, int mediLicenceNo, String specialisation ) {
        super(name, surname, dateofBirth, mobileNo);
        this.mediLicenceNo = mediLicenceNo;
        this.specialisation = specialisation;
    }

    public int getmediLicenceNo() {
        return mediLicenceNo;
    }

    public void setmediLicenceNo( int mediLicenceNo) {
        this.mediLicenceNo = mediLicenceNo;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }



}
