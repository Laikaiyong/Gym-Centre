/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import facade.CommentFacade;
import facade.CustomerFacade;
import facade.FeedbackFacade;
import facade.GymClassFacade;
import facade.InventoryFacade;
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
import model.Comment;
import model.Customer;
import model.Feedback;
import model.GymClass;
import model.Inventory;
import model.Staff;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "Report", urlPatterns = {"/report"})
public class Report extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private TrainerFacade trainerFacade;
    @EJB
    private StaffFacade staffFacade;
    @EJB
    private GymClassFacade gymClassFacade;
    @EJB
    private InventoryFacade inventoryFacade;
    @EJB
    private CommentFacade commentFacade;
    @EJB
    private FeedbackFacade feedbackFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> allCust = customerFacade.findAll();
        List<Staff> allStaff = staffFacade.findAll();
         List<Trainer> allTrainer = trainerFacade.findAll();
         List<GymClass> allGymClasses = gymClassFacade.findAll();
         List<Inventory> allInventories = inventoryFacade.findAll();
         List<Comment> allComment = commentFacade.findAll();
         List<Feedback> allFeedbacks = feedbackFacade.findAll();
        request.setAttribute("customers", allCust);
        request.setAttribute("staffs", allStaff);
        request.setAttribute("trainers", allTrainer);
        request.setAttribute("gymClasses", allGymClasses);
        request.setAttribute("inventories", allInventories);
        request.setAttribute("comments", allComment);
        request.setAttribute("feedbacks", allFeedbacks);
        request.getRequestDispatcher("report.jsp").forward(request, response);
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
