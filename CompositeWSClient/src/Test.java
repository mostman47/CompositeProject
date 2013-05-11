
import org.tempuri.StudentInfoOutputCursorType;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mr.nam
 */
public class Test {
    public static void main(String[] args) {
        StudentInfoOutputCursorType student = studentInfo();
    }

    private static StudentInfoOutputCursorType studentInfo(java.lang.Object studentInfoInput) {
        org.tempuri.StudentInfo service = new org.tempuri.StudentInfo();
        org.tempuri.StudentInfoPortType port = service.getStudentInfoPort();
        return port.studentInfo(studentInfoInput);
    }
}
