/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.gymclass;

import facade.CommentFacade;
import facade.CustomerFacade;
import facade.FeedbackFacade;
import facade.GymClassFacade;
import facade.TrainerFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Feedback;
import model.GymClass;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "UpdateGymClass", urlPatterns = {"/updateGymClass"})
public class UpdateGymClass extends HttpServlet {
   @EJB
    private CustomerFacade customerFacade;
       @EJB
    private CommentFacade commentFacade;
       @EJB
    private FeedbackFacade feedbackFacade;
       @EJB
    private TrainerFacade trainerFacade;
       @EJB
    private GymClassFacade classFacade;
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 HttpSession session = request.getSession();
                 Long gymId = Long.valueOf(request.getParameter("id"));
                        GymClass gym = (GymClass) classFacade.find(gymId);
               
                                        List<Customer> allCust = customerFacade.findAll();
        request.setAttribute("customers", allCust);
                List<GymClass> classes = classFacade.findAll();
        

        session.setAttribute("updateClass", gym);
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
                         HttpSession session = request.getSession();
        Integer paymentState = Integer.parseInt(request.getParameter("payment").toString());
        Long customerId = Long.parseLong(request.getParameter("customer").toString());
        
        GymClass gym = (GymClass) session.getAttribute("updateClass");
        gym.setPaymentStatus(paymentState);
        classFacade.edit(gym);
        
        Customer cust = customerFacade.find(customerId);
ArrayList<GymClass> updatedClasses = cust.getClasses();
        boolean checked = true;
        for (GymClass gym1: updatedClasses) {
            if (gym1.getId() == gym.getId()) {
                checked = false;
            }
        }
        if (checked) {
            updatedClasses.add(gym); 
        }

        cust.setClasses(updatedClasses);
                customerFacade.edit(cust);
        
        response.sendRedirect("class");
  }
}
