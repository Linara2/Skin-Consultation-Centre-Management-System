import javax.swing.*;
import java.io.IOException;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorFrame extends JFrame {

    private JTable table_1;

    private ArrayList<Doctor> doctorList = new ArrayList<>();
    private JScrollPane jScrollPane;
    private JButton buttonAssign;
    private JButton buttonSort;
    private Container lk;

    public DoctorFrame() {
       doctorInterface();
       setLocationRelativeTo(null);
       loadDoctors();

    }

    //Creating a table to list all the doctors//

    private void doctorInterface() {
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Skin Consultation Manager");
        setResizable(true);
        lk = getContentPane();
        lk.setBackground(new Color(206, 229, 253));
        setLayout(null);
        JLabel header = new JLabel("List of all the doctors");
        header.setFont(new Font("Arial Black", Font.BOLD, 16));
        header.setBounds(240, 0, 600, 100);
        add(header);
        jScrollPane = new JScrollPane();
        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel());
        table_1.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Licence No",
                        "Name",
                        "Surname",
                        "Date of Birth",
                        "Mobile number",
                        "Specialisation"
                }

        ));

        jScrollPane.setViewportView(table_1);
        jScrollPane.setBounds(50, 100, 600, 300);
        add(jScrollPane);

        buttonAssign = new JButton("Book a doctor");
        buttonAssign.setBounds(50, 450, 260, 50);
        buttonAssign.setBackground(new Color(241, 236, 236));
        buttonAssign.setForeground(Color.black);
        add(buttonAssign);

        buttonAssign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {doctorAssignButtonPerformed(e);}

        });



        buttonSort = new JButton("Sort doctor list in ascending order");
        buttonSort.setBounds(390, 450, 260, 50);
        buttonSort.setBackground(new Color(241, 236, 236));
        buttonSort.setForeground(Color.black);
        add(buttonSort);

        buttonSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){sortButtonPerformed(e);}

        });
        setVisible(true);

    }

    private  void doctorAssignButtonPerformed(ActionEvent e) {
        this.dispose();
        new PatientFrame();


    }

    //Sorting the doctors in alphabetical order according to the surname//

    private void sortButtonPerformed(ActionEvent e){
        List<Doctor> sortedList = doctorList.stream()
                .sorted(Comparator.comparing(Doctor::getSurname))
                .collect(Collectors.toList());
        DefaultTableModel tb1 = (DefaultTableModel) table_1.getModel();
        tb1.setRowCount(0);
        for (Doctor doctor : sortedList) {
            Vector v = new Vector();
            v.add(doctor.getmediLicenceNo());
            v.add(doctor.getName());
            v.add(doctor.getSurname());
            v.add(doctor.getDateOfBirth());
            v.add(doctor.getMobileNo());
            v.add(doctor.getSpecialisation());
            tb1.addRow(v);
        }
    }

    private void loadDoctors(){
        try {
            loadFile();
            DefaultTableModel tb1 = (DefaultTableModel) table_1.getModel();
            tb1.setRowCount(0);
            for (Doctor doctor : doctorList) {
                Vector v = new Vector();
                v.add(doctor.getmediLicenceNo());
                v.add(doctor.getName());
                v.add(doctor.getSurname());
                v.add(doctor.getDateOfBirth());
                v.add(doctor.getMobileNo());
                v.add(doctor.getSpecialisation());
                tb1.addRow(v);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadFile() throws IOException {
        File file = new File("text.txt");
        String[] filedata;

        Scanner scanfile = new Scanner(file);
        while (scanfile.hasNextLine()) {
            filedata = scanfile.nextLine().split(",");
            LocalDate date = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if (filedata[2] != null) {
                date = LocalDate.parse(filedata[2].trim(), formatter);
            }
            doctorList.add(new Doctor(filedata[0].trim(), filedata[1].trim(), date, Integer.parseInt(filedata[3].trim()), Integer.parseInt(filedata[4].trim()), filedata[5]));
            System.out.println(Arrays.toString(filedata));
        }

    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        DoctorFrame doctorFrame = new DoctorFrame();
        doctorFrame.setVisible(true);
    }

}

