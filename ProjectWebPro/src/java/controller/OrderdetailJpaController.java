/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import model.Orderdetail;
import model.Orderlist;
import model.Product;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;

/**
 *
 * @author SSirith
 */
public class OrderdetailJpaController implements Serializable {

    public OrderdetailJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orderdetail orderdetail) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Orderlist ordernumber = orderdetail.getOrdernumber();
            if (ordernumber != null) {
                ordernumber = em.getReference(ordernumber.getClass(), ordernumber.getOrdernumber());
                orderdetail.setOrdernumber(ordernumber);
            }
            Product productcode = orderdetail.getProductcode();
            if (productcode != null) {
                productcode = em.getReference(productcode.getClass(), productcode.getProductcode());
                orderdetail.setProductcode(productcode);
            }
            em.persist(orderdetail);
            if (ordernumber != null) {
                ordernumber.getOrderdetailList().add(orderdetail);
                ordernumber = em.merge(ordernumber);
            }
            if (productcode != null) {
                productcode.getOrderdetailList().add(orderdetail);
                productcode = em.merge(productcode);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orderdetail orderdetail) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Orderdetail persistentOrderdetail = em.find(Orderdetail.class, orderdetail.getNoOrder());
            Orderlist ordernumberOld = persistentOrderdetail.getOrdernumber();
            Orderlist ordernumberNew = orderdetail.getOrdernumber();
            Product productcodeOld = persistentOrderdetail.getProductcode();
            Product productcodeNew = orderdetail.getProductcode();
            if (ordernumberNew != null) {
                ordernumberNew = em.getReference(ordernumberNew.getClass(), ordernumberNew.getOrdernumber());
                orderdetail.setOrdernumber(ordernumberNew);
            }
            if (productcodeNew != null) {
                productcodeNew = em.getReference(productcodeNew.getClass(), productcodeNew.getProductcode());
                orderdetail.setProductcode(productcodeNew);
            }
            orderdetail = em.merge(orderdetail);
            if (ordernumberOld != null && !ordernumberOld.equals(ordernumberNew)) {
                ordernumberOld.getOrderdetailList().remove(orderdetail);
                ordernumberOld = em.merge(ordernumberOld);
            }
            if (ordernumberNew != null && !ordernumberNew.equals(ordernumberOld)) {
                ordernumberNew.getOrderdetailList().add(orderdetail);
                ordernumberNew = em.merge(ordernumberNew);
            }
            if (productcodeOld != null && !productcodeOld.equals(productcodeNew)) {
                productcodeOld.getOrderdetailList().remove(orderdetail);
                productcodeOld = em.merge(productcodeOld);
            }
            if (productcodeNew != null && !productcodeNew.equals(productcodeOld)) {
                productcodeNew.getOrderdetailList().add(orderdetail);
                productcodeNew = em.merge(productcodeNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = orderdetail.getNoOrder();
                if (findOrderdetail(id) == null) {
                    throw new NonexistentEntityException("The orderdetail with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Orderdetail orderdetail;
            try {
                orderdetail = em.getReference(Orderdetail.class, id);
                orderdetail.getNoOrder();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orderdetail with id " + id + " no longer exists.", enfe);
            }
            Orderlist ordernumber = orderdetail.getOrdernumber();
            if (ordernumber != null) {
                ordernumber.getOrderdetailList().remove(orderdetail);
                ordernumber = em.merge(ordernumber);
            }
            Product productcode = orderdetail.getProductcode();
            if (productcode != null) {
                productcode.getOrderdetailList().remove(orderdetail);
                productcode = em.merge(productcode);
            }
            em.remove(orderdetail);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orderdetail> findOrderdetailEntities() {
        return findOrderdetailEntities(true, -1, -1);
    }

    public List<Orderdetail> findOrderdetailEntities(int maxResults, int firstResult) {
        return findOrderdetailEntities(false, maxResults, firstResult);
    }

    private List<Orderdetail> findOrderdetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orderdetail.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Orderdetail findOrderdetail(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orderdetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderdetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orderdetail> rt = cq.from(Orderdetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
