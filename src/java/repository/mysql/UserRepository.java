package repository.mysql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DatabaseAgent;
import model.User;

public class UserRepository implements Serializable
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

	public Admin getAdminByCredentials(String username, String password) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String query = "Select * from users where username = ? AND password = ? AND AccountType='Admin' ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
			{
				return transformResultsetToAdmin(resultSet);
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
				return transformResultsetToAdmin(resultSet);
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

	public ArrayList<Admin> getAllUsers()
	{

		ArrayList allusers = new ArrayList<>();

		Connection connection = DatabaseAgent.getConnection();
		PreparedStatement ps = null;
		ResultSet resultSet = null;

		String query = "Select * from users";

		try
		{

			ps = connection.prepareStatement(query);
			resultSet = ps.executeQuery();
			while (resultSet.next())
			{
				Admin s = transformResultsetToAdmin(resultSet);
				allusers.add(s);
			}
			connection.close();
		}
		catch (SQLException ex)
		{
			System.out.println(ex);
			return null;
		}
		return allusers;
	}

	public UserRepository insertAdmin()
	{

		Connection connection = DatabaseAgent.getConnection();
		System.out.println("in S DB");
		String sql = "INSERT INTO users (f_name,l_name,email,username,profile_pic,password,bio) VALUES (?,?,?,?,?,?,?);";
		String query = "SELECT LAST_INSERT_ID()";
		try
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			PreparedStatement ps2 = connection.prepareStatement(query);
			ps.setString(1, this.getF_name());
			ps.setString(2, this.getL_name());
			ps.setString(3, this.getEmail());
			ps.setString(4, this.getUsername());
			ps.setString(5, this.getProfile_pic());
			ps.setString(6, this.getPassword());
			ps.setString(7, this.getBio());
			System.out.println("in S DB Q");
			ps.executeUpdate();
			ResultSet rs = ps2.executeQuery();
			while (rs.next())
			{
				this.setUser_id(rs.getInt(1));
			}

			connection.close();
		}
		catch (SQLException ex)
		{
			System.out.println(ex);
		}
		return this;
	}

	public UserRepository update()
	{

		Connection connection = DatabaseAgent.getConnection();

		String sql = "UPDATE users SET f_name = ?,l_name = ?,email = ?, username = ?,profile_pic = ?, password = ?,bio = ? WHERE user_id=?;";

		try
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, this.getF_name());
			ps.setString(2, this.getL_name());
			ps.setString(3, this.getEmail());
			ps.setString(4, this.getUsername());
			ps.setString(5, this.getProfile_pic());
			ps.setString(6, this.getPassword());
			ps.setString(7, this.getBio());
			ps.executeUpdate();
			connection.close();

		}
		catch (SQLException ex)
		{
			System.out.println(ex);
		}
		return this;
	}

	public void updateUser(Admin admin) throws SQLException
	{
		Connection connection = DatabaseAgent.getConnection();
		try
		{
			String sql = "UPDATE users SET f_name = ?,l_name = ?,email = ?, username = ?,profile_pic = ?, password = ?,bio = ? WHERE user_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getF_name());
			preparedStatement.setString(2, admin.getL_name());
			preparedStatement.setString(3, admin.getEmail());
			preparedStatement.setString(4, admin.getUsername());
			preparedStatement.setString(5, admin.getProfile_pic());
			preparedStatement.setString(6, admin.getPassword());
			preparedStatement.setString(7, admin.getBio());
			preparedStatement.setInt(8, admin.getUser_id());
			preparedStatement.executeUpdate();
		}
		finally
		{
			connection.close();
		}
	}

	public UserRepository updateDatabase(int UserID, String f_name, String l_name, String email, String username, String profile_pic, String password, String bio)
	{

		Connection connection = DatabaseAgent.getConnection();

		this.setF_name(f_name);
		this.setL_name(l_name);
		this.setEmail(email);
		this.setUsername(username);
		this.setProfile_pic(profile_pic);
		this.setPassword(password);
		this.setBio(bio);

		String sql = "UPDATE users SET f_name = ?, l_name = ?, email = ?, username = ?, profile_pic = ?, password = ?, bio = ? WHERE user_id = ? ";

		try
		{
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, this.getF_name());
			ps.setString(2, this.getL_name());
			ps.setString(3, this.getEmail());
			ps.setString(4, this.getUsername());
			ps.setString(5, this.getProfile_pic());
			ps.setString(6, this.getPassword());
			ps.setString(7, this.getBio());
			ps.setInt(8, this.getUser_id());
			System.out.println("ps" + ps.toString());
			ps.executeUpdate();

			connection.close();
		}
		catch (SQLException ex)
		{
			System.out.println(ex);
		}
		return this;
	}

	private Admin transformResultsetToAdmin(ResultSet resultSet) throws SQLException
	{
		Admin admin = new Admin();
		admin.setUser_id(resultSet.getInt("user_id"));
		admin.setF_name(resultSet.getString("f_name"));
		admin.setL_name(resultSet.getString("l_name"));
		admin.setEmail(resultSet.getString("email"));
		admin.setUsername(resultSet.getString("username"));
		admin.setProfile_pic(resultSet.getString("profile_pic"));
		admin.setPassword(resultSet.getString("password"));
		admin.setBio(resultSet.getString("bio"));
		return admin;
	}

}
