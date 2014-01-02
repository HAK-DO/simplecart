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
package org.simplecart.dao;

import net.sf.hibernate.HibernateException;

import org.simplecart.account.billing.InternetBillingDetails;

/**
 * @version     $LastChangedRevision$ $LastChangedDate$
 * @author      Daniel Watrous
 */

public class InternetBillingDetailsDAO extends BaseDAO {

    /** Creates a new instance of AdministratorDAO */
    public InternetBillingDetailsDAO() {
        super();
        DAOClassType = InternetBillingDetails.class;
    }
    
    /**
     * @return
     * @param id
     * @param lock
     */
    public InternetBillingDetails findById(Long id, boolean lock) throws HibernateException {
        InternetBillingDetails billingDetails = null;
        
        billingDetails = (InternetBillingDetails) abstractFindById(id, lock);
        return billingDetails;
    }

}
