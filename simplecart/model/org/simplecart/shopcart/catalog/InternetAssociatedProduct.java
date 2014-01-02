/*
 * @(#)InternetAssociatedProduct.java $LastChangedRevision: 74 $ $LastChangedDate: 2005-04-10 03:15:30 +0900 (일, 10 4월 2005) $
 * Created on Apr 5, 2005
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
package org.simplecart.shopcart.catalog;

import org.apache.log4j.Category;

/**
 * @version		$LastChangedRevision: 74 $ $LastChangedDate: 2005-04-10 03:15:30 +0900 (일, 10 4월 2005) $
 * @author 		Daniel Watrous
 * 
 */
public class InternetAssociatedProduct extends InternetAssociation {
	
    private ProductCategory productCategory;
    private Product product;
    private static Category cat = Category.getInstance(InternetAssociatedProduct.class.getName());
    
    /**
     * No-arg constructor for JavaBean tools
     */
	InternetAssociatedProduct() {}
    
	/**
	 * Full constructor;
	 */
	public InternetAssociatedProduct(ProductCategory productCategory, Product product) {
	    this.productCategory = productCategory;
	    this.product = product;
	}
    
    // JavaBean style accessors/mutators
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public Product getProduct() {
        return product;
    }
    
    public boolean equals(Object obj) {
        cat.debug("Enter Equals method for InternetAssociatedProduct class.");
        if (this == obj) return true;
        InternetAssociatedProduct checkObj = (InternetAssociatedProduct) obj;
        cat.debug("Product in this: " + this.getProduct().getName());
        cat.debug("Product in checkObj: " + checkObj.getProduct().getName());
        cat.debug("ProductCategory in this: " + this.getProductCategory().getName());
        cat.debug("ProductCategory in checkObj: " + checkObj.getProductCategory().getName());
        if (this.product == checkObj.getProduct() && this.productCategory == checkObj.getProductCategory()) return true;
        return false;
    }
}
