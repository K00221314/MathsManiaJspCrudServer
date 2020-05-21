package repository.mysql;

import model.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminRepository implements Serializable {

  

   

    public AdminRepository Login(String username, String password) {

        Connection connection = DatabaseAgent.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "Select * from users where username = ? AND password = ? AND AccountType='Admin' ";

        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                this.user_id = resultSet.getInt("user_id");
                this.f_name = resultSet.getString("f_name");
                this.l_name = resultSet.getString("l_name");
                this.email = resultSet.getString("email");
                this.username = resultSet.getString("username");
                this.profile_pic = resultSet.getString("profile_pic");
                this.password = resultSet.getString("password");
                this.bio = resultSet.getString("bio");
                this.AccountType = resultSet.getString("AccountType");

            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return this;

    }

    public AdminRepository saveToDatabase() {

        Connection connection = DatabaseAgent.getConnection();
        System.out.println("in S DB");
        String sql = "INSERT INTO users (f_name,l_name,email,username,profile_pic,password,bio) VALUES (?,?,?,?,?,?,?);";
        String query = "SELECT LAST_INSERT_ID()";
        try {
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
            while (rs.next()) {
                this.setUser_id(rs.getInt(1));
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

    public AdminRepository update() {

        Connection connection = DatabaseAgent.getConnection();

        String sql = "UPDATE users SET f_name = ?,l_name = ?,email = ?, username = ?,profile_pic = ?, password = ?,bio = ? WHERE user_id=?;";

        try {
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

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

    public AdminRepository delete(int userid) {
        Connection connection = DatabaseAgent.getConnection();

        String sql = "DELETE FROM users WHERE user.userid=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, this.user_id);

            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

//    public User getUserDetails(){
//        
//    }
    public AdminRepository getUserDetails(int user_id) {
        AdminRepository u = null;
        Connection connection = DatabaseAgent.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM users WHERE user_id = ?;";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, user_id);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                u = new AdminRepository();
                u.setUser_id(resultSet.getInt("user_id"));
                u.setF_name(resultSet.getString("f_name"));
                u.setL_name(resultSet.getString("l_name"));
                u.setEmail(resultSet.getString("email"));
                u.setUsername(resultSet.getString("username"));
                u.setProfile_pic(resultSet.getString("profile_pic"));
                u.setPassword(resultSet.getString("password"));
                u.setBio(resultSet.getString("bio"));
                return u;
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public ArrayList<AdminRepository> getAllUsers() {

        ArrayList allusers = new ArrayList<>();

        Connection connection = DatabaseAgent.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "Select * from users";

        try {

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                AdminRepository s = new AdminRepository();
                s.setUser_id(resultSet.getInt("user_id"));
                s.setF_name(resultSet.getString("f_name"));
                s.setL_name(resultSet.getString("l_name"));
                s.setEmail(resultSet.getString("email"));
                s.setUsername(resultSet.getString("username"));
                s.setProfile_pic(resultSet.getString("profile_pic"));
                s.setPassword(resultSet.getString("password"));
                s.setBio(resultSet.getString("bio"));
                allusers.add(s);
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return allusers;
    }

    public AdminRepository updateUser() {
        Connection connection = DatabaseAgent.getConnection();
        String sql = "UPDATE users SET f_name = ?,l_name = ?,email = ?, username = ?,profile_pic = ?, password = ?,bio = ? WHERE user_id=?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, this.getF_name());
            ps.setString(2, this.getL_name());
            ps.setString(3, this.getEmail());
            ps.setString(4, this.getUsername());
            ps.setString(5, this.getProfile_pic());
            ps.setString(6, this.getPassword());
            ps.setString(7, this.getBio());
          
            ps.setInt(8, this.getUser_id());

            ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("in update user");
        }
        return this;
    }

    public boolean deleteUser(int user_id) {

        AdminRepository a = null;
        Connection connection = DatabaseAgent.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String sql = "DELETE Users FROM users WHERE user_id = ? ";
       
        try {
            ps = connection.prepareStatement(sql);
           

            ps.setInt(1, user_id);
            
            int i = ps.executeUpdate();
            if (i == 0) {
                return false;
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

	public AdminRepository updateDatabase(int UserID, String f_name, String l_name, String email, String username, String profile_pic, String password, String bio)
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

        try {
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
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
	}

    
}
