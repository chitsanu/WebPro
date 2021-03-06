/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SSirith
 */
@Entity
@Table(name = "ORDERLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderlist.findAll", query = "SELECT o FROM Orderlist o")
    , @NamedQuery(name = "Orderlist.findByOrderdate", query = "SELECT o FROM Orderlist o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Orderlist.findByAccountid", query = "SELECT o FROM Orderlist o WHERE o.accountid = :accountid")})
public class Orderlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDERNUMBER")
    private Integer ordernumber;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ACCOUNTID")
    @ManyToOne(optional = false)
    private Account accountid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordernumber")
    private List<Orderdetail> orderdetailList;

    public Orderlist() {
    }

    public Orderlist(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Orderlist(Integer ordernumber, Date orderdate) {
        this.ordernumber = ordernumber;
        this.orderdate = orderdate;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    @XmlTransient
    public List<Orderdetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<Orderdetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordernumber != null ? ordernumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderlist)) {
            return false;
        }
        Orderlist other = (Orderlist) object;
        if ((this.ordernumber == null && other.ordernumber != null) || (this.ordernumber != null && !this.ordernumber.equals(other.ordernumber))) {
            return false;
        }
        return true;
    }

    
//    @Override
//    public String toString() {
//        return "model.Orderlist[ ordernumber=" + ordernumber + " ]";
//    }

//    @Override
//    public String toString() {
//        return "Orderlist{" + "orderdate=" + orderdate + ", ordernumber=" + ordernumber + ", accountid=" + accountid + ", orderdetailList=" + orderdetailList + '}';
//    }
    
}
