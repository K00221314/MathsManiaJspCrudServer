/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rob
 */
@Entity
@Table(name = "results")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Results.findAll", query = "SELECT r FROM Results r")
    , @NamedQuery(name = "Results.findById", query = "SELECT r FROM Results r WHERE r.id = :id")
    , @NamedQuery(name = "Results.findByCategory", query = "SELECT r FROM Results r WHERE r.category = :category")
    , @NamedQuery(name = "Results.findByType", query = "SELECT r FROM Results r WHERE r.type = :type")
    , @NamedQuery(name = "Results.findByDifficulty", query = "SELECT r FROM Results r WHERE r.difficulty = :difficulty")
    , @NamedQuery(name = "Results.findByQuestion", query = "SELECT r FROM Results r WHERE r.question = :question")
    , @NamedQuery(name = "Results.findByCorrectAnswer", query = "SELECT r FROM Results r WHERE r.correctAnswer = :correctAnswer")
    , @NamedQuery(name = "Results.findByIncorrectAnswers1", query = "SELECT r FROM Results r WHERE r.incorrectAnswers1 = :incorrectAnswers1")})
public class Results implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "difficulty")
    private String difficulty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "correct_answer")
    private String correctAnswer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "incorrect_answers1")
    private String incorrectAnswers1;

    public Results() {
    }

    public Results(Integer id) {
        this.id = id;
    }

    public Results(Integer id, String category, String type, String difficulty, String question, String correctAnswer, String incorrectAnswers1) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers1 = incorrectAnswers1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getIncorrectAnswers1() {
        return incorrectAnswers1;
    }

    public void setIncorrectAnswers1(String incorrectAnswers1) {
        this.incorrectAnswers1 = incorrectAnswers1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Results)) {
            return false;
        }
        Results other = (Results) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restful.Results[ id=" + id + " ]";
    }
    
}
