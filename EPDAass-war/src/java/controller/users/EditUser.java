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
import model.Trainer;
import model.Staff;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "EditUser", urlPatterns = {"/editUser"})
public class EditUser extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private TrainerFacade trainerFacade;
    @EJB
    private StaffFacade staffFacade;

    private void populateUserFields(
            BaseUser user,
            String email,
            String phone,
            String nation,
            String location,
            int age,
            int height,
            int weight,
            int accountStatus,
            String gender
    ) {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("addRole", null);
        session.setAttribute("editId", request.getParameter("id"));
        session.setAttribute("editRole", request.getParameter("role"));
        Long userId = Long.valueOf(request.getParameter("id"));
       BaseUser currentUser = new BaseUser();
        switch (request.getParameter("role")) {
            case "customer":
                currentUser = (Customer) customerFacade.find(userId);
                         session.setAttribute("editCustomer", currentUser);
                                                  session.setAttribute("editStaff", null);
                         session.setAttribute("editTrainer", null);

                break;
            case "trainer":
                currentUser = (Trainer) trainerFacade.find(userId);
         session.setAttribute("editTrainer", currentUser);
                                  session.setAttribute("editStaff", null);
                         session.setAttribute("editCustomer", null);
                break;
            case "staff":
                currentUser = (Staff) staffFacade.find(userId);
                         session.setAttribute("editStaff", currentUser);
                         session.setAttribute("editTrainer", null);
                         session.setAttribute("editCustomer", null);

                break;
            default:
                request
                        .getSession()
                        .setAttribute("editUserError", "Edit User Not Found");
        }
        

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
        Long userId = Long.valueOf(session.getAttribute("editId").toString());
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String nation = request.getParameter("nation");
        String location = request.getParameter("location");
        int age = Integer.parseInt(request.getParameter("age"));
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int accountStatus = Integer.parseInt(request.getParameter("accountStatus"));
        String role = session.getAttribute("editRole").toString();
        String gender = request.getParameter("gender");

        switch (role) {
            case "customer":
                Customer currentCustomer = customerFacade.find(userId);
                
//                        int score = Integer.parseInt(request.getParameter("score"));

                populateUserFields(currentCustomer, email, phone, nation, location, age, height, weight, accountStatus, gender);
//                currentCustomer.setScore(score);
                customerFacade.edit(currentCustomer);

                break;
            case "trainer":
                model.Trainer currentTrainer = trainerFacade.find(userId);

                populateUserFields(currentTrainer, email, phone, nation, location, age, height, weight, accountStatus, gender);
                trainerFacade.edit(currentTrainer);
                break;
            case "staff":
                model.Staff currentStaff = staffFacade.find(userId);

                populateUserFields(currentStaff, email, phone, nation, location, age, height, weight, accountStatus, gender);
                staffFacade.edit(currentStaff);
                break;
            default:
                request
                        .getSession()
                        .setAttribute("editUserError", "EditFail");
                doGet(request, response);
                return;
        }

        response.sendRedirect("users");
    }

}
