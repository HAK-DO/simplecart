/*
 * @(#)ProductOption.java $LastChangedRevision: 63 $ $LastChangedDate: 2005-04-07 09:09:37 +0900 (목, 07 4월 2005) $
 * Created on April 1, 2005
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
package org.simplecart.shopcart.catalog;

/**
 * ProductOption represents a Stock Keeping Unit (SKU) when
 * considering inventory.  This typically represents a size, 
 * length or weight.  A ProductOption is responsible for its
 * price and associated Products.
 * 
 * @version     $LastChangedRevision: 63 $ $LastChangedDate: 2005-04-07 09:09:37 +0900 (목, 07 4월 2005) $
 * @author      Daniel Watrous
 *
 */
public interface ProductOption extends CatalogItem {

	/**
     * return all associated Product(s)
     * @return Product[]
	 */
    public Product[] getProductsArray ();

    /**
     * return all consumer visible associated Product(s)
     * @return Product[]
     */
    public Product[] getConsumerVisibleProducts ();

    /**
     * associate will link the Product passed in 
     * as a parameter with this ProductCategory. 
     * @param Product product
     */
    //public void associate (Product product); 
    
    /**
     * if the product passed in as a parameter is contained
     * in the set of Product(s) associated with this
     * ProductCategory it will be dissociated from it.
     * @param Product product
     */
    //public void dissociate (Product product);
    
    /**
     * return the weight of one unit in ounces
     * @return float
     */
    public float getUnitWeightInOunces();
	
    /**
     * return the Actual (Sale) Price
     * @return float
     */
    public float getUnitPriceActualRetail();
	
    /**
     * return the Manufacturer's Suggested Retail Price
     * @return float
     */
    public float getUnitPriceManufacturerSuggestedRetail();
    
    /**
     * return the inventory Stock Keeping Unit (SKU)
     * relating to this ProductOption.  This value is 
     * unique to the merchant, and not necessarily 
     * related to the supplier.
     * @return String
     */
	public String getStockKeepingUnitIdentifier();
	
    /**
     * return the selling price.  This will most often be
     * Actual Retail Price.
     * @return float
     */
    public float getSellingPrice ();
	
    /**
     * return the Quantity Available For Sale.
     * @return float
     */
    public float getQuantityAvailableForSale ();
    
    /**
     * return the Time required to fulfill orders
     * including this ProductOption
     * @return
     */
	public int getFulfillmentTimeInDays ();
}
