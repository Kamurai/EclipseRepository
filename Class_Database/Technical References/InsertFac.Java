import java.io.*;
import java.sql.*;

class InsertFac {
public static void main (String args[])
  throws SQLException, IOException {
  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");

} catch (ClassNotFoundException e) {
 System.out.println("Could not load the driver");
  }
  String user="Relational";
  String pass="Relational";
  System.out.println (user + pass);
  
  Connection  con=DriverManager.getConnection
   ("jdbc:oracle:thin:@localhost:1521:oracle","Relational","Relational");

   Statement stmt=con.createStatement();
   ResultSet cust=stmt.executeQuery
    ("Select * from FacultyEDB");
     while (cust.next ()) {
     System.out.println("SSN:"+cust.getString(1)+ "First Name:    "+cust.getString(3));
   }
     CallableStatement cstmt = con.prepareCall("{CALL insertFaculty('121-44-4447', '17-MAY-1972', 'Mikhail', 'Barysnikov', 'Full', 'DAN')}");

cstmt.executeUpdate();

   stmt.close();
   con.close();
}
}
