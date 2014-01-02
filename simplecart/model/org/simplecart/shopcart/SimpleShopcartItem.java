/*
 * ShopcartItem.java
 *
 * Created on February 23, 2005, 10:39 AM
 */

package org.simplecart.shopcart;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author Daniel Watrous
 */
public class SimpleShopcartItem implements Serializable, ShopcartItem {
    
    private Long optionId;
    private float amount;
    private String name;
    private String description;
    private float price;
    private String comment;
    private static NumberFormat nf = NumberFormat.getCurrencyInstance ();
    
    /** Creates a new instance of ShopcartItem */
    public SimpleShopcartItem(
            Long optionId, 
            float amount,
            String name,
            String description,
            String comment,
            float price) {
        this.optionId = optionId;
        this.amount = amount;
        this.name = name;
        this.description = description;
        this.price = price;
        this.comment = comment;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public boolean equals (Object obj) {
        if (!(obj instanceof SimpleShopcartItem)) return false;
        SimpleShopcartItem testItem = (SimpleShopcartItem) obj;
        if (!testItem.getOptionId().equals(this.getOptionId())) return false;
        return true;
    }
    
    public int hashCode() {
        return this.getOptionId().intValue();
    }
    
    public float getLineItemTotal () {
        return this.amount*this.price;
    }
    
    public String getLineItemTotalAsString () {
        return nf.format(getLineItemTotal ());
    }
    
    public String getCost() {
        return "" + nf.format(this.price);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
