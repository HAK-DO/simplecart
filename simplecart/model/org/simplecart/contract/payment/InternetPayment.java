/*
 * @(#)InternetPayment.java $LastChangedRevision$ $LastChangedDate$
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
package org.simplecart.contract.payment;

import java.util.Date;

/**
 * @version		$LastChangedRevision$ $LastChangedDate$
 * @author 		Daniel Watrous
 * 
 */
public class InternetPayment implements Payment {
    
    private Long id;
    private float paymentAmount;
    private String paymentMethod;
    private String creditCardType;
    private String creditCardNumber;
    private String creditCardCVVSCode;
    private String expirationDate;
    private Date paymentDate;

    public Long getId () {
        return this.id;
    }
    /* (non-Javadoc)
     * @see org.simplecart.contract.payment.Payment#getPaymentTotalAmount()
     */
    public float getPaymentTotalAmount() {
        return this.paymentAmount;
    }

    /* (non-Javadoc)
     * @see org.simplecart.contract.payment.Payment#getPaymentMethod()
     */
    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    /* (non-Javadoc)
     * @see org.simplecart.contract.payment.Payment#getPaymentDate()
     */
    public Date getPaymentDate() {
        return this.paymentDate;
    }

    /* (non-Javadoc)
     * @see org.simplecart.contract.Contract#getEffectiveDate()
     */
    public Date getEffectiveDate() {
        return null;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    public String getCreditCardType() {
        return creditCardType;
    }
    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public float getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCreditCardCVVSCode() {
        return creditCardCVVSCode;
    }

    public void setCreditCardCVVSCode(String creditCardCVVSCode) {
        this.creditCardCVVSCode = creditCardCVVSCode;
    }
}
