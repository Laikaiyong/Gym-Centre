/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.feedback;

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
import model.Comment;
import model.Customer;
import model.Feedback;
import model.GymClass;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "AddFeedback", urlPatterns = {"/addFeedback"})
public class AddFeedback extends HttpServlet {
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
                        session.setAttribute("addGym", gym);
               session.setAttribute("addFeedback", "true");
               
                                        List<Customer> allCust = customerFacade.findAll();
        request.setAttribute("customers", allCust);

        request.getRequestDispatcher("feedback.jsp").forward(request, response);
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
        String description = request.getParameter("desc");
        Feedback feedback = new Feedback();
        feedback.setDescription(description);
        feedbackFacade.create(feedback);
        
        GymClass gym = (GymClass) session.getAttribute("addGym");
        ArrayList<Feedback> feedbacks1 = gym.getFeedback();
                feedbacks1.add(feedback);
        gym.setFeedback(feedbacks1);
        classFacade.edit(gym);
        
               Trainer trainer = (Trainer) session.getAttribute("user");
        ArrayList<Feedback> feedbacks = trainer.getFeedbacks();
                feedbacks.add(feedback);
        trainer.setFeedbacks(feedbacks);
        trainerFacade.edit(trainer);
        
        response.sendRedirect("feedback");
  }
}
