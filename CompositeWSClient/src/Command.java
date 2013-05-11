
import java.sql.Connection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mr.nam
 */
public class Command {

    private CompositeJDBC composite;

    public Command(CompositeJDBC c) {
        composite = c;
    }

    public void printStudentInfo() {
        printInfo("Student_Info", "Student_Info");
    }

    public void printTeacherInfo() {
        printInfo("Teacher_Info", "Teacher_Info");
    }

    private void printInfo(String data_source, String table) {
        Connection conn;
        try {
            conn = composite.connect(data_source);
            composite.query(conn, table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
