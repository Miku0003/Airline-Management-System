package airlinemanagementsystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class JourneyDetails extends JFrame implements ActionListener{
    
    JTable table;
    
    JTextField pnr;
    
    JButton show;
    
    public JourneyDetails() {
        
//        getContentPane().setBackground(Color.white);
        setTitle("Journey Details");
        setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Raleway", Font.BOLD, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 50, 100, 25);
        add(pnr);
        
        show = new JButton("Show");
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        add(show);
        
        
        table = new JTable();
       
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBackground(Color.white);
        jsp.setBounds(0, 100, 800, 150);
        add(jsp);
        
        setSize(815, 500);
        setLocation(250, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Information Found");
            }
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        new JourneyDetails();
    }
    
}
