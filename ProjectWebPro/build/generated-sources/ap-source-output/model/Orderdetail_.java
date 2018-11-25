package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Orderlist;
import model.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-25T14:40:47")
@StaticMetamodel(Orderdetail.class)
public class Orderdetail_ { 

    public static volatile SingularAttribute<Orderdetail, Product> productcode;
    public static volatile SingularAttribute<Orderdetail, Integer> quantity;
    public static volatile SingularAttribute<Orderdetail, Integer> ordernumber;
    public static volatile SingularAttribute<Orderdetail, Orderlist> orderlist;

}