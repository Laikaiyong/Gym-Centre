/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.comment;

import facade.CommentFacade;
import facade.CustomerFacade;
import facade.GymClassFacade;
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
import model.Comment;
import model.Customer;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "AddComment", urlPatterns = {"/addComment"})
public class AddComment extends HttpServlet {
       @EJB
    private CustomerFacade customerFacade;
       @EJB
    private CommentFacade commentFacade;
       @EJB
    private GymClassFacade classFacade;
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 HttpSession session = request.getSession();
                 Long gymId = Long.valueOf(request.getParameter("id"));
                        GymClass gym = (GymClass) classFacade.find(gymId);
                        session.setAttribute("addGym", gym);
               session.setAttribute("addComment", "true");
        List<model.Comment> comments = commentFacade.findAll();

 
        session.setAttribute("comments", comments);
        request.getRequestDispatcher("comment.jsp").forward(request, response);
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
        String rating = request.getParameter("rating").toString();
        Comment comment = new Comment();
        comment.setDescription(description);
        comment.setRating(rating);
        commentFacade.create(comment);
        
        GymClass gym = (GymClass) session.getAttribute("addGym");
        ArrayList<Comment> comments1 = gym.getComments();
                comments1.add(comment);
        gym.setComments(comments1);
        classFacade.edit(gym);
        
               Customer cust = (Customer) session.getAttribute("user");
        ArrayList<Comment> comments = cust.getComments();
        comments.add(comment);
        cust.setComments(comments);
        customerFacade.edit(cust);
        
        response.sendRedirect("comment");
  }
}
