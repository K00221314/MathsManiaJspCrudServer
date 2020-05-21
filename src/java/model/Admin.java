package model;

import java.io.Serializable;

public class Admin implements Serializable {

    private int user_id;
    private String f_name;
    private String l_name;
    private String email;
    private String username;
    private String profile_pic;
    private String password;
    private String bio;
    private String AccountType;

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
        this.AccountType = AccountType;
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
    
}
