/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author James
 */
public class Cart implements Serializable {

    private Map<String, ItemsInCart> cart;

    public Cart() {
        cart = new HashMap();
    }

    public void add(Product p) {
        ItemsInCart items = cart.get(p.getProductcode());
        if (items == null) {
            cart.put(p.getProductcode(), new ItemsInCart(p));
        } else {
            items.setQuantity(items.getQuantity() + 1);
        }
    }

    public void remove(Product p) {
    ItemsInCart items = cart.get(p.getProductcode());
    items.setQuantity(items.getQuantity() - 1);
        if (items.getQuantity() == 0) {
            this.remove(p.getProductcode());
        }
        
        
    }

    public void remove(String productCode) {
        
        cart.remove(productCode);

    }

    public int getTotalPrice() {
        int sum = 0;
        Collection<ItemsInCart> itemInCarts = cart.values();
        for (ItemsInCart itemInCart : itemInCarts) {
            sum += itemInCart.getTotalPrice();
        }
        return sum;
    }

    public int getTotalQuantity() {
        int sum = 0;
        Collection<ItemsInCart> itemInCarts = cart.values();
        for (ItemsInCart itemInCart : itemInCarts) {
            sum += itemInCart.getQuantity();
        }
        return sum;
    }

    public List<ItemsInCart> getitemsInCart() {
        return new ArrayList(cart.values());
    }
}
