package org.simplecart.contract.salesorder;

import java.util.Collection;

import org.simplecart.account.Customer;
import org.simplecart.contract.Contract;

/**
 * A SalesOrder is a particular type of Contract and represents a purchase by a
 * Customer.
 */
public interface SalesOrder extends Contract {
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public Collection getLineItems();
    public Collection getPayments();
	public float getSalesOrderSubTotal();
	public String getSalesOrderSubTotalAsString();
	public float getSalesOrderTotal();
	public String getSalesOrderTotalAsString();
    public float getSalesOrderTax();
    public String getSalesOrderTaxAsString();
    public float getShippingCost();
    public String getShippingCostAsString();
}