import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

        static int no;

        public ArrayList<Doctor> doctorList = new ArrayList<Doctor>(10);

        //Creating the westminsterConsultationManager object//
        static WestminsterSkinConsultationManager l1 = new WestminsterSkinConsultationManager();


        public static void main(String[] args) throws ParseException, IOException {
            Scanner methodChoose = new Scanner(System.in);

            //Creating the main menu//

            while (true) {
                System.out.println("\nEnter 1 to add a new doctor: ");
                System.out.println("Enter 2 to delete a doctor: ");
                System.out.println("Enter 3 to print the doctor list");
                System.out.println("Enter 4 to print the sorted doctor list: ");
                System.out.println("Enter 5 to save in a file: ");
                System.out.println("Enter 6 to load the file");
                System.out.println("Enter 7 to open GUI");
                System.out.println("Enter 8 to exist\n");


                no = methodChoose.nextInt();

                if (no == 1) {                            //Adding a new doctor to the system.
                    l1.addANewDoctor();
                } else if (no == 2) {                       //Deleting a doctor from the system.
                    l1.deleteADoctor();
                } else if (no == 3) {                      //Printing the doctor list.
                    l1.printDoctorList();
                } else if (no == 4) {                       //Printing the sorted doctor list.
                    l1.printSortedDoctorList();
                } else if (no == 5) {                       //Saving the data in a file.
                    l1.saveInAFile();
                } else if (no == 6) {                     //Load the doctor list
                    l1.loadFile();
                } else if (no == 7){
                    l1.openGUI();                         //Open GUI
                } else if (no == 8) {                     //Exist the program
                    l1.exist();
                    break;

                } else {
                    System.out.println("Please Enter A Correct Input");
                }
            }


        }


    //Adding a new doctor//

    @Override
    public void addANewDoctor() throws ParseException {
        if(doctorList.size()<=10) {

            //taking all the information of a doctor to add him.

            try {
                Scanner input2 = new Scanner(System.in);
                System.out.print("Enter the name of the doctor: ");
                String name = input2.next();

                Scanner input3 = new Scanner(System.in);
                System.out.print("Enter the surname of the doctor : ");
                String surname = input3.next();

                Scanner input4 = new Scanner(System.in);
                System.out.print("Enter the date of birth of the doctor(yyyy-mm-dd) : ");
                LocalDate dateOfBirth = LocalDate.parse(input4.next());

                Scanner input5 = new Scanner(System.in);
                System.out.print("Enter the mobile number of the doctor : ");
                int mobileNo = input5.nextInt();

                Scanner input6 = new Scanner(System.in);
                System.out.print("Enter the medical licence number of the doctor : ");
                int mediLicenceNo = input6.nextInt();

                Scanner input7 = new Scanner(System.in);
                System.out.print("Enter the specialized path of the doctor : ");
                String specialisation = input7.next();

                doctorList.add(new Doctor(name, surname, dateOfBirth, mobileNo, mediLicenceNo, specialisation));

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }else {
            System.out.println("Cannot add a doctor");
        }

    }

    //Deleting a doctor//

    @Override
    public void deleteADoctor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the medical licence of the doctor you want to delete:");
        int mediLicenceNo=Integer.parseInt(input.next());
        Doctor dd1=null;

        for (Doctor i:doctorList){
            if (i.getmediLicenceNo()==(mediLicenceNo)){
                dd1=i;
            }
        }

        doctorList.remove(dd1);
        System.out.println("Doctor with medical licence number" + " "+ mediLicenceNo + " has been successfully removed");

    }

    @Override
    public void printDoctorList() {
        for(Doctor i:doctorList){

            System.out.println("\nName of the doctor : " + (i).getName());
            System.out.println("Surname of the doctor:" +  (i).getSurname());
            System.out.println("Date of birth of the doctor:" + (i).getDateOfBirth());
            System.out.println("Mobile number of the doctor:" + (i).getMobileNo());
            System.out.println("Medical Licence number of the doctor:" + (i).getmediLicenceNo());
            System.out.println("Specialised path of the doctor:" + (i).getSpecialisation());
        }
    }

    //Printing the doctor list in alphabetical order according the surname//

    @Override
    public void printSortedDoctorList() {

        Collections.sort(doctorList, new Comparator<Doctor>(){
            @Override
            public int compare(Doctor f1, Doctor s2) {return f1.getSurname().compareTo(s2.getSurname());}
        });

        for(Doctor i:doctorList){

            System.out.println("\nName of the doctor : " + (i).getName());
            System.out.println("Surname of the doctor:" +  (i).getSurname());
            System.out.println("Date of birth of the doctor:" + (i).getDateOfBirth());
            System.out.println("Mobile number of the doctor:" + (i).getMobileNo());
            System.out.println("Medical Licence number of the doctor:" + (i).getmediLicenceNo());
            System.out.println("Specialised path of the doctor:" + (i).getSpecialisation());
        }
    }

    //Saving the doctor details in a file//

    @Override
    public void saveInAFile() {
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter("text.txt"));
            for(Doctor i :doctorList){
                writer.write(i.getName()+","+i.getSurname()+","+i.getDateOfBirth()+","+i.getMobileNo()+","+i.getmediLicenceNo()+","+i.getSpecialisation());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    //Loading the saved file//

    @Override
    public void loadFile() throws IOException {
        File file = new File("text.txt");
        String[] filedata;

        Scanner scanfile = new Scanner(file);
        while (scanfile.hasNextLine()){
            filedata = scanfile.nextLine().split(",");
            LocalDate date = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if (filedata[2]!=null) {
                date = LocalDate.parse(filedata[2].trim(), formatter);
            }
            doctorList.add(new Doctor(filedata[0].trim(),filedata[1].trim(), date, Integer.parseInt(filedata[3].trim()),Integer.parseInt(filedata[4].trim()),filedata[5]));
            System.out.println(Arrays.toString(filedata));
        }
        System.out.println("Data added");


    }

    public void openGUI() {
        HomePage frame = new HomePage();
        frame.setVisible(true);
    }

    //Exist the program//

    @Override
    public void exist() {

    }
};



