package model;

import repository.DatabaseUtilityClass;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User implements Serializable {

    private int userid;
    private String fName;
    private String lName;
    private String email;
    private String accountType;
    private String username;
    private String password;
    private String bio;
    private String profilePic;
   

    public User() {
    }

    public User(String fname, String lName, String email, String username, String profilePic, String password, String bio) {
        this.fName = fname;
        this.lName = lName;
        this.email = email;
        this.username = username;
        this.profilePic = profilePic;
        this.password = password;
        this.bio = bio;

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int userid, String fname, String lName, String email, String username, String password, String bio) {
        this.userid = userid;
        this.fName = fname;
        this.lName = lName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;

    }

    public User(int userid) {
        this.userid = userid;
    }

	
    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
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

    /**
     * @return the profilePic
     */
    public String getProfilePic() {
        return profilePic;
    }

    /**
     * @param profilePic the profilePic to set
     */
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

   

    public User Login(String username, String password) {
        System.out.println("in User login");
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "Select * from users where username = ? AND password = ?";

        try {
            System.out.println("in User login try catch");
            System.out.println(username + "  " + password);
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                this.setUserid(resultSet.getInt("user_id"));
                this.setfName(resultSet.getString("f_Name"));
                this.setlName(resultSet.getString("l_Name"));
                this.setEmail(resultSet.getString("email"));
                this.setAccountType(resultSet.getString("accountType"));
                this.setUsername(resultSet.getString("username"));
                this.setProfilePic(resultSet.getString("profile_Pic"));
                this.setPassword(resultSet.getString("password"));
                this.setBio(resultSet.getString("bio"));
                
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return this;

    }

    public User saveToDatabase() {

        Connection connection = DatabaseUtilityClass.getConnection();
        System.out.println("in savetoDB");
        String sql = "INSERT INTO users (f_name,l_name, email, username, profile_pic, password,bio) VALUES (?,?,?,?,?,?,?)";
        String query = "SELECT LAST_INSERT_ID()";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            PreparedStatement ps2 = connection.prepareStatement(query);
            ps.setString(1, this.getfName());
            ps.setString(2, this.getlName());
            ps.setString(3, this.getEmail());
            ps.setString(4, this.getUsername());
            ps.setString(5, this.getProfilePic());
            ps.setString(6, this.getPassword());
            ps.setString(7, this.getBio());
           
            
            System.out.println(ps);

            ps.executeUpdate();
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                this.setUserid(rs.getInt(1));
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

    public User getUserDetails(int userId) {
        User u = null;
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "Select * from Users where user_id = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                u = new User();
                u.setUserid(resultSet.getInt("userId"));
                u.setfName(resultSet.getString("f_name"));
                u.setlName(resultSet.getString("l_name"));
                u.setEmail(resultSet.getString("email"));
                u.setAccountType(resultSet.getString("accountType"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setBio(resultSet.getString("bio"));
                u.setProfilePic(resultSet.getString("profile_pic"));
                return u;
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

        return u;
    }
//

    public User deleteDateabase(int UserID) {
        Connection connection = DatabaseUtilityClass.getConnection();
        System.out.println("in delete DB ");
        String sql = "DELETE Users FROM users WHERE user_id = ? ";
//        String sql2 = "Delete Uploads From uploads Where user_id =?";
//        String sql3 = "Delete Enteries From enteries Where upload_id = (select uploadId from uploads where user_id = ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
//            PreparedStatement ps2 = connection.prepareStatement(sql2);
//            PreparedStatement ps3 = connection.prepareStatement(sql3);

            ps.setInt(1, this.getUserid());
//            ps2.setInt(1, this.getUserid());
//            ps3.setInt(1, this.getUserid());
//
//            ps3.executeUpdate();
//            ps2.executeUpdate();
            ps.executeUpdate();

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

    public User updateDatabase(int userid, String fname, String lName, String email, String username, String profilePic, String password, String bio) {
        Connection connection = DatabaseUtilityClass.getConnection();

        this.setfName(fname);
        this.setlName(lName);
        this.setEmail(email);
        this.setUsername(username);
        this.setProfilePic(profilePic);
        this.setPassword(password);
        this.setBio(bio);
      

        String sql = "UPDATE users SET f_name = ?, l_name = ?, email = ?, username = ?, profile_pic = ?, password = ?, bio = ? WHERE user_id = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, this.getfName());
            ps.setString(2, this.getlName());
            ps.setString(3, this.getEmail());
            ps.setString(4, this.getUsername());
            ps.setString(5, this.getProfilePic());
            ps.setString(6, this.getPassword());
            ps.setString(7, this.getBio());
            ps.setInt(8, this.getUserid());
            System.out.println("ps" + ps.toString());
            ps.executeUpdate();

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }
	
	public ArrayList<User> getAllUsers() {

        ArrayList allusers = new ArrayList<>();

        Connection connection = DatabaseUtilityClass.getConnection();
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
//            
//    

    //    public User updateUser() {
//
//        Connection connection = DatabaseUtilityClass.getConnection();
//         
//        String sql = "UPDATE user SET username = ?, password = ?, "
//                + "email = ?, phone = ?, course = ? WHERE userid = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            
//            ps.setString(1, this.getUsername());
//            ps.setString(2, this.getPassword());
//            ps.setString(3, this.getEmail());
//            ps.setString(4, this.getPhone());
//            ps.setString(5, this.getCourse());
//            ps.setInt(6, this.userid);
//            
//
//            ps.executeUpdate();
//            connection.close();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return this;
//    }
    /**
     * @return the course
     */
}
