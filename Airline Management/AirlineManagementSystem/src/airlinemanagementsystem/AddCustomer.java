package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname, tfnationality, tfaadhar, tfaddress, tfcontact;
            
    JRadioButton male, female;
    
    public AddCustomer() {
        
        setTitle("Add Customer Details");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/emp.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 80, 300, 300);
        add(img);
        
        JLabel label = new JLabel("ADD CUSTOMER DETAILS");
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        label.setForeground(new Color(8, 27, 41));
        label.setBounds(200, 20, 250, 40);
        add(label);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(50, 90, 100, 30);
        add(name);
        
        tfname = new JTextField();
        tfname.setFont(new Font("Raleway", Font.BOLD, 16));
        tfname.setBounds(200, 90, 200, 30);
        add(tfname);
        
        JLabel nationality = new JLabel("Nationality");
        nationality.setFont(new Font("Raleway", Font.BOLD, 16));
        nationality.setBounds(50, 130, 100, 30);
        add(nationality);
        
        tfnationality = new JTextField();
        tfnationality.setFont(new Font("Raleway", Font.BOLD, 16));
        tfnationality.setBounds(200, 130, 200, 30);
        add(tfnationality);
        
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        aadhar.setBounds(50, 170, 120, 30);
        add(aadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        tfaadhar.setBounds(200, 170, 200, 30);
        add(tfaadhar);
        
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        address.setBounds(50, 210, 100, 30);
        add(address);
        
        tfaddress = new JTextField();
        tfaddress.setFont(new Font("Raleway", Font.BOLD, 16));
        tfaddress.setBounds(200, 210, 200, 30);
        add(tfaddress);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        gender.setBounds(50, 250, 100, 30);
        add(gender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        male = new JRadioButton("Male");
        male.setBounds(200, 250, 90, 30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(310, 250, 90, 30);
        female.setBackground(Color.white);
        add(female);
        
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel contact = new JLabel("Phone");
        contact.setFont(new Font("Raleway", Font.BOLD, 16));
        contact.setBounds(50, 290, 100, 30);
        add(contact);
        
        tfcontact = new JTextField();
        tfcontact.setFont(new Font("Raleway", Font.BOLD, 16));
        tfcontact.setBounds(200, 290, 200, 30);
        add(tfcontact);
        
        JButton save = new JButton("Save");
        save.setForeground(Color.WHITE);
        save.setBounds(200, 340, 200, 30);
        save.setBackground(Color.BLACK);
        save.addActionListener(this);
        add(save);
        
        
        
        setSize(700, 500);
        setLocation(300, 150);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        String sname = tfname.getText();
        String snationality = tfnationality.getText();
        String saadhar = tfaadhar.getText();
        String saddress = tfaddress.getText();
        String scontact = tfcontact.getText();
        String sgender = null;
        if(male.isSelected()) {
            sgender = "Male";
        }else {
            sgender = "Female";
        }
                
        try{
            Conn conn = new Conn();
            //DML command
            String query = "insert into passenger values('"+sname+"', '"+snationality+"', '"+saadhar+"', '"+saddress+"', '"+scontact+"', '"+sgender+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String args[]) {
        new AddCustomer();
    }
    
}
