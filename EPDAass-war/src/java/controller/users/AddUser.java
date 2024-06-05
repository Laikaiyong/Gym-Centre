/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.users;

import facade.CustomerFacade;
import facade.StaffFacade;
import facade.TrainerFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BaseUser;
import model.Customer;
import model.Staff;
import model.Trainer;
import service.Authenticate;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "AddUser", urlPatterns = {"/addUser"})
public class AddUser extends HttpServlet {


    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private TrainerFacade trainerFacade;
    @EJB
    private StaffFacade staffFacade;
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
    



    private void registerStaff(
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
        Staff customer = new Staff();
        populateUserFields(customer, name, email, password, phone, nation, location, age, height, weight, 1, gender);
//        managingStaff.setStatus(AccountStatus.INACTIVE);
        staffFacade.create(customer);
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("editId", null);
        session.setAttribute("editRole", null);
        session.setAttribute("addRole", request.getParameter("role"));

        List<Customer> allCust = customerFacade.findAll();
        List<model.Staff> allStaff = staffFacade.findAll();
        List<model.Trainer> allTrainer = trainerFacade.findAll();
        request.setAttribute("customers", allCust);
        request.setAttribute("staffs", allStaff);
        request.setAttribute("trainers", allTrainer);
        request.getRequestDispatcher("users.jsp").forward(request, response);
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
                HttpSession session = request.getSession();
                String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String nation = request.getParameter("nation");
        String location = request.getParameter("location");
        int age = Integer.parseInt(request.getParameter("age"));
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        String role = session.getAttribute("addRole").toString();
        String gender = request.getParameter("gender");
        if (authService.checkUsername(name)) {
            request
                    .getSession()
                    .setAttribute("addUserError", "Username already exists");
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
                case "staff":
                    registerStaff(name, email, password, phone, nation, location, age, height, weight, gender);
                    break;
                default:
                    request
                            .getSession()
                            .setAttribute("addUserError", "Unknown role");
                    doGet(request, response);
                    return;
            }

        } catch (Exception e) {
            request
                    .getSession()
                    .setAttribute("addUserError", "Error adding user");
            doGet(request, response);
            return;
        }

        session.setAttribute(
                "addUserSuccess",
                "Successfully added " + role
        );
        response.sendRedirect("users");
    }
}
