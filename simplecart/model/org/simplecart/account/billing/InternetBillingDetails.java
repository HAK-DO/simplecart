/*
 * @(#)InternetProduct.java $LastChangedRevision$ $LastChangedDate$
 * Created on Apr 28, 2005
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
package org.simplecart.account.billing;

import java.util.Date;

import org.simplecart.account.Customer;
/**
 * @version     $LastChangedRevision$ $LastChangedDate$
 * @author      Daniel Watrous
 */

public abstract class InternetBillingDetails implements BillingDetails {
    
    private Long id;
    private Date dateCreated;
    private Customer customer;
    
    public Customer getCustomer() {
        return customer;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Long getId() {
        return id;
    }

    // business methods implemented

    public abstract boolean isValid();
    
}
