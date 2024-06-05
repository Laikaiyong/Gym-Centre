package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Comment;
import model.GymClass;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-05T10:26:14")
@StaticMetamodel(Customer.class)
public class Customer_ extends BaseUser_ {

    public static volatile SingularAttribute<Customer, Integer> score;
    public static volatile ListAttribute<Customer, Comment> comments;
    public static volatile ListAttribute<Customer, GymClass> classes;

}