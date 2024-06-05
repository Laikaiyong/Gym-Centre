package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Feedback;
import model.GymClass;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-06-05T10:06:38")
@StaticMetamodel(Trainer.class)
public class Trainer_ extends BaseUser_ {

    public static volatile ListAttribute<Trainer, GymClass> classes;
    public static volatile ListAttribute<Trainer, Feedback> feedbacks;

}