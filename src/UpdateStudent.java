import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class UpdateStudent{

    public void show(){

        Design designObj = new Design();
        DataBaseFunctions dbFunctions = new DataBaseFunctions();

        // Create the frame
        JFrame addFrame = new JFrame("Students Management System - Fazil");
        addFrame.setLayout(null);

        JLabel labelTitle = new JLabel("Update Student");
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

        // Name
        JLabel labelName = new JLabel("Name: ");
        labelName.setBounds(50, 270, 200, 50);
        addFrame.add(labelName);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(300, 270, 200, 50);
        addFrame.add(textFieldName);

        // DOB
        JLabel labelDOB = new JLabel("DOB: ");
        labelDOB.setBounds(50, 340, 200, 50);
        addFrame.add(labelDOB);

        JTextField textFieldDOB = new JTextField();
        textFieldDOB.setBounds(300, 340, 200, 50);
        addFrame.add(textFieldDOB);

        // GPA
        JLabel labelGPA = new JLabel("GPA: ");
        labelGPA.setBounds(50, 410, 200, 50);
        addFrame.add(labelGPA);

        JTextField textFieldGPA = new JTextField();
        textFieldGPA.setBounds(300, 410, 200, 50);
        addFrame.add(textFieldGPA);

        // HOSTELER
        JLabel labelHosteler = new JLabel("Hosteler: ");
        labelHosteler.setBounds(50, 480, 200, 50);
        addFrame.add(labelHosteler);

        JTextField textFieldHosteler = new JTextField();
        textFieldHosteler.setBounds(300, 480, 200, 50);
        addFrame.add(textFieldHosteler);

        // BUTTON SUBMIT
        JButton buttonSubmit = new JButton("Update Student");
        buttonSubmit = designObj.setButton(buttonSubmit);
        buttonSubmit.setBounds(50, 550, 450, 50);
        buttonSubmit.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                   String rollno = textFieldRollNo.getText();
                   String name = textFieldName.getText();
                   String DOB = textFieldDOB.getText();
                   Float GPA = Float.parseFloat(textFieldGPA.getText());
                   String hosteler = textFieldHosteler.getText();
                   
                   dbFunctions.updateData(rollno, name, DOB, GPA, hosteler);

                   JOptionPane.showMessageDialog(addFrame, "Data updated successfully.");  
                }
             }
        );
        addFrame.add(buttonSubmit);

        // addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.setSize(550, 650);
        addFrame.setVisible(true);

    }
}

