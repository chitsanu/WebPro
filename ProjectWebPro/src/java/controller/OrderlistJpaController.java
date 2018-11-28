/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Account;
import model.Orderdetail;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import model.Orderlist;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;

/**
 *
 * @author SSirith
 */
public class OrderlistJpaController implements Serializable {

    public OrderlistJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orderlist orderlist) throws RollbackFailureException, Exception {
        if (orderlist.getOrderdetailList() == null) {
            orderlist.setOrderdetailList(new ArrayList<Orderdetail>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Account accountid = orderlist.getAccountid();
            if (accountid != null) {
                accountid = em.getReference(accountid.getClass(), accountid.getAccountid());
                orderlist.setAccountid(accountid);
            }
            List<Orderdetail> attachedOrderdetailList = new ArrayList<Orderdetail>();
            for (Orderdetail orderdetailListOrderdetailToAttach : orderlist.getOrderdetailList()) {
                orderdetailListOrderdetailToAttach = em.getReference(orderdetailListOrderdetailToAttach.getClass(), orderdetailListOrderdetailToAttach.getNoOrder());
                attachedOrderdetailList.add(orderdetailListOrderdetailToAttach);
            }
            orderlist.setOrderdetailList(attachedOrderdetailList);
            em.persist(orderlist);
            if (accountid != null) {
                accountid.getOrderlistList().add(orderlist);
                accountid = em.merge(accountid);
            }
            for (Orderdetail orderdetailListOrderdetail : orderlist.getOrderdetailList()) {
                Orderlist oldOrdernumberOfOrderdetailListOrderdetail = orderdetailListOrderdetail.getOrdernumber();
                orderdetailListOrderdetail.setOrdernumber(orderlist);
                orderdetailListOrderdetail = em.merge(orderdetailListOrderdetail);
                if (oldOrdernumberOfOrderdetailListOrderdetail != null) {
                    oldOrdernumberOfOrderdetailListOrderdetail.getOrderdetailList().remove(orderdetailListOrderdetail);
                    oldOrdernumberOfOrderdetailListOrderdetail = em.merge(oldOrdernumberOfOrderdetailListOrderdetail);
                }
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

    public void edit(Orderlist orderlist) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Orderlist persistentOrderlist = em.find(Orderlist.class, orderlist.getOrdernumber());
            Account accountidOld = persistentOrderlist.getAccountid();
            Account accountidNew = orderlist.getAccountid();
            List<Orderdetail> orderdetailListOld = persistentOrderlist.getOrderdetailList();
            List<Orderdetail> orderdetailListNew = orderlist.getOrderdetailList();
            List<String> illegalOrphanMessages = null;
            for (Orderdetail orderdetailListOldOrderdetail : orderdetailListOld) {
                if (!orderdetailListNew.contains(orderdetailListOldOrderdetail)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Orderdetail " + orderdetailListOldOrderdetail + " since its ordernumber field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (accountidNew != null) {
                accountidNew = em.getReference(accountidNew.getClass(), accountidNew.getAccountid());
                orderlist.setAccountid(accountidNew);
            }
            List<Orderdetail> attachedOrderdetailListNew = new ArrayList<Orderdetail>();
            for (Orderdetail orderdetailListNewOrderdetailToAttach : orderdetailListNew) {
                orderdetailListNewOrderdetailToAttach = em.getReference(orderdetailListNewOrderdetailToAttach.getClass(), orderdetailListNewOrderdetailToAttach.getNoOrder());
                attachedOrderdetailListNew.add(orderdetailListNewOrderdetailToAttach);
            }
            orderdetailListNew = attachedOrderdetailListNew;
            orderlist.setOrderdetailList(orderdetailListNew);
            orderlist = em.merge(orderlist);
            if (accountidOld != null && !accountidOld.equals(accountidNew)) {
                accountidOld.getOrderlistList().remove(orderlist);
                accountidOld = em.merge(accountidOld);
            }
            if (accountidNew != null && !accountidNew.equals(accountidOld)) {
                accountidNew.getOrderlistList().add(orderlist);
                accountidNew = em.merge(accountidNew);
            }
            for (Orderdetail orderdetailListNewOrderdetail : orderdetailListNew) {
                if (!orderdetailListOld.contains(orderdetailListNewOrderdetail)) {
                    Orderlist oldOrdernumberOfOrderdetailListNewOrderdetail = orderdetailListNewOrderdetail.getOrdernumber();
                    orderdetailListNewOrderdetail.setOrdernumber(orderlist);
                    orderdetailListNewOrderdetail = em.merge(orderdetailListNewOrderdetail);
                    if (oldOrdernumberOfOrderdetailListNewOrderdetail != null && !oldOrdernumberOfOrderdetailListNewOrderdetail.equals(orderlist)) {
                        oldOrdernumberOfOrderdetailListNewOrderdetail.getOrderdetailList().remove(orderdetailListNewOrderdetail);
                        oldOrdernumberOfOrderdetailListNewOrderdetail = em.merge(oldOrdernumberOfOrderdetailListNewOrderdetail);
                    }
                }
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
                Integer id = orderlist.getOrdernumber();
                if (findOrderlist(id) == null) {
                    throw new NonexistentEntityException("The orderlist with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Orderlist orderlist;
            try {
                orderlist = em.getReference(Orderlist.class, id);
                orderlist.getOrdernumber();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orderlist with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Orderdetail> orderdetailListOrphanCheck = orderlist.getOrderdetailList();
            for (Orderdetail orderdetailListOrphanCheckOrderdetail : orderdetailListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Orderlist (" + orderlist + ") cannot be destroyed since the Orderdetail " + orderdetailListOrphanCheckOrderdetail + " in its orderdetailList field has a non-nullable ordernumber field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Account accountid = orderlist.getAccountid();
            if (accountid != null) {
                accountid.getOrderlistList().remove(orderlist);
                accountid = em.merge(accountid);
            }
            em.remove(orderlist);
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

    public List<Orderlist> findOrderlistEntities() {
        return findOrderlistEntities(true, -1, -1);
    }

    public List<Orderlist> findOrderlistEntities(int maxResults, int firstResult) {
        return findOrderlistEntities(false, maxResults, firstResult);
    }

    private List<Orderlist> findOrderlistEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orderlist.class));
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

    public Orderlist findOrderlist(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orderlist.class, id);
        } finally {
            em.close();
        }
    }
    public List<Orderlist> findByAccountid(Account account) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Orderlist.findByAccountid");
        q.setParameter("accountid", account);
        try {
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getOrderlistCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orderlist> rt = cq.from(Orderlist.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
