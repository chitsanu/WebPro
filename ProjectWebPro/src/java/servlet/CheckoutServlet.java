/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.OrderdetailJpaController;
import controller.OrderlistJpaController;
import controller.ProductJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Account;
import model.Cart;
import model.ItemsInCart;
import model.Orderdetail;
import model.Orderlist;
import controller.AccountJpaController;

/**
 *
 * @author James
 */
public class CheckoutServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception, StackOverflowError {
        HttpSession session = request.getSession(false);
        Cart cart = (Cart) session.getAttribute("cart");
        AccountJpaController accounttrl = new AccountJpaController(utx, emf);
        ProductJpaController prodCtrl = new ProductJpaController(utx, emf);
        OrderlistJpaController olCtrl = new OrderlistJpaController(utx, emf);
        OrderdetailJpaController odCtrl = new OrderdetailJpaController(utx, emf);
        Account account = (Account) session.getAttribute("account");
        Orderdetail od = new Orderdetail();
        Orderlist ol = new Orderlist();
        if (session != null) {
            ol.setOrderdate(new Date());
            ol.setAccountid(accounttrl.findAccount(account.getAccountid()));
            olCtrl.create(ol);
            List<ItemsInCart> items = cart.getitemsInCart();
            List<Orderdetail> odList = new ArrayList<Orderdetail>();
            for (ItemsInCart itemsInCart : items) {
                od.setOrdernumber(ol);
                od.setProductcode(itemsInCart.getProduct());
                od.setQuantity(itemsInCart.getQuantity());
                odCtrl.create(od);
                odList.add(od);
                ol.setOrderdetailList(odList);
            }
        }
        session.setAttribute("account", account);
        session.removeAttribute("cart");
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
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
