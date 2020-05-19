/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

        try {
            PreparedStatement ps = connection.prepareStatement(sql);


            ps.setInt(1, this.getUserid());
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
    
	
//	public static String addQuestion(String question,String a,String b,String c,String d,String set,String answer){
//		String query="insert into "+DatabaseUtilityClass.QUESTION_TABLE+" ("+DatabaseUtilityClass.TEXT_COL+","+DatabaseUtilityClass.SET_COL+","+DatabaseUtilityClass.ANSWER_COL+") values(?,?,?)";
//		int id=0;
//		
//		try{
//			Connection con=DBConnect.getConnection();
//			PreparedStatement ps=con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			ps.setString(1,question);
//			ps.setString(2,set);
//			ps.setString(3,answer);
//			
//			ps.executeUpdate();
//			ResultSet rs=ps.getGeneratedKeys();
//			
//			if(rs.next()){
//				id=rs.getInt(1);
//			}
//			
//			query="insert into "+DatabaseUtilityClass.CHOICE_TABLE+" ("+DatabaseUtilityClass.TEXT_COL+","+DatabaseUtilityClass.QUESTION_ID_COL+") values(?,?)";
//			ps=con.prepareStatement(query);
//			ps.setString(1,a);
//			ps.setInt(2,id);
//			ps.executeUpdate();
//			
//			query="insert into "+DatabaseUtilityClass.CHOICE_TABLE+" ("+DatabaseUtilityClass.TEXT_COL+","+DatabaseUtilityClass.QUESTION_ID_COL+") values(?,?)";
//			ps=con.prepareStatement(query);
//			ps.setString(1,b);
//			ps.setInt(2,id);
//			ps.executeUpdate();
//
//			query="insert into "+DatabaseUtilityClass.CHOICE_TABLE+" ("+DatabaseUtilityClass.TEXT_COL+","+DatabaseUtilityClass.QUESTION_ID_COL+") values(?,?)";
//			ps=con.prepareStatement(query);
//			ps.setString(1,c);
//			ps.setInt(2,id);
//			ps.executeUpdate();
//
//			query="insert into "+DatabaseUtilityClass.CHOICE_TABLE+" ("+DatabaseUtilityClass.TEXT_COL+","+DatabaseUtilityClass.QUESTION_ID_COL+") values(?,?)";
//			ps=con.prepareStatement(query);
//			ps.setString(1,d);
//			ps.setInt(2,id);
//			ps.executeUpdate();
//
//			return "true";
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return "false";
//	}
//	
//	public static JSONArray getQuestions(String set){
//		String query="select * from "+DatabaseUtilityClass.QUESTION_TABLE+" where "+DatabaseUtilityClass.SET_COL+"=?";
//		JSONArray array=new JSONArray();
//		JSONObject obj;
//		
//		try{
//			Connection con=DatabaseUtilityClass.getConnection();
//			PreparedStatement ps=con.prepareStatement(query);
//			ps.setString(1,set);
//			
//			ResultSet rs=ps.executeQuery();			
//			ResultSet rs1=null;
//			
//			while(rs.next()){
//				obj=new JSONObject();
//				obj.put("id", rs.getString(DatabaseUtilityClass.ID_COL));
//				obj.put("question", rs.getString(DatabaseUtilityClass.TEXT_COL));
//				obj.put("answer", rs.getString(DatabaseUtilityClass.ANSWER_COL));
//				
//				query="select * from "+DatabaseUtilityClass.CHOICE_TABLE+" where "+DatabaseUtilityClass.QUESTION_ID_COL+"=?";
//				ps=con.prepareStatement(query);
//				ps.setString(1,rs.getString(DatabaseUtilityClass.ID_COL));
//				rs1=ps.executeQuery();
//				
//				rs1.absolute(1);
//				obj.put("a", rs1.getString(DatabaseUtilityClass.TEXT_COL));
//				
//				rs1.absolute(2);
//				obj.put("b", rs1.getString(DatabaseUtilityClass.TEXT_COL));
//				
//				rs1.absolute(3);
//				obj.put("c", rs1.getString(DatabaseUtilityClass.TEXT_COL));
//				
//				rs1.absolute(4);
//				obj.put("d", rs1.getString(DatabaseUtilityClass.TEXT_COL));
//				
//				array.add(obj);
//			}
//			
//			rs.close();
//			rs1.close();
//			ps.close();
//			con.close();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return array;
//	}
//	
//	public static JSONArray getResult(){
//		String query="select * from "+DatabaseUtilityClass.USER_TABLE;
//		JSONArray array= new JSONArray();
//		JSONObject obj;
//		
//		try{
//			Connection con=DatabaseUtilityClass.getConnection();
//			PreparedStatement ps=con.prepareStatement(query);
//			
//			ResultSet rs=ps.executeQuery();
//			ResultSet rs1=null;
//			query="select * from "+DatabaseUtilityClass.RESULT_TABLE+" where "+DatabaseUtilityClass.USER_ID_COL+"=?";
//			
//			while(rs.next()){
//				ps=con.prepareStatement(query);
//				ps.setString(1,rs.getString(DatabaseUtilityClass.ID_COL));
//				rs1=ps.executeQuery();
//				int points=0;
//				
//				while(rs1.next()){
//					if(checkAnswer(rs1.getString(DatabaseUtilityClass.QUESTION_ID_COL), rs1.getString(DatabaseUtilityClass.ANSWER_COL))){
//						points++;
//					}
//				}
//				
//				obj=new JSONObject();
//				obj.put("name", rs.getString(DatabaseUtilityClass.NAME_COL));
//				obj.put("email", rs.getString(DatabaseUtilityClass.EMAIL_COL));
//				obj.put("points", points);
//				array.add(obj);
//			}
//			
//			rs1.close();
//			rs.close();
//			ps.close();
//			con.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	    JSONArray sortedJsonArray = new JSONArray();
//
//	    ArrayList<JSONObject> jsonValues = new ArrayList<JSONObject>();
//	    
//	    for (int i = 0; i < array.size(); i++) {
//	        jsonValues.add((JSONObject)array.get(i));
//	    }
//	    
//	    Collections.sort( jsonValues, new Comparator<JSONObject>() {
//	        //You can change "Name" with "ID" if you want to sort by ID
//	        private static final String KEY_NAME = "points";
//
//	        @Override
//	        public int compare(JSONObject a, JSONObject b) {
//	        	Integer valA=null;
//	        	Integer valB=null;
//	        	
//	            try {
//	                valA = new Integer(String.valueOf(a.get(KEY_NAME)));
//		            valB = new Integer(String.valueOf(b.get(KEY_NAME)));
//	            } 
//	            catch (Exception e) {
//	                e.printStackTrace();
//	            }
//
//	            return valB > valA ? 1 : valB < valA ? -1 : 0;
//	            //if you want to change the sort order, simply use the following:
//	            //return -valA.compareTo(valB);
//	        }
//		});
//		
//
//	    for (int i = 0; i < array.size(); i++) {
//	        sortedJsonArray.add(jsonValues.get(i));
//	    }
//		
//		return sortedJsonArray;
//	}
//	
//	public static boolean checkAnswer(String id,String answer){
//		String query="select * from "+DatabaseUtilityClass.QUESTION_TABLE+" where "+DatabaseUtilityClass.ID_COL+"=?";
//		
//		try{
//			Connection con=DatabaseUtilityClass.getConnection();
//			PreparedStatement ps=con.prepareStatement(query);
//			ps.setString(1,id);
//			
//			ResultSet rs=ps.executeQuery();
//			
//			if(rs.next()){
//				if(rs.getString(DatabaseUtilityClass.ANSWER_COL).equals(answer)){
//					return true;
//				}
//			}
//			
//			rs.close();
//			ps.close();
//			con.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//				
//		return false;
//	}
//	
//	public static JSONObject getQuestion(String id){
//		String query="select * from "+DatabaseUtilityClass.QUESTION_TABLE+" where "+DatabaseUtilityClass.ID_COL+"=?";
//		JSONObject obj=null;
//		
//		try{
//			Connection con=DatabaseUtilityClass.getConnection();
//			PreparedStatement ps=con.prepareStatement(query);
//			ps.setString(1,id);
//			
//			ResultSet rs=ps.executeQuery();			
//			ResultSet rs1=null;
//			
//			if(rs.next()){
//				obj=new JSONObject();
//				obj.put("id", rs.getString(DatabaseUtilityClass.ID_COL));
//				obj.put("question", rs.getString(DatabaseUtilityClass.TEXT_COL));
//				obj.put("answer", rs.getString(DatabaseUtilityClass.ANSWER_COL));
//				obj.put("set", rs.getString(DatabaseUtilityClass.SET_COL));
//				
//				query="select * from "+DatabaseUtilityClass.CHOICE_TABLE+" where "+DatabaseUtilityClass.QUESTION_ID_COL+"=?";
//				ps=con.prepareStatement(query);
//				ps.setString(1,rs.getString(DatabaseUtilityClass.ID_COL));
//				rs1=ps.executeQuery();
//				
//				rs1.absolute(1);
//				obj.put("a", rs1.getString(DatabaseUtilityClass.TEXT_COL));
//				
//				rs1.absolute(2);
//				obj.put("b", rs1.getString(DatabaseUtilityClass.TEXT_COL));
//				
//				rs1.absolute(3);
//				obj.put("c", rs1.getString(DatabaseUtilityClass.TEXT_COL));
//				
//				rs1.absolute(4);
//				obj.put("d", rs1.getString(DatabaseUtilityClass.TEXT_COL));
//				
//			}
//			
//			rs.close();
//			rs1.close();
//			ps.close();
//			con.close();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return obj;
//	}
//
//	public static String deleteQuestion(String id){
//		String query="delete from "+DatabaseUtilityClass.QUESTION_TABLE+" where "+DatabaseUtilityClass.ID_COL+"=?";
//		int result1=0,result2=0;
//		
//		try{
//			Connection con=DatabaseUtilityClass.getConnection();
//			PreparedStatement ps=con.prepareStatement(query);
//			ps.setString(1, id);
//			
//			result1=ps.executeUpdate();
//			
//			query="delete from "+DatabaseUtilityClass.CHOICE_TABLE+" where "+DatabaseUtilityClass.QUESTION_ID_COL+"=?";
//			ps=con.prepareStatement(query);
//			ps.setString(1,id);
//			result2=ps.executeUpdate();
//			
//			if(result1>0&&result2>0){
//				return "true";
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return "false";
//	}
//	
//	public static boolean checkAnswerExists(String id,LinkedHashMap lhm){
//		if(lhm.containsKey(id)){
//			if(lhm.get(id)!=null){
//				return true;
//			}
//		}
//		
//		return false;
//	}
}
