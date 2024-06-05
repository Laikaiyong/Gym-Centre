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
@WebServlet(name = "DeleteUser", urlPatterns = {"/deleteUser"})
public class DeleteUser extends HttpServlet {

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
        session.setAttribute("editId", request.getParameter("id"));
        session.setAttribute("editRole", request.getParameter("role"));
        Long userId = Long.valueOf(request.getParameter("id"));
        BaseUser currentUser = new BaseUser();
        switch (request.getParameter("role")) {
             case "customer":
                Customer currentCustomer = customerFacade.find(userId);
                currentCustomer.setAccountStatus(0);
                customerFacade.edit(currentCustomer);

                break;
            case "trainer":
                model.Trainer currentTrainer = trainerFacade.find(userId);
                currentTrainer.setAccountStatus(0);
                trainerFacade.edit(currentTrainer);
                break;
            case "staff":
                model.Staff currentStaff = staffFacade.find(userId);
                currentStaff.setAccountStatus(0);
                staffFacade.edit(currentStaff);
                break;
            default:
                request
                        .getSession()
                        .setAttribute("deleteUserError", "Delete Fail");
        }
        
        response.sendRedirect("users");
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
