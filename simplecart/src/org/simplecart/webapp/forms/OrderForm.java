/*
 * OrderForm.java
 *
 * Created on February 21, 2005, 3:42 PM
 */

package org.simplecart.webapp.forms;

import java.util.Date;

import org.apache.struts.validator.ValidatorActionForm;

/**
 *
 * @author Daniel Watrous
 */
public class OrderForm extends ValidatorActionForm {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6183617403661667390L;

	/**
     * activity is used to tell DispatchAction which 
     * method to call on the Action(s).
     */
    private String activity;
    
    // identifier value for use with persistence
    private Long id;
    
    // begin base and inherited class values
    private Date placedOn;
    private boolean complete;
    private String notes;

    // begin associated class Address values
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String state;
    private String postalCode;    

    // credit card billing details
    private int creditCardType;
    private String creditCardNumber;
    private String creditCardExpirationMonth;
    private String creditCardExpirationYear;
    private String creditCardCVVSCode;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPlacedOn() {
        return placedOn;
    }

    public void setPlacedOn(Date placedOn) {
        this.placedOn = placedOn;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
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
    public int getCreditCardType() {
        return creditCardType;
    }
    public void setCreditCardType(int creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardCVVSCode() {
        return creditCardCVVSCode;
    }

    public void setCreditCardCVVSCode(String creditCardCVVSCode) {
        this.creditCardCVVSCode = creditCardCVVSCode;
    }
}
