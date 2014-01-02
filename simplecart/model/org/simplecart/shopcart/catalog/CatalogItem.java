/*
 * @(#)CatalogItem.java $LastChangedRevision: 67 $ $LastChangedDate: 2005-04-07 13:15:22 +0900 (목, 07 4월 2005) $
 * Created on March 23, 2005
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

import org.simplecart.base.Persistent;

/**
 * 
 * @version     $LastChangedRevision: 67 $ $LastChangedDate: 2005-04-07 13:15:22 +0900 (목, 07 4월 2005) $
 * @author      Daniel Watrous
 *
 */
public interface CatalogItem extends Persistent {
    /**
     * tell whether the implementing CatalogItem can
     * be displayed to end consumers
     * @return boolean true if consumer visible
     */
    public boolean isConsumerVisible();
    public String getName();
    public void setName(String name);
    public String getDescription();
    public void setDescription(String description);
    public SearchUtility getSearchDetails();
}
