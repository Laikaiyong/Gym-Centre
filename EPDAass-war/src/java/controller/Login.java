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
import model.Staff;
import model.SuperAdmin;
import model.Trainer;
import service.Authenticate;

/**
 *
 * @author vandyck.lai
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private Authenticate authService;

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("authError", request.getParameter("error"));
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        BaseUser user = authService.login(username, password);

        if (user != null) {
            if (user.getAccountStatus() == 0)
            {
            request
                .getSession()
                .setAttribute("authError", "Account deactivated");
            response.sendRedirect("login.jsp?error=Account deactivated");
            } else {
                            // Authentication successful, create a session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect based on user role
            String redirectUrl = getRoleBasedRedirectUrl(user, request);
            response.sendRedirect(redirectUrl);
            }

        } else {
            // Authentication failed, redirect to login page with error
            request
                .getSession()
                .setAttribute("authError", "Invalid email or password");
            response.sendRedirect("login.jsp?error=Invalid username or password");
        }
    }

    private String getRoleBasedRedirectUrl(
        BaseUser user,
        HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        if (user instanceof Customer) {
            session.setAttribute("userRole", "customer");
        } else if (user instanceof Staff) {
            session.setAttribute("userRole", "staff");
        } else if (user instanceof Trainer) {
            session.setAttribute("userRole", "trainer");
        } else if (user instanceof SuperAdmin) {
            session.setAttribute("userRole", "superadmin");

        } else {
            return "login.jsp?error=Routing Error"; // Fallback or general dashboard path if the role is not determined
        }
        return "home.jsp";
    }
}
