package org.simplecart.shopcart;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleShopcart implements Shopcart, Serializable {
    
    private List items = new LinkedList();
    private static NumberFormat nf = NumberFormat.getCurrencyInstance ();

    public void Shopcart() {
        // your code here
    }

    /**
     * @param item
     */
    public int addItem(ShopcartItem item) {
        if (!this.items.contains(item)) {
            this.items.add(item);
            return items.size() - 1;
        } else {
            return this.getItemIndex(item);
        }
    }

    public int getItemIndex(ShopcartItem item) {
        return items.indexOf(item);
    }

    /**
     * 
     * @param itemIndex
     */
    public void removeItem(int itemIndex) {
        if (itemIndex < 0)
            return;
        if (items.size() <= itemIndex)
            return;
        ShopcartItem item = (ShopcartItem) items.remove(itemIndex);
    }

    public List getItems() {
        return this.items;
    }
    
    public int getNumberOfItems() {
        int numItems = 0;
        Iterator cartItems = getItems().iterator();
        while (cartItems.hasNext()) {
            numItems += ((ShopcartItem) cartItems.next()).getAmount();
        }
        return numItems;
    }

    public float getCartSubTotal() {
        float subTotal = 0;
        ShopcartItem currentItem;
        Iterator cartItems = getItems().iterator();
        while (cartItems.hasNext()) {
            currentItem = (ShopcartItem) cartItems.next();
            subTotal = subTotal + (currentItem.getPrice()*currentItem.getAmount());
        }
        return subTotal;
    }
    
    public String getCartSubTotalAsString() {
        return nf.format(getCartSubTotal());
    }
    
    public float getShippingEstimatedCost() {
        float shipping = (float) 0.00;
        ShopcartItem currentItem;
        Iterator items = getItems().iterator();
        boolean first = false;
        while (items.hasNext()) {
            currentItem = (ShopcartItem) items.next();
            for (int i=0; i<currentItem.getAmount(); i++) {
                shipping += (first) ? 0.50:3.50;
                if (!first) first=true;
            }
        }
        return shipping;
    }

    public String getShippingEstimatedCostAsString() {
        return nf.format(getShippingEstimatedCost());
    }

    public float getCartTotal() {
        return getCartSubTotal()+getShippingEstimatedCost();
    }
    
    public String getCartTotalAsString() {
        return nf.format(getCartTotal());
    }
    
}
