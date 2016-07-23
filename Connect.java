import java.sql.*;
public class Connect
{
	Connection cn;
	Statement smt;
	public Connect()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("Jdbc:Odbc:Library");
			smt=cn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}