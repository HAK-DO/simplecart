/*
 * @(#)CheckOrMoneyOrderBillingDetails.java $LastChangedRevision$ $LastChangedDate$
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

/**
 * @version		$LastChangedRevision$ $LastChangedDate$
 * @author 		Daniel Watrous
 * 
 */
public class CheckOrMoneyOrderBillingDetails extends InternetBillingDetails {
    public boolean isValid() {
        return true;
    }
}
