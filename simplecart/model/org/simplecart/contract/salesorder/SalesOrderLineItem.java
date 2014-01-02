package org.simplecart.contract.salesorder;

import org.simplecart.base.Persistent;
import org.simplecart.contract.LineItem;
import org.simplecart.shopcart.catalog.ProductOption;

/**
 * An Internet LineItem does not maintain a reference to the SalesOrder that
 * owns it. This is intented to increase performance for web-based uses.
 */
public class SalesOrderLineItem  implements LineItem, Persistent {
    
    private Long id;
    private float quantity;
    private float unitPrice;
    private ProductOption option;
    private String comment;
    
    /**
     * Default no args constructor
     */
    public SalesOrderLineItem() {
    }
    
    /**
     * Full constructor
     *
     * @param quantity
     * @param unitCost
     * @param option
     */
    public SalesOrderLineItem(
            float quantity,
            float unitPrice,
            String comment,
            ProductOption option) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.setComment(comment);
        this.option = option;
    }
    
    public Long getId() {
        return id;
    }
    
    public float getQuantity() {
        return quantity;
    }
    
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    
    public float getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(float unitCost) {
        this.unitPrice = unitCost;
    }
    
    public ProductOption getOption() {
        return option;
    }
    
    public void setOption(ProductOption option) {
        this.option = option;
    }
    
    public float getLineItemTotalCost() {
        return (this.unitPrice*this.quantity);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}