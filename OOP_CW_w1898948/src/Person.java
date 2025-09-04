import java.time.LocalDate;

public class Person {
    String name;

    String surname;

    LocalDate dateOfBirth;

    int mobileNo;

    public Person(String name, String surname, LocalDate dateofBirth, int mobileNo){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateofBirth;
        this.mobileNo = mobileNo;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname (String surname){
        this.surname=surname;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    public int getMobileNo(){
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String toString(){
        return "Person{"+
                "name='" + name+'\''+
                ", surname='"+surname+'\''+
                ", dateOfBirth='"+dateOfBirth+'\''+
                ", mobileNo="+mobileNo+
                '}';
    }
}
