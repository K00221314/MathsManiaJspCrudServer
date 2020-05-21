package repository.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.User;
import support.repository.Support;

public class UserRepository
{

	/**
	 * deletes a User by id from the repository
	 *
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteUserById(int userId) throws SQLException
	{
		User user = getUserById(userId);
		return deleteUser(user);
	}

	/**
	 * Deletes a result from the repository
	 *
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteUser(User user) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		String sql = "DELETE FROM users WHERE user.userid=?;";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getUserid());
			int numberOfRecordsChanged = preparedStatement.executeUpdate();
			return (numberOfRecordsChanged != 0);
		}
		finally
		{
			connection.close();
		}
	}

	public User getUserByCredentials(String username, String password) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String query = "Select * from users where username = ? AND password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
			{
				return transformResultsetToUser(resultSet);
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

	public User getUserById(int userId) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();

		try
		{
			String query = "SELECT * FROM users WHERE user_id = ?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);

			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next())
			{
				return transformResultsetToUser(resultSet);
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

	public ArrayList<User> getUsers() throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String query = "Select * from users";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			ArrayList<User> users = new ArrayList<>();
			while (resultSet.next())
			{
				users.add(transformResultsetToUser(resultSet));
			}
			return users;
		}
		finally
		{
			connection.close();
		}
	}

	public int insertUser(User user) throws SQLException, Exception
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String insertSql = "INSERT INTO users (f_name,l_name,email,username,profile_pic,password,bio) VALUES (?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setString(1, user.getfName());
			preparedStatement.setString(2, user.getlName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, user.getProfilePic());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getBio());
			preparedStatement.executeUpdate();

			int id = Support.getLastInsertedIdOnConnection(connection);
			user.setUserid(id);
			return id;
		}
		finally
		{
			connection.close();
		}
	}

	public void updateUser(User user) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String sql = "UPDATE users SET f_name = ?,l_name = ?,email = ?, username = ?,profile_pic = ?, password = ?,bio = ? WHERE user_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getfName());
			preparedStatement.setString(2, user.getlName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, user.getProfilePic());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getBio());
			preparedStatement.setInt(8, user.getUserid());
			preparedStatement.executeUpdate();
		}
		finally
		{
			connection.close();
		}
	}

	private User transformResultsetToUser(ResultSet resultSet) throws SQLException
	{
		User user = new User();
		user.setUserid(resultSet.getInt("user_id"));
		user.setfName(resultSet.getString("f_name"));
		user.setlName(resultSet.getString("l_name"));
		user.setEmail(resultSet.getString("email"));
		user.setUsername(resultSet.getString("username"));
		user.setProfilePic(resultSet.getString("profile_pic"));
		user.setPassword(resultSet.getString("password"));
		user.setBio(resultSet.getString("bio"));
		return user;
	}

}
