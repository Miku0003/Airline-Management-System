package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
 
    public Home(){
        
        setTitle("Home Page");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/aeroplane.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1380, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1380, 750);
        add(image);
        
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setFont(new Font("Raleway", Font.BOLD, 40));
        heading.setBounds(400, 30, 600, 40);
        heading.setForeground(new Color(8,27,41));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        String text = ae.getActionCommand();
        
        if(text.equals("Add Customer Details")) {
            new AddCustomer().setVisible(true);
        }else if(text.equals("Flight Details")) {
            new FlightInfo().setVisible(true);
        } else if(text.equals("Book Flight")) {
            new BookFlight().setVisible(true);
        } else if(text.equals("Journey Details")) {
            new JourneyDetails().setVisible(true);
        } else if(text.equals("Cancel Ticket")) {
            new Cancel().setVisible(true);
        } else if(text.equals("Boarding Pass")) {
            new BoardingPass().setVisible(true);
        }
        
    }
    
    public static void main(String args[]) {
        new Home();
    }
    
}
