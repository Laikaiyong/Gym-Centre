/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.gymclass;

import facade.CustomerFacade;
import facade.GymClassFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BaseUser;
import model.Customer;
import model.GymClass;
import model.Staff;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "EnrolGymClass", urlPatterns = {"/enrolGymClass"})
public class EnrolGymClass extends HttpServlet {
    
       @EJB
    private GymClassFacade classFacade;
    
       @EJB
    private CustomerFacade customerFacade;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long gymId = Long.valueOf(request.getParameter("id"));
       GymClass gym = (GymClass) classFacade.find(gymId);
       
        List<GymClass> classes = classFacade.findAll();

        Customer cust = (Customer) session.getAttribute("user");
        ArrayList<GymClass> updatedClasses = cust.getClasses();
        boolean checked = true;
        for (GymClass gym1: updatedClasses) {
            if (gym1.getId() == Long.valueOf(request.getParameter("id"))) {
                checked = false;
            }
        }
        if (checked) {
            updatedClasses.add(gym); 
        }

        cust.setClasses(updatedClasses);
        customerFacade.edit(cust);
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
