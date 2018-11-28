package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Account;
import model.Orderdetail;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-28T21:28:53")
@StaticMetamodel(Orderlist.class)
public class Orderlist_ { 

    public static volatile SingularAttribute<Orderlist, Account> accountid;
    public static volatile ListAttribute<Orderlist, Orderdetail> orderdetailList;
    public static volatile SingularAttribute<Orderlist, Integer> ordernumber;
    public static volatile SingularAttribute<Orderlist, Date> orderdate;

}