package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    
    JLabel lname, lnationality, laddress, lgender, lsource, ldestination, lfname, lfcode, labelfname, labelfcode, lbldate;
    
    JButton bookflight, fetchuserButton, flight;
    
    Choice destination, source;
    
    JDateChooser dcdate;
    
    public BookFlight() {
        
        setTitle("Book Flight");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500, 100, 350, 250);
        add(img);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        heading.setForeground(new Color(8, 27, 41));
        heading.setBounds(350, 20, 250, 40);
        add(heading);
        
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        aadhar.setBounds(30, 90, 120, 30);
        add(aadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        tfaadhar.setBounds(170, 90, 180, 30);
        add(tfaadhar);
        
        fetchuserButton = new JButton("Fetch User");
        fetchuserButton.setBackground(Color.BLACK);
        fetchuserButton.setForeground(Color.white);
        fetchuserButton.setBounds(360, 90, 105, 30);
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
        
        JLabel nationality = new JLabel("Nationality");
        nationality.setFont(new Font("Raleway", Font.BOLD, 16));
        nationality.setBounds(30, 170, 100, 30);
        add(nationality);
        
        lnationality = new JLabel();
        lnationality.setFont(new Font("Raleway", Font.BOLD, 16));
        lnationality.setBounds(170, 170, 180, 30);
        add(lnationality);
                
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        address.setBounds(30, 210, 100, 30);
        add(address);
        
        laddress = new JLabel();
        laddress.setFont(new Font("Raleway", Font.BOLD, 16));
        laddress.setBounds(170, 210, 180, 30);
        add(laddress);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        gender.setBounds(30, 250, 100, 30);
        add(gender);
        
        lgender = new JLabel("Gender");
        lgender.setFont(new Font("Raleway", Font.BOLD, 16));
        lgender.setBounds(170, 250, 100, 30);
        add(lgender);

        lsource = new JLabel("Source");
        lsource.setFont(new Font("Raleway", Font.BOLD, 16));
        lsource.setBounds(30, 290, 100, 30);
        add(lsource);
        
        //Dropdown ke liye 2  Classes Hai 1st = JComboBox and 2nd = Choice
        //JComboBox is in the swing 
        //Choice is in the awt
        
        source = new Choice();
        source.setBounds(170, 290, 180, 30);
        add(source);
        
        ldestination = new JLabel("Destination");
        ldestination.setFont(new Font("Raleway", Font.BOLD, 16));
        ldestination.setBounds(30, 330, 100, 30);
        add(ldestination);
        
        destination = new Choice();
        destination.setBounds(170, 330, 180, 30);
        add(destination);
        
        flight = new JButton("Fetch Flights");
        flight.setForeground(Color.WHITE);
        flight.setBounds(360, 330, 105, 25);
        flight.setBackground(Color.BLACK);
        flight.addActionListener(this);
        add(flight);
        
        lfname = new JLabel("Flight Name");
        lfname.setFont(new Font("Raleway", Font.BOLD, 16));
        lfname.setBounds(30, 370, 100, 30);
        add(lfname);
        
        labelfname = new JLabel();
        labelfname.setFont(new Font("Raleway", Font.BOLD, 16));
        labelfname.setBounds(170, 370, 180, 30);
        add(labelfname);
        
        lfcode = new JLabel("Flight Code");
        lfcode.setFont(new Font("Raleway", Font.BOLD, 16));
        lfcode.setBounds(30, 410, 180, 30);
        add(lfcode);
        
        labelfcode = new JLabel();
        labelfcode.setFont(new Font("Raleway", Font.BOLD, 16));
        labelfcode.setBounds(170, 410, 180, 30);
        add(labelfcode);
        
        lbldate = new JLabel("Date of Travel");
        lbldate.setFont(new Font("Raleway", Font.BOLD, 16));
        lbldate.setBounds(30, 450, 180, 30);
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setFont(new Font("Raleway", Font.BOLD, 16));
        dcdate.setBounds(170, 450, 180, 30);
        add(dcdate);
        
        bookflight = new JButton("Book Flight");
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(170, 500, 180, 30);
        bookflight.setBackground(Color.BLACK);
        bookflight.addActionListener(this);
        add(bookflight);
        
        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        
        setSize(900, 600);
        setLocation(250, 130);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == fetchuserButton){
            
            String saadhar = tfaadhar.getText();
            
            try{
                Conn conn = new Conn();
                //DDL command
                String query = "select * from passenger where aadhar = '"+saadhar+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()){
                    lname.setText(rs.getString("name"));
                    lnationality.setText(rs.getString("nationality"));
                    laddress.setText(rs.getString("address"));
                    lgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Aadhar");
                }
           
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } else {
            if(ae.getSource() == flight){
            
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                //DDL command
                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()){
                    labelfname.setText(rs.getString("flight_name"));
                    labelfcode.setText(rs.getString("flight_code"));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");
                }
           
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } else {
                
                Random random = new Random();
                
                String aadhar = tfaadhar.getText();
                String name = lname.getText();
                String nationality = lnationality.getText();
                String flightname = labelfname.getText();
                String flightcode = labelfcode.getText();
                String src = source.getSelectedItem();
                String dest = destination.getSelectedItem();
                String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
    
               try{
                Conn conn = new Conn();
                //DDL command
                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+dest+"', '"+ddate+"')";

                conn.s.executeUpdate(query);
               
                JOptionPane.showMessageDialog(null, "Ticket Booked Sucessfuly");
                
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        }
        
    }
    
    public static void main(String args[]) {
        new BookFlight();
    }
    
}
