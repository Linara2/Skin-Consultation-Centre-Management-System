import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PatientFrame extends JFrame implements ActionListener {

    static ArrayList<Patient> patientsList = new ArrayList<>();

    //static ArrayList<Consultation> consultationList = new ArrayList<>();

    JFrame border;

    Container col;

    JLabel title;
    JLabel firstname;
    JLabel lastname;
    JLabel DOB;
    JLabel mobNo;
    JLabel notes;
    JLabel licenseNo;
    JLabel appointments;
    JLabel details;

    JTextField lastname_text;
    JTextField firstname_text;
    JTextField dob_text;
    JTextField mobile_text;
    JTextArea notes_text;
    JTextField licenseNo_text;
    JTextField appointment_text;
    JTextArea detail_text;

    JButton button_enter;
    JButton button_back;



    public PatientFrame(){

        //Creating a frame to enter the patient details and consult a doctor//

        setTitle("Westminster Consultation");
        setSize(1000,800);
        setResizable(true);
        col = getContentPane();
        col.setBackground(new Color(206, 229, 253));


        col = getContentPane();
        col.setLayout(null);


        JLabel header = new JLabel("Doctor Consultation");
        header.setBounds(320, 0, 600, 100);
        header.setFont(new Font("Arial Black", Font.BOLD,19));
        col.add(header);

        title= new JLabel("");
        col.add(title);

        firstname = new JLabel("First name:");
        firstname.setForeground(Color.black);
        firstname.setBounds(60,120,110,30);
        firstname.setFont(new Font("Arial",Font.PLAIN,14));
        col.add(firstname);

        firstname_text = new JTextField(15);
        firstname_text.setBounds(150,120,220,30);
        col.add(firstname_text);
        
        lastname = new JLabel("Last name:");
        lastname.setForeground(Color.black);
        lastname.setFont(new Font("Arial",Font.PLAIN,14));
        lastname.setBounds(510,120,110,30);
        col.add(lastname);

        lastname_text = new JTextField(15);
        lastname_text.setBounds(600,120,220,30);
        col.add(lastname_text);

        DOB = new JLabel("Date of birth:");
        DOB.setForeground(Color.black);
        DOB.setFont(new Font("Arial",Font.PLAIN,14));
        DOB.setBounds(60,180,110,30);
        col.add(DOB);

        dob_text = new JTextField(15);
        dob_text.setBounds(150,180,220,30);
        col.add(dob_text);

        mobNo= new JLabel("Mobile number:");
        mobNo.setForeground(Color.black);
        mobNo.setFont(new Font("Arial",Font.PLAIN,14));
        mobNo.setBounds(510,180,110,30);
        col.add(mobNo);

        mobile_text = new JTextField(15);
        mobile_text.setBounds(620,180,220,30);
        col.add(mobile_text);

        notes = new JLabel("Notes:");
        notes.setForeground(Color.black);
        notes.setFont(new Font("Arial",Font.PLAIN,14));
        notes.setBounds(60,240,110,30);
        col.add(notes);

        notes_text = new JTextArea();
        notes_text.setBounds(150,240,600,70);
        col.add(notes_text);

        licenseNo = new JLabel("Doctor licence no:");
        licenseNo.setForeground(Color.black);
        licenseNo.setFont(new Font("Arial",Font.PLAIN,14));
        licenseNo.setBounds(60,340,160,30);
        col.add(licenseNo);

        licenseNo_text = new JTextField(15);
        licenseNo_text.setBounds(190,340,200,30);
        col.add(licenseNo_text);

        appointments = new JLabel("Appointment date:");
        appointments.setForeground(Color.black);
        appointments.setFont(new Font("Arial",Font.PLAIN,14));
        appointments.setBounds(490,340,200,30);
        col.add(appointments);

        appointment_text = new JTextField(15);
        appointment_text.setBounds(670,340,220,30);
        col.add(appointment_text);

        details = new JLabel("Patient's Details:");
        details.setForeground(Color.black);
        details.setFont(new Font("Arial",Font.PLAIN,14));
        details.setBounds(60,410,110,30);
        col.add(details);

        detail_text = new JTextArea();
        detail_text.setBounds(220,410,240,310);
        col.add(detail_text);


        button_enter = new JButton("Enter");
        button_enter.setBounds(550,600,120,40);
        col.add(button_enter);

        button_enter.addActionListener(this);

        button_back = new JButton("Back");
        button_back.setBounds(750,600,120,40);
        button_back.addActionListener(e ->{

            this.dispose();
            DoctorFrame doctor_frame = new DoctorFrame();
        });

        col.add(button_back);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button_enter) {
            String firstname = this.firstname_text.getText();
            String surname = this.lastname_text.getText();
            String dateOfBirth = this.DOB.getText();
            String mobNo = this.mobile_text.getText();
            String notes = this.notes_text.getText();
            String value_1
                    = "First Name : "
                    + firstname_text.getText() + "\n";
            String value_2
                    = "\nLast Name : "
                    + lastname_text.getText() + "\n";
            String value_3
                    = "\nDate of Birth : "
                    + dob_text.getText() + "\n";
            String value_4
                    = "\nMobile Number : "
                    + mobile_text.getText() + "\n";
            String value_5
                    = "\nNotes : "
                    + notes_text.getText() + "\n";
            String value_6
                    = "\nDoctor licence no : "
                    + licenseNo_text.getText() + "\n";
            String value_7
                    = "\nAppointmnet data and time : "
                    + appointment_text.getText() + "\n";

            //String value_8
            //="Cost :" +"\n"
            //+cost;

            detail_text.setText(value_1 + value_2 + value_3 + value_4 + value_5 + value_6 + value_7);
            detail_text.setEditable(false);


            String f_name = firstname_text.getText();
            if(f_name.isEmpty()){
                JOptionPane.showMessageDialog(col,
                        "Name cannot be empty", "Error",JOptionPane.ERROR_MESSAGE);

                return;
            }
            String l_name = lastname_text.getText();
            if(l_name.isEmpty()){
                JOptionPane.showMessageDialog(col,
                        "Surname cannot be empty", "Error",JOptionPane.ERROR_MESSAGE);
                //clearTextFields();
                return;
            }

            String birthDate = (dob_text.getText());
            LocalDate patientBirthDate;

            if (dateValidater(birthDate)==null){

                JOptionPane.showMessageDialog(col,
                        "Invalid date of birth", "Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            patientBirthDate = dateValidater(String.valueOf(birthDate));

            //Validating the mobile number//
            String m_number = mobile_text.getText();
            int mobileNo;

            try{
                mobileNo = Integer.parseInt(m_number);
            }catch(Exception x){
                JOptionPane.showMessageDialog(col,
                        "Mobile number should be integer", "Error",JOptionPane.ERROR_MESSAGE);

                return;
            }

            //notes validator//

            String n_notes = notes_text.getText();
            if(n_notes.isEmpty()){
                JOptionPane.showMessageDialog(col,
                        "Notes cannot be empty", "Error",JOptionPane.ERROR_MESSAGE);

                return;
            }

            //license number validator//

            String li_number = licenseNo_text.getText();
            int licenseNo;

            try{
                licenseNo = Integer.parseInt(li_number);
            }catch(Exception x){
                JOptionPane.showMessageDialog(col,
                        "Licence number should be an integer", "Error",JOptionPane.ERROR_MESSAGE);

                return;
            }

            String datetime = (appointment_text.getText());
            LocalDate dateandtime;

            if (dateValidater(datetime)==null){

                JOptionPane.showMessageDialog(col,
                        "Invalid date ", "Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            dateandtime = dateTimeValidator(String.valueOf(datetime));


        }

        //Date Of Birth Validator//

    }public static LocalDate dateValidater(String dob) {



        if("k".equals(dob)){
            System.out.println("You should enter at least one date to continue");
            return null;
        }

        try{
            LocalDate dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ISO_DATE);
            return dateOfBirth;

        }catch(IllegalArgumentException e){
            System.out.println("Wrong date format, please enter the correct format");
        }catch(DateTimeParseException e){
            System.out.println("Wrong date format, please enter the correct format");
        }
        return null;

        //Appointment Date Validator//

    }
    public static LocalDate dateTimeValidator(String dateatime ){

        if ("t".equals(dateatime)){
            System.out.println("You should enter at least one date and time to continue");
            return null;
        }

        try{
            LocalDate dateAndTime = LocalDate.parse(dateatime, DateTimeFormatter.ISO_DATE_TIME);
            return dateAndTime;

        }catch(IllegalArgumentException e){
            System.out.println("Wrong date format, please enter the correct format");
        }catch(DateTimeParseException e){
            System.out.println("Wrong date format, please enter the correct format");
        }
        return null;


    }

    public static void main ( String [] args) {
        new PatientFrame();

    }





}

