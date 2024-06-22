package airlinemanagementsystem;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            //first step to connect database register a driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           //second step to connect database Create A Connection String
           c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","system");
           //third step to connect database create the statement
           s = c.createStatement();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

