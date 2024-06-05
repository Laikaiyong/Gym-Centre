/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.gymclass;

import facade.CustomerFacade;
import facade.GymClassFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.GymClass;
import model.Staff;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "Class", urlPatterns = {"/class"})
public class Class extends HttpServlet {

       @EJB
    private GymClassFacade classFacade;
          @EJB
    private CustomerFacade customerFacade;
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<GymClass> classes = classFacade.findAll();
                                                List<Customer> allCust = customerFacade.findAll();
        request.setAttribute("customers", allCust);
        

        request.setAttribute("addClass", null);
        request.setAttribute("updateClass", null);
        request.setAttribute("classes", classes);
        request.getRequestDispatcher("class.jsp").forward(request, response);
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
