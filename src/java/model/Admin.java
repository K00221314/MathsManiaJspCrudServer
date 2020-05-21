package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Admin implements Serializable {



    private int user_id;
    private String f_name;
    private String l_name;
    private String email;
    private String username;
    private String profile_pic;
    private String password;
    private String bio;
    private String accountType;

    public Admin() {
    }

    public Admin(int user_id, String f_name, String l_name, String email, String username, String profile_pic, String password, String bio, String AccountType) {
        this.user_id = user_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.username = username;
        this.profile_pic = profile_pic;
        this.password = password;
        this.bio = bio;
        this.accountType = AccountType;
    }

    public Admin(String f_name, String l_name, String email, String username, String profile_pic, String password, String bio) {

        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.username = username;
        this.profile_pic = profile_pic;
        this.password = password;
        this.bio = bio;
//        this.AccountType=AccountType;

    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
//        this.AccountType= AccountType;
    }

    public Admin(int user_id, String f_name, String l_name, String email, String username, String profile_pic, String password, String bio) {
        this.user_id = user_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.username = username;
        this.profile_pic = profile_pic;
        this.password = password;
        this.bio = bio;
//        this.AccountType=AccountType;
    }

    public Admin(int user_id) {
        this.user_id = user_id;
    }

   

    public Admin Login(String username, String password) {

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
				this.setAccountType(resultSet.getString("AccountType"));

            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return this;

    }

    public Admin saveToDatabase() {

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

    public Admin update() {

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

    public Admin delete(int userid) {
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
    public Admin getUserDetails(int user_id) {
        Admin u = null;
        Connection connection = DatabaseAgent.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM users WHERE user_id = ?;";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, user_id);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                u = new Admin();
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

    public ArrayList<Admin> getAllUsers() {

        ArrayList allusers = new ArrayList<>();

        Connection connection = DatabaseAgent.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "Select * from users";

        try {

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Admin s = new Admin();
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

    public Admin updateUser() {
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

        Admin a = null;
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

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the f_name
     */
    public String getF_name() {
        return f_name;
    }

    /**
     * @param f_name the f_name to set
     */
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    /**
     * @return the l_name
     */
    public String getL_name() {
        return l_name;
    }

    /**
     * @param l_name the l_name to set
     */
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the profile_pic
     */
    public String getProfile_pic() {
        return profile_pic;
    }

    /**
     * @param profile_pic the profile_pic to set
     */
    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

	public Admin updateDatabase(int UserID, String f_name, String l_name, String email, String username, String profile_pic, String password, String bio)
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
	/**
	 * @return the accountType
	 */
	public String getAccountType()
	{
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}
    
}
