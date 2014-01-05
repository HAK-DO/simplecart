/*
 * @(#)InternetAssociation.java $LastChangedRevision: 64 $ $LastChangedDate: 2005-04-07 09:24:13 +0900 (목, 07 4 2005) $
 * Created on Apr 6, 2005
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

import java.util.Date;
import org.simplecart.base.Persistent;

/**
 * @version		$LastChangedRevision: 64 $ $LastChangedDate: 2005-04-07 09:24:13 +0900 (목, 07 4 2005) $
 * @author 		Daniel Watrous
 * 
 */
public abstract class InternetAssociation implements CatalogItemAssociation, Persistent {
    private Long id;
    
    private Date dateAssociated = new Date();
    private boolean primaryAssociation;
    
    // JavaBean style accessors/mutators
    public Long getId() {
        return id;
    }
    public Date getDateAssociated() {
        return dateAssociated;
    }
    
    public boolean isPrimaryAssociation() {
        return primaryAssociation;
    }
    
    public void setPrimaryAssociation(boolean primaryAssociation) {
        this.primaryAssociation = primaryAssociation;
    }
    

}
