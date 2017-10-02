import java.sql.*;
import java.io.*;

class Customers {
public static void main (String args[])
  throws SQLException, IOException {
  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");

} catch (ClassNotFoundException e) {
 System.out.println("Could not load the driver");
  }
  String user="is2080";
  String pass="is2080pass";
  String v_cid;
  System.out.println (user + pass);
  
  Connection  con=DriverManager.getConnection
   ("jdbc:oracle:thin:@localhost:1521:xe","is2080","is2080pass");

   Statement stmt=con.createStatement();
   ResultSet cust=stmt.executeQuery
    ("Select cname, city, discnt FROM customers");
     while (cust.next ()) {
     System.out.println("CUstomer:"+cust.getString(1)+ "Discnt: "+cust.getString(2));
   }
//   stmt.executeUpdate ("Update customers set discnt = discnt * 3");
   v_cid = readentry ("Enter cid: ");
   stmt.executeUpdate ("Update customers set discnt=disnt*10" +
                        "Where cid = v_cid");
                                
   stmt.close();
   con.close();
}
}


   
