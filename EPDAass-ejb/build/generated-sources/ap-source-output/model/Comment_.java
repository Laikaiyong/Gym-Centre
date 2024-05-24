package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Feedback;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-05-24T23:38:17")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, String> rating;
    public static volatile ListAttribute<Comment, Feedback> feedbacks;
    public static volatile SingularAttribute<Comment, String> description;
    public static volatile SingularAttribute<Comment, Long> id;

}