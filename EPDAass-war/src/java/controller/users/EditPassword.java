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

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "EditPassword", urlPatterns = {"/editPassword"})
public class EditPassword extends HttpServlet {
    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private TrainerFacade trainerFacade;
    @EJB
    private StaffFacade staffFacade;

    private void populateUserFields(
            BaseUser user,
            String password
    ) {
        user.setPassword(password);
    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("addRole", null);
        session.setAttribute("editPasswordId", request.getParameter("id"));
        session.setAttribute("editPasswordRole", request.getParameter("role"));
        Long userId = Long.valueOf(request.getParameter("id"));
       BaseUser currentUser = new BaseUser();
        switch (request.getParameter("role")) {
            case "customer":
                currentUser = (Customer) customerFacade.find(userId);
                         session.setAttribute("editCustomerPassword", currentUser);
                         session.setAttribute("editTrainerPassword", null);

                break;
            case "trainer":
                currentUser = (Trainer) trainerFacade.find(userId);
         session.setAttribute("editPasswordTrainer", currentUser);
                         session.setAttribute("editPasswordCustomer", null);
                break;
            default:
                request
                        .getSession()
                        .setAttribute("editPasswordError", "Edit User Not Found");
        }
        

        List<Customer> allCust = customerFacade.findAll();
        List<model.Trainer> allTrainer = trainerFacade.findAll();
               List<Staff> allStaff = staffFacade.findAll();
        request.setAttribute("customers", allCust);
        request.setAttribute("trainers", allTrainer);
        request.setAttribute("staffs", allStaff);
        
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
        Long userId = Long.valueOf(session.getAttribute("editPasswordId").toString());
        String password = request.getParameter("password");
        String role = session.getAttribute("editPasswordRole").toString();

        switch (role) {
            case "customer":
                Customer currentCustomer = customerFacade.find(userId);


                populateUserFields(currentCustomer, password);
                customerFacade.edit(currentCustomer);

                break;
            case "trainer":
                model.Trainer currentTrainer = trainerFacade.find(userId);

                populateUserFields(currentTrainer, password);
                trainerFacade.edit(currentTrainer);
                break;
            default:
                request
                        .getSession()
                        .setAttribute("editPasswordError", "Edit Fail");
                doGet(request, response);
                return;
        }

        response.sendRedirect("users");
    }

}
