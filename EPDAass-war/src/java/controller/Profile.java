/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import facade.CustomerFacade;
import facade.StaffFacade;
import facade.TrainerFacade;
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
import model.Staff;
import model.Trainer;

/**
 *
 * @author vandycklai
 */
@WebServlet(name = "Profile", urlPatterns = {"/profile"})
public class Profile extends HttpServlet {

        @EJB
    private CustomerFacade customerFacade;

    @EJB
    private TrainerFacade trainerFacade;
    
        @EJB
    private StaffFacade staffFacade;
        
            private void populateUserFields(
            BaseUser user,
            String email,
            String phone,
            String nation,
            String location,
            int age,
            int height,
            int weight,
            String gender
    ) {
        user.setEmail(email);
        user.setNation(nation);
        user.setLocation(location);
        user.setPhone(phone);
        user.setAge(age);
        user.setHeight(height);
        user.setWeight(weight);
        user.setGender(gender);
    }

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
        request.setAttribute("updateProfileError", request.getParameter("error"));
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
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
            String role = (String) session.getAttribute("userRole");
            
            BaseUser user;
             switch (role) {
                case "customer":
                    user = (Customer) session.getAttribute("user");
                    
                    break;
                case "trainer":
                   user = (Trainer) session.getAttribute("user");
                    break;
                case "staff":
                   user = (Staff) session.getAttribute("user");
                    break;
                default:
                    request
                            .getSession()
                            .setAttribute("updateProfileError", "Unknown Role");
                    doGet(request, response);
                    return;
            }
            
        Long userId = user.getId();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String nation = request.getParameter("nation");
        String location = request.getParameter("location");
        int age = Integer.parseInt(request.getParameter("age"));
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        String gender = request.getParameter("gender");
        
            try {
                 switch (role) {
                case "customer":
                                        Customer currentCustomer = customerFacade.find(userId);
                    
                            populateUserFields(currentCustomer, email, phone, nation, location, age, height, weight, gender);
                    customerFacade.edit(currentCustomer);
                    
                    break;
                case "trainer":
                    Trainer currentTrainer = trainerFacade.find(userId);
                    
                            populateUserFields(currentTrainer, email, phone, nation, location, age, height, weight, gender);
                    trainerFacade.edit(currentTrainer);
                    break;
                case "staff":
                            Staff currentStaff = staffFacade.find(userId);
                    
                            populateUserFields(currentStaff, email, phone, nation, location, age, height, weight, gender);
                    staffFacade.edit(currentStaff);
                    break;
                default:
                    request
                            .getSession()
                            .setAttribute("updateProfileError", "Unknown Role");
                    doGet(request, response);
                    return;
            }

             response.sendRedirect("profile");


            } catch (Exception e) {

            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
