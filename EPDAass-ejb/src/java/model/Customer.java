/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.io.Serializable;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vandycklai
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Customer")
public class Customer extends BaseUser implements Serializable {
    
    public Customer() {}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    @Column(name = "score")
    private int score;
    
    @OneToMany
    protected ArrayList<GymClass> classes = new ArrayList<>();

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    
        @OneToMany
    protected ArrayList<Comment> comments = new ArrayList<>();
    

    public ArrayList<GymClass> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<GymClass> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "model.Customer [ id=" + this.getUsername() + " ]";
    }
    
}
