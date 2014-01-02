/*
 * PartyForm.java
 *
 * Created on February 11, 2005, 4:09 PM
 */

package org.simplecart.webapp.forms;

import org.apache.struts.validator.ValidatorActionForm;

/**
 *
 * @author Daniel Watrous
 */
public class PartyForm extends ValidatorActionForm {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -5933031887951478553L;

	/**
     * activity is used to tell DispatchAction which 
     * method to call on the Action(s).
     */
    private String activity;
    
    /**
     * identifier value
     */
    private Long id;
    
    /**
     * begin base and inherited class values
     */
    private String nameFirst;
    private String nameLast;
    private String username;
    private String password;
    private String passwordConfirm;
    private String emailAddress;
    private String phone;
    private String companyName;

    /**
     * begin associated class Address values
     */
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String state;
    private String postalCode;    
    
    /** Creates a new instance of PartyForm */
    public PartyForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    
}
