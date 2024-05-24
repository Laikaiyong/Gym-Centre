/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Trainer")
public class Trainer extends BaseUser implements Serializable {

    public Trainer() {
    }

    @Override
    public String toString() {
        return "model.Trainer[ id=" + this.getUsername() + " ]";
    }

    @OneToMany
    protected ArrayList<GymClass> classes = new ArrayList<>();

    @OneToMany
    protected ArrayList<Feedback> feedbacks = new ArrayList<>();

    public ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(ArrayList<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public ArrayList<GymClass> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<GymClass> classes) {
        this.classes = classes;
    }
}
