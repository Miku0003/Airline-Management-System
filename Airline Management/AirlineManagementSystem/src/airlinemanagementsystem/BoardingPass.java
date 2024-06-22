package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    
    JLabel lname, lnationality, lsrc, ldest, labelfname,labelfcode, dcdate;
    
    JButton fetchuserButton;
    
    public BoardingPass() {
        
        setTitle("Book Flight");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(550, 50, 350, 250);
        add(img);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setFont(new Font("Raleway", Font.BOLD, 40));
        heading.setForeground(new Color(8, 27, 41));
        heading.setBounds(350, 10, 250, 45);
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setFont(new Font("Raleway", Font.BOLD, 24));
        subheading.setForeground(new Color(8, 27, 41));
        subheading.setBounds(350, 60, 250, 40);
        add(subheading);
        
        JLabel pnrdetails = new JLabel("PNR DETAILS");
        pnrdetails.setFont(new Font("Raleway", Font.BOLD, 16));
        pnrdetails.setBounds(30, 110, 120, 30);
        add(pnrdetails);
        
        tfpnr = new JTextField();
        tfpnr.setFont(new Font("Raleway", Font.BOLD, 16));
        tfpnr.setBounds(170, 110, 180, 30);
        add(tfpnr);
        
        fetchuserButton = new JButton("Enter");
        fetchuserButton.setBackground(Color.BLACK);
        fetchuserButton.setForeground(Color.white);
        fetchuserButton.setBounds(360, 110, 105, 30);
        fetchuserButton.addActionListener(this);
        add(fetchuserButton);
        
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(30, 150, 100, 30);
        add(name);
        
        lname = new JLabel();
        lname.setFont(new Font("Raleway", Font.BOLD, 16));
        lname.setBounds(170, 150, 180, 30);
        add(lname);
        
        JLabel nationality = new JLabel("NATIONALITY");
        nationality.setFont(new Font("Raleway", Font.BOLD, 16));
        nationality.setBounds(30, 190, 110, 30);
        add(nationality);
        
        lnationality = new JLabel();
        lnationality.setFont(new Font("Raleway", Font.BOLD, 16));
        lnationality.setBounds(170, 190, 180, 30);
        add(lnationality);
                
        JLabel src = new JLabel("SRC");
        src.setFont(new Font("Raleway", Font.BOLD, 16));
        src.setBounds(30, 230, 100, 30);
        add(src);
        
        lsrc = new JLabel();
        lsrc.setFont(new Font("Raleway", Font.BOLD, 16));
        lsrc.setBounds(170, 230, 180, 30);
        add(lsrc);
        
        JLabel dest = new JLabel("DEST");
        dest.setFont(new Font("Raleway", Font.BOLD, 16));
        dest.setBounds(360, 230, 100, 30);
        add(dest);
        
        ldest = new JLabel();
        ldest.setFont(new Font("Raleway", Font.BOLD, 16));
        ldest.setBounds(470, 230, 100, 30);
        add(ldest);
        
        JLabel lfname = new JLabel("Flight Name");
        lfname.setFont(new Font("Raleway", Font.BOLD, 16));
        lfname.setBounds(30, 270, 100, 30);
        add(lfname);
        
        labelfname = new JLabel();
        labelfname.setFont(new Font("Raleway", Font.BOLD, 16));
        labelfname.setBounds(170, 270, 180, 30);
        add(labelfname);
        
        JLabel lfcode = new JLabel("Flight Code");
        lfcode.setFont(new Font("Raleway", Font.BOLD, 16));
        lfcode.setBounds(360, 270, 100, 30);
        add(lfcode);
        
        labelfcode = new JLabel();
        labelfcode.setFont(new Font("Raleway", Font.BOLD, 16));
        labelfcode.setBounds(470, 270, 100, 30);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setFont(new Font("Raleway", Font.BOLD, 16));
        lbldate.setBounds(30, 310, 50, 30);
        add(lbldate);
        
        dcdate = new JLabel();
        dcdate.setFont(new Font("Raleway", Font.BOLD, 16));
        dcdate.setBounds(170, 310, 180, 30);
        add(dcdate);
       
        setSize(1000, 450);
        setLocation(170, 130);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
       
        String spnr = tfpnr.getText();

        try{
            Conn conn = new Conn();
            //DDL command
            String query = "select * from reservation where PNR = '"+spnr+"'";

            ResultSet rs = conn.s.executeQuery(query);

            if(rs.next()){
                lname.setText(rs.getString("name"));
                lnationality.setText(rs.getString("nationality"));
                lsrc.setText(rs.getString("src"));
                ldest.setText(rs.getString("des"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                dcdate.setText(rs.getString("ddate"));
                

            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String args[]) {
        new BoardingPass();
    }
    
}
