package profile_post;

import java.sql.DriverManager;
import java.sql.*;


/* Created By Seriaa Bakir
*/



public class ConnectDB {

	public static Connection connect ()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook","root","");  
			return con;
		}
		catch (Exception ex)
		{
			
		}
		return null;
	}
	
	public static void main(String[] args) {
	
		
	}
		
			
}