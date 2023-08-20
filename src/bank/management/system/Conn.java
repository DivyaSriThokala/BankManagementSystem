package bank.management.system;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
    public Conn() {
    	try {
    		String url="jdbc:mysql://localhost:3306/bankmanagementsystem";
    		String uname="root";
    		String pass="12345";
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		 c=DriverManager.getConnection(url,uname,pass);
    		 s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    	}
    	catch(Exception e) {
    	    System.out.println(e);	
    	}
    }
}
