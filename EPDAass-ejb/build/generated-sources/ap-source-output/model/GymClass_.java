package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Comment;
import model.Feedback;
import model.Inventory;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-05T10:26:14")
@StaticMetamodel(GymClass.class)
public class GymClass_ { 

    public static volatile SingularAttribute<GymClass, String> date;
    public static volatile ListAttribute<GymClass, Feedback> feedback;
    public static volatile ListAttribute<GymClass, Comment> comments;
    public static volatile ListAttribute<GymClass, Inventory> inventories;
    public static volatile SingularAttribute<GymClass, Integer> fee;
    public static volatile SingularAttribute<GymClass, String> name;
    public static volatile SingularAttribute<GymClass, Long> id;
    public static volatile SingularAttribute<GymClass, String> classStatus;
    public static volatile SingularAttribute<GymClass, String> time;
    public static volatile SingularAttribute<GymClass, Integer> paymentStatus;

}