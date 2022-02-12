import java.awt.Font;
import java.awt.event.*;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Program{

    public static void main(String[] args){

        Design designObj = new Design();

        // Create the frame
        JFrame frame = new JFrame("Students Management System - Fazil");
        frame.setLayout(null);

        JLabel labelTitle = new JLabel("Students Management System");
        labelTitle.setBounds(10, 10, 500, 50);
        labelTitle.setFont(new Font("Serif", Font.BOLD, 30));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setVerticalAlignment(SwingConstants.CENTER);
        frame.add(labelTitle);
        
        // Width 225 each = 450 

        // Button Add
        JButton buttonAdd = new JButton("Add Student");
        buttonAdd.setBounds(50, 200, 225, 50);
        buttonAdd = designObj.setButton(buttonAdd);
        buttonAdd.addActionListener(new AddButtonActionListener()); 
        frame.add(buttonAdd);

        // Button Update
        JButton buttonUpdate = new JButton("Update Student");
        buttonUpdate.setBounds(300, 200, 225, 50);
        buttonUpdate = designObj.setButton(buttonUpdate);
        buttonUpdate.addActionListener(new UpdateButtonActionListener()); 
        frame.add(buttonUpdate);

        // Button View
        JButton buttonView = new JButton("View Students");
        buttonView.setBounds(50, 275, 225, 50);
        buttonView = designObj.setButton(buttonView);
        buttonView.addActionListener(new ViewButtonActionListener()); 
        frame.add(buttonView);

        // Button Delete
        JButton buttonDelete = new JButton("Delete Student");
        buttonDelete.setBounds(300, 275, 225, 50);
        buttonDelete = designObj.setButton(buttonDelete);
        buttonDelete.addActionListener(new DeleteButtonActionListener()); 
        frame.add(buttonDelete);

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        

    }
}

class AddButtonActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        new AddStudent().show();
    }
}	

class UpdateButtonActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        new UpdateStudent().show();
    }
}	

class DeleteButtonActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        new DeleteStudent().show();
    }
}	

class ViewButtonActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        new ViewStudents().show();
    }
}