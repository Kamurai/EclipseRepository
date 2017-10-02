import java.sql.*;
import java.io.*;

class Insert {
public static void main (String args[])
  throws SQLException, IOException {
  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");

} catch (ClassNotFoundException e) {
 System.out.println("Could not load the driver");
  }
    String user="is2080";
    String pass="is2080pass";
//  String v_cid;
  System.out.println("\nUser: " + user + "\tPassword: " + pass + "\n");
  
  Connection  con=DriverManager.getConnection
   ("jdbc:oracle:thin:@localhost:1521:xe","is2080","is2080pass");

   Statement stmt=con.createStatement();
   ResultSet cust=stmt.executeQuery
    ("Select cname, discnt  FROM customers");
     while (cust.next ()) {
     System.out.println("Customer:"+cust.getString(1)+ "\t\tDiscnt: "+cust.getString(2));
   }

     stmt.executeUpdate ("Insert into customers (cid, cname, city, discnt) values " +
                 "('C011','IBM','Atlanta',30)");
   
   System.out.println("Row Inserted. Check your Oracle Database");
                                
   stmt.close();
   con.close();
}
}


   
