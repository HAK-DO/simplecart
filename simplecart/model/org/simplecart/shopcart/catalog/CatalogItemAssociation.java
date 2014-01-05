/*
 * @(#)CatalogItemAssociation.java $LastChangedRevision: 59 $ $LastChangedDate: 2005-04-06 13:52:56 +0900 (수, 06 4 2005) $
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

import java.util.Date;

/**
 * @version		$LastChangedRevision: 59 $ $LastChangedDate: 2005-04-06 13:52:56 +0900 (수, 06 4 2005) $
 * @author 		Daniel Watrous
 * 
 */
public interface CatalogItemAssociation {
    public Date getDateAssociated();
    public boolean isPrimaryAssociation();
}
