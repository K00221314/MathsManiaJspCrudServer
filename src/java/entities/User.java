package entities;

import java.io.Serializable;

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
}