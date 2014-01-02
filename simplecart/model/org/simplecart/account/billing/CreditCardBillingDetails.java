/*
 * @(#)CreditCardBillingDetails.java $LastChangedRevision$ $LastChangedDate$
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
public class CreditCardBillingDetails extends InternetBillingDetails {
	private CreditCardType creditCardType;
	private String creditCardNumber;
	private String creditCardExpirationMonth;
	private String creditCardExpirationYear;
        private String creditCardCVVSCode;
    
    public String getCreditCardExpirationMonth() {
        return creditCardExpirationMonth;
    }
    public void setCreditCardExpirationMonth(String creditCardExpirationMonth) {
        this.creditCardExpirationMonth = creditCardExpirationMonth;
    }
    public String getCreditCardExpirationYear() {
        return creditCardExpirationYear;
    }
    public void setCreditCardExpirationYear(String creditCardExpirationYear) {
        this.creditCardExpirationYear = creditCardExpirationYear;
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    public CreditCardType getCreditCardType() {
        return creditCardType;
    }
    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }
    public String getCreditCardCVVSCode() {
        return creditCardCVVSCode;
    }
    public void setCreditCardCVVSCode(String creditCardCVVSCode) {
        this.creditCardCVVSCode = creditCardCVVSCode;
    }

    // implement business methods from inherited interface
    
    public boolean isValid() {
        return creditCardType.isValid(this);
    }
}
