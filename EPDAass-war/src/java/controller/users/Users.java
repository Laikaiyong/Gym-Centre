/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.users;

import facade.CustomerFacade;
import facade.StaffFacade;
import facade.TrainerFacade;
import java.io.IOException;
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
@WebServlet(name = "Users", urlPatterns = {"/users"})
public class Users extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private TrainerFacade trainerFacade;
    @EJB
    private StaffFacade staffFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Customer> allCust = customerFacade.findAll();
        List<Staff> allStaff = staffFacade.findAll();
        List<Trainer> allTrainer = trainerFacade.findAll();
        session.setAttribute("editId", null);
        session.setAttribute("editRole", null);
        session.setAttribute("editPasswordId", null);
        session.setAttribute("editPasswordRole", null);
        session.setAttribute("addRole", null);
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

    }
}
