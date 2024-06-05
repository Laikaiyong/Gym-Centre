/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.gymclass;

import facade.CommentFacade;
import facade.FeedbackFacade;
import facade.GymClassFacade;
import facade.InventoryFacade;
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
import model.GymClass;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "AddGymClass", urlPatterns = {"/addGymClass"})
public class AddGymClass extends HttpServlet {
        @EJB
    private GymClassFacade gymClassFacade;
    @EJB
    private TrainerFacade trainerFacade;
    @EJB
    private InventoryFacade inventoryFacade;
    @EJB
    private CommentFacade commentFacade;
    @EJB
    private FeedbackFacade feedbackFacade;
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        session.setAttribute("addClass", "true");
                List<GymClass> classes = gymClassFacade.findAll();
        
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
        String name = request.getParameter("name");
        String time = request.getParameter("time");
        String date = request.getParameter("date");
        Integer fee = Integer.parseInt(request.getParameter("fee"));
        GymClass gym = new GymClass();
        gym.setName(name);
        gym.setTime(time);
        gym.setDate(date);
        gym.setFee(fee);
        gymClassFacade.create(gym);
        
        Trainer trainer = (Trainer) request.getAttribute("user");
        ArrayList<GymClass> classes = trainer.getClasses();
        classes.add(gym);
        trainer.setClasses(classes);
        trainerFacade.edit(trainer);
        
        response.sendRedirect("class");
    }

  
}
