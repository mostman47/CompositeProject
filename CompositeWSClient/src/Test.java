
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mr.nam
 */
public class Test {

    public static void main(String args[]) {
        CompositeJDBC composite = new CompositeJDBC();
        Command cmd = new Command(composite);
        String _COMMAND = "*********COMMAND*******\n"
                + "1: Get Student's Information\n"
                + "2: Get Teacher's Information\n"
                + "3: Quit\n"
                + "*********************\n";
        System.out.println(_COMMAND);
        String command = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!command.equals("3")) {
            try {
                System.out.print("?");
                command = br.readLine();
                switch (command) {
                    case "1":
                        System.out.println("1: Student's Info");
                        cmd.printStudentInfo();
                        break;
                    case "2":
                        System.out.println("2: Teacher's Info");
                        cmd.printTeacherInfo();
                        break;
                    case "3":
                        break;

                    default:
                        System.out.println(_COMMAND);
                }
            } catch (IOException ioe) {
                System.out.println("IO error trying to read your name!");
                System.exit(1);
            }
        }
//        
    }
}
