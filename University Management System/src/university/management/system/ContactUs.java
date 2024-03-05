package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ContactUs extends JFrame implements ActionListener{
    
    JTextField name, email, messagesg;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    ContactUs() {
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Contact Us");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        name = new JTextField();
        name.setBounds(200, 150, 150, 30);
        add(name);
        
  
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        email = new JTextField();
        email.setBounds(200, 300, 150, 30);
        add(email);
        

        JLabel message = new JLabel("Message");
        message.setBounds(400, 350, 200, 30);
        message.setFont(new Font("serif", Font.BOLD, 20));
        add(message);
        
        messagesg = new JTextField();
        messagesg.setBounds(600, 350, 150, 30);
        add(messagesg);
        
        
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
//            APPLY REGGIX

           String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
             Pattern pattern = Pattern.compile(emailPattern);

        String emailMd ; 

        Matcher matcher = pattern.matcher(email.getText());
        
        if (matcher.find()) {
            JOptionPane.showMessageDialog(null, "Correct Email", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Email", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new ContactUs();
    }
}
