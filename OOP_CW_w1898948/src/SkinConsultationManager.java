import java.io.IOException;
import java.text.ParseException;

public interface SkinConsultationManager {

    void addANewDoctor() throws ParseException;

    void deleteADoctor();

    void printDoctorList();

    void printSortedDoctorList();

    void saveInAFile();

    void loadFile() throws IOException;

    void openGUI();

    void exist();
}
