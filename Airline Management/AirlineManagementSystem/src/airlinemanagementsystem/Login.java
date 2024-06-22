
package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton reset, submit, close;
    JTextField user;
    JPasswordField pwd;
    
    public Login(){
        
        setTitle("Login");
        
        setLayout(null);
        
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Raleway", Font.BOLD, 16));
        username.setBounds(35, 10, 80, 30);
        add(username);
        
        user = new JTextField();
        user.setFont(new Font("Raleway", Font.BOLD, 16));
        user.setBounds(175, 10, 220, 30);
        add(user);
        
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Raleway", Font.BOLD, 16));
        password.setBounds(35, 50, 80, 30);
        add(password);
        
        pwd = new JPasswordField();
        pwd.setFont(new Font("Raleway", Font.BOLD, 16));
        pwd.setBounds(175, 50, 220, 30);
        add(pwd);
        
        reset = new JButton("Reset");
        reset.setFont(new Font("Raleway", Font.BOLD, 16));
        reset.setBounds(50, 120, 150, 30);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(225, 120, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setFont(new Font("Raleway", Font.BOLD, 16));
        close.setBounds(135, 175, 150, 30);
        close.addActionListener(this);
        add(close);
        
        setSize(450, 270);
        getContentPane().setBackground(Color.WHITE);
        setLocation(400,250);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String susername = user.getText();
            String spwd = pwd.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username = '"+susername+"' and password = '"+spwd+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == reset) {
            user.setText("");
            pwd.setText("");
        }
    }
                
                
//                Conn c = new Conn();
//                
//                String query = "select * from login where username = '"+susername+"'and spwd = '"+spwd+"'";
//                //DDL command keliye
//                ResultSet rs = c.s.executeQuery(query);//ResultSet java.sql me hota hai returned value ko store karne keliye karte hain
//                if(rs.next()) {
//                    new Home();
//                    setVisible(false);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
//                    setVisible(false);
//                }
//                
//            } catch(Exception e) {
//                e.getStackTrace();
//            }
            
//        } else if(ae.getSource() == close) {
//            System.exit(0);
//        } else if(ae.getSource() == reset) {
//            user.setText("");
//            pwd.setText("");
//        }
//    }
    
    public static void main(String args[]) {
        new Login();
    }
    
}
