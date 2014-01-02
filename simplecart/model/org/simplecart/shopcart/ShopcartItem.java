/*
 * @(#)ShopcartItem.java $LastChangedRevision: 118 $ $LastChangedDate: 2005-05-19 07:33:05 +0900 (목, 19 5월 2005) $
 * Created on Apr 27, 2005
 *
 * Copyright (c) 2005, Daniel Watrous
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or 
 * without modification, are governed by the license found in
 * the following places:
 * license.txt included with this distribution, or
 * http://www.simplecart.org/license.html
 * 
 */
package org.simplecart.shopcart;

/**
 * @version		$LastChangedRevision: 118 $ $LastChangedDate: 2005-05-19 07:33:05 +0900 (목, 19 5월 2005) $
 * @author 		Daniel Watrous
 * 
 */
public interface ShopcartItem {
    public Long getOptionId();
    public float getAmount();
    public String getDescription();
    public String getName();
    public float getPrice();
    public String getComment();

    /**
     * return the total as calculated by getPrice()*getAmount()
     * @return total
     */
    public float getLineItemTotal();
    public String getLineItemTotalAsString();
}
