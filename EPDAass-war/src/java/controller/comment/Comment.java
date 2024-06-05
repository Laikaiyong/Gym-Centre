/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.comment;

import facade.CommentFacade;
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
import javax.servlet.http.HttpSession;
import model.GymClass;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "Comment", urlPatterns = {"/comment"})
public class Comment extends HttpServlet {

       @EJB
    private CommentFacade commentFacade;
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<model.Comment> comments = commentFacade.findAll();
                 HttpSession session = request.getSession();
        session.setAttribute("addGym", null);
        session.setAttribute("addComment", null);
        request.setAttribute("comments", comments);
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

  }
}
