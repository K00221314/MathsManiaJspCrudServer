package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseUtilityClass
{

	public static Connection getConnection()
	{

		try
		{
			String host = "localhost";
			String dbName = "mathmania1";
			int port = 3306;

			String mySqlUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?serverTimezone=UTC";

			
			Properties userInfo = new Properties();
			userInfo.put("user", "root");
			userInfo.put("password", "letmein1");

			Connection connection = DriverManager.getConnection(mySqlUrl, userInfo);
			return connection;
		} catch (Exception ex)
		{
			System.out.println("error on db connection" + ex.getMessage());
		}
		System.out.println("Fatal Error");
		return null;
	}
}
