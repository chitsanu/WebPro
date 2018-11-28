/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import controller.ProfileJpaController;
import model.Card;

/**
 *
 * @author SSirith
 */
public class RegisterServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {

        HttpSession session = request.getSession(true);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String Lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String cardNumStr = request.getParameter("card");
        String exp = request.getParameter("exp");
        String cvc = request.getParameter("cvc");
        if (email != null && password != null) {
            int cardNum = Integer.valueOf(cardNumStr);
            AccountJpaController acCtrl = new AccountJpaController(utx, emf);
            ProfileJpaController profileCtrl = new ProfileJpaController(utx, emf);
            CardJpaController cardCtrl = new CardJpaController(utx, emf);
            Account account = new Account(email, password, cryptWithMD5(password));
            acCtrl.create(account);
            Profile profile = new Profile(fname, Lname, address, tel);
            profile.setAccountid(acCtrl.findAccount(account.getAccountid()));
            Card card = new Card(cardNum, exp, cvc);
            card.setAccountid(acCtrl.findAccount(account.getAccountid()));
            System.out.println("======================================================");
            System.out.println(profile);
            System.out.println("======================================================");
            profileCtrl.create(profile);
            cardCtrl.create(card);
            getServletContext().getRequestDispatcher("/HomePage.jsp").forward(request, response);

        } else {
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);

        }

    }

    public static String cryptWithMD5(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        return null;
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
