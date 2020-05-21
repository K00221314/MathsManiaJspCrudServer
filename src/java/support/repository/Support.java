package support.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rob
 */
public class Support
{

	public static int getLastInsertedIdOnConnection(Connection connection) throws Exception, SQLException
	{
		String sqlQuery = "SELECT LAST_INSERT_ID()";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next())
		{
			return resultSet.getInt(1);
		}
		else
		{
			throw new Exception("SQL failed");
		}
	}	
}
