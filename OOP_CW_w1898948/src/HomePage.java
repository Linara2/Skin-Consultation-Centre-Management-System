import javax.swing.*;
import java.awt.*;

//Creating a home page to the application//

public class HomePage extends JFrame {


    private Container bc;

    public HomePage () {
          Homeframe();
      }

      //Creating a homepage for the application//

      private void Homeframe(){
          setSize(560, 560);
          setTitle("Westminster Consultation Manager");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setResizable(true);
          bc = getContentPane();
          bc.setBackground(new Color(194, 218, 243));


          setLayout(null);
          JLabel header = new JLabel("Skin Consultation Center");
          header.setBounds(100, 10, 600, 100);
          header.setFont(new Font("Arial Black", Font.BOLD,25));
          add(header);

          JLabel icon = new JLabel();
          icon.setIcon(new ImageIcon("consultation.jpg"));
          Dimension size = icon.getPreferredSize();
          icon.setBounds(80, 90, 380, 300);
          add(icon);

          JButton button_home = new JButton("View all Doctors");
          button_home.setBounds(120, 420, 300, 50);
          button_home.setBackground(new Color(252, 241, 241, 255));
          button_home.addActionListener(e ->{

              DoctorFrame doctor_page = new DoctorFrame();
          });


          add(button_home);
          setVisible(true);
      }

      public static void main (String[]args){

          HomePage frame = new HomePage();
          frame.setVisible(true);
}
}
