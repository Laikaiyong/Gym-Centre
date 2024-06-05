/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import facade.CustomerFacade;
import facade.StaffFacade;
import facade.TrainerFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.SuperAdmin;
import model.Trainer;
import service.Authenticate;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "ResetPassword", urlPatterns = {"/resetpassword"})
public class Reset extends HttpServlet {


    @EJB
    private Authenticate authService;
    
        @EJB
    private CustomerFacade customerFacade;

    @EJB
    private TrainerFacade trainerFacade;
    
        @EJB
    private StaffFacade staffFacade;

    
    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("resetError", request.getParameter("error"));
        request.getRequestDispatcher("/resetpassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        String role = authService.checkUserRole(name);
       if (role.equals("None")) {
            request
                    .getSession()
                    .setAttribute("resetError", "Username not register");
            doGet(request, response);
            return;
        }
       
       if (!password.equals(confirmPassword)) {
            request
                    .getSession()
                    .setAttribute("resetError", "Password does not match confirmation");
            doGet(request, response);
            return;        
       }

        try {

            if (!role.equals("None"))
            {
                switch(role) {
                case "staff":
                    Staff staff =  (Staff) authService.resetGetUser(name);
                    staff.setPassword(password);
                    staffFacade.edit(staff);
                    break;
                case "customer":
                    Customer customer =  (Customer) authService.resetGetUser(name);
                    customer.setPassword(password);
                    customerFacade.edit(customer);
                    break;
                case "trainer":
                    Trainer trainer =  (Trainer) authService.resetGetUser(name);
                    trainer.setPassword(password);
                    trainerFacade.edit(trainer);
                    break;
                case "superadmin":
                    request
                            .getSession()
                            .setAttribute("resetError", "Could not reset super admin");
                    doGet(request, response);
                    break;
                default:
                    request
                            .getSession()
                            .setAttribute("resetError", role);
//                    request
//                            .getSession()
//                            .setAttribute("resetError", "User not found");
                    doGet(request, response);
                    break;
                
            }
            } else {
                                    request
                            .getSession()
                            .setAttribute("resetError", "Role none detected");
                    doGet(request, response);
            }
            

        } catch (Exception e) {
            request
                    .getSession()
                    .setAttribute("resetError", "Error resetting password");
            doGet(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute(
                "resetSuccess",
                "Successfully reset as " + name
        );
        response.sendRedirect("login.jsp");
    }

}
