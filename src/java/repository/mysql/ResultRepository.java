package repository.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DatabaseAgent;
import entities.Results;
import support.repository.Support;

/**
 *
 * @author Rob
 */
public class ResultRepository
{

	/**
	 * deletes a result by id from the repository
	 *
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static boolean deleteResultById(int id) throws SQLException
	{
		Results result = getResultById(id);
		return deleteResult(result);
	}

	/**
	 * Deletes a result from the repository
	 *
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	public static boolean deleteResult(Results result) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		String sql = "DELETE FROM results WHERE results.Id=?;";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, result.getId());
			int numberOfRecordsChanged = preparedStatement.executeUpdate();
			return (numberOfRecordsChanged != 0);
		}
		finally
		{
			connection.close();
		}
	}

	/**
	 *
	 * @param Id
	 * @return
	 * @throws java.sql.SQLException
	 */
	public static Results getResultById(int Id) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String sqlQuery = "SELECT * FROM results WHERE Id = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, Id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				return transformResultsSetToResult(resultSet);
			}
			else
			{
				return null;
			}
		}
		finally
		{
			connection.close();
		}
	}

	public static ArrayList<Results> getResults() throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String sqlQuery = "Select * from results";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			ArrayList allresults = new ArrayList<>();
			while (resultSet.next())
			{
				allresults.add(transformResultsSetToResult(resultSet));
			}
			return allresults;
		}
		finally
		{
			connection.close();
		}
	}

	/**
	 * Inserts a Result into the repository
	 *
	 * @param result
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static int insertResult(Results result) throws SQLException, Exception
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String insertSql = "INSERT INTO results (category,type,difficulty,question,correct_answer,incorrect_answers1) VALUES (?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setString(1, result.getCategory());
			preparedStatement.setString(2, result.getType());
			preparedStatement.setString(3, result.getDifficulty());
			preparedStatement.setString(4, result.getQuestion());
			preparedStatement.setString(5, result.getCorrect_answer());
			preparedStatement.setString(6, result.getIncorrect_answers1());
			preparedStatement.executeUpdate();

			int id = Support.getLastInsertedIdOnConnection(connection);
			result.setId(id);
			return id;
		}
		finally
		{
			connection.close();
		}
	}

	public static void updateResult(Results result) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();

		try
		{
			String updateSqlStatement = "UPDATE results SET  category = ?,type = ?,difficulty = ?, question = ?,correct_answer = ?, incorrect_answers1 = ? WHERE Id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(updateSqlStatement);
			preparedStatement.setString(1, result.getCategory());
			preparedStatement.setString(2, result.getType());
			preparedStatement.setString(3, result.getDifficulty());
			preparedStatement.setString(4, result.getQuestion());
			preparedStatement.setString(5, result.getCorrect_answer());
			preparedStatement.setString(6, result.getIncorrect_answers1());
			preparedStatement.setInt(7, result.getId());

			preparedStatement.executeUpdate();
		}
		finally
		{
			connection.close();
		}
	}

	/*
	Private Methods
	 */
	/**
	 *
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private static Results transformResultsSetToResult(ResultSet resultSet) throws SQLException
	{
		Results result = new Results();
		result.setId(resultSet.getInt("Id"));
		result.setCategory(resultSet.getString("category"));
		result.setType(resultSet.getString("type"));
		result.setDifficulty(resultSet.getString("difficulty"));
		result.setQuestion(resultSet.getString("question"));
		result.setCorrect_answer(resultSet.getString("correct_answer"));
		result.setIncorrect_answers1(resultSet.getString("incorrect_answers1"));
		return result;
	}

}
