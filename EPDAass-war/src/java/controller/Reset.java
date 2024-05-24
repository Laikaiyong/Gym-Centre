/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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

       if (authService.checkUsername(name)) {
            request
                    .getSession()
                    .setAttribute("resetError", "User does not exist");
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
