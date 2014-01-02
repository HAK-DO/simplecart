package org.simplecart.account;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.simplecart.account.billing.BillingDetails;
import org.simplecart.contract.salesorder.SalesOrder;

/**
 * The Customer class.
 *
 * @hibernate.joined-subclass
 * 	table="CUSTOMER"
 * 	lazy="true"
 */
public class Customer extends org.simplecart.base.Party {
    
    private String phone;
    
    private String companyName;
    
    private Set orders = new HashSet();
    
    private Collection billingDetails = new HashSet();
    
    /**
     * Default no args constructor
     */
    public Customer() {
    }
    
    /**
     * Each Customer may have a collection of SalesOrders
     *
     * @hibernate.set
     * 	table="INTERNET_ORDER"
     * 	inverse="true"
     * @hibernate.collection-key
     * 	column="CUSTOMER_ID"
     * @hibernate.collection-one-to-many
     * 	class="org.simplecart.contract.salesorder.InternetSalesOrder"
     * @return java.util.Collection
     */
    public java.util.Collection getOrders() {
        return orders;
    }
    
    /**
     *
     * @param orders
     */
    public void setOrders(Set orders) {
        this.orders = orders;
    }
    
    /**
     * @hibernate.property
     * 	column="PHONE"
     * 	type="string"
     * 	length="25"
     * @return String
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * @hibernate.property
     * 	column="COMPANY_NAME"
     * 	type="string"
     * 	length="255"
     * @return String
     */
    public String getCompanyName() {
        return companyName;
    }
    
    /**
     *
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public void addOrder(SalesOrder order) {
        this.orders.add(order);
        order.setCustomer(this);
    }
    
    public void addBillingDetails(BillingDetails details) {
        this.getBillingDetails().add(details);
    }

    public Collection getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Collection billingDetails) {
        this.billingDetails = billingDetails;
    }
}