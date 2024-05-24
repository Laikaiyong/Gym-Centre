/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BaseUser;
import model.Customer;
import facade.CustomerFacade;
import facade.TrainerFacade;
import model.Trainer;
import service.Authenticate;


@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private TrainerFacade trainerFacade;

    @EJB
    private Authenticate authService;

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

    private void registerCustomer(
            String name,
            String email,
            String password,
            String phone,
            String nation,
            String location,
            int age,
            int height,
            int weight,
            String gender
    ) {
        Customer customer = new Customer();
        populateUserFields(customer, name, email, password, phone, nation, location, age, height, weight, 1, gender);
//        managingStaff.setStatus(AccountStatus.INACTIVE);
        customerFacade.create(customer);
    }

    private void registerTrainer(
            String name,
            String email,
            String password,
            String phone,
            String nation,
            String location,
            int age,
            int height,
            int weight,
            String gender
    ) {
        Trainer trainer = new Trainer();
        populateUserFields(trainer, name, email, password, phone, nation, location, age, height, weight, 1, gender);
//        managingStaff.setStatus(AccountStatus.INACTIVE);
        trainerFacade.create(trainer);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request
                .getRequestDispatcher("register.jsp")
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String nation = request.getParameter("nation");
        String location = request.getParameter("location");
        int age = Integer.parseInt(request.getParameter("age"));
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        String role = request.getParameter("role");
        String gender = request.getParameter("gender");
        if (authService.checkUsername(name)) {
            request
                    .getSession()
                    .setAttribute("regError", "Username already exists");
            doGet(request, response);
            return;
        }

        try {
            switch (role) {
                case "customer":
                    registerCustomer(name, email, password, phone, nation, location, age, height, weight, gender);
                    break;
                case "trainer":
                    registerTrainer(name, email, password, phone, nation, location, age, height, weight, gender);
                    break;
                default:
                    request
                            .getSession()
                            .setAttribute("regError", "Unknown Role");
                    doGet(request, response);
                    return;
            }

        } catch (Exception e) {
            request
                    .getSession()
                    .setAttribute("regError", "Error registering user");
            doGet(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute(
                "registrationSuccess",
                "Successfully registered as " + role
        );
        response.sendRedirect("login.jsp");
    }

}
