/*
 * @(#)InternetProduct.java $LastChangedRevision: 64 $ $LastChangedDate: 2005-04-07 09:24:13 +0900 (목, 07 4 2005) $
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

/**
 * @version     $LastChangedRevision: 64 $ $LastChangedDate: 2005-04-07 09:24:13 +0900 (목, 07 4 2005) $
 * @author      Daniel Watrous
 */

public class InternetAssociatedOption extends InternetAssociation {
    
    private Product product;
    private ProductOption productOption;
    
    /**
     * No-arg constructor for JavaBean tools
     */
    InternetAssociatedOption() {}
    
    /**
     * Full constructor;
     */
    public InternetAssociatedOption(Product product, ProductOption productOption) {
        this.product = product;
        this.productOption = productOption;
    }
    
    // JavaBean style accessors/mutators
    public ProductOption getProductOption() {
        return productOption;
    }

    public Product getProduct() {
        return product;
    }

}
