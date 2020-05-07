/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import repository.DatabaseUtilityClass;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Uploads implements Serializable {

    private int uploadId;
    private String image;
    private String title;
    private String description;
    private int userId;
    private String username;
    private int rating;

    public Uploads() {
    }

    public Uploads(int uploadId, String image, String title, String description, int userId) {
        this.uploadId = uploadId;
        this.image = image;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Uploads(int uploadId, String image, String title, String description) {
        this.uploadId = uploadId;
        this.image = image;
        this.title = title;
        this.description = description;
      
    }
    
    public Uploads(String image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public Uploads(String image, String title, String description, int userId) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.userId = userId;
        System.out.println("Construtor :" + this.userId);
    }

    /**
     * @return the uploadID
     */
    public int getUploadID() {
        return uploadId;
    }

    /**
     * @param uploadID the uploadID to set
     */
    public void setUploadID(int uploadID) {
        this.uploadId = uploadID;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    public ArrayList<Uploads> getAllUploads() {
        System.out.println("get all uploads");
        ArrayList allUploads = new ArrayList<>();

        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "SELECT `uploadId`,`image`,`title`,`description`,uploads.user_id,users.username, rating\n"
                + "FROM `uploads`join users on uploads.user_id = users.user_id WHERE 1";

        try {

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Uploads u = new Uploads();
                u.setUploadID(resultSet.getInt("uploadId"));
                u.setImage(resultSet.getString("image"));
                u.setTitle(resultSet.getString("title"));
                u.setDescription(resultSet.getString("description"));
                u.setUserId(resultSet.getInt("user_Id"));
                u.setUsername(resultSet.getString("username"));
                u.setRating(resultSet.getInt("rating"));
                allUploads.add(u);
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

        return allUploads;
    }

    public ArrayList<Uploads> getUserUploads(int id) {
        System.out.println("get user uploads");
        ArrayList userUploads = new ArrayList<>();

        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "select * from uploads where user_Id in( select user_id from users where user_Id=?); ";

        try {

            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Uploads u = new Uploads();
                u.setUploadID(resultSet.getInt("uploadId"));
                u.setImage(resultSet.getString("image"));
                u.setTitle(resultSet.getString("title"));
                u.setDescription(resultSet.getString("description"));
                u.setUserId(resultSet.getInt("user_Id"));
                 u.setRating(resultSet.getInt("rating"));
                userUploads.add(u);
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

        return userUploads;
    }

    public Uploads saveToDatabase() {
        System.out.println("In upload save to db");
        Connection connection = DatabaseUtilityClass.getConnection();

        String sql = "INSERT INTO uploads (image,title,description, user_Id) VALUES (?,?,?,?);";
        String query = "SELECT LAST_INSERT_ID()";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            PreparedStatement ps2 = connection.prepareStatement(query);

            ps.setString(1, this.getImage());
            ps.setString(2, this.getTitle());
            ps.setString(3, this.getDescription());
            ps.setInt(4, this.getUserId());
            System.out.println("save to db id: " + this.getUserId());
            ps.executeUpdate();
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                this.uploadId = rs.getInt(1);
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Uploads getUploadDetails(int id) {
        System.out.println("get UD");
        System.out.println(id);
        Uploads u = null;
        
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "Select * from uploads where uploadId = ?";

        try {
          
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                 
                Uploads u2 = new Uploads();
                u2.setUploadID(resultSet.getInt("uploadId"));
                u2.setImage(resultSet.getString("image"));
                u2.setTitle(resultSet.getString("title"));
                u2.setDescription(resultSet.getString("description"));
                u2.setUserId(resultSet.getInt("user_Id"));
                 u2.setRating(resultSet.getInt("rating"));
                System.out.println(u2.toString());
                return u2;
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

        return u;
    }

    public boolean deleteUpload(int id) {
        System.out.println("uploads delete upload");
        Uploads u = null;
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "DELETE FROM uploads WHERE uploadId = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

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

    public Uploads updateDateabase(int uploadId, String image, String title, String description) {
        Connection connection = DatabaseUtilityClass.getConnection();
        System.out.println("in update db uplads");
        this.image = image;
        this.title = title;
        this.description = description;
        this.uploadId = uploadId;

        String sql = "UPDATE uploads SET image = ?, title = ?, description = ? WHERE uploadId = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, this.image);
            ps.setString(2, this.title);
            ps.setString(3, this.description);
              ps.setInt(4, this.uploadId);

            System.out.println("ps" + ps.toString());
            ps.executeUpdate();

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Uploads getSelectedUpload(int nid) {
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "select * from uploads where uploadId = ?; ";
        Uploads u = new Uploads();
        try {

            ps = connection.prepareStatement(query);
            ps.setInt(1, nid);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                u.setUploadID(resultSet.getInt("uploadId"));
                u.setImage(resultSet.getString("image"));
                u.setTitle(resultSet.getString("title"));
                u.setDescription(resultSet.getString("description"));
                u.setUserId(resultSet.getInt("user_Id"));
                 u.setRating(resultSet.getInt("rating"));
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

        return u;

    }
}
