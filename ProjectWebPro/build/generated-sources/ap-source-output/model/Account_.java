package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Card;
import model.Orderlist;
import model.Profile;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-28T11:49:58")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> activatecode;
    public static volatile ListAttribute<Account, Card> cardList;
    public static volatile SingularAttribute<Account, Integer> accountid;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, Date> activationdate;
    public static volatile ListAttribute<Account, Profile> profileList;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile ListAttribute<Account, Orderlist> orderlistList;

}