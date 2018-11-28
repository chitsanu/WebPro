/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.ProfileJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import controller.exceptions.RollbackFailureException;
import model.Card;

/**
 *
 * @author SSirith
 */
public class EditProfileServlet extends HttpServlet {
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
            throws ServletException, IOException, RollbackFailureException, Exception {
         HttpSession session = request.getSession(false);
        
        Account account = (Account) request.getAttribute("account");
        Profile profile=(Profile) session.getAttribute("profile");
        Card card = (Card) session.getAttribute("card");
        
        String Fname= request.getParameter("fname");
        String Lname=request.getParameter("lname");
        String Address=request.getParameter("address");
        String tel=request.getParameter("tel");
        String cardNumStr = request.getParameter("card");
        String exp = request.getParameter("exp");
        String cvc = request.getParameter("cvc");
        int cardNum = Integer.valueOf(cardNumStr);
        
        AccountJpaController accCtrl=new AccountJpaController(utx, emf);
        ProfileJpaController pfCtrl = new ProfileJpaController(utx, emf);
        CardJpaController cardCtrl = new CardJpaController(utx, emf);
         
        profile.setFname(Fname);
        profile.setLname(Lname);
        profile.setAddress(Address);
        profile.setTel(tel);
        System.out.println("=============================================");
        System.out.println(profile.toString());
        System.out.println("=============================================");
//        card.setAccountid(accCtrl.findAccount(account.getAccountid()));
        card.setCardnumber(cardNum);
        card.setExp(exp);
        card.setCvc(cvc);
        System.out.println(card.toString());
//        cardCtrl.create(card);
        pfCtrl.edit(profile);
        cardCtrl.edit(card);
        session.setAttribute("profile", profile);
        session.setAttribute("card", card);
        response.sendRedirect("HomePage.jsp");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
