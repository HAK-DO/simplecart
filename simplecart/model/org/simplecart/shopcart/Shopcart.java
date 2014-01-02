/*
 * Shopcart.java
 *
 * Created on February 23, 2005, 10:28 AM
 */

package org.simplecart.shopcart;

import java.util.List;

/**
 *
 * @author Daniel Watrous
 */
public interface Shopcart {
    public int addItem (ShopcartItem item);
    public void removeItem (int itemIndex);
    public List getItems ();
    public int getNumberOfItems();
    public float getCartSubTotal();
    public String getCartSubTotalAsString();
    public float getShippingEstimatedCost();
    public String getShippingEstimatedCostAsString();
    public float getCartTotal();
    public String getCartTotalAsString();
}
