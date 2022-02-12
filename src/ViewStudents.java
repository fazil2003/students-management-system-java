import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class ViewStudents{

    public void show(){

        Design designObj = new Design();

        DataBaseFunctions dbFunctions = new DataBaseFunctions();
        String[][] resultString = dbFunctions.getData();

        // Create the frame
        JFrame frame = new JFrame("Students Management System - Fazil");
        // If i use this line, then table is not visible
        // frame.setLayout(null);              
        

        String column[] = {"ROLLNO", "NAME", "DOB", "GPA", "HOSTELER"};         
        JTable tableView = new JTable(resultString, column);    
        tableView.setBounds(50, 200, 225, 50);         
        JScrollPane scrollPane = new JScrollPane(tableView); 
        frame.add(scrollPane);     

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        

    }
}
