package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {

      System.out.println(DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","myaimspace")); 

    Connection  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","myaimspace");
      Statement s = conn.createStatement();
      
      ResultSet rs = s.executeQuery("select * from dukandar where city = 'katni' ");
      rs.next();
      rs.next();
      
      System.out.println(rs.getString("suppliername"));
      System.out.println(rs.getString("status"));
      System.out.println(rs.getString("premise"));
	}

}
