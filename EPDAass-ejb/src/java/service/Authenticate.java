/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import model.BaseUser;
import model.Customer;
import model.Staff;
import model.SuperAdmin;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@Stateless
public class Authenticate {

    @PersistenceContext(unitName = "EPDAass-ejbPU")
    private EntityManager em;

    public BaseUser login(String email, String password) {
        BaseUser user = null;

        user = authenticate(email, password, Customer.class);
        if (user != null) return user;

        user = authenticate(email, password, Staff.class);
        if (user != null) return user;

        user = authenticate(email, password, Trainer.class);
        if (user != null) return user;

        user = authenticate(email, password, SuperAdmin.class);
        if (user != null) return user;

        return null; // Authentication failed
    }
    
    public BaseUser resetGetUser(String username) {
        BaseUser user = null;

        user = getUser(username, Customer.class);
        if (user != null) return user;

        user = getUser(username, Staff.class);
        if (user != null) return user;

        user = getUser(username, Trainer.class);
        if (user != null) return user;

        return null; 
    }
    
    private <T extends BaseUser> T getUser(
        String username,
        Class<T> userClass
    ) {
         String queryString = String.format(
            "SELECT u FROM %s u WHERE u.username = :username",
            userClass.getSimpleName()
        );
        try {
            T user = em
                .createQuery(queryString, userClass)
                .setParameter("username", username)
                .getSingleResult();

            if (user != null)
            {
                return user;
            }
        } catch (NoResultException e) {
            // No user found with the given username in this table
        }
        return null;
    }

    private <T extends BaseUser> T authenticate(
        String username,
        String password,
        Class<T> userClass
    ) {
        String queryString = String.format(
            "SELECT u FROM %s u WHERE u.username = :username",
            userClass.getSimpleName()
        );
        try {
            T user = em
                .createQuery(queryString, userClass)
                .setParameter("username", username)
                .getSingleResult();

            if (user != null)
            {
                if (checkPassword(password, user.getPassword())) {
                    return user;
                }
            }
        } catch (NoResultException e) {
            // No user found with the given username in this table
        }
        return null; // Authentication failed or user not found in this role
    }

    private boolean checkPassword(String rawPassword, String storedPassword) {
        return rawPassword.equals(storedPassword);
    }

    public boolean checkUsername(String username) {
        if (existsInEntity(username, Trainer.class)) return true;
        if (existsInEntity(username, Staff.class)) return true;
        if (existsInEntity(username, SuperAdmin.class)) return true;
        return existsInEntity(username, Customer.class);
    }

    public <T> String checkUserRole(String username) {
        if (!existsInEntityRole(username, Trainer.class).equals("None")) return existsInEntityRole(username, Trainer.class).toLowerCase();
        if (!existsInEntityRole(username, Staff.class).equals("None")) return existsInEntityRole(username, Staff.class).toLowerCase();
        if (!existsInEntityRole(username, SuperAdmin.class).equals("None")) return existsInEntityRole(username, SuperAdmin.class).toLowerCase();
        return existsInEntityRole(username, Customer.class).toLowerCase();
    }

    private <T> boolean existsInEntity(String username, Class<T> entityType) {
        String queryString =
            "SELECT u FROM " +
            entityType.getSimpleName() +
            " u WHERE u.username = :username";
        List<T> results = em
            .createQuery(queryString, entityType)
            .setParameter("username", username)
            .getResultList();
        return !results.isEmpty();
    }

    private <T> String existsInEntityRole(String username, Class<T> entityType) {
        String queryString =
            "SELECT u FROM " +
            entityType.getSimpleName() +
            " u WHERE u.username = :username";
        List<T> results = em
            .createQuery(queryString, entityType)
            .setParameter("username", username)
            .getResultList();
        return !results.isEmpty() ? entityType.getSimpleName() : "None";
    }

    public <T extends BaseUser> boolean checkUserPermission(
        Long id,
        Class<T> entityType,
        String path
    ) {
        if (
            entityType.equals(Customer.class) &&
            path.startsWith("/customer/")
        ) {
            return true;
        } else if (
            entityType.equals(Staff.class) &&
            path.startsWith("/staff/")
        ) {
            return true;
        } else if (
            entityType.equals(Trainer.class) &&
            path.startsWith("/trainer/")
        ){
            return true;
        }
        // Default to false if none of the conditions match
        return false;
    }

}