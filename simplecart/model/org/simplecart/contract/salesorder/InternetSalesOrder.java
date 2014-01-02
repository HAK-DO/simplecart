package org.simplecart.contract.salesorder;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.simplecart.account.Customer;
import org.simplecart.base.Address;
import org.simplecart.base.Persistent;
import org.simplecart.contract.LineItem;
import org.simplecart.contract.payment.InternetPayment;

/**
 * <p>
 * </p>
 *
 */
public class InternetSalesOrder implements SalesOrder, Persistent {
    
    private Long id;
    private String notes;
    private Collection lineItems = new HashSet();
    private Date placedOn;
    private Customer customer;
    private Address address;
    private Collection payments = new HashSet();
    private static final float SALES_TAX_RATE = (float) 0.066;
    private static NumberFormat nf = NumberFormat.getCurrencyInstance ();

    /**
     * Default no args constructor
     */
    public InternetSalesOrder() {
    }
    
    /**
     * Partial constructor
     */
    public InternetSalesOrder(
            Customer customer,
            Address address) {
        this.placedOn = new Date();
        this.customer = customer;
        // also create association from customer to this order
        customer.addOrder(this);
        this.address = address;
    }
    
    public Long getId() {
        return id;
    }
    
    public Date getPlacedOn() {
        return placedOn;
    }
    
    public void setPlacedOn(Date placedOn) {
        this.placedOn = placedOn;
    }
    
    public Date getEffectiveDate() {
        return null;
    }
    
    public String getNotes() {
        
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Collection getLineItems() {
        return lineItems;
    }
    
    public void setLineItems(Collection lineItems) {
        this.lineItems = lineItems;
    }
    
    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }
    
    public Address getAddress() {
        
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public float getSalesOrderSubTotal() {
        float salesOrderTotal = 0;
        Iterator lineItemIterator = lineItems.iterator();
        while (lineItemIterator.hasNext()) {
            salesOrderTotal += ((LineItem) lineItemIterator.next()).getLineItemTotalCost();
        }
        return salesOrderTotal;
    }

    public String getSalesOrderSubTotalAsString() {
        return nf.format(getSalesOrderSubTotal());
    }

    public float getSalesOrderTax() {
        if (
                (getAddress().getState().toLowerCase().indexOf("utah") != -1) ||
                (getAddress().getState().toLowerCase().indexOf("ut") != -1))
        {
            return getSalesOrderSubTotal()*SALES_TAX_RATE;
        } else return (float) 0.00;
    }
    
    public String getSalesOrderTaxAsString() {
        return nf.format(getSalesOrderTax());
    }

    public float getShippingCost() {
        float shipping = (float) 0.00;
        SalesOrderLineItem currentItem;
        Iterator items = getLineItems().iterator();
        boolean first = false;
        while (items.hasNext()) {
            currentItem = (SalesOrderLineItem) items.next();
            for (int i=0; i<currentItem.getQuantity(); i++) {
                shipping += (first) ? 0.50:3.50;
                if (!first) first=true;
            }
        }
        return shipping;
    }
    
    public String getShippingCostAsString() {
        return nf.format(getShippingCost());
    }

    public float getSalesOrderTotal() {
        float salesOrderTotal = 0;
        salesOrderTotal += getSalesOrderSubTotal();
        salesOrderTotal += getShippingCost();
        salesOrderTotal += getSalesOrderTax();

        return salesOrderTotal;
    }

    public String getSalesOrderTotalAsString() {
        return nf.format(getSalesOrderTotal());
    }

    public Collection getPayments() {
        return payments;
    }

    public void setPayments(Collection payments) {
        this.payments = payments;
    }
    
    public void addPayment(InternetPayment payment) {
        this.payments.add(payment);
    }
    
}