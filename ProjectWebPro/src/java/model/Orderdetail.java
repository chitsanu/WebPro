/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SSirith
 */
@Entity
@Table(name = "ORDERDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o")
    , @NamedQuery(name = "Orderdetail.findByNoOrder", query = "SELECT o FROM Orderdetail o WHERE o.noOrder = :noOrder")
    , @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity")})
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NO_ORDER")
    private Integer noOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    @JoinColumn(name = "ORDERNUMBER", referencedColumnName = "ORDERNUMBER")
    @ManyToOne(optional = false)
    private Orderlist ordernumber;
    @JoinColumn(name = "PRODUCTCODE", referencedColumnName = "PRODUCTCODE")
    @ManyToOne(optional = false)
    private Product productcode;

    public Orderdetail() {
    }

    public Orderdetail(Integer noOrder) {
        this.noOrder = noOrder;
    }

    public Orderdetail(Integer noOrder, int quantity) {
        this.noOrder = noOrder;
        this.quantity = quantity;
    }

    public Integer getNoOrder() {
        return noOrder;
    }

    public void setNoOrder(Integer noOrder) {
        this.noOrder = noOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orderlist getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Orderlist ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Product getProductcode() {
        return productcode;
    }

    public void setProductcode(Product productcode) {
        this.productcode = productcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noOrder != null ? noOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.noOrder == null && other.noOrder != null) || (this.noOrder != null && !this.noOrder.equals(other.noOrder))) {
            return false;
        }
        return true;
    }

    
//    @Override
//    public String toString() {
//        return "model.Orderdetail[ noOrder=" + noOrder + " ]";
//    }

    @Override
    public String toString() {
        return "Orderdetail{" + "noOrder=" + noOrder + ", quantity=" + quantity + ", ordernumber=" + ordernumber + ", productcode=" + productcode + '}';
    }
    
}
