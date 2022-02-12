import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class DeleteStudent{

    public void show(){

        Design designObj = new Design();
        DataBaseFunctions dbFunctions = new DataBaseFunctions();

        // Create the frame
        JFrame addFrame = new JFrame("Students Management System - Fazil");
        addFrame.setLayout(null);

        JLabel labelTitle = new JLabel("Delete Student");
        labelTitle.setBounds(10, 10, 500, 50);
        labelTitle.setFont(new Font("Serif", Font.BOLD, 30));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setVerticalAlignment(SwingConstants.CENTER);
        addFrame.add(labelTitle);
        
        // Width 225 each = 450 

        // RollNo
        JLabel labelRollNo = new JLabel("Roll No: ");
        labelRollNo.setBounds(50, 200, 200, 50);
        addFrame.add(labelRollNo);

        JTextField textFieldRollNo = new JTextField();
        textFieldRollNo.setBounds(300, 200, 200, 50);
        addFrame.add(textFieldRollNo);

        // BUTTON SUBMIT
        JButton buttonSubmit = new JButton("Delete Student");
        buttonSubmit = designObj.setButton(buttonSubmit);
        buttonSubmit.setBounds(50, 270, 450, 50);
        buttonSubmit.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                   String rollno = textFieldRollNo.getText();
                   
                   dbFunctions.deleteData(rollno);

                   JOptionPane.showMessageDialog(addFrame, "Data deleted successfully.");  
                }
             }
        );
        addFrame.add(buttonSubmit);

        // addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.setSize(550, 450);
        addFrame.setVisible(true);

    }
}

