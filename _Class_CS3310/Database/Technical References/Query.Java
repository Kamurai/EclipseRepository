import java.sql.*;
import java.io.*;

class Query {
public static void main (String args[])
  throws SQLException, IOException {
  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");

} catch (ClassNotFoundException e) {
 System.out.println("Could not load the driver");
  }
    String user="is2080";
    String pass="is2080pass";

  System.out.println ("\nUser: " + user + "\tPassword: " + pass + "\n");
  
  Connection  con=DriverManager.getConnection
   ("jdbc:oracle:thin:@localhost:1521:xe","is2080","is2080pass");

   Statement stmt=con.createStatement();
   ResultSet cust=stmt.executeQuery
    ("Select cname, city, discnt FROM customers");
     while (cust.next ()) {
     System.out.println("CUstomer:"+cust.getString(1)+ "\t\tCity:"+ cust.getString(2) + "\t\tDiscnt:"+cust.getString(3));
   }
                                
   stmt.close();
   con.close();
}
}
   