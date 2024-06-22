package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    
    JLabel lname, cancelation, lfcode, dateoftravel;
    
    JButton fetchuserButton, cancel;
    
    public Cancel() {
        
        Random random = new Random();
        
        setTitle("Ticket Cancelation");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500, 80, 250, 250);
        add(img);
        
        JLabel heading = new JLabel("CANCELATION");
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        heading.setForeground(new Color(8, 27, 41));
        heading.setBounds(280, 20, 250, 40);
        add(heading);
        
        JLabel pnr = new JLabel("PNR Number");
        pnr.setFont(new Font("Raleway", Font.BOLD, 16));
        pnr.setBounds(30, 90, 120, 30);
        add(pnr);
        
        tfpnr = new JTextField();
        tfpnr.setFont(new Font("Raleway", Font.BOLD, 16));
        tfpnr.setBounds(170, 90, 180, 30);
        add(tfpnr);
        
        fetchuserButton = new JButton("Show Details");
        fetchuserButton.setBackground(Color.BLACK);
        fetchuserButton.setForeground(Color.white);
        fetchuserButton.setBounds(360, 90, 110, 30);
        fetchuserButton.addActionListener(this);
        add(fetchuserButton);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(30, 130, 100, 30);
        add(name);
        
        lname = new JLabel();
        lname.setFont(new Font("Raleway", Font.BOLD, 16));
        lname.setBounds(170, 130, 180, 30);
        add(lname);
        
        JLabel lblcanelation = new JLabel("Cancelation No.");
        lblcanelation.setFont(new Font("Raleway", Font.BOLD, 16));
        lblcanelation.setBounds(30, 170, 125, 30);
        add(lblcanelation);
        
        cancelation = new JLabel("" + random.nextInt(1000000));
        cancelation.setFont(new Font("Raleway", Font.BOLD, 16));
        cancelation.setBounds(170, 170, 180, 30);
        add(cancelation);
                
        JLabel fcode = new JLabel("Flight Code");
        fcode.setFont(new Font("Raleway", Font.BOLD, 16));
        fcode.setBounds(30, 210, 100, 30);
        add(fcode);
        
        lfcode = new JLabel();
        lfcode.setFont(new Font("Raleway", Font.BOLD, 16));
        lfcode.setBounds(170, 210, 180, 30);
        add(lfcode);
        
        JLabel date = new JLabel("Date");
        date.setFont(new Font("Raleway", Font.BOLD, 16));
        date.setFont(new Font("Raleway", Font.BOLD, 16));
        date.setFont(new Font("Raleway", Font.BOLD, 16));
        date.setBounds(30, 250, 100, 30);
        add(date);
        
        dateoftravel = new JLabel();
        dateoftravel.setFont(new Font("Raleway", Font.BOLD, 16));
        dateoftravel.setBounds(170, 250, 100, 30);
        add(dateoftravel);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(170, 300, 110, 30);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);   
        
        setSize(800, 400);
        setLocation(270, 130);
//        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == fetchuserButton){
            
            String spnr = tfpnr.getText();
            
            try{
                Conn conn = new Conn();
                //DDL command
                String query = "select * from reservation where PNR = '"+spnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()){
                    lname.setText(rs.getString("name"));
                    lfcode.setText(rs.getString("flightcode"));
                    dateoftravel.setText(rs.getString("ddate"));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");
                }
           
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == cancel){
            
            String sname = lname.getText();
            String spnr = tfpnr.getText();
            String scancelno = cancelation.getText();
            String sfcode = lfcode.getText();
            String sdate = dateoftravel.getText();
                        
            try{
                Conn conn = new Conn();
                //DDL command
                String query = "insert into cancel values('"+spnr+"', '"+sname+"', '"+scancelno+"', '"+sfcode+"', '"+sdate+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR = '"+spnr+"'");
               
                JOptionPane.showMessageDialog(null, "Ticket Canceled Successfully");
                setVisible(false);
           
            }catch(Exception e){
                e.printStackTrace();
            
            }
        }
        
    }
    
    public static void main(String args[]) {
        new Cancel();
    }
    
}
