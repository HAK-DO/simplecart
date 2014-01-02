package org.simplecart.contract;

public interface LineItem {

	/**
	 * 
	 * Quantity refers to the number of units (units may be gallons, items,
	 * meters, etc.) of a particular InternetProduct InternetProductOption that correspond to this
	 * LineItem.
	 */
	public float getQuantity();

	/**
	 * 
	 * Unit Cost is the dollar cost per unit and is used to calculate the
	 * LineItem total.
	 */
	public float getUnitPrice ();

	/**
	 * 
	 * The Line Item total should return the total cost for a LineItem as
	 * calculated by the Quantity*UnitCost.
	 */
	public float getLineItemTotalCost();
}