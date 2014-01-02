
package org.simplecart.base;



/**
 * <p>Basic address class that will be associated with
 * each class that stores an address</p>
 * 
 */
public class Address implements Persistent {

    private Long id;
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String state;
    private String postalCode;

	/**
	 * Default no args constructor
	 */
    public Address() {        
    } 

    public Long getId() {
        return id;
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
 }
