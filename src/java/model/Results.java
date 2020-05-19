/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daly
 */
public class Results {

    private int Id;
    private String category;
    private String type;

    private String difficulty;

    private String question;
    private String correct_answer;
    private String incorrect_answers1;

    public Results(String category, String type, String difficulty, String question, String correct_answer, String incorrect_answers1) {
        this.category=category;
        this.type=type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers1 = incorrect_answers1;
    }

    public Results() {
        
    }

    public Results(int Id, String category, String type, String difficulty, String question, String correct_answer, String incorrect_answers1) {
        this.Id = Id;
        this.category=category;
        this.type=type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers1 = incorrect_answers1;
    }

    public Results(int Id) {
        this.Id = Id;
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getIncorrect_answers1() {
        return incorrect_answers1;
    }

    public void setIncorrect_answers1(String incorrect_answers1) {
        this.incorrect_answers1 = incorrect_answers1;
    }
    
    public Results saveToDatabase() {

        Connection connection = DatabaseUtilityClass.getConnection();
        System.out.println("in S DB");
        String sql = "INSERT INTO results (category,type,difficulty,question,correct_answer,incorrect_answers1) VALUES (?,?,?,?,?,?);";
        String query = "SELECT LAST_INSERT_ID()";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            PreparedStatement ps2 = connection.prepareStatement(query);
            ps.setString(1, this.getCategory());
            ps.setString(2, this.getType());
            ps.setString(3, this.getDifficulty());
            ps.setString(4, this.getQuestion());
            ps.setString(5, this.getCorrect_answer());
            ps.setString(6, this.getIncorrect_answers1());
            
            System.out.println("in S DB Q");
            ps.executeUpdate();
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                this.setId(rs.getInt(1));
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Results update() {

        Connection connection = DatabaseUtilityClass.getConnection();

        String sql = "UPDATE results SET category = ?,type = ?,difficulty = ?, question = ?,correct_answer = ?, incorrect_answers1 = ? WHERE Id=?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, this.getCategory());
            ps.setString(2, this.getType());
            ps.setString(3, this.getDifficulty());
            ps.setString(4, this.getQuestion());
            ps.setString(5, this.getCorrect_answer());
            ps.setString(6, this.getIncorrect_answers1());
            //ps.setInt(7, this.Id);
            //addd in ps 7 testing
          
            ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Results delete(int Id) {
        Connection connection = DatabaseUtilityClass.getConnection();

        String sql = "DELETE FROM results WHERE results.Id=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, this.Id);

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
    public Results getResultsDetails(int Id) {
        Results result = null;
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM results WHERE Id = ?;";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, Id);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                result = new Results();
                result.setId(resultSet.getInt("Id"));
                result.setCategory(resultSet.getString("category"));
                result.setType(resultSet.getString("type"));
                result.setDifficulty(resultSet.getString("difficulty"));
                result.setQuestion(resultSet.getString("question"));
                result.setCorrect_answer(resultSet.getString("correct_answer"));
                result.setIncorrect_answers1(resultSet.getString("incorrect_answers1"));
               
                return result;
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public ArrayList<Results> getAllResults() {

        ArrayList allresults = new ArrayList<>();

        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "Select * from results";

        try {

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Results result = new Results();
                result.setId(resultSet.getInt("Id"));
                result.setCategory(resultSet.getString("category"));
                result.setType(resultSet.getString("type"));
                result.setDifficulty(resultSet.getString("difficulty"));
                result.setQuestion(resultSet.getString("question"));
                result.setCorrect_answer(resultSet.getString("correct_answer"));
                result.setIncorrect_answers1(resultSet.getString("incorrect_answers1"));
                allresults.add(result);
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return allresults;
    }

    public Results updateResults() {
        Connection connection = DatabaseUtilityClass.getConnection();
        String sql = "UPDATE results SET  category = ?,type = ?,difficulty = ?, question = ?,correct_answer = ?, incorrect_answers1 = ? WHERE Id=?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, this.getCategory());
            ps.setString(2, this.getType());
            ps.setString(3, this.getDifficulty());
            ps.setString(4, this.getQuestion());
            ps.setString(5, this.getCorrect_answer());
            ps.setString(6, this.getIncorrect_answers1());
          
            ps.setInt(7, this.getId());

            ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("in update results");
        }
        return this;
    }

    public boolean deleteResult(int Id) {

        Results result = null;
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String sql = "DELETE results FROM results WHERE Id = ? ";
        
        try {
            ps = connection.prepareStatement(sql);
            

            ps.setInt(1, Id);
      
           
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

    public Results updateResultsDatabase(int Id, String category, String type, String difficulty, String question, String correct_answer, String incorrect_answers1) {
         Connection connection = DatabaseUtilityClass.getConnection();

        this.setCategory(category);
        this.setType(type);
        this.setDifficulty(difficulty);
        this.setQuestion(question);
        this.setCorrect_answer(correct_answer);
        this.setIncorrect_answers1(incorrect_answers1);
      
      

        String sql = "UPDATE results SET category = ?, type = ?, difficulty = ?, question = ?, correct_answer = ?, incorrect_answers1 = ? WHERE Id = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, this.getCategory());
            ps.setString(2, this.getType());
            ps.setString(3, this.getDifficulty());
            ps.setString(4, this.getQuestion());
            ps.setString(5, this.getCorrect_answer());
            ps.setString(6, this.getIncorrect_answers1());
          
            ps.setInt(7, this.getId());
            System.out.println("ps" + ps.toString());
            ps.executeUpdate();

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }

}
