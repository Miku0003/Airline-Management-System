
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    
    Payment() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/paytm.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0, 0, 500, 800);
        add(i4);
        
        JButton pay = new JButton("Done");
        pay.setBounds(0, 700, 500, 50);
        pay.setFont(new Font("RALEWAY", Font.BOLD, 20));
        pay.addActionListener(this);
        pay.setBackground(new Color(0, 239, 239));
        i4.add(pay);
        
        
        setSize(500, 800);
        setLocation(300, 0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        String text = ae.getActionCommand();
        
        if(text.equals("Done")) {
         
            JOptionPane.showMessageDialog(null, "Ticket Booked Sucessfuly");

                setVisible(false);
            
        }
    }
    
    
    public static void main(String args[]) {
        new Payment();
    }
    
}
