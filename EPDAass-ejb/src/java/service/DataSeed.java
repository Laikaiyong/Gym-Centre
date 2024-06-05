/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.BaseUser;
import model.Comment;
import model.Customer;
import model.Feedback;
import model.GymClass;
import model.Inventory;
import model.Staff;
import model.SuperAdmin;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@Stateless
public class DataSeed {

    @PersistenceContext(unitName = "EPDAass-ejbPU")
    private EntityManager em;
    
        private void populateUserFields(
            BaseUser user,
            String name,
            String email,
            String password,
            String phone,
            String nation,
            String location,
            int age,
            int height,
            int weight,
            int accountStatus,
            String gender
    ) {
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setNation(nation);
        user.setLocation(location);
        user.setPhone(phone);
        user.setAge(age);
        user.setHeight(height);
        user.setWeight(weight);
        user.setAccountStatus(accountStatus);
        user.setGender(gender);
    }


    public void seedDatabase() {
String queryString = String.format(
            "SELECT u FROM %s u",
            SuperAdmin.class.getSimpleName()
        );
        List<SuperAdmin> results = em
            .createQuery(queryString)
            .getResultList();
        
        // Check if the database is empty before seeding
        if (results.size() <= 0)
        {
            SuperAdmin superAdmin = new SuperAdmin();
            superAdmin.setUsername("super");
            superAdmin.setPassword("123");
            populateUserFields(
                    superAdmin,
                    "super",
                    "superadmin@gym.com",
                    "123",
                    "0121231234",
                    "Malaysia",
                    "Kidzania",
                    20,
                    120,
                    45,
                    1,
                    "Male"
                    
            );
            
            em.persist(superAdmin);
            
            ArrayList<Inventory> inventories = new ArrayList();
            Inventory inventory = new Inventory();
            inventory.setName("Dumbell");
            inventory.setRemark("10kg");
            inventories.add(inventory);
            em.persist(inventory);
            
            ArrayList<Comment> comments = new ArrayList();
            Comment comment = new Comment();
            comment.setRating("5");
            comment.setDescription("Thank you for the session");
            comments.add(comment);
            em.persist(comment);
            
            ArrayList<Feedback> feedbacks = new ArrayList();
            Feedback feedback = new Feedback();
            feedback.setDescription("Thank you!");
            feedbacks.add(feedback);
            em.persist(feedback);

            
            ArrayList<GymClass> classes = new ArrayList();
            ArrayList<GymClass> classes1 = new ArrayList();
            GymClass gym1 = new GymClass();
            gym1.setClassStatus("Completed");
            gym1.setDate("2024-05-24");
            gym1.setTime("2:00");
            gym1.setName("Happy with Uncle Chin");
            gym1.setPaymentStatus(1);
            gym1.setFee(200);
            gym1.setInventories(inventories);
            gym1.setComments(comments);
            gym1.setFeedback(feedbacks);
            
            classes.add(gym1);
            em.persist(gym1);
            
            GymClass gym2 = new GymClass();
            gym2.setClassStatus("Pending");
            gym2.setDate("2024-05-22");
            gym2.setTime("3:00");
                        gym2.setName("Happy with Uncle Chai");
            gym2.setPaymentStatus(0);
            gym2.setFee(100);
            
            classes.add(gym2);
            em.persist(gym2);
            
            GymClass gym3 = new GymClass();
            gym3.setClassStatus("Completed");
            gym3.setDate("2024-05-20");
            gym3.setTime("2:00");
            gym3.setName("Acrobat Auntie Lim");
            gym3.setPaymentStatus(1);
            gym3.setFee(150);
            
            classes1.add(gym3);
            em.persist(gym3);
            
            GymClass gym4 = new GymClass();
            gym4.setClassStatus("Pending");
            gym4.setDate("2024-05-24");
            gym4.setTime("2:00");
            gym4.setName("Nancy Gym");
            gym4.setPaymentStatus(1);
            gym4.setFee(200);
            
            classes1.add(gym4);
            em.persist(gym4);
            
            GymClass gym5 = new GymClass();
            gym5.setClassStatus("Completed");
            gym5.setDate("2024-05-23");
            gym5.setTime("3:00");
            gym5.setName("Funny Yung");
            gym5.setPaymentStatus(0);
            gym5.setFee(150);
            
            classes1.add(gym5);
            em.persist(gym5);
            
            GymClass gym6 = new GymClass();
            gym6.setClassStatus("Pending");
            gym6.setDate("2024-05-22");
            gym6.setTime("4:00");
            gym6.setName("Fun run");
            gym6.setPaymentStatus(1);
            gym6.setFee(200);
            
            classes1.add(gym6);
            em.persist(gym6);
            
            GymClass gym7 = new GymClass();
            gym7.setClassStatus("Completed");
            gym7.setDate("2024-05-24");
            gym7.setTime("3:00");
            gym7.setName("DLL Happy Gym");
            gym7.setPaymentStatus(1);
            gym7.setFee(350);
            
            classes1.add(gym7);
            em.persist(gym7);

            
            Staff staff = new Staff();
            populateUserFields(
                    staff,
                    "staff1",
                    "staff1@gym.com",
                    "123",
                    "0111111111",
                    "China",
                    "LegoLand",
                    20,
                    100,
                    45,
                    1,
                    "Female"
                    
            );
            em.persist(staff);
            
            Trainer trainer1 = new Trainer();
            populateUserFields(
                    trainer1,
                    "trainer1",
                    "trainer1@gym.com",
                    "123",
                    "011126806666",
                    "China",
                    "Kidzania",
                    20,
                    160,
                    45,
                    1,
                    "Male"
                    
            );
            trainer1.setClasses(classes);
            trainer1.setFeedbacks(feedbacks);
            em.persist(trainer1);
            Trainer trainer2 = new Trainer();
            populateUserFields(
                    trainer2,
                    "trainer2",
                    "trainer2@gym.com",
                    "123",
                    "011126806666",
                    "Malaysia",
                    "Kidzania",
                    23,
                    160,
                    45,
                    0,
                    "Female"
                    
            );
                        trainer2.setClasses(classes1);
            em.persist(trainer2);
            Trainer trainer3 = new Trainer();
            populateUserFields(
                    trainer3,
                    "trainer3",
                    "trainer3@gym.com",
                    "123",
                    "011126806666",
                    "Indonesia",
                    "LegoLand",
                    20,
                    160,
                    45,
                    1,
                    "Female"
                    
            );
            em.persist(trainer3);
            
            Customer customer1 = new Customer();
            populateUserFields(
                    customer1,
                    "customer1",
                    "customer1@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "HappyHour",
                    21,
                    150,
                    20,
                    1,
                    "Male"
                    
            );
            customer1.setClasses(classes);
            customer1.setComments(comments);
            em.persist(customer1);
            Customer customer2 = new Customer();
            populateUserFields(
                    customer2,
                    "customer2",
                    "customer2@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "HappyHour",
                    20,
                    150,
                    20,
                    1,
                    "Male"
                    
            );
            em.persist(customer2);
            Customer customer3 = new Customer();
            populateUserFields(
                    customer3,
                    "customer3",
                    "customer3@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "LegoLand",
                    21,
                    160,
                    20,
                    1,
                    "Male"
                    
            );
            em.persist(customer3);
            Customer customer4 = new Customer();
            populateUserFields(
                    customer4,
                    "customer4",
                    "customer4@gym.com",
                    "123",
                    "0199999999",
                    "Malaysia",
                    "LegoLand",
                    21,
                    160,
                    20,
                    1,
                    "Female"
                    
            );
            em.persist(customer4);
            Customer customer5 = new Customer();
            populateUserFields(
                    customer5,
                    "customer5",
                    "customer5@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "HappyHour",
                    20,
                    160,
                    40,
                    1,
                    "Female"
                    
            );
            em.persist(customer5);
            Customer customer6 = new Customer();
            populateUserFields(
                    customer6,
                    "customer6",
                    "customer6@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "HappyHour",
                    21,
                    160,
                    40,
                    1,
                    "Female"
                    
            );
            em.persist(customer6);
            Customer customer7 = new Customer();
            populateUserFields(
                    customer7,
                    "customer7",
                    "customer7@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "HappyHour",
                    20,
                    160,
                    40,
                    1,
                    "Male"
                    
            );
            em.persist(customer7);
            Customer customer8 = new Customer();
            populateUserFields(
                    customer8,
                    "customer8",
                    "customer8@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "HappyHour",
                    21,
                    150,
                    40,
                    1,
                    "Male"
                    
            );
            em.persist(customer8);
            Customer customer9 = new Customer();
            populateUserFields(
                    customer9,
                    "customer9",
                    "customer9@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "HappyHour",
                    21,
                    150,
                    40,
                    1,
                    "Male"
                    
            );
            em.persist(customer9);
            Customer customer10 = new Customer();
            populateUserFields(
                    customer10,
                    "customer10",
                    "customer10@gym.com",
                    "123",
                    "0199999999",
                    "Japan",
                    "HappyHour",
                    23,
                    170,
                    70,
                    1,
                    "Male"
                    
            );
            em.persist(customer10);

        }

    }
}

