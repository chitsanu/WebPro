/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.ProfileJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Account;
import model.Profile;
import controller.AccountJpaController;
import controller.CardJpaController;
import java.util.ArrayList;
import java.util.List;
import model.Card;

/**
 *
 * @author SSirith
 */
public class LoginServlet extends HttpServlet {

    @PersistenceUnit(unitName = "ProjectPU")
    EntityManagerFactory emf;
    @Resource
    UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && password != null) {
            AccountJpaController acCtrl = new AccountJpaController(utx, emf);
            ProfileJpaController proCtrl = new ProfileJpaController(utx, emf);
            CardJpaController cardCtrl = new CardJpaController(utx, emf);
            Account account = acCtrl.findAccountEmail(email);
            Profile profile = proCtrl.findByAccountid(account);
            Card card = cardCtrl.findByAccountid(account);
            System.out.println("===========================================");
            System.out.println(profile.toString());
            System.out.println(card.toString());
            System.out.println("===========================================");
            if (account != null) {
                if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
//                    List<Profile>profileList = new ArrayList<>();
//                    profileList.add(profile);
//                    account.setProfileList(profileList);
//                    System.out.println(account.toString());
                    session.setAttribute("account", account);
                    session.setAttribute("profile", profile);
                    session.setAttribute("card", card);
                    getServletContext().getRequestDispatcher("/HomePage.jsp").forward(request, response);
                    return;
                }
            }
            request.setAttribute("message", "Invalid username or password.");
        }
            
        getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
